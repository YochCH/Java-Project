/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import clinic.NotPaidException;
import clinic.Treatment;
import clinic.TreatmentTypeEnum;
import java.io.*;
import java.util.*;

/**
 *
 * @author huser
 */
public class Patient extends User{
    private int id;
    private static int count=0;
    private List<Treatment> treatments;

    Patient() {
        this.treatments=new LinkedList<Treatment>();
        id=count++;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Patient.count = count;
    }
    public void addTreatment(Treatment treatment) throws NotPaidException {
        int count = 0;
        for (Treatment t : treatments) {
            if (!t.isPayed()) {
                count++;
            }
            if (count == 2) {
                throw new NotPaidException();
            }
        }

        treatments.add(treatment);
    }

    public void setTreatment(int id, Date date, TreatmentTypeEnum treatmentType, int toothNum, int price, boolean isPayed) {
        for (Treatment t : treatments) {
            if (t.getId()== id) {
                t.setDate(date);
                t.setIsPayed(isPayed);
                t.setPrice(price);
                t.setToothNum(toothNum);
                t.setTreatmentType(treatmentType);
            }
        }
    }
    
    @Override
    public void createReport(){
        String path="C:\\Users\\user\\Downloads\\"+super.getName()+"Report.txt";
        ObjectOutputStream oos;
        try {
		BufferedWriter bw= new BufferedWriter(new FileWriter(path));
        
		
		treatments.add(new Treatment(new Date(), TreatmentTypeEnum.FILLING, 2, 100, true));
                
		for(Treatment t : treatments) {
			
			
			bw.write(t+"\n");
			
		}
		
		bw.close();
        } catch (IOException ex) {
            System.out.print("fall!!!!!!!!!!!!");
        }
        
    }
    
    public static void main(String args[]) {
 
        Patient p = new Patient();
        p.setName("shalom");
        p.setPassword("123456");
        p.createReport();
    }
    @Override
    public String toString() {
        return "id:" + id+" "+super.toString() ;
    }
    
    
    
    
    
    
    
}
