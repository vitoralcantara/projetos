package rmiknolexample;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * 
 * @author Andre
 */
public interface IForum extends Remote {
	public void postMessage(String author, String aMessage)
			throws RemoteException;

	public String[] readPosts() throws RemoteException;

	public String[] readPosts(int beginAt) throws RemoteException;
}