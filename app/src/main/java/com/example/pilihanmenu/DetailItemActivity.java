package com.example.pilihanmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailItemActivity extends AppCompatActivity {

    private Item selectedItem;
    private int selectedItemHarga;
    private int qty = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item);

        Intent intent = getIntent();
        if (intent != null) {
            selectedItem = (Item) intent.getSerializableExtra("selectedItem");
            selectedItemHarga = selectedItem.getHarga();

            ImageView detailImg = findViewById(R.id.detailImg);
            TextView detailNama = findViewById(R.id.detailNama);
            TextView detailDeskripsi = findViewById(R.id.detailDeskripsi);
            TextView detailHrg = findViewById(R.id.detailHrg);

            detailImg.setImageResource(selectedItem.getImg());
            detailNama.setText(selectedItem.getNama());
            detailDeskripsi.setText(selectedItem.getDeskripsi());
            detailHrg.setText("Harga: " + selectedItem.getHarga());
        }

        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnPlus = findViewById(R.id.btnPlus);
        EditText etQty = findViewById(R.id.etQty);
        TextView jmlHrg = findViewById(R.id.jmlHrg);

        btnMinus.setOnClickListener(v -> {
            if (qty > 1) {
                qty--;
                updateUI(etQty, jmlHrg);
            }
        });

        btnPlus.setOnClickListener(v -> {
            qty++;
            updateUI(etQty, jmlHrg);
        });

        etQty.setOnEditorActionListener((v, actionId, event) -> {
            try {
                qty = Integer.parseInt(v.getText().toString());
            } catch (NumberFormatException e) {
                qty = 1;
            }
            updateUI(etQty, jmlHrg);
            return false;
        });
        updateUI(etQty, jmlHrg);

        Button pesanButton = findViewById(R.id.btnPesan);
        pesanButton.setOnClickListener(v -> {
            Intent detailTransactionIntent = new Intent(DetailItemActivity.this, DetailTransactionActivity.class);
            detailTransactionIntent.putExtra("namaItem", selectedItem.getNama());
            detailTransactionIntent.putExtra("hargaItem", selectedItemHarga);
            detailTransactionIntent.putExtra("quantity", qty);
            startActivity(detailTransactionIntent);
        });
    }

    private void updateUI(EditText etQty, TextView jmlHrg) {
        etQty.setText(String.valueOf(qty));
        int total = selectedItemHarga * qty;
        jmlHrg.setText(String.valueOf(total));
    }
}