/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/Add"})
public class Add extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static Time parseTime(String value) {
        try {
            return new Time(new SimpleDateFormat("HH:mm:ss").parse(value).getTime());
        } catch (Exception exception) {
            return null;
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        int ck=Integer.parseInt(request.getParameter("cooked"));
        int ws=Integer.parseInt(request.getParameter("wasted"));
        String name=request.getParameter("name");
        String d=request.getParameter("date");
        Date dt=Date.valueOf(d);
        //d = FormattingDate.StringToDate(request.getParameter("date"));
        Time t=parseTime(request.getParameter("time"));
        //InputStream ph=new FileStream(parseFile(request.getParameter("ph"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
         Connection con;
        String dri="com.mysql.cj.jdbc.Driver";
        String DBUrl="jdbc:mysql://localhost:3306/food donation";
                    Class.forName(dri);
                    con=DriverManager.getConnection(DBUrl,"root","");
                   
  String sql = "insert into posts "+ " values (?,?,?,?)";  
	PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,name);
        st.setInt(2,ck);
	st.setInt(3,ws);
        st.setTime(4,(java.sql.Time)t);
        //st.setDate(5,(java.sql.Date)dt);
        //st.setBlob(6,ph);
        st.executeUpdate();

        /*st1 = con.prepareStatement(sql1);
        st1.setString(1,reg);
	st1.setString(2,pwd);
        st1.executeUpdate();*/
        
        response.sendRedirect("index.html");
				
            
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    
   private static class FormattingDate {
   public static Date StringToDate(String dob) throws ParseException {
      //Instantiating the SimpleDateFormat class
      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
      //Parsing the given String to Date object
      Date date = (Date) formatter.parse(dob);
      System.out.println("Date object value: "+date);
      return date;
   }

}
}
