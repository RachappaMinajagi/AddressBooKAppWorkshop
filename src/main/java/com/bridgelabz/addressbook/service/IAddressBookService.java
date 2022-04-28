package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.DTO.AddressBookDTO;
import com.bridgelabz.addressbook.Model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {

    public AddressBook saveAddress(AddressBookDTO addressBookDTO);

    public List<AddressBook> getListOfAddresses();

    public Optional<AddressBook> getDataById(Integer id);

    public AddressBook updateDateById(Integer id, AddressBookDTO addressBookDTO);

    public void deleteContact(Integer id);

}