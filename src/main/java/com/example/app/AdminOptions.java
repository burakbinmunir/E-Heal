package com.example.app;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the admin-options template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admin-options")
@JsModule("./themes/admin-options.ts")
@Route("adminoptions")
public class AdminOptions extends LitTemplate {

    @Id("enrolLaboratory")
    private VerticalLayout enrolLaboratory;
    @Id("enrolPharmacy")
    private VerticalLayout enrolPharmacy;
    @Id("enrolDoctor")
    private VerticalLayout enrolDoctor;
    @Id("enrolPatient")
    private VerticalLayout enrolPatient;

    /**
     * Creates a new AdminOptions.
     */
    public AdminOptions() {
        Image i1 = new Image();
        i1.setSrc("https://img.freepik.com/free-vector/flat-hand-drawn-patient-taking-medical-examination-illustration_23-2148859982.jpg?t=st=1653623657~exp=1653624257~hmac=62494f5132a1bfa3559ff833c293bcb32b48180067f5837cb3b0ff0ce3492bcd&w=740");
        i1.setWidth("300px");
        i1.setHeight("300px");
        enrolPatient.add(i1);
        Label label = new Label("Enrol Patient");
        enrolPatient.add(label);
        enrolPatient.addClickListener(e->{
            enrolPatient.getUI().ifPresent(ui->ui.navigate(PatientSignup.class));
        });

        Image i2 = new Image();
        i2.setSrc("https://img.freepik.com/free-vector/pharmacy-medical-shop-concept_74855-7815.jpg?t=st=1653623804~exp=1653624404~hmac=2c4d589e8f3803f7897a7ee6ac6aa406f0443d9f6053a281246e9738d96a3348&w=1380");
        i2.setWidth("300px");
        i2.setHeight("300px");
        enrolPharmacy.add(i2);
        Label l = new Label("Enrol Pharmacy");
        enrolPharmacy.add(l);
        enrolPharmacy.addClickListener((ev->{
            enrolPharmacy.getUI().ifPresent(ui->ui.navigate(PharmacySignup.class));
        }));

        Image i3 = new Image();
        i3.setSrc("https://img.freepik.com/free-vector/flat-laboratory-room-with-microscope_23-2148885022.jpg?t=st=1653623853~exp=1653624453~hmac=42790bef87fd9c460bdb5d01c2e9310c587210cf191b6d2939ba25dd3d722db6&w=1060");
        i3.setWidth("300px");
        i3.setHeight("300px");
        enrolLaboratory.add(i3);
        Label label3 = new Label("Enrol Laboratory");
        enrolLaboratory.add(label3);
        enrolLaboratory.addClickListener((eve->{
            enrolLaboratory.getUI().ifPresent(ui->ui.navigate(LaboratorySignup.class));
        }));

        Image i4 = new Image();
        i4.setSrc("https://img.freepik.com/free-vector/doctor-character-background_1270-84.jpg?t=st=1653623858~exp=1653624458~hmac=f19297cf492927d3281f99a8fd6a8bac27dc1f411b7b5cecb0a9b3711e949a99&w=740");
        i4.setWidth("300px");
        i4.setHeight("300px");
        enrolDoctor.add(i4);
        Label label4 = new Label("Enrol Doctor");
        enrolDoctor.add(label4);
        enrolDoctor.addClickListener(
                even->{
                    enrolDoctor.getUI().ifPresent(ui->ui.navigate(DoctorSignup.class));
                }
        );
    }

}
