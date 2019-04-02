
package org.springframework.samples.petclinic.visits.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

	public List<Visit> findByPetId(int petId);

	public List<Visit> findByPetIdIn(Iterable<Integer> petIds);
}
