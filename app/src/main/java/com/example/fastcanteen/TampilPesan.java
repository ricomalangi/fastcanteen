package com.example.fastcanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;

public class TampilPesan extends AppCompatActivity {

    private LinearLayout pesan;
    private Context context;
    private LinearLayout send;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_tampil_pesan);

        context = this;
        pesan = findViewById(R.id.pesan);
        send = findViewById(R.id.send);
        text = findViewById(R.id.editText);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = text.getText().toString();
                CardMyPesan(s);
            }
        });

        Kontent();
    }

    private void CardMyPesan(String s) {
        View v = getLayoutInflater().inflate(R.layout.card_pesan_b, null);
        LinearLayout konten_pesan = v.findViewById(R.id.konten_pesan);
        TextView textView = new TextView(context);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(lp);

        textView.setText(""+s);
        textView.setTextSize(14);
        textView.setTextColor(getResources().getColor(R.color.hitam));
        konten_pesan.addView(textView);

        pesan.addView(v);
        text.setText("");

    }

    private void Kontent() {
        View v = getLayoutInflater().inflate(R.layout.card_pesan, null);
        LinearLayout konten_pesan = v.findViewById(R.id.konten_pesan);
        TextView textView = new TextView(context);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(lp);

        textView.setText("selamat datang !");
        textView.setTextSize(14);
        textView.setTextColor(getResources().getColor(R.color.hitam));
        konten_pesan.addView(textView);

        pesan.addView(v);
    }
}