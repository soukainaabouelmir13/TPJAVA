package phase1.Controllers;

import phase1.Main;
import phase1.models.Departement;
import phase1.services.DB;
import phase1.services.DepartementServices;
import phase1.services.EnseignantServices;

public class DepartementContreller {


    public static void showMenu(){
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: ajouter un département");
        System.out.println("2: supprimer les départements");
        System.out.println("3:  modifier un département");
        System.out.println("4: afficher un département");
        System.out.println("0:  retourner  un au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez choisir une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                destroyDepartement();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                showDepartements();

                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showDepartements(){
        for (Departement departement : DB.departements) {
            System.out.print("Id : " + departement.getId());
            System.out.print(" | Intitulé : " + departement.getIntitule());
            if (! Main.isNull(departement.getChef())) {
                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
            }
            System.out.println("");
        }

    }
    public static void createDepartement(){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementServices.addDept(intitule, EnseignantServices.getEnsById(id));

        showDepartements();
        showMenu();


    }
    public static void editDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        DepartementServices.deleteDeptById(id);
        showDepartements();

    }
}


