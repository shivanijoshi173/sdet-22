
	package Practice;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.testng.annotations.Test;

	import com.mysql.cj.jdbc.Driver;

	public class GetAllDetailsOfTable 
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
			int result=state.executeUpdate("insert into customer (first_name,last_name,address)values('TRUPTI', 'AR', 'PUNE');");
			
	ResultSet rsl=state.executeQuery("select * from customer;");
	ResultSetMetaData rsm=rsl.getMetaData();
	int count = rsm.getColumnCount();
			
			while(rsl.next())
			{
				for(int i=1;i<=count;i++) {
				System.out.print(rsl.getString(i));
			}
				System.out.println(" ");
		
			}
		}
		


	}



