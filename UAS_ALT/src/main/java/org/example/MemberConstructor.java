package org.example;

public class MemberConstructor {

    private String nama_member;
    private String noTelp_member;
    private int poin_member;

    public MemberConstructor(String nama_member, String noTelp_member, int poin_member) {
        this.nama_member = nama_member;
        this.noTelp_member = noTelp_member;
        this.poin_member = poin_member;
    }

    public MemberConstructor(){}


    public void setNoTelp_member(String noTelp_member) {
        this.noTelp_member = noTelp_member;
    }

    public void setNama_member(String nama_member) {
        this.nama_member = nama_member;
    }

    public String getNoTelp_member() {
        return noTelp_member;
    }

    public String getNama_member() {
        return nama_member;
    }
}
