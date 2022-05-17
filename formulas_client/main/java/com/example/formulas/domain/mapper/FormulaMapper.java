package com.example.formulas.domain.mapper;

import android.util.Log;

import com.example.formulas.domain.Formula;

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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return formula;
    }
}
