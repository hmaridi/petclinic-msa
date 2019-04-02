
package org.springframework.samples.petclinic.customers.web;

import io.micrometer.core.annotation.Timed;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.customers.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Timed("petclinic.pet")
// @RequiredArgsConstructor
// @Slf4j
class PetResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(PetResource.class);

	@Autowired
	private PetRepository petRepository;
	@Autowired
	private OwnerRepository ownerRepository;

	@GetMapping("/petTypes")
	public List<PetType> getPetTypes() {
		return petRepository.findPetTypes();
	}

	@PostMapping("/owners/{ownerId}/pets")
	@ResponseStatus(HttpStatus.CREATED)
	public Pet processCreationForm(@RequestBody PetRequest petRequest, @PathVariable("ownerId") int ownerId) {

		final Pet pet = new Pet();
		final Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		Owner owner = optionalOwner.orElseThrow(() -> new ResourceNotFoundException("Owner " + ownerId + " not found"));
		owner.addPet(pet);
		LOGGER.info("Update Pets {}", petRequest, pet);
		return save(pet, petRequest);
	}

	@PutMapping("/owners/*/pets/{petId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void processUpdateForm(@RequestBody PetRequest petRequest) {
		int petId = petRequest.getId();
		Pet pet = findPetById(petId);
		LOGGER.info("Update Pets {}", petRequest);
		save(pet, petRequest);
	}

	private Pet save(final Pet pet, final PetRequest petRequest) {
		pet.setName(petRequest.getName());
		pet.setBirthDate(petRequest.getBirthDate());
		petRepository.findPetTypeById(petRequest.getTypeId()).ifPresent(pet::setType);
		LOGGER.info("Saving pet {}", pet);
		return petRepository.save(pet);
	}

	@GetMapping("owners/*/pets/{petId}")
	public PetDetails findPet(@PathVariable("petId") int petId) {
		LOGGER.info("Find By petId {}", petId);
		return new PetDetails(findPetById(petId));
	}

	private Pet findPetById(int petId) {
		Optional<Pet> pet = petRepository.findById(petId);
		if (!pet.isPresent()) {
			throw new ResourceNotFoundException("Pet " + petId + " not found");
		}
		LOGGER.info("Find By petId {}", petId);
		return pet.get();
	}

}
