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

public class Departments {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, FileNotFoundException {

		printDepartments();

	}

	@SuppressWarnings("unused")
	private static void loadData(String path, String tableName) throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, FileNotFoundException {
		DriverManager
				.registerDriver((Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance());
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=emp;schemaName=dbo;user=du;password=P@ssword";

		File file = new File(path);

		try (Scanner scanner = new Scanner(file);
				Connection connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection.createStatement()) {

			while (scanner.hasNextLine()) {
				statement.executeUpdate("insert into " + tableName + " values" + scanner.nextLine());
			}
		}
	}

	private static void printDepartments()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DriverManager
				.registerDriver((Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance());
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=emp;schemaName=dbo;user=du;password=P@ssword";

		String sqlString = "with months as (SELECT  DATEADD(MONTH, x.number, '1990-01-01') AS Month "
				+ "FROM    master.dbo.spt_values x " + "WHERE   x.type = 'P' "
				+ "AND     x.number <= DATEDIFF(MONTH, '1990-01-01', '1996-01-01')) "
				+ "select top(100) (select dept_name from dbo.departments d2 where d.dept_no=d2.dept_no) as department, sum(cast(s.salary as bigint)) as earnings "
				+ "from dbo.dept_emp d left join dbo.employees e on d.emp_no=e.emp_no left join (months m left join dbo.salaries s on s.from_date <= m.month and m.month <= s.to_date) on e.emp_no = s.emp_no "
				+ "where e.hire_date <= '1990-01-01' " + "group by d.dept_no "
				+ "order by sum(cast(s.salary as bigint)) asc ";

		try (Connection connection = DriverManager.getConnection(connectionUrl);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
				ResultSet rs = preparedStatement.executeQuery()) {

			System.out.println("|--------------------------------------------|");
			System.out.println("| Department:               |     Earnings:  |");
			System.out.println("|---------------------------|----------------|");
			while (rs.next()) {

				StringBuilder sb = new StringBuilder();
				String earnings = rs.getString("earnings");
				String department = rs.getString("department");

				sb.append("| " + department);
				for (int i = 0; i <= 25 - department.length(); i++) {
					sb.append(" ");
				}
				sb.append("|");
				for (int i = 0; i <= 14 - earnings.length(); i++) {
					sb.append(" ");
				}

				sb.append(earnings + " |");

				System.out.println(sb);
			}
			System.out.println("|--------------------------------------------|");
		}
	}

}
