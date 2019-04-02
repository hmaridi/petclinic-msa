
package org.springframework.samples.petclinic.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class OwnerDetails {

	private int id;

	private String firstName;

	private String lastName;

	private String address;

	private String city;

	private String telephone;

	private final List<PetDetails> pets = new ArrayList<>();

	@JsonIgnore
	public List<Integer> getPetIds() {
		return pets.stream().map(PetDetails::getId).collect(toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<PetDetails> getPets() {
		return pets;
	}

}
