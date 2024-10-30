package org.example;

public class MakananConstructor {

    private String id_makanan;
    private String nama_makanan;
    private int harga_makanan;

    public MakananConstructor(String id_makanan, String nama_makanan, int harga_makanan) {
        this.id_makanan = id_makanan;
        this.nama_makanan = nama_makanan;
        this.harga_makanan = harga_makanan;
    }

    public MakananConstructor(){};

    public String getId_makanan() {
        return id_makanan;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public int getHarga_makanan() {
        return harga_makanan;
    }

}