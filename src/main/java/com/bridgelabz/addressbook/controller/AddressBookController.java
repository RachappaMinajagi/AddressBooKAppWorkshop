package com.bridgelabz.addressbook.controller;


import com.bridgelabz.addressbook.Model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Created controller class to make api calls
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    AddressBookRepository repository;

    //Print welcome message
    @GetMapping("")
    public String getMessage() {
        return "Welcome to Addressbook App";
    }

    //Create api call to save data to repository
    @PostMapping("/create")
    public AddressBook postAddress(@RequestBody AddressBook addressBook) {
        AddressBook newAddressBook = new AddressBook(addressBook);
        repository.save(newAddressBook);
        return newAddressBook;
    }

    //Get all data to repository
    @GetMapping("/get")
    public List<AddressBook> getAddress() {
        List<AddressBook> addressBook = repository.findAll();
        return addressBook;
    }

    //To get data by id to repository
    @GetMapping("/get/{id}")
    public AddressBook getAddressById(@PathVariable Integer id) {
        Optional<AddressBook> addressBook = repository.findById(id);
        return addressBook.get();
    }

    //Update  data in the repository by id
    @PutMapping("/updateData/{id}")
    public AddressBook updateById(@PathVariable Integer id, @RequestBody AddressBook addressBook) {
        AddressBook newAddressBook = new AddressBook(addressBook, id);
        repository.save(newAddressBook);
        return newAddressBook;
    }

    //Delete  data by id in the repository
    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Integer id) {
        repository.deleteById(id);
        return "Address of id: " + id + " has been deleted";
    }
}