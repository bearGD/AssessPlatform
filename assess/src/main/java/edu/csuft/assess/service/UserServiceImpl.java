package edu.csuft.assess.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csuft.assess.exception.InvalidAuthorityException;
import edu.csuft.assess.exception.InvalidNameException;
import edu.csuft.assess.exception.InvalidPwdException;
import edu.csuft.assess.exception.NotFoundEvaluateException;
import edu.csuft.assess.exception.NotFoundMemberException;
import edu.csuft.assess.exception.NotFoundSecureQueException;
import edu.csuft.assess.exception.NotFoundUserException;
import edu.csuft.assess.exception.NotMatchPwdException;
import edu.csuft.assess.exception.NotMatchSecureAnsException;
import edu.csuft.assess.mapper.LoginMapper;
import edu.csuft.assess.mapper.OperateMapper;
import edu.csuft.assess.mapper.QueryMapper;
import edu.csuft.assess.util.StringUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	LoginMapper loginMapper;

	@Autowired
	OperateMapper operateMapper;

	@Autowired
	QueryMapper queryMapper;

	@Override
	public User login(User user) throws InvalidNameException, InvalidPwdException, InvalidAuthorityException {
		User u = loginMapper.checkUser(user.getName());
		if (u == null) {
			throw new InvalidNameException(user.getName());
		}
		if (!u.getPassword().equals(StringUtil.stringToSHA256(user.getPassword()))) {
//			if (!u.getPassword().equals(user.getPassword())) {
			throw new InvalidPwdException();
		}
		if (!u.getAuthority().equals(user.getAuthority())) {
			throw new InvalidAuthorityException();
		}
		return u;
	}

	@Override
	public boolean changePassword(HashMap<String, String> pwd) throws NotMatchPwdException {
		
		boolean b = operateMapper.changePwd(StringUtil.stringToSHA256(pwd.get("newpwd")), StringUtil.stringToSHA256(pwd.get("oldpwd")), pwd.get("name"));
//		boolean b = operateMapper.changePwd(pwd.get("newpwd"), pwd.get("oldpwd"), pwd.get("name"));
		if (!b) {
			throw new NotMatchPwdException();
		}
		return b;
	}

	@Override
	public boolean changeSecureQuestion(HashMap<String, String> que) {
		return operateMapper.changeSecureQue(que.get("question"), StringUtil.stringToSHA256(que.get("answer")), que.get("name"));
	}

	
	@Override
	public Map<String, String> querySecureQue(String name) throws NotFoundSecureQueException, NotFoundUserException {
		Map<String, String> que = new HashMap<>();
		que = queryMapper.queryUser(name);
		if(que==null) {
			throw new NotFoundUserException();
		}
		que = queryMapper.queryQuestion(name);
		if(que==null) {
			throw new NotFoundSecureQueException();
		}
		return que;
	}
	
	@Override
	public boolean regainPassword(HashMap<String, String> regainPwd) throws NotMatchSecureAnsException {
		boolean b = loginMapper.regainPwd(StringUtil.stringToSHA256(regainPwd.get("password")), regainPwd.get("name"), StringUtil.stringToSHA256(regainPwd.get("answer")));
		if (!b) {
			throw new NotMatchSecureAnsException();
		}
		return b;
	}

	@Override
	public List<Item> queryEvaluate(String teacherName) throws NotFoundEvaluateException {
		List<Item> items = new ArrayList<>();
		items = queryMapper.querySelect(teacherName);
		if(items.size()==0) {
			throw new NotFoundEvaluateException();
		}
		return items;
	}

	@Override
	public List<Integer> queryTotal(String teacherName) throws NotFoundEvaluateException {
		List<Integer> total = new ArrayList<>();
		total = queryMapper.querySum(teacherName);
		if(total.size()==0) {
			throw new NotFoundEvaluateException();
		}
		return total;
	}

	@Override
	public Map<String, Object> submitAssess(Submit submit) {
		operateMapper.addSubmit(submit.getTeacherName(), submit.getClassName());
		int lastId = operateMapper.lastInsertId();
		operateMapper.addSumScore(lastId, submit.getSumScore());
		for(int i = 1; i <= 8;i++) {
			operateMapper.addAnswers(i, lastId, submit.getItemId().get(i-1));			
		}
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "ok");
		return map;
	}
	
	@Override
	public List<User> queryAllMember(String role) throws NotFoundMemberException {
		List<User> users = new ArrayList<>();
		users = queryMapper.queryMemberByRole(role);
		if(users.isEmpty()) {
			throw new NotFoundMemberException();
		}
		return users;
	}

	@Override
	public boolean delMember(HashMap<String, String> user) {
		return operateMapper.del(user.get("name"));
	}

	@Override
	public boolean addMember(HashMap<String, String> user) {
		return operateMapper.add(user.get("name"), user.get("authority"), user.get("role"));
	}

	@Override
	public boolean accredit(HashMap<String, String> user) {
		return operateMapper.changeAuthority(user.get("name"));
	}

	@Override
	public List<String> querySubject() {
		return queryMapper.getSubjects();
	}

	@Override
	public List<Item> queryItems() {
		return queryMapper.getItems();
	}


}
