package com.example.dialogdemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	private StringProperty firstName;
	private StringProperty lastName;

//	private StringProperty address;

	public Person(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
	}

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
//Núna er ListView<String>  Breyttu honum þannig að hann sé ListView<Person> (Breyttu Person.java þannig að hann hafi toString aðferðina og Main.java amk)
	public String toString() {
		return firstName.getValue() + " "+lastName.getValue();
	}
}
