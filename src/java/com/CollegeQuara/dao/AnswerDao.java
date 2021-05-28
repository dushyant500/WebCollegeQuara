package com.CollegeQuara.dao;

import com.CollegeQuara.dto.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnswerDao implements BaseDao<Answer>{

    @Override
    public boolean save(Answer ob) {
        try {
            Connection cnn = DBConnection.getConnection();
            
            PreparedStatement ps = cnn.prepareStatement("insert into answer"
                    + "(ans,faculty,question) value(?,?,?)");
            ps.setString(1,ob.getAns());
            ps.setInt(2,ob.getFaculty());
            ps.setInt(3, ob.getQuestion());
            
            int i = ps.executeUpdate();
            cnn.close();
            if(i>0)
                return true;
            else
                return false;
        } catch (Exception ex) 
        {
            System.err.println("Answer Save : " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Answer ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Answer ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Answer> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Answer get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 public List<Answer> listByQuestion(int qid)
    {
        List<Answer> list = new ArrayList<>();
        try{
         
         
         String query = "select ans,ans_date,user_name "
                 + "from answer,user "
                 + "where question="+qid 
                 + " and answer.faculty=user.userid "
                 + "order by ans_date DESC";   
        
         Connection cnn = DBConnection.getConnection();
         Statement stm = cnn.createStatement();
         ResultSet rs = stm.executeQuery(query);
         
         while(rs.next())
         {
             String ans = rs.getString("ans");
             Date date = rs.getDate("ans_date");
             String name = rs.getString("user_name");
             
             Answer ob = new Answer();
             ob.setAns(ans);
             ob.setAnsDate(date);
             ob.setFacultyName(name);
             
             list.add(ob);
             
         }
         
        }catch(Exception ex){
            System.out.println("Get Answer "+ex.getMessage());
            
        }
        return list;
    }



}
