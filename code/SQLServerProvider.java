/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import javafx.animation.KeyValue;

/**
 *
 * @author Admin
 */
public class SQLServerProvider {
    private Connection conn;
    private CallableStatement callableStatement;
    private ResultSet resSet;
    private Statement statement;
    
    public void open() {
        String strServer = "MSI-PC";
        String strDatabase = "QLDB";
        String uid = "sa";
        String pwd = "sa123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://" +  strServer
                                 + ":1433;databaseName="+ strDatabase
                                 + ";user = "           + uid
                                 + ";password = "       + pwd;
            conn = DriverManager.getConnection(connectionURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean isDangNhap(String uid, String pwd) {
        int a =1;
        String procCkDN = "{? = call CKDANGNHAP(?, ?)}";
        String updateTT = "UPDATE DANGNHAP SET TRANGTHAI='CONNECT' WHERE TENDANGNHAP='" + uid +"'";
        try {
            callableStatement = conn.prepareCall(procCkDN);
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setString(2, uid);            
            callableStatement.setString(3, pwd);
            callableStatement.execute();
            a = callableStatement.getInt(1);
            if(a==1)
                executeUpdate(updateTT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a==1?true:false;
    }
    public boolean isUId(String uid) { // kiểm tra xem có uid đó hay chưa
        int a =1;
        String procCkDN = "{? = call CKUID(?)}";
        try {
            callableStatement = conn.prepareCall(procCkDN);
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setString(2, uid);
            callableStatement.execute();
            a = callableStatement.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a==1?true:false;
    }
    public boolean isNhomLienHe(String maNDN, String tenNhom) { // kiểm tra xem có uid đó hay chưa
        int a =1;
        String procCkDN = "{? = call CKNLH(?, ?)}";
        try {
            callableStatement = conn.prepareCall(procCkDN);
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setString(2, maNDN);
            callableStatement.setString(3, tenNhom);
            callableStatement.execute();
            a = callableStatement.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a==1?true:false;
    }
    public boolean isSDT(String mandn, String sdt) { // kiểm tra xem danh bạ đó có trong id đó hay chưa
        int a =1;
        String procCkDN = "{? = call CKDB(?, ?)}";
        try {
            callableStatement = conn.prepareCall(procCkDN);
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setString(2, mandn);
            callableStatement.setString(3, sdt);
            callableStatement.execute();
            a = callableStatement.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a==1?true:false;
    }
    public String getMaNDNOnl() {
        String funcGetMaNDN = "{? = call GETMANDNONL() }";
        String maNDN = null;
        try {
            callableStatement = conn.prepareCall(funcGetMaNDN);
            callableStatement.registerOutParameter(1, Types.CHAR);
            callableStatement.execute();
            maNDN = callableStatement.getString(1);
//            System.out.println(maNDN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maNDN;
    }
    public String getMaNDN(String uid) {
        String funcGetMaNDN = "{? = call GETMANDN(?) }";
        String maNDN = null;
        try {
            callableStatement = conn.prepareCall(funcGetMaNDN);
            callableStatement.registerOutParameter(1, Types.CHAR);
            callableStatement.setString(2, uid);
            callableStatement.execute();
            maNDN = callableStatement.getString(1);
//            System.out.println(maNDN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maNDN;
    }
    public String getMaNLH(String maNDN, String tenNLH) {
        String funcGetUid = "{? = call GETMANLH(?, ?) }";
        String maNLH = null;
        try {
            callableStatement = conn.prepareCall(funcGetUid);
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setString(2, maNDN);
            callableStatement.setString(3, tenNLH);
            callableStatement.execute();
            maNLH = callableStatement.getString(1);
//            System.out.println(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maNLH;
    }
    public String getUid(String maNDN) {
        String funcGetUid = "{? = call GETUID(?) }";
        String uid = null;
        try {
            callableStatement = conn.prepareCall(funcGetUid);
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setString(2, maNDN);
            callableStatement.execute();
            uid = callableStatement.getString(1);
//            System.out.println(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uid;
    }
    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String sql) {
        resSet = null;
        try {
            statement = conn.createStatement();
            resSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public int executeUpdate(String sql) {
        int n=-1;
        try {
            statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
}
