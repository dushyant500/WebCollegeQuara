
package com.CollegeQuara.dao;

import com.CollegeQuara.dto.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionDao implements BaseDao<Question>{

    @Override
    public boolean save(Question ob) {
           try {
            Connection cnn = DBConnection.getConnection();
            
           PreparedStatement ps = cnn.prepareStatement("insert into question"
                    + "(qus,student) value(?,?)");
           ps.setString(1,ob.getQus());
           ps.setInt(2,ob.getStudent());
            
            int i = ps.executeUpdate();
            cnn.close();
            if(i>0)
                return true;
            else
                return false;
        } catch (Exception ex) 
        {
            System.err.println("Question Save : " + ex.getMessage());
            return false;
        }        

    }

    @Override
    public boolean update(Question ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Question ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question get(int id) {
               try{
            Connection cnn = DBConnection.getConnection();
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery("select * from question where qid="+id);
            if(rs.next())
            {
                int qid = rs.getInt("qid");
                String qus = rs.getString("qus");
                Date askDate = rs.getDate("ask_date");
                
                Question question = new Question(qid, qus, askDate, 0);
                return question;
            }else{return null;}
        }catch(Exception ex){
            System.out.println("Qus Get : "+ex.getMessage());
            return null;
        }
    }
    
    public List<Question> listByBranch(String branch)
    {
       // select qid,qus,ask_date,user_name from question,user where student in (select userid from user where branch='cs' and type='student') and user.userid=question.student;
        ArrayList<Question> list = new ArrayList<>();
        try {
            Connection cnn = DBConnection.getConnection();
        
        String query = "select qid,qus,ask_date,user_name "
                + "from question,user "
                + "where student in "
                + "(select userid from user where branch=? "
                + "and type='student') "
                + "and user.userid=question.student";    
            
        PreparedStatement ps = cnn.prepareStatement(query);
            ps.setString(1,branch);
                      
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int qid = rs.getInt("qid");
                String qus = rs.getString("qus");
                Date askDate = rs.getDate("ask_date");
                String userName = rs.getString("user_name");

                Question question = new Question(qid, qus, askDate, 0);
                question.setName(userName);
                list.add(question);
            }
            
            
        } catch (Exception ex) 
        {
            System.err.println("Question list : " + ex.getMessage());            
        }   
        return list;

    }
    

    public List<Question> listByStudent(int id) 
    {
                ArrayList<Question> list = new ArrayList<>();
        try {
            Connection cnn = DBConnection.getConnection();
            
            PreparedStatement ps = cnn.prepareStatement("select * from question where student=?");
            ps.setInt(1,id);
                      
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int qid = rs.getInt("qid");
                String qus = rs.getString("qus");
                Date askDate = rs.getDate("ask_date");

                Question question = new Question(qid, qus, askDate, 0);
                
                list.add(question);
            }
            
            
        } catch (Exception ex) 
        {
            System.err.println("Question list : " + ex.getMessage());            
        }   
        return list;

    }
   
    public List<Question> list(String branch) 
    {
                ArrayList<Question> list = new ArrayList<>();
        try {
            Connection cnn = DBConnection.getConnection();
            String query = "select qid,qus,ask_date,user_name from question,user where student in (select userid from user where branch=? and type='student') and user.userid=question.student";
            PreparedStatement ps = cnn.prepareStatement(query);
            ps.setString(1,branch);
                      
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int qid = rs.getInt("qid");
                String qus = rs.getString("qus");
                Date askDate = rs.getDate("ask_date");
                String name = rs.getString("user_name");
                Question question = new Question(qid, qus, askDate, name);
                
                list.add(question);
            }
            return list;
            
        } catch (Exception ex) 
        {
            System.err.println("Question list : " + ex.getMessage());            
            return null;       
        }   
        
 }


}
