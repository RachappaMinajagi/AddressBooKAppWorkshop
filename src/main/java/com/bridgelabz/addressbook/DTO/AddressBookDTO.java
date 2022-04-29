package com.bridgelabz.addressbook.DTO;

//Created AddressBookDTO

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @NotEmpty(message="First name cant be empty")
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="AddressBook firstName is Invalid")
    private String firstName;

    @NotEmpty(message="Last name cant be empty")
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="AddressBook lastName is Invalid")
    private String lastName;

    @NotEmpty(message="Email cant be empty")
    @Pattern(regexp = "^[\\w+-]+(\\.[\\w-]+)*@[^_\\W]+(\\.[^_\\W]+)?(?=(\\.[^_\\W]{3,}$|\\.[a-zA-Z]{2}$)).*$", message = "Please enter a valid email id")
    private String email;

    @NotNull(message="Phone number cant be empty")
    //@Pattern(regexp = "^[0-9]{10}$", message = "Please enter a valid phone number")
    private long phoneNumber;

    @NotEmpty(message="city cant be empty")
    private String city;

    @NotEmpty(message="State cant be empty")
    private String state;

    @NotNull(message="Zip code cant be empty")
    //@Pattern(regexp = "^[0-9]{6}$", message = "Please enter a valid zip code")
    private Integer zip;

    public AddressBookDTO() {
        super();
    }
}