package JDBC_Validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Library_Model;

public class AddupdateDeleteOperation {
	Connection con ;
	  PreparedStatement ps;
	  Statement smt;
	  ResultSet rs;
	  String url;
	  String db_user;
	  String db_password;
	  String qry1 = "delete from db.library where Bookid = ?";
	  String driver;
	  int success_fail = 0;
	  public AddupdateDeleteOperation(String url, String db_user, String db_password, String driver) {
			super();
			this.url = url;
			this.db_user = db_user;
			this.db_password = db_password;
			this.driver = driver;
		}
	  //Default Constructor
	  public AddupdateDeleteOperation() {
		  
	  }
	// Start of Connection Operation	  
public void getConnection() {
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
	// Start of delete Operation
	  public int deleteOpration(int bookid) {
		  success_fail =0;
		  try {
				ps= this.con.prepareStatement(qry1);
				ps.setInt(1, bookid);
				success_fail = ps.executeUpdate();
			}  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return success_fail;
	  }// End delte Operation

 // Start of Add Operation
 public int addOperation(int bookid,String Titel,String Author,double Price,int Page) {
			  success_fail =0;
			 String  qry1 = "insert into db.library values(?,?,?,?,?)";
			  try {
					ps= this.con.prepareStatement(qry1);
					ps.setInt(1, bookid);
					ps.setString(2, Titel);
					ps.setString(3, Author);
					ps.setDouble(4, Price);
					ps.setInt(5, Page);
					success_fail = ps.executeUpdate();
				}  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  return success_fail;
		  }// End of Add Operation

	// Start of Find Operation
  public Library_Model findOpration(int bookid) {
			  rs = null;
			  Library_Model  model = null;
			  String qry1 = "select * from db.library where Bookid = ?";
			  try {
					ps= this.con.prepareStatement(qry1);
					ps.setInt(1, bookid);
					rs = ps.executeQuery();
					while(rs.next()) {
						model = new Library_Model(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));
					}
										
				}  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  return model;
		  }
// End of Find Operation 
  public int updateOperation(int Bookid_new,String Titel_new,String Author_new,double Price_new,int Page_new) {
		  rs = null;
		  String qry1 = "update db.library set Titel=?,Author=?,Price=?,Page=? where Bookid =?";
		  try {
				ps= this.con.prepareStatement(qry1);
				ps.setString(1, Titel_new);
				ps.setString(2, Author_new);
				ps.setDouble(3, Price_new);
				ps.setInt(4, Page_new);
				ps.setInt(5, Bookid_new);				
				success_fail = ps.executeUpdate();
													
			}  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return success_fail;
	  }
  
}
