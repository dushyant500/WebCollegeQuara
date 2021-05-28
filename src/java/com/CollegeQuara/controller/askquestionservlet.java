
package com.CollegeQuara.controller;

import com.CollegeQuara.dao.QuestionDao;
import com.CollegeQuara.dto.Question;
import com.CollegeQuara.dto.User;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "askqus",urlPatterns ={"/askqus"})
public class askquestionservlet extends HttpServlet
{
   private QuestionDao quesd ;
    
   @Override
    public void init(ServletConfig config) throws ServletException {
     quesd = new QuestionDao();
     super.init(config); 
    }
     
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sess = req.getSession();
        User use = (User) sess.getAttribute("sesuser");
        
        String ques = req.getParameter("ques");
        int id = use.getUserid();
        
        System.out.println("questionservlet"+ques+"%&"+id);
        Question question = new Question(ques,id);
       boolean save = quesd.save(question);
        System.out.println("queston" + save);
        
        String url = req.getContextPath()+"/student/question.jsp";
        resp.sendRedirect(url);
        
    }
    
}
