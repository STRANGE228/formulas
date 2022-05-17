package com.example.formulas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.formulas.R;
import com.example.formulas.domain.Theme;
import com.example.formulas.nodb.NoDb;

import java.util.List;

public class ThemeSpinnerAdapter extends ArrayAdapter<Theme> {
    public ThemeSpinnerAdapter(@NonNull Context context, @NonNull List<Theme> objects) {
        super(context, R.layout.spinner_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.spinner_item, null);
        }

        ((TextView)convertView.findViewById(R.id.tv_spinner_item))
                .setText(NoDb.THEME_LIST.get(position).getName());

        return convertView;
    }
}
