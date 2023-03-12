package com.example.noteassignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Notes> data;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private ItemClickListener2 itemClickListener2;
    TextView note;


    Adapter(Context context, List<Notes> data, ItemClickListener onClick, ItemClickListener2 onClick2) {
        this.mInflater = LayoutInflater.from(context);
        this.data = data;

        this.mClickListener = onClick;
        this.itemClickListener2 = onClick2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.note.setText(data.get(position).getUsername());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(holder.getAdapterPosition(), data.get(position).id);

            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener2.onItemClick2(holder.getAdapterPosition(), data.get(position).id);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView note;
        Button delete;
        Button update;

        ViewHolder(View itemView) {
            super(itemView);
            this.note = itemView.findViewById(R.id.note);
            this.delete = itemView.findViewById(R.id.delete);
            this.update = itemView.findViewById(R.id.update);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }

    }
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(int position, String id);
    }

    public interface ItemClickListener2{
        void onItemClick2(int position, String id);
    }
}
