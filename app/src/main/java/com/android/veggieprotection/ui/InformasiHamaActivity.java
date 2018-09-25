package com.android.veggieprotection.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.veggieprotection.R;
import com.android.veggieprotection.adapter.HamaAdapter;
import com.android.veggieprotection.model.EntityHama;
import com.android.veggieprotection.model.EntitySayuran;
import com.android.veggieprotection.util.QueryUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InformasiHamaActivity extends AppCompatActivity implements HamaAdapter.OnClickListener{

    @Bind(R.id.mylist)
    ListView mylist;

    List<EntityHama> listHama = new ArrayList<>();
    HamaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_hama);
        ButterKnife.bind(this);

        Bundle data = getIntent().getExtras();
        int index = data.getInt("index");

        EntitySayuran sayur = QueryUtils.getSingleSayuran(index);

        listHama.clear();
        listHama.addAll(EntityHama.daftarHama(sayur));

        adapter = new HamaAdapter(this, listHama);
        adapter.setOnClickListener(this);
        mylist.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        int id = (position + 1);
        Intent intent = new Intent(InformasiHamaActivity.this, InformasiPestisidaActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
