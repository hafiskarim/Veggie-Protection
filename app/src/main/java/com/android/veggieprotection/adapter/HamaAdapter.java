package com.android.veggieprotection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.veggieprotection.R;
import com.android.veggieprotection.model.EntityHama;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Diiyo on 11/23/15.
 */
public class HamaAdapter extends ArrayAdapter<EntityHama> {

    Context context;
    List<EntityHama> listHama;
    int[] arrGambar = new int[]{
            R.drawable.tomat,
            R.drawable.wortel,
            R.drawable.cabe,
            R.drawable.terong,
            R.drawable.wortel
    };

    OnClickListener onClickListener;

    public HamaAdapter(Context context, List<EntityHama> listHama) {
        super(context, 0, listHama);
        this.context = context;
        this.listHama = listHama;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        EntityHama hama = listHama.get(position);

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hama, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.gambar.setImageResource(arrGambar[hama.gambar]);
        holder.namaHama.setText(hama.nama);
        holder.keterangan.setText(hama.detail);
        holder.btnHama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null){
                    onClickListener.onClick(position);
                }
            }
        });

        return convertView;
    }

    @Override
    public int getCount() {
        return listHama.size();
    }

    public interface OnClickListener{
        void onClick(int position);
    }

    static class ViewHolder {
        @Bind(R.id.gambar)
        ImageView gambar;
        @Bind(R.id.namaHama)
        TextView namaHama;
        @Bind(R.id.btnHama)
        TextView btnHama;
        @Bind(R.id.keterangan)
        TextView keterangan;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
