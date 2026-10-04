package com.samsung.android.support.senl.p148nt.model.contextawareness.worker.task;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class InvalidTask extends DeepSkyTask {
    private static final String TAG = CALogger.createTag("InvalidTask");

    public InvalidTask(@NonNull ContextAwarenessParam contextAwarenessParam) {
        super(contextAwarenessParam);
    }

    @Override // java.lang.Runnable
    public void run() {
        DataLogger.m12302d(TAG, "run");
    }
}
