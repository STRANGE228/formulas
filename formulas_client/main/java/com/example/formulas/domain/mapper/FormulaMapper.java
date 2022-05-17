package com.example.formulas.domain.mapper;

import android.util.Log;

import com.example.formulas.domain.Formula;
import com.example.formulas.domain.Theme;
import com.example.formulas.nodb.NoDb;

import org.json.JSONException;
import org.json.JSONObject;

public class FormulaMapper {

    public static Formula formulaFromJson(JSONObject jsonObject) {
        Formula formula = null;

        try {
            formula = new Formula(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("formula"),
                    ThemeMapper.themeFromFormulaJson(jsonObject)
            );
            for (Formula formula1 : NoDb.FORMULA_LIST) {
                if (formula1.getName().equals(formula.getName())) {
                    formula = formula1;
                    break;
                }
            }
            formula.getTheme().addFormula(formula);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return formula;
    }
}
