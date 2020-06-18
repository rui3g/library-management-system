package cn.tjrac.sytstem.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


/**
 * @author YO
 * @create 2019-07-09 10:11
 */
public class AccessTokenUtil {

    public final static String appKey = "3fe33df8146c43e8a6e0e16b9b3ee827";
    public final static String appSecret = "e2a30c650364b8870350b09ac38f0ca3";

    public static Map getToken() {
        String url  = "https://open.ys7.com/api/lapp/token/get";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("appKey",appKey);
        params.add("appSecret",appSecret);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);
        Map tokenMap = JSONObject.parseObject(responseEntity.getBody(), Map.class);
        tokenMap.put("appKey",appKey);
        tokenMap.put("appSecret",appSecret);
        return tokenMap;
    }
}
