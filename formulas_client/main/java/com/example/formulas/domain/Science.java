package com.example.formulas.domain;

import java.io.Serializable;
import java.util.List;

public class Science implements Serializable {
    private int id;

    private String name;

    private List<Theme> themeList;

    public Science(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public void addTheme(Theme theme) {
        this.themeList.add(theme);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
