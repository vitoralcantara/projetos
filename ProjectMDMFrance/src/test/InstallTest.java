package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Install;

import org.junit.Test;

public class InstallTest {

		private Install install;
		
	@Test
	public void testSaveInfoDB() {
		// test cas d'utilisation normal
		Install.saveInfoDB("Une Adresse","Mot de passe");
		// test dans le cas ou un des 2 champs est vide retourne null
		Install.saveInfoDB("Une Adresse Empty 1","");
		System.out.println("adresse : "+Install.getAddressDB() +"   mdp : "+Install.getPasswdDB());
		Install.saveInfoDB("","Mot de passe Empty 2");
		//Test des diff�rents caract�res sp�ciaux, les \ et " sont interdits 
		System.out.println("adresse : "+Install.getAddressDB() +"   mdp : "+Install.getPasswdDB());
		Install.saveInfoDB("&�(-�_��)='1234567890�+^$*�!:;,���%�/.?,;:!�}]@^`|[{#&~�","&�(-�_��)='1234567890�+^$*�!:;,���%�/.?,;:!�}]@^`|[{#&~�");
		fail("Not yet implemented");
	}

	@Test
	public void testGetPasswdDB() {
		// Test du cas normal
		Install.saveInfoDB("Une Adresse","Mot de passe");
		System.out.println("Le mot de passe stock� dans infoDB.txt est : "+Install.getPasswdDB());
		// Test du cas vide, retourne null
		Install.saveInfoDB("Une Adresse","");
		System.out.println("Le mot de passe stock� dans infoDB.txt est : "+Install.getPasswdDB());
		//Test des diff�rents caract�res sp�ciaux, les \ et " sont interdits 
		Install.saveInfoDB("Une Adresse","&�(-�_��)='1234567890�+^$*�!:;,���%�/.?,;:!�}]@^`|[{#&~�");
				System.out.println("Le mot de passe stock� dans infoDB.txt est : "+Install.getPasswdDB());
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddressDB() {
		// Test du cas normal
		Install.saveInfoDB("Une Adresse","Mot de passe");
		System.out.println("L'adresse stock�e dans infoDB.txt est : "+Install.getAddressDB());
		fail("Not yet implemented");
		// Test du cas vide, retourne null
		Install.saveInfoDB("","Un mot de passe");
		System.out.println("L'adresse dans infoDB.txt est : "+Install.getPasswdDB());
		//Test des diff�rents caract�res sp�ciaux, les \ et " sont interdits 
		Install.saveInfoDB("&�(-�_��)='1234567890�+^$*�!:;,���%�/.?,;:!�}]@^`|[{#&~�","Un mot de passe");
		System.out.println("L'adresse stock�e dans infoDB.txt est : "+Install.getPasswdDB());
		fail("Not yet implemented");
		
	}

	@Test
	public void testInitDB() {		
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllNature() {
		Install install = new Install(); 
		ArrayList<int> natureArray = new ArrayList<int>(); 
		
	   
		
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllNatureWithoutResp() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllNatureWithoutTuteur() {
		fail("Not yet implemented");
	}

	@Test
	public void passwordVerification() {
		Install inst = new Install();
		String pswd;
		int ret;
		
		pswd="azAZ09";
		ret=0;
		assertTrue("pswd correct",inst.passwordVerification(pswd)==ret);
		pswd="azAZ09bcdFGHIJK234";
		ret=0;
		assertTrue("pswd correct",inst.passwordVerification(pswd)==ret);
		
		pswd="azAZ0";
		ret=1;
		assertTrue("pswd trop court",inst.passwordVerification(pswd)==ret);
		pswd="";
		ret=1;
		assertTrue("pswd trop court",inst.passwordVerification(pswd)==ret);
		
		pswd="azAZ09bcdFGHIJK2345";
		ret=2;
		assertTrue("pswd trop long",inst.passwordVerification(pswd)==ret);
		
		pswd="aaaaaaaaaaa-";
		ret=3;
		assertTrue("caractere incorrecte",inst.passwordVerification(pswd)==ret);
		pswd="aaaaaaaaaaa_";
		ret=3;
		assertTrue("caractere incorrecte",inst.passwordVerification(pswd)==ret);
		pswd="aaaaaaaaaaa/";
		ret=3;
		assertTrue("caractere incorrecte",inst.passwordVerification(pswd)==ret);
		pswd="aaaaaaaaaaa\\";
		ret=3;
		assertTrue("caractere incorrecte",inst.passwordVerification(pswd)==ret);
		pswd="aaaaaaaaaaa!";
		ret=3;
		assertTrue("caractere incorrecte",inst.passwordVerification(pswd)==ret);
		pswd="aaaaaaaaaaa;";
		ret=3;
		assertTrue("caractere incorrecte",inst.passwordVerification(pswd)==ret);
		
		pswd=null;
		ret=4;
		assertTrue("caractere incorrecte",inst.passwordVerification(pswd)==ret);
	}
}
