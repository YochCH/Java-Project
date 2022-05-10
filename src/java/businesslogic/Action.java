/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import clinic.*;
import users.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Clock;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "Action", urlPatterns = {"/Action"})
public class Action extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String ADD_PATIENT = "addPatient";
    private static final String ADD_TREATMENT = "addTreatment";
    private static final String SET_TREATMENT = "setTreatment";
    private static final String CREATE_REPORT = "createReport";

    Clinic clinic = Clinic.getClinic();

    User user;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Action</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Action at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
        } catch (Exception e) {
            e.getMessage();
        }

        //get action from URL
        String action = request.getParameter("action");

        //get user from context
        user = (User) request.getServletContext().getAttribute("user");
        String responseMessage = "";
        //call to match method
        switch (action) {
            case ADD_PATIENT:
                String PatientName = request.getParameter("addName");
                String PatientPassword = request.getParameter("addPassword");
               ((Doctor)user).addPatient((Patient) clinic.addUser(PatientPassword, PatientName, PermissionEnum.PATIENT));
                responseMessage = "The patient be added successfully" ;
                System.out.println("Action:ADD_PATIENT Patient successfully added PatientName:" + PatientName);

                break;
            
            case ADD_TREATMENT:
                Date addDate = new Date(request.getParameter("addDate"));
                int addToothNumber = Integer.parseInt(request.getParameter("addToothNumber"));
                TreatmentTypeEnum addTreatmentType = TreatmentTypeEnum.valueOf(request.getParameter("addTreatmentType"));
                int addPrice = Integer.parseInt(request.getParameter("addPrice"));
                boolean addPaid;
                String s = request.getParameter("addPaid");
                if ("on".equals(s)) {
                    addPaid = true;
                } else {
                    addPaid = false;
                }

                String addPatientId = request.getParameter("addPatientId");
                try {
                    Patient patient= ((Doctor) user).getPatients().get(addPatientId);
                    Treatment t = new Treatment(addDate, addTreatmentType, addToothNumber, addPrice, addPaid);
                    patient.addTreatment(t);
                    responseMessage = "The treatment be added successfully" ;
                    System.out.println("Action:ADD_TREATMENT Treatment successfully added TreatmentId:" + t.getId());
                } catch (Exception ex) {
                    Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
                    response.getWriter().write(ex.getMessage());
                    responseMessage = "The treatment adding was failed" ;
                    System.out.println("Action:ADD_TREATMENT The treatment adding was failed PatientId:" + addPatientId);
                }
                break;
            case SET_TREATMENT:
                int id = Integer.parseInt(request.getParameter("id"));
                Date setDate = new Date(request.getParameter("setDate"));
                int setToothNumber = Integer.parseInt(request.getParameter("setToothNumber"));
                TreatmentTypeEnum setTreatmentType = TreatmentTypeEnum.valueOf(request.getParameter("setTreatmentType"));
                int setPrice = Integer.parseInt(request.getParameter("setPrice"));
                boolean setPaid;
                String sp = request.getParameter("setPaid");
                if ("on".equals(sp)) {
                    setPaid = true;
                } else {
                    setPaid = false;
                }
                
                Patient patient= ((Doctor) user).getPatients().get(id);
                patient.setTreatment(id,setDate, setTreatmentType, setToothNumber, setPrice, setPaid);
                responseMessage = "The treatment be changed successfully" ;
                System.out.println("Action:SET_TREATMENT Treatment successfully changed TreatmentId:" + id);
                break;
            case CREATE_REPORT:

                user.createReport();
                responseMessage = "Reoport download Successfully" ;
                System.out.println("Action:CREATE_REPORT Reoport download Successfully userId:" + user.getName());
                break;
           
        }
        //return message to user
        response.getWriter().write(responseMessage);
        String url = "/WelcomePatient.jsp";
        if (user.getPermission() == PermissionEnum.DOCTOR) {
            url = "/WelcomeDoctor.jsp";
        }
        request.getServletContext().getRequestDispatcher(url).include(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
