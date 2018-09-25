package com.android.veggieprotection.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.veggieprotection.R;
import com.android.veggieprotection.model.EntitySayuran;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Diiyo on 11/18/15.
 */
public class SayuranAdapter extends RecyclerView.Adapter<SayuranAdapter.ViewHolder> {

    Context context;
    List<EntitySayuran> items;

    OnItemClick onItemClick;

    public SayuranAdapter(Context context, List<EntitySayuran> items) {
        this.context = context;
        this.items = items;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sayuran, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        EntitySayuran item = items.get(position);

        holder.title.setText(item.nama);

        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.icon)
        ImageView icon;
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.click)
        RelativeLayout click;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClick{
        void onClick(int position);
    }
}
