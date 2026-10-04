package com.google.android.play.core.internal;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bo */
/* JADX INFO: loaded from: classes5.dex */
public final class C5193bo extends RuntimeException {
    public C5193bo(String str) {
        super(str);
    }

    public C5193bo(Throwable th) {
        super("Failed to initialize FileStorage", th);
    }
}
