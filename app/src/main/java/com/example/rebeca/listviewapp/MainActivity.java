package com.example.rebeca.listviewapp;

import android.app.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity implements TextWatcher {



    @BindView(R.id.lvNames) ListView lvNames;
    @BindView(R.id.edtSearch) EditText edtSearch;
    ArrayAdapter<String> adapter;
    List<String> names;
    List<String> search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        names = new ArrayList<>();

        names.add("Lívia");
        names.add("Sarah");
        names.add("Amanda");
        names.add("Rebeca");

        edtSearch.addTextChangedListener(this);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        lvNames.setAdapter(adapter);

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
        adapter.getFilter().filter(s);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}




