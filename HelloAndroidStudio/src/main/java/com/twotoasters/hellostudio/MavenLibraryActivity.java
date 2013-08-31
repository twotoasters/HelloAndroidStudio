package com.twotoasters.hellostudio;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MavenLibraryActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maven);
        loadImage();
    }

    protected String getImageUrl() {
        return "http://www.gravatar.com/avatar/aaa0d355f3b4971c57396d5d51861f44?size=250";
    }

    private ImageView getImageView(int resId) {
        return (ImageView) findViewById(resId);
    }

    void loadImage() {
        Picasso.with(this)
                .load(getImageUrl())
                .into(getImageView(R.id.imageView));
    }

}
