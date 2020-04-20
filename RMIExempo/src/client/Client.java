package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.edu.ifrn.diatinf.tads.psd.rmi.helloworld.HelloWorld;

public class Client {

	public static void main(String[] args) {
		String name = "Helloworld";
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("localhost");
			HelloWorld hello = (HelloWorld) registry.lookup(name);
			String s = hello.sayHello();
			System.out.println("Mensagem do servidor: " + s);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
