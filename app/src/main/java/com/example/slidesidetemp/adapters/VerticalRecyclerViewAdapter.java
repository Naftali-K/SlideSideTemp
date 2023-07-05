package com.example.slidesidetemp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.slidesidetemp.interfaces.CallbackInterface;
import com.example.slidesidetemp.listener.OnSwipeTouchListener;
import com.example.slidesidetemp.R;

/**
 * @Author: naftalikomarovski
 * @Date: 2023/06/28
 */
public class VerticalRecyclerViewAdapter extends  RecyclerView.Adapter<VerticalRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "Test_code";

    private Context context;
    private CallbackInterface callback;

    private GestureDetector gestureDetector;

    public VerticalRecyclerViewAdapter(Context context, CallbackInterface callback) {
        this.context = context;
        this.callback = callback;

        init(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_vertical_item, parent, false);

//        view.setOnTouchListener(new OnSwipeTouchListener(parent.getContext(), callback)); // connect touch listener

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private void init(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {

            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();

            if (Math.abs(diffX) > Math.abs(diffY) &&
                    Math.abs(diffX) > SWIPE_THRESHOLD &&
                    Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    // Выполняйте действия при смахивании вправо
                    Log.d(TAG, "onFling: onBackPress");
                    return true;
                }
            }

            return false;
        }
    }



    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }

        void bind(int position) {
            textView.setText("Test item " + position);
        }
    }
}
