package Z_DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WritingDataToDB {

	public static void main(String[] args) throws SQLException {
		Driver  driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_E018", "root", "3007");
		
		Statement stmt = conn.createStatement();
		
		int result = stmt.executeUpdate("insert into Ninza_CRM_Details1 values('safari','http://49.249.28.218:8098/','Adam','tiger')"); 
		
		System.out.println(result);
		if (result!=0)
		{
				System.out.println("Data added successfully");
		}
		else 
		{
				System.out.println("Not addded");
		}
		conn.close();
			
		}
	}

