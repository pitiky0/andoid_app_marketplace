package com.projects.marketplace.model;

public class Categorie {

    private long id;
    private String designiation;

    public Categorie(long id, String designiation) {
        this.id = id;
        this.designiation = designiation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesigniation() {
        return designiation;
    }

    public void setDesigniation(String designiation) {
        this.designiation = designiation;
    }
}
