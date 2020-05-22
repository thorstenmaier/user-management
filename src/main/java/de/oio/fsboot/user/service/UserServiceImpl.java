package de.oio.fsboot.user.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import de.oio.fsboot.user.domain.User;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getAllUsers() {
		return Arrays.asList(new User("Guenther", "Nubert"), new User("Bud", "Spencer"), new User("Dieter", "Develop"));
	}
}
