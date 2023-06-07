package com.kuliah.latihanspringboot.model;

import lombok.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    private UUID id_user;

    //GENERAL INFORMATION
    private String fname;
    private String lname;
    private String email;

    //AUTHENTICATION INFORMATIONS
    private String username;
    private String password;
}
