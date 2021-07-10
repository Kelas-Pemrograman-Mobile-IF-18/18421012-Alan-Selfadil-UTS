package com.alan.selfadil.aplikasipemesanangaselpiji.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.alan.selfadil.aplikasipemesanangaselpiji.R;
import com.alan.selfadil.aplikasipemesanangaselpiji.admin.HistoryPesananAdminActivity;
import com.alan.selfadil.aplikasipemesanangaselpiji.admin.HomeAdminActivity;
import com.alan.selfadil.aplikasipemesanangaselpiji.admin.ProfileAdminActivity;
import com.alan.selfadil.aplikasipemesanangaselpiji.session.PrefSetting;
import com.alan.selfadil.aplikasipemesanangaselpiji.session.SessionManager;
import com.alan.selfadil.aplikasipemesanangaselpiji.tampilanawal.LoginActivity;

public class UserActivity extends AppCompatActivity {

    SessionManager session;
    SharedPreferences prefs;
    PrefSetting prefSetting;
    CardView cardExit, cardDataPesanan, cardInputGas, cardProfile;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        prefSetting = new PrefSetting(this);
        prefs = prefSetting.getSharePreferances();

        session = new SessionManager(UserActivity.this);

        prefSetting.isLogin(session, prefs);

        cardExit = (CardView) findViewById(R.id.btnKeluar);
        cardDataPesanan = (CardView) findViewById(R.id.btnHistory);
        cardProfile = (CardView) findViewById(R.id.btnProfil);
        cardInputGas = (CardView) findViewById(R.id.btnPesan);

        cardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setLogin(false);
                session.setSessid(0);
                Intent i = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        cardInputGas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, PesananActivity.class);
                startActivity(i);
                finish();
            }
        });

        cardDataPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, HistoryUserActivity.class);
                startActivity(i);
                finish();
            }
        });

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, ProfilActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}