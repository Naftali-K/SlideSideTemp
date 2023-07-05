package com.example.slidesidetemp.listener;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.slidesidetemp.interfaces.CallbackInterface;

/**
 * @Author: naftalikomarovski
 * @Date: 2023/06/27
 */
public class OnSwipeTouchListener implements View.OnTouchListener {

    private static final String TAG = "Test_code";

    private CallbackInterface callback;

    private final GestureDetector gestureDetector;

    public OnSwipeTouchListener(Context context, CallbackInterface callback) {
        gestureDetector = new GestureDetector(context, new GestureListener());
        this.callback = callback;
        Log.d(TAG, "OnSwipeTouchListener: Start work touch action");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // Передайте событие касания в GestureDetector для обработки жестов
        boolean result = gestureDetector.onTouchEvent(motionEvent);

        // Обработайте жесты на уровне вложенного RecyclerView
        if (!result && motionEvent.getAction() == MotionEvent.ACTION_UP) {
            View parentRecyclerView = findParentRecyclerView(view);
            if (parentRecyclerView != null) {
                parentRecyclerView.performClick();
            }
        }

        return result;
    }

    private View findParentRecyclerView(View view) {
        View parent = (View) view.getParent();
        while (parent != null) {
            if (parent instanceof RecyclerView) {
                return parent;
            }
            parent = (View) parent.getParent();
        }
        return null;
    }


    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();

            Log.d(TAG, "onFling: X- " + diffX + " Y- " + diffY);

            if (Math.abs(diffX) > Math.abs(diffY) &&
                    Math.abs(diffX) > SWIPE_THRESHOLD &&
                    Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    onBackPressed();
                }
            }

            return true;
        }
    }

    public void onBackPressed() {

        Log.d(TAG, "onBackPressed: On Back Press");

        callback.onBack();
    }
}
