package com.example.app;

import com.example.app.Admin;
import com.example.app.Appointments.TempObservation;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.sql.Date;
import java.sql.Time;

/**
 * A Designer generated component for the cancel-appointment-by-patient template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("cancel-appointment-by-patient")
@JsModule("./cancel-appointment-by-patient.ts")
@Route("cancel-appointment-by-patient")
public class CancelAppointmentByPatient extends LitTemplate {


    @Id("StatusBadge")
    private HorizontalLayout statusBadge;
    @Id("sideImage")
    private HorizontalLayout sideImage;
    @Id("name")
    private TextField name;
    @Id("expertise")
    private TextField expertise;
    @Id("contact")
    private TextField contact;
    @Id("gender")
    private TextField gender;
    @Id("email")
    private TextField email;
    @Id("AppointmentDate")
    private TextField appointmentDate;
    @Id("timing")
    private TextField timing;
    @Id("form")
    private VerticalLayout form;

    /**
     * Creates a new CancelAppointmentByPatient.
     */
    public CancelAppointmentByPatient() {
        Image image = new Image();
        image.setSrc("https://preview.pixlr.com/images/800wm/1077/1/1077100334.jpg");
        image.setWidth("500px");
        image.setHeight("700px");
        sideImage.add(image);


       Admin admin  = new Admin();

        TempObservation to = admin.getUnderObservation();
        name.setValue(to.getDocName());
        contact.setValue(to.getPhoneNumber());
        email.setValue(to.getDocEmail());

        timing.setValue(String.valueOf(to.getStartTime())+ "-" + String.valueOf(to.getEndTime()));
        appointmentDate.setValue(String.valueOf(to.getAppNum()));
        gender.setValue(to.getDocGender());
        expertise.setValue(to.getDocSpecialization());

        if (to.getStatus() == 0) {
            Span pending1 = new Span((VaadinIcon.CLOCK).create(), new Span("Pending"));
            pending1.getElement().getThemeList().add("badge");
            pending1.setWidth("110px");
            pending1.setHeight("30px");
            statusBadge.add(pending1);
            HorizontalLayout ButtonsPanel = new HorizontalLayout();
            form.add(ButtonsPanel);

            Button Cancelbutton = new Button("Cancel", VaadinIcon.CLOSE_CIRCLE_O.create());
            Cancelbutton.addThemeVariants(ButtonVariant.LUMO_ERROR);
            Cancelbutton.setAutofocus(true);
            ButtonsPanel.add(Cancelbutton);
            Cancelbutton.addClickListener(
                    event->{
                        admin.cancelAppointment(to.getAppNum());

                    }
            );
        }
        if (to.getStatus() == 1) {
            Span confirmed1 = new Span((VaadinIcon.CHECK).create(), new Span("Approved"));
            confirmed1.getElement().getThemeList().add("badge success");
            confirmed1.setWidth("110px");
            confirmed1.setHeight("30px");
            statusBadge.add(confirmed1);
            HorizontalLayout ButtonsPanel = new HorizontalLayout();
            form.add(ButtonsPanel);

            Button Cancelbutton = new Button("Cancel", VaadinIcon.CLOSE_CIRCLE_O.create());
            Cancelbutton.addThemeVariants(ButtonVariant.LUMO_ERROR);
            Cancelbutton.setAutofocus(true);
            ButtonsPanel.add(Cancelbutton);
            Cancelbutton.addClickListener(
                    event->{

                }
            );

        }
        if (to.getStatus() == 3) {
            Span denied1 = new Span((VaadinIcon.EXCLAMATION_CIRCLE_O).create(), new Span("Rejected"));
            denied1.getElement().getThemeList().add("badge error");
            denied1.setWidth("110px");
            denied1.setHeight("30px");
            statusBadge.add(denied1);
            HorizontalLayout ButtonsPanel = new HorizontalLayout();
            form.add(ButtonsPanel);

            Button Rescdule = new Button("Reschedule", VaadinIcon.HAND.create());
            Rescdule.setAutofocus(true);
            ButtonsPanel.add(Rescdule);

            Rescdule.addClickListener(event->Rescdule.getUI().ifPresent(ui -> ui.navigate(BookDocapp.class)));

        }
        if (to.getStatus() == 4) {
            Span denied1 = new Span((VaadinIcon.EXCLAMATION_CIRCLE_O).create(), new Span("Rejected"));
            denied1.getElement().getThemeList().add("badge error");
            denied1.setWidth("110px");
            denied1.setHeight("30px");
            statusBadge.add(denied1);
            HorizontalLayout ButtonsPanel = new HorizontalLayout();
            form.add(ButtonsPanel);

            Button Rescdule = new Button("Reschedule", VaadinIcon.HAND.create());
            Rescdule.setAutofocus(true);
            ButtonsPanel.add(Rescdule);

            Rescdule.addClickListener(event->Rescdule.getUI().ifPresent(ui -> ui.navigate(BookDocapp.class))
                        );

        }
        admin.removeUnderObservation();

    }

}
