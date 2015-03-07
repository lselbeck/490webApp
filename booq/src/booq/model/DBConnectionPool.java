package booq.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import eshop.beans.CartItem;
import eshop.beans.Customer;
import eshop.model.BookPeer;
import eshop.model.OrderDetailsPeer;
import eshop.model.OrderPeer;
import booq.beans.Book;


public class DBConnectionPool {
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public ArrayList<Connection> getConnList() {
		return connList;
	}

	public void setConnList(ArrayList<Connection> connList) {
		this.connList = connList;
	}

	public String getDriver() {
		return driver;
	}

	final String driver = "org.gjt.mm.mysql.Driver";
	String url;
	String username;
	String passwd; 
	ArrayList<Connection> connList = new ArrayList<Connection>();
	
	public DBConnectionPool(String url, String username, String passwd) throws Exception{
		this.url = url;
		this.username = username;
		this.passwd = passwd; 
		
		Class.forName(driver);
	}
	
	public Connection getConnection() throws Exception{
		if(connList.size() > 0){
			Connection conn = connList.get(0);
			if(conn.isValid(10)){
				return conn;
			}
		}
		
		return DriverManager.getConnection(url, username, passwd);
	}
	
	public void returnConnection(Connection conn) throws Exception{
		connList.add(conn);
	}
	
	public void closeAll(){
		for(Connection conn: connList){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
	
//----special methods // 
	
	
//----book queries---//
	
	///all books in a genre by putting in a genre id
	//search for books by using a keyword. Matching books in title and author
	//method that returns the book that is requested based on ID 


	//search for anything matching
	//search for book id
	//list books by genre 
	//author search 
	//publication date 
	
	
	public ArrayList<Book> getSearchResults(String keyword) {
	    return BookQueries.searchBooks(this, keyword);
	    }
	
	
	 public ArrayList<Book> getBooksInCategory(Integer genreId) {
		    return BookQueries.getBooksByCategory(this, genreId);
		    }

	 public Book getBookDetails(String bookID) {
		    return BookQueries.getBookById(this, bookID);
		    }

//----ordering operations ----// 
	
//insert order--//
	 public long insertOrder(); 
	
}
