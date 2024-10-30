package org.example;

public class ToppingConstructor {
    private String id_topping;
    private String nama_topping;
    private int harga_topping;

    public ToppingConstructor(String id_topping, String nama_topping, int harga_topping) {
        this.id_topping = id_topping;
        this.nama_topping = nama_topping;
        this.harga_topping = harga_topping;
    }

    public ToppingConstructor(){}

    public String getId_topping() {
        return id_topping;
    }

    public String getNama_topping() {
        return nama_topping;
    }

    public int getHarga_topping() {
        return harga_topping;
    }

    public void setId_topping(String id_topping) {
        this.id_topping = id_topping;
    }
}
