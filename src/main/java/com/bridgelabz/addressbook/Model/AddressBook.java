package com.bridgelabz.addressbook.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

//Created AddressBook class with different fields
public class AddressBook {

        @Id
        @GeneratedValue
        private Integer id;

        private String firstName;
        private String lastName;
        private String email;
        private long phoneNumber;
        private String city;
        private String state;
        private Integer zip;




        public AddressBook() {
                super();
        }

        //Created constructor for postaddress method
        public AddressBook(AddressBook addressBook) {
                super();
                this.firstName = addressBook.firstName;
                this.lastName = addressBook.lastName;
                this.email = addressBook.email;
                this.phoneNumber = addressBook.phoneNumber;
                this.city = addressBook.city;
                this.state = addressBook.state;
                this.zip = addressBook.zip;
        }

        //Created constructor for update by id method
        public AddressBook(AddressBook addressBook, Integer id) {
                this.id = id;
                this.firstName = addressBook.firstName;
                this.lastName = addressBook.lastName;
                this.email = addressBook.email;
                this.phoneNumber = addressBook.phoneNumber;
                this.city = addressBook.city;
                this.state = addressBook.state;
                this.zip = addressBook.zip;


        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public long getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(long phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public Integer getZip() {
                return zip;
        }

        public void setZip(Integer zip) {
                this.zip = zip;
        }
}