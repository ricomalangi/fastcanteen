package com.example.fastcanteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.fastcanteen.fragment.FragmentChat;

public class ChatMainActivity extends AppCompatActivity {

    private FragmentTransaction ft;
    private FragmentManager fm;
    private FragmentChat fragmentChat;
    private AppCompatActivity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_chat_main);

        context =this;
        activity = this;

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        BuatFragment();
    }

    private void BuatFragment() {
        fragmentChat = new FragmentChat(activity, context);

        ft.add(R.id.konten, fragmentChat);
        ft.commit();
    }

    public void TampilPesan() {
        Intent i = new Intent(ChatMainActivity.this, TampilPesan.class);
        startActivity(i);
        onPause();
    }
}