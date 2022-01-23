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
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(value = "/UpdateBookServlet", initParams = { 
		   @WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"), 
		   @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/db"),
		   @WebInitParam(name = "dbuser", value = "root"),
		   @WebInitParam(name = "dbpassword", value = "password"),})
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Bookid = Integer.parseInt(request.getParameter("Bookid_Name"));
		String Titel = (String)(request.getParameter("Titel_Name"));
		String Author = (String)(request.getParameter("Author_Name"));
		double Price  = Double.parseDouble(request.getParameter("Bookid_Name"));
		int Page = Integer.parseInt(request.getParameter("Page_Name"));
		ServletConfig cfg = getServletConfig();
		String url = cfg.getInitParameter("url").trim();
		String driver = cfg.getInitParameter("driver").trim();
		String dbuser = cfg.getInitParameter("dbuser").trim(); 
		String dbpassword = cfg.getInitParameter("dbpassword").trim();
		AddupdateDeleteOperation addupddlt = new AddupdateDeleteOperation(url,dbuser,dbpassword,driver);
		addupddlt.getConnection();
		addupddlt.updateOperation(Bookid,Titel,Author,Price,Page);	
		
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
