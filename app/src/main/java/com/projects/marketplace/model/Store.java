package com.projects.marketplace.model;

import java.util.List;

public class Store {

    private long id;
    private String name;
    private Fournisseur fournisseur;
    private List<Article> articles;

    public Store(long id, String name, Fournisseur fournisseur, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.fournisseur = fournisseur;
        this.articles = articles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<Article> getStores() {
        return articles;
    }

    public void setStores(List<Article> articles) {
        this.articles = articles;
    }
}
