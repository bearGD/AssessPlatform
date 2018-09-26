package edu.csuft.assess.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.csuft.assess.service.Item;
import edu.csuft.assess.service.User;

@Mapper
public interface QueryMapper {
	
	/**
	 * 获取到评分题目
	 * 
	 * @return
	 */
	@Select("SELECT content FROM subject")
	List<String> getSubjects();

	/**
	 * 获取到选项
	 * 
	 * @return
	 */
	@Select("SELECT id,sub_id,content,score FROM items")
	List<Item> getItems();

	@Select("SELECT name,authority FROM login WHERE role = #{role}")
	public List<User> queryMemberByRole(String role);
	
	@Select("SELECT securequestion FROM login WHERE name = #{name} ")
	public Map<String,String> queryQuestion(String name);
	
	/**
	 * 查询学员对某位老师的评价
	 * @param teacher
	 * @return
	 */
	@Select("SELECT a.sub_id,i.content,i.score,s.time FROM answers AS a,items AS i,submit AS s WHERE a.submit_id IN (SELECT id FROM submit WHERE teacher=#{teacher}) AND a.item_id = i.id AND s.id = a.submit_id")
	List<Item> querySelect(String teacher);
	
	/**
	 * 查询学员对某位老师评价的分数
	 * @param teacher
	 * @return
	 */
	@Select("SELECT sum FROM sumscore WHERE submit_id IN (SELECT id FROM submit WHERE teacher=#{teacher})")
	List<Integer> querySum(String teacher);
	
	@Select("SELECT id FROM login WHERE name = #{name}")
	Map<String, String> queryUser(String name);
}
