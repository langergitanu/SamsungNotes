package com.google.android.play.core.internal;

import java.io.InputStream;

/* JADX INFO: renamed from: com.google.android.play.core.internal.cb */
/* JADX INFO: loaded from: classes5.dex */
public final class C5207cb extends AbstractC5206ca {

    /* JADX INFO: renamed from: a */
    private final AbstractC5206ca f2974a;

    /* JADX INFO: renamed from: b */
    private final long f2975b;

    /* JADX INFO: renamed from: c */
    private final long f2976c;

    public C5207cb(AbstractC5206ca abstractC5206ca, long j, long j2) {
        this.f2974a = abstractC5206ca;
        long jM3975a = m3975a(j);
        this.f2975b = jM3975a;
        this.f2976c = m3975a(jM3975a + j2);
    }

    @Override // com.google.android.play.core.internal.AbstractC5206ca
    /* JADX INFO: renamed from: a */
    public final long mo3720a() {
        return this.f2976c - this.f2975b;
    }

    /* JADX INFO: renamed from: a */
    private final long m3975a(long j) {
        if (j < 0) {
            return 0L;
        }
        return j > this.f2974a.mo3720a() ? this.f2974a.mo3720a() : j;
    }

    @Override // com.google.android.play.core.internal.AbstractC5206ca
    /* JADX INFO: renamed from: a */
    public final InputStream mo3721a(long j, long j2) {
        long jM3975a = m3975a(this.f2975b);
        return this.f2974a.mo3721a(jM3975a, m3975a(j2 + jM3975a) - jM3975a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
