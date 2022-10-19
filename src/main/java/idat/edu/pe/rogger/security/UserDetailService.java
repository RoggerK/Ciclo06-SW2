package idat.edu.pe.rogger.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("rogger".equals(username)) {
			return new User("rogger","123", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Usuario no existe " + username);
		}
	}

}
