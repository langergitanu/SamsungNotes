package com.google.android.play.core.tasks;

import androidx.annotation.NonNull;
import com.google.android.play.core.internal.C5173av;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public final class Tasks {
    private Tasks() {
    }

    /* JADX INFO: renamed from: a */
    public static <ResultT> Task<ResultT> m4184a(Exception exc) {
        C5349m c5349m = new C5349m();
        c5349m.m4205a(exc);
        return c5349m;
    }

    public static <ResultT> ResultT await(@NonNull Task<ResultT> task) throws InterruptedException {
        C5173av.m3912a(task, "Task must not be null");
        if (task.isComplete()) {
            return (ResultT) m4186a((Task) task);
        }
        C5350n c5350n = new C5350n(null);
        m4187a(task, c5350n);
        c5350n.m4209a();
        return (ResultT) m4186a((Task) task);
    }

    /* JADX INFO: renamed from: a */
    public static <ResultT> Task<ResultT> m4185a(ResultT resultt) {
        C5349m c5349m = new C5349m();
        c5349m.m4206a(resultt);
        return c5349m;
    }

    public static <ResultT> ResultT await(@NonNull Task<ResultT> task, long j, @NonNull TimeUnit timeUnit) throws TimeoutException {
        C5173av.m3912a(task, "Task must not be null");
        C5173av.m3912a(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (ResultT) m4186a((Task) task);
        }
        C5350n c5350n = new C5350n(null);
        m4187a(task, c5350n);
        if (c5350n.m4210a(j, timeUnit)) {
            return (ResultT) m4186a((Task) task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    /* JADX INFO: renamed from: a */
    private static <ResultT> ResultT m4186a(Task<ResultT> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* JADX INFO: renamed from: a */
    private static void m4187a(Task<?> task, C5350n c5350n) {
        Executor executor = TaskExecutors.f3219a;
        task.addOnSuccessListener(executor, c5350n);
        task.addOnFailureListener(executor, c5350n);
    }
}
