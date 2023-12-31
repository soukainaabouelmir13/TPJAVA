package phase1.services;

import phase1.models.Etudiant;
import phase1.models.Filiere;

import java.util.ArrayList;

public class EtudiantServices {


    private static int id;

    public static Etudiant addEtd(String nom, String prenom, String email, int apogee  ){
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setApogee(apogee);
        etudiant.setId(DB.getEtdId());
        DB.etudiants.add(etudiant);

        return  new Etudiant();
    }
    public static Etudiant updateEtd(int id,String email, String nom,String prenom,int apogee ){
        EtudiantServices.id = id;
        for ( Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == id) {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(email);
                etudiant.setApogee(apogee);
            }
            return  new Etudiant();
        }
        public static ArrayList<Etudiant> deleteEtdById(int id){

            DB.etudiants.remove(getEtdById(id));
            return  DB.etudiants;
        }

        public static Etudiant getEtdById(int id){
            for (Etudaint etudiant : DB.etudiants) {
                if (etudiant.getId() == id) return etudiant.getFiliere();
            }
            return  new Etudiant();
        }

        public static ArrayList<Etudiant> getAllEtd(int id){
            return  DB.etudiants;
        }
    }

    private static int getEtdById(int id) {
        return 0;
    }

    public static void addEtd(String nom, Filiere filiereById) {
    }

    public static void deleteEtdById(int id) {
    }
}


