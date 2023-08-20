package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the pharmacy-options template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("pharmacy-options")
@JsModule("./pharmacy-options.ts")
@Route("pharmacyoptions")
public class PharmacyOptions extends LitTemplate {

    @Id("viewOrdersLayout")
    private VerticalLayout viewOrdersLayout;

    public void initializeViewOrdersLayout(){
        Image img  = new Image();
        img.setSrc("https://img.freepik.com/free-vector/order-tracking-program-convenient-service-shopping-list-basket-content-purchase-package-mobile-software-smartphone-application_335657-2558.jpg?t=st=1653600851~exp=1653601451~hmac=32cde30e2249540f13d2dde4f1a2640e68f5f361532c6581360de681e105ed39&w=740");
        img.setWidth("400px");
        img.setHeight("300px");
        viewOrdersLayout.add(img);

        Label label = new Label("Manage Orders");
        viewOrdersLayout.add(label);
        viewOrdersLayout.addClickListener(
                event->{
                    viewOrdersLayout.getUI().ifPresent(ui->ui.navigate(ViewArrivedOrders.class));
                }
        );
    }
    public PharmacyOptions() {
            initializeViewOrdersLayout();
    }

}
