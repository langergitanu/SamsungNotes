package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import java.io.InputStream;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bs */
/* JADX INFO: loaded from: classes5.dex */
final class C5062bs extends C5088cr {

    /* JADX INFO: renamed from: a */
    final int f2663a;

    /* JADX INFO: renamed from: b */
    final long f2664b;

    /* JADX INFO: renamed from: c */
    final String f2665c;

    /* JADX INFO: renamed from: d */
    final int f2666d;

    /* JADX INFO: renamed from: e */
    final int f2667e;

    /* JADX INFO: renamed from: f */
    final int f2668f;

    /* JADX INFO: renamed from: g */
    final long f2669g;

    /* JADX INFO: renamed from: h */
    @AssetPackStatus
    final int f2670h;

    /* JADX INFO: renamed from: i */
    final InputStream f2671i;

    public C5062bs(int i, String str, int i2, long j, String str2, int i4, int i5, int i6, long j2, @AssetPackStatus int i7, InputStream inputStream) {
        super(i, str);
        this.f2663a = i2;
        this.f2664b = j;
        this.f2665c = str2;
        this.f2666d = i4;
        this.f2667e = i5;
        this.f2668f = i6;
        this.f2669g = j2;
        this.f2670h = i7;
        this.f2671i = inputStream;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3735a() {
        return this.f2667e + 1 == this.f2668f;
    }
}
