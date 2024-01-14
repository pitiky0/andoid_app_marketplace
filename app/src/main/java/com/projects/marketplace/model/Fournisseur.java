package com.projects.marketplace.model;

import java.util.List;

public class Fournisseur extends User{

    private List<Store> stores;

    public Fournisseur(long id, String name, String address, String password, List<Store> stores) {
        super(id, name, address, password);
        this.stores = stores;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
