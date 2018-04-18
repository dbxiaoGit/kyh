package kyh.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.*;

import kyh.entity.User;

@Mapper
public interface UserDao {

	
    @Select("SELECT * FROM gringotts.t_user order by id desc limit 10")
	List<User> get10();
	
	User getOne(int id);

	//void insert(User user) 

	void update(User user) ;

	void delete(int id) ;
}
