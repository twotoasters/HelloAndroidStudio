package com.twotoasters.hellostudio;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

public class MainActivity extends ListActivity {

    private static final List<ActivityInfo> activitiesInfo = Arrays.asList(
            new ActivityInfo(SimpleActivity.class, R.string.activity_simple),
            new ActivityInfo(MavenLibraryActivity.class, R.string.activity_maven),
            new ActivityInfo(GradleLibraryActivity.class, R.string.activity_gradle));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] titles = getActivityTitles();
        setListAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, titles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Class<? extends Activity> clazz = activitiesInfo.get(position).activityClass;
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    protected String[] getActivityTitles() {
        String[] result = new String[activitiesInfo.size()];
        int i = 0;
        for (ActivityInfo info : activitiesInfo) {
            result[i++] = getString(info.titleResourceId);
        }
        return result;
    }

}
