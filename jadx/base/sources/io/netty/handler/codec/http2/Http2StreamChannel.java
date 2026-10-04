package io.netty.handler.codec.http2;

import io.netty.channel.Channel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2StreamChannel extends Channel {
    Http2FrameStream stream();
}
