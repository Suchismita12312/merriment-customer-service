package com.merriment.customerservice.repository;

import com.merriment.customerservice.model.*;
import com.merriment.customerservice.service.RegisterCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterCustomerRepository {

    @Autowired
    private RegisterCustomerService registerCustomerService;
    public ResponseMetaData registerCustomer(RegisterCustomerRequest registerCustomerRequest, String type) {
        RegisterCustomerResponse registerCustomerResponse = new RegisterCustomerResponse();
        ResponseMetaData responseMetaData;
        if (type.equals("CareTaker")){
            responseMetaData = registerCustomerService.registerForCareTaker(registerCustomerRequest);
        }else{
            responseMetaData = registerCustomerService.registerForCareGiver(registerCustomerRequest);
        }
        return responseMetaData;
    }
}
