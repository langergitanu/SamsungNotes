package com.google.android.play.core.review;

import android.app.PendingIntent;
import androidx.constraintlayout.motion.widget.AbstractC2322a;

/* JADX INFO: renamed from: com.google.android.play.core.review.a */
/* JADX INFO: loaded from: classes5.dex */
final class C5247a extends ReviewInfo {

    /* JADX INFO: renamed from: a */
    private final PendingIntent f3011a;

    public C5247a(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            throw new NullPointerException("Null pendingIntent");
        }
        this.f3011a = pendingIntent;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    /* JADX INFO: renamed from: a */
    public final PendingIntent mo4050a() {
        return this.f3011a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            return this.f3011a.equals(((ReviewInfo) obj).mo4050a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f3011a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f3011a);
        return AbstractC2322a.m1626p(new StringBuilder(strValueOf.length() + 26), "ReviewInfo{pendingIntent=", strValueOf, "}");
    }
}
