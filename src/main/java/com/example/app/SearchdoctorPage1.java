package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SingleSelect;
import com.vaadin.flow.router.Route;
import java.util.List;



@Tag("searchdoctor-page1")
@JsModule("./searchdoctor-page1.ts")
@Route("searchdoctor")
public class SearchdoctorPage1 extends LitTemplate {


    private Admin admin;
    private ComboBox<String> doctorsBox;

    @Id("searchLayout")
    private VerticalLayout searchLayout;
    @Id("searchSpecilist")
    private HorizontalLayout searchSpecilist;


    public SearchdoctorPage1() {

        admin = new Admin();
        Image image = new Image();
        image.setSrc("https://img.freepik.com/free-vector/health-doctor-search-logo-design-inspiration_347382-650.jpg?w=1060");
        image.setWidth("500px");
        image.setHeight("300px");
        searchLayout.add(image);

        HorizontalLayout searchBar = new HorizontalLayout();
        doctorsBox = new ComboBox<>();
        doctorsBox.setItems(admin.getAvailableDoctors());
        searchBar.add(image);

        Button searchButton = new Button();
        searchButton.setIcon(VaadinIcon.SEARCH.create());

        searchBar.add(doctorsBox);
        searchBar.add(searchButton);
        searchLayout.add(searchBar);
        searchButton.addClickListener(event->
        {


            String name = doctorsBox.getValue();
            StringBuilder firstName;
            firstName = new StringBuilder();
            int i = 0;

            for (; name.charAt(i) != ' ';i++){
                firstName.append(name.charAt(i));
            }

            StringBuilder lastName = new StringBuilder();

            for(int j = i + 1; j< name.length(); j++){
                lastName.  append(name.charAt(j));
            }

            List<Doctor> foundDoctors = admin.getDoctors(firstName.toString(),lastName.toString());
            Grid<Doctor> doctorGrid = new Grid<Doctor>();
            doctorGrid.addColumn(Doctor::getName).setHeader("Name");
            doctorGrid.addColumn(Doctor::getSpecialization).setHeader("Specialization");

            doctorGrid.addComponentColumn(Doctor::getViewButton).setHeader("Choice");
            doctorGrid.setSelectionMode(Grid.SelectionMode.SINGLE);

            doctorGrid.setItems(foundDoctors);

            searchLayout.add(doctorGrid);

        });
        searchSpecilist.addClickListener(
                event-> {
                    searchSpecilist.getUI().ifPresent(ui -> ui.navigate(SearchByspecialization.class));
                }


        );


    }
}
