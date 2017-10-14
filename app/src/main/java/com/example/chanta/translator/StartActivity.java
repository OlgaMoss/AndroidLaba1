package com.example.chanta.translator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        getSupportActionBar().hide();
//
//        Intent intent = new Intent(this, StandartActivity.class);
//        startActivity(intent);
//        finish();
//    }
//
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start);

    Thread timerThread = new Thread(){
        public void run(){
            try{
                sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                Intent intent = new Intent(StartActivity.this,StandartActivity.class);
                startActivity(intent);
            }
        }
    };
        timerThread.start();
}

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
