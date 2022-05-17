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
import com.example.formulas.domain.Formula;
import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;
import com.example.formulas.nodb.NoDb;
import com.example.formulas.rest.FormulasApiVolley;

public class AddScienceFragment extends Fragment {

    private EditText etScienceName;
    private AppCompatButton btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_science, container, false);


        btnAdd = view.findViewById(R.id.btn_add);
        etScienceName = view.findViewById(R.id.et_scienceName);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etScienceName.getText().toString().trim().length() == 0) return;
                new FormulasApiVolley(getContext()).addScience(
                        new Science(0,
                                etScienceName.getText().toString()
                        )
                );

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(AddScienceFragment.this)
                        .commit();
            }
        });

        return view;
    }
}
