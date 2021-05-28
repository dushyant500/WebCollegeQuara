package com.CollegeQuara.controller;

import com.CollegeQuara.dao.AnswerDao;
import com.CollegeQuara.dto.Answer;
import com.CollegeQuara.dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ansfaculty",urlPatterns = {"/faculty/sendans"})
public class GiveAnsServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("com.CollegeQuara.controller.GiveAnsServlet.doPost()");
        String ans = req.getParameter("ans");
   int quesid = Integer.parseInt(req.getParameter("quesid"));
        System.out.println(ans+ "$ $" +quesid);
        HttpSession sess = req.getSession();
        User user = (User) sess.getAttribute("sesuser");
        
        int userid = user.getUserid();
        Answer ob = new Answer(ans, userid, quesid);
        
        
        boolean status = new AnswerDao().save(ob);
        System.out.println("in give answer servlet " + status);
        resp.getWriter().write("Done !");
        
    }
    
    
    
}
