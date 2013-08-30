package com.twotoasters.hellostudio;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BlankActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blank, menu);
        return true;
    }

    public long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }
    
}
