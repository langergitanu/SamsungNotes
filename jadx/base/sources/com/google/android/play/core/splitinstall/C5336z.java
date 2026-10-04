package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.z */
/* JADX INFO: loaded from: classes5.dex */
public final class C5336z implements InterfaceC5219cn<Context> {

    /* JADX INFO: renamed from: a */
    private final C5335y f3216a;

    public C5336z(C5335y c5335y) {
        this.f3216a = c5335y;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Context mo3591a() {
        Context contextM4182b = this.f3216a.m4182b();
        C5195bq.m3949b(contextM4182b);
        return contextM4182b;
    }
}
