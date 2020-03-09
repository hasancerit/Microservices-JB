package com.microservices.moviecatalogservice.models;

public class CatalogItem {
    private String name;
    private String description;
    private int rate;

    public CatalogItem() {
    }

    public CatalogItem(String name, String description, int rate) {
        this.name = name;
        this.description = description;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
