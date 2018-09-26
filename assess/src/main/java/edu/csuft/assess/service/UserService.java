package edu.csuft.assess.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.csuft.assess.exception.InvalidAuthorityException;
import edu.csuft.assess.exception.InvalidNameException;
import edu.csuft.assess.exception.InvalidPwdException;
import edu.csuft.assess.exception.NotFoundEvaluateException;
import edu.csuft.assess.exception.NotFoundMemberException;
import edu.csuft.assess.exception.NotFoundSecureQueException;
import edu.csuft.assess.exception.NotFoundUserException;
import edu.csuft.assess.exception.NotMatchPwdException;
import edu.csuft.assess.exception.NotMatchSecureAnsException;

public interface UserService {
	
	/**
	 * 登录
	 * @param user
	 * @return
	 * @throws InvalidNameException
	 * @throws InvalidPwdException
	 * @throws InvalidAuthorityException
	 */
	User login(User user) throws InvalidNameException, InvalidPwdException,InvalidAuthorityException;
	
	/**
	 * 修改密码
	 * @return
	 * @throws NotMatchPwdException 
	 */
	boolean changePassword(HashMap<String, String> pwd) throws NotMatchPwdException;
	
	/**
	 * 修改密保问题
	 * @return
	 */
	boolean changeSecureQuestion(HashMap<String, String> question);
	
	/**
	 * 找回密码
	 * @throws NotMatchSecureAnsException 
	 */
	boolean regainPassword(HashMap<String, String> regainPwd) throws NotMatchSecureAnsException;
	
	/**
	 * 查询评分详情
	 * @return
	 * @throws NotFoundEvaluateException 
	 */
	List<Item> queryEvaluate(String teacherName) throws NotFoundEvaluateException;
	
	/**
	 * 查询评分总分
	 * @param teacherName
	 * @return
	 * @throws NotFoundEvaluateException 
	 */
	List<Integer> queryTotal(String teacherName) throws NotFoundEvaluateException;
	
	/**
	 * 提交评价
	 * @param submit
	 * @return
	 */
	Map<String, Object> submitAssess(Submit submit);
	
	/**
	 * 查询密保问题
	 * @return
	 * @throws NotFoundSecureQueException 
	 * @throws NotFoundUserException 
	 */
	Map<String, String> querySecureQue(String name) throws NotFoundSecureQueException, NotFoundUserException;
	
	/**
	 * 查询所有学员/教员
	 * @param role
	 * @return
	 * @throws NotFoundMemberException 
	 */
	List<User> queryAllMember(String role) throws NotFoundMemberException;
	
	/**
	 * 删除学员/教员
	 * @param user
	 * @return
	 */
	boolean delMember(HashMap<String, String> user);

	/**
	 * 添加学员/教员
	 * @param user
	 * @return
	 */
	boolean addMember(HashMap<String, String> user);
	
	/**
	 * 授权教员
	 * @param user
	 * @return
	 */
	boolean accredit(HashMap<String, String> user);
	
	/**
	 * 查询进行评分的题目
	 * @return
	 */
	List<String> querySubject();
	
	/**
	 * 查询题目的选项
	 * @return
	 */
	List<Item> queryItems();
}
