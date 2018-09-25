package com.android.veggieprotection.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.veggieprotection.R;
import com.android.veggieprotection.adapter.BookmarkAdapter;
import com.android.veggieprotection.model.EntityBookmark;
import com.android.veggieprotection.model.EntitySayuran;
import com.android.veggieprotection.util.QueryUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DaftarBookmarkActivity extends AppCompatActivity implements BookmarkAdapter.OnItemClick {

    @Bind(R.id.mylist)
    RecyclerView mylist;
    List<EntityBookmark> items = new ArrayList<>();
    BookmarkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bookmark2);
        ButterKnife.bind(this);

        mylist.setHasFixedSize(true);
        mylist.setLayoutManager(new LinearLayoutManager(this));

        items.clear();
        items.addAll(QueryUtils.getAllBookmark());

        adapter = new BookmarkAdapter(this, items);
        adapter.setOnItemClick(this);
        mylist.setAdapter(adapter);

    }

    @Override
    public void onClick(int position) {
        EntityBookmark item = items.get(position);
        EntitySayuran sayur = QueryUtils.ambilSayuran(item.nama);

        System.out.println(sayur);
        System.out.println(sayur.getId());

        System.out.println(QueryUtils.daftarHama(sayur).size());

        Intent intent = new Intent(DaftarBookmarkActivity.this, InformasiSayuranActivity.class);
        intent.putExtra("sayur", sayur);
        startActivity(intent);
    }
}
