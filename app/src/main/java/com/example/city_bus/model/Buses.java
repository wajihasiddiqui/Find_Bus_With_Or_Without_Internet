package com.example.city_bus.model;

public class Buses {

    private String bus_no;
    private String bus_startlocations;
    private String bus_endlocation;
    private String time;
    private String distance;
    private String route_name;
    //private String route_img;


    public Buses(String bus_no, String bus_startlocations, String bus_endlocation, String time, String distance, String route_name) {
        this.bus_no = bus_no;
        this.bus_startlocations = bus_startlocations;
        this.bus_endlocation = bus_endlocation;
        this.time = time;
        this.distance = distance;
        this.route_name = route_name;
    }

    public String getBus_no() {
        return bus_no;
    }

    public void setBus_no(String bus_no) {
        this.bus_no = bus_no;
    }

    public String getBus_startlocations() {
        return bus_startlocations;
    }

    public void setBus_startlocations(String bus_startlocations) {
        this.bus_startlocations = bus_startlocations;
    }

    public String getBus_endlocation() {
        return bus_endlocation;
    }

    public void setBus_endlocation(String bus_endlocation) {
        this.bus_endlocation = bus_endlocation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }
}
