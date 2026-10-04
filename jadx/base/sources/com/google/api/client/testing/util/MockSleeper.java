package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Sleeper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class MockSleeper implements Sleeper {
    private int count;
    private long lastMillis;

    public final int getCount() {
        return this.count;
    }

    public final long getLastMillis() {
        return this.lastMillis;
    }

    @Override // com.google.api.client.util.Sleeper
    public void sleep(long j) {
        this.count++;
        this.lastMillis = j;
    }
}
