package edu.csuft.assess.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.csuft.assess.exception.NotFoundEvaluateException;
import edu.csuft.assess.exception.NotFoundMemberException;
import edu.csuft.assess.exception.NotMatchPwdException;
import edu.csuft.assess.service.Item;
import edu.csuft.assess.service.Submit;
import edu.csuft.assess.service.User;
import edu.csuft.assess.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/changePwd")
	public boolean changePassword(@RequestBody HashMap<String, String> pwd) {
		boolean b = false;
		try {
			b = userService.changePassword(pwd);
		} catch (NotMatchPwdException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	@PostMapping("/changeSecureQ")
	public boolean changeSecureQue(@RequestBody HashMap<String, String> question) {
		return userService.changeSecureQuestion(question);
	}
	
	@GetMapping("/querySelect")
	public List<Item> querySelect(@RequestParam String teacher){
		List<Item> items = new ArrayList<>();
		try {
			items = userService.queryEvaluate(teacher);
		} catch (NotFoundEvaluateException e) {
			e.printStackTrace();
			return items;
		}
		return items;
	}
	
	@GetMapping("/queryTotal")
	public List<Integer> queryTotal(String teacher) {
		List<Integer> total = new ArrayList<>();
		try {
			total= userService.queryTotal(teacher);
		} catch (NotFoundEvaluateException e) {
			e.printStackTrace();
			return total;
		}
		return total;
	}
	
	@PostMapping("/submit")
	public Map<String, Object> submitAss(@RequestBody Submit submit){
		return userService.submitAssess(submit);
	}
	
	@GetMapping("/querySubject")
	public List<String> querySubject(){
		return userService.querySubject();
	}
	
	@GetMapping("/queryItems")
	public List<Item> queryItems(){
		return userService.queryItems();
	}
	
	@GetMapping("/allMember")
	public List<User> queryAllMember(@RequestParam String role) {
		List<User> members = new ArrayList<>();
		try {
			members = userService.queryAllMember(role);
		} catch (NotFoundMemberException e) {
			e.printStackTrace();
			return members;
		}
		return members;
	}
	
	@PostMapping("/delMember")
	public boolean delMember(@RequestBody HashMap<String, String> user) {
		return userService.delMember(user);
	}
	
	@PostMapping("/addMember")
	public boolean addMember(@RequestBody HashMap<String, String> user) {
		return userService.addMember(user);
	}
	
	@PostMapping("/accredit")
	public boolean accredit(@RequestBody HashMap<String, String> user) {
		return userService.accredit(user);
	}
}
