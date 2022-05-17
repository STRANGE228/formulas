package com.example.formulas.domain.mapper;


import com.example.formulas.domain.Science;

import org.json.JSONException;
import org.json.JSONObject;

public class ScienceMapper {
    public static Science scienceFromJson(JSONObject jsonObject) {
        Science science = null;

        try {
            science = new Science(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return science;
    }

    public static Science scienceFromThemeJson(JSONObject jsonObject) {
        Science science = null;

        try {
            science = new Science(
                    jsonObject.getJSONObject("scienceDto").getInt("id"),
                    jsonObject.getJSONObject("scienceDto").getString("name")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return science;

    }
}
