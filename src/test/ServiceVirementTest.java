package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import domaine.CompteCourant;
import domaine.CompteEpargne;
import service.IOperationsBancaires;
import service.ServiceVirement;

/**
 * @author User HEDI Ines, MORENO Beatriz
 * 
 *  La classe serviceVirementTest permet de tester les methode de la classe serice virement.       
 *
 */
public class ServiceVirementTest {

	private CompteCourant compteEmmeteur;
	private CompteEpargne compteBeneficiaire;
	private ServiceVirement service;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(">>>Tests Service Virement");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tests Service Virement completés<<<");
	}
/**
 * 
 *	Methode qui instancie un compte courant d'un solde de 1000 euros avant chaque test (compte emeteur).
 *  Methode qui instancie un compte epargne d'un solde de 1000 euros avant chaque test (compte beneficiaire).
 *	
 */
	@Before
	public void setUp() throws Exception {
		compteEmmeteur = new CompteCourant();
		compteEmmeteur.setSolde(1000);
		
		compteBeneficiaire = new CompteEpargne();
		compteBeneficiaire.setSolde(1000);	
		
		service = new ServiceVirement();
	}

/**
 * 
 *  Methode qui verifie que l'on peut debiter 100 euros du compte emeteur vers le compte beneficiaire 
 *
 */
	@Test
	public void virementTest() {
		assertEquals(true, 
				service.virement(compteEmmeteur, compteBeneficiaire, 100));
	}
/**
 * 
 *  Methode qui verifie que l'on peut debiter 1999.99 euros du compte emeteur vers le compte beneficiaire 
 *
 */
	@Test
	public void virementAvecDecouvertTest() {
		assertEquals(true, 
				service.virement(compteEmmeteur, compteBeneficiaire, 1999.99));
	}
/**
 * 
 *  Methode qui verifie que l'on peut pas debiter 2000.01 euros du compte emeteur vers le compte beneficiaire 
 *
 */	
	@Test
	public void virementDecouvertDepaseTest() {
		assertEquals(false, 
				service.virement(compteEmmeteur, compteBeneficiaire, 2000.01));
	}
/**
 * 
 *  Methode qui verifie que l'on peut pas debiter une somme negatif
 *
 */		
	@Test
	public void virementMontantNegatif() {
		assertEquals(false, 
				service.virement(compteEmmeteur, compteBeneficiaire, -100));
	}

}
