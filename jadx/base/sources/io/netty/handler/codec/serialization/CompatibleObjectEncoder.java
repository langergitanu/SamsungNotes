package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class CompatibleObjectEncoder extends MessageToByteEncoder<Serializable> {
    private final int resetInterval;
    private int writtenObjects;

    public CompatibleObjectEncoder() {
        this(16);
    }

    public ObjectOutputStream newObjectOutputStream(OutputStream outputStream) {
        return new ObjectOutputStream(outputStream);
    }

    public CompatibleObjectEncoder(int i) {
        this.resetInterval = ObjectUtil.checkPositiveOrZero(i, "resetInterval");
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Serializable serializable, ByteBuf byteBuf) throws IOException {
        ObjectOutputStream objectOutputStreamNewObjectOutputStream = newObjectOutputStream(new ByteBufOutputStream(byteBuf));
        try {
            int i = this.resetInterval;
            if (i != 0) {
                int i2 = this.writtenObjects + 1;
                this.writtenObjects = i2;
                if (i2 % i == 0) {
                    objectOutputStreamNewObjectOutputStream.reset();
                }
            }
            objectOutputStreamNewObjectOutputStream.writeObject(serializable);
            objectOutputStreamNewObjectOutputStream.flush();
            objectOutputStreamNewObjectOutputStream.close();
        } catch (Throwable th) {
            objectOutputStreamNewObjectOutputStream.close();
            throw th;
        }
    }
}
