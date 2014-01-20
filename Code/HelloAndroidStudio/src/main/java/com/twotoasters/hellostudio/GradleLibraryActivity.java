package com.twotoasters.hellostudio;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

public class GradleLibraryActivity extends Activity implements PullToRefreshAttacher.OnRefreshListener {

    private PullToRefreshAttacher pullToRefreshAttacher;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradle);

        pullToRefreshAttacher = setupPullToRefresh();
    }

    protected PullToRefreshAttacher setupPullToRefresh() {
        if (pullToRefreshAttacher == null) {
            // Create a PullToRefreshAttacher instance
            pullToRefreshAttacher = PullToRefreshAttacher.get(this);

            // Retrieve the PullToRefreshLayout from the content view
            PullToRefreshLayout ptrLayout = (PullToRefreshLayout) findViewById(R.id.ptr_layout);

            // Give the PullToRefreshAttacher to the PullToRefreshLayout, along with a refresh listener.
            ptrLayout.setPullToRefreshAttacher(pullToRefreshAttacher, this);
        }
        return pullToRefreshAttacher;
    }

    @Override
    public void onRefreshStarted(View view) {
        /**
         * Simulate Refresh with 4 seconds sleep
         */
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);

                // Notify PullToRefreshAttacher that the refresh has finished
                pullToRefreshAttacher.setRefreshComplete();
            }
        }.execute();
    }
}
