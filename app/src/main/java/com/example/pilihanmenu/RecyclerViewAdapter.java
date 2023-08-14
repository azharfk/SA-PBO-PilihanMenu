package com.example.pilihanmenu;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    private List<Item> listItem;
    public RecyclerViewAdapter(List<Item> listItem) {
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = listItem.get(position);
        holder.img.setImageResource(item.getImg());
        holder.nama.setText(item.getNama());
        holder.deskripsi.setText(item.getDeskripsi());
        String stringHarga = String.valueOf(item.getHarga());
        holder.harga.setText(stringHarga);
        holder.btnDetailPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getBindingAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Item selectedItem = listItem.get(adapterPosition);
                    Intent intent = new Intent(v.getContext(), DetailItemActivity.class);
                    intent.putExtra("selectedItem", selectedItem);
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView nama;
        TextView deskripsi;
        TextView harga;
        Button btnDetailPesan;
        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgMakanan);
            nama = itemView.findViewById(R.id.txtNama);
            deskripsi = itemView.findViewById(R.id.txtDeskripsi);
            harga = itemView.findViewById(R.id.txtHarga);
            btnDetailPesan = itemView.findViewById(R.id.btnDetailPesan);
        }
    }
}
