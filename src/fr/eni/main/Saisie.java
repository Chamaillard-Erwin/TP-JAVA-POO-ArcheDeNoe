package fr.eni.main;

import fr.eni.bo.animal.Animal;
import fr.eni.bo.animal.Espece;
import fr.eni.bo.animal.Sexe;

import java.util.Scanner;

public class Saisie {
    Scanner scan = new Scanner(System.in);
    String saisie;
    String nom;
    int choixSexe;
    int choixEspece;
    Sexe[] sexeTab = Sexe.values();
    Espece[] especeTab = Espece.values();


    public String getNom() {
        return nom;
    }

    public int getChoixSexe() {
        return choixSexe;
    }

    public int getChoixEspece() {
        return choixEspece;
    }

    public char getFinAjout() {
        return finAjout;
    }

    char finAjout;

    public void afficherDessin() {
        System.out.println("");
        System.out.println("_______");
        System.out.println("|_____|__________________________");
        System.out.println("| BIENVENUE SUR L'ARCHE DE NOE  /");
        System.out.println("|     |                        /");
        System.out.println("|_____|_______________________/");
    }

    public char demanderAutreAnimal() {
        System.out.println("Voulez-vous ajouter un animal ?");
        saisie = scan.nextLine().toUpperCase();
        finAjout = saisie.charAt(0);
        return finAjout;
    }

    public void demanderNom() {
        System.out.println("Quel est son nom ?");
        this.nom = scan.nextLine();
    }

    public int demanderSexe() {
        System.out.print("Quels est son sexe ? ");
        afficherSexe();
        this.choixSexe = scan.nextInt();
        scan.nextLine();
        return this.choixSexe;
    }

    public int demanderEspece() {
        System.out.print("Quel est son espece ? ");
        afficherEspece();
        this.choixEspece = scan.nextInt();
        scan.nextLine();
        return this.choixEspece;
    }

    public void afficherSexe() {
        for (Sexe sexe : sexeTab) {
            System.out.print(sexe.ordinal() + "-" + sexe.toString() + " ");
        }
        System.out.println();
    }

    public void afficherEspece() {
        for (Espece espece : especeTab) {
            System.out.print(espece.ordinal() + "-" + espece.toString() + " ");
        }
        System.out.println();
    }

}
