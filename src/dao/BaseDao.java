package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BaseDao {
	
		public String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		public String url="jdbc:sqlserver://localhost:1433;databaseName=Vote";
		
		public String user="sa";
		
		public String pwd="123";
		
		
	  public ResultSet rs;
	  public Connection conn;
	  public PreparedStatement stmt;
	  
	  public Connection getConnection()
	  {
		  try {
			Class.forName(driver);
			if(conn==null||conn.isClosed()==true)
			{
			conn=DriverManager.getConnection(url,user,pwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return conn;
	  }
	  
	  
	  public void CloseAll(Connection conn,ResultSet rs,PreparedStatement stmt)
	  {
		 
			  try {
				  if(rs!=null)
				  {
					  rs.close();
				  }
				  if(stmt!=null)
				  {
					  stmt.close();
				  }
				  if(conn!=null)
				  {
					  conn.close();
				  }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  
	  public int executeUpdate(String sql,Object...para)
	  {
		  stmt=null;
		  conn=getConnection();
		  int num=0;
		  try {
			stmt=conn.prepareStatement(sql);
			if(para!=null)
			{
				for(int i=0;i<para.length;i++)
				{
					stmt.setObject(i+1, para[i]);
				}
			}
			num=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally
		  {
			  CloseAll(conn, rs, stmt);
		  }
		 return num;
	  }
	  
	  public ResultSet executeQuery(String sql,Object...para)
	  {
		  stmt=null;
		  conn=getConnection();

		  try {
			stmt=conn.prepareStatement(sql);
			if(para!=null)
			{
				for(int i=0;i<para.length;i++)
				{
					stmt.setObject(i+1, para[i]);
				}
			}
			rs=stmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return rs;
	  }
}
