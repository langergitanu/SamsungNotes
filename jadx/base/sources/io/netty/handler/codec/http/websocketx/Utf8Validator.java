package io.netty.handler.codec.http.websocketx;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Utf8Validator implements ByteProcessor {
    private static final int UTF8_ACCEPT = 0;
    private static final int UTF8_REJECT = 12;
    private boolean checking;
    private int codep;
    private int state = 0;
    private static final byte[] TYPES = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 11, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    private static final byte[] STATES = {0, 12, 24, 36, 60, SprAttributeBase.TYPE_DURATION, 84, 12, 12, 12, 48, 72, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 12, 12, 12, 12, 12, 0, 12, 0, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, 36, 12, 36, 12, 12, 12, 36, 12, 12, 12, 12, 12, 36, 12, 36, 12, 12, 12, 36, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public void check(ByteBuf byteBuf) {
        this.checking = true;
        byteBuf.forEachByte(this);
    }

    public void finish() {
        this.checking = false;
        this.codep = 0;
        if (this.state == 0) {
            return;
        }
        this.state = 0;
        throw new CorruptedWebSocketFrameException(WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "bytes are not UTF-8");
    }

    public boolean isChecking() {
        return this.checking;
    }

    @Override // io.netty.util.ByteProcessor
    public boolean process(byte b) {
        byte b5 = TYPES[b & 255];
        int i = this.state;
        this.codep = i != 0 ? (b & Utf8.REPLACEMENT_BYTE) | (this.codep << 6) : b & (255 >> b5);
        byte b6 = STATES[i + b5];
        this.state = b6;
        if (b6 != 12) {
            return true;
        }
        this.checking = false;
        throw new CorruptedWebSocketFrameException(WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "bytes are not UTF-8");
    }

    public void check(ByteBuf byteBuf, int i, int i2) {
        this.checking = true;
        byteBuf.forEachByte(i, i2, this);
    }
}
