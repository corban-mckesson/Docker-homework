package com.corban.upskilling.homework.helloname;

import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Name {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    protected Name(){}

    public Name(JSONObject name){
        this.name = name.toString();
    }

    public Name(String name){
        this.name = name;
    }

    public String getNameString(){
        return name.toString();
    }

    public JSONObject getNameJSON(){
        JSONObject json = new JSONObject(name);
        return json;
    }

    public int getId() {
        return id;
    }
}
