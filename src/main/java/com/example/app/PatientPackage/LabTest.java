package com.example.app.PatientPackage;

import lombok.Getter;
import lombok.Setter;

public class LabTest {
    @Getter @Setter
    private String labTestName;

    @Setter @Getter
    private int labTestNumber;

    public LabTest(){
        labTestNumber = 0; labTestName = "";
    }
}
