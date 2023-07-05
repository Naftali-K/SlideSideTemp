package com.example.slidesidetemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

/**
 * https://youtu.be/Ci5146VOyg4
 * https://github.com/r0adkll/Slidr
 */

public class RightWithLibraryActivity extends AppCompatActivity {

    private Button lockBtn, unlockBtn;

    private SlidrInterface slidrInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_with_library);
        setReferences();

        slidrInterface = Slidr.attach(this);

        lockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidrInterface.lock();
            }
        });
        unlockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidrInterface.unlock();
            }
        });
    }

    private void setReferences() {
        lockBtn = findViewById(R.id.lock_btn);
        unlockBtn = findViewById(R.id.unlock_btn);
    }
}