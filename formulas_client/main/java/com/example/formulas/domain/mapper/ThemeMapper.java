package com.example.formulas.domain.mapper;


import com.example.formulas.domain.Theme;

import org.json.JSONException;
import org.json.JSONObject;

public class ThemeMapper {
    public static Theme themeFromJson(JSONObject jsonObject) {
        Theme theme = null;

        try {
            theme = new Theme(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    ScienceMapper.scienceFromThemeJson(jsonObject)
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return theme;
    }

    public static Theme themeFromFormulaJson(JSONObject jsonObject) {
        Theme theme = null;

        try {
            theme = new Theme(
                    jsonObject.getJSONObject("themeDto").getInt("id"),
                    jsonObject.getJSONObject("themeDto").getString("name"),
                    ScienceMapper.scienceFromThemeJson(jsonObject.getJSONObject("themeDto"))
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return theme;

    }
}
