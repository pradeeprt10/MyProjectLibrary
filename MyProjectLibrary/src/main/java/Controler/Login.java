package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JDBC_Validation.LoginValidation;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet implementation class Login
 */
@WebServlet(value = "/LoginSevlet", initParams = { 
		   @WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"), 
		   @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/db"),
		   @WebInitParam(name = "dbuser", value = "root"),
		   @WebInitParam(name = "dbpassword", value = "password")})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean validate = false;		
		String user = request.getParameter("uname").trim();
		String password = request.getParameter("psw").trim();
		ServletConfig cfg = getServletConfig();
		String driver = cfg.getInitParameter("driver").trim();
		String url = cfg.getInitParameter("url").trim();
		String dbuser = cfg.getInitParameter("dbuser").trim(); 
		String dbpassword = cfg.getInitParameter("dbpassword").trim();
		LoginValidation loginv = new LoginValidation();
		loginv.getconnection(url, dbuser, dbpassword, driver);
		validate = loginv.validateUser(user,password);
		String tableValue = "";
		tableValue = loginv.getBookDetails();
		//Setting the html content in form of Table which are getting from LoginValidation pass to WelcomeJSP.
		request.setAttribute("table", tableValue);		
		if(validate == true) {
			RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
			rd.forward(request, response);
			//response.sendRedirect("Welcome.jsp");
		}
		else {
			//RequestDispatcher rd = request.getRequestDispatcher("index.html");
			//response.sendRedirect("/MyProjectLibrary/index.html");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		}
		
	}

}
