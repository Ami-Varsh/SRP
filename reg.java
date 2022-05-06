/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author amirt
 */
@WebServlet(urlPatterns = {"/reg"})
public class reg extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("name");
        String mail=request.getParameter("mail");
        String ph=request.getParameter("ph");
        String type=request.getParameter("type");
        String pwd=request.getParameter("pwd");
        String address=request.getParameter("addr");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
         Connection con;
        //PreparedStatement st=null;
        PreparedStatement st1=null;
        ResultSet rs;
        String dri="com.mysql.cj.jdbc.Driver";
        String DBUrl="jdbc:mysql://localhost:3306/food donation";
                    Class.forName(dri);
                    con=DriverManager.getConnection(DBUrl,"root","");
                   
  String sql = "insert into user "+ " values (?,?,?,?,?,?)";  
	PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,name);
	st.setString(2,mail);
        st.setString(3, ph);
        st.setString(4,type);
        st.setString(5,pwd);
        st.setString(6,address);
        st.executeUpdate();

        /*st1 = con.prepareStatement(sql1);
        st1.setString(1,reg);
	st1.setString(2,pwd);
        st1.executeUpdate();*/
        
                    response.sendRedirect("login.jsp");
				
            
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
