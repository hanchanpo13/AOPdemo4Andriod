package com.jeven.aopdemo4andriod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.aop.LoginChecker;
import com.example.aop.SingleClick;
import com.example.aop.TimeWatcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SingleClick
    public void click(View v) {
        new Thread(() -> doClick()).start();
    }

    
    @TimeWatcher
    private void doClick() {
        try {
            Thread.sleep(2000);
            doSomeLoginThings();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LoginChecker
    private void doSomeLoginThings() {
    }
}
