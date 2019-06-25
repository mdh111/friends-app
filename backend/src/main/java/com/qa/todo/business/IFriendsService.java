package com.qa.todo.business;

import java.util.List;
import java.util.Optional;

import com.qa.todo.domain.Friends;

public interface IFriendsService {

	List<Friends> getFriends();

	void deleteFriends(Long id);

	Friends addFriends(Friends friends);

	Optional<Friends> findById(long id);

}