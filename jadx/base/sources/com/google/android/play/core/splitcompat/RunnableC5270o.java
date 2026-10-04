package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.o */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC5270o implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Set f3053a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ SplitCompat f3054b;

    public RunnableC5270o(SplitCompat splitCompat, Set set) {
        this.f3054b = splitCompat;
        this.f3053a = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Iterator it = this.f3053a.iterator();
            while (it.hasNext()) {
                this.f3054b.f3027b.m4086f((String) it.next());
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
