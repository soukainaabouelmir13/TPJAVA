package phase1.Controllers;

import phase1.Main;
import phase1.models.Module;
import phase1.services.DB;
import phase1.services.ModuleServices;
import phase1.services.FiliereServices;
public class ModuleController {


    private static Object id;

    public static void showMenu(){
        System.out.println("-------------------------[ Modules ]---------------------------");


        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher les  modules");
        System.out.println("3: Pour modifier un  module");
        System.out.println("4: Pour supprimer un  module");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createModule();
                break;
            case 2:
                showModule();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showModule(){
        for (Module module : DB.modules) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitulé : " + module.getIntitule());

            System.out.println("");
        }

    }
    public static void createModule(){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        ModuleServices.addModule( intitule, FiliereServices.getFiliereById(id));

        showModule();
        showMenu();


    }
    public static void editModule(){
        showModule();
        int id = Main.getIntInput("Sélecionnez un module par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        ModuleServices.addModule(id, intitule, FiliereServices.getFiliereById(id));

        showModule();
        showMenu();
    }
    public static void destroyModule(){
        showModule();
        int id = Main.getIntInput("Sélecionnez un module par id :");
        ModuleServices.deleteModuleById(id);
        showModule();

    }
}


