/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UploadService;

import com.CollegeQuara.controller.UploadServlet;
import com.CollegeQuara.dto.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadService {
    public String uploadFile(ServletContext ctx,
            HttpServletRequest req)
    {
        String relativeWebPath = "/assets/docs";
        
        String buildPath = ctx.getRealPath(relativeWebPath);
        String proPath =  buildPath.replace("build/","");
        
       /*assets*/ System.out.println("Buildpath "+buildPath);
        /*build*/System.out.println("Propath "+proPath);
        
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("sesuser");
        int userid = user.getUserid();
        
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if(isMultipart)
        {
          DiskFileItemFactory factory = new DiskFileItemFactory();               
          factory.setSizeThreshold(500*1024);
          
          ServletFileUpload upload = new ServletFileUpload(factory);   
          // maximum file size to be uploaded.
          upload.setSizeMax(500*1024);
            try 
            {
              List<FileItem>fileItems = upload.parseRequest(req);
              
              for(FileItem item : fileItems)
              {                    
                  String fileName = item.getName();
                  InputStream is = item.getInputStream();
                  
                  File f1 = new File(buildPath,userid+"");
                  File f2 = new File(proPath,userid+"");
                  if(!f1.exists()){
                      f1.mkdir();
                  }
                  if(!f2.exists()){
                      f2.mkdir();
                  }
                  
                  long milli = System.currentTimeMillis();
                  String ext = fileName.substring(fileName.lastIndexOf("."));
                  String fName = milli+ext;
                  
                  FileOutputStream fos1 = new FileOutputStream(new File(f1, fName));
                  FileOutputStream fos2 = new FileOutputStream(new File(f2, fName));
                  
                  while (true){
                      int i = is.read();
                      if(i==-1)break;
                      fos1.write(i);
                      fos2.write(i);
                  }
                  
                  fos1.close();
                  fos2.close();
                  return fName;
              }
              
            } catch (Exception ex) 
            {
                System.err.println("IN file upload service" + ex.getMessage());
                return null;
            }
        }return null;
    }

}
