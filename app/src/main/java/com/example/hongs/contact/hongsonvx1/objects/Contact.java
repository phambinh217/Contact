package com.example.hongs.contact.hongsonvx1.objects;

/**
 * Created by hongs on 2018-03-16.
 *
 */

public class Contact {
    private String name;
    private String numberPhone;

    public Contact() {
    }

    public Contact(String name, String numberPhone) {
        this.name = name;
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
