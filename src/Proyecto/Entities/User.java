package Proyecto.Entities;

import Proyecto.Helpers.ConnectionDB;
import Proyecto.Helpers.Hash;

public class User {
	private String username;
	private String passwordHsh;
	private String email;
	private int age;
	private String gender;
	private String country;

	public boolean save() {
		String PassHash = Hash.Encriptar(this.passwordHsh);

		try {

			String query = String.format(
					"INSERT INTO users (username, passHash, email, age, country, gender) VALUES ('%s', '%s', '%s', %s, '%s', '%s')",
					this.username, PassHash, this.email, this.age, this.country, this.gender);
			
			return ConnectionDB.executeUpdate(query);
		} catch (Exception e) {
			return false;
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPasswordHsh() {
		return passwordHsh;
	}

	public void setPasswordHsh(String passwordHsh) {
		this.passwordHsh = passwordHsh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
