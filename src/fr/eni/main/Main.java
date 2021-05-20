package fr.eni.main;

import fr.eni.bo.Arche;
import fr.eni.bo.animal.Espece;
import fr.eni.bo.animal.Sexe;
import fr.eni.bo.animal.individu.Chat;
import fr.eni.bo.animal.individu.Chien;
import fr.eni.bo.animal.individu.Gorille;
import fr.eni.bo.animal.individu.Lapin;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Saisie s = new Saisie();
        Arche arche = new Arche(8);

        /**
         * Amorce de la boucle : On affiche le dessin, puis on demande à ajouter un animal
         */
        s.afficherDessin();
        s.demanderAutreAnimal();

        /**
         * Boucle principale
         */
        while(!arche.verifArchePleine() && s.getFinAjout() == 'O') {

            //On demande les infos de l'animal
            s.demanderNom();
            s.demanderSexe();
            s.demanderEspece();
            //En fonction du choix de l'espece on creer une instance de la classe correspondante
            switch (s.getChoixEspece()) {
                case 0 :
                    arche.ajouterAnimal(new Chat(s.getNom(), Sexe.choisirSexe(s.getChoixSexe())));
                    break;
                case 1 :
                    arche.ajouterAnimal(new Chien(s.getNom(), Sexe.choisirSexe(s.getChoixSexe())));
                    break;
                case 2 :
                    arche.ajouterAnimal(new Gorille(s.getNom(), Sexe.choisirSexe(s.getChoixSexe())));
                    break;
                case 3 :
                    arche.ajouterAnimal(new Lapin(s.getNom(), Sexe.choisirSexe(s.getChoixSexe())));
                    break;
                default:
                    System.err.println("ERREUR DANS LES SAISIES");
            }

            //Si après la création, l'arche n'est pas pleine on relance la boucle
            //sinon on
            //on demande à sortir de la boucle
            if (!arche.verifArchePleine()) {
                s.demanderAutreAnimal();
            }
            else {
                System.out.println("L'arche est pleine !");
            }
        }

        /**
         * Ici on affiche les informations de fin : Bon voyage !
         */
        arche.afficherArche();
        arche.afficherNourritureRequise();
    }
}