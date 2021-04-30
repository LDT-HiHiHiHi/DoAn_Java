/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.util.Vector;

/**
 *
 * @author pc
 */
public class NhomLienHe {
    private String msNhom, tenNhom;
    private Vector<DanhBa> dsNhom = new Vector<DanhBa>();

    /**
     * @return the msNhom
     */
    public String getMsNhom() {
        return msNhom;
    }

    /**
     * @param msNhom the msNhom to set
     */
    public void setMsNhom(String msNhom) {
        this.msNhom = msNhom;
    }

    /**
     * @return the tenNhom
     */
    public String getTenNhom() {
        return tenNhom;
    }

    /**
     * @param tenNhom the tenNhom to set
     */
    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    /**
     * @return the dsNhom
     */
    public Vector<DanhBa> getDsNhom() {
        return dsNhom;
    }

    /**
     * @param dsNhom the dsNhom to set
     */
    public void setDsNhom(Vector<DanhBa> dsNhom) {
        this.dsNhom = dsNhom;
    }

    public NhomLienHe() {
    }

    public NhomLienHe(String msNhom, String tenNhom) {
        this.msNhom = msNhom;
        this.tenNhom = tenNhom;
    }

    @Override
    public String toString() {
        return this.tenNhom; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void themNhom(DanhBa db){
        dsNhom.add(db);
        db.setNlh(this);
    }
}
