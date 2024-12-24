package mypack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Senddata
 */
@WebServlet("/senddata")
public class Senddata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Senddata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String name= request.getParameter("username");
		String gender= request.getParameter("gender");
		String emailid= request.getParameter("email");
		String subject=request.getParameter("course");
		String language= request.getParameter("language");
		String password= request.getParameter("password");
		
		out.println(name);
		out.println(gender);
		out.println(emailid);
		out.println(subject);
		out.println(language);
		out.println(password);
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","1234");
		PreparedStatement pst = con.prepareStatement("insert into userdata value(?,?,?,?,?,?)");
		pst.setString(1, name);
		pst.setString(2, gender);
		pst.setString(3, emailid);
		pst.setString(4, subject);
		pst.setString(5, language);
		pst.setString(6, password);
		System.out.println("data sent");
		pst.executeUpdate();
		
		con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
