package com.merriment.customerservice.service;
import com.merriment.customerservice.mapper.CustomerMapper;
import com.merriment.customerservice.model.Caretaker;
import com.merriment.customerservice.model.RegisterCustomerRequest;
import com.merriment.customerservice.model.RegisterCustomerResponse;

public class RegisterCustomerService {
    public RegisterCustomerResponse registerForCareTaker(RegisterCustomerRequest registerCustomerRequest) {
        Caretaker caretaker = CustomerMapper.mapToCareTaker(registerCustomerRequest);

        return null;
    }

    public RegisterCustomerResponse registerForCareGiver(RegisterCustomerRequest registerCustomerRequest) {
        return null;
    }
}
