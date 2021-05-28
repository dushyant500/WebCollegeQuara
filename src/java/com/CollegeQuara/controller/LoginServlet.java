/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CollegeQuara.controller;

import com.CollegeQuara.dao.UserDao;
import com.CollegeQuara.dto.User;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *@author Dushyant
 **/
@WebServlet(name = "login",urlPatterns = {"/Login"})

public class LoginServlet extends HttpServlet 
{
    UserDao userDao ;
    
   @Override
    public void init(ServletConfig config) throws ServletException 
    {
        userDao = new UserDao();
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   
    {        
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        System.out.println("in login servlet "+email+" "+pass);
        
        User user = userDao.getUser(email,pass);
        if(user==null)
               {resp.sendRedirect("login.jsp?err=1");}
        else
        {
                HttpSession session = req.getSession();
                session.setAttribute("sesuser",user);
                System.out.println(user.getBranch());
                System.out.println(user.isVerifyStatus());
            if(user.isVerifyStatus()==1){        
                if(user.getType().equals("faculty"))
                {
                    resp.sendRedirect("faculty/home.jsp");
                }else{
                    resp.sendRedirect("student/home.jsp");
                }
            }
            else{
            resp.sendRedirect("Verify.jsp");
            }
        
        }
      
   }    
}
