package fr.eni.bo.animal;

public enum Sexe {
    MALE,
    FEMELLE;

    public static Sexe choisirSexe (int choix) {
        switch (choix) {
            case 0 : return MALE;
            case 1 : return FEMELLE;
            default:
                System.err.println("Problème avec le sexe");
                return MALE;
        }
    }
}
