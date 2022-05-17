package com.example.formulas.rest;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.formulas.MainActivity;
import com.example.formulas.domain.Formula;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;
import com.example.formulas.domain.mapper.FormulaMapper;
import com.example.formulas.domain.mapper.ScienceMapper;
import com.example.formulas.domain.mapper.ThemeMapper;
import com.example.formulas.nodb.NoDb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FormulasApiVolley implements FormulasApi{

    private final Context context;

    public static final String BASE_URL = "http://192.168.165.137:1337";

    private Response.ErrorListener errorListener;

    public FormulasApiVolley(Context context) {
        this.context = context;
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("API_TEST_ERROR", error.toString());

            }
        };
    }

    @Override
    public void fillFormula() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/formula";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        NoDb.FORMULA_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = null;

                                jsonObject = response.getJSONObject(i);

                                Formula formula = FormulaMapper.formulaFromJson(jsonObject);
                                NoDb.FORMULA_LIST.add(formula);
                            }
                            ((MainActivity)context).updateAdapter();
                            Log.d("API_TEST_FORMULA", NoDb.FORMULA_LIST.toString() );

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                errorListener
        );
        requestQueue.add(arrayRequest);
    }

    @Override
    public void fillTheme() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/theme";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        NoDb.THEME_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = null;

                                jsonObject = response.getJSONObject(i);

                                Theme theme = ThemeMapper.themeFromJson(jsonObject);
                                NoDb.THEME_LIST.add(theme);
                            }
                            ((MainActivity)context).updateAdapter();
                            Log.d("API_TEST_THEME", NoDb.THEME_LIST.toString() );

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                errorListener
        );
        requestQueue.add(arrayRequest);
    }

    @Override
    public void fillScience() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/science";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        NoDb.SCIENCE_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = null;

                                jsonObject = response.getJSONObject(i);

                                Science science = ScienceMapper.scienceFromJson(jsonObject);
                                NoDb.SCIENCE_LIST.add(science);
                            }
                            ((MainActivity)context).updateAdapter();
                            Log.d("API_TEST_SCIENCE", NoDb.SCIENCE_LIST.toString() );

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                errorListener
        );
        requestQueue.add(arrayRequest);
    }

    @Override
    public void addFormula(Formula formula) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/formula";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillFormula();
                        Log.d("API_TEST_ADD_FORMULA", response);
                    }
                },
                errorListener
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("nameFormula", formula.getName());
                params.put("formula_s", formula.getFormula());
                params.put("nameTheme", formula.getTheme().getName());

                return params;
            }
        };
        requestQueue.add(request);
    }

    @Override
    public void updateFormula(int id, String newFormulaName, String newFormula, String newThemeName) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/formula" + "/" + id;

        StringRequest request = new StringRequest(
                Request.Method.PUT,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillFormula();
                        Log.d("API_TEST_UPDATE_FORMULA", response);
                    }
                },
                errorListener
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("nameFormula", newFormulaName);
                params.put("formula_s", newFormula);
                params.put("nameTheme", newThemeName);

                return params;
            }
        };
        requestQueue.add(request);
    }

    @Override
    public void deleteFormula(int id) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/formula" + "/" + id;

        StringRequest request = new StringRequest(
                Request.Method.DELETE,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillFormula();
                        Log.d("API_TEST_DELETE_FORMULA", response);
                    }
                },
                errorListener
        );
        requestQueue.add(request);
    }

    @Override
    public void addScience(Science science) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/science";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillScience();
                        Log.d("API_TEST_ADD_SCIENCE", response);
                    }
                },
                errorListener
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("nameScience", science.getName());

                return params;
            }
        };
        requestQueue.add(request);

    }

    @Override
    public void updateScience(int id, String nameScience) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/science" + "/" + id;

        StringRequest request = new StringRequest(
                Request.Method.PUT,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillScience();
                        Log.d("API_TEST_UPDATE_SCIENCE", response);
                    }
                },
                errorListener
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("name", nameScience);

                return params;
            }
        };
        requestQueue.add(request);

    }

    @Override
    public void deleteScience(int id) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/science" + "/" + id;

        StringRequest request = new StringRequest(
                Request.Method.DELETE,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillScience();
                        Log.d("API_TEST_DELETE_SCIENCE", response);
                    }
                },
                errorListener
        );
        requestQueue.add(request);
    }

    @Override
    public void addTheme(Theme theme) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/theme";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillTheme();
                        Log.d("API_TEST_ADD_THEME", response);
                    }
                },
                errorListener
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("nameTheme", theme.getName());
                params.put("nameScience", theme.getScience().getName());

                return params;
            }
        };
        requestQueue.add(request);
    }

    @Override
    public void updateTheme(int id, String nameTheme, String nameScience) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/theme" + "/" + id;

        StringRequest request = new StringRequest(
                Request.Method.PUT,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillTheme();
                        Log.d("API_TEST_UPDATE_THEME", response);
                    }
                },
                errorListener
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("nameTheme", nameTheme);
                params.put("nameScience", nameScience);

                return params;
            }
        };
        requestQueue.add(request);
    }

    @Override
    public void deleteTheme(int id) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/theme" + "/" + id;

        StringRequest request = new StringRequest(
                Request.Method.DELETE,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillTheme();
                        Log.d("API_TEST_DELETE_THEME", response);
                    }
                },
                errorListener
        );
        requestQueue.add(request);
    }
}
