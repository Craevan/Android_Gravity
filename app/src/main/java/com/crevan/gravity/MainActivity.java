package com.crevan.gravity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.crevan.myframework.LoopFW;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoopFW loop = new LoopFW();
        loop.startGame();
    }
}