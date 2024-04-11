package com.merriment.customerservice.common;

import com.merriment.customerservice.model.Caretaker;
import com.merriment.customerservice.model.MerrimentError;
import com.merriment.customerservice.model.ResponseMetaData;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;


@Component
public class Authentication {

    @Value("${authentication.base.url}")
    private String authUrl;

    @Autowired
    RestTemplate restTemplate;


    public Caretaker registerNewCustomer(Caretaker caretaker){
        MerrimentError error = new MerrimentError();
        List<MerrimentError> errorList = new ArrayList<MerrimentError>();
        try {
            String url = authUrl + "/newcustomer";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            Map<String, String> body = new HashMap<String, String>();
            body.put("userName", caretaker.getUserName());
            body.put("password", caretaker.getPassword());
            body.put("serviceCode", caretaker.getServiceCode());
            body.put("email", caretaker.getEmail());
            HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(body, headers);
            ResponseEntity<ResponseMetaData> response = restTemplate.postForEntity(url, request, ResponseMetaData.class);
            if(response.getStatusCode().equals(HttpStatus.CREATED)) {
                ResponseMetaData responseMetaData = response.getBody();
                if(responseMetaData != null && (responseMetaData.getErrorDesInfo() == null || responseMetaData.getErrorDesInfo().isEmpty())) {
                    caretaker.setCustomerId(responseMetaData.getMessage());
                }else{
                    caretaker.setErrorList(responseMetaData.getErrorDesInfo());
                }
            }else{
                error.setErrorCode("MER103");
                error.setErrorMessage("Authentication service returned Error" + response.getStatusCode());
                errorList.add(error);
                caretaker.setErrorList(errorList);
            }
        }catch(RestClientException re){
            re.getMessage();
        }catch(Exception e){
            e.getStackTrace();
        }
        return caretaker;
    }


}
