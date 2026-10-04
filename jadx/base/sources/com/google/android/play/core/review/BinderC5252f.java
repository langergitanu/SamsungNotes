package com.google.android.play.core.review;

import android.os.Bundle;
import com.google.android.play.core.internal.AbstractBinderC5154ac;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.review.f */
/* JADX INFO: loaded from: classes5.dex */
class BinderC5252f<T> extends AbstractBinderC5154ac {

    /* JADX INFO: renamed from: a */
    final C5157af f3018a;

    /* JADX INFO: renamed from: b */
    final C5345i<T> f3019b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5254h f3020c;

    public BinderC5252f(C5254h c5254h, C5157af c5157af, C5345i<T> c5345i) {
        this.f3020c = c5254h;
        this.f3018a = c5157af;
        this.f3019b = c5345i;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5155ad
    /* JADX INFO: renamed from: a */
    public void mo3869a(Bundle bundle) {
        this.f3020c.f3022a.m3896a();
        this.f3018a.m3878c("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
