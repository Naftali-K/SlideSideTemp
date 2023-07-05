package com.example.slidesidetemp.adapters;

import android.view.LayoutInflater;
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
 * @Date: 2023/06/27
 */
public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {

    private CallbackInterface callback;

    public HorizontalRecyclerViewAdapter(CallbackInterface callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_horizontal_item, parent, false);

        view.setOnTouchListener(new OnSwipeTouchListener(parent.getContext(), callback));

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
