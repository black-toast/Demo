package com.blacktoast.demo.statusbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean isNight = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setTransparentStatusBar(this, false);
        setContentView(R.layout.activity_main);
    }

    public void change(View view) {
        StatusBarUtils.setStatusTextColor(!isNight, MainActivity.this);
        isNight = !isNight;
    }
}
