/**
 * Classe qui possède quelque méthodes utilitaires comme l'affichage des infos du menu
 * mais aussi les informations rentré par l'utilisateur dans le but de déchargé un peu la méthode main
 * @author echamaillard
 */

package fr.eni.main;

import fr.eni.bo.animal.Espece;
import fr.eni.bo.animal.Sexe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Saisie {
    //Attributs nécéssaire pour la saisie
    String saisie;
    String nom;
    int choixSexe;
    int choixEspece;
    Sexe[] sexeTab = Sexe.values();
    Espece[] especeTab = Espece.values();
    char finAjout;

    /**
     * Méthode pour afficher un dessin dans le but de faire le mariole
     */
    public void afficherDessin() {
        System.out.println("");
        System.out.println("_______");
        System.out.println("|_____|__________________________");
        System.out.println("| BIENVENUE SUR L'ARCHE DE NOE  /");
        System.out.println("|     |                        /");
        System.out.println("|_____|_______________________/");
    }

    /**
     * Méthode pour demande si l'utilisateur veut ajouter un autre animal
     * @return
     */
    public char demanderAutreAnimal() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Voulez-vous ajouter un animal O/N ?");
        saisie = scan.nextLine().toUpperCase();
        finAjout = saisie.charAt(0);
        return finAjout;
    }

    /**
     * Méthode pour demande un nom d'animal
     * Retourne localement un char
     * @return
     */
    public void demanderNom() {
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Quel est son nom ? (Pas plus de 20 caractères)");
            this.nom = scan.nextLine();
            if (this.nom.length() > 20) {
                System.err.println("Le nom est trop long, veuillez recommencer");
            }
        }while (this.nom.length() > 20);
    }

    /**
     * Méthode pour demander le sexe
     * Retourne localement un int
     * @return
     */
    public int demanderSexe(){

        do {
            Scanner scan = new Scanner(System.in);
            try{
                System.out.print("Quel est son sexe ? ");
                afficherSexe();
                this.choixSexe = scan.nextInt();
                scan.nextLine();
            }
            catch(InputMismatchException e) {
                System.err.println("Erreur de saisie, veuillez recommencer.");
                this.choixSexe = -1;
            }
        }while (this.choixSexe < 0 || this.choixSexe >= Sexe.values().length);

        return this.choixSexe;
    }

    /**
     * Méthode pour demander l'espece à l'animal
     * Retourne un int
     * @return
     */
    public int demanderEspece(){
        do {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.print("Quel est son espece ? ");
                afficherEspece();
                this.choixEspece = scan.nextInt();
                scan.nextLine();
            }
            catch (InputMismatchException e) {
                System.err.println("Erreur de saisie, veuillez recommencer.");
                this.choixEspece = -1;
            }
        }while (this.choixEspece < 0 || this.choixEspece >= Espece.values().length);

        return this.choixEspece;
    }

    /**
     * Méthode pour afficher les choix de sexe dynamiquement
     */
    public void afficherSexe() {
        for (Sexe sexe : sexeTab) {
            System.out.print(sexe.ordinal() + "-" + sexe.toString() + " ");
        }
        System.out.println();
    }

    /**
     * Méthode pour afficher les choix d'espèce dynamiquement
     */
    public void afficherEspece() {
        for (Espece espece : especeTab) {
            System.out.print(espece.ordinal() + "-" + espece.toString() + " ");
        }
        System.out.println();
    }

    //GETTERS
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

}
