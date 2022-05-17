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
import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;
import com.example.formulas.nodb.NoDb;
import com.example.formulas.rest.FormulasApiVolley;

public class AddThemeFragment extends Fragment {

    private EditText etThemeName;
    private AppCompatButton btnAdd;
    private ScienceSpinnerAdapter scienceSpinnerAdapter;
    private AppCompatSpinner spScience;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_theme, container, false);


        btnAdd = view.findViewById(R.id.btn_add);
        etThemeName = view.findViewById(R.id.et_themeName);
        spScience = view.findViewById(R.id.sp_science);

        scienceSpinnerAdapter = new ScienceSpinnerAdapter(getContext(), NoDb.SCIENCE_LIST);
        spScience.setAdapter(scienceSpinnerAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etThemeName.getText().toString().trim().length() == 0) return;
                new FormulasApiVolley(getContext()).addTheme(
                        new Theme(0,
                                etThemeName.getText().toString(),
                                ((Science) spScience.getSelectedItem())
                        )
                );

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(AddThemeFragment.this)
                        .commit();
            }
        });

        return view;
    }
}
