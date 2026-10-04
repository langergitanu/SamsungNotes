package com.samsung.android.support.senl.p148nt.model.executor;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ModelThreadPoolExecutor {
    private static final String TAG = ModelLogger.createTag("ModelThreadPoolExecutor");
    private static ExecutorService sExecutorService;

    @NonNull
    public static synchronized ExecutorService getSingleThreadExecutor() {
        try {
            if (sExecutorService == null) {
                sExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
            }
        } catch (Throwable th) {
            throw th;
        }
        return sExecutorService;
    }
}
