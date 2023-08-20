package com.example.app.Appointments;

import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

public class TempObservation {
    @Getter
    private String docName;

    @Getter
    private String docSpecialization;

    @Getter
    private  String phoneNumber;

    @Getter
    private  String docEmail;

    @Getter
    private  String docGender;

    @Getter
    private  String healthCentreName;

    @Getter
    private Date appDate;

    @Getter
    private   Time startTime;

    @Getter
    private Time endTime;

    @Getter
    private   int status;

    @Getter
    private int appNum;



    public TempObservation(){

        docName = ""; docSpecialization = ""; phoneNumber = ""; docEmail = "";
        docGender = ""; healthCentreName = ""; appDate = null; startTime = null;
        endTime = null; status = 0; appNum = 0;
    }

    public void setDocName(String d){
        this.docName = d;
    }

    public void setDocSpecialization(String s){this.docSpecialization = s;}
    public void setPhoneNumber(String p){this.phoneNumber = p;}
    public void setDocEmail(String e){this.docEmail = e;}
    public void setDocGender(String g){this.docGender = g;}
    public void setHealthCentreName(String h){this.healthCentreName = h;}
    public void setDate(Date d){this.appDate = d;}
    public void setStartTime(Time s){this.startTime = s;}
    public void setEndTime(Time e){this.endTime = e;}
    public void setStatus(int s){this.status = s;}
    public void setAppNum(int a){this.appNum = a;}

}
