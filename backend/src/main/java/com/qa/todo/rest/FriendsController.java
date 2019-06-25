package com.qa.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.todo.business.IFriendsService;
import com.qa.todo.constants.Constants;
import com.qa.todo.domain.Friends;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FriendsController {

	@Autowired
	private IFriendsService friendsService;

	@GetMapping(path = Constants.FRIENDS)
	public ResponseEntity<List<Friends>> getFriends() {
		return ResponseEntity.ok(friendsService.getFriends());
	}
	
	@RequestMapping(value = Constants.FRIENDS, method = RequestMethod.POST)
	public ResponseEntity<Friends> postTodo(@RequestBody Friends todo) {
		return ResponseEntity.ok(friendsService.addFriends(todo));
	}

	@RequestMapping(value = Constants.FRIENDS_WITH_PARAM, method = RequestMethod.DELETE)
	public ResponseEntity<List<Friends>> deleteFriends(@PathVariable("id") long id) {
		if (!friendsService.findById(id).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		friendsService.deleteFriends(id);
		return ResponseEntity.ok(friendsService.getFriends());
	}



}