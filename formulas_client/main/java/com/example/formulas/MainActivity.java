package com.example.formulas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.formulas.adapter.FormulaAdapter;
import com.example.formulas.domain.Formula;
import com.example.formulas.fragment.AddFormulaFragment;
import com.example.formulas.fragment.MenuFragment;
import com.example.formulas.nodb.NoDb;
import com.example.formulas.rest.FormulasApiVolley;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFormula;
    private FormulaAdapter formulaAdapter;
    private FormulasApiVolley formulasApiVolley;

    private ItemTouchHelper.SimpleCallback simpleCallback;

    private AppCompatButton btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.btn_menu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuFragment menuFragment = new MenuFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, menuFragment)
                        .commit();
            }
        });

        rvFormula = findViewById(R.id.rv_formulas);
        formulasApiVolley = new FormulasApiVolley(this);

        formulasApiVolley.fillScience();
        formulasApiVolley.fillTheme();
        formulasApiVolley.fillFormula();

        formulaAdapter = new FormulaAdapter(this, NoDb.FORMULA_LIST);
        rvFormula.setAdapter(formulaAdapter);

        simpleCallback = new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                Formula formula = NoDb.FORMULA_LIST.get(viewHolder.getAdapterPosition());

                if (direction == ItemTouchHelper.LEFT) {
                    formulasApiVolley.deleteFormula(formula.getId());
                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvFormula);
    }

    public void updateAdapter() {

        formulaAdapter.notifyDataSetChanged();
    }

    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        if (fragmentList.size() > 0) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragmentList.get(fragmentList.size() - 1))
                    .commit();
        } else {
            finish();
        }
    }
}