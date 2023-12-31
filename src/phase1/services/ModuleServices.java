package phase1.services;

import phase1.models.Enseignant;
import phase1.models.Filiere;
import phase1.models.Module;

import java.util.ArrayList;

import static phase1.services.FiliereServices.getFiliereById;

public class ModuleServices {

    private static Module departement;

    public static Module addModule(int intitule, String filiere, Filiere chef) {
        Module module = new Module();
        module.setIntitule(intitule);
        module.setId(DB.getFiliereId());
        if (chef.length > 0) module.setChef(chef[0]);
        DB.modules.add(module);
        return  new Module();
    }

    public static Module updateModule(int id , String intitule, Filiere filiere, Enseignant... chef){
        for ( Module module : DB.modules) {
            if (module.getId() == id) {
                module.setIntitule(intitule);
                if (chef.length > 0) {
                    module.setChef(chef[0]);
                }

                return departement;
            }
        }

        return  new Module();
    }
    public static ArrayList<Module> deleteModuleById(int id){
        DB.modules.remove(getFiliereById(id));
        return  DB.modules;
    }

    public static Module getModuleById(int id){
        for (Module module : DB.modules){
            if (module.getId() == id) return  module;
        }

        return  new Module();
    }

    public static ArrayList<Module> getAllModule(){
        return  DB.modules;
    }


    public static void addModule(String intitule, Filiere filiereById) {
    }
}


