package com.example.fastcanteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.Normalizer;
//
public class OrderMinuman extends AppCompatActivity {
//
//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter adapter;
//    // SessionManager sessionManager;
//    private Button btnForm;
//    private Session session;
//    private SQLite dbsqlite;
    // String email;
//    private static final String KENDARAAN_URL = "https://bengkelinteam.000webhostapp.com/api/data_kendaraan.php";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order_minuman);
//
//        recyclerView = (RecyclerView) findViewById(R.id.recylcerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // declare sqlite
//        dbsqlite = new SQLite(getApplicationContext());
        // declare session manager
//        session = new Session(getApplicationContext());

        // cek apakah user sudah pernah login
//        if (!session.isLoggedIn()) {
            // Jika User tidak tercatat di sesiion atau telah login, Maka user automatis akan terlogout.
//            logoutUser();
//        }

        // Intent intent = getIntent();
        // email = intent.getStringExtra("email");
        // declare fungsi untuk memanggil data dari db
//        loadRecyclerViewData();

//        btnForm = findViewById(R.id.btnFormMinuman)
//        btnForm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(OrderMinuman.this, FormPemesanan.class);
//                startActivity(intent);
//            }
//        });
//    }
}