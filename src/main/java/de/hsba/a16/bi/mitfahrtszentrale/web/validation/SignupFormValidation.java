package de.hsba.a16.bi.mitfahrtszentrale.web.validation;

import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignupFormValidation {
	@Size.List({
		@Size(min = 4, message = "Ihre Eingabe muss mindesten 4 Buchstaben sein"),
		@Size(max = 30, message = "Ihre muss max 30 Buchstaben sein")
	})

	private String name;
	@Size.List({
		@Size(min = 2, message = "Ihre Eingabe muss mindesten 4 Buchstaben sein"),
		@Size(max = 30, message = "Ihre muss max 30 Buchstaben sein")
	})
	private String firstName, lastName;

	@Size.List({
		@Size(min = 6, message = "Ihr Passwort muss mindesten 6 Buchstaben sein"),
		@Size(max = 30, message = "Ihre Password kann max 30 Buchstaben sein")
	})
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Email(message = "Die Form Ihrer E-Mail ist nicht vollständig")
	private String email;

	public SignupFormValidation() {
	}

	public SignupFormValidation(User user) {
		user.setName(getName());
		user.setPassword(getPassword());
		user.setFirstName(getFirstName());
		user.setLastName(getLastName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
