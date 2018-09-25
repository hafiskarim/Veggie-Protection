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
import com.android.veggieprotection.model.EntityBookmark;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Diiyo on 11/18/15.
 */
public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder> {

    Context context;
    List<EntityBookmark> items;

    OnItemClick onItemClick;

    public BookmarkAdapter(Context context, List<EntityBookmark> items) {
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

        final EntityBookmark item = items.get(position);

        holder.title.setText(item.nama);
        holder.icon.setImageResource(R.drawable.trash);
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onClick(position);
                }
            }
        });

        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeItem(position, item.getId());
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

    public void removeItem(int position, long id){
        items.remove(position);
        EntityBookmark.delete(EntityBookmark.class, id);
        notifyDataSetChanged();
    }

    public interface OnItemClick{
        void onClick(int position);
    }
}
