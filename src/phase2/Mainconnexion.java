package phase2;

import phase1. models.Departement;
import phase1.models.Enseignant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Mainconnexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/gestionecole";
        String user = "root";
        String pwd = "";

        try {
            Connection cx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Good Connection");

            // Création de la table departements si elle n'existe pas
            createTable(cx);

            // Insérer un nouveau département
            Departement newDepartement = new Departement("mip", new Enseignant("Nom", "Prénom", "Email", "Grade"));
            insertDepartement(newDepartement, cx);
            Departement newDepartement2 = new Departement("gegm", new Enseignant("Nom", "Prénom", "Email", "Grade"));
            insertDepartement(newDepartement2, cx);
            try {
                // ...
                int idToDelete = 9; // ID du département à supprimer
                deleteDepartement(idToDelete, cx); // Appel de la méthode deleteDepartement
                // ...
            } catch (SQLException e) {
                // Gestion des exceptions
            }


            // Récupération de tous les départements depuis la base de données
            List<Departement> departements = getAllDepartements(cx);
            for (Departement departement : departements) {
                System.out.println(departement.toString());
            }

        } catch (SQLException e) {
            System.out.println("Bad Connection");
            e.printStackTrace();
        }
    }
    public static void CreatetableEns(Connection cx) throws SQLException {
        String sql = "create table IF NOT EXISTS Enseignant" +
                "(" +
                " id int auto_increment" +
                " primary key," +
                " nom varchar(250), " +
                " prenom varchar(250), " +
                " email varchar(250), " +
                " grade varchar(250)  " +
                ");";

    try (Statement st = cx.createStatement()) {
        st.execute(sql);
        System.out.println("Table 'Ensiegnant' créée avec succès !");
    } catch (SQLException e) {
        System.out.println("Erreur lors de la création de la table 'Enseignant'");
        e.printStackTrace();
    }
}
    public static void createTable(Connection cx) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS departements (" +
                "id int primary key auto_increment, " +
                "intitule varchar(255), " +
                "responsable varchar(255), " +
                "FOREIGN KEY (chef) REFERENCES enseignants(id)," +
        ")";

        try (Statement st = cx.createStatement()) {
            st.execute(query);
            System.out.println("Table 'departements' créée avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la création de la table 'departements'");
            e.printStackTrace();
        }
    }
    public static List<Departement> getAllDepartements(Connection cx) throws SQLException {
        String query = "SELECT d.id, d.intitule, d.responsable as responsable_id, e.nom as responsable_nom, e.prenom as responsable_prenom " +
                "FROM departements d " +
                "LEFT JOIN enseignants e ON d.responsable = e.id";
        List<Departement> departements = new ArrayList<>();

        Statement st = cx.createStatement();
        ResultSet r = st.executeQuery(query);

        while (r.next()) {
            int id = r.getInt("id");
            String intitule = r.getString("intitule");
            int chefId = r.getInt("chef_id");
            String chefNom = r.getString("chef_nom");
            String chefPrenom = r.getString("chef_prenom");

            // Création d'un objet Departement pour chaque ligne de la table
            Departement departement = new Departement(intitule, null);
            departement.setId(id);

            // Création de l'objet Enseignant pour le chef
            Enseignant chef = new Enseignant(chefNom, chefPrenom, null, null, null);
            chef.setId(chefId);

            departement.setChef(chef);

            departements.add(departement);
        }

        return departements;
    }
    public static void insertDepartement(Departement departement, Connection cx) throws SQLException {
        String query = "INSERT INTO departements (id,intitule, responsable) VALUES (1,gegm, amin bjari)" +
                "(2,mecanique,mari hajar)";

        try (PreparedStatement ps = cx.prepareStatement(query)) {
            ps.setString(1, departement.getIntitule());

            // Supposons que vous stockiez l'ID de l'enseignant en tant que chef du département
            ps.setInt(2, departement.getChef().getId());

            ps.executeUpdate();
            System.out.println("Département inséré avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion du département");
            e.printStackTrace();
        }
    }
    public static void insertEnseignant(Enseignant enseignant, Connection cx) throws SQLException {
        String sql = "INSERT INTO enseignant (id, nom,prenom,email,grade) VALUES (1, amin, bjari,aminjar@gmail.com)" +
                "(2,mari, hajar,jarrmaro@gmail.com)";

        try (PreparedStatement ps = cx.prepareStatement(sql)) {
            ps.setString(1, enseignant.getEmail());

            // Supposons que vous stockiez l'ID de l'enseignant en tant que chef du département
            ps.setInt(2, enseignant.getId());

            ps.executeUpdate();
            System.out.println("Enseignant inséré avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion du Enseignant");
            e.printStackTrace();
        }
    }
    public static void deleteDepartement(int idDep, Connection myConn) throws SQLException {
        String sql = "DELETE  from Departement where idDep = ?";
        PreparedStatement myStmt = myConn.prepareStatement(sql);
        myStmt.setInt(1, idDep);
        myStmt.executeUpdate();
    }
    public static void deleteEnseignant(int idEns, Connection myConn) throws SQLException {
        String sql = "DELETE  from Enseignant where idEns = ?";
        PreparedStatement myStmt = myConn.prepareStatement(sql);
        myStmt.setInt(1, idEns);
        myStmt.executeUpdate();
    }

}



