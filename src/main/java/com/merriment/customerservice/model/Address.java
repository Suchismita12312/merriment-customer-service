package com.merriment.customerservice.model;

import java.util.List;

public class Address {

    private String addressLine1;
    private String addressLine2;

    private String town;

    private String postCode;

    private List<MerrimentError> errorList;

    public List<MerrimentError> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<MerrimentError> errorList) {
        this.errorList = errorList;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
