package com.example.proyek2pbo;

public class NotaProperty {
    private int id_nota;
    private String tgl_pengambilan;


    public NotaProperty(int id_nota, String tgl_pengambilan) {
        this.id_nota = id_nota;
        this.tgl_pengambilan = tgl_pengambilan;
    }

    public int getId_nota() {
        return id_nota;
    }

    public String getTgl_pengambilan() {
        return tgl_pengambilan;
    }
}
