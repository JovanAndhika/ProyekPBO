package com.example.proyek2pbo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MemberProperty {

    public MemberProperty() {
    }

    public MemberProperty(String email, String nama) {
        this.setEmail(email);
        this.setNama(nama);
    }

    private StringProperty email;
    public void setEmail(String value) { emailProperty().set(value); }
    public String getEmail() { return emailProperty().get(); }
    public StringProperty emailProperty() {
        if (email == null) email = new SimpleStringProperty(this, "NRP");
        return email;
    }

    private StringProperty nama;
    public void setNama(String value) { namaProperty().set(value); }
    public String getNama() { return namaProperty().get(); }
    public StringProperty namaProperty() {
        if (nama == null) nama = new SimpleStringProperty(this, "nama");
        return nama;
    }
}
