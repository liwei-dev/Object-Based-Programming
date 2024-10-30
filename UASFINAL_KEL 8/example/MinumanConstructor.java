package org.example;

class MinumanConstructor{

    private String id_minuman;
    private String nama_minuman;
    private int harga_minuman;
    public MinumanConstructor(String id_minuman, String nama_minuman, int harga_minuman) {
        this.id_minuman = id_minuman;
        this.nama_minuman = nama_minuman;
        this.harga_minuman = harga_minuman;
    }

    public MinumanConstructor(){}

    public String getId_minuman() {
        return id_minuman;
    }

    public String getNama_minuman() {
        return nama_minuman;
    }

    public int getHarga_minuman() {
        return harga_minuman;
    }

}
