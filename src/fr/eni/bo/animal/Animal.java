package fr.eni.bo.animal;

public abstract class Animal {

    protected String nom;
    protected Sexe sexe;

    public Animal(String nom, Sexe sexe) {
        this.nom = nom;
        this.sexe = sexe;
    }

    //GETTERS
    public String getNom() {
        return nom;
    }

    public Sexe getSexe() {
        return sexe;
    }

}
