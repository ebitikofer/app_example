package com.example.e.permaguru;

/**
 * Created by e on 10/9/17.
 */

public class Profile {

    //private variables
    String _name;
    String _email;
    String _zone;
    Plan _plan;

    // Empty constructor
    public Profile(){

    }
    // constructor
    public Profile(String name, String email, String zone){
        this._name = name;
        this._email = email;
        this._zone = zone;
    }

    // constructor
    public Profile(String name, String email) {
        this._name = name;
        this._email = email;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting name
    public String getEmail(){
        return this._email;
    }

    // setting name
    public void setEmail(String email){
        this._email = email;
    }

    // getting phone number
    public String getNickName(){
        return this._zone;
    }

    // setting phone number
    public void setNickName(String zone){
        this._zone = zone;
    }
}
