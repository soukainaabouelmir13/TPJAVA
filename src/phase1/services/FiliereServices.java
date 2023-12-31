package phase1.services;

import phase1.models.Departement;
import phase1.models.Enseignant;
import phase1.models.Filiere;

import java.util.ArrayList;

public class FiliereServices {

    public static Filiere addFiliere(String intitule, Departement dept, Enseignant... chef) {
        Filiere filiere = new Filiere();
        filiere.setIntitule(intitule);
        filiere.setId(DB.getDeptId());
        if (chef.length > 0) filiere.setChef(chef[0]);
        DB.filieres.add(filiere);
        return  new Filiere();
    }

    public static Filiere updateFiliere(int id , String intitule, Departement dept, Enseignant... chef){
        for (Filiere filiere : DB.filieres) {
            if (filiere.getId() == id) {
                filiere.setIntitule(intitule);
                if (chef.length > 0) {
                    filiere.setChef(chef[0]);
                }
                return filiere;
            }
        }
        return  new Filiere();
    }
    public static ArrayList<Filiere> deleteFiliereById(int id){
        DB.filieres.remove(getFiliereById(id));
        return  DB.filieres;
    }

    public static Filiere getFiliereById(int id){
        return  new Filiere();
    }

    public static ArrayList<Filiere> getAllFiliere(){
        return  DB.filieres;
    }


}


