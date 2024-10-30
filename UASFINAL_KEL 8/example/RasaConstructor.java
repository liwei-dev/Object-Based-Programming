package org.example;

public class RasaConstructor {
    private String id_rasa;
    private String nama_rasa;

    public RasaConstructor(String id_rasa, String nama_rasa) {
        this.id_rasa = id_rasa;
        this.nama_rasa = nama_rasa;
    }

    public RasaConstructor(){}

    public String getId_rasa() {
        return id_rasa;
    }

    public String getNama_rasa() {
        return nama_rasa;
    }

    public void setId_rasa(String id_rasa) {
        this.id_rasa = id_rasa;
    }
}
