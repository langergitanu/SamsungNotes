package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5167ap;
import com.google.android.play.core.internal.InterfaceC5153ab;
import com.google.android.play.core.tasks.C5345i;
import com.google.android.play.core.tasks.Task;

/* JADX INFO: renamed from: com.google.android.play.core.review.h */
/* JADX INFO: loaded from: classes5.dex */
public final class C5254h {

    /* JADX INFO: renamed from: b */
    private static final C5157af f3021b = new C5157af("ReviewService");

    /* JADX INFO: renamed from: a */
    final C5167ap<InterfaceC5153ab> f3022a;

    /* JADX INFO: renamed from: c */
    private final String f3023c;

    public C5254h(Context context) {
        this.f3023c = context.getPackageName();
        this.f3022a = new C5167ap<>(context, f3021b, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), C5250d.f3015a);
    }

    /* JADX INFO: renamed from: a */
    public final Task<ReviewInfo> m4053a() {
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f3021b, "requestInAppReview (%s)", new Object[]{this.f3023c});
        this.f3022a.m3897a(new C5251e(this, c5345iM3195e, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }
}
