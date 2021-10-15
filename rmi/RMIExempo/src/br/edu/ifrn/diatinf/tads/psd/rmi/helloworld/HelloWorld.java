package br.edu.ifrn.diatinf.tads.psd.rmi.helloworld;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWorld extends Remote {

	String sayHello() throws RemoteException;
}
