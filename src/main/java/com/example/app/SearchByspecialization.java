package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

import java.util.List;

/**
 * A Designer generated component for the search-byspecialization template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("search-byspecialization")
@JsModule("./search-byspecialization.ts")
@Route("searchbyspecialization")
public class SearchByspecialization extends LitTemplate {

    @Id("cardiologistSelection")
    private Button cardiologistSelection;
    @Id("dermatologistSelection")
    private Button dermatologistSelection;
    @Id("EyeSpecialistSelection")
    private Button eyeSpecialistSelection;
    @Id("ChildSpecialistSelection")
    private Button childSpecialistSelection;
    @Id("OrthopedicSelection")
    private Button orthopedicSelection;
    @Id("NutritionistSelection")
    private Button nutritionistSelection;
    @Id("ENTSelection")
    private Button eNTSelection;
    @Id("DiabetesSpecialistSelection")
    private Button diabetesSpecialistSelection;
    private Admin admin;
    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;

    public SearchByspecialization() {
        admin = new Admin();
        cardiologistSelection.addClickListener(
                event->{
                        List<Doctor> foundDoctors = admin.searchBySpecialization("Cardiology");

                        Grid<Doctor> docGrid = new Grid<Doctor>();
                        docGrid.addColumn(Doctor::getName).setHeader("Name");
                        docGrid.addComponentColumn(Doctor::getViewButton).setHeader("View");
                        docGrid.setItems(foundDoctors);
                        docGrid.setVisible(true);
                        vaadinVerticalLayout.add(docGrid);
                }
        );

        dermatologistSelection.addClickListener(
                event->{
                    List<Doctor> foundDoctors = admin.searchBySpecialization("Dermatology");

                    Grid<Doctor> docGrid = new Grid<Doctor>();
                    docGrid.addColumn(Doctor::getName).setHeader("Name");
                    docGrid.addComponentColumn(Doctor::getViewButton).setHeader("View");
                    docGrid.setItems(foundDoctors);
                    docGrid.setVisible(true);
                    vaadinVerticalLayout.add(docGrid);
                }
        );

        eyeSpecialistSelection.addClickListener(
                event->{
                    List<Doctor> foundDoctors = admin.searchBySpecialization("Eye Specialist");

                    Grid<Doctor> docGrid = new Grid<Doctor>();
                    docGrid.addColumn(Doctor::getName).setHeader("Name");
                    docGrid.addComponentColumn(Doctor::getViewButton).setHeader("View");
                    docGrid.setItems(foundDoctors);
                    docGrid.setVisible(true);
                    vaadinVerticalLayout.add(docGrid);
                }
        );

        childSpecialistSelection.addClickListener(
                event->{
                    List<Doctor> foundDoctors = admin.searchBySpecialization("Child Specialist");

                    Grid<Doctor> docGrid = new Grid<Doctor>();
                    docGrid.addColumn(Doctor::getName).setHeader("Name");
                    docGrid.addComponentColumn(Doctor::getViewButton).setHeader("View");
                    docGrid.setItems(foundDoctors);
                    docGrid.setVisible(true);
                    vaadinVerticalLayout.add(docGrid);
                }
        );

        orthopedicSelection.addClickListener(
                event->{
                    List<Doctor> foundDoctors = admin.searchBySpecialization("Orthopedic Specialist");

                    Grid<Doctor> docGrid = new Grid<Doctor>();
                    docGrid.addColumn(Doctor::getName).setHeader("Name");
                    docGrid.addComponentColumn(Doctor::getViewButton).setHeader("View");
                    docGrid.setItems(foundDoctors);
                    docGrid.setVisible(true);
                    vaadinVerticalLayout.add(docGrid);
                }
        );

        nutritionistSelection.addClickListener(
                event->{
                    List<Doctor> foundDoctors = admin.searchBySpecialization("Nutritionist Specialist");

                    Grid<Doctor> docGrid = new Grid<Doctor>();
                    docGrid.addColumn(Doctor::getName).setHeader("Name");
                    docGrid.addComponentColumn(Doctor::getViewButton).setHeader("View");
                    docGrid.setItems(foundDoctors);
                    docGrid.setVisible(true);
                    vaadinVerticalLayout.add(docGrid);
                }
        );


        eNTSelection.addClickListener(
                event->{
                    List<Doctor> foundDoctors = admin.searchBySpecialization("ENT Specialist");

                    Grid<Doctor> docGrid = new Grid<Doctor>();
                    docGrid.addColumn(Doctor::getName).setHeader("Name");
                    docGrid.addComponentColumn(Doctor::getViewButton).setHeader("View");
                    docGrid.setItems(foundDoctors);
                    docGrid.setVisible(true);
                    vaadinVerticalLayout.add(docGrid);
                }
        );


        diabetesSpecialistSelection.addClickListener(
                event->{
                    List<Doctor> foundDoctors = admin.searchBySpecialization("Diabetes Specialist");

                    Grid<Doctor> docGrid = new Grid<Doctor>();
                    docGrid.addColumn(Doctor::getName).setHeader("Name");
                    docGrid.addComponentColumn(Doctor::getViewButton).setHeader("View");
                    docGrid.setItems(foundDoctors);
                    docGrid.setVisible(true);
                    vaadinVerticalLayout.add(docGrid);
                }
        );
 }

}
