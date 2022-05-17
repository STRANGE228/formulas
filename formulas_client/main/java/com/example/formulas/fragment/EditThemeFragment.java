package com.example.formulas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.example.formulas.R;
import com.example.formulas.adapter.ScienceSpinnerAdapter;
import com.example.formulas.adapter.ThemeSpinnerAdapter;
import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;
import com.example.formulas.nodb.NoDb;
import com.example.formulas.rest.FormulasApiVolley;

public class EditThemeFragment extends Fragment {
    private EditText etThemeName;
    private ScienceSpinnerAdapter scienceSpinnerAdapter;
    private ThemeSpinnerAdapter themeSpinnerAdapter;
    private AppCompatButton btnAdd;
    private AppCompatSpinner spScience, spTheme;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_theme, container, false);

        spScience = view.findViewById(R.id.sp_science);
        spTheme = view.findViewById(R.id.sp_theme);
        btnAdd = view.findViewById(R.id.btn_add);
        etThemeName = view.findViewById(R.id.et_themeName);

        scienceSpinnerAdapter = new ScienceSpinnerAdapter(getContext(), NoDb.SCIENCE_LIST);
        themeSpinnerAdapter = new ThemeSpinnerAdapter(getContext(), NoDb.THEME_LIST);

        spScience.setAdapter(scienceSpinnerAdapter);
        spTheme.setAdapter(themeSpinnerAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etThemeName.getText().toString().trim().length() == 0) {
                    new FormulasApiVolley(getContext()).deleteTheme(
                            ((Theme) spTheme.getSelectedItem()).getId()
                    );
                }
                else {
                    new FormulasApiVolley(getContext()).updateTheme(
                            ((Theme) spTheme.getSelectedItem()).getId(),
                            etThemeName.getText().toString(),
                            ((Science) spScience.getSelectedItem()).getName()
                    );
                }

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(EditThemeFragment.this)
                        .commit();
            }
        });

        return view;
    }
}
