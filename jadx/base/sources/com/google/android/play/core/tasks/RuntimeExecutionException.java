package com.google.android.play.core.tasks;

/* JADX INFO: loaded from: classes5.dex */
public class RuntimeExecutionException extends AbstractC5346j {
    public RuntimeExecutionException(Throwable th) {
        super(th);
    }

    @Override // com.google.android.play.core.tasks.AbstractC5346j
    public final int getErrorCode() {
        return -100;
    }
}
