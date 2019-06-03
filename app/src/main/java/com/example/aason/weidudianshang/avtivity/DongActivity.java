package com.example.aason.weidudianshang.avtivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aason.weidudianshang.R;

public class DongActivity extends AppCompatActivity {
    private TextView miao;
    private ImageView img;
    private TextView tiao;
    private int ss = 5;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
           super.handleMessage(msg);
            ss--;
            miao.setText(ss + "s");
            if (ss == 0) {
                Intent intent = new Intent(DongActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                mediaPlayer.stop();
            } else {
                handler.sendEmptyMessageDelayed(0, 1000);
                mediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong);
        miao = findViewById(R.id.miao);
        img = findViewById(R.id.img);
        tiao = findViewById(R.id.tiao);
        mediaPlayer= MediaPlayer.create(this,R.raw.aaa);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        handler.sendEmptyMessageDelayed(0, 1000);
        initData();
    }
    public void tiao(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void initData() {
       getSupportActionBar().hide();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int height = displayMetrics.heightPixels;
        //渐变
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(img, "alpha", 0, 1);
        //缩放
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img, "scaleX", 2, 1);
        //旋转
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(img, "rotation", 0, 360);
        //平移
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(img, "translationY", height / 2 - img.getHeight() / 2);
        //组合
        AnimatorSet set = new AnimatorSet();
        set.play(objectAnimator).with(objectAnimator1).with(objectAnimator2).with(objectAnimator3);
        set.setDuration(6000);
        set.start();
        //监听
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
