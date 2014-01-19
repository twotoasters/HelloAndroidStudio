package com.twotoasters.hellostudio;

import android.os.Bundle;
import android.app.Activity;

public class SimpleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
    }

    public long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }
    
}
