package com.example.lib;

import java.util.Random;
import java.util.Scanner;

public class Combat {
    Gladiateur gladiateur;
    Personnage adversaire;

    public Gladiateur getGladiateur() {
        return gladiateur;
    }

    public void setGladiateur(Gladiateur gladiateur) {
        this.gladiateur = gladiateur;
    }

    public Personnage getAdversaire() {
        return adversaire;
    }

    public void setAdversaire(Personnage adversaire) {
        this.adversaire = adversaire;
    }

    public Combat(Gladiateur gladiateur, Personnage adversaire) {
        this.gladiateur = gladiateur;
        this.adversaire = adversaire;
    }

    public Personnage Affronter()
    {
        //introduire adversaire
        do{
            Scanner lire = new Scanner(System.in);

            //L'état des deux combattants (PV actuels / PV max) s'affiche.
            getGladiateur().Afficher();
            getAdversaire().Afficher();

            System.out.println();
            System.out.println("Que fait " + getGladiateur().getNom() + "?");
            System.out.println("1. Attaquer");
            System.out.println("2. Defendre");
            System.out.println("3. Potion");

            System.out.println();
            System.out.println("Choix: ");
            int option = lire.nextInt();
            //Le joueur choisit une action (1, 2 ou 3)
            switch (option) {
                case 1:
                    System.out.println(getGladiateur().getNom() + " attaque " + getAdversaire().getNom());
                    getAdversaire().Defendre(getGladiateur().Attaquer(),false);
                    break;
                case 2:
                    System.out.println(getGladiateur().getNom() + " se met en position défensive");
                    System.out.println(getGladiateur().getNom() + " attaque " + getAdversaire().getNom());
                    getAdversaire().Defendre(getGladiateur().Attaquer(),false);
                        getGladiateur().Defendre(getAdversaire().Attaquer(), true);
                    break;
                case 3:
                    System.out.println(getGladiateur().getNom() + " boit une potion");
                    getGladiateur().BoirePotion();
                    break;
                default:
                    System.out.println("Option invalide");
                    break;
            }

            //Si l'adversaire est mort suite à l'attaque du joueur → le combat se termine
            if(getAdversaire().getPV() <= 0) return getGladiateur();

            if( option != 2) TourEnemy(false);
            System.out.println();
        }while(getGladiateur().getPV() > 0);
        return getAdversaire();
    }

    private void TourEnemy(boolean defend){
        //jet d'esquive est effectué pour le joueur (20 % de chance)
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        if(randomNumber != 1){
            //if(esquive fail) do adversaire attaque
            System.out.println(getAdversaire().getNom() + " attaque " + getGladiateur().getNom());
            getGladiateur().Defendre(getAdversaire().Attaquer(),defend);
        }
        else {
            System.out.println(getGladiateur().getNom() + " esquive une attaque");
        }
    }
}
