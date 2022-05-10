/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.util.Date;


public class Treatment {
   private Date date;
   private TreatmentTypeEnum treatmentType;
   private int toothNum;
   private int price;
   private boolean isPayed;
   private int id;
   private static int count = 0;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TreatmentTypeEnum getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentTypeEnum treatmentType) {
        this.treatmentType = treatmentType;
    }

    public int getToothNum() {
        return toothNum;
    }

    public void setToothNum(int toothNum) {
        this.toothNum = toothNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Treatment(Date date, TreatmentTypeEnum treatmentType, int toothNum, int price, boolean isPayed) {
        this.date = date;
        this.treatmentType = treatmentType;
        this.toothNum = toothNum;
        this.price = price;
        this.isPayed = isPayed;
        this.id = count++;
    }

    @Override
    public String toString() {
        return "Treatment{" + "date=" + date + ", treatmentType=" + treatmentType + ", toothNum=" + toothNum + ", price=" + price + ", isPayed=" + isPayed + '}';
    }
   
   
   
}
