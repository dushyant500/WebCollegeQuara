
package com.CollegeQuara.dto;

import java.util.Date;

public class Question {
 private int qid;
    private String qus;
    private Date askDate;
    private int student;

    public Question() {
    }

    public Question(int qid, String qus, Date askDate, int student) {
        this.qid = qid;
        this.qus = qus;
        this.askDate = askDate;
        this.student = student;
    }

    public Question(String qus, Date askDate, int student) 
    {
        this.qus = qus;
        this.askDate = askDate;
        this.student = student;
    }

    public Question(String ques, int id) 
    {
       this.qus = ques;
       this.student = id;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQus() {
        return qus;
    }

    public void setQus(String qus) {
        this.qus = qus;
    }

    public Date getAskDate() {
        return askDate;
    }

    public void setAskDate(Date askDate) {
        this.askDate = askDate;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }
    
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question(int qid, String qus, Date askDate, String name) {
        this.qid = qid;
        this.qus = qus;
        this.askDate = askDate;
        this.name = name;
    }
    
    
}
