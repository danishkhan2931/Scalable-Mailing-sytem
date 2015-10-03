import java.sql.*;  
// DB Connection Class
class ConnectionCentralDB{  
ArrayList<Mail >list;
ConnectionCentralDB(string username,string password){  
try{  
//step1 load the driver class  
Class.forName("com.mysql.jdbc.Driver");   
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"centralizedDatabase:@somehost:1521:xe",username,password);  
  
//step3 create the statement object  
Statement stmt=con.createStatement();   
  
}catch(Exception e){ System.out.println(e);}  
  
}
Mail public query(int start,int end)
{
	ResultSet rs=stmt.executeQuery(Select * from central where id>=start and id<end);  
while(rs.next())  
{
	list[i].setsender(rs.string(1));
	list[i].setreciever(rs.string(2));
	list[i].setSubject(rs.string(3));
	list[i].setSubject(rs.string(4));	
}
return list;
	
}  
}  