package com.example.app.System;

public class FirstAid {
    public String incidentName ;
    public String measureLink ;

    public FirstAid(){
        incidentName = measureLink ="";
    }

    public void setIncidentName (String name){
        incidentName = name ;
    }

    public String getMeasureLink() {
        return measureLink;
    }

    public void setMeasureLink(String url){
        measureLink = url ;
    }

    public String getIncidentName() {
        return incidentName ;
    }
}

