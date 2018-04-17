package kyh.dao.custom;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kyh.entity.custom.FcsAcctRegister;

@Mapper
public interface FcsAcctRegisterDao {

	@Select("select * from (select * from wise.fcs_acct_register order by id desc) where rownum <=10 ")
	List<FcsAcctRegister> get10();
}
