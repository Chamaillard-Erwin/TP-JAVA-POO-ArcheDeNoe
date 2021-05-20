package fr.eni.bo.animal;

public abstract class Animal {

    //Atributs de classe
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

    public abstract boolean isInstance(Object obj);
}
