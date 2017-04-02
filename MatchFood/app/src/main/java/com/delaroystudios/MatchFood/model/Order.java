package com.delaroystudios.MatchFood.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 27/03/2017.
 */

public class Order {
    private Restaurant restaurant;
    private Plate plate;
    private String date;
    private List<String> users;

    public Order(Restaurant restaurant, Plate plate, String date){
        this.restaurant = restaurant;
        this.plate = plate;
        this.date = date;
        this.users = new ArrayList<>();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getUsers(){
        return users;
    }

    public void addUser(String userId){
        if (plate.getAmount() > users.size()) {
            users.add(userId);
        }
    }

    public void removeUser(String userID){
        users.remove(userID);
    }
}
