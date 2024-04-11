package com.merriment.customerservice.service;
import com.merriment.customerservice.common.Authentication;
import com.merriment.customerservice.dao.CustomerDao;
import com.merriment.customerservice.dao.CustomerInterface;
import com.merriment.customerservice.dao.ServiceCodeDao;
import com.merriment.customerservice.dao.ServiceCodeInterface;
import com.merriment.customerservice.mapper.CustomerMapper;
import com.merriment.customerservice.model.Caretaker;
import com.merriment.customerservice.model.RegisterCustomerRequest;
import com.merriment.customerservice.model.ResponseMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService {


    private final CustomerInterface customerDao;

    @Autowired
    private Authentication authentication;

    public RegisterCustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    public ResponseMetaData registerForCareTaker(RegisterCustomerRequest registerCustomerRequest) {
        int result = 0;
        ResponseMetaData responseMetaData = new ResponseMetaData();
        Caretaker caretaker = CustomerMapper.mapToCareTaker(registerCustomerRequest);
        caretaker = this.createCustomer(caretaker);
        String customerId = caretaker.getCustomerId();
        if(customerId != null){
            caretaker = customerDao.createCaretaker(caretaker);
            if(caretaker.getErrorList() == null || caretaker.getErrorList().isEmpty()){
                responseMetaData.statusCode("Success");
                responseMetaData.setMessage("Customer created successfully");
            }else{
                responseMetaData.setErrorDesInfo(caretaker.getErrorList());
                responseMetaData.setStatusCode("Error");
                responseMetaData.setMessage("Some Error Occurred");
            }
        }else{
            if(!caretaker.getErrorList().isEmpty()){
                responseMetaData.setErrorDesInfo(caretaker.getErrorList());
                responseMetaData.setStatusCode("Error");
                responseMetaData.setMessage("Some Error Occurred");
            }
        }
        return responseMetaData;
    }

    private Caretaker createCustomer(Caretaker caretaker) {
        return authentication.registerNewCustomer(caretaker);
    }

    public ResponseMetaData registerForCareGiver(RegisterCustomerRequest registerCustomerRequest) {
        return null;
    }
}
