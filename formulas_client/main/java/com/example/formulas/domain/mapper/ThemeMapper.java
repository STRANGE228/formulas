package com.example.formulas.domain.mapper;


import android.util.Log;

import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;
import com.example.formulas.nodb.NoDb;

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
            for (Theme theme1 : NoDb.THEME_LIST) {
                if (theme1.getName().equals(theme.getName())) {
                    theme = theme1;
                    break;
                }
            }
            theme.getScience().addTheme(theme);
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
            for (Theme theme1 : NoDb.THEME_LIST) {
                if (theme1.getName().equals(theme.getName())) {
                    theme = theme1;
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return theme;

    }
}
