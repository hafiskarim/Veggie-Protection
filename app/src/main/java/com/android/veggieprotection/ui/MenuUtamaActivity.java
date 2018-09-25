package com.android.veggieprotection.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.veggieprotection.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuUtamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sayur)
    void DaftarSayur() {
        startActivity(new Intent(MenuUtamaActivity.this, DaftarSayuranActivity.class));
    }

    @OnClick(R.id.bookmark)
    void DaftarBookmark() {
        startActivity(new Intent(MenuUtamaActivity.this, DaftarBookmarkActivity.class));
    }

    @OnClick(R.id.cari)
    void CariSayuran() {
        startActivity(new Intent(MenuUtamaActivity.this, PencarianActivity.class));
    }
}
