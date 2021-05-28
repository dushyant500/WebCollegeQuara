package com.CollegeQuara.dao;

import com.CollegeQuara.dto.Docs;
import com.CollegeQuara.dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao implements BaseDao<User>
{
    @Override
    public boolean save(User ob) 
    {
        try {
            Connection cnn = DBConnection.getConnection();
            
            PreparedStatement ps = cnn.prepareStatement("insert into user"
                    + "(user_name,email,password,branch,type) value(?,?,?,?,?)");
            ps.setString(1,ob.getUserName());
            ps.setString(2,ob.getEmail());
            ps.setString(3,ob.getPassword());
            ps.setString(4,ob.getBranch());
            ps.setString(5,ob.getType());
            
            int i = ps.executeUpdate();
            cnn.close();
            if(i>0)
                return true;
            else
                return false;
        } catch (Exception ex) 
        {
            System.err.println("Register User : " + ex.getMessage());
            return false;
        }        
    }

    @Override
    public boolean update(User ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(User ob){
            throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User getUser(String email, String pass) 
    {
        try(Connection cnn = DBConnection.getConnection())
        {            
      PreparedStatement ps  = cnn.prepareStatement("select userid,user_name,email,branch,type,isverify from user where email=? and password=?");
            
            System.out.println(email+pass);
            
            ps.setString(1,email);
            ps.setString(2, pass);
            
            
            ResultSet rs = ps.executeQuery();
            System.out.println("In user dao getuser udate count"+ps.getUpdateCount());
         
            if(rs.next())
            {
                
                int userid = rs.getInt("userid");
                String name = rs.getString("user_name");
                String useremail = rs.getString("email");
                String branch = rs.getString("branch");
                String type = rs.getString("type");
                int verify = rs.getInt("isverify");
                User user = new User(userid, name, email, branch, type, verify);
                return user;                
            }else{
                return null;
            }
            
        }catch(Exception ex){
            System.err.println("@  #  @Login User : " + ex.getMessage());
            return null;
        }
    }
    
    
    
    
    public ArrayList<User> listStudents(String branch)
    {
        ArrayList<User> list = new ArrayList<>();
        
        try(Connection cnn = DBConnection.getConnection()) 
        {
            PreparedStatement ps = cnn.prepareStatement("select user_name,email from user "
                    + "where type='student' and branch=?");
            ps.setString(1, branch);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("user_name");
                String email = rs.getString("email");
                
                User user = new User();
                user.setUserName(name);
                user.setEmail(email);
                
                list.add(user);
            }
            
            
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        return list;
    }
    

public ArrayList<User> list(String branch, int uid)
    {
        ArrayList<User> list = new ArrayList<>();
        
        try(Connection cnn = DBConnection.getConnection()) 
        {
            PreparedStatement ps = cnn.prepareStatement("select user_name,email from user "
                    + "where type='student' and branch=? and userid!=?");
            ps.setString(1, branch);
            ps.setInt(2, uid);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("user_name");
                String email = rs.getString("email");
                
                User user = new User();
                user.setUserName(name);
                user.setEmail(email);
                
                list.add(user);
            }
            
            
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        return list;
    }
public boolean verifyUser(String email, String otp) 
    {
        try {
            Connection cnn = DBConnection.getConnection();
            
            PreparedStatement ps = cnn.prepareStatement("update user "
                    + " set isverify=1 where email=? and otp=?");
            ps.setString(1,email);
            ps.setInt(2,Integer.parseInt(otp));
            
            int i = ps.executeUpdate();            
            cnn.close();
            if(i>0){return true;}
            else {return false;}
        } catch (Exception ex) 
        {
            System.err.println("Verify User : " + ex.getMessage());            
            return false;
        }    
    }     

    public void updateOTP(String email, int otp) {
               try {
            Connection cnn = DBConnection.getConnection();
            
            PreparedStatement ps = cnn.prepareStatement("update user "
                    + " set otp=? where email=?");
            ps.setInt(1,otp);
            ps.setString(2,email);
            
            int i = ps.executeUpdate();
            cnn.close();
            
        } catch (Exception ex) 
        {
            System.err.println("Update Otp User : " + ex.getMessage());            
        }        

    }

    public boolean saveDocument(int userid, String fileName) {
        try {
            Connection cnn = DBConnection.getConnection();
            
            PreparedStatement ps = cnn.prepareStatement("insert into documents"
                    + "(filepath,faculty) value(?,?)");
            ps.setString(1,fileName);
            ps.setInt(2,userid);
            
            int i = ps.executeUpdate();
            cnn.close();
            if(i>0)
            {
                return true;
            }
            else
                return false;
        } catch (Exception ex) 
        {
            System.err.println("File Upload : " + ex.getMessage());
            return false;
        } 
    }
 public List<Docs> listDocs(String branch)
    {
        List<Docs> docsList = new ArrayList<>();
        String query = "select user_name,filepath,send_date,faculty "
                + "from user,documents where faculty in "
                + "(select userid from user where type='faculty' "
                + "and branch=?) and user.userid=documents.faculty "
                + "order by send_date DESC";
        
        try(Connection cnn = DBConnection.getConnection())
        {
           PreparedStatement ps = cnn.prepareStatement(query);
           ps.setString(1, branch);
           ResultSet rs = ps.executeQuery(); 
           while (rs.next()) 
           {                
               String name = rs.getString("user_name");
               String filename = rs.getString("filepath");
               Date date = rs.getDate("send_date");
               int facid = rs.getInt("faculty");
               
               Docs ob = new Docs(facid, name, filename, date);
               docsList.add(ob);
           }
            
        }catch(Exception ex){
            System.out.println("Get Docs : " + ex.getMessage());
        }
        return docsList;
    }

}    