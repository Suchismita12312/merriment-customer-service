package com.merriment.customerservice.dao;

import com.merriment.customerservice.model.Address;
import com.merriment.customerservice.model.Caretaker;

public interface CustomerInterface {

    public Caretaker createCaretaker(Caretaker caretaker);

    Integer createAddress(Address address);

    public int createCaregiver();
}
