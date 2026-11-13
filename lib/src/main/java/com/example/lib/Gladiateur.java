package com.example.lib;

public class Gladiateur extends Personnage implements ISoignable{
    private boolean peutDefendre;
    private float nbPotions;

    public boolean getPeutDefendre() {
        return peutDefendre;
    }

    public void setPeutDefendre(boolean peutDefendre) {
        this.peutDefendre = peutDefendre;
    }

    public float getNbPotions() {
        return nbPotions;
    }

    public void setNbPotions(float nbPotions) {
        this.nbPotions = nbPotions;
    }

    public Gladiateur(String nom, float PVMax, float PV, float attaque, float defense) {
        super(nom, PVMax, PV, attaque, defense);
        setPeutDefendre(true);
        setNbPotions(2);
    }

    @Override
    public float Attaquer() {
        return super.Attaquer();
    }

    @Override
    public void Defendre(float dégats, boolean veutDefendre) {
        if(getPeutDefendre() && veutDefendre)
        {
            float dégâts = Math.max((dégats/2) - getDefense(), 1);
            this.setPV(getPV() - dégâts);
            setPeutDefendre(false);
        }
        else if(!getPeutDefendre() && veutDefendre){
            System.out.println("L'action échoue");
            float dégâts = Math.max(dégats - getDefense(), 1);
            this.setPV(getPV() - dégâts);
        }
        else {
            float dégâts = Math.max(dégats - getDefense(), 1);
            this.setPV(getPV() - dégâts);
        }
    }

    @Override
    public void BoirePotion() {
        if(getNbPotions() > 0) {
            //heal
            setPV(getPV() + 15);
            if(getPV() > getPVMax()) setPV(getPVMax());
            setNbPotions(getNbPotions() - 1);
        }
        else System.out.println("L'action échoue");
    }
}
