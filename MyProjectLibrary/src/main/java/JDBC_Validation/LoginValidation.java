package JDBC_Validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Library_Model;

public class LoginValidation {
	Connection con ;
	  PreparedStatement ps;
	  Statement smt;
	  ResultSet rs;
	  String url;
	  String db_user;
	  String user;
	  String db_password;
	  String password;
	 // String qry = "select * from db.employee here user = ? and password = ?";
	  String qry = "select * from db.employee where user = ? and password =?";
	  String qry2 ="select * from db.library";
	  String driver;
	  boolean validation = false;
	  String table;
	/**
	 * @param url
	 * @param user
	 * @param password
	 * @param driver
	 */
	public LoginValidation(String url, String db_user,String user, String db_password,String password, String driver) {
		super();
		this.url = url;
		this.db_user = db_user;
		this.user = user;
		this.db_password = db_password;
		this.password = password;
		this.driver = driver;
	}

	public LoginValidation() {
			
	}

	//Get Connection
	public void getconnection(String url, String db_user,String db_password,String driver) {
		this.url = url;
		this.db_user = db_user;
		this.driver = driver;
		 try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, db_user, db_password);
		 } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	//  User validate Login User - Start
	 public boolean validateUser(String user,String password) {	
		 this.user = user;
		 this.password = password;
		 try {
			
			ps= this.con.prepareStatement(qry);
			ps.setString(1, user);
			ps.setString(2, password);
			rs = ps.executeQuery();
			validation =rs.next();		
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return validation;
	 }
	// User validation - End
	//Get  Book details
	 
	 public String getBookDetails() {
		 this.rs = null;
		 table ="";
		 //Table Construction with Heading
		 table += "<table border =1>";
		 table += "<tr><td>BookId</td><td>Titel</td><td>Author</td><td>Price</td><td>Page</td><td>Update/Delete</td></tr>";
		 try {
			smt = this.con.createStatement();
			rs = smt.executeQuery(qry2);
			while(rs.next()) {
				Library_Model book = new Library_Model();
				book.setBookid(rs.getInt("Bookid"));
				book.setTitel(rs.getString("Titel"));
				book.setAuthor(rs.getString("Author"));
				book.setPrice(rs.getDouble("Price"));
				book.setPage(rs.getInt("Page"));
				table += "<tr>";
				table += "<td>";
				table +=book.getBookid();
				table += "</td>";
				table += "<td>";
				table +=book.getTitel();
				table += "</td>";
				table += "<td>";
				table +=book.getAuthor();
				table += "</td>";
				table += "<td>";
				table +=book.getPrice();
				table += "</td>";
				table += "<td>";
				table +=book.getPage();
				table += "</td>";
				table += "<td>";
				//Update operation will perform find then update, so it will call FindBookServlet then UpdateBookJsp then UpdateBookServlet
				table += "<a href=FindBookServlet?Bookid="+ book.getBookid()+"> update </a><a href=DeleteBookServlet?Bookid="+ book.getBookid()+ ">delete</a>";
				table += "</td>";
				table += "</tr>";							
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 table += "</table>";
		return table; 
	 }
	}
