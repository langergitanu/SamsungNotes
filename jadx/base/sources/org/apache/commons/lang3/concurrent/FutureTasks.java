package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FutureTasks {
    private FutureTasks() {
    }

    public static <V> FutureTask<V> run(Callable<V> callable) {
        FutureTask<V> futureTask = new FutureTask<>(callable);
        futureTask.run();
        return futureTask;
    }
}
