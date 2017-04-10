package com.example.admin.multiscreens;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //TextView numbers ,family,colors,phrases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new FragmentsControl(getSupportFragmentManager()));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


//        numbers=(TextView)findViewById(R.id.numbers);
//        family=(TextView)findViewById(R.id.family);
//        colors=(TextView)findViewById(R.id.colors);
//        phrases=(TextView)findViewById(R.id.phrases);
//
//  // method to be called on clicking numbers
//
//        numbers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,Numbers.class);
//                startActivity(i);
//            }
//        });
//
//        // method to be called on clicking  family
//        family.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,Family.class);
//                startActivity(i);
//            }
//        });
//        // method to be called on clicking  colors
//        colors.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,Colors.class);
//                startActivity(i);
//            }
//        });
//        // method to be called on clicking phrases
//        phrases.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,Phrases.class);
//                startActivity(i);
//            }
//        });
//
//
//



    }
}
