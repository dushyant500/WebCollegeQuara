

package com.CollegeQuara.controller;

import Email.EmailVerify;
import com.CollegeQuara.dao.UserDao;
import com.CollegeQuara.dto.User;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dushyant
 */
@WebServlet(name = "register",urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet{
private UserDao userdao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        userdao = new UserDao();
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        EmailVerify mail = new EmailVerify();
             String flag ;
              String name  = req.getParameter("username"); 
              String email  = req.getParameter("email");
              String pass  = req.getParameter("pass");
               String branch  = req.getParameter("branch");
                String type  = req.getParameter("type");
                String cpass = req.getParameter("cpass");
              if(pass.equals(cpass) )
                {
                User user = new User(name, email, pass, branch, type);
                  boolean status = userdao.save(user);
                  if(status)
                        {
                          Random r = new Random(System.currentTimeMillis());
                          int otp =  10000 + r.nextInt(20000);
            
                          mail.sendVerifyMail(name, email, otp);
                          userdao.updateOTP(email,otp);
                        }
                  String url = "Verify.jsp";
                  resp.sendRedirect(url);
                }else
                {
                   flag = "no";
                   resp.sendRedirect("register.jsp?flag");
                }
               
    }
    
    
    
}
