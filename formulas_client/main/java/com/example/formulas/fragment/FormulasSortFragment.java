package com.example.formulas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formulas.MainActivity;
import com.example.formulas.R;
import com.example.formulas.adapter.FormulaAdapter;
import com.example.formulas.adapter.ScienceSpinnerAdapter;
import com.example.formulas.adapter.ThemeSpinnerAdapter;
import com.example.formulas.domain.Formula;
import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;
import com.example.formulas.nodb.NoDb;
import com.example.formulas.rest.FormulasApiVolley;

public class FormulasSortFragment extends Fragment {
    private AppCompatSpinner spScience, spTheme;
    private ScienceSpinnerAdapter scienceSpinnerAdapter;
    private ThemeSpinnerAdapter themeSpinnerAdapter;
    private Science science;
    private RecyclerView rvFormula;
    private FormulaAdapter formulaAdapter;
    private ItemTouchHelper.SimpleCallback simpleCallback;
    private FormulasApiVolley formulasApiVolley;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_formula, container, false);

        spScience = view.findViewById(R.id.sp_science);
        spTheme = view.findViewById(R.id.sp_theme);
        rvFormula = view.findViewById(R.id.rv_formulas);

        science = new Science(0, "Все");
        scienceSpinnerAdapter = new ScienceSpinnerAdapter(getContext(), NoDb.SCIENCE_LIST);
        scienceSpinnerAdapter.add(new Science(0, "Все"));
        themeSpinnerAdapter = new ThemeSpinnerAdapter(getContext(), NoDb.THEME_LIST);
        themeSpinnerAdapter.add(new Theme(0, "Все", science));

        spScience.setAdapter(scienceSpinnerAdapter);
        spTheme.setAdapter(themeSpinnerAdapter);

        formulaAdapter = new FormulaAdapter(getContext(), NoDb.FORMULA_LIST);
        rvFormula.setAdapter(formulaAdapter);

        spScience.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                if (((Science)spScience.getSelectedItem()).getName().equals("Все")) {
                    formulaAdapter = new FormulaAdapter(getContext(), NoDb.FORMULA_LIST);
                    formulaAdapter.notifyDataSetChanged();
                } else {

                    themeSpinnerAdapter.clear();
                    themeSpinnerAdapter.addAll(((Science) spScience.getSelectedItem()).getThemeList());
                    themeSpinnerAdapter.notifyDataSetChanged();
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        spTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                if (((Theme)spTheme.getSelectedItem()).getName().equals("Все")) {
                    formulaAdapter = new FormulaAdapter(getContext(), NoDb.FORMULA_LIST);
                    formulaAdapter.notifyDataSetChanged();
                } else {

                    formulaAdapter = new FormulaAdapter(getContext(), ((Theme) spTheme.getSelectedItem()).getFormulaList());
                    formulaAdapter.notifyDataSetChanged();
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        return view;
    }

}
