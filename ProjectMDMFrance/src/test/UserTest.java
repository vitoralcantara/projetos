package test;

import static org.junit.Assert.*;

import model.User;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUserStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserStringStringStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsConnected() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetConnected() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetroleApps() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckInformationUser() {
		User u = new User();
		boolean res;
		String login;
		String mail;
		
		//cas ou utilisateur present dans la base
		res=false;
		login="loginquiexiste";
		mail="mailquiexiste";
		if(res != u.checkInformationUser(login, mail))
		fail("les2existent");

		//cas ou utilisateur present dans la base
		res=false;
		login="loginquiexiste";
		mail="mailquiexistepas";
		if(res != u.checkInformationUser(login, mail))
			fail("lelogineexiste ");
		
		//cas ou utilisateur present dans la base
		res=false;
		login="loginquiexistepas";
		mail="mailquiexiste";
		if(res != u.checkInformationUser(login, mail))
			fail("lemaileexiste ");
		
		//cas ou utilisateur non present dans la base
		res=true;
		login="loginquiexistepas";
		mail="mailquiexistepas";
		if(res != u.checkInformationUser(login, mail))
			fail("le2existepas ");
		
	}

	@Test
	public void testLoadUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testSha256() {
		User u = new User();
		String res;
		String pass="motdepasse";
		String passCrypted="967520ae23e8ee14888bae72809031b98398ae4a636773e18fff917d77679334";
		assertEquals(u.sha256(pass),passCrypted);
		}
}
