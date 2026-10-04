package com.samsung.android.smartswitchfileshare;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface FileShareCallback {
    public static final long LEAST_PROGRESS_INTERVAL = 200;

    void finish(int i, int i2);

    void progress(long j, long j2);
}
