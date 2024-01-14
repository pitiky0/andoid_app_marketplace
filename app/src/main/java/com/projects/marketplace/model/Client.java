package com.projects.marketplace.model;

import java.util.List;

public class Client extends User{

    private List<Commande> commandes;

    public Client(long id, String name, String address, String password, List<Commande> commandes) {
        super(id, name, address, password);
        this.commandes = commandes;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
