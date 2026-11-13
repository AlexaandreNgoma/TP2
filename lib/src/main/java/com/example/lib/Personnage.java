package com.example.lib;
import java.util.Random;

public class Personnage implements ICombattant{
    private String nom;
    private float PVMax;
    private float PV;
    private float attaque;
    private float defense;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPVMax() {
        return PVMax;
    }

    private void setPVMax(float PVMax) {
        this.PVMax = PVMax;
    }

    public float getPV() {
        return PV;
    }

    public void setPV(float PV) {
        this.PV = PV;
    }

    public float getAttaque() {
        return attaque;
    }

    private void setAttaque(float attaque) {
        this.attaque = attaque;
    }

    public float getDefense() {
        return defense;
    }

    private void setDefense(float defense) {
        this.defense = defense;
    }

    public Personnage(String nom, float PVMax, float PV, float attaque, float defense) {
        this.nom = nom;
        this.PVMax = PVMax;
        this.PV = PV;
        this.attaque = attaque;
        this.defense = defense;
    }

    @Override
    public void Afficher()
    {
        System.out.println(getNom() + " : " + getPV() + "/" + getPVMax() + " PV");
    }


    @Override
    public float Attaquer() {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        float dégâts = getAttaque() + randomNumber;
        return dégâts;
    }

    @Override
    public void Defendre(float dégats, boolean veutDefendre) {
        float dégâts = Math.max(dégats - getDefense(), 1);
        this.setPV(getPV() - dégâts);
    }
}
