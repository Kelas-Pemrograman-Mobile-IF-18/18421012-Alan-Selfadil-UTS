package com.alan.selfadil.aplikasipemesanangaselpiji.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alan.selfadil.aplikasipemesanangaselpiji.R;
import com.alan.selfadil.aplikasipemesanangaselpiji.admin.HomeAdminActivity;
import com.alan.selfadil.aplikasipemesanangaselpiji.admin.ProfileAdminActivity;

public class ProfilActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

    }
}