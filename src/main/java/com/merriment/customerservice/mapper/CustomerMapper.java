package com.merriment.customerservice.mapper;

import com.merriment.customerservice.model.Address;
import com.merriment.customerservice.model.AddressDetail;
import com.merriment.customerservice.model.Caretaker;
import com.merriment.customerservice.model.RegisterCustomerRequest;

public class CustomerMapper {
    public static Caretaker mapToCareTaker(RegisterCustomerRequest registerCustomerRequest) {
        Caretaker caretaker = new Caretaker(registerCustomerRequest.getPassword());
        caretaker.setUserName(registerCustomerRequest.getUserName());
        caretaker.setFirstName(registerCustomerRequest.getFirstName());
        caretaker.setLastName(registerCustomerRequest.getLastName());
        caretaker.setServiceCode(registerCustomerRequest.getServiceCode());
        Address address = new Address();
        AddressDetail addressDetail = registerCustomerRequest.getAddressDetail();
        address.setAddressLine1(addressDetail.getAddressLine1());
        address.setAddressLine2(addressDetail.getAddressLine2());
        address.setPostCode(addressDetail.getPostCode());
        address.setTown(addressDetail.getTownName());
        caretaker.setAddress(address);
        return caretaker;
    }
}
