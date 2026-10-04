package com.google.android.play.core.internal;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ca */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC5206ca implements Closeable {
    /* JADX INFO: renamed from: a */
    public abstract long mo3720a();

    /* JADX INFO: renamed from: a */
    public abstract InputStream mo3721a(long j, long j2);

    /* JADX INFO: renamed from: b */
    public synchronized InputStream m3974b() {
        return mo3721a(0L, mo3720a());
    }
}
