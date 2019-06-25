package com.qa.todo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.todo.domain.Friends;
import com.qa.todo.persistence.FriendsRepository;

@Service
public class FriendsService implements IFriendsService {
	
	@Autowired
	private FriendsRepository friendsRepository;
	
	public List<Friends> getFriends() {
		return friendsRepository.findAll();
	}

	public void deleteFriends(Long id) {
		friendsRepository.deleteById(id);
		
	}

	public Friends addFriends(Friends friends) {
		return friendsRepository.save(friends);
	}

	public Optional<Friends> findById(long id) {
		return friendsRepository.findById(id);
	}
}
