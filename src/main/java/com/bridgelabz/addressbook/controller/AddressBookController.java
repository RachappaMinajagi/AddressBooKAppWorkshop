package com.bridgelabz.addressbook.controller;


import com.bridgelabz.addressbook.DTO.AddressBookDTO;
import com.bridgelabz.addressbook.DTO.ResponseDTO;
import com.bridgelabz.addressbook.Model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Created controller class to make api calls
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    AddressBookService service;

    //Print welcome message
    @GetMapping("")
    public String getMessage() {
        return "Welcome to Addressbook App";
    }

    //Get all the addresses present in addressbook
    @GetMapping("/get")
    public ResponseEntity<String> getAllData() {
        List<AddressBook> listOfContacts = service.getListOfAddresses();
        ResponseDTO response = new ResponseDTO("Addresbook :", listOfContacts);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //Add the address to the addressbook
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> postData(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBook newContact = service.saveAddress(addressBookDTO);
        ResponseDTO response = new ResponseDTO("New Contact Added in Addressbook : ", newContact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    //Get  specific through id passed as variable address from address book
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBook> retriveData(@PathVariable Integer id) {
        ResponseDTO response = new ResponseDTO("Addressbook of given id: ", service.getAddressbyId(id));
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //Update  address through id passed as variable address from address book
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook newContact = service.updateDateById(id, addressBookDTO);
        ResponseDTO response = new ResponseDTO("Addressbook updated : ", newContact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    //Delete contact from address book
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataById(@PathVariable Integer id) {
        service.deleteContact(id);
        return new ResponseEntity<String>("Contact deleted succesfully", HttpStatus.OK);
    }
}