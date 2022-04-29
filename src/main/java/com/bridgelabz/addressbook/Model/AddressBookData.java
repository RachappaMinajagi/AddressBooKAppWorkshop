package com.bridgelabz.addressbook.Model;

import com.bridgelabz.addressbook.DTO.AddressBookDTO;
import lombok.Data;

//Created AddressBook class with different fields
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Created AddressBook class with different fields
@Entity
@Data
public class AddressBookData {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer id;

        private String firstName;
        private String lastName;
        private String email;
        private long phoneNumber;
        private String city;
        private String state;
        private Integer zip;


        public AddressBookData() {
                super();
        }
        public AddressBookData(Integer id, String firstName, String lastName, String email, long phoneNumber, String city,
                               String state, Integer zip) {
                super();
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.city = city;
                this.state = state;
                this.zip = zip;
        }
        public AddressBookData(AddressBookDTO addressBookDTO) {
                this.firstName = addressBookDTO.getFirstName();
                this.lastName = addressBookDTO.getLastName();
                this.email = addressBookDTO.getEmail();
                this.phoneNumber = addressBookDTO.getPhoneNumber();
                this.city = addressBookDTO.getCity();
                this.state = addressBookDTO.getCity();
                this.zip = addressBookDTO.getZip();
        }
        public AddressBookData(Integer id, AddressBookDTO addressBookDTO) {
                this.id=id;
                this.firstName = addressBookDTO.getFirstName();
                this.lastName = addressBookDTO.getLastName();
                this.email = addressBookDTO.getEmail();
                this.phoneNumber = addressBookDTO.getPhoneNumber();
                this.city = addressBookDTO.getCity();
                this.state = addressBookDTO.getCity();
                this.zip = addressBookDTO.getZip();
        }
}