package fr.eni.main;

import fr.eni.bo.Arche;
import fr.eni.bo.animal.Sexe;
import fr.eni.bo.animal.individu.Chat;
import fr.eni.bo.animal.individu.Chien;
import fr.eni.bo.animal.individu.Gorille;
import fr.eni.bo.animal.individu.Lapin;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Saisie s = new Saisie();
        Arche arche = new Arche(2);

        s.afficherDessin();
        s.demanderAutreAnimal();
        while(!arche.verifArchePleine() && s.getFinAjout() == 'O') {
            s.demanderNom();
            s.demanderSexe();
            s.demanderEspece();
            switch (s.getChoixEspece()) {
                case 0 :
                    arche.ajouterAnimal(new Chat(s.getNom(), Sexe.choisirSexe(s.getChoixSexe())));
                    arche.setCptChats(arche.getCptChats() + 1);
                    break;
                case 1 :
                    arche.ajouterAnimal(new Chien(s.getNom(), Sexe.choisirSexe(s.getChoixSexe())));
                    arche.setCptChiens(arche.getCptChiens() + 1);
                    break;
                case 2 :
                    arche.ajouterAnimal(new Gorille(s.getNom(), Sexe.choisirSexe(s.getChoixSexe())));
                    arche.setCptGorilles(arche.getCptGorilles() + 1);
                    break;
                case 3 :
                    arche.ajouterAnimal(new Lapin(s.getNom(), Sexe.choisirSexe(s.getChoixSexe())));
                    arche.setCptLapins(arche.getCptLapins() + 1);
                    break;
                default:
                    System.err.println("ERREUR DANS LES SAISIES");
            }

            if (!arche.verifArchePleine()) {
                s.demanderAutreAnimal();
            }
            else {
                System.out.println("L'arche est pleine !");
            }
        }

        arche.afficherArche();
        arche.afficherNourritureRequise();











    }
}
