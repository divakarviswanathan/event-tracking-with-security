package pep.diva.trackevents.eventtracking.service;

import pep.diva.trackevents.eventtracking.model.User;

/**
 * @author divakar
 *
 */
public interface UserService {

    public void save(User user);

    public User findByUsername(String username);
}

