/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.util.Date;

/**
 *
 * @author pc
 */
public class SaoLuu {
    private String maSaoLuu, tenSaoLuu;
    private Date ngayTao;
    private DanhBa db;

    /**
     * @return the maSaoLuu
     */
    public String getMaSaoLuu() {
        return maSaoLuu;
    }

    /**
     * @param maSaoLuu the maSaoLuu to set
     */
    public void setMaSaoLuu(String maSaoLuu) {
        this.maSaoLuu = maSaoLuu;
    }

    /**
     * @return the tenSaoLuu
     */
    public String getTenSaoLuu() {
        return tenSaoLuu;
    }

    /**
     * @param tenSaoLuu the tenSaoLuu to set
     */
    public void setTenSaoLuu(String tenSaoLuu) {
        this.tenSaoLuu = tenSaoLuu;
    }

    /**
     * @return the ngayTao
     */
    public Date getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao the ngayTao to set
     */
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    /**
     * @return the db
     */
    public DanhBa getDb() {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(DanhBa db) {
        this.db = db;
    }

    public SaoLuu() {
    }

    public SaoLuu(String maSaoLuu, String tenSaoLuu, Date ngayTao) {
        this.maSaoLuu = maSaoLuu;
        this.tenSaoLuu = tenSaoLuu;
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return this.tenSaoLuu; //To change body of generated methods, choose Tools | Templates.
    }
}
