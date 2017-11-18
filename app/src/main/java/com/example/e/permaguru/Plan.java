package com.example.e.permaguru;

/**
 * Created by e on 10/9/17.
 */

public class Plan {

    //private variables
    String _map;
    String _calendar;

    // Empty constructor
    public Plan(){

    }

    // constructor
    public Plan(String map, String calendar){
        this._map = map;
        this._calendar = calendar;
    }

    // getting map
    public String getMap(){
        return this._map;
    }

    // setting map
    public void setMap(String map){
        this._map = map;
    }

    // getting calendar
    public String getCalendar(){
        return this._calendar;
    }

    // setting calendar
    public void setCalendar(String calendar){
        this._calendar = calendar;
    }
}
