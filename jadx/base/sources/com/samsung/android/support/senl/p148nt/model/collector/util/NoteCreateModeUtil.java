package com.samsung.android.support.senl.p148nt.model.collector.util;

import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NoteCreateModeUtil {
    private static final int MODE_LIMIT_COUNT = 2900;
    private static final String TAG = CollectLogger.createTag("NoteCreateModeUtil");
    private static final AtomicInteger sModeInteger = new AtomicInteger(2000);

    public static synchronized int getNoteCreateMode() {
        AtomicInteger atomicInteger;
        atomicInteger = sModeInteger;
        atomicInteger.compareAndSet(MODE_LIMIT_COUNT, 2000);
        atomicInteger.addAndGet(1);
        DataLogger.m12307i(TAG, "getNoteCreateMode  " + atomicInteger.get());
        return atomicInteger.get();
    }
}
