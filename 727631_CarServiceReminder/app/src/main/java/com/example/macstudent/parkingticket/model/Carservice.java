package com.example.macstudent.parkingticket.model;


//import java.util.Date;

/**
 * Created by macstudent on 2018-04-13.
 */

public class Carservice {

    private int id;
    private String serviceDate;
    private String odometer;
    private String serviceType;
    private String description;
    private String cost;
    private String nextService;
    private String nextChange;
    private String serviceStation;

    public Carservice() {

    }

    public Carservice(int id, String serviceDate, String odometer, String serviceType, String description, String cost, String nextService, String nextChange, String serviceStation) {
        this.id = id;
        this.serviceDate = serviceDate;
        this.odometer = odometer;
        this.serviceType = serviceType;
        this.description = description;
        this.cost = cost;
        this.nextService = nextService;
        this.nextChange = nextChange;
        this.serviceStation = serviceStation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNextService() {
        return nextService;
    }

    public void setNextService(String nextService) {
        this.nextService = nextService;
    }

    public String getNextChange() {
        return nextChange;
    }

    public void setNextChange(String nextChange) {
        this.nextChange = nextChange;
    }

    public String getServiceStation() {
        return serviceStation;
    }

    public void setServiceStation(String serviceStation) {
        this.serviceStation = serviceStation;
    }
}