package com.alan.selfadil.aplikasipemesanangaselpiji.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.alan.selfadil.aplikasipemesanangaselpiji.R;

public class DetailPesananGasUserActivity extends AppCompatActivity {

    EditText edtKodegas, edtJenisgas, edtJumlahgas, edtAlamat, edtAtasnama;

    String strKodegas, strJenisgas, strJumlagas, strAlamat, strAtasnama, _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan_gas_user);

        edtKodegas = (EditText) findViewById(R.id.edtKodeGas);
        edtJenisgas = (EditText) findViewById(R.id.edtJenisGas);
        edtJumlahgas = (EditText) findViewById(R.id.edtJumlahpesanan);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        edtAtasnama = (EditText) findViewById(R.id.edtAtasNama);

        Intent i = getIntent();
        strKodegas = i.getStringExtra("kodepesanan");
        strJenisgas = i.getStringExtra("jenisgas");
        strJumlagas = i.getStringExtra("jumlahpesanan");
        strAlamat = i.getStringExtra("alamatpenerima");
        strAtasnama = i.getStringExtra("atasnama");
        _id = i.getStringExtra("_id");

        edtKodegas.setText(strKodegas);
        edtJenisgas.setText(strJenisgas);
        edtJumlahgas.setText(strJumlagas);
        edtAlamat.setText(strAlamat);
        edtAtasnama.setText(strAtasnama);

    }
}