package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.notification.Notification;

/**
 * A Designer generated component for the doctors-options template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("doctors-options")
@JsModule("./themes/eheal/doctors-options.ts")
@Route("doctorsoptions")
public class DoctorsOptions extends LitTemplate {

    @Id("diagnosePatient")
    private VerticalLayout diagnosePatient;
    @Id("viewAppointmentLayout")
    private VerticalLayout viewAppointmentLayout;

    void initializeDiagnosePatient() {
        Image img = new Image();
        img.setSrc("https://img.freepik.com/free-vector/veterinary-clinic-diagnostic-laboratory-isometric-view-with-cat-undergoing-mri-scan-test-assistant-computer_1284-63162.jpg?t=st=1653506573~exp=1653507173~hmac=651125e2218fea4c3997d3f670a09d519b48f127b798e0038dfdcfd810ef6c93&w=740");
        img.setWidth("300px");
        img.setHeight("300px");
        diagnosePatient.add(img);

        Label label = new Label("Diagnose Patients");
        diagnosePatient.add(label);
        diagnosePatient.addClickListener(
                e->{
                    diagnosePatient.getUI().ifPresent(ui->ui.navigate(ViewApprovedDoctorappointments.class));
                }
        );
    }

    void initializeViewAppointmentsLayout(){
            Image img = new Image();
            img.setSrc("https://img.freepik.com/free-vector/people-using-online-appointment-booking-app_74855-5556.jpg?t=st=1653507198~exp=1653507798~hmac=2461cdbca79a56ab6c8a16ba02d15e1188257a75d48cdc244267f0036534d0fd&w=1060");
            img.setWidth("300px");
            img.setHeight("300px");
            viewAppointmentLayout.add(img);

            Label label = new Label("See Scheduled Appointments");
            viewAppointmentLayout.add(label);

            viewAppointmentLayout.addClickListener(
                    event->{
                        viewAppointmentLayout.getUI().ifPresent(ui->ui.navigate(DoctorsViewappointments.class));
                    }
            );
    }
    public DoctorsOptions() {
            initializeDiagnosePatient();
            initializeViewAppointmentsLayout();
    }

}
