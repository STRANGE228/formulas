package com.example.formulas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.example.formulas.R;
import com.example.formulas.adapter.ScienceSpinnerAdapter;
import com.example.formulas.adapter.ThemeSpinnerAdapter;
import com.example.formulas.domain.Formula;
import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;
import com.example.formulas.nodb.NoDb;
import com.example.formulas.rest.FormulasApiVolley;

public class ChangeFormulaFragment extends Fragment {
    private AppCompatSpinner spScience, spTheme;
    private ScienceSpinnerAdapter scienceSpinnerAdapter;
    private ThemeSpinnerAdapter themeSpinnerAdapter;
    private EditText etFormulaName, etFormula;
    private AppCompatButton btnAdd;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_formula, container, false);

        Formula formula = (Formula) getArguments().getSerializable("Formula");

        spScience = view.findViewById(R.id.sp_science);
        spTheme = view.findViewById(R.id.sp_theme);
        btnAdd = view.findViewById(R.id.btn_add);
        etFormulaName = view.findViewById(R.id.et_formulaName);
        etFormula = view.findViewById(R.id.et_formula);

        etFormulaName.setText(formula.getName());
        etFormula.setText(formula.getFormula());

        scienceSpinnerAdapter = new ScienceSpinnerAdapter(getContext(), NoDb.SCIENCE_LIST);
        themeSpinnerAdapter = new ThemeSpinnerAdapter(getContext(), NoDb.THEME_LIST);


        spScience.setAdapter(scienceSpinnerAdapter);
        spTheme.setAdapter(themeSpinnerAdapter);


        spScience.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                themeSpinnerAdapter.clear();
                themeSpinnerAdapter.addAll(((Science)spScience.getSelectedItem()).getThemeList());
                themeSpinnerAdapter.notifyDataSetChanged();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etFormulaName.getText().toString().trim().length() == 0) return;
                new FormulasApiVolley(getContext()).updateFormula(
                    formula.getId(),
                    etFormulaName.getText().toString(),
                    etFormula.getText().toString(),
                        String.valueOf(((Theme) spTheme.getSelectedItem()))
                );

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(ChangeFormulaFragment.this)
                        .commit();
            }
        });

        return view;
    }
}
