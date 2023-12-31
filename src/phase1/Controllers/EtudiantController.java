package phase1.Controllers;

import phase1.Main;
import phase1.models.Etudiant;
import phase1.services.DB;
import phase1.services.EtudiantServices;
import phase1.services.FiliereServices;
import phase1.Controllers.FiliereController;

public class EtudiantController {


    public static void showMenu(){
        System.out.println("-------------------------[ Etudiants ]---------------------------");


        System.out.println("1: Pour ajouter un etudeant");
        System.out.println("2: Pour afficher les etudiants");
        System.out.println("3: Pour modifier un etudiants");
        System.out.println("4: Pour supprimer un etudiants");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiant();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showEtudiant(){
        for (Etudiant etudiant : DB.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | nom : " + etudiant.getNom());
            System.out.print(" |prenom : " + etudiant.getPrenom());
            System.out.print(" |apogee : " + etudiant.getApogee());
            System.out.print(" |email : " + etudiant.getEmail());
            System.out.println("");
        }

    }
    public static void createEtudiant(){
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String apogee = Main.getStringInput("Entrez le code apogee :");
        String email = Main.getStringInput("Entrez le email:");
        FiliereController.showFilieres();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        EtudiantServices.addEtd(nom, FiliereServices.getFiliereById(id));

        showEtudiant();
        showMenu();


    }
    public static void editEtudiant(){
        showEtudiant();
        int id = Main.getIntInput("Sélecionnez un etudiantt par id :");
        String nom = Main.getStringInput("Entrezle nom :");

        int idEtd = Main.getIntInput("Sélecionnez un etudiant par id :");

        EtudiantServices.updateEtd(id, FiliereServices.getFiliereById(id));

        showEtudiant();
        showMenu();
    }
    public static void destroyEtudiant(){
        showEtudiant();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        EtudiantServices.deleteEtdById(id);
        showEtudiant();

    }
}


