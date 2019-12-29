package com.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import com.rmi.beans.Employee;

public interface ICompanyDetails extends Remote {

  public List<Employee> getEmployeeDetails() throws RemoteException;
}
