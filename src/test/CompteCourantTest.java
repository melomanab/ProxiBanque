package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import domaine.CompteCourant;
/**
 * @author User HEDI Ines, MORENO Beatriz
 * 
 *  La classe compteCourantTest pour tester les methodes de la classe Compte Courant.       
 *
 */

public class CompteCourantTest {
/**
 * 
 *  Declaration d'une variable nommee compte de type CompteCourant     
 *
 */
	private CompteCourant compte;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(">>>Tests Compte Courant");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tests Compte Courant completés<<<");
	}
/**
 * 
 *  Methode qui instancie un compte courant d'un solde de 1000 euros avant chaque test.
 *
 */	
	@Before
	public void setUp() throws Exception {
		compte = new CompteCourant();
		compte.setSolde(1000);
	}
/**
 * 
 *  Methode qui verifie dans un premier temps que l'on peut crediter 100 euros du compte courant puis que le solde est bien de 1100 euro si on ajoute 0 euro
 *
 */	
	
	// @Ignore
	@Test
	public void crediterTest() {
		assertEquals(true, compte.crediter(100));
		assertEquals(1100, compte.getSolde(),0);
	}
/**
 * 
 *  Methode qui verifie dans un premier temps que l'on peut debiter 100 euros du compte courant puis que le solde est bien de 900 euro si on ajoute 0 euro
 *
 */

	@Test
	public void debiterTest() {
		assertEquals(true, compte.debiter(100));
		assertEquals(900, compte.getSolde(),0);
	}
/**
 * 
 *  Methode qui verifie dans un premier temps que l'on peut debiter 1100 euros du compte courant puis que le solde est bien de -100 euro si on ajoute 0 euro
 *
 */
	@Test
	public void debiterAvecDecouvertTest() {
		assertEquals(true,compte.debiter(1100));
		assertEquals(-100, compte.getSolde(),0);
	}
/**
 * 
 *  Methode qui verifie dans un premier temps que l'on peut pas debiter 3000 euros du compte courant puis que le solde est bien de 1000 euro si on ajoute 0 euro
 *
 */
		
	@Test
	public void debiterDecouvertDepaseTest() {
		assertEquals(false,compte.debiter(3000));
		assertEquals(1000, compte.getSolde(),0);
	}
}
