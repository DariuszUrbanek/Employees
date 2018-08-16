package com.example.du.xml;

import java.io.File;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.example.du.generated.xsd.Company;
import com.example.du.generated.xsd.EmployeeType;

public class XmlUnmarshaller {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Company company = readXML();
		Integer empNo = getLastEmpNo();

		saveEmployeesInDB(getInserts(company, empNo));
	}

	private static void saveEmployeesInDB(List<String> inserts)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DriverManager
				.registerDriver((Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance());
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=emp;schemaName=dbo;user=du;password=P@ssword";

		try (Connection connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection.createStatement()) {

			for (String insert : inserts) {
				statement.executeUpdate(insert);

			}

		}

	}
// FIXME - add birth date to xsd, re-generate sources
	private static List<String> getInserts(Company company, Integer empNo) {

		List<String> list = new ArrayList<>();

		for (EmployeeType employee : company.getEmployees().getEmployee()) {

			empNo++;
			Date date = new Date();
			String dateFormatted = new SimpleDateFormat("yyyy-MM-dd").format(date);

			list.add("insert into employees(emp_no, first_name, last_name, hire_date, birth_date) values (" + empNo + ",'"
					+ employee.getFirstname() + "','" + employee.getLastname() + "','" + dateFormatted + "','" + dateFormatted + "')");
		}
		return list;

	}

	private static Integer getLastEmpNo()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DriverManager
				.registerDriver((Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance());
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=emp;schemaName=dbo;user=du;password=P@ssword";

		try (Connection connection = DriverManager.getConnection(connectionUrl);
				PreparedStatement preparedStatement = connection
						.prepareStatement("select top(1) emp_no from dbo.employees order by emp_no desc");
				ResultSet rs = preparedStatement.executeQuery()) {
			if (rs.next()) {
				return rs.getInt("emp_no");
			} else {
				return null;
			}

		}

	}

	public static Company readXML() {
		try {
			File file = new File("src\\main\\resources\\xml\\HelloWorld.xml");

			JAXBContext jaxbc = JAXBContext.newInstance(Company.class);

			Unmarshaller jaxbUnamrshaller = jaxbc.createUnmarshaller();
			Company company = (Company) jaxbUnamrshaller.unmarshal(file);

			return company;

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
