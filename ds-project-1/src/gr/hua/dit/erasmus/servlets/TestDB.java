package gr.hua.dit.erasmus.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDB() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variables
        String jdbcUrl = "jdbc:mysql://localhost:3306/ds_project?useSSL=false";
        String user = "hbstudent";
        String pass = "changeit";
        String driver= "com.mysql.jdbc.Driver";
        
        // get connection to db
        try {
                PrintWriter out = response.getWriter();
                out.println("Connecting to db: " + jdbcUrl);
                
                Class.forName(driver);
                Connection con = DriverManager.getConnection(jdbcUrl,user,pass);
                out.println("Connection Success!");
                con.close();
        }
        catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
        }
        
	}

}
