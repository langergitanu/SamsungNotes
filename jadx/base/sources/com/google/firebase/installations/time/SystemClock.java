package com.google.firebase.installations.time;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SystemClock implements Clock {
    private static SystemClock singleton;

    private SystemClock() {
    }

    public static SystemClock getInstance() {
        if (singleton == null) {
            singleton = new SystemClock();
        }
        return singleton;
    }

    @Override // com.google.firebase.installations.time.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
