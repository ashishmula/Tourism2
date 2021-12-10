package com.abhishek.tourism;

import java.io.Serializable;

class Place implements Serializable {
    String name;
    int ticketPrice;
    int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Place(String name, int ticketPrice, int image) {
        this.name = name;
        this.ticketPrice = ticketPrice;
        this.image = image;
    }
}
