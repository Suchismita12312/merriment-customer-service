/*
 * Register Customer
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.merriment.customerservice.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;


/**
 * RegisterCustomerRequest
 */
public class RegisterCustomerRequest {
  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("telephoneCode")
  private String telephoneCode = null;

  @JsonProperty("telephoneNumber")
  private String telephoneNumber = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("serviceCode")
  private String serviceCode = null;

  @JsonProperty("addressDetail")
  private AddressDetail addressDetail = null;

   /**
   * Get userName
   * @return userName
  **/
  @ApiModelProperty(value = "")
  public String getUserName() {
    return userName;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")
  public String getFirstName() {
    return firstName;
  }

   /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")
  public String getLastName() {
    return lastName;
  }

   /**
   * Get telephoneCode
   * @return telephoneCode
  **/
  @ApiModelProperty(value = "")
  public String getTelephoneCode() {
    return telephoneCode;
  }

   /**
   * Get telephoneNumber
   * @return telephoneNumber
  **/
  @ApiModelProperty(value = "")
  public String getTelephoneNumber() {
    return telephoneNumber;
  }

   /**
   * Get emailAddress
   * @return emailAddress
  **/
  @ApiModelProperty(value = "")
  public String getEmailAddress() {
    return emailAddress;
  }

  @ApiModelProperty(value = "")
  public String getPassword() {
    return password;}

  @ApiModelProperty(value = "")
  public String getServiceCode() {
    return serviceCode;}

  public RegisterCustomerRequest addressDetail(AddressDetail addressDetail) {
    this.addressDetail = addressDetail;
    return this;
  }

   /**
   * Address
   * @return addressDetail
  **/
  @ApiModelProperty(value = "Address")
  public AddressDetail getAddressDetail() {
    return addressDetail;
  }

  public void setAddressDetail(AddressDetail addressDetail) {
    this.addressDetail = addressDetail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterCustomerRequest registerCustomerRequest = (RegisterCustomerRequest) o;
    return Objects.equals(this.userName, registerCustomerRequest.userName) &&
        Objects.equals(this.firstName, registerCustomerRequest.firstName) &&
        Objects.equals(this.lastName, registerCustomerRequest.lastName) &&
        Objects.equals(this.telephoneCode, registerCustomerRequest.telephoneCode) &&
        Objects.equals(this.telephoneNumber, registerCustomerRequest.telephoneNumber) &&
        Objects.equals(this.emailAddress, registerCustomerRequest.emailAddress) &&
            Objects.equals(this.emailAddress, registerCustomerRequest.password) &&
            Objects.equals(this.emailAddress, registerCustomerRequest.serviceCode) &&
        Objects.equals(this.addressDetail, registerCustomerRequest.addressDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, firstName, lastName, telephoneCode, telephoneNumber, emailAddress, password, serviceCode, addressDetail);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterCustomerRequest {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    telephoneCode: ").append(toIndentedString(telephoneCode)).append("\n");
    sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(password)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(serviceCode)).append("\n");
    sb.append("    addressDetail: ").append(toIndentedString(addressDetail)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

