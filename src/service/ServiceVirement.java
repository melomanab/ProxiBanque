package service;

import java.util.ArrayList;
import java.util.Scanner;

import domaine.Client;
import domaine.ConseillerClientele;
/**
 * @author HEDI Ines, MORENO Beatriz
 * La classe service.ServiceVirement represente les services propose d'effectuer des virements
 */
public class ServiceVirement {

	private IOperationsBancaires compteEmmeteur;
	private IOperationsBancaires compteBeneficiaire;
	private double montant;
	
	// Getters
	/**
	 * @return
	 * Methode pour recuperer la variable compte emmeteur
	 */
	public IOperationsBancaires getCompteEmmeteur() {
		return compteEmmeteur;
	}

	/**
	 * @return
	 * Methode pour recuperer la variable compte Beneficiaire
	 */
	public IOperationsBancaires getCompteBeneficiaire() {
		return compteBeneficiaire;
	}

	/**
	 * @return
	 * Methode pour recuperer la variable montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * @param monConseiller
	 * @return
	 * Methode pour effectuer un virement entre deux comptes
	 */
	public String demandeVirement(ConseillerClientele monConseiller) {

		// --- Selection compte EMETTEUR
		System.out.println("Veuillez selectionner le client titulaire du compte EMETTEUR: ");

		ArrayList<Client> listeClients = monConseiller.getListeClients();
		for (int i = 0; i < listeClients.size(); i++) {
			System.out.println(i + "-" + monConseiller.getListeClients().get(i));
		}
		Scanner scan = new Scanner(System.in);
		int selectionClient = Integer.parseInt(scan.nextLine());

		// Prevoir selection index de client inexistant
		if (selectionClient >= listeClients.size()) {
			System.out.println("Selection invalide");

		} else {

			Client clientSelectione = monConseiller.getListeClients().get(selectionClient);

			System.out.println("Vous avez selectionne le client:" + clientSelectione);

			System.out.println("Veuillez selectionner le compte EMETTEUR:");

			System.out.println("0-Compte courant: " + clientSelectione.getcCourant().getNumeroCompte() + "\tSolde: "
					+ clientSelectione.getcCourant().getSolde() + "\n" + "1-Compte epargne: "
					+ clientSelectione.getcEpargne().getNumeroCompte() + "\tSolde: "
					+ clientSelectione.getcEpargne().getSolde());

			// La selection de l'utilisateur est convertie en nombre entier
			int selectionCompte = Integer.parseInt(scan.nextLine());

			switch (selectionCompte) {
			case 0:
				this.compteEmmeteur = clientSelectione.getcCourant();
				

				break;
			case 1:
				this.compteEmmeteur = clientSelectione.getcEpargne();
				

				break;
			default:
				System.out.println("Selection invalide");
			}

			// --- Selection MONTANT
			System.out.println("Veuillez selectionner le MONTANT: ");

			this.montant = Integer.parseInt(scan.nextLine());
			

			// --- Selection compte BENEFICIAIRE
			System.out.println("Veuillez selectionner le client titulaire du compte BENEFICIAIRE: ");

			
			for (int i = 0; i < listeClients.size(); i++) {
				System.out.println(i + "-" + monConseiller.getListeClients().get(i));
			}

			
			selectionClient = Integer.parseInt(scan.nextLine());

			// Prevoir selection index de client inexistant
			if (selectionClient >= listeClients.size()) {
				System.out.println("Selection invalide");

			} else {

				clientSelectione = monConseiller.getListeClients().get(selectionClient);

				System.out.println("Vous avez selectionné le client:" + clientSelectione);

				System.out.println("Veuillez selectionner le compte BENEFICIAIRE:");

				System.out.println("0-Compte courant: " + clientSelectione.getcCourant().getNumeroCompte() + "\n"
						+ "1-Compte epargne: " + clientSelectione.getcEpargne().getNumeroCompte());

				// La selection de l'utilisateur est convertie en nombre entier
				selectionCompte = Integer.parseInt(scan.nextLine());

				switch (selectionCompte) {
				case 0:
					this.compteBeneficiaire = clientSelectione.getcCourant();
					
					break;
				case 1:
					this.compteBeneficiaire = clientSelectione.getcEpargne();
					
					break;
				default:
					System.out.println("Selection invalide");
				}

			}
		}

		
		return "Vous venez d'effectuer une demande de virement sur le service Virement de ProxiBanque.\n"
				+ "Voici le récapitulatif de votre demande:\n" + "Virement du compte EMETTEUR: " + this.compteEmmeteur 
				+ "\n" + "vers le compte BENEFICIAIRE: " + this.compteBeneficiaire + "\n" + "d'un MONTANT de: "
				+ "[" + this.montant + " EUR]";
	}

	/**
	 * @param compteEmetteur
	 * @param compteBeneficiaire
	 * @param montant
	 * @return
	 * Methode pour valider le virement si il est autorise par le systeme et afficher les informations de la transaction
	 * si non le virement est refuse
	 */
	public boolean virement(IOperationsBancaires compteEmetteur, IOperationsBancaires compteBeneficiaire,
			double montant) {

		// Le credit est toujours autorisé (pas de plafond)
		boolean debitAutorise;
		
		debitAutorise = compteEmetteur.debiter(montant);
		if (debitAutorise) {
			compteBeneficiaire.crediter(montant);
			System.out.println("Le virement a ete VALIDE."+ "\n" +"Il sera effectue dans les plus brefs delais."+ "\n"+
					// "Voici le récapitulatif de votre virement:\n" + 
					"Solde du compte EMETTEUR aprés virement: " +  this.compteEmmeteur + "\n"+
					"Solde du compte BENEFICIARE aprés virement: " +  this.compteBeneficiaire);
			return true;		
		}
		System.out.println("Le virement a ete REFUSE");
		return false;
	}

}
