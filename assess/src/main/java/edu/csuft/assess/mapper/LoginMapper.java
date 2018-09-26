package edu.csuft.assess.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.csuft.assess.service.User;

@Mapper
public interface LoginMapper {
	
	@Select("SELECT name,password,authority FROM login WHERE name=#{name}")
	User checkUser(String name);
	
	@Update("UPDATE login SET password=#{password} WHERE name=#{name} AND secureanswer=#{answer}")
	boolean regainPwd(String password,String name,String answer);
}
