package com.example.city_bus.model;

public class searchBusResultlist {

    private String bus_no;
    private String time;
    private String distance;
    private String route_name;
    private String route_img;

    public searchBusResultlist() {
    }


    public searchBusResultlist(String bus_no, String time, String distance, String route_name, String route_img) {
        this.bus_no = bus_no;
        this.time = time;
        this.distance = distance;
        this.route_name = route_name;
        this.route_img = route_img;
    }

    public String getBus_no() {
        return bus_no;
    }

    public void setBus_no(String bus_no) {
        this.bus_no = bus_no;
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

    public String getRoute_img() {
        return route_img;
    }

    public void setRoute_img(String route_img) {
        this.route_img = route_img;
    }


}
