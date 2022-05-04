package com.bridgelabz.addressbook.controller;


import com.bridgelabz.addressbook.DTO.AddressBookDTO;
import com.bridgelabz.addressbook.DTO.ResponseDTO;
import com.bridgelabz.addressbook.Model.AddressBookData;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

  /**
   *  @RestController annotation in order to simplify the creation of RESTful web services.
   *  Rest controller tells to spring boot that this my controller class in which create an API.
  */
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
      /**
       * @Autowired annotation is used for dependency injection.In spring boot application,
       * all loaded beans are eligible for auto wiring to another bean.
       */

    @Autowired
    private IAddressBookService addressBookService;
      /**
       *@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
       * @param : ResponseEntity
       * @return :Ability to save employee details to repository
       */
    @PostMapping(path = "/create")
    public ResponseEntity<String> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        String newContact = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("New Contact Added in AddressBook ", newContact);//msg with data
        return new ResponseEntity (respDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/retrieve/{token}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable String token)
    {
        List<AddressBookData> listOfContacts = addressBookService.getAddressBookDataByToken(token);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:",listOfContacts);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    /**
     * get data for particular id
     * Ability to get a record by token
     */
    @GetMapping("/get/{token}")
    public ResponseEntity<String> getRecordById(@PathVariable String token) throws AddressBookException {
        AddressBookData newAddressBook = addressBookService.getRecordByToken(token);
        ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully",newAddressBook);
        return new ResponseEntity(dto,HttpStatus.OK);
    }


    @PutMapping("/update/{token}")
    public ResponseEntity<String> updateRecordById(@PathVariable String token,@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBookData entity = addressBookService.updateRecordByToken(token,addressBookDTO);
        ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully",entity);
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{token}")
    public ResponseEntity<String> deleteRecordById(@PathVariable String token){
        ResponseDTO dto = new ResponseDTO("Address Book Record deleted successfully",addressBookService.deleteRecordByToken(token));
        return new ResponseEntity(dto,HttpStatus.OK);
    }
}
