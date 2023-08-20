package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

import javax.annotation.PreDestroy;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * A Designer generated component for the available-doctors template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("available-doctors")
@JsModule("./available-doctors.ts")
@Route("availabledoctors")
public class AvailableDoctors extends LitTemplate {


    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;

    /**
     * Creates a new AvailableDoctors.
     */
    public AvailableDoctors(Doctor d) {


        Grid<Person> personGrid = new Grid<Person>();
        personGrid.addColumn(Person::getFirstName).setHeader("First Name");
        personGrid.addColumn(Person::getLastName).setHeader("Last Name");




      Person p = new Person();
      p.setFirstName("Ali");
      p.setLastName("Murtaza");

      List<Person> lp = new ArrayList<Person>();
      lp.add(p);
      personGrid.setItems(lp);
      vaadinVerticalLayout.add(personGrid);



    }

}
