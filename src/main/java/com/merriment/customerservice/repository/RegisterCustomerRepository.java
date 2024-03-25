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
        ResponseMetaData responseMetaData = new ResponseMetaData();
        if (type.equals("CareTaker")){
            registerCustomerResponse = registerCustomerService.registerForCareTaker(registerCustomerRequest);
        }else{
            registerCustomerResponse = registerCustomerService.registerForCareGiver(registerCustomerRequest);
        }
        List<MerrimentError> error = registerCustomerResponse.getErrorDesInfo();
        if(!error.isEmpty()){
            responseMetaData.setStatusCode("Success");
            responseMetaData.message("Customer Registration Successful");
            responseMetaData.setErrorDesInfo(error);
        }else{
            responseMetaData.setMessage("Error in Customer Registration");
            responseMetaData.setErrorDesInfo(error);
            responseMetaData.statusCode("Error");
        }
        return responseMetaData;
    }
}
