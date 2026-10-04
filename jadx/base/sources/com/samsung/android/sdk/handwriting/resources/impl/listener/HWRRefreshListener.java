package com.samsung.android.sdk.handwriting.resources.impl.listener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface HWRRefreshListener {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RefreshResult {
        public static final int FAILURE = 1;
        public static final int SUCCESS = 0;
    }

    void onComplete(int i);
}
