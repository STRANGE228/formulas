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
import com.example.formulas.domain.Formula;
import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;
import com.example.formulas.nodb.NoDb;
import com.example.formulas.rest.FormulasApiVolley;

public class EditScienceFragment extends Fragment {
    private EditText etScienceName;
    private ScienceSpinnerAdapter scienceSpinnerAdapter;
    private AppCompatButton btnAdd;
    private AppCompatSpinner spScience;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_science, container, false);

        spScience = view.findViewById(R.id.sp_science);
        btnAdd = view.findViewById(R.id.btn_add);
        etScienceName = view.findViewById(R.id.et_scienceName);

        scienceSpinnerAdapter = new ScienceSpinnerAdapter(getContext(), NoDb.SCIENCE_LIST);
        spScience.setAdapter(scienceSpinnerAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etScienceName.getText().toString().trim().length() == 0) {
                    new FormulasApiVolley(getContext()).deleteScience(
                            ((Science) spScience.getSelectedItem()).getId()
                    );
                }
                else {
                    new FormulasApiVolley(getContext()).updateScience(
                            ((Science) spScience.getSelectedItem()).getId(),
                            etScienceName.getText().toString()
                    );
                }

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(EditScienceFragment.this)
                        .commit();
            }
        });

        return view;
    }
}
