package com.merriment.customerservice.common;

import com.merriment.customerservice.model.Caretaker;
import com.merriment.customerservice.model.MerrimentError;
import com.merriment.customerservice.model.ResponseMetaData;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

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
            MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
            body.add("userName", caretaker.getUserName());
            body.add("password", caretaker.getPassword());
            body.add("serviceCode", caretaker.getServiceCode());
            body.add("email", caretaker.getEmail());
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);
            ResponseEntity<ResponseMetaData> response = restTemplate.postForEntity(url, request, ResponseMetaData.class);
            if(response.getStatusCode().equals(HttpStatus.CREATED)) {
                caretaker.setCustomerId(Objects.requireNonNull(response.getBody()).getMessage());
            }else{
                error.setErrorCode("MER103");
                error.setErrorMessage("Authentication service returned Error" + response.getStatusCode());
                errorList.add(error);
                caretaker.setErrorList(errorList);
                return caretaker;
            }
        }catch(RestClientException re){
            re.getMessage();
        }catch(Exception e){
            e.getStackTrace();
        }
        return caretaker;
    }


}
