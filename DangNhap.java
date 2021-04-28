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
public class DangNhap {
    private String maNDN, tenDN, pwd;
    private Vector<NguoiDung> dsnd = new Vector<NguoiDung>();
    private Vector<DanhBa> dsdb = new Vector<DanhBa>();
    /**
     * @return the maNDN
     */
    public String getMaNDN() {
        return maNDN;
    }

    /**
     * @param maNDN the maNDN to set
     */
    public void setMaNDN(String maNDN) {
        this.maNDN = maNDN;
    }

    /**
     * @return the tenDN
     */
    public String getTenDN() {
        return tenDN;
    }

    /**
     * @param tenDN the tenDN to set
     */
    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the dsnd
     */
    public Vector<NguoiDung> getDsnd() {
        return dsnd;
    }

    /**
     * @param dsnd the dsnd to set
     */
    public void setDsnd(Vector<NguoiDung> dsnd) {
        this.dsnd = dsnd;
    }
    
    /**
     * @return the dsdb
     */
    public Vector<DanhBa> getDsdb() {
        return dsdb;
    }

    /**
     * @param dsdb the dsdb to set
     */
    public void setDsdb(Vector<DanhBa> dsdb) {
        this.dsdb = dsdb;
    }
    
    public DangNhap() {
    }

    public DangNhap(String maNDN, String tenDN, String pwd) {
        this.maNDN = maNDN;
        this.tenDN = tenDN;
        this.pwd = pwd;
    }

    //@Override
    //public String toString() {
        //return ; //To change body of generated methods, choose Tools | Templates.
    //}
    
    public void themNguoiDung(NguoiDung nd){
        dsnd.add(nd);
        nd.setDn(this);
    }
    public void themDanhBa(DanhBa db){
        dsdb.add(db);
        db.setDn(this);
        
    }
}
