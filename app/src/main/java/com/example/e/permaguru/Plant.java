package com.example.e.permaguru;

/**
 * Created by e on 10/5/17.
 */

public class Plant {

    //private variables
    int _id;
    String _name;
    String _nick_name;

    // Empty constructor
    public Plant(){

    }
    // constructor
    public Plant(int id, String name, String nick_name){
        this._id = id;
        this._name = name;
        this._nick_name = nick_name;
    }

    // constructor
    public Plant(String name, String nick_name){
        this._name = name;
        this._nick_name = nick_name;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getNickName(){
        return this._nick_name;
    }

    // setting phone number
    public void setNickName(String nick_name){
        this._nick_name = nick_name;
    }
}