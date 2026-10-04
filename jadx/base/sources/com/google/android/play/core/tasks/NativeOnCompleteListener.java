package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;

/* JADX INFO: loaded from: classes5.dex */
public class NativeOnCompleteListener implements OnCompleteListener<Object> {

    /* JADX INFO: renamed from: a */
    private final long f3217a;

    /* JADX INFO: renamed from: b */
    private final int f3218b;

    public NativeOnCompleteListener(long j, int i) {
        this.f3217a = j;
        this.f3218b = i;
    }

    public native void nativeOnComplete(long j, int i, @Nullable Object obj, int i2);

    @Override // com.google.android.play.core.tasks.OnCompleteListener
    public void onComplete(Task<Object> task) {
        if (!task.isComplete()) {
            throw new IllegalStateException(AbstractC4539a.m3197g(50, this.f3218b, "onComplete called for incomplete task: "));
        }
        if (task.isSuccessful()) {
            nativeOnComplete(this.f3217a, this.f3218b, task.getResult(), 0);
            return;
        }
        Exception exception = task.getException();
        if (!(exception instanceof AbstractC5346j)) {
            nativeOnComplete(this.f3217a, this.f3218b, null, -100);
            return;
        }
        int errorCode = ((AbstractC5346j) exception).getErrorCode();
        if (errorCode == 0) {
            throw new IllegalStateException(AbstractC4539a.m3197g(51, this.f3218b, "TaskException has error code 0 on task: "));
        }
        nativeOnComplete(this.f3217a, this.f3218b, null, errorCode);
    }
}
