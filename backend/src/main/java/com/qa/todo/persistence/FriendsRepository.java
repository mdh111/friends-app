package com.qa.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.todo.domain.Friends;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {
	
}
