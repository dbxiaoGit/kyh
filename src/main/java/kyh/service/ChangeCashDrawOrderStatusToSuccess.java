package kyh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kyh.dao.custom.WiseDao;
import kyh.entity.CashDrawOrder;

@Service
public class ChangeCashDrawOrderStatusToSuccess {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
    WiseDao wiseDao;
	
	public Map<String,String> fangKuan(String memberCode) {
		Map<String,String> resultMap = new HashMap<String,String>();
		List<CashDrawOrder> lCashDrawOrder = wiseDao.getCashDrawOrderFostatus2(memberCode);
		if(lCashDrawOrder.size() == 0) {
			resultMap.put("message",memberCode + "没有放款中的交易");
			return resultMap;
		}
		lCashDrawOrder.forEach(cashDrawOrder -> {
			String resuleKey = memberCode + "_" + cashDrawOrder.getId_cash_draw_order();
			try {
				wiseDao.updateCashDrawOrderFostatusTo3(memberCode);
				resultMap.put(resuleKey, "success");
			}catch(Exception e) {
				logger.error(e.toString());
				resultMap.put(resuleKey, "fail");
			}
		});
		return resultMap;
	}
	
	public Map<String,String> missMemberCodeFangKuan() {
		Map<String,String> resultMap = new HashMap<String,String>();
		List<CashDrawOrder> lCashDrawOrder = wiseDao.getAllCashDrawOrderFostatus2();
		if(lCashDrawOrder.size() == 0) {
			resultMap.put("message","没有放款中的交易");
			return resultMap;
		}
		lCashDrawOrder.forEach(cashDrawOrder -> {
			String memberCode = cashDrawOrder.getFo_membercode();
			String resuleKey = memberCode + "_" + cashDrawOrder.getId_cash_draw_order();
			try {
				wiseDao.updateCashDrawOrderFostatusTo3(memberCode);
				resultMap.put(resuleKey, "success");
			}catch(Exception e) {
				logger.error(e.toString());
				resultMap.put(resuleKey, "fail");
			}
		});
		return resultMap;
	}
	
}
