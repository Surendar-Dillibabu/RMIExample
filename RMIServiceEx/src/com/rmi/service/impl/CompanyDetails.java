package com.rmi.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.rmi.beans.Employee;
import com.rmi.remote.ICompanyDetails;

public class CompanyDetails extends UnicastRemoteObject implements ICompanyDetails {

  /**
   * 
  */
  private static final long serialVersionUID = 1L;

  public CompanyDetails() throws RemoteException {
    super();
  }

  @Override
  public List<Employee> getEmployeeDetails() throws RemoteException {
    List<Employee> employeeList = new ArrayList<>();
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      try (
          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "dev_user", "devuser");
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("select * from employee_details");) {

        while (rs.next()) {
          Employee employee = new Employee();
          employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
          employee.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
          employee.setSalary(rs.getLong("SALARY"));
          employee.setDeptId(rs.getInt("DEPT_ID"));
          employee.setJoiningDate(rs.getDate("JOINING_DATE"));
          employeeList.add(employee);
        }
      } catch (SQLException se) {
        se.printStackTrace();
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return employeeList;
  }

}
