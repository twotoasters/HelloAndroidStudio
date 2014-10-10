package com.twotoasters.hellostudio.util;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Maintains a singleton instance for obtaining the bus. Ideally this would be replaced with
 * a more efficient means such as through injection directly into interested classes.
 */
public final class BusProvider {
    private static final MainPostingBus BUS = new MainPostingBus();

    public static MainPostingBus getInstance() {
        return BUS;
    }

    private BusProvider() {
        // no op
    }

    public static void register(Object object) {
        getInstance().register(object);
    }

    public static void unregister(Object object) {
        getInstance().unregister(object);
    }

    public static void post(Object event) {
        getInstance().post(event);
    }

    public static class MainPostingBus extends Bus {
        private final Handler mainThread = new Handler(Looper.getMainLooper());

        public MainPostingBus() {
            super(ThreadEnforcer.ANY);
        }

        @Override
        public void post(final Object event) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.post(event);
            } else {
                mainThread.post(new Runnable() {
                    @Override
                    public void run() {
                        MainPostingBus.super.post(event);
                    }
                });
            }
        }
    }
}
