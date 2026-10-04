package com.google.android.play.core.assetpacks;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bv */
/* JADX INFO: loaded from: classes5.dex */
final class C5065bv extends RuntimeException {

    /* JADX INFO: renamed from: a */
    final int f2682a;

    public C5065bv(String str) {
        super(str);
        this.f2682a = -1;
    }

    public C5065bv(String str, int i) {
        super(str);
        this.f2682a = i;
    }

    public C5065bv(String str, Exception exc) {
        super(str, exc);
        this.f2682a = -1;
    }

    public C5065bv(String str, Exception exc, int i) {
        super(str, exc);
        this.f2682a = i;
    }
}
