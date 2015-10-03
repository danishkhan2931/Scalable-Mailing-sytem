import java.sql.*;  
class CentralDataBase{  
CentralDataBase(string username, string password) {
	
try{  
//step1 load the driver class  
Class.forName("com.mysql.jdbc.Driver");   
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"Central Database:@localhost:1521:xe",username,psasword);  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  

}catch(Exception e)
{ System.out.println(e);
}  
  
}

public insert(string insertquery)
{
	stmt.executeUpdate(insertquery); 
	
}  
}  