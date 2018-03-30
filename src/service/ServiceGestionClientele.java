package service;

import java.util.ArrayList;
import java.util.Scanner;

import domaine.Client;
import domaine.ConseillerClientele;

/**
 * @author HEDI Ines, MORENO Beatriz
 *
 */
/**
 * La classe service.ServiceGestionClientele represente les services propose pour la gestion de la clientele 
 *
 */
public class ServiceGestionClientele {

	/**
	 * @return 
	 * Methode pour remplir l'attribut listeClients avec les informations de
	 *         9 clients different pour simuler une base de donnée
	 */
	
	public ArrayList<Client> chargerClientele() {

		ArrayList<Client> listeClients = new ArrayList<Client>();

		listeClients.add(new Client("MORENO", "Beatriz", "101 rue Challemel Lacour", "69007", "Lyon", "0638383865"));
		listeClients.add(new Client("HEDI", "Ines", "8bis rue des Martirs", "75020", "Paris", "0782233717"));
		listeClients.add(new Client("MANNOU", "Tarik"));
		listeClients.add(new Client("BOIVIN", "Stephane"));
		listeClients.add(new Client("DEMOLIS", "Alex"));

		listeClients.add(new Client("BATAULT", "Frederic"));
		listeClients.add(new Client("BLONDEL", "Benoit"));
		listeClients.add(new Client("LE PAPE", "Joel"));
		listeClients.add(new Client("SERSOUB", "Nabil"));

		return listeClients;
	}

	/**
	 * @param 
	 * Methode pour ajouter un nouveau client à la liste si cette derniere
	 *            n'a pas atteind la limite imposé et qui ensuite l'affiche
	 */
	public void creerClient(ConseillerClientele monConseiller) {

		ArrayList<Client> listeClients = monConseiller.getListeClients();

		if (listeClients.size() < monConseiller.getMaxClients()) {
			System.out.println("Veuillez saisir le Nom:");

			Scanner scan = new Scanner(System.in);
			String nom = scan.nextLine();

			System.out.println("Veuillez saisir le Prenom:");
			String prenom = scan.nextLine();

			System.out.println("Veuillez saisir l'Adresse:");
			String adresse = scan.nextLine();

			System.out.println("Veuillez saisir le Code Postal:");
			String codePostal = scan.nextLine();

			System.out.println("Veuillez saisir la Ville:");
			String ville = scan.nextLine();

			System.out.println("Veuillez saisir le Telephone:");
			String telephone = scan.nextLine();

			Client nouveauClient = new Client(nom, prenom, adresse, codePostal, ville, telephone);
			listeClients.add(nouveauClient);

			System.out.println(
					nouveauClient.getNom() + " " + nouveauClient.getPrenom() + " vient d'être rajouté à vos clients");
		} else {

			System.out.println("Vous ne pouvez pas rajouter de nouveau client.");
			System.out.println("Vous avez atteint le nombre maximal de clients à votre charge");
		}
	}

	/**
	 * @param monConseiller
	 * Methode pour afficher les informations d'un client choisi. Si le client n'exicte pas on invalide le resultat.
	 */
	public void afficherClient(ConseillerClientele monConseiller) {

		System.out.println("Veuillez selectionner le client que vous souhaitez afficher:");

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

			System.out.println("Voici les informations du client:");

			// TO-DO Afficher informations completes du client
			System.out.println(clientSelectione.infosClient());
			System.out.println(clientSelectione.infosComptes());

		}
	}

	/**
	 * @param monConseiller
	 * Methode pour modifier les informations d'un client choisi puis afficher les nouvelles informations de ce client.
	 */
	public void modifierClient(ConseillerClientele monConseiller) {
		System.out.println("Veuillez selectionner le client que vous souhaitez modifier:");

		ArrayList<Client> listeClients = monConseiller.getListeClients();

		for (int i = 0; i < listeClients.size(); i++) {

			System.out.println(i + "-" + monConseiller.getListeClients().get(i));

		}
		Scanner scan = new Scanner(System.in);
		int selectionClient = Integer.parseInt(scan.nextLine());

		
		if (selectionClient >= listeClients.size()) {
			System.out.println("Selection invalide");

		} else {

			Client clientSelectione = monConseiller.getListeClients().get(selectionClient);

			System.out.println("Vous avez selectionne le client:" + clientSelectione);
			String reponse = "O";

			do {
				System.out.println("Veuillez selectionner le champ que vous souhaitez modifier:");

				
				System.out.println("0-Nom" + "\n" + "1-Prenom" + "\n" + "2-Adresse" + "\n" + "3-Code Postal" + "\n"
						+ "4-Ville" + "\n" + "5-Telephone");

				int selectionPropriete = Integer.parseInt(scan.nextLine());

				switch (selectionPropriete) {
				case 0:
					System.out.println("Introduisez un nouveau Nom:");
					String nom = scan.nextLine();
					clientSelectione.setNom(nom);
					break;
				case 1:
					System.out.println("Introduisez un nouveau Prenom:");
					String prenom = scan.nextLine();
					clientSelectione.setPrenom(prenom);
					break;
				case 2:
					System.out.println("Introduisez une nouvelle Adresse:");
					String adresse = scan.nextLine();
					clientSelectione.setAdresse(adresse);
					break;
				case 3:
					System.out.println("Introduisez un nouveau Code Postal:");
					String codePostal = scan.nextLine();
					clientSelectione.setCodePostal(codePostal);
					break;
				case 4:
					System.out.println("Introduisez une nouvelle Ville:");
					String ville = scan.nextLine();
					clientSelectione.setVille(ville);
					break;
				case 5:
					System.out.println("Introduisez un nouveau Telephone:");
					String telephone = scan.nextLine();
					clientSelectione.setTelephone(telephone);
					break;
				default:
					System.out.println("Selection invalide");

				}
				System.out.println("Voulez vous poursuivre les modifications sur ce client?: <O/N>");
				reponse = scan.nextLine();

			} while (reponse.equals("O"));

			System.out.println("Nouvelles informations du client:\n" + clientSelectione.infosClient() + "\n"
					+ clientSelectione.infosComptes());
		}
	}

	/**
	 * @param monConseiller
	 * Methode pour supprimer toutes les informations d'un client choisi (avec les comptes)
	 */
	public void supprimerClient(ConseillerClientele monConseiller) {

		ArrayList<Client> listeClients = monConseiller.getListeClients();

		
		if (listeClients.isEmpty()) {
			System.out.println("Vous ne pouvez pas supprimer de client." + " Votre liste de clients est vide.  ");
		} else {

			System.out.println("Veuillez selectionner le client que vous souhaitez supprimer:");

			for (int i = 0; i < listeClients.size(); i++) {

				System.out.println(i + "-" + monConseiller.getListeClients().get(i));

			}
			Scanner scan = new Scanner(System.in);
			int selectionClient = Integer.parseInt(scan.nextLine());

	
			if (selectionClient >= listeClients.size()) {
				System.out.println("Selection invalide");

			} else {

				Client clientSelectione = monConseiller.getListeClients().get(selectionClient);

				System.out.println("Vous avez selectionné le client suivant:" + clientSelectione);
				System.out.println("Etes-vous sur de vouloir le supprimer? <O/N>");
				String reponse = scan.nextLine();

				if (reponse.equals("O")) {
					System.out.println("Le client " + clientSelectione + " vient d'etre supprimé");
					listeClients.remove(clientSelectione);
				}

			}
		}
	}

}
