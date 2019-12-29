package com.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import com.rmi.beans.Employee;
import com.rmi.remote.ICompanyDetails;

public class GetCompanyDetails {

  public static void main(String[] args) {
    try {
      ICompanyDetails companyDetails = (ICompanyDetails) Naming.lookup("rmi://localhost:5001/companyDetails");
      List<Employee> employeeList = companyDetails.getEmployeeDetails();
      for (Employee employee : employeeList) {
        System.out.println(employee);
      }
    } catch (MalformedURLException | RemoteException | NotBoundException e) {
      e.printStackTrace();
    }
  }
}
