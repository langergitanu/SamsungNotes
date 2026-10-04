package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.play.core.internal.AbstractBinderC5231o;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.m */
/* JADX INFO: loaded from: classes5.dex */
class BinderC5003m<T> extends AbstractBinderC5231o {

    /* JADX INFO: renamed from: a */
    final C5157af f2443a;

    /* JADX INFO: renamed from: b */
    final C5345i<T> f2444b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5006p f2445c;

    public BinderC5003m(C5006p c5006p, C5157af c5157af, C5345i<T> c5345i) {
        this.f2445c = c5006p;
        this.f2443a = c5157af;
        this.f2444b = c5345i;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5232p
    /* JADX INFO: renamed from: a */
    public void mo3596a(Bundle bundle) {
        this.f2445c.f2450a.m3896a();
        this.f2443a.m3878c("onRequestInfo", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5232p
    /* JADX INFO: renamed from: b */
    public void mo3597b(Bundle bundle) {
        this.f2445c.f2450a.m3896a();
        this.f2443a.m3878c("onCompleteUpdate", new Object[0]);
    }
}
