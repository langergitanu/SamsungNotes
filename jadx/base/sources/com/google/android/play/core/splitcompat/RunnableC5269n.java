package com.google.android.play.core.splitcompat;

import android.util.Log;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.n */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC5269n implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ SplitCompat f3052a;

    public RunnableC5269n(SplitCompat splitCompat) {
        this.f3052a = splitCompat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3052a.f3027b.m4076a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
