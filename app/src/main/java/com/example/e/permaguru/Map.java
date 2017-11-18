package com.example.e.permaguru;

/**
 * Created by e on 10/9/17.
 */

public class Map {

    //private variables
    String _zones;
    String _edges;
    String _sectors;
    String _ecotones;
    String _beds;
    String _resources;

    // Empty constructor
    public Map(){

    }
    // constructor
    public Map(String zones, String edges, String sectors, String ecotones, String beds, String resources){
        this._zones = zones;
        this._edges = edges;
        this._sectors = sectors;
        this._ecotones = ecotones;
        this._beds = beds;
        this._resources = resources;
    }

    // getting zones
    public String getZones(){
        return this._zones;
    }

    // setting zones
    public void setZones(String zones){
        this._zones = zones;
    }

    // getting edges
    public String getEdges(){
        return this._edges;
    }

    // setting edges
    public void setEdges(String edges){
        this._edges = edges;
    }

    // getting sectors
    public String getSectors(){
      return this._sectors;
    }

    // setting sectors
    public void setSectors(String sectors){
        this._sectors = sectors;
    }

    // getting ecotones
    public String getEcotones(){
        return this._ecotones;
    }

    // setting ecotones
    public void setEcotones(String ecotones){
        this._ecotones = ecotones;
    }

    // getting beds
    public String getBeds(){
        return this._beds;
    }

    // setting beds
    public void setBeds(String beds){
        this._beds = beds;
    }

    // getting resources
    public String getResources(){
        return this._resources;
    }

    // setting resources
    public void setResources(String resources){
        this._resources = resources;
    }

}
