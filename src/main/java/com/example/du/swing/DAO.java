package com.example.du.swing;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Properties;

public class DAO {

	private static Integer lastEmpNo;

	private static Integer getNextEmpNo() throws SQLException {
		if(lastEmpNo == null)
			lastEmpNo = getLastEmpNo();
		if(lastEmpNo == null)
			throw new SQLException();
		return ++lastEmpNo;			
	}

	public static void main(String[] args) {

	}

	private static Connection getConnection() throws Exception {
		DriverManager
				.registerDriver((Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance());
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=emp;schemaName=dbo;user=du;password=P@ssword";
		
		Properties properties = new Properties();
		properties.put("loginTimeout", "1");
		Connection connection = DriverManager.getConnection(connectionUrl,properties);
		return connection;
	}

	public static Integer getLastEmpNo() {

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select top(1) emp_no from dbo.employees order by emp_no desc");
				ResultSet rs = preparedStatement.executeQuery()) {
			if (rs.next()) {
				return rs.getInt("emp_no");
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean addEmployee(Employee emp) {

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"insert into employees (emp_no, birth_date, first_name, last_name, hire_date) " + "values("
								+ (getNextEmpNo()) + ",'" + emp.birthDate + "','" + emp.firstName + "','" + emp.lastName
								+ "','" + emp.hireDate + "')")) {
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean deleteEmployee(int specifiedEmpNo) {

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from employees where emp_no=" + specifiedEmpNo)) {
			preparedStatement.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String printLastTenEmployees() {

		StringBuilder sb = new StringBuilder();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select top(10) * from employees order by emp_no desc");
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				try (PreparedStatement preparedStatement2 = connection.prepareStatement(
						"select top(3) * from salaries where emp_no=" + rs.getInt("emp_no") + " order by to_date desc");
						ResultSet rs2 = preparedStatement2.executeQuery()) {

					sb.append(rs.getString("emp_no") + "  " + rs.getString("first_name") + "  "
							+ rs.getString("last_name") + "  " + rs.getString("birth_date") + "  "
							+ rs.getString("hire_date") + "\n");

					while (rs2.next()) {
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(rs2.getDate("from_date"));

						sb.append(
								"        Year " + calendar.get(Calendar.YEAR) + ": $" + rs2.getString("salary") + "\n");

					}
					sb.append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return sb.toString();
	}

	public static Employee getEmployeeByNo(int specifiedEmpNo) {

		Employee emp = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from employees where emp_no=" + specifiedEmpNo);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				// System.out.println(
				// rs.getString("emp_no") + " " + rs.getString("first_name") + " " +
				// rs.getString("last_name")
				// + " " + rs.getString("birth_date") + " " + rs.getString("hire_date"));

				emp = new Employee(rs.getInt("emp_no"), rs.getDate("birth_date"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getDate("hire_date"));

			}
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void updateEmployee(Employee emp) {

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("update Employees set first_name = '"
						+ emp.firstName + "', last_name = '" + emp.lastName + "', birth_date = '" + emp.birthDate
						+ "', hire_date = '" + emp.hireDate + "' where emp_no = " + emp.empNo)) {

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static class Employee {
		Integer empNo;
		Date birthDate;
		String firstName;
		String lastName;
		Date hireDate;

		public Employee(Integer empNo, Date birthDate, String firstName, String lastName, Date hireDate) {
			this.empNo = empNo;
			this.birthDate = birthDate;
			this.firstName = firstName;
			this.lastName = lastName;
			this.hireDate = hireDate;
		}

		public Employee(Date birthDate, String firstName, String lastName, Date hireDate) {
			this.birthDate = birthDate;
			this.firstName = firstName;
			this.lastName = lastName;
			this.hireDate = hireDate;
		}
	}
}
