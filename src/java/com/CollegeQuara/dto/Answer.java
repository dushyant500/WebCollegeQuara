package com.CollegeQuara.dto;

import java.util.Date;

public class Answer {
     private int ansid;
    private String ans;
    private Date ansDate;
    private int faculty;
    private int question;

    public Answer() {
    }

    public Answer(int ansid, String ans, Date ansDate, int faculty, int question) {
        this.ansid = ansid;
        this.ans = ans;
        this.ansDate = ansDate;
        this.faculty = faculty;
        this.question = question;
    }
    
    public Answer(String ans,int faculty, int question) 
    {    
        this.ans = ans;     
        this.faculty = faculty;
        this.question = question;
    }

    public int getAnsid() {
        return ansid;
    }

    public void setAnsid(int ansid) {
        this.ansid = ansid;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Date getAnsDate() {
        return ansDate;
    }

    public void setAnsDate(Date ansDate) {
        this.ansDate = ansDate;
    }

    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
    
    private String facultyName;

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }
    

    
}
