
package org.springframework.samples.petclinic.api.dto;

import java.util.ArrayList;
import java.util.List;


public class PetDetails {

	private int id;

	private String name;

	private String birthDate;

	private PetType type;

	private List<VisitDetails> visits = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public List<VisitDetails> getVisits() {
		return visits;
	}
  
    

}
