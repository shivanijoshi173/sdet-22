package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate 
{
	@Test
	public void executeQuery() throws SQLException
	{
		Connection con = null;
		try
		{
		//STEP1:REGISTER THE DATABASE
		Driver driverreff=new Driver();
		DriverManager.registerDriver(driverreff);
		
		//STEP2:ESTABLISH THE CONNECTION WITH DATABASE
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
		
		//STEP3:ISSUE CREATE STATEMENT
		Statement state=con.createStatement();
		
		//STEP4:EXECUTE THE QUERY
		int result=state.executeUpdate("insert into customer values('10','ASHU', 'DR', 'MUMBAI"
				+ ""
				+ "');");
		if(result==1)
		{
			System.out.println("PASSS");
		}

		else
		{
			System.out.println("FAIL");
		}
		}
		catch(Exception e) {
			
		}
		finally
		{
			con.close();
		}
}
}