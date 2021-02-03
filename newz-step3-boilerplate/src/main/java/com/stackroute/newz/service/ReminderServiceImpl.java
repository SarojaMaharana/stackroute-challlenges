package com.stackroute.newz.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.Reminder;
import com.stackroute.newz.repository.ReminderRepository;
import com.stackroute.newz.service.ReminderService;
import com.stackroute.newz.util.exception.ReminderNotExistsException;

import javax.transaction.Transactional;

/*
 * This class is implementing the ReminderService interface. This class has to be annotated with 
 * @Service annotation.
 * @Service - is an annotation that annotates classes at the service layer, thus 
 * clarifying it's role.
 * 
 * */

@Service
@Transactional
public class ReminderServiceImpl implements ReminderService {

	private ReminderRepository reminderRepository;

	/*
	 * Autowiring should be implemented for the ReminderRepository.
	 */

	@Autowired
	public ReminderServiceImpl(ReminderRepository reminderRepository) {
		this.reminderRepository = reminderRepository;
	}

	/*
	 * Add a new reminder.
	 */
	public Reminder addReminder(Reminder reminder) {
		reminder.setSchedule(LocalDateTime.now());
		final Reminder newReminder = reminderRepository.save(reminder);
		return newReminder;
	}

	/*
	 * Update an existing reminder by it's reminderId. Throw ReminderNotExistsException 
	 * if the reminder with specified reminderId does not exist.
	 */
	public Reminder updateReminder(Reminder reminder) throws ReminderNotExistsException {
		final Reminder optionalReminder = reminderRepository.getOne(reminder.getReminderId());
		if(optionalReminder == null) throw new ReminderNotExistsException();
		final Reminder updatedReminder = reminderRepository.saveAndFlush(reminder);
		return updatedReminder;

	}

	/*
	 * Delete an existing reminder by it's reminderId. Throw ReminderNotExistsException if 
	 * the reminder with specified reminderId does not exist.
	 */
	public void deleteReminder(int reminderId) throws ReminderNotExistsException {
		final Reminder optionalReminder = reminderRepository.getOne(reminderId);
		if(optionalReminder == null) throw new ReminderNotExistsException();
		reminderRepository.deleteById(reminderId);
	}

	/*
	 * Retrieve an existing reminder by it's reminderId. Throw ReminderNotExistsException 
	 * if the reminder with specified reminderId does not exist.
	 */
	public Reminder getReminder(int reminderId) throws ReminderNotExistsException {
		final Optional<Reminder> optionalReminder = reminderRepository.findById(reminderId);
		if(optionalReminder.isEmpty()) throw new ReminderNotExistsException();
		return optionalReminder.get();
	}

	/*
	 * Retrieve all existing reminders
	 */
	public List<Reminder> getAllReminders() {
		return reminderRepository.findAll();
	}
}
