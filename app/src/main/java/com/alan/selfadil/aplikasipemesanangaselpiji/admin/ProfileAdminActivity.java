package com.alan.selfadil.aplikasipemesanangaselpiji.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.alan.selfadil.aplikasipemesanangaselpiji.R;
import com.alan.selfadil.aplikasipemesanangaselpiji.session.PrefSetting;
import com.alan.selfadil.aplikasipemesanangaselpiji.session.SessionManager;
import com.alan.selfadil.aplikasipemesanangaselpiji.tampilanawal.LoginActivity;

public class ProfileAdminActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_admin);
    }
}