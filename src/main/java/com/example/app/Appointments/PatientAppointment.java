package com.example.app.Appointments;

import com.example.app.Admin;
import com.example.app.PrescribeMedicine;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import lombok.Getter;
import lombok.Setter;

import com.vaadin.flow.component.notification.Notification;


public class PatientAppointment extends Appointment{
    @Getter @Setter
    private String reasonOfCancellation;
    @Getter @Setter
    private String patientsCurrentCondition;
    @Getter @Setter
    private String patientUserName;
    @Getter @Setter
    private Button viewButton;
    private String patientName;
    private Admin admin;
    @Getter @Setter
    private Button diagnosePatientButton;

    void initializeDiagnosePatient(){
        diagnosePatientButton = new Button("Diagnose Pateint");
        diagnosePatientButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        diagnosePatientButton.addClickListener(
                event->{
                    admin.addAppointmentBeingDiagnosed(getAppointmentNumber());
                    diagnosePatientButton.getUI().ifPresent(ui->ui.navigate(PrescribeMedicine.class));
                }
        );
    }

    public PatientAppointment(){

        viewButton = new Button("View Appointment");
        viewButton.addClickListener(
                event->{
                    Dialog appointmentDialog = new Dialog();
                    VerticalLayout dialogLayout = new VerticalLayout();
                    HorizontalLayout layout1 = new HorizontalLayout();
                    Label appointmentNumberLabel = new Label("Appointment Number: ");
                    Label appointmentNumber = new Label(String.valueOf( getAppointmentNumber()));
                    Label spaceLabel = new Label("   ");
                    Label patientNameLabel = new Label("Patient Name: ");
                    Label patientName = new Label(getPatientName());

                    layout1.add(appointmentNumberLabel);
                    layout1.add(appointmentNumber);
                    layout1.add(spaceLabel);
                    layout1.add(patientNameLabel);
                    layout1.add(patientName);


                    Label descriptionLabel = new Label("Current Condition");
                    HorizontalLayout layout2 = new HorizontalLayout();
                    TextArea currentCondition = new TextArea();
                    currentCondition.setValue(getPatientsCurrentCondition());
                    currentCondition.setEnabled(false);

                    layout2.add(currentCondition);


                    dialogLayout.add(layout1);
                    dialogLayout.add(descriptionLabel);
                    dialogLayout.add(layout2);
                    appointmentDialog.add(dialogLayout);
                    appointmentDialog.setOpened(true);

                    HorizontalLayout buttonsLayout = new HorizontalLayout();
                    Button cancelButton = new Button("Cancel Appointment");
                    cancelButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
                    cancelButton.addClickListener(
                            e-> {
                                Dialog reasonOfCancellation = new Dialog();
                                VerticalLayout cancelLayout = new VerticalLayout();
                                TextArea reason = new TextArea();
                                reason.setLabel("Enter reason of Cancellation");
                                cancelLayout.add(reason);

                                Button okButton = new Button("Ok");
                                okButton.addClickListener(ev->{
                                    admin.cancelAppointment(getAppointmentNumber());
                                    reasonOfCancellation.close();
                                    Notification.show("Appointment Cancelled");
                                });

                                cancelLayout.add(okButton);
                                Button cancel = new Button("Cancel");
                                cancel.addClickListener(eve->{
                                    reasonOfCancellation.close();
                                });
                                cancelLayout.add(cancel);
                                reasonOfCancellation.add(cancelLayout);
                                reasonOfCancellation.open();
                            }
                    );
                    buttonsLayout.add(cancelButton);


                    Button approveButton = new Button("Approve");
                    approveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
                    approveButton.addClickListener(
                            newEvent->{
                                admin.approveAppointment(getAppointmentNumber());
                                Notification.show("Appointment Approved");
                            }
                    );

                    buttonsLayout.add(approveButton);

                    Button reshceduleButton = new Button("Request Reschedule");
                    reshceduleButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

                    reshceduleButton.addClickListener(
                            reshceduleEvent->{
                                admin.rescheduleAppointment(getAppointmentNumber());
                                Notification.show("Appointment Rescheduled");
                            }
                    );

                    buttonsLayout.add(reshceduleButton);
                    appointmentDialog.add(buttonsLayout);

                }
        );
        initializeDiagnosePatient();
    }

    public String getPatientName(){
        return getPatientNameByUserName();
    }

    String getPatientNameByUserName(){
        admin = new Admin();
        return patientName = admin.getPatientName(patientUserName);
    }

}
