package phase1.Controllers;

import phase1.Main;
import phase1.models.Filiere;
import phase1.services.DB;
import phase1.services.FiliereServices;
import phase1.Controllers.DepartementContreller;
import phase1.services.EnseignantServices;

public class FiliereController {


    public static void showMenu(){
        System.out.println("-------------------------[ Filieres ]---------------------------");


        System.out.println("1: Pour ajouter un filiere");
        System.out.println("2: Pour afficher les filieres");
        System.out.println("3: Pour modifier un filiere");
        System.out.println("4: Pour supprimer un filiere");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFiliere();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showFiliere(){
        for (Filiere filiere : DB.filieres) {
            System.out.print("Id : " + filiere.getId());
            System.out.print(" | Intitulé : " + filiere.getIntitule());
            if (! Main.isNull(filiere.getChef())) {
                System.out.print(" | Chef : " + filiere.getChef().getNom() + " " + filiere.getChef().getPrenom());
            }
            System.out.println("");
        }

    }
    public static void createFiliere(){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        DepartementContreller.showDepartements();
        int id = Main.getIntInput("Sélecionnez un Filiere par id :");
        FiliereServices.addFiliere(intitule, EnseignantServices.getEnsById(id));

        showFiliere();
        showMenu();


    }
    public static void editFiliere(){
        showFiliere();
        int id = Main.getIntInput("Sélecionnez un filiere par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        DepartementContreller.showDepartements();
        int idDept = Main.getIntInput("Sélecionnez un departement par id :");

        FiliereServices.updateFiliere(id, intitule, EnseignantServices.getEnsById(id));

        showFiliere();
        showMenu();
    }
    public static void destroyFiliere(){
        showFiliere();
        int id = Main.getIntInput("Sélecionnez un filire par id :");
        FiliereServices.deleteFiliereById(id);
        showFiliere();

    }

    public static void showFilieres() {
    }
}






































