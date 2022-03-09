package kms.dat.zego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kms.dat.zego.Repository.UserRepository;
import kms.dat.zego.models.User;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException("Couldn't found user");
		}
		return new MyUserDetails(user);
	}

}
