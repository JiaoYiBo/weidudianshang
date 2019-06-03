package com.example.aason.weidudianshang.avtivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;

public class FinshActivity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finsh);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            private Intent intent;

            @Override
            public void onClick(View v) {
                //Toast.makeText(FinshActivity.this,"支付成功",Toast.LENGTH_SHORT).show();
                intent = new Intent(FinshActivity.this, ShowActivity.class);
                startActivity(intent);

            }
        });
    }
}
