package com.twotoasters.hellostudio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    private static final List<ActivityInfo> ACTIVITIES_INFO = Arrays.asList(
            new ActivityInfo(SimpleActivity.class, R.string.activity_simple),
            new ActivityInfo(MavenLibraryActivity.class, R.string.activity_maven),
            new ActivityInfo(GradleLibraryActivity.class, R.string.activity_gradle));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] titles = getActivityTitles();

        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, titles));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onListItemClick(parent, view, position, id);
            }
        });
    }

    protected void onListItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class<? extends Activity> clazz = ACTIVITIES_INFO.get(position).activityClass;
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    protected String[] getActivityTitles() {
        String[] result = new String[ACTIVITIES_INFO.size()];
        int i = 0;
        for (ActivityInfo info : ACTIVITIES_INFO) {
            result[i++] = getString(info.titleResourceId);
        }
        return result;
    }

}
