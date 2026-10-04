package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.i */
/* JADX INFO: loaded from: classes5.dex */
public final class C4999i implements InterfaceC5219cn<Context> {

    /* JADX INFO: renamed from: a */
    private final C4997g f2435a;

    public C4999i(C4997g c4997g) {
        this.f2435a = c4997g;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Context mo3591a() {
        Context contextM3592a = this.f2435a.m3592a();
        C5195bq.m3949b(contextM3592a);
        return contextM3592a;
    }
}
