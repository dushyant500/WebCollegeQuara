package com.CollegeQuara.dto;

public class User {
    private int userid;
    private String userName;
    private String email;
    private String password;
    private String branch;
    private String type;
    private int otp;
    private int verifyStatus;
    
    public User(){
    }

    public User(int userid, String userName, String email, String password, String branch, String type, int otp, int verifyStatus) {
        this.userid = userid;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.branch = branch;
        this.type = type;
        this.otp = otp;
        this.verifyStatus = verifyStatus;
    }
    
    
    public User(String userName, String email, String password, String branch, String type, int otp, int verifyStatus) {
     
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.branch = branch;
        this.type = type;
        this.otp = otp;
        this.verifyStatus = verifyStatus;
    }

    public User(String name, String email, String pass, String branch, String type) {
    this.userName = name;
    this.email = email;
    this.password = pass;
    this.branch = branch;
    this.type = type;
    }

    public User(int userid, String name, String email, String branch, String type) 
    {
    this.userid =userid ;
    this.userName = name;
    this.email = email;
    this.branch = branch;
    this.type = type;
    }

    public User(int userid, String name, String email, String branch, String type, int verify) {
              this.userid = userid;
              this.userName = name;
              this.email = email;
              this.branch = branch;
              this.type = type;
              this.verifyStatus = verify;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public int isVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(int verifyStatus) {
        this.verifyStatus = verifyStatus;
    }
    
    

}
