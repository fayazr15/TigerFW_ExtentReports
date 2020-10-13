package commonLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * @code This class provides functions to Connection,Disconnection and Fetch Data from DB
 * @author Fayaz
 *
 */
public class DataBaseLib 
{
	/**
	 *  Global Reference variables
	 */
	 Connection connect;
	 Statement statement;
	 ResultSet result;

	public void connectToDB() throws SQLException 
	{
		Driver driverref = new Driver();

		/*step 1 : register the database-Driver */
		DriverManager.registerDriver(driverref);

		/*// step 2 : connect to database*/		
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root"); //j2ee==root
		/* step 3 : create statement*/
		statement = connect.createStatement();
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		/* step 1 : execute Query*/
		result = statement.executeQuery(query);
		return result;
	}
	
	public int executeNonSelectQuery(String query) throws SQLException
	{
		result = statement.executeQuery(query);
		 /*step 1 : Update Query*/
		int updateResult = statement.executeUpdate(query);//insert into exceldata values (1,'CreateOrganisation','OrganisationName','Wipro','')
		return updateResult;
	}
	
	public boolean executeAndValidateData(String query,int colIndex,String expdata) throws SQLException
	{
		boolean flag = false;
		/* step 1 : execute Query*/
		 result = statement.executeQuery(query);
		/* step 2 : verify */
		 
		 while(result.next())
		{
						String dbData = result.getString(colIndex);
						 if(dbData.equals(expdata)) 
						 {
							 flag = true;
							 break;
						 }
		}	 
		return flag;
	}
	
	public String fetchDataFromDB(String tableName,int rownum,int columnIndex) throws SQLException
	{
		 /*step 1 : execute Query*/
		result = statement.executeQuery("select * from "+tableName+";");
	
		int count =1;
		
		String value =null;
		
		/* step 2 : verify and fetch particular row & column value*/
		while (result.next()) 
		{
			if (count==rownum) 
			{
				 value = result.getString(columnIndex);
				System.out.println(value);
			}
			count++;
		
		}
		return value;
	}
	
	 public void DisconnectToDB() throws SQLException
	 {
	/*	step 1 : close the connection */
		connect.close();
					 
	 }
					 		 
}
	
