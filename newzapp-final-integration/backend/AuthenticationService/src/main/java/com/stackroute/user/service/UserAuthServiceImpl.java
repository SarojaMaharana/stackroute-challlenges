package com.stackroute.user.service;

import com.stackroute.user.model.User;
import com.stackroute.user.repository.UserAuthRepository;
import com.stackroute.user.service.UserAuthService;
import com.stackroute.user.util.exception.UserAlreadyExistsException;
import com.stackroute.user.util.exception.UserIdAndPasswordMismatchException;
import com.stackroute.user.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 * Service classes are used here to implement additional business logic/validation
 * This class has to be annotated with @Service annotation.
 * @Service - It is a specialization of the component annotation. It doesn't currently
 * provide any additional behavior over the @Component annotation, but it's a good idea
 * to use @Service over @Component in service-layer classes because it specifies intent
 * better. Additionally, tool support and additional behavior might rely on it in the
 * future.
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

	private UserAuthRepository userAuthRepository;

	/*
	 * Autowiring should be implemented for the UserAuthRepository and SQL Operation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	@Autowired
	public UserAuthServiceImpl(UserAuthRepository userAuthRepository) {
		this.userAuthRepository = userAuthRepository;
	}

	/*
	 * This method should be used to find an existing User with correct password.
	 */

	@Override
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException, UserIdAndPasswordMismatchException {
		final Optional<User> optionalUser = userAuthRepository.findById(userId);
		if(optionalUser.isEmpty()) throw new UserNotFoundException("User is not found");
		final User existingUser = userAuthRepository.findByUserIdAndPassword(userId, password);
		if(existingUser == null) throw new UserIdAndPasswordMismatchException("UserId or password is incorrect");
		return existingUser;

	}

	/*
	 * This method should be used to save a new User.
	 */

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		if(userAuthRepository.findById(user.getUserId()).isPresent()) throw new UserAlreadyExistsException("user already exists");
		userAuthRepository.save(user);
		return true;
	}
}
