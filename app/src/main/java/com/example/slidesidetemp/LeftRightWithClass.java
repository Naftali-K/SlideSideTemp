package com.example.slidesidetemp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.MotionEvent;

import com.example.slidesidetemp.interfaces.CallbackInterface;
import com.example.slidesidetemp.listener.SwipeGestureListener;

public class LeftRightWithClass extends AppCompatActivity {

    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right_with_class);

        gestureDetector = new GestureDetectorCompat(this, new SwipeGestureListener(new CallbackInterface() {
            @Override
            public void onBack() {
                onBackPressed();
            }
        }));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}