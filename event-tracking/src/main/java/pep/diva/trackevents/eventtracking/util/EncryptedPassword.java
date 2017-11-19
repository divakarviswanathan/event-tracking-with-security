package pep.diva.trackevents.eventtracking.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author divakar
 *
 */
public class EncryptedPassword {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("divakar"));
	}

}
