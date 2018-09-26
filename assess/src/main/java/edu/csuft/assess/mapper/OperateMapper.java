package edu.csuft.assess.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OperateMapper {

	
	/**
	 * 添加提交的记录
	 */
	@Insert("INSERT INTO submit(teacher,class,time) VALUES(#{teacherName},#{className},Now())")
	void addSubmit( String teacherName, String className);

	/**
	 * 添加总分
	 */
	@Insert("INSERT INTO sumscore(submit_id,sum) VALUES(#{id},#{sumScore})")
	void addSumScore(int id, int sumScore);

	/**
	 * 添加答案
	 */
	@Insert("INSERT INTO answers(sub_id,submit_id,item_id) VALUES(#{subId},#{submitId},#{itemId})")
	void addAnswers(int subId, int submitId, int itemId);
	/**
	 * 修改密码
	 * @param newPwd
	 * @param oldPwd
	 * @param name
	 * @return
	 */
	@Update("UPDATE login SET password=#{newPwd} WHERE password=#{oldPwd} AND name=#{name}")
	public boolean changePwd(String newPwd,String oldPwd,String name);
	
	/**
	 * 修改密保问题
	 * @param question
	 * @param answer
	 * @param name
	 * @return
	 */
	@Update("UPDATE login SET securequestion=#{question},secureanswer=#{answer} WHERE name=#{name}")
	public boolean changeSecureQue(String question,String answer,String name);
	
	@Select("SELECT last_insert_id()")
	public int lastInsertId();
	
	@Delete("DELETE FROM login WHERE name=#{name}")
	public boolean del(String name);
	
	@Update("UPDATE login SET authority='1' WHERE name = #{name}")
	public boolean changeAuthority(String name);
	
	@Insert("INSERT INTO login(name,password,authority,role) VALUES(#{name},'8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',#{authority},#{role})")
	public boolean add(String name,String authority,String role);
}
