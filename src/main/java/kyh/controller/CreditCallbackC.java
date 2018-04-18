package kyh.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kyh.service.CreditCallback;


@RestController
public class CreditCallbackC {

	Logger logger = LoggerFactory.getLogger(getClass());
    
	@Autowired
	CreditCallback creditCallback;
	
    @RequestMapping(value="/shouXin",produces="application/json;charset=UTF-8")
    public Map<String,String> creditCallback(@RequestParam String memberCode) {
    	logger.info("shouXin");
    	return creditCallback.doCreditCallbackByMemberCode(memberCode);
    }
	
    @RequestMapping(value="/missMemberCodeShouXin",produces="application/json;charset=UTF-8")
    public Map<String,String> creditCallback() {
    	logger.info("missMemberCodeShouXin");
    	return creditCallback.doAllCreditCallback();
    }
    
}
