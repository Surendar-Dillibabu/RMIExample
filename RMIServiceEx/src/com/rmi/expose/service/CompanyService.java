package com.rmi.expose.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import com.rmi.service.impl.CompanyDetails;

public class CompanyService {

  public static void main(String[] args) {
    try {
      LocateRegistry.createRegistry(5001);
      Naming.rebind("rmi://localhost:5001/companyDetails", new CompanyDetails());
    } catch (RemoteException | MalformedURLException e) {
      e.printStackTrace();
    }
  }
}
