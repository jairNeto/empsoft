package com.delaroystudios.MatchFood.model;

/**
 * Created by Lucas on 20/03/2017.
 */

public class Plate {
    private String name;
    private int amount, thumbnail;
    private double evaluation, price;

    public Plate(String name, int amount, double evaluation, double price, int thumbnail){
        this.name = name;
        this.amount = amount;
        this.evaluation = evaluation;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public int getThumbnail(){ return thumbnail; }

    public void setThumbnail(int thumbnail){ this.thumbnail = thumbnail; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}