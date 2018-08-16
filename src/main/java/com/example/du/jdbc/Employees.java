package com.example.du.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employees {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, FileNotFoundException {
		printEmployees();
//		String folder = "C:\\Users\\Darek\\Desktop\\Scripts\\";
//		loadData(folder + "load_dept_manager.sql", "dept_manager");
//		loadData(folder + "load_salaries1.sql", "salaries");
//		loadData(folder + "load_salaries2.sql", "salaries");
//		loadData(folder + "load_salaries3.sql", "salaries");
//		loadData(folder + "load_titles.sql", "titles");
	}

	@SuppressWarnings("unused")
	private static void loadData(String path, String tableName)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, FileNotFoundException {
		DriverManager
				.registerDriver((Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance());
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=emp;schemaName=dbo;user=du;password=P@ssword";

		File file = new File(path);
		
		try (Scanner scanner = new Scanner(file);
				Connection connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection
						.createStatement()) {
				
			while(scanner.hasNextLine()) {
				statement.executeUpdate("insert into " + tableName + " values" + scanner.nextLine());
			}
		}
	}
	
	private static void printEmployees()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DriverManager.registerDriver((Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance());
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=emp;schemaName=dbo;user=du;password=P@ssword";

		try (Connection connection = DriverManager.getConnection(connectionUrl);
				PreparedStatement preparedStatement = connection
						.prepareStatement("select top(10) * from employees");
				ResultSet rs = preparedStatement.executeQuery()) {
			
			while(rs.next()) {
				System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
			}
		}
	}

}
