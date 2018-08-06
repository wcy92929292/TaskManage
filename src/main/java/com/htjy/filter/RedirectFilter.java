package com.htjy.filter; 

import java.io.IOException;  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

public class RedirectFilter implements Filter {  
    public void destroy() {  
    }  

	 public void doFilter(ServletRequest servletRequest,  
	            ServletResponse servletResponse, FilterChain filterChain)  
	            throws IOException, ServletException {  
	 	HttpServletRequest request = (HttpServletRequest) servletRequest;  
		HttpServletResponse response = (HttpServletResponse) servletResponse;  
        String currentURL = request.getRequestURI();
        HttpSession session = request.getSession(false);  
        //根据indexOf原则，如果不包含login.html 则返回-1，业务上就要进行session判断处理
        if (currentURL.indexOf("login.html")==-1 && currentURL.indexOf("register.html")==-1&& currentURL.indexOf("index.html")==-1&& currentURL.indexOf("preIndex.html")==-1&&currentURL.indexOf("rule.html")==-1&& currentURL.indexOf("business2.html")==-1&&currentURL.indexOf("/index/")!=-1) {
        	 if (session==null ||session.getAttribute("user") == null) {  
        		 StringBuffer url = request.getRequestURL();  
        		 response.setContentType("text/html;charset=utf-8"); 
        		 if(currentURL.indexOf("business.html")!=-1){
            		 response.getWriter().write("<script>alert('检测到您尚未登录，请登录后继续！');window.location='"+request.getContextPath() + "/index/login.html?next=index'; </script>");    
        		 }else if(currentURL.indexOf("personal.html")!=-1){
            		 response.getWriter().write("<script>alert('检测到您尚未登录，请登录后继续！');window.location='"+request.getContextPath() + "/index/login.html?next=personal'; </script>");    
        		 }else if(currentURL.indexOf("business2.html")!=-1){
            		 response.getWriter().write("<script>alert('检测到您尚未登录，请登录后继续！');window.location='"+request.getContextPath() + "/index/login.html?next=preIndex'; </script>");    
        		 }
        		 response.getWriter().flush();
//                 response.sendRedirect(request.getContextPath() + "/index/login.html");  
                 return;  
             }
         }  
        if (currentURL.indexOf("login.html")==-1 && currentURL.indexOf("/admin/")!=-1) {
       	 if (session==null ||session.getAttribute("admin") == null) {  
       		 StringBuffer url = request.getRequestURL();  
                response.sendRedirect(request.getContextPath() + "/admin/login.html");  
                return;  
            }
        }  
        
        filterChain.doFilter(request, response);   
	}
	 public void init(FilterConfig filterConfig) throws ServletException {  
		 
	    }

}
