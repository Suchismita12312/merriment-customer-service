package com.merriment.customerservice.controller;


import com.merriment.customerservice.model.RegisterCustomerRequest;
import com.merriment.customerservice.model.ResponseMetaData;
import com.merriment.customerservice.repository.RegisterCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpStatus;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-03-11T12:38:18.583+01:00")
@RestController
public class CustomerApiController {

    @Autowired
    private RegisterCustomerRepository registerCustomerRepository;
    /**
     * Register Customer
     * Registers Customer to Merriment
     * <p><b>201</b> - OK
     * <p><b>400</b> - Y803 : eventName required&lt;br&gt;Y803 : callbackUrl required&lt;br&gt;Y800 : Invalid value for callbackUrl
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * @param type type
     * @param registerCustomerRequest registerCustomerRequest
     * @return ResponseMetaData
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    @PostMapping(value = "/register/{type}")
    public ResponseMetaData registerCustomer(@PathVariable String type, @RequestBody RegisterCustomerRequest registerCustomerRequest) throws RestClientException {
        Object postBody = registerCustomerRequest;

        ResponseMetaData responseMetadata = registerCustomerRepository.registerCustomer(registerCustomerRequest,type);
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'type' when calling registerCustomer");
        }

        // verify the required parameter 'registerCustomerRequest' is set
        if (registerCustomerRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'registerCustomerRequest' when calling registerCustomer");
        }

    return null;


    }
}
