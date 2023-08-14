package com.example.pilihanmenu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<Item> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItem = new ArrayList<>();
        listItem.add(new Item(R.drawable.sate, "Sate Ayam", "sate ayam bumbu kacang", 20000));
        listItem.add(new Item(R.drawable.bakso, "Bakso Sapi", "bakso daging sapi", 15000));
        listItem.add(new Item(R.drawable.nasgor, "Nasi Goreng", "nasi goreng spesial", 15000));
        listItem.add(new Item(R.drawable.ayam, "Ayam Kremes", "ayam goreng yang kriuk dan renyah", 10000));
        listItem.add(new Item(R.drawable.esteh, "Es Teh", "minuman es teh yang segar", 5000));

        adapter = new RecyclerViewAdapter(listItem);
        recyclerView.setAdapter(adapter);
    }
}
