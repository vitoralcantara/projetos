package rmiknolexample;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * 
 * @author Andre
 */
public class ForumService {
	public static void main(String[] args) {
		try {
			IForum forumObj = new ForumImpl();
			Naming.rebind("forumService", forumObj);
			System.err.println("Rodando");
		} catch (RemoteException e) {
			System.err.println("Ocorreu um erro relativo ao RMI: "
					+ e.getMessage());
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.err.println("Ocorreu um erro desconhecido: "
					+ e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
}