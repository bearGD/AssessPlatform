package edu.csuft.assess.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.csuft.assess.exception.InvalidAuthorityException;
import edu.csuft.assess.exception.InvalidNameException;
import edu.csuft.assess.exception.InvalidPwdException;
import edu.csuft.assess.exception.NotFoundSecureQueException;
import edu.csuft.assess.exception.NotFoundUserException;
import edu.csuft.assess.exception.NotMatchSecureAnsException;
import edu.csuft.assess.service.User;
import edu.csuft.assess.service.UserService;

@RestController
@RequestMapping("/v1/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 登录用户核对
	 * @param user
	 * @param session
	 * @return
	 */
	@PostMapping("/")
	public int checkUser(@RequestBody User user,HttpSession session) {
		try {
			User u = userService.login(user);
			session.setAttribute("n", u.getName());
			session.setAttribute("a", u.getAuthority());
		} catch (InvalidNameException e) {
			e.printStackTrace();
			return 1;
		} catch (InvalidPwdException e) {
			e.printStackTrace();
			return 2;
		} catch (InvalidAuthorityException e) {
			e.printStackTrace();
			return 3;
		}
		return 4;
	}
	
	@GetMapping
	public Map<String, Object> getUser(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", session.getAttribute("n"));
		map.put("authority", session.getAttribute("a"));
		session.invalidate();
		return map;
	}
	
	/**
	 * 找回密码
	 * @param newPwd
	 * @return
	 */
	@PostMapping("/regainPwd")
	public boolean regainPwd(@RequestBody HashMap<String, String> newPwd) {
		boolean b = false;
		try {
			b = userService.regainPassword(newPwd);
		} catch (NotMatchSecureAnsException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	@GetMapping("/secureQue")
	public Map<String, String> getSecureQue(@RequestParam String name){
		Map<String, String> que = new HashMap<>();
		try {
			que = userService.querySecureQue(name);
		} catch (NotFoundSecureQueException e) {
			e.printStackTrace();
			que.put("question", "not");
			return que;
		} catch (NotFoundUserException e) {
			e.printStackTrace();
			que.put("user", "not");
			return que;
		}
		return que;
	}
}
