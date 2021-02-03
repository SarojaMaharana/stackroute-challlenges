package com.stackroute.userprofile.service;

import com.stackroute.userprofile.model.UserProfile;
import com.stackroute.userprofile.repository.UserProfileRepository;
import com.stackroute.userprofile.util.exception.UserProfileAlreadyExistsException;
import com.stackroute.userprofile.util.exception.UserProfileNotFoundException;
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
* */

@Service
public class UserProfileServiceImpl implements UserProfileService {

	private UserProfileRepository userProfileRepository;

	/*
	 * Autowiring should be implemented for the UserProfileRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	@Autowired
	public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

	/*
	 * This method should be used to save a new userprofile.Call the corresponding method
	 * of Respository interface.
	 */

    public UserProfile registerUser(UserProfile user) throws UserProfileAlreadyExistsException {
		user.setCreatedAt();
		final Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(user.getUserId());
		if(optionalUserProfile.isPresent())
			throw new UserProfileAlreadyExistsException("user already exists");
		final UserProfile newUser = userProfileRepository.insert(user);
		if (newUser == null)
			throw new UserProfileAlreadyExistsException("user already exists");
        return newUser;
    }

	/*
	 * This method should be used to update a existing userprofile.Call the corresponding
	 * method of Respository interface.
	 */

    @Override
    public UserProfile updateUser(String userId, UserProfile user) throws UserProfileNotFoundException {
    	user.setCreatedAt();
		final Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(user.getUserId());
		if (optionalUserProfile.isEmpty())
			throw new UserProfileNotFoundException("user not found");
		userProfileRepository.save(user);
    	return user;
    }

	/*
	 * This method should be used to delete an existing user. Call the corresponding
	 * method of Respository interface.
	 */

    @Override
    public boolean deleteUser(String userId) throws UserProfileNotFoundException {
		final Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(userId);
		if (optionalUserProfile.isEmpty())
			throw new UserProfileNotFoundException("user not found");
		userProfileRepository.deleteById(userId);
        return true;
    }
    
	/*
	 * This method should be used to get userprofile by userId.Call the corresponding
	 * method of Respository interface.
	 */

    @Override
    public UserProfile getUserById(String userId) throws UserProfileNotFoundException {
		final Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(userId);
		if (optionalUserProfile.isEmpty())
			throw new UserProfileNotFoundException("user not found");
    	return userProfileRepository.findById(userId).get();
    }
}
