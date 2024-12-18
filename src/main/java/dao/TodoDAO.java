package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Todo;

//todoテーブルを担当するDAO

public class TodoDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true";
	private final String DB_USER = "root";
	private final String DB_PASS = "52481001uk";
	
	public List<Todo> findAll(){
		List<Todo> todoList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データーベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT ID, TITLE, CONTENT,CREATEAT, UPDATEDAT FROM TODOS ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Timestamp createdAt = rs.getTimestamp("CRETATEDAT");
				Timestamp updatedAt = rs.getTimestamp("UPDATEDAT");
				Todo todo = new Todo(id,title,content,createdAt,updatedAt);
				todoList.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return todoList;
	}

	public boolean create(Todo todo) {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
	
	try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
		
		
	String sql = "INSERT INTO todos (ID,TITLE,CONTENT,CREATEDAT,UPDATEDAT) VALUES(?,?,?,?,?)";
     PreparedStatement pStmt = conn.prepareStatement(sql);

     pStmt.setInt(1, todo.getId());
     pStmt.setString(2, todo.getTitle());
     pStmt.setString(3, todo.getContent());
     pStmt.setTimestamp(4, todo.getCreatedAt());
     pStmt.setTimestamp(5, todo.getUpdatedAt());
     
     int result = pStmt.executeUpdate();
     if(result != 1) {
    	 return false;
     }
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
	}
	}
