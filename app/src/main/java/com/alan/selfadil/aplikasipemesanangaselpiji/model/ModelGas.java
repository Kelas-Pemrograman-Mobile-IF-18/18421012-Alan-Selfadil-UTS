package com.alan.selfadil.aplikasipemesanangaselpiji.model;

public class ModelGas {

    String _id, kodeGas, jenisGas, jumlahPesanan, alamatpenerima, atasnama;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getKodeGas() {
        return kodeGas;
    }

    public void setKodeGas(String kodeGas) {
        this.kodeGas = kodeGas;
    }

    public String getAtasnama() {
        return atasnama;
    }

    public void setAtasnama(String atasnama) {
        this.atasnama = atasnama;
    }

    public String getAlamatpenerima() {
        return alamatpenerima;
    }

    public void setAlamatpenerima(String alamatpenerima) {
        this.alamatpenerima = alamatpenerima;
    }

    public String getJenisGas() {
        return jenisGas;
    }

    public void setJenisGas(String jenisGas) {
        this.jenisGas = jenisGas;
    }

    public String getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(String jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

}
