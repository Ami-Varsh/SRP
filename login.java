/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author INDHUJA
 */

interface B{
   abstract void process1();
}
public class login extends HttpServlet implements B{
    @Override
    public void process1(){
     System.out.println("INVALID USER ID OR PASSWORD");
     
}
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String uname=request.getParameter("username");
        
        String pwd=request.getParameter("pwd");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Connection con;
            Statement st;
            ResultSet rs;
            String dri="com.mysql.cj.jdbc.Driver";
            String DBUrl="jdbc:mysql://localhost:3306/food donation";
                    Class.forName(dri);
                    con=DriverManager.getConnection(DBUrl,"root","");
                    st=con.createStatement();  
                    String sql="SELECT * FROM user WHERE mail LIKE \'%" +uname + "%\'" +
" AND pwd LIKE \'%" + pwd + "%\'";
                   
                    rs=st.executeQuery(sql);
                    
                     
           if( !rs.isBeforeFirst()&& rs.getRow()==0){
                user.add(uname,pwd);
               RequestDispatcher req = request.getRequestDispatcher("login.jsp");
			req.include(request, response);
                        process1();
                        
           }
            else
		{
			RequestDispatcher req = request.getRequestDispatcher("index.html");
			req.forward(request, response);
		}		
            
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
   
    