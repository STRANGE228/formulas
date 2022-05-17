package com.example.formulas.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formulas.R;
import com.example.formulas.domain.Formula;
import com.example.formulas.fragment.ChangeFormulaFragment;
import com.example.formulas.nodb.NoDb;

import java.util.List;

public class FormulaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    private final List<Formula> formulaList;

    public FormulaAdapter(Context context, List<Formula> formulaList) {
        this.inflater = LayoutInflater.from(context);
        this.formulaList = formulaList;
        this.context = context;
    }

    private class MyHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvScience, tvTheme, tvFormula;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvScience = itemView.findViewById(R.id.tv_science);
            tvTheme = itemView.findViewById(R.id.tv_theme);
            tvFormula = itemView.findViewById(R.id.tv_formula);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.formula_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Formula formula = NoDb.FORMULA_LIST.get(position);

        ((MyHolder) holder).tvName.setText(formula.getName());
        ((MyHolder) holder).tvScience.setText(formula.getTheme().getScience().getName());
        ((MyHolder) holder).tvTheme.setText(formula.getTheme().getName());
        ((MyHolder) holder).tvFormula.setText(formula.getFormula());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFormulaFragment changeFormulaFragment = new ChangeFormulaFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable("Formula", formula);

                changeFormulaFragment.setArguments(bundle);

                ((AppCompatActivity)context).getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, changeFormulaFragment)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return NoDb.FORMULA_LIST.size();
    }
}
