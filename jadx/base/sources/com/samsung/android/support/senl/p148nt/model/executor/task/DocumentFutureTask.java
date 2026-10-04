package com.samsung.android.support.senl.p148nt.model.executor.task;

import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentFutureTask<V> extends FutureTask<V> {
    private Callable<V> mCallable;
    private Runnable mRunnable;

    public DocumentFutureTask(@NonNull Callable<V> callable) {
        super(callable);
        this.mCallable = callable;
    }

    public Callable<V> getCallable() {
        return this.mCallable;
    }

    public Runnable getRunnable() {
        return this.mRunnable;
    }

    @Override // java.util.concurrent.FutureTask
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (getRunnable() != null) {
            sb.append(" runnable : ");
            sb.append(getRunnable());
        }
        if (getCallable() != null) {
            sb.append(" callable : ");
            sb.append(getCallable());
        }
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }

    public DocumentFutureTask(@NonNull Runnable runnable, V v) {
        super(runnable, v);
        this.mRunnable = runnable;
    }
}
