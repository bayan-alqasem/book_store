package jo.jordan.JordanBookStore.service;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jo.jordan.JordanBookStore.entity.User;
import jo.jordan.JordanBookStore.entity.UserPrinciple;
import jo.jordan.JordanBookStore.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		UserPrinciple userPrinciple = new UserPrinciple(user);
		return userPrinciple;
	}

}