package com.example.app.PatientPackage;

import com.example.app.Admin;
import com.example.app.HealthServiceProvider.Pharmacy;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.util.List;

public class Prescription extends MedicalRecord{
        @Getter @Setter
        private Button viewPrescriptionButton;
        @Getter    @Setter
        private Date prescribedDate;
        @Getter @Setter
        private String doctorName;
        @Getter @Setter
        private int medicineCount;
        @Getter @Setter
        private int labTestCount;
        @Getter @Setter
        private String doctorComment;
        @Getter @Setter
        private int duration;   // duration of this prescription
        @Getter @Setter
        private int appointmentNumber;
        @Getter @Setter
        private List<Medicine> prescribedMedicines;
        @Getter @Setter
        private List<LabTest> recommendedTests;
        @Getter @Setter
        private Button orderButton;
        private Admin admin;

        public Prescription(){
            admin = new Admin();
            viewPrescriptionButton = new Button("View Prescription");
            orderButton = new Button("Order Medicines");
            doctorName = ""; medicineCount = 0; doctorComment = "";
            labTestCount = 0; duration = 0; prescribedDate = null;
            prescribedMedicines = null; recommendedTests = null;

            viewPrescriptionButton.addClickListener(
                    event->{
                        Dialog medicinesDialog = new Dialog();
                        HorizontalLayout medicinesLayout = new HorizontalLayout();
                        Grid<Medicine> medicinesGrid = new Grid<Medicine>();
                        medicinesGrid.addColumn(Medicine::getMedicineName).setHeader("Medicine Name");
                        medicinesGrid.addColumn(Medicine::getDoseInMorning).setHeader("Morning");
                        medicinesGrid.addColumn(Medicine::getDoseInNoon).setHeader("Noon");
                        medicinesGrid.addColumn(Medicine::getDoseInNight).setHeader("Night");medicinesGrid.setItems(prescribedMedicines);
                        medicinesLayout.add(medicinesGrid);
                        medicinesDialog.add(medicinesLayout);

                        Button returnButton = new Button("Return");
                        returnButton.addClickListener(
                                e->{
                                        medicinesDialog.close();
                                }
                        );
                        medicinesDialog.add(returnButton);

                            medicinesDialog.setWidth("500px");
                            medicinesDialog.open();
                    }
            );

            orderButton.addClickListener(
                    eve-> {
                        Dialog pharmaciesDialog = new Dialog();
                        HorizontalLayout pharmaciesDialogLayout = new HorizontalLayout();

                        Grid<Pharmacy> availablePharmacies = new Grid<Pharmacy>();
                        availablePharmacies.addColumn(Pharmacy::getName).setHeader("Name");
                        availablePharmacies.addColumn(Pharmacy::getAddress).setHeader("Location");
                        availablePharmacies.addColumn(Pharmacy::getEmail).setHeader("Email");
                        availablePharmacies.addColumn(Pharmacy::getPhone).setHeader("Phone Number");
                        availablePharmacies.addComponentColumn(Pharmacy::getPlaceOrder);

                        availablePharmacies.setItems(admin.getAvailablePharmacies());
                        Button returnButton = new Button("Back");
                        returnButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
                        returnButton.addClickListener(
                                e->{
                                    pharmaciesDialog.close();
                                }
                        );
                        pharmaciesDialogLayout.add(returnButton);
                        pharmaciesDialogLayout.add(availablePharmacies);

                        pharmaciesDialog.setSizeFull();

                        admin.setTempPrescription(getAppointmentNumber());
                        pharmaciesDialog.add(pharmaciesDialogLayout);

                        pharmaciesDialog.open();
                    }
                );

        }

}
