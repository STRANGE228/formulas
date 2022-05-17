package com.example.formulas.domain;

import java.io.Serializable;

public class Theme implements Serializable {
    private int id;

    private String name;

    private Science science;

    public Theme(int id, String name, Science science) {
        this.name = name;
        this.id = id;
        this.science = science;
//        this.science.addTheme(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Science getScience() {
        return science;
    }

    @Override
    public String toString() {
        return name;
    }
}
