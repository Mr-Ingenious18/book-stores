package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.js.dto.Books;

public class BookCRUD {
	static String path="com.mysql.cj.jdbc.Driver";
	final static String address="jdbc:mysql://localhost:3306/book_store?user=root";
	static Connection c;
	public int insertBooK(Books b) {
		try {
			Class.forName(path);
			 c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("insert into book values(?,?,?,?)");
			ps.setInt(1, b.getId());
			ps.setString(2,b.getName());
			ps.setDouble(3, b.getPrice());
			ps.setString(4, b.getAuthor());
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
		  e.printStackTrace();
		} catch (SQLException e) {
		  e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
		      e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int deleteBookById (int id) {
		try {
			Class.forName(path);
			c= DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("delete from book where id=?");
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int updateBookById (int id, Books b) {
		try {
			Class.forName(path);
			c= DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("update book set bookname=?, author=?, price=? where id=?");
			ps.setString(1, b.getName());
			ps.setString(2, b.getAuthor());
			ps.setDouble(3, b.getPrice());
			ps.setInt(4, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}  
		return 0;
	}
    public Books getBookById(int id) {
    	Books b=null;
    	try {
			Class.forName(path);
			c= DriverManager.getConnection(address);
			PreparedStatement ps= c.prepareStatement("select * from book where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b= new Books();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPrice(rs.getDouble(3));
				b.setAuthor(rs.getString(4));				
				
			}else {
				return b;
			}
			return b;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
    
    }
    public ArrayList<Books> getAllBooks(){
    	ArrayList<Books> al = new ArrayList<Books>();
    	try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Books b = new Books();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPrice(rs.getDouble(3));
				b.setAuthor(rs.getString(4));
				al.add(b);
			}
			return al;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
    }
    public boolean batchExecution(ArrayList<Books>books) {
    	try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("insert into books values (?,?,?,?)");
			for(Books b: books) {
				ps.setInt(1, b.getId());
				ps.setString(2,b.getName());
				ps.setDouble(3, b.getPrice());
				ps.setString(4, b.getAuthor());
				ps.addBatch();
			}
			ps.executeBatch();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
    }
}
    
