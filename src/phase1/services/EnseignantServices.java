package phase1.services;

import phase1.models.Departement;
import phase1.models.Enseignant;

import java.util.ArrayList;

public class EnseignantServices {

    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dept){
        Enseignant enseignant = new Enseignant("Nom", "Prénom", "Email", "Grade");
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setEmail(email);
        enseignant.setId(DB.getEnsId());
        DB.enseignant.add(enseignant);

        return  new Enseignant("Nom", "Prénom", "Email", "Grade");
    }

    public static Enseignant updateEns(int id,String email, String prenom, String nom, Departement dept){
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setEmail(email);}

            return  new Enseignant("Nom", "Prénom", "Email", "Grade");
        }
        public static ArrayList<Enseignant> deleteEnsById(int id){
            DB.enseignants.remove(getEnsById(id));
            return  DB.enseignants;
        }

        public static Departement getEnsById(int id){
            for (Enseignant enseignant : DB.enseignants) {
                if (enseignant.getId() == id) return enseignant.getDept();
            }
            return new Enseignant("Nom", "Prénom", "Email", "Grade").getDept();
        }

        public static ArrayList<Enseignant> getAllEns(){
            return  DB.enseignants;
        }}

    public static Departement getEnsById(int id) {
   return 0; }

    public static void deleteEnsById(int id) {
    }
}

