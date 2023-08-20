package com.example.app.HealthServiceProvider;

import lombok.Getter;
import lombok.Setter;

public class HealthServiceProviders {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String address;
    @Getter @Setter
    private String registrationNumber;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String phone;
    @Getter @Setter
    private String password;

    HealthServiceProviders(){
        name = ""; address = ""; registrationNumber = "";
        email = ""; password = ""; phone = "";
    }
}
