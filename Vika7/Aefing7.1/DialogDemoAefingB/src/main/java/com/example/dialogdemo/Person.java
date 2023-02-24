package com.example.dialogdemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	private StringProperty firstName;
	private StringProperty lastName;
	// B Bættu við þriðja sviðinu í dialoginn og Person sem er address. Taktu skjáskot af dialognum.

	private StringProperty address;

//	private StringProperty address;

	public Person(String firstName, String lastName, String address) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		// B Bættu við þriðja sviðinu í dialoginn og Person sem er address. Taktu skjáskot af dialognum.

		this.address = new SimpleStringProperty(address);
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

	// B Bættu við þriðja sviðinu í dialoginn og Person sem er address. Taktu skjáskot af dialognum.
	public StringProperty addressProperty() {
		return address;
    }

	public String getAddress() {
		return address.getValue();
	}
}
