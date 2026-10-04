package com.google.android.play.core.splitcompat;

import android.content.Context;
import com.google.android.play.core.splitinstall.C5319t;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.m */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC5268m implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f3051a;

    public RunnableC5268m(Context context) {
        this.f3051a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C5319t.m4153a(this.f3051a).m4035a(true);
    }
}
