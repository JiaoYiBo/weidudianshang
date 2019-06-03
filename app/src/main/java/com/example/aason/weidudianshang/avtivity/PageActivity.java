package com.example.aason.weidudianshang.avtivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;

public class PageActivity extends AppCompatActivity {

    private View btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {

            private Intent intent;

            @Override
            public void onClick(View v) {
                Toast.makeText(PageActivity.this,"支付成功",Toast.LENGTH_SHORT).show();
                intent = new Intent(PageActivity.this, FinshActivity.class);
                startActivity(intent);

            }
        });
    }
}
