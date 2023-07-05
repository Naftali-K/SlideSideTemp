package com.example.slidesidetemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class LeftRightActivity extends AppCompatActivity {
    private static final String TAG = "Test_code";

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right);
        setGestureDetector();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }

    private void setGestureDetector() {
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {

                if (velocityX > 0) {
//                    Log.d(TAG, "onFling: Slide Left to Right");
                    onBackPressed();
                } else {
//                    Log.d(TAG, "onFling: Slide Right to Left");
                }

                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }
}