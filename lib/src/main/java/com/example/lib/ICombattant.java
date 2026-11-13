package com.example.lib;

public interface ICombattant {
    public abstract void Afficher();
    public abstract float Attaquer();
    public abstract void Defendre(float dégats, boolean veutDefendre);
}
