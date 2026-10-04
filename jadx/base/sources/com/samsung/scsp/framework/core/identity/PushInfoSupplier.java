package com.samsung.scsp.framework.core.identity;

import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface PushInfoSupplier {
    default boolean compare() {
        return ScspCorePreferences.get().pushInfos.get().equals(new PushInfoList(getPushInfo()).toJsonArray().toString());
    }

    PushInfo[] getPushInfo();

    default boolean has() {
        return getPushInfo() != null && getPushInfo().length > 0;
    }

    @WorkerThread
    default void update() {
        ScspIdentityFactory.getUserInstance().updatePush();
    }
}
