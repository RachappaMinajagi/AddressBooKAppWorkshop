package com.bridgelabz.addressbook.service;


import com.bridgelabz.addressbook.DTO.AddressBookDTO;
import com.bridgelabz.addressbook.Model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {


    @Autowired
    AddressBookRepository repository;



    public AddressBook saveAddress(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        repository.save(addressBook);
        return addressBook;
    }

    public List<AddressBook> getListOfAddresses() {
        List<AddressBook> list = repository.findAll();
        return list;
    }


    public Optional<AddressBook> getDataById(Integer id) {
        Optional<AddressBook> newAddressBook = repository.findById(id);
        return newAddressBook;
    }


    public AddressBook updateDateById(Integer id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(id, addressBookDTO);
        repository.save(addressBook);
        return addressBook;
    }


    public void deleteContact(Integer id) {
        repository.deleteById(id);
    }

}