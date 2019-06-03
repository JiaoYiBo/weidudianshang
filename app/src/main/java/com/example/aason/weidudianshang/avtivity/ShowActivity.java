
package com.example.aason.weidudianshang.avtivity;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.app.CustomViewPager;
import com.example.aason.weidudianshang.fragment.FragmentFive;
import com.example.aason.weidudianshang.fragment.FragmentFour;
import com.example.aason.weidudianshang.fragment.Fragmentone;
import com.example.aason.weidudianshang.fragment.Fragmentthree;
import com.example.aason.weidudianshang.fragment.Fragmenttwo;

import java.util.ArrayList;


public class ShowActivity extends FragmentActivity {

    private CustomViewPager vp;
    private RadioGroup rg;
    private ArrayList<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        vp = findViewById(R.id.vp);
       vp.setScanScroll(false);
        rg = findViewById(R.id.rg);
        list = new ArrayList<Fragment>();
        list.add(new Fragmentone());
        list.add(new Fragmenttwo());
        list.add(new Fragmentthree());
        list.add(new FragmentFour());
        list.add(new FragmentFive());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        rg.check(R.id.rg1);
                        break;
                    case 1:
                        rg.check(R.id.rg2);
                        break;
                    case 2:
                        rg.check(R.id.rg3);
                        break;
                    case 3:
                        rg.check(R.id.rg4);
                        break;
                    case 4:
                        rg.check(R.id.rg5);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rg1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rg2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rg3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rg4:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rg5:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });
    }
}
