package com.stackroute.newz.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.UserProfile;
import com.stackroute.newz.repository.UserProfileRepository;
import com.stackroute.newz.util.exception.UserProfileAlreadyExistsException;
import com.stackroute.newz.util.exception.UserProfileNotExistsException;

/*
 * This class is implementing the UserProfileRepository interface. This class has to be annotated with 
 * @Service annotation.
 * @Service - is an annotation that annotates classes at the service layer, thus 
 * clarifying it's role.
 * 
 * */
@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	private UserProfileRepository userProfileRepository;

	/*
	 * Autowiring should be implemented for the UserProfileRepository.
	 */

	@Autowired
	public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

	/*
	 * Add a new user. Throw UserProfileAlreadyExistsException if the userProfile with specified
	 * userId already exists.
	 */
	public UserProfile registerUser(UserProfile user) throws UserProfileAlreadyExistsException {
		Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(user.getUserId());
		if(optionalUserProfile.isPresent()) throw new UserProfileAlreadyExistsException();
//		user.setUserId(UUID.randomUUID().toString());
		user.setCreateAt(LocalDateTime.now());
		final UserProfile newUserProfile = userProfileRepository.save(user);
		return newUserProfile;
	}

	/*
	 * Update an existing userProfile by it's userId. Throw UserProfileNotExistsException 
	 * if the userProfile with specified userId does not exist.
	 */
	public UserProfile updateUserProfile(UserProfile user, String userId) 
			throws UserProfileNotExistsException {
		final UserProfile optionalUserProfile = userProfileRepository.getOne(userId);
		if(optionalUserProfile == null) throw new UserProfileNotExistsException();
		final UserProfile updatedUserProfile = userProfileRepository.saveAndFlush(user);
		return updatedUserProfile;
	}

	
	/*
	 * Delete an existing userProfile by it's userId. Throw UserProfileNotExistsException if 
	 * the userProfile with specified userId does not exist.
	 */
	public void deleteUserProfile(String userId) throws UserProfileNotExistsException {
		final UserProfile optionalUserProfile = userProfileRepository.getOne(userId);
		if(optionalUserProfile == null) throw new UserProfileNotExistsException();
		userProfileRepository.deleteById(userId);
	}
	
	
	/*
	 * Retrieve an existing userProfile by it's userId. Throw UserProfileNotExistsException 
	 * if the userProfile with specified userId does not exist.
	 */
	public UserProfile getUserProfile(String userId) throws UserProfileNotExistsException {
		Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(userId);
		if(optionalUserProfile.isEmpty()) throw new UserProfileNotExistsException();
		return optionalUserProfile.get();
	}

	/*
	 * Retrieve all existing userProfiles
	 */
	public List<UserProfile> getAllUserProfiles() {
		return userProfileRepository.findAll();
	}

}
