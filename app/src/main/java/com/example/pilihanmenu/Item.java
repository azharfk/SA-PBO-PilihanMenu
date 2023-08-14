package com.example.pilihanmenu;

import java.io.Serializable;

public class Item implements Serializable {
    private int img;
    private String nama;
    private String deskripsi;
    private int harga;

    public Item(int img, String nama, String deskripsi, int harga) {
        this.img = img;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public int getImg() {
        return img;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getHarga() {
        return harga;
    }
}
