package com.merriment.customerservice.dao;

import com.merriment.customerservice.common.Authentication;
import com.merriment.customerservice.model.Address;
import com.merriment.customerservice.model.Caretaker;
import com.merriment.customerservice.model.MerrimentError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDao implements CustomerInterface{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Caretaker createCaretaker(Caretaker caretaker) {
        MerrimentError error = new MerrimentError();
        List<MerrimentError> errorList = new ArrayList<MerrimentError>();
        Integer addressCode = createAddress(caretaker.getAddress());
        if(addressCode != 0) {
            String caretakerSql = "INSERT INTO Caretaker (CustomerId, Username, FirstName, LastName, ServiceCode, AddressCode) values" +
                    "(?,?,?,?,?,?)";
            int result = jdbcTemplate.update(caretakerSql, new Object[]{
                    caretaker.getCustomerId(), caretaker.getUserName(), caretaker.getFirstName(), caretaker.getLastName(), caretaker.getServiceCode(), addressCode
            });
            if (result != 0){
                return caretaker;
            }else{
                error.setErrorCode("MER104");
                error.setErrorMessage("Error in adding Customer Details");
                errorList.add(error);
                caretaker.setErrorList(errorList);
                return caretaker;
            }
        }else{
            error.setErrorCode("MER105");
            error.setErrorMessage("Error in adding Address Details");
            errorList.add(error);
            caretaker.setErrorList(errorList);
            return caretaker;
        }

    }

    @Override
    public Integer createAddress(Address address) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String addressSql = "INSERT INTO ADDRESS (AddressLine1, AddressLine2, Town, PostCode) values (?,?,?,?)";
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(addressSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, address.getAddressLine1());
            ps.setString(2,address.getAddressLine2());
            ps.setString(3,address.getTown());
            ps.setString(4,address.getPostCode());
            return ps;
        }, keyHolder);
        return (Integer) keyHolder.getKey();
    }

    @Override
    public int createCaregiver() {
        return 0;
    }
}
