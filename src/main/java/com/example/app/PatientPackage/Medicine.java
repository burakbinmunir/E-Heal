package com.example.app.PatientPackage;

import com.example.app.Admin;
import com.vaadin.flow.component.button.Button;
import lombok.Getter;
import lombok.Setter;
import org.atmosphere.config.service.Get;

public class Medicine {
    @Getter @Setter
    private String medicineName;
    @Getter @Setter
    private double doseInMorning;
    @Getter @Setter
    private double doseInNoon;
    @Getter @Setter
    private double doseInNight;
    @Getter @Setter
    private Button addToCartButton;
    @Getter @Setter
    private String orderStatus;
    private Admin admin;
    public Medicine(){
        admin = new Admin();
        medicineName = ""; doseInMorning = 0; doseInNight = 0;
        doseInNoon = 0; orderStatus = "Not Available";

        addToCartButton = new Button("Added To Cart");
        addToCartButton.addClickListener(
                ev-> {
                    admin.setAvailable(getMedicineName());
                }
        );
    }

}
