package com.android.veggieprotection.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.veggieprotection.R;
import com.android.veggieprotection.model.EntityBookmark;
import com.android.veggieprotection.model.EntitySayuran;
import com.android.veggieprotection.util.QueryUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InformasiSayuranActivity extends AppCompatActivity {

    public static final String isBookmark = "marked";

    EntitySayuran sayur;
    @Bind(R.id.gambar)
    ImageView gambar;
    @Bind(R.id.namaSayur)
    TextView namaSayur;
    @Bind(R.id.btnHama)
    TextView btnHama;
    @Bind(R.id.keterangan)
    TextView keterangan;
    @Bind(R.id.bookmark)
    ImageView imgMark;

    EntityBookmark tbBookmark, cekBookmark;
    boolean status = false;

    int[] arrGambar = new int[]{R.drawable.tomat,
            R.drawable.bayam,
            R.drawable.terong,
            R.drawable.cabe,
            R.drawable.wortel};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_sayuran);
        ButterKnife.bind(this);

        getData();
        gambar.setImageResource(arrGambar[sayur.gambar]);
        namaSayur.setText(sayur.nama);
        keterangan.setText(sayur.detail);

    }

    @OnClick(R.id.btnHama)
    void showHama() {

        int index = (sayur.gambar + 1);

        Intent intent = new Intent(InformasiSayuranActivity.this, InformasiHamaActivity.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    @OnClick(R.id.bookmark)
    void bookmark(){

        if (cekBookmark == null && status == false){
            imgMark.setImageResource(R.drawable.bintangkuning);
            insertToBookmark();
            status = true;
        }

        else if (status == true){
            System.out.println("sudah selesai");
        }

    }

    private void getData() {

        Bundle data = getIntent().getExtras();
        sayur = (EntitySayuran) data.getSerializable("sayur");

        cekBookmark = QueryUtils.getBookmark(sayur.nama);

        if (cekBookmark != null){
            imgMark.setImageResource(R.drawable.bintangkuning);
        } else{
            imgMark.setImageResource(R.drawable.bintangputih);
        }
    }

    private void insertToBookmark(){
        tbBookmark = new EntityBookmark();
        tbBookmark.gambar = sayur.gambar;
        tbBookmark.nama = sayur.nama;
        tbBookmark.save();
    }

}
