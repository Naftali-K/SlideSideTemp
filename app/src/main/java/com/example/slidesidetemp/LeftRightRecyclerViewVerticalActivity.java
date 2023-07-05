package com.example.slidesidetemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.slidesidetemp.adapters.VerticalRecyclerViewAdapter;
import com.example.slidesidetemp.interfaces.CallbackInterface;

public class LeftRightRecyclerViewVerticalActivity extends AppCompatActivity {

    private static final String TAG = "Test_code";

    private RecyclerView recyclerView;
    private VerticalRecyclerViewAdapter adapter;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right_recycler_view_vertical);
        setReferences();
        setGestureDetector();

        adapter = new VerticalRecyclerViewAdapter(getBaseContext(), new CallbackInterface() {
            @Override
            public void onBack() {
                onBackPressed();
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d(TAG, "onScrolled: X - " + dx + "; Y - " + dy);
                if (dx > 0) {
                    Log.d(TAG, "onScrolled: onBackPress");
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        Log.d(TAG, "onTouchEvent: Event");

        return super.onTouchEvent(event);
    }

    private void setReferences() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void setGestureDetector() {
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {

                if (velocityX > 0) {
                    Log.d(TAG, "onFling: Slide Left to Right");
                    onBackPressed();
                } else {
                    Log.d(TAG, "onFling: Slide Right to Left");
                }

                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }
}