package com.example.fastcanteen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardHome extends AppCompatActivity {

    app_bar appBar;
    LinearLayout homeBtn, inboxBtn, profilBtn, infoBtn;
    ProgressDialog progressDialog;
    SessionManager sessionManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_home);

        homeBtn = findViewById(R.id.homeBtn);
        inboxBtn = findViewById(R.id.inboxBtn);
//        appBar = findViewById(R.id.app_bar1);
        profilBtn = findViewById(R.id.profilBtn);
        infoBtn = findViewById(R.id.infoBtn);

        progressDialog = new ProgressDialog(this);

        sessionManager = new SessionManager(getApplicationContext());

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardHome.this, DashboardHome.class);
                startActivity(intent);
            }
        });

        inboxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DashboardHome.this, ChatMainActivity.class);
                startActivity(intent2);
            }
        });

//        appBar.setActionBar(new View.Acti() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3 = new Intent(DashboardHome.this, app_bar.class);
//                startActivity(intent3);
//            }
//        });

        profilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(DashboardHome.this, Profil.class);
                startActivity(intent4);
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(DashboardHome.this, info_aplikasi.class);
                startActivity(intent5);
            }
        });

        View orderMakanan = findViewById(R.id.orderMakanan);
        orderMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(DashboardHome.this, OrderMakanan.class);
                startActivity(intent6);
            }
        });

        View orderMinuman = findViewById(R.id.orderMinuman);
        orderMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(DashboardHome.this, OrderMinuman.class);
                startActivity(intent7);
            }
        });
    }

}