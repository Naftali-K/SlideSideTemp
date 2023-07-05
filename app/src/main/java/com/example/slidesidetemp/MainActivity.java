package com.example.slidesidetemp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.second_activity_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), LeftRightWithClass.class));
            }
        });

        findViewById(R.id.third_activity_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), LeftRightActivity.class));
            }
        });

        findViewById(R.id.fourth_activity_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), LeftRightRecyclerViewHorizontalActivity.class));
            }
        });

        findViewById(R.id.fifth_activity_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), LeftRightRecyclerViewVerticalActivity.class));
            }
        });

        findViewById(R.id.left_right_with_library_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), RightWithLibraryActivity.class));
            }
        });

        findViewById(R.id.right_recycler_view_with_library_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), RightRecyclerViewWithLibraryActivity.class));
            }
        });
    }
}