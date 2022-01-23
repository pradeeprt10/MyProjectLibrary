package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JDBC_Validation.AddupdateDeleteOperation;
import JDBC_Validation.LoginValidation;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet(value = "/DeleteBookServlet", initParams = { 
		   @WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"), 
		   @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/db"),
		   @WebInitParam(name = "dbuser", value = "root"),
		   @WebInitParam(name = "dbpassword", value = "password"),})
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Book_id = Integer.parseInt(request.getParameter("Bookid"));
		ServletConfig cfg = getServletConfig();
		String url = cfg.getInitParameter("url").trim();
		String driver = cfg.getInitParameter("driver").trim();
		String dbuser = cfg.getInitParameter("dbuser").trim(); 
		String dbpassword = cfg.getInitParameter("dbpassword").trim();
		AddupdateDeleteOperation addupddlt = new AddupdateDeleteOperation(url,dbuser,dbpassword,driver);
		addupddlt.getConnection();
		//Call Delete operation to delete the selected record
		addupddlt.deleteOpration(Book_id);
		// Below  Logic is to Redirect to Welcome Page with All the Record fetch
		LoginValidation loginv = new LoginValidation();
		loginv.getconnection(url, dbuser, dbpassword, driver);
		String tableValue = "";
		tableValue = loginv.getBookDetails();
		request.setAttribute("table", tableValue);
		RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
		rd.forward(request, response);
	}

}
