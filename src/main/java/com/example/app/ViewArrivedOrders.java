package com.example.app;

import com.example.app.HealthServiceProvider.Order;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the view-arrived-orders template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("view-arrived-orders")
@JsModule("./view-arrived-orders.ts")
@Route("arrivedorders")
public class ViewArrivedOrders extends LitTemplate {


    @Id("vaadinHorizontalLayout")
    private HorizontalLayout vaadinHorizontalLayout;
    private Admin admin;
    public ViewArrivedOrders() {
        admin = new Admin();
        Grid<Order> arrivedOrders = new Grid<Order>();
        arrivedOrders.addColumn(Order::getOrderNumber).setHeader("Order Number");
        arrivedOrders.addComponentColumn(Order::getCompleteOrder);
        arrivedOrders.setItems(admin.getOrders());
        vaadinHorizontalLayout.add(arrivedOrders);
        }

}
