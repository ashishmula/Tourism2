package com.abhishek.tourism;

import java.util.ArrayList;

class Country {
String name,capital;
int image;
ArrayList<Place> places;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public Country(String name, String capital, int image, ArrayList<Place> places) {
        this.name = name;
        this.capital = capital;
        this.image = image;
        this.places = places;
    }
}
