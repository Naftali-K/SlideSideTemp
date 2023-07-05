package com.example.slidesidetemp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.slidesidetemp.adapters.HorizontalRecyclerViewAdapter;
import com.example.slidesidetemp.interfaces.CallbackInterface;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

/**
 * https://youtu.be/Ci5146VOyg4
 * https://github.com/r0adkll/Slidr
 */

public class RightRecyclerViewWithLibraryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HorizontalRecyclerViewAdapter adapter;

    private SlidrInterface slidrInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_recycler_view_with_library);
        setReferences();

        slidrInterface = Slidr.attach(this);


        adapter = new HorizontalRecyclerViewAdapter(new CallbackInterface() {
            @Override
            public void onBack() {

            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void setReferences() {
        recyclerView = findViewById(R.id.recycler_view);
    }
}