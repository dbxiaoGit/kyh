package kyh.service;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kyh.dao.custom.WiseDao;
import kyh.entity.FcsAcctRegister;

import org.apache.http.message.BasicNameValuePair;

@Service
public class CreditCallback {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${creditCallbackUrl}")
	private String creditCallbackUrl;
	@Value("${fcsUrl}")
	private String fcsUrl;
    @Autowired
    WiseDao wiseDao;

	public Map<String,String> doCreditCallbackByMemberCode(String memberCode) {
		Map<String,String> resultMap = new HashMap<String,String>();
		wiseDao.updateOneRegisterStatus3To1(memberCode);
		List<FcsAcctRegister> listFcsAcctRegister = wiseDao.getOneRegisterStatus1(memberCode);
		if(listFcsAcctRegister.size() == 0) {
			resultMap.put("message",memberCode + "没有申请中的记录");
			return resultMap;
		}
		listFcsAcctRegister.forEach(fcsAcctRegister -> {
			String membserCode = fcsAcctRegister.getMember_code();
			String requestResult = sendRequestToMock(membserCode);
			resultMap.put(membserCode, requestResult);
		});
		return resultMap;
	}
	
	public Map<String,String> doAllCreditCallback() {
		Map<String,String> resultMap = new HashMap<String,String>();
		wiseDao.updateRegisterStatus3To1();;
		List<FcsAcctRegister> listFcsAcctRegister = wiseDao.getRegisterStatus1();
		if(listFcsAcctRegister.size() == 0) {
			resultMap.put("message","没有申请中的记录");
			return resultMap;
		}
		listFcsAcctRegister.forEach(fcsAcctRegister -> {
			String membserCode = fcsAcctRegister.getMember_code();
			String requestResult = sendRequestToMock(membserCode);
			resultMap.put(membserCode, requestResult);
		});
		return resultMap;
	}
	
	public String sendRequestToMock(String memberCode) {
		logger.info("sendRequestToMock,memberCode={}",memberCode);
		String responseString = null;
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();;
			HttpPost httpPost = new HttpPost(creditCallbackUrl);
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(60000)
					.setConnectTimeout(60000).setSocketTimeout(60000).build();
			httpPost.setConfig(requestConfig);
			List<BasicNameValuePair> lparams = new LinkedList<BasicNameValuePair>();
			lparams.add(new BasicNameValuePair("method","applyLimiteUpdate"));
			lparams.add(new BasicNameValuePair("url",fcsUrl));
			lparams.add(new BasicNameValuePair("memberCode",memberCode));
			lparams.add(new BasicNameValuePair("auditStatus","0"));
			lparams.add(new BasicNameValuePair("abCredit",""));
			lparams.add(new BasicNameValuePair("auditRemark",""));
			lparams.add(new BasicNameValuePair("fundSrc",""));
			lparams.add(new BasicNameValuePair("quotaAmt","500000"));
			lparams.add(new BasicNameValuePair("final_valid_result","0"));
			lparams.add(new BasicNameValuePair("fcsCreditAmt","0"));
			lparams.add(new BasicNameValuePair("fcsEnChashmentAmt","500000"));
			lparams.add(new BasicNameValuePair("higestAmtByCustomClass","500000"));
			lparams.add(new BasicNameValuePair("custom_group","A"));
			lparams.add(new BasicNameValuePair("final_auth_result","01"));
			lparams.add(new BasicNameValuePair("carriersValidResult","0"));
			lparams.add(new BasicNameValuePair("cashTcType","2"));
			lparams.add(new BasicNameValuePair("quotaTcType","2"));
			lparams.add(new BasicNameValuePair("eacct",""));
			//httpPost.setEntity(new StringEntity(reqeustString, ContentType.create("application/x-www-form-urlencoded", Consts.UTF_8)));
			httpPost.setHeader("ContentType", "application/x-www-form-urlencoded");
			httpPost.setEntity(new UrlEncodedFormEntity(lparams,"UTF-8"));
			response = httpclient.execute(httpPost);
			int resStatu = response.getStatusLine().getStatusCode();
			responseString = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
			logger.info("statusCode:{},responseString:{}",resStatu,responseString);
		} catch (Exception e) {
			logger.error(e.toString());
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
					response.close();
				} catch (Exception e) {
					logger.error(e.toString());}
			}
		}
		return responseString;
	}
}
