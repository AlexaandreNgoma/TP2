package com.example.lib;

public class Adversaire extends Personnage{

    public Adversaire(String nom, float PVMax, float PV, float attaque, float defense) {
        super(nom, PVMax, PV, attaque, defense);
    }

    @Override
    public float Attaquer() {
        return super.Attaquer();
    }

    @Override
    public void Defendre(float dégats, boolean veutDefendre) {
        super.Defendre(dégats,false);
    }
}
