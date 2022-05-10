/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless
public class ClinicNameSession {
    
    public  final String clinicName="Dental Health";
    public String getClinicName() {
        return clinicName;
    }
}
