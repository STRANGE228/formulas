package com.example.formulas.domain;

import android.util.Log;

import com.example.formulas.nodb.NoDb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Science implements Serializable {
    private int id;

    private String name;

    private ArrayList<Theme> themeList = new ArrayList<>();

    public Science(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public void addTheme(Theme theme) {
        themeList.add(theme);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Theme> getThemeList(){
        return this.themeList;
    }

    @Override
    public String toString() {
        return name;
    }
}
