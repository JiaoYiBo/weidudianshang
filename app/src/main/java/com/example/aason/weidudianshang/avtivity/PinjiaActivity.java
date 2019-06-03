package com.example.aason.weidudianshang.avtivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;

public class PinjiaActivity extends AppCompatActivity {

    private TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinjia);
        btn = findViewById(R.id.text_frag04_orderfrag02_total);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PinjiaActivity.this, WoActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(PinjiaActivity.this, "发表成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
