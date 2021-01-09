package com.care.root.kakao;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.care.root.ordervo.OrderVO;

@Service
public class KakaoServiceImpl implements KakaoService{
	private static final String HOST = "https://kapi.kakao.com";
	private RestTemplate restTemplate = new RestTemplate();
	private KakaoPayReadyVO kakaoPayReadyVO;
	
    public String kakaoPayReady(OrderVO orderVO) {
    	 
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "admin key를 넣어주세요~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id",orderVO.getOrderId());
        params.add("partner_user_id", orderVO.getId());
        params.add("item_name", orderVO.getGoodsName());
        params.add("quantity", "1");
        params.add("total_amount", Integer.toBinaryString(orderVO.getAmount()));
        params.add("tax_free_amount", "0");
        params.add("approval_url", "http://localhost:8081/kakaoPaySuccess");
        params.add("cancel_url", "http://localhost:8081/kakaoPayCancel");
        params.add("fail_url", "http://localhost:8081/kakaoPaySuccessFail");
 
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
 
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            
//            log.info("" + kakaoPayReadyVO);
            System.out.println(kakaoPayReadyVO.getNext_redirect_pc_url());
            return kakaoPayReadyVO.getNext_redirect_pc_url();
 
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        return "/pay";
        
    }
    
}

