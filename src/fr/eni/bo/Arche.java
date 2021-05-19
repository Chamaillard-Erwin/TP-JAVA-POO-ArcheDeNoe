package fr.eni.bo;

import fr.eni.bo.animal.Animal;
import fr.eni.bo.animal.Espece;
import fr.eni.bo.animal.individu.Carnivore;
import fr.eni.bo.animal.individu.Herbivore;

public class Arche {
    //Constante de l'instance
    private final int NBJOURS = 10;
    private final int VEGETAUXPARJOUR = 10;
    private final int VIANDEPARJOUR = 30;

    //Attribut(s) de l'instance
    private Animal[] animalTab;
    private int cptChats;
    private int cptChiens;
    private int cptGorilles;
    private int cptLapins;
    private int nbVegetaux;
    private int poidsViande;

    public Arche(int nbPlaces) {
        this.animalTab = new Animal[nbPlaces];
    }

    /**
     * Méthode permettant d'ajouter un animal à l'arche, si c'est plein alors on préviens l'utilisateur
     * @param animal
     */
    public void ajouterAnimal(Animal animal) {
        if (!verifArchePleine() && !verifierIndividualite(animal)) {
            for (int i = 0; i < this.animalTab.length; i++) {
                if (this.animalTab[i] == null) {
                    this.animalTab[i] = animal;
                    System.out.printf("L'animal %s est dans l'arche. (capacité %d/%d)%n", this.animalTab[i].getNom(), (i +1), this.animalTab.length);
                    break;
                }
            }
        }
    }

    /**
     * Méthode pour afficher le contenu de l'arche
     */
    public void afficherArche() {
        System.out.println("L'arche possède à son bord, " + cptChats + " chat(s), " + cptChiens + " chien(s), "
        + cptGorilles + " gorille(s), " + cptLapins + " lapin(s)");
    }

    /**
     * Méthode qui renvoie TRUE si l'arche est pleine
     * @return
     */
    public boolean verifArchePleine() {
        for (Animal animal : this.animalTab) {
            if (animal == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Méthode pour calculer le nombre de végétaux requis pour le voyage
     * en fonction du nombre de jour, consommation par jour et du nombre d'herbivore dans l'arche
     * @return
     */
    public int calculerNbVegetaux() {
        for (Animal animal : this.animalTab) {
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
        for (Animal animal : this.animalTab) {
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
        for (Animal vl_animal : this.animalTab) {
            if (vl_animal != null
                    && vl_animal.getClass().getName().equals(animal.getClass().getName())
                    && vl_animal.getSexe().equals(animal.getSexe())) {
                System.out.println("Animal déjà existant");
                return true;
            }
        }
        return false;
    }

    //GETTERS
    public Animal[] getAnimalTab() {
        return this.animalTab;
    }

    public int getCptChats() {
        return cptChats;
    }

    public int getCptChiens() {
        return cptChiens;
    }

    public int getCptGorilles() {
        return cptGorilles;
    }

    public int getCptLapins() {
        return cptLapins;
    }

    //SETTERS
    public void setCptChats(int cptChats) {
        this.cptChats = cptChats;
    }

    public void setCptChiens(int cptChiens) {
        this.cptChiens = cptChiens;
    }

    public void setCptGorilles(int cptGorilles) {
        this.cptGorilles = cptGorilles;
    }

    public void setCptLapins(int cptLapins) {
        this.cptLapins = cptLapins;
    }
}
