package com.example.formulas.domain;

import java.io.Serializable;

public class Formula implements Serializable {

    private int id;

    private String name;

    private String formula;

    private Theme theme;

    public Formula(int id, String name, String formula, Theme theme) {
        this.name = name;
        this.formula = formula;
        this.id = id;
        this.theme = theme;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getFormula() {return formula;}

    public Theme getTheme() {
        return this.theme;
    }

    @Override
    public String toString() {
        return this.getTheme().getName() + ": " + this.name + "-" + this.formula;
    }
}
