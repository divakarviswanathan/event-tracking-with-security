package pep.diva.trackevents.eventtracking.service;

/**
 * @author divakar
 *
 */
public interface SecurityService {

    public String findLoggedInUsername();

    public void autologin(String username, String password);
}
