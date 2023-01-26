package com.example.fastcanteen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.common.Priority;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button login, register;
    EditText ETemail, ETpassword;
    ProgressDialog progressDialog;
    SessionManager sessionManager;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
        ETemail = findViewById(R.id.ETemail);
        ETpassword = findViewById(R.id.ETpassword);

        progressDialog = new ProgressDialog(this);

        sessionManager = new SessionManager(getApplicationContext());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, DashboardHome.class);
//                startActivity(intent);

                progressDialog.setMessage("Login...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                email = ETemail.getText().toString();
                password = ETpassword.getText().toString();

                validasiData();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Register.class);
                startActivity(intent2);
            }
        });
    }

    void validasiData(){
        if(email.equals("") || password.equals("")){
            Toast.makeText(MainActivity.this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        } else {
            cekLogin();
        }
    }

    void cekLogin() {
        AndroidNetworking.post("https://tkjbpnup.com/kelompok_7/api_fastcanteen/cekLogin2.php")
                .addBodyParameter("email", ""+email)
                .addBodyParameter("password", ""+password)
                .setPriority(Priority.MEDIUM)
                .setTag("Cek Login")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        Log.d("Cek Login", "+response");

                    try {
                            Boolean status = response.getBoolean("status");
                            String pesan   = response.getString("result");
                            String id_user = response.getString("id_user");
                            String nama_lengkap = response.getString("nama_lengkap");
                            String email = response.getString("email");
                            String nomor_handphone = response.getString("nomor_hp");
                            String jurusan = response.getString("jurusan");
                            Toast.makeText(MainActivity.this, ""+pesan, Toast.LENGTH_SHORT).show();
                            Log.d("status",""+status);
                            if(status){
                                sessionManager.createSession_namalengkap(nama_lengkap);
                                sessionManager.createSession_jurusan(jurusan);
                                sessionManager.createSession_nomor(nomor_handphone);
                                sessionManager.createSession_email(email);
                                sessionManager.createSession_id(id_user);


                                new AlertDialog.Builder(MainActivity.this)
                                        .setMessage("Berhasil Login")
                                        .setCancelable(false)
                                        .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent2 = new Intent(MainActivity.this, DashboardHome.class);
                                                startActivity(intent2);
                                            }
                                        })
                                        .show();
                            }
                            else {
                                new AlertDialog.Builder(MainActivity.this)
                                        .setMessage("Gagal Melakukan Login !")
                                        .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                //dialog.cancel();
                                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                                startActivity(intent);
                                            }
                                        })
                                        .setCancelable(false)
                                        .show();
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }


}