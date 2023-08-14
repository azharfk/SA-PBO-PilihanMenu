package com.example.pilihanmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_transaksi);

        TextView namaPesanan = findViewById(R.id.namaPesanan);
        TextView jmlPesanan = findViewById(R.id.jmlPesanan);
        TextView totalBayar = findViewById(R.id.totalBayar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String namaItem = extras.getString("namaItem");
            int selectedItemHarga = extras.getInt("hargaItem");
            int qty = extras.getInt("quantity");
            int total = selectedItemHarga * qty;

            namaPesanan.setText(namaItem);
            jmlPesanan.setText(selectedItemHarga + " x " + qty);
            totalBayar.setText(String.valueOf(total));
        }

        Button backButton = findViewById(R.id.btnMenu);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(DetailTransactionActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

    }
}
