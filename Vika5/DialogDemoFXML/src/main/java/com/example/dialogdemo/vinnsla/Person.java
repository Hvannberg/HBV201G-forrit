package com.example.dialogdemo.vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// Vinnsluklasi fyrir einstakling

public class Person {
    private final StringProperty firstName; // fornafnið
    private final StringProperty lastName;    // eftirnafn

    /**
     * Smiður fyrir klasann. Tekur inn fornafn og eftirnafn
     *
     * @param firstName fornafn
     * @param lastName  eftirnafn
     */
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }
    // takið eftir nafnahefðunum hér fyrir property tilviksbreytu
    // þ.e. firstNameProperty og getFirstName
    /**
     * property fyrir fornafn
     *
     * @return fornafns property
     */
    public StringProperty firstNameProperty() {
        return firstName;
    }

    /**
     * skilar fornafninu
     *
     * @return fornafnið
     */

    public String getFirstName() {
        return firstName.get();
    }


    /**
     * eftirnafns property
     *
     * @return property fyrir eftirnafn
     */
    public StringProperty lastNameProperty() {
        return lastName;
    }

    ;

    /**
     * skilar eftirnafninu
     *
     * @return eftirnafnið
     */
    public String getLastName() {
        return lastName.get();
    }

}
