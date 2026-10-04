package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ChannelMetadata {
    private final int defaultMaxMessagesPerRead;
    private final boolean hasDisconnect;

    public ChannelMetadata(boolean z) {
        this(z, 1);
    }

    public int defaultMaxMessagesPerRead() {
        return this.defaultMaxMessagesPerRead;
    }

    public boolean hasDisconnect() {
        return this.hasDisconnect;
    }

    public ChannelMetadata(boolean z, int i) {
        ObjectUtil.checkPositive(i, "defaultMaxMessagesPerRead");
        this.hasDisconnect = z;
        this.defaultMaxMessagesPerRead = i;
    }
}
