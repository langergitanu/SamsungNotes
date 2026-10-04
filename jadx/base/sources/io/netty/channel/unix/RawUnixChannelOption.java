package io.netty.channel.unix;

import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class RawUnixChannelOption extends GenericUnixChannelOption<ByteBuffer> {
    private final int length;

    public RawUnixChannelOption(String str, int i, int i2, int i4) {
        super(str, i, i2);
        this.length = ObjectUtil.checkPositive(i4, "length");
    }

    public int length() {
        return this.length;
    }

    @Override // io.netty.channel.ChannelOption
    public void validate(ByteBuffer byteBuffer) {
        super.validate(byteBuffer);
        if (byteBuffer.remaining() == this.length) {
            return;
        }
        throw new IllegalArgumentException("Length of value does not match. Expected " + this.length + ", but got " + byteBuffer.remaining());
    }
}
