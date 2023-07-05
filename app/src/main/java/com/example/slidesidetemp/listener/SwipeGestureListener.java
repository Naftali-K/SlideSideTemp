package com.example.slidesidetemp.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

import com.example.slidesidetemp.interfaces.CallbackInterface;

/**
 * @Author: naftalikomarovski
 * @Date: 2023/06/27
 */
public class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    private CallbackInterface callback;

    public SwipeGestureListener(CallbackInterface callback) {
        this.callback = callback;
    }

    @Override
    public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        float diffX = e2.getX() - e1.getX();
        float diffY = e2.getY() - e1.getY();

        if (Math.abs(diffX) > Math.abs(diffY) && Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
            if (diffX > 0) {

                callback.onBack();
                return true;
            }
        }

        return false;
    }
}
