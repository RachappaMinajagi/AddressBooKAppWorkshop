package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.Model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {
}