package com.example.du.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import org.jdesktop.swingx.JXDatePicker;
import com.example.du.swing.DAO.Employee;

public class SwingInterface {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame("Database operations");
		mainFrame.setSize(400, 400);

		JPanel panel = new JPanel(new GridBagLayout());
		mainFrame.add(panel, BorderLayout.NORTH);

		JLabel operationLabel = new JLabel("Select operations:");

		operationLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(operationLabel, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		panel.add(createAddEmpButton(), new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		panel.add(createFindEmpButton(), new GridBagConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		panel.add(createShowLastTenEmpButton(), new GridBagConstraints(0, 3, 1, 1, 0, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		panel.add(createDeleteEmpButton(), new GridBagConstraints(0, 4, 1, 1, 0, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		mainFrame.setVisible(true);
	}

	private static JButton createAddEmpButton() {
		JButton button1 = new JButton();
		button1.setAction(new AbstractAction() {

			private static final long serialVersionUID = -1467004304193846541L;

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				frame.setSize(300, 300);
				frame.setVisible(true);

				JPanel panel = new JPanel(new GridBagLayout());
				frame.add(panel, BorderLayout.NORTH);

				JLabel titleLabel = new JLabel("Enter employee data:");
				titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

				panel.add(titleLabel, new GridBagConstraints(0, 0, 2, 1, 2, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelFirstName = new JLabel("First name: ");
				panel.add(labelFirstName, new GridBagConstraints(0, 1, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelLastName = new JLabel("Last name: ");
				panel.add(labelLastName, new GridBagConstraints(0, 2, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelBirthDate = new JLabel("Birth date: ");
				panel.add(labelBirthDate, new GridBagConstraints(0, 3, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelHireDate = new JLabel("Hire date: ");
				panel.add(labelHireDate, new GridBagConstraints(0, 4, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JTextField textFirstName = new JTextField();
				panel.add(textFirstName, new GridBagConstraints(1, 1, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
				// Pattern firstNamePattern = Pattern.compile("[A-Z][a-z]*");
				// Matcher m = firstNamePattern.matcher(textFirstName.getText());
				// while(m.find())
				// m.group()

				JTextField textLastName = new JTextField();
				panel.add(textLastName, new GridBagConstraints(1, 2, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JXDatePicker birthDatePicker = new JXDatePicker();
				birthDatePicker.setFormats(new SimpleDateFormat("yyyy-MM-dd"));

				// JTextField textBirthDate = new JTextField();
				panel.add(birthDatePicker, new GridBagConstraints(1, 3, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JXDatePicker hireDatePicker = new JXDatePicker();
				hireDatePicker.setFormats(new SimpleDateFormat("yyyy-MM-dd"));

				// JTextField textHireDate = new JTextField();
				panel.add(hireDatePicker, new GridBagConstraints(1, 4, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JButton button = new JButton();
				button.setAction(new AbstractAction() {

					private static final long serialVersionUID = -4831993337779811290L;

					@Override
					public void actionPerformed(ActionEvent e) {

						if (!textFirstName.getText().matches("[A-Z][a-z]*")) {
							JOptionPane.showMessageDialog(frame, "Incorect first name field content!",
									"Ooops, wrong data!", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (!textLastName.getText().matches("[A-Z][a-z]*")) {
							JOptionPane.showMessageDialog(frame, "Incorect last name field content!",
									"Ooops, wrong data!", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (birthDatePicker.getDate() == null) {
							JOptionPane.showMessageDialog(frame, "Birth date field is empty!", "Ooops, wrong data!",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (hireDatePicker.getDate() == null) {
							JOptionPane.showMessageDialog(frame, "Hire date field is empty!", "Ooops, wrong data!",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						Employee emp = new Employee(new Date(birthDatePicker.getDate().getTime()),
								textFirstName.getText(), textLastName.getText(),
								new Date(hireDatePicker.getDate().getTime()));
						boolean result = DAO.addEmployee(emp);

						if (result)
							JOptionPane.showMessageDialog(frame, "Employee added to database!", "Success!",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(frame, "Employee wasn't added to database.", "Error!",
									JOptionPane.ERROR_MESSAGE);

						frame.dispose();
					}
				});
				button.setText("Execute");
				panel.add(button, new GridBagConstraints(0, 5, 2, 1, 2, 1, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			}
		});
		button1.setText("Add employee to database");
		return button1;
	}

	private static JButton createFindEmpButton() {
		JButton button2 = new JButton();
		button2.setAction(new AbstractAction() {

			private static final long serialVersionUID = 2384852097620279383L;

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				frame.setSize(400, 400);
				frame.setVisible(true);

				JPanel panel = new JPanel(new GridBagLayout());
				frame.add(panel, BorderLayout.NORTH);

				JLabel titleLabel = new JLabel("Enter employee number:");
				titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
				panel.add(titleLabel, new GridBagConstraints(0, 0, 2, 1, 2, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelEmpNo = new JLabel("Employee number: ");
				panel.add(labelEmpNo, new GridBagConstraints(0, 1, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JTextField textEmpNo = new JTextField();
				panel.add(textEmpNo, new GridBagConstraints(1, 1, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JButton buttonFind = new JButton();

				panel.add(buttonFind, new GridBagConstraints(0, 2, 2, 1, 2, 1, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelData = new JLabel("Enter data to update:");
				labelData.setFont(new Font("Arial", Font.BOLD, 16));
				panel.add(labelData, new GridBagConstraints(0, 3, 2, 1, 2, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelFirstName = new JLabel("First name: ");
				panel.add(labelFirstName, new GridBagConstraints(0, 4, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelLastName = new JLabel("Last name: ");
				panel.add(labelLastName, new GridBagConstraints(0, 5, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelBirthDate = new JLabel("Birth date: ");
				panel.add(labelBirthDate, new GridBagConstraints(0, 6, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelHireDate = new JLabel("Hire date: ");
				panel.add(labelHireDate, new GridBagConstraints(0, 7, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JTextField textFirstName = new JTextField();
				panel.add(textFirstName, new GridBagConstraints(1, 4, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JTextField textLastName = new JTextField();
				panel.add(textLastName, new GridBagConstraints(1, 5, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JXDatePicker birthDatePicker = new JXDatePicker();
				birthDatePicker.setFormats(new SimpleDateFormat("yyyy-MM-dd"));

				// JTextField textBirthDate = new JTextField();
				panel.add(birthDatePicker, new GridBagConstraints(1, 6, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JXDatePicker hireDatePicker = new JXDatePicker();
				hireDatePicker.setFormats(new SimpleDateFormat("yyyy-MM-dd"));

				// JTextField textHireDate = new JTextField();
				panel.add(hireDatePicker, new GridBagConstraints(1, 7, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				buttonFind.setAction(new AbstractAction() {

					private static final long serialVersionUID = 2722903688417476971L;

					@Override
					public void actionPerformed(ActionEvent e) {

						if (!textEmpNo.getText().matches("\\d{1,6}")) {
							JOptionPane.showMessageDialog(frame, "Employee number is incorrect!", "Ooops, wrong data!",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (Integer.parseInt(textEmpNo.getText()) < 10001) {
							JOptionPane.showMessageDialog(frame,
									"Employee number out of range!\nFirst employee number in database is: 10001",
									"Ooops, wrong data!", JOptionPane.ERROR_MESSAGE);
							return;
						}

						Integer lastEmpNo = DAO.getLastEmpNo();
						if (lastEmpNo != null && Integer.parseInt(textEmpNo.getText()) > lastEmpNo) {
							JOptionPane.showMessageDialog(frame,
									"Employee number out of range!\nLast employee number in database is: " + lastEmpNo,
									"Ooops, wrong data!", JOptionPane.ERROR_MESSAGE);
							return;
						}

						Employee emp = DAO.getEmployeeByNo(Integer.valueOf(textEmpNo.getText()));
						if (emp != null) {
							birthDatePicker.setDate(emp.birthDate);
							textFirstName.setText(emp.firstName);
							textLastName.setText(emp.lastName);
							hireDatePicker.setDate(emp.hireDate);
						} else {
							JOptionPane.showMessageDialog(frame, "Unable to get employee data.", "Error!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				buttonFind.setText("Find");

				JButton button = new JButton();
				button.setAction(new AbstractAction() {

					private static final long serialVersionUID = 862243110497641633L;

					@Override
					public void actionPerformed(ActionEvent e) {

						if (!textFirstName.getText().matches("[A-Z][a-z]*")) {
							JOptionPane.showMessageDialog(frame, "Incorect first name field content!",
									"Ooops, wrong data!", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (!textLastName.getText().matches("[A-Z][a-z]*")) {
							JOptionPane.showMessageDialog(frame, "Incorect last name field content!",
									"Ooops, wrong data!", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (birthDatePicker.getDate() == null) {
							JOptionPane.showMessageDialog(frame, "Birth date field is empty!", "Ooops, wrong data!",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (hireDatePicker.getDate() == null) {
							JOptionPane.showMessageDialog(frame, "Hire date field is empty!", "Ooops, wrong data!",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						Employee emp = new Employee(Integer.valueOf(textEmpNo.getText()),
								new Date(birthDatePicker.getDate().getTime()), textFirstName.getText(),
								textLastName.getText(), new Date(hireDatePicker.getDate().getTime()));
						DAO.updateEmployee(emp);

						JOptionPane.showMessageDialog(frame, "Employee updated!", "Success!",
								JOptionPane.INFORMATION_MESSAGE);

						frame.dispose();
					}
				});
				button.setText("Update");
				panel.add(button, new GridBagConstraints(0, 8, 2, 1, 2, 1, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			}
		});
		button2.setText("Find and edit employee");
		return button2;
	}

	private static JButton createShowLastTenEmpButton() {
		JButton button3 = new JButton();
		button3.setAction(new AbstractAction() {

			private static final long serialVersionUID = -603763493698141714L;

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				frame.setSize(300, 600);
				frame.setVisible(true);

				JPanel panel = new JPanel(new GridBagLayout());
				frame.add(panel, BorderLayout.NORTH);

				JLabel titleLabel = new JLabel("Last 10 employees in database:");
				titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

				panel.add(titleLabel, new GridBagConstraints(0, 0, 2, 1, 2, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				if (DAO.printLastTenEmployees() != null) {
					JTextArea textArea = new JTextArea(DAO.printLastTenEmployees());
					JScrollPane scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
							ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setPreferredSize(new Dimension(250, 500));
					panel.add(scrollPane, new GridBagConstraints(0, 1, 2, 1, 2, 1, GridBagConstraints.WEST,
							GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
				} else {
					JOptionPane.showMessageDialog(frame, "Unable to show employees!", "Error!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button3.setText("Show last 10 employees with salaries");
		return button3;
	}

	private static JButton createDeleteEmpButton() {
		JButton button4 = new JButton();
		button4.setAction(new AbstractAction() {

			private static final long serialVersionUID = 2772810078457348094L;

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				frame.setSize(300, 300);
				frame.setVisible(true);

				JPanel panel = new JPanel(new GridBagLayout());
				frame.add(panel, BorderLayout.NORTH);

				JLabel titleLabel = new JLabel("Enter employee you want to delete:");
				titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

				panel.add(titleLabel, new GridBagConstraints(0, 0, 2, 1, 2, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JLabel labelEmployeeNumber = new JLabel("Employee number: ");
				panel.add(labelEmployeeNumber, new GridBagConstraints(0, 1, 1, 1, 2, 1, GridBagConstraints.EAST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

				JTextField textEmployeeNumber = new JTextField();
				panel.add(textEmployeeNumber, new GridBagConstraints(1, 1, 1, 1, 15, 1, GridBagConstraints.WEST,
						GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

				JButton button = new JButton();
				button.setAction(new AbstractAction() {

					private static final long serialVersionUID = -1479019990637342762L;

					@Override
					public void actionPerformed(ActionEvent e) {

						if (!textEmployeeNumber.getText().matches("\\d{1,6}")) {
							JOptionPane.showMessageDialog(frame, "Employee number is incorrect!", "Ooops, wrong data!",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (Integer.parseInt(textEmployeeNumber.getText()) < 10001) {
							JOptionPane.showMessageDialog(frame,
									"Employee number out of range!\nFirst employee number in database is: 10001",
									"Ooops, wrong data!", JOptionPane.ERROR_MESSAGE);
							return;
						}
						Integer lastEmpNo = DAO.getLastEmpNo();
						if (lastEmpNo != null && Integer.parseInt(textEmployeeNumber.getText()) > lastEmpNo) {
							JOptionPane.showMessageDialog(frame,
									"Employee number out of range!\nLast employee number in database is: " + lastEmpNo,
									"Ooops, wrong data!", JOptionPane.ERROR_MESSAGE);
							return;
						}

						boolean result = DAO.deleteEmployee(Integer.valueOf(textEmployeeNumber.getText()));

						if (result)
							JOptionPane.showMessageDialog(frame, "Employee deleted from database!", "Success!",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(frame, "Employee not deleted from database!", "Error!",
									JOptionPane.ERROR_MESSAGE);

						frame.dispose();
					}
				});
				button.setText("Execute");
				panel.add(button, new GridBagConstraints(0, 5, 2, 1, 2, 1, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			}
		});
		button4.setText("Delete employee from database");
		return button4;
	}

}