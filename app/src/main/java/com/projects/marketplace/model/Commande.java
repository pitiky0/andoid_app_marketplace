package com.projects.marketplace.model;

import java.sql.Date;
import java.util.List;

public class Commande {

    private long id;
    private Date dateCommende;
    private Client client;
    private List<Article> articles;

    public Commande(long id, Date dateCommende, Client client, List<Article> articles) {
        this.id = id;
        this.dateCommende = dateCommende;
        this.client = client;
        this.articles = articles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateCommende() {
        return dateCommende;
    }

    public void setDateCommende(Date dateCommende) {
        this.dateCommende = dateCommende;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
