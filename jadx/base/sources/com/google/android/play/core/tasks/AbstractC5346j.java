package com.google.android.play.core.tasks;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.j */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC5346j extends RuntimeException {
    public AbstractC5346j(String str) {
        super(str);
    }

    public abstract int getErrorCode();

    public AbstractC5346j(Throwable th) {
        super(th);
    }
}
