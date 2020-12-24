package com.example.city_bus.model;

import java.io.Serializable;

public class Stops implements Serializable {

    public String bus_no;
    public String route_name;
    public String stop;

    public Stops(String string) {

    }

    public Stops(String bus_no, String route_name, String stop) {
        this.bus_no = bus_no;
        this.route_name = route_name;
        this.stop = stop;
    }

    public String getBus_no() {
        return bus_no;
    }

    public void setBus_no(String bus_no) {
        this.bus_no = bus_no;
    }

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }
}
