/**
 * Classe de l'arche contenant beaucoup de méthode
 * l'arche permet d'effectuer différentes vérification et affiche des informations en fonction de l'ajout d'animaux
 * permet également de compter la nourriture requise pour le voyage
 */


package fr.eni.bo;

import fr.eni.bo.animal.Animal;
import fr.eni.bo.animal.individu.*;

import java.util.ArrayList;
import java.util.List;

public class Arche {
    //Constante de l'instance
    private final int NBJOURS = 10;
    private final int VEGETAUXPARJOUR = 10;
    private final int VIANDEPARJOUR = 30;
    private final int MAX_ANIMAL = 10;

    //Attribut(s) de l'instance
    private List<Animal> animalList;
    private int nbVegetaux;
    private int poidsViande;


    public Arche(int nbPlaces) {
        this.animalList = new ArrayList<>();
    }

    /**
     * Méthode permettant d'ajouter un animal à l'arche, si c'est plein alors on préviens l'utilisateur
     * @param animal
     */
    public void ajouterAnimal(Animal animal) {
        if (!verifArchePleine() && !verifierIndividualite(animal)) {
            animalList.add(animal);
            System.out.printf("L'animal %s est dans l'arche. (capacité %d/%d)%n", animal.getNom(), animalList.size(), this.MAX_ANIMAL);
        }
    }

    /**
     * Méthode pour afficher le contenu de l'arche
     */
    public void afficherArche() {
        System.out.println("L'arche possède à son bord, " + compterTypeAnimaux(Chat.class.getName()) + " chat(s), " + compterTypeAnimaux(Chien.class.getName()) + " chien(s), "
        + compterTypeAnimaux(Gorille.class.getName()) + " gorille(s), " + compterTypeAnimaux(Lapin.class.getName()) + " lapin(s)");
    }

    /**
     * Méthode qui renvoie TRUE si l'arche est pleine
     * @return
     */
    public boolean verifArchePleine() {
        if (this.animalList.size() == 10) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Méthode pour calculer le nombre de végétaux requis pour le voyage
     * en fonction du nombre de jour, consommation par jour et du nombre d'herbivore dans l'arche
     * @return
     */
    public int calculerNbVegetaux() {
        for (Animal animal : this.animalList) {
            if (animal instanceof Herbivore) {
                this.nbVegetaux += this.VEGETAUXPARJOUR;
            }
        }
        return this.nbVegetaux * NBJOURS;
    }

    /**
     * Méthode pour calculer le poids de viande requis pour le voyage
     * en fonction du nombre de jour, consommation par jour et du nombre de carnivore dans l'arche
     * @return
     */
    public int calculerPoidsViande() {
        for (Animal animal : this.animalList) {
            if (animal instanceof Carnivore) {
                this.poidsViande += this.VIANDEPARJOUR;
            }
        }
        return this.poidsViande * NBJOURS;
    }

    /**
     * Méthode pour afficher la nourriture requise
     */
    public void afficherNourritureRequise() {
        System.out.printf("Le commis doit avoir, à bord, %d végétaux et %dkg de viande", calculerNbVegetaux(), calculerPoidsViande());
    }

    /**
     *Méthode pour vérifier l'unicité (Merci SQL) de l'animal
     * Return TRUE si l'animal existe
     * @param animal
     * @return
     */
    public boolean verifierIndividualite(Animal animal) {
        for (Animal vl_animal : this.animalList) {
            if ( vl_animal.getClass().getName().equals(animal.getClass().getName())
                    && vl_animal.getSexe().equals(animal.getSexe())) {
                System.out.println("Animal déjà existant");
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour compter le nombre d'animaux par type de classe
     * @param nomClasse
     * @return
     */
    public int compterTypeAnimaux(String nomClasse) {
        int cpt = 0;
        for (Animal animal : this.animalList) {
            if (animal.getClass().getName().equals(nomClasse)) {
                cpt++;
            }
        }
        return cpt;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }
}
