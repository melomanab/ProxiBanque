package lanceur;

// import java.text.SimpleDateFormat;
// import java.util.Date;
// import domaine.CompteBancaire;
import java.util.ArrayList;
import java.util.Scanner;
import domaine.Client;
import domaine.ConseillerClientele;
import service.IOperationsBancaires;
import service.ServiceGestionClientele;
import service.ServiceGestionPatrimoine;
import service.ServiceVirement;

/**
 * @author MORENO Beatriz, HEDI Ines
 *
 */

public class DemoProxiBanque {


	/**
	 * @param args
	 * Methode de lancement du programme 
	 */
	
	public static void main(String[] args) {

		// --------------------------------
		// ---Declaration
		// --------------------------------
		ConseillerClientele conseiller;
		ServiceGestionClientele servGestClientele;
		ServiceVirement servVirement;
		ServiceGestionPatrimoine servPatrimoine;

		// --------------------------------
		// ---Instanciation
		// --------------------------------
		conseiller = new ConseillerClientele("MBIANDOU", "Douglas");
		servGestClientele = new ServiceGestionClientele();
		servVirement = new ServiceVirement();
		servPatrimoine = new ServiceGestionPatrimoine();
		
		// --------------------------------
		// Utilisation
		// --------------------------------

		// --- Menu principal
		System.out.println(">>> Bienvenue sur Système d'Information ProxiBanque, la banque proche de ses clients <<<");

		// --- Simulation BD clients: charger une liste de clients ----
		ArrayList<Client> listeClients;
		listeClients = servGestClientele.chargerClientele();
		conseiller.setListeClients(listeClients);
		
		// Rajouter 800.000 euros sur compte courant de Beatriz
		conseiller.getListeClients().get(0).getcEpargne().setSolde(800000);
		// Rajouter 1.000.000 euros sur compte courant de Ines
		conseiller.getListeClients().get(1).getcEpargne().setSolde(1000000);
		
		System.out.println(conseiller);
		// --- // --- // --- // --- // --- // --- // --- // --- // --- 
		
		Scanner scan = new Scanner(System.in);
		String reponse;
		do {			
			int selectionMenu;
			//do {
				System.out.println(">>> A quel service souhaitez-vous acceder?:");
				System.out.println("0-Afficher la liste de clients\n" +"1-Creer un client\n" + "2-Modifier les informations d'un client\n"
					+ "3-Lire les informations d'un client\n" + "4-Supprimer un client\n"
					+ "5-Faire un virement compte à compte\n" + "6-Proposer des placements (service reservé aux clients fortunés)\n" + 
					  "7-Quitter");
				selectionMenu = Integer.parseInt(scan.nextLine());
			//} while ((selectionMenu<0)|(selectionMenu>6));
			
			switch (selectionMenu) {
			case 0:
				System.out.println(conseiller);
				break;
			case 1:
				servGestClientele.creerClient(conseiller);
				break;
			case 2:
				servGestClientele.modifierClient(conseiller);
				break;
			case 3:
				servGestClientele.afficherClient(conseiller);
				break;
			case 4:
				servGestClientele.supprimerClient(conseiller);
				break;
			case 5:
				System.out.println(servVirement.demandeVirement(conseiller));
				IOperationsBancaires compteEmetteur = servVirement.getCompteEmmeteur();
				IOperationsBancaires compteBeneficiaire = servVirement.getCompteBeneficiaire();
				double montant = servVirement.getMontant();
				servVirement.virement(compteEmetteur, compteBeneficiaire, montant);
				break;
			case 6:
				servPatrimoine.calculPatrimoineClientele(conseiller);
				System.out.println(servPatrimoine.propositionsPlacements(conseiller));
				break;
			case 7:
				break;
			default:
				System.out.println("Selection invalide");
			}

			do
			{
				System.out.println("Souhaitez-vous effectuer d'autres operations?: <O/N>");
				reponse = scan.nextLine();
			}
			while ((!reponse.equals("O"))&&(!reponse.equals("N")));

		} while (reponse.equals("O"));
		System.out.println("Merci d'avoir utilisé nos services. Au revoir!");
		scan.close();

/*
		// --- Service gestion clientele
		// System.out.println(">>> Service gestion clientele");
		// servGestClientele.supprimerClient(conseiller);
		// servGestClientele.creerClient(conseiller);
		// servGestClientele.modifierClient(conseiller);
		servGestClientele.afficherClient(conseiller);

		// --- Service virements
		// Rajouter 10.000 euros sur compte courant de Beatriz
		conseiller.getListeClients().get(0).getcCourant().setSolde(10000);

		System.out.println(servVirement.demandeVirement(conseiller));
		IOperationsBancaires compteEmetteur = servVirement.getCompteEmmeteur();
		IOperationsBancaires compteBeneficiaire = servVirement.getCompteBeneficiaire();
		double montant = servVirement.getMontant();
		servVirement.virement(compteEmetteur, compteBeneficiaire, montant);

		// // Test compte courant
		// client.getcCourant().crediter(10000);
		// System.out.println(client);
		// System.out.println(client.infosComptes());
		//
		// client.getcCourant().debiter(200);
		// System.out.println(client);
		// System.out.println(client.infosComptes());
		//
		// client.getcCourant().debiter(10800);
		// System.out.println(client);
		// System.out.println(client.infosComptes());
		//
		// client.getcCourant().debiter(1);
		// System.out.println(client);
		// System.out.println(client.infosComptes());
		//
		// // Test compte epargne
		// client.getcEpargne().crediter(10000);
		// System.out.println(client);
		// System.out.println(client.infosComptes());
		//
		// client.getcEpargne().debiter(200.25);
		// System.out.println(client);
		// System.out.println(client.infosComptes());
		//
		// client.getcEpargne().debiter(100000);
		// System.out.println(client);
		// System.out.println(client.infosComptes());
*/
	}

}
