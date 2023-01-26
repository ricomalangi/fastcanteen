package com.example.fastcanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

public class Register extends AppCompatActivity {

    Button BTNdaftar;
    EditText ETNamaLengkap, ETjurusan, ETemail, ETnomor, ETnamapengguna, ETPassword;
    String NamaLengkap, jurusan, email ,nomor, Password;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // deklarasikan variabel
        BTNdaftar = findViewById(R.id.btnRegister);
        ETNamaLengkap = findViewById(R.id.namaLenngkap);
        ETjurusan = findViewById(R.id.jurusan);
        ETnomor = findViewById(R.id.noHp);
        ETemail = findViewById(R.id.email);
        ETPassword = findViewById(R.id.password);

        // Memfungsikan Widget
        BTNdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NamaLengkap = ETNamaLengkap.getText().toString();
                jurusan = ETjurusan.getText().toString();
                nomor = ETnomor.getText().toString();
                email = ETemail.getText().toString();
                Password = ETPassword.getText().toString();


                validasiData();

                // Toast.makeText(getApplicationContext(),"Berhasil Melakukan Register",Toast.LENGTH_LONG).show();
                // startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


    }

    void validasiData(){
        if(NamaLengkap.equals("") ||jurusan.equals("") || nomor.equals("") || email.equals("") ||Password.equals("")){
            Toast.makeText(Register.this, "Data Tidak Lengkap", Toast.LENGTH_SHORT).show();
        } else {
            kirimData();
        }
    }

    void kirimData(){
        AndroidNetworking.post("https://tkjbpnup.com/kelompok_4/api_trashpickup/register.php")
                .addBodyParameter("nama_lengkap",""+NamaLengkap)
                .addBodyParameter("jurusan",""+jurusan)
                .addBodyParameter("nomor_telpon",""+nomor)
                .addBodyParameter("email",""+email)
                .addBodyParameter("password",""+Password)
                .setPriority(Priority.MEDIUM)
                .setTag("Tambah Data")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("cekRegister",""+response);

                        try {
                            Boolean status = response.getBoolean("status");
                            String pesan   = response.getString("result");
                            Toast.makeText(Register.this, ""+pesan, Toast.LENGTH_SHORT).show();
                            Log.d("status",""+status);
                            if(status){
                                new AlertDialog.Builder(Register.this)
                                        .setMessage("Berhasil Register")
                                        .setCancelable(false)
                                        .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent(Register.this, MainActivity.class);
                                                startActivity(intent);
                                            }
                                        })
                                        .show();
                            }
                            else {
                                new AlertDialog.Builder(Register.this)
                                        .setMessage("Gagal Melakukan Register !")
                                        .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent(Register.this, Register.class);
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
                        Log.d("ErrorTambahData",""+anError.getErrorBody());
                    }
                });
    }
}