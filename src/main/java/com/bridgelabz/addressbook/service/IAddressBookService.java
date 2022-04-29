package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.DTO.AddressBookDTO;
import com.bridgelabz.addressbook.Model.AddressBookData;

import java.util.List;

public interface IAddressBookService {

    //save data to repository
    String createAddressBookData(AddressBookDTO addressBookDTO);

    //get All Data from token
    List<AddressBookData> getAddressBookDataByToken(String token);


    //get records created for particular id by generating token for that id
    AddressBookData getRecordByToken(String token);


    //update records by providing token generated for particular id
    AddressBookData updateRecordByToken(String token, AddressBookDTO addressBookDTO);



    //deleted records by token
    AddressBookData deleteRecordByToken(String token);
}