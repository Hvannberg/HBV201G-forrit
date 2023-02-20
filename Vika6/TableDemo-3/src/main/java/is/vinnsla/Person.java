package is.vinnsla;

/**
 *  * Dæmi sem er tekið upprunalega frá JavaCodeJunkie
 *  Vinnsluklasi fyrir gögn um persónu
 *
 */
public class Person {
	private String firstName;
	private String lastName;
	private int age;

	public Person() {
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
	}

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setAge(int age) {
		this.age = age;
	}
}
