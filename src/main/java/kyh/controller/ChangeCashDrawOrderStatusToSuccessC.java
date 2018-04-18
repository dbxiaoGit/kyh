package kyh.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kyh.service.ChangeCashDrawOrderStatusToSuccess;


@RestController
public class ChangeCashDrawOrderStatusToSuccessC {

	Logger logger = LoggerFactory.getLogger(getClass());
    
	@Autowired
	ChangeCashDrawOrderStatusToSuccess changeCashDrawOrderStatusToSuccess;
	
    @RequestMapping(value="/fangkuan",produces="application/json;charset=UTF-8")
    public Map<String,String> creditCallback(@RequestParam String memberCode) {
    	logger.info("fangkuan");
    	return changeCashDrawOrderStatusToSuccess.fangKuan(memberCode);
    }
    
    @RequestMapping(value="/missMemberCodeFangKuang",produces="application/json;charset=UTF-8")
    public Map<String,String> creditCallback() {
    	logger.info("fangkuan");
    	return changeCashDrawOrderStatusToSuccess.missMemberCodeFangKuan();
    }
    
}
