package com.delaroystudios.MatchFood.model;

/**
 * Created by Lucas on 27/03/2017.
 */

public class Order {
    private Restaurant restaurant;
    private Plates plate;
    private String date;

    public Order(Restaurant restaurant, Plates plate, String date){
        this.restaurant = restaurant;
        this.plate = plate;
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Plates getPlate() {
        return plate;
    }

    public void setPlate(Plates plate) {
        this.plate = plate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}