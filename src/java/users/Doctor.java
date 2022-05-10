/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.*;
import java.time.Clock;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huser
 */
public class Doctor extends User{
    private Map<String,Patient> patients;

    Doctor() {
        patients=new HashMap<String,Patient>();
    }

    public Map<String, Patient> getPatients() {
        return patients;
    }

    public void setPatients(Map<String, Patient> patients) {
        this.patients = patients;
    }
    
    @Override
    public void createReport(){
        String path="C:\\Users\\user\\Downloads\\doctor report.txt";
//        try {
//
//            FileOutputStream fileOut = new FileOutputStream(path);
//            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
//            for(Patient p : patients.values()){
//               objectOut.writeObject(p);
//
//            }
//            objectOut.close();
//            System.out.println("The Object  was succesfully written to a file");
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        ObjectOutputStream oos;
        try {
		BufferedWriter bw= new BufferedWriter(new FileWriter(path));
        
		
		
		for(Patient p : patients.values()) {
			
			
			bw.write(p+"\n");
			
		}
		
		bw.close();
        } catch (IOException ex) {
            System.out.print("fall!!!!!!!!!!!!");
        }
        
    }
    public void addPatient(Patient p){
        if(this.patients!=null){
            this.patients.put(p.getName(), p);
        }
    }
    
    
    
}
