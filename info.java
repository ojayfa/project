/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeassociationregistrationsystem2;

/**
 *
 * @author DELL
 */
public class info {
    private String  name, address, icno, plotno;
    final private String housetype;

    info(String housetype, String name, String address, String icno, String plotno) {
        this.housetype= housetype; 
        this.name= name;
        this.address= address;
        this.icno= icno;
        this.plotno = plotno;
    }

    void setname(String name) {
        this.name = name;
    }

    void setaddress(String address) {
        this.address = address;
    }
    
    void seticno(String icno) {
        this.icno = icno;
    }
    
    void setplotno(String plotno) {
        this.plotno= plotno;
    }

    String gethousetype() {
        return housetype;
    }

    String getname() {
        return name;
    }

    String getaddress() {
        return address;

    }
    
     String geticno() {
        return icno;

    }
     
      String getplotno() {
        return plotno;

    }  
}
