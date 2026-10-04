package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface SpdyFrameDecoderDelegate {
    void readDataFrame(int i, boolean z, ByteBuf byteBuf);

    void readFrameError(String str);

    void readGoAwayFrame(int i, int i2);

    void readHeaderBlock(ByteBuf byteBuf);

    void readHeaderBlockEnd();

    void readHeadersFrame(int i, boolean z);

    void readPingFrame(int i);

    void readRstStreamFrame(int i, int i2);

    void readSetting(int i, int i2, boolean z, boolean z2);

    void readSettingsEnd();

    void readSettingsFrame(boolean z);

    void readSynReplyFrame(int i, boolean z);

    void readSynStreamFrame(int i, int i2, byte b, boolean z, boolean z2);

    void readWindowUpdateFrame(int i, int i2);
}
