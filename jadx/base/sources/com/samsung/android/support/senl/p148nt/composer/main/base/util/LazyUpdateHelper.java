package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LazyUpdateHelper<T> {
    Callback mCallback;
    Handler mHandler;
    LazyUpdateRunnable mLazyUpdateRunnable;
    long mUpdateInterval;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback<T> {
        void onLazyUpdate(T t);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LazyUpdateRunnable<T> implements Runnable {
        AtomicReference<T> mInfo;

        public /* synthetic */ LazyUpdateRunnable(LazyUpdateHelper lazyUpdateHelper, int i) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            LazyUpdateHelper.this.mCallback.onLazyUpdate(this.mInfo.get());
        }

        public void setValue(T t) {
            this.mInfo.set(t);
        }

        private LazyUpdateRunnable() {
            this.mInfo = new AtomicReference<>();
        }
    }

    public LazyUpdateHelper(@NonNull Callback callback) {
        this.mUpdateInterval = 100L;
        this.mCallback = callback;
        this.mHandler = new Handler();
        this.mLazyUpdateRunnable = new LazyUpdateRunnable(this, 0);
    }

    public void updateValue(T t) {
        this.mHandler.removeCallbacks(this.mLazyUpdateRunnable);
        this.mLazyUpdateRunnable.setValue(t);
        this.mHandler.postDelayed(this.mLazyUpdateRunnable, this.mUpdateInterval);
    }

    public LazyUpdateHelper(long j, @NonNull Callback callback) {
        this(callback);
        this.mUpdateInterval = j;
    }
}
