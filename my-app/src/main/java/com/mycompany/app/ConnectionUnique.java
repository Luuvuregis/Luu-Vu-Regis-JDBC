package com.mycompany.app;

import java.sql.*;

public class ConnectionUnique 
{
	private static String CONNECT_URL = "jdbc:mysql://mysql-projectwinyoels.alwaysdata.net:3306/projectwinyoels_gestion_peda_mysql";
	private Connection connection = null;
	private static ConnectionUnique instance = null;
	
	Connection getConnection(String LOGIN, String PASSWORD)
	{
		try 
		{
			return DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);

		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	
	private ConnectionUnique()
	{
		
	}
	
	
	public static ConnectionUnique getInstance()
	{
		if(instance == null)
			instance = new ConnectionUnique();
		return instance;
	}
	
}
