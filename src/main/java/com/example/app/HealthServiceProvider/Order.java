package com.example.app.HealthServiceProvider;

import com.example.app.Admin;
import com.example.app.PatientPackage.Medicine;
import com.example.app.PatientPackage.Prescription;
import com.example.app.ViewArrivedOrders;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import lombok.Getter;
import lombok.Setter;
import org.atmosphere.config.service.Get;

import java.awt.*;
import java.util.List;

public class Order {
    @Getter @Setter
        private List<Medicine> prescribedMedicines;
    @Getter @Setter
        private Pharmacy pharmacy;
    @Getter @Setter
        private int orderNumber;
    @Getter @Setter
        private String status;
    @Getter @Setter
    private int appNum;
    @Getter @Setter
    private Button completeOrder;
    private Admin admin;
    public Order(){
        admin = new Admin();
        completeOrder = new Button("Complete Order");
        completeOrder.addClickListener(
                e-> {
                    admin.setCurrentOrder(getAppNum());
                    Grid<Medicine> medicineGrid = new Grid<Medicine>();
                    medicineGrid.addColumn(Medicine::getMedicineName).setHeader("Name");
                    medicineGrid.addColumn(Medicine::getDoseInMorning).setHeader("Morning Dose");
                    medicineGrid.addColumn(Medicine::getDoseInNoon).setHeader("Noon Dose");
                    medicineGrid.addColumn(Medicine::getDoseInNight).setHeader("Night Dose");
                    medicineGrid.addComponentColumn(Medicine::getAddToCartButton);

                    medicineGrid.setItems(getPrescribedMedicines());

                    Dialog d = new Dialog();
                    d.add(medicineGrid);
                    Button dispatchOrder  = new Button("Dispatch Order");
                    dispatchOrder.addClickListener(
                            ev->{
                                d.close();
                                dispatchOrder.getUI().ifPresent(ui -> ui.navigate(ViewArrivedOrders.class));
                                Notification.show("Order Dispatched");
                            }
                    );
                    d.add(dispatchOrder);
                    d.setSizeFull();
                    d.open();
                }
        );
    }

}
