/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CollegeQuara.controller;

import com.CollegeQuara.dao.UserDao;
import com.CollegeQuara.dto.User;
import UploadService.FileUploadService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "upload",urlPatterns = {"/faculty/upload"})
public class UploadServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException 
    {          
        User user = (User) req.getSession().getAttribute("sesuser");
        int userid = user.getUserid();
        ServletContext ctx = getServletContext();
        FileUploadService fileUpload = new FileUploadService();
        String fileName = fileUpload.uploadFile(ctx, req);
        System.out.println("Fil Name : " +  fileName);
        
        if(fileName!=null)
            new UserDao().saveDocument(userid, fileName);
        
        resp.sendRedirect(req.getContextPath()+"/faculty/uploaddocs.jsp");
    }    
}