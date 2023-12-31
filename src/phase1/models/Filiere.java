package phase1.models;

import java.util.ArrayList;

public class Filiere {

    private int id;
    private String intitule;
    private Enseignant chef;
    private Departement dept;

    ArrayList<java.lang.Module> modules = new ArrayList<java.lang.Module>();

    public Filiere() {
    }

    public Filiere(String intitule, Enseignant chef, Departement dept) {
        this.intitule = intitule;
        this.chef = chef;
        this.dept = dept;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getChef() {
        return chef;
    }

    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }

    public ArrayList<java.lang.Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<java.lang.Module> modules) {
        this.modules = modules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

