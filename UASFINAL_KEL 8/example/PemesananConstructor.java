package org.example;

public class PemesananConstructor {

    private String id_pemesanan;

    private String id_member;

    private String tanggal_pemesanan;

    private int harga_total;

    private String metode_pembayaran;

    public PemesananConstructor(String id_pemesanan, String id_member, String tanggal_pemesanan, int harga_total){
        this.id_pemesanan = id_pemesanan;
        this.id_member = id_member;
        this.tanggal_pemesanan = tanggal_pemesanan;
        this.harga_total = harga_total;
        this.metode_pembayaran = metode_pembayaran;
    }

    public PemesananConstructor(){}

    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public String getId_member() {
        return id_member;
    }

    public String getTanggal_pemesanan() {
        return tanggal_pemesanan;
    }

    public String getMetode_Pembayaran() {
        return metode_pembayaran;
    }

    public int getHarga_total() {
        return harga_total;
    }
}
