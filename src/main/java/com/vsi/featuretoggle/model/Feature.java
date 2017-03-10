package com.vsi.featuretoggle.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "toggles")
public class Feature {

    @Id
    private String Id;

    private String name;

    private String description;

    private boolean state;

    public Feature() {}

    public Feature(String name, String description, boolean state) {
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getId() {
        return this.Id;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOn() {
        return state;
    }
    //getter, setter, toString, Constructors

}