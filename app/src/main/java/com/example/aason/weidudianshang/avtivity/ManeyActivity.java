package com.example.aason.weidudianshang.avtivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.aason.weidudianshang.R;

public class ManeyActivity extends AppCompatActivity {

    private GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maney);
        gv = findViewById(R.id.gv);
        for (int i=0;i<20;i++){

        }
    }
}
