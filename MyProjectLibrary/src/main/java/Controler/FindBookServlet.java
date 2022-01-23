package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JDBC_Validation.AddupdateDeleteOperation;
import Model.Library_Model;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet implementation class FindBookServlet
 */
@WebServlet(value = "/FindBookServlet", initParams = { 
		   @WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"), 
		   @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/db"),
		   @WebInitParam(name = "dbuser", value = "root"),
		   @WebInitParam(name = "dbpassword", value = "password"),})
public class FindBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Book_id = Integer.parseInt(request.getParameter("Bookid"));
		ServletConfig cfg = getServletConfig();
		String url = cfg.getInitParameter("url").trim();
		String driver = cfg.getInitParameter("driver").trim();
		String dbuser = cfg.getInitParameter("dbuser").trim(); 
		String dbpassword = cfg.getInitParameter("dbpassword").trim();
		AddupdateDeleteOperation addupddlt = new AddupdateDeleteOperation(url,dbuser,dbpassword,driver);
		addupddlt.getConnection();
		Library_Model book_reference_object = addupddlt.findOpration(Book_id);
		request.setAttribute("Bookid",book_reference_object.getBookid());
		request.setAttribute("Titel",book_reference_object.getTitel());
		request.setAttribute("Author",book_reference_object.getAuthor());
		request.setAttribute("Price",book_reference_object.getPrice());
		request.setAttribute("Page",book_reference_object.getPage());
		RequestDispatcher rd = request.getRequestDispatcher("UpdateBook.jsp");
		rd.forward(request, response);
	
}

}
