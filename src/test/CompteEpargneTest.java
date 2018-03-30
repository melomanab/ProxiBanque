package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domaine.CompteCourant;
import domaine.CompteEpargne;
/**
 * @author User HEDI Ines, MORENO Beatriz
 * 
 *  La classe compteEpargneTest permet de tester les methode de la classe Compte Epargne.       
 *
 */
public class CompteEpargneTest {
	
	private CompteEpargne compte;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(">>>Tests Compte Epargne");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tests Compte Epargne completés<<<");
	}
/**
 * 
 *  Methode qui instancie un compte epargne d'un solde de 1000 euros avant chaque test.
 *
 */
	@Before
	public void setUp() throws Exception {
		compte = new CompteEpargne();
		compte.setSolde(1000);
	}
/**
 * 
 *  Methode qui verifie dans un premier temps que l'on peut crediter 100 euros du compte epargne puis que le solde est bien de 1100 euro si on ajoute 0 euro
 *
 */	

	@Test
	public void crediterTest() {
		assertEquals(true, compte.crediter(100));
		assertEquals(1100, compte.getSolde(),0);
	}
/**
 * 
 *  Methode qui verifie dans un premier temps que l'on peut debiter 100 euros du compte epargne puis que le solde est bien de 900 euro si on ajoute 0 euro
 *
 */

	@Test
	public void debiterTest() {
		assertEquals(true, compte.debiter(100));
		assertEquals(900, compte.getSolde(),0);
	}

/**
 * 
 *  Methode qui verifie dans un premier temps que l'on peut pas debiter 1001 euros du compte epargne puis que le solde est bien de 1000 euro si on ajoute 0 euro
 *
 */	
	@Test
	public void debiterSoldeInsuffisantTest() {
		assertEquals(false,compte.debiter(1001));
		assertEquals(1000, compte.getSolde(),0);
	}

}
