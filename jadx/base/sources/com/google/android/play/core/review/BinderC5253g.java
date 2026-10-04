package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.review.g */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5253g extends BinderC5252f<ReviewInfo> {
    public BinderC5253g(C5254h c5254h, C5345i c5345i) {
        super(c5254h, new C5157af("OnRequestInstallCallback"), c5345i);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.play.core.review.BinderC5252f, com.google.android.play.core.internal.InterfaceC5155ad
    /* JADX INFO: renamed from: a */
    public final void mo3869a(Bundle bundle) {
        super.mo3869a(bundle);
        this.f3019b.m4201b((T) ReviewInfo.m4049a((PendingIntent) bundle.get("confirmation_intent")));
    }
}
