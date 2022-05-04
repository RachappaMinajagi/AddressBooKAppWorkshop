package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.DTO.AddressBookDTO;
import com.bridgelabz.addressbook.Model.AddressBookData;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import com.bridgelabz.addressbook.util.EmailSenderService;
import com.bridgelabz.addressbook.util.TokenUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    TokenUtility tokenUtility;

    @Autowired
    EmailSenderService sender;


    public String createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData newAddress = new AddressBookData(addressBookDTO);
        addressBookRepository.save(newAddress);
        String token = tokenUtility.createToken(newAddress.getId());
        sender.sendEmail(newAddress.getEmail(), "Test Email", "Registered SuccessFully, hii: "
                + newAddress.getFirstName() + "Please Click here to get data-> "
                + "http://localhost:8080/addressBook/get/" + token);
        return token;
    }

    public AddressBookData updateRecordByToken(String token, AddressBookDTO addressBookDTO) {
        Integer id = tokenUtility.decodeToken(token);
        Optional<AddressBookData> addressBook = addressBookRepository.findById(id);
        if (addressBook.isEmpty()) {
            throw new AddressBookException("Address Book Details for id not found");
        }
        AddressBookData newBook = new AddressBookData(id, addressBookDTO);
        addressBookRepository.save(newBook);
        sender.sendEmail(newBook.getEmail(), "Test Email", "Updated SuccessFully, hii: "
                + newBook.getFirstName() + "Please Click here to get data of updated id-> "
                + "http://localhost:8080/addressBook/get/" + token);
        return newBook;
    }


    public AddressBookData deleteRecordByToken(String token) {
        Integer id = tokenUtility.decodeToken(token);
        Optional<AddressBookData> addressBook = addressBookRepository.findById(id);
        if (addressBook.isEmpty()) {
            log.warn("Unable to find address book details for given id: " + id);
            throw new AddressBookException("Address Book Details not found");
        } else {
            addressBookRepository.deleteById(id);
            sender.sendEmail("rachotism@gmail.com", "Test Email", "Deleted SuccessFully, hii: "
                    + addressBook.get() + "Please Click here to get data-> "
                    + "http://localhost:8080/addressBook/get/" + token);
        }
        return null;
    }


    public List<AddressBookData> getAddressBookDataByToken(String token) {
        int id = tokenUtility.decodeToken(token);
        Optional<AddressBookData> isContactPresent = addressBookRepository.findById(id);
        if (isContactPresent.isPresent()) {
            List<AddressBookData> listAddressBook = addressBookRepository.findAll();
            sender.sendEmail("rachotism@gmail.com", "Test Email", "Get your data with this token, hii: "
                    + isContactPresent.get().getEmail() + "Please Click here to get data-> "
                    + "http://localhost:8080/addressBook/retrieve/" + token);
            return listAddressBook;
        } else {
            System.out.println("Exception ...Token not found!");
            return null;
        }
    }


    public AddressBookData getRecordByToken(String token) {
        Integer id = tokenUtility.decodeToken(token);
        Optional<AddressBookData> newAddressBook = addressBookRepository.findById(id);
        if (newAddressBook.isEmpty()) {
            log.warn("Unable to find address book details for given id: " + id);
            throw new AddressBookException("Address Book Details not found for that particular id");
        } else {
            sender.sendEmail("rachotism@gmail.com", "Test Email", "Deleted SuccessFully, Hello: "
                    + newAddressBook.get().getEmail() + "Please Click here to get data-> "
                    + "http://localhost:8080/addressBook/get/" + token);

            return newAddressBook.get();
        }

    }
}