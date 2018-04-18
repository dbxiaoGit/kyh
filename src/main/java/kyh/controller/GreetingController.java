package kyh.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kyh.dao.custom.WiseDao;
import kyh.dao.master.UserDao;
import kyh.entity.FcsAcctRegister;
import kyh.entity.User;

@RestController
public class GreetingController {

	Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserDao userDao ;
    
    @Autowired
    WiseDao wiseDao;
    
    @Value("${spring.datasource.ds1.password}")
    private String testV1;
    
    @Value("${spring.datasource.ds2.password}")
    private String testV2;
    
    @RequestMapping(value="/mysql",produces="application/json;charset=UTF-8")
    public List<User> testMysql() {
    	logger.info("testMysql");
    	logger.info(testV1);
    	logger.info(testV2);
		return userDao.get10();
    }
    
    @RequestMapping(value="/oracle",produces="application/json;charset=UTF-8")
    public List<FcsAcctRegister> testOracle() {
    	logger.info("testOracle");
		return wiseDao.getRegister10();
    }

}
