package com.android.veggieprotection.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.android.veggieprotection.R;
import com.android.veggieprotection.model.EntityHama;
import com.android.veggieprotection.model.EntityPestisida;
import com.android.veggieprotection.model.EntitySayuran;
import com.android.veggieprotection.util.QueryUtils;

import java.util.ArrayList;
import java.util.List;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int TIME_OUT = 3000;
    List<EntitySayuran> daftarSayuran = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        daftarSayuran = QueryUtils.getAllSayuran();

        if (daftarSayuran.size() == 0 || daftarSayuran == null){
            insertTable();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MenuUtamaActivity.class));
                finish();
            }
        }, TIME_OUT);

    }

    private void insertTable() {

        EntitySayuran tomat = new EntitySayuran();
        tomat.gambar = 0;
        tomat.nama = "Tomat";
        tomat.detail = "Tomat enak dimakan";
        tomat.save();

        EntitySayuran bayam = new EntitySayuran();
        bayam.gambar = 1;
        bayam.nama = "Bayam";
        bayam.detail = "Di masak";
        bayam.save();

        EntitySayuran terong = new EntitySayuran();
        terong.gambar = 2;
        terong.nama = "Terong";
        terong.detail = "Di tanam";
        terong.save();

        EntitySayuran cabai = new EntitySayuran();
        cabai.gambar = 3;
        cabai.nama = "Cabai";
        cabai.detail = "Pedes";
        cabai.save();

        EntitySayuran wortel = new EntitySayuran();
        wortel.gambar = 4;
        wortel.nama = "Wortel";
        wortel.detail = "Makanan kelinci";
        wortel.save();

        EntityHama hamaTomatA = new EntityHama();
        hamaTomatA.gambar = 0;
        hamaTomatA.nama = "Kutu";
        hamaTomatA.detail = "Hama ini menyerang tomat dan mengakibatkan tomat menjadi busuk";
        hamaTomatA.entitySayuran = tomat;
        hamaTomatA.save();

        EntityHama hamaTomatB = new EntityHama();
        hamaTomatB.gambar = 1;
        hamaTomatB.nama = "Tungau";
        hamaTomatB.detail = "Hama ini membuat tomat menjadi berlubang";
        hamaTomatB.entitySayuran = tomat;
        hamaTomatB.save();

        EntityHama hamaTomatC = new EntityHama();
        hamaTomatC.gambar = 2;
        hamaTomatC.nama = "ulat";
        hamaTomatC.detail = "hama ini membuat ukuran tomat menjadi kecil";
        hamaTomatC.entitySayuran = tomat;
        hamaTomatC.save();

        EntityPestisida pestisidaA = new EntityPestisida();
        pestisidaA.gambar = 1;
        pestisidaA.nama = "Pestisida Kutu";
        pestisidaA.detail = "untuk mengusir hama A";
        pestisidaA.hama = hamaTomatA;
        pestisidaA.save();

        EntityPestisida pestisidaB = new EntityPestisida();
        pestisidaB.gambar = 2;
        pestisidaB.nama = "Pestisida Tungau";
        pestisidaB.detail = "untuk mengusir hama B";
        pestisidaB.hama = hamaTomatB;
        pestisidaB.save();

        EntityPestisida pestisidaC = new EntityPestisida();
        pestisidaC.gambar = 3;
        pestisidaC.nama = "Pestisida Ulat";
        pestisidaC.detail = "Untuk mengusir hama C";
        pestisidaC.hama = hamaTomatC;
        pestisidaC.save();

    }
}
