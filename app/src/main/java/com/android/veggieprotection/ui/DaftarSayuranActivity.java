package com.android.veggieprotection.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.veggieprotection.R;
import com.android.veggieprotection.adapter.SayuranAdapter;
import com.android.veggieprotection.model.EntityHama;
import com.android.veggieprotection.model.EntitySayuran;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DaftarSayuranActivity extends AppCompatActivity implements SayuranAdapter.OnItemClick {

    @Bind(R.id.mylist)
    RecyclerView mylist;

    List<EntitySayuran> items = new ArrayList<>();
    List<EntityHama> hamas = new ArrayList<>();

    SayuranAdapter adapter;


    // on create di buat untuk inisialisasi pertama kali activity di running
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sayuran);
        ButterKnife.bind(this);

        mylist.setHasFixedSize(true);
        mylist.setLayoutManager(new LinearLayoutManager(this));

        //mengosongkan array
        items.clear();
        //buat nampung data
        items.addAll(EntitySayuran.getAllSayuran());

        adapter = new SayuranAdapter(this, items);
        adapter.setOnItemClick(this);
        mylist.setAdapter(adapter);

    }

    @Override
    public void onClick(int position) {

        EntitySayuran item = items.get(position);

        Intent intent = new Intent(DaftarSayuranActivity.this, InformasiSayuranActivity.class);
        intent.putExtra("sayur", item);
        startActivity(intent);

    }

}
