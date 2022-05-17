package com.example.formulas.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.formulas.R;

public class MenuFragment extends Fragment {

    AppCompatButton btnBack, addFormula, addScience, addTheme, changeScience, changeTheme;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        btnBack = view.findViewById(R.id.btn_menu_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(MenuFragment.this)
                        .commit();
            }
        });

        addFormula = view.findViewById(R.id.btn_add);
        addFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFormulaFragment addFormulaFragment = new AddFormulaFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, addFormulaFragment)
                        .commit();
            }
        });

        addScience = view.findViewById(R.id.btn_science);
        addScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddScienceFragment addScienceFragment = new AddScienceFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, addScienceFragment)
                        .commit();
            }
        });

        changeScience = view.findViewById(R.id.btn_science_change);
        changeScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditScienceFragment editScienceFragment = new EditScienceFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, editScienceFragment)
                        .commit();
            }
        });

        addTheme = view.findViewById(R.id.btn_theme);
        addTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddThemeFragment addThemeFragment = new AddThemeFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, addThemeFragment)
                        .commit();
            }
        });

        changeTheme = view.findViewById(R.id.btn_theme_change);
        changeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditThemeFragment editThemeFragment = new EditThemeFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, editThemeFragment)
                        .commit();
            }
        });


        return view;
    }
}

