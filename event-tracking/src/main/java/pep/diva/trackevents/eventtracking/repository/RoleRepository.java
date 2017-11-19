package pep.diva.trackevents.eventtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pep.diva.trackevents.eventtracking.model.Role;

/**
 * @author divakar
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
