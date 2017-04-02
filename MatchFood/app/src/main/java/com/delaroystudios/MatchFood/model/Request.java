package com.delaroystudios.MatchFood.model;

/**
 * Created by jairneto on 2/4/17.
 */

public class Request {

    private String name;
    private int amount, plateThumbnail, userThumbnail;
    private double plateEvaluation, price, userEvaluation;

    public Request(String name, int amount, int plateThumbnail, int userThumbnail, double plateEvaluation, double price, double userEvaluation) {
        this.name = name;
        this.amount = amount;
        this.plateThumbnail = plateThumbnail;
        this.userThumbnail = userThumbnail;
        this.plateEvaluation = plateEvaluation;
        this.price = price;
        this.userEvaluation = userEvaluation;
    }

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

    public int getPlateThumbnail() {
        return plateThumbnail;
    }

    public void setPlateThumbnail(int plateThumbnail) {
        this.plateThumbnail = plateThumbnail;
    }

    public int getUserThumbnail() {
        return userThumbnail;
    }

    public void setUserThumbnail(int userThumbnail) {
        this.userThumbnail = userThumbnail;
    }

    public double getPlateEvaluation() {
        return plateEvaluation;
    }

    public void setPlateEvaluation(double plateEvaluation) {
        this.plateEvaluation = plateEvaluation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getUserEvaluation() {
        return userEvaluation;
    }

    public void setUserEvaluation(double userEvaluation) {
        this.userEvaluation = userEvaluation;
    }

}
