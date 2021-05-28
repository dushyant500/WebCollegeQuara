/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;


import com.CollegeQuara.dto.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "webf", urlPatterns = {"/*"})

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("Init filter");
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        System.out.println("filter.MyFilter.doFilter()");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURL().toString();
        System.out.println("\nURL >>>> " + url);

        Object sessionObj = req.getSession().getAttribute("sesuser");
        boolean s = url.contains("/student/") || url.contains("/faculty/");
        System.out.println("filter.MyFilter.doFilter()__TEST"+s);
        if(url.contains(".") && s==false)
        {
            chain.doFilter(request, response);
        }else if (url.contains("/student/") || url.contains("/faculty/")) 
        {
            if (sessionObj == null) {
                String u = req.getContextPath() + "/login.jsp";
                res.sendRedirect(u);
            } else 
            {
                User user = (User) sessionObj;
                if(url.contains(user.getType()))
                {
                    chain.doFilter(request, response);
                }else{
                    if (user.getType().equals("faculty")) {
                        res.sendRedirect(req.getContextPath() + "/faculty/home.jsp");
                    } else {
                        res.sendRedirect(req.getContextPath() + "/student/home.jsp");
                    }
                }
            }
        } else if (url.contains("/logout")) {
            chain.doFilter(request, response);
        } else if (sessionObj != null) {
            User user = (User) sessionObj;
            if (user.getType().equals("faculty")) {
                res.sendRedirect(req.getContextPath() + "/faculty/home.jsp");
            } else {
                res.sendRedirect(req.getContextPath() + "/student/home.jsp");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.err.println("Destroy filter");
    }
}
