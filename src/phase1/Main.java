package phase1;

import phase1.Controllers.DepartementContreller;
import phase1.models.Enseignant;
import phase1.services.DB;

import java.util.Scanner;

public class Main {

    public static boolean isNull(Object ob) {
        return ob == null ;
    }
    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);


        // This method reads the number provided using keyboard
        int num = scan.nextInt();

        // Closing Scanner after the use
        //  scan.close();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);

        // This method reads the number provided using keyboard
        String str = scan.nextLine();

        // Closing Scanner after the use
        //  scan.close();
        return str;
    }

    public static void showPrincipalMenu(){
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println("1: choisir un département");
        System.out.println("2: choisir un etudiant");
        System.out.println("3: choisir une filiere");
        System.out.println("4: choisir un module");
        System.out.println("5: choisir un enseignant");

        //"Veuillez sélectionner une option : ")
        int option = getIntInput("choisir une option  : ");
        switch(option) {
            case 1:
                DepartementContreller.showMenu();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                // code block
        }
        switch(option) {
            case 1:

                DepartementContreller.showMenu();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                // code block
        }


    }
    public static void main(String[] args) {

        Enseignant enseignant = new Enseignant("Nom", "Prénom", "Email", "Grade");
        enseignant.setNom("Amine");
        enseignant.setPrenom("Bejari");
        enseignant.setEmail("aminjar@gmail.com");
        enseignant.setGrade("Prof");
        enseignant.setId(DB.getEnsId());
        DB.enseignants.add(enseignant);
        showPrincipalMenu();
    }
}
