package pep.diva.trackevents.eventtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pep.diva.trackevents.eventtracking.model.User;

/**
 * @author divakar
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}
