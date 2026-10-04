package com.samsung.scsp.framework.core.identity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface E2eeInfoSupplier {
    public static final int DEFAULT_INTEGRITY_VALUE = Integer.MAX_VALUE;
    public static final String[] TYPES = {"non", "kmx", "sks"};

    default int getDeviceIntegrity() {
        return Integer.MAX_VALUE;
    }

    String getSakUid();

    int getType();
}
