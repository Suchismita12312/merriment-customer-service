package com.merriment.customerservice.model;

import java.util.List;

public class Caretaker {

    private String CustomerId;
    private String userName;
    private String firstName;
    private String lastName;
    private Address address;
    private String serviceCode;
    private String email;
    private String password;
    private List<MerrimentError> errorList;

    public List<MerrimentError> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<MerrimentError> errorList) {
        this.errorList = errorList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Caretaker(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
