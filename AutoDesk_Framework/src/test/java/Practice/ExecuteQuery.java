package Practice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuery
{
	@Test
	public void executeQuery() throws SQLException
	{
		//STEP1:REGISTER THE DATABASE
		Driver driverreff=new Driver();
		DriverManager.registerDriver(driverreff);
		
		//STEP2:ESTABLISH THE CONNECTION WITH DATABASE
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
		
		//STEP3:ISSUE CREATE STATEMENT
		Statement state=con.createStatement();
		
		//STEP4:EXECUTE THE QUERY
		ResultSet result=state.executeQuery("select * from customer");
		
		while(result.next())
		{
			System.out.println(result.getString(3));
		}
		
	}
	

}
