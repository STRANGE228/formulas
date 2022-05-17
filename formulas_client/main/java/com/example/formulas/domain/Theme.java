package com.example.formulas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Theme implements Serializable {
    private int id;

    private String name;

    private Science science;

    private List<Formula> formulaList = new ArrayList<Formula>();

    public Theme(int id, String name, Science science) {
        this.name = name;
        this.id = id;
        this.science = science;
    }

    public void addFormula(Formula formula) {
        this.formulaList.add(formula);
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
