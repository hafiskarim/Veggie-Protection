package com.android.veggieprotection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.veggieprotection.R;
import com.android.veggieprotection.model.EntitySayuran;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Diiyo on 12/1/15.
 */
public class PencarianAdapter extends ArrayAdapter<EntitySayuran> {

    Context context;
    List<EntitySayuran> list;

    public PencarianAdapter(Context context, List<EntitySayuran> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EntitySayuran entitySayuran = list.get(position);

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sayuran, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(entitySayuran.nama);

        return convertView;

    }

    static class ViewHolder {
        @Bind(R.id.icon)
        ImageView icon;
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.click)
        RelativeLayout click;
        @Bind(R.id.line)
        View line;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
