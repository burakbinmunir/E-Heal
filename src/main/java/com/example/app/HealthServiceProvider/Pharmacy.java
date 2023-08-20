package com.example.app.HealthServiceProvider;

import com.example.app.Admin;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import lombok.Getter;
import lombok.Setter;

public class Pharmacy extends HealthServiceProviders {
    @Getter @Setter
    private Button placeOrder;
    private Admin admin;
    public Pharmacy(){
        admin = new Admin();
        placeOrder = new Button("Place Order");
        placeOrder.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        placeOrder.addClickListener(
                event->{
                    admin.placeOrder(getRegistrationNumber());
                    Notification.show("Order Placed");
                }
        );


    }
}
