package com.example.dialogdemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// Vinnsluklasi
public class Person {

	private final StringProperty firstName;
	private final StringProperty lastName;

	public Person(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
	}
	// takið eftir nafnahefðunum hér fyrir property tilviksbreytu þ.e. firstNameProperty og getFirstName

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	};

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
}
