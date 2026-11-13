package com.example.lib;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner lire = new Scanner(System.in);
        System.out.println("Le Tournoi Commence");

        System.out.println("Entrez le nom de votre gladiatuer");
        String nom = lire.nextLine();

        Gladiateur gladiateur = new Gladiateur(nom,100,100,12,4);
        Adversaire[] adversaires = {
                new Adversaire("Le Germain",40,40,8,2),
                new Adversaire("Tigris de Gaule",50,50,10,3),
                new Adversaire("Commodus",70,70,13,5)
        };

        for(int i = 0; i <= adversaires.length-1; i++){
            Personnage gagnant = Affrontement(gladiateur,adversaires[i]);
            System.out.println();
            System.out.println(gagnant.getNom() + " a gagné");
            if (gagnant != gladiateur) {
                System.out.println("Le Gladiateur a perdu");
                break;
            }
            else System.out.println("Le Gladiateur a vaincu son adversaire");
        }
        System.out.println("Fin du jeu");
    }
    private static Personnage Affrontement(Gladiateur gladiateur, Adversaire adversaire)
    {
        Combat combat = new Combat(gladiateur,adversaire);
        return combat.Affronter();
    }
}