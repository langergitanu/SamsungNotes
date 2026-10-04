package com.samsung.android.spen.libinterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface DvfsManagerInterface {
    void acquire();

    void acquire(int i);

    int getApproximateFrequency(int i);

    int[] getSupportedFrequency();

    void release();

    void setDvfsValue(int i);
}
