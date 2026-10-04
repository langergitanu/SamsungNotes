package io.netty.handler.codec.http2;

import io.netty.channel.ChannelId;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Http2StreamChannelId implements ChannelId {
    private static final long serialVersionUID = -6642338822166867585L;

    /* JADX INFO: renamed from: id */
    private final int f8905id;
    private final ChannelId parentId;

    public Http2StreamChannelId(ChannelId channelId, int i) {
        this.parentId = channelId;
        this.f8905id = i;
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        return this.parentId.asLongText() + '/' + this.f8905id;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        return this.parentId.asShortText() + '/' + this.f8905id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Http2StreamChannelId)) {
            return false;
        }
        Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) obj;
        return this.f8905id == http2StreamChannelId.f8905id && this.parentId.equals(http2StreamChannelId.parentId);
    }

    public int hashCode() {
        return this.parentId.hashCode() + (this.f8905id * 31);
    }

    public String toString() {
        return asShortText();
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (!(channelId instanceof Http2StreamChannelId)) {
            return this.parentId.compareTo(channelId);
        }
        Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) channelId;
        int iCompareTo = this.parentId.compareTo(http2StreamChannelId.parentId);
        return iCompareTo == 0 ? this.f8905id - http2StreamChannelId.f8905id : iCompareTo;
    }
}
