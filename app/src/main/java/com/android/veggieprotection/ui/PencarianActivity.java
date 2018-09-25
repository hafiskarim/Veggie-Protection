package com.android.veggieprotection.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.android.veggieprotection.R;
import com.android.veggieprotection.adapter.PencarianAdapter;
import com.android.veggieprotection.model.EntitySayuran;
import com.android.veggieprotection.util.QueryUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PencarianActivity extends AppCompatActivity {

    List<EntitySayuran> list = new ArrayList<>();
    PencarianAdapter adapter;
    EntitySayuran entitySayuran;

    @Bind(R.id.ed_search)
    EditText edSearch;
    @Bind(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);
        ButterKnife.bind(this);

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String teks = s.toString();
                pencarian(teks);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                entitySayuran = list.get(position);

                Intent intent = new Intent(PencarianActivity.this, InformasiSayuranActivity.class);
                intent.putExtra("sayur", entitySayuran);
                startActivity(intent);
            }
        });

    }

    private void pencarian(String teks) {
        if (teks.length() == 0){
            list.clear();
            adapter.notifyDataSetChanged();
        }else{
            list.clear();
            list.addAll(QueryUtils.cariSayur(teks));
            adapter = new PencarianAdapter(this, list);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

    }
}
