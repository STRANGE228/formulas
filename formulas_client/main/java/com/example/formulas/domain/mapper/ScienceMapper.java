package com.example.formulas.domain.mapper;


import android.util.Log;

import com.example.formulas.domain.Science;
import com.example.formulas.nodb.NoDb;

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
            for (Science science1 : NoDb.SCIENCE_LIST) {
                if (science1.getName().equals(science.getName())) {
                    science = science1;
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return science;

    }
}
