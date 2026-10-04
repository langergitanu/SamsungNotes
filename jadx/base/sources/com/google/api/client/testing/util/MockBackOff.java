package com.google.api.client.testing.util;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class MockBackOff implements BackOff {
    private long backOffMillis;
    private int maxTries = 10;
    private int numTries;

    public final int getMaxTries() {
        return this.numTries;
    }

    public final int getNumberOfTries() {
        return this.numTries;
    }

    @Override // com.google.api.client.util.BackOff
    public long nextBackOffMillis() {
        int i = this.numTries;
        if (i < this.maxTries) {
            long j = this.backOffMillis;
            if (j != -1) {
                this.numTries = i + 1;
                return j;
            }
        }
        return -1L;
    }

    @Override // com.google.api.client.util.BackOff
    public void reset() {
        this.numTries = 0;
    }

    public MockBackOff setBackOffMillis(long j) {
        Preconditions.checkArgument(j == -1 || j >= 0);
        this.backOffMillis = j;
        return this;
    }

    public MockBackOff setMaxTries(int i) {
        Preconditions.checkArgument(i >= 0);
        this.maxTries = i;
        return this;
    }
}
