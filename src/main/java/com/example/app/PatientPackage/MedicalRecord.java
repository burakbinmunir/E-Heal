package com.example.app.PatientPackage;

import com.vaadin.flow.component.button.Button;
import lombok.Getter;
import lombok.Setter;

public class MedicalRecord {
    @Getter
    @Setter
    private String diseaseName;

    @Getter
    @Setter
    private int occurenceYear;

    @Getter
    @Setter
    private int occurenceMonth;

    @Getter
    @Setter
    private int recordNumber;

    @Getter
    @Setter
    private String currentCondition;

    @Getter
    @Setter
    private Button viewPrescriptionButton;

   public MedicalRecord(){
        diseaseName = ""; occurenceMonth = 0; occurenceYear = 0;
        recordNumber = 0;
//        viewPrescriptionButton.addClickListener(
//                event->{
//                    viewPrescription();
//                }
//        );
    }


}
