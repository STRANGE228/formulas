package com.example.formulas.nodb;

import com.example.formulas.domain.Formula;
import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;

import java.util.ArrayList;
import java.util.List;

public class NoDb {
    private NoDb(){}

    public static final List<Formula> FORMULA_LIST = new ArrayList<>();
    public static final List<Theme> THEME_LIST = new ArrayList<>();
    public static final List<Science> SCIENCE_LIST = new ArrayList<>();
}
