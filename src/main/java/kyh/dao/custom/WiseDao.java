package kyh.dao.custom;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kyh.entity.CashDrawOrder;
import kyh.entity.FcsAcctRegister;

@Mapper
public interface WiseDao {

	@Select("select * from (select * from wise.fcs_acct_register order by id desc) where rownum <=10 ")
	List<FcsAcctRegister> getRegister10();
	
	@Select("select * from wise.fcs_acct_register where status = 1")
	List<FcsAcctRegister> getRegisterStatus1();
	
	@Select("select * from wise.fcs_acct_register where status = 1 and member_code=#{member_code}")
	List<FcsAcctRegister> getOneRegisterStatus1(@Param("member_code") String member_code);
	
	@Update("update wise.fcs_acct_register set status = 1 where status = 3")
	void updateRegisterStatus3To1();
	
	@Update("update wise.fcs_acct_register set status = 1 where status = 3 and member_code=#{member_code}")
	void updateOneRegisterStatus3To1(@Param("member_code") String member_code);
	
	@Select("select * from wise.t_cash_draw_order where fo_status = 2 and fo_membercode=#{fo_memberCode} ")
	List<CashDrawOrder> getCashDrawOrderFostatus2(@Param("fo_memberCode") String fo_memberCode);
	
	@Update("update wise.wise.t_cash_draw_order set fo_status = 3 where fo_status = 2 and fo_membercode=#{fo_memberCode}")
	void updateCashDrawOrderFostatusTo3(@Param("fo_memberCode") String fo_memberCode);
	
	@Select("select * from wise.t_cash_draw_order where fo_status = 2 ")
	List<CashDrawOrder> getAllCashDrawOrderFostatus2();
	
}
