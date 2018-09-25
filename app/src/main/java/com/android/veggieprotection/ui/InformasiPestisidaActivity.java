package com.android.veggieprotection.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.veggieprotection.R;
import com.android.veggieprotection.model.EntityHama;
import com.android.veggieprotection.model.EntityPestisida;
import com.android.veggieprotection.util.QueryUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InformasiPestisidaActivity extends AppCompatActivity {


    @Bind(R.id.gambar)
    ImageView gambar;
    @Bind(R.id.keterangan)
    TextView keterangan;
    @Bind(R.id.namaSayur)
    TextView namaSayur;
    @Bind(R.id.groupTitle)
    RelativeLayout groupTitle;

    EntityHama hama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_pestisida);
        ButterKnife.bind(this);

        getData();

    }

    private void getData(){

        Bundle data = getIntent().getExtras();
        int id = data.getInt("id");

        hama = QueryUtils.ambilHama(id);

        EntityPestisida pestisida = QueryUtils.ambilPestisida(hama);

        keterangan.setText(pestisida.detail);

    }
}
