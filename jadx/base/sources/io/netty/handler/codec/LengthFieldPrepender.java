package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class LengthFieldPrepender extends MessageToMessageEncoder<ByteBuf> {
    private final ByteOrder byteOrder;
    private final int lengthAdjustment;
    private final int lengthFieldLength;
    private final boolean lengthIncludesLengthFieldLength;

    public LengthFieldPrepender(int i) {
        this(i, false);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) {
        encode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public LengthFieldPrepender(int i, boolean z) {
        this(i, 0, z);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i = byteBuf.readableBytes() + this.lengthAdjustment;
        if (this.lengthIncludesLengthFieldLength) {
            i += this.lengthFieldLength;
        }
        ObjectUtil.checkPositiveOrZero(i, "length");
        int i2 = this.lengthFieldLength;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        list.add(channelHandlerContext.alloc().buffer(4).order(this.byteOrder).writeInt(i));
                    } else {
                        if (i2 != 8) {
                            throw new Error("should not reach here");
                        }
                        list.add(channelHandlerContext.alloc().buffer(8).order(this.byteOrder).writeLong(i));
                    }
                } else {
                    if (i >= 16777216) {
                        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "length does not fit into a medium integer: "));
                    }
                    list.add(channelHandlerContext.alloc().buffer(3).order(this.byteOrder).writeMedium(i));
                }
            } else {
                if (i >= 65536) {
                    throw new IllegalArgumentException(AbstractC0000a.m11h(i, "length does not fit into a short integer: "));
                }
                list.add(channelHandlerContext.alloc().buffer(2).order(this.byteOrder).writeShort((short) i));
            }
        } else {
            if (i >= 256) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(i, "length does not fit into a byte: "));
            }
            list.add(channelHandlerContext.alloc().buffer(1).order(this.byteOrder).writeByte((byte) i));
        }
        list.add(byteBuf.retain());
    }

    public LengthFieldPrepender(int i, int i2) {
        this(i, i2, false);
    }

    public LengthFieldPrepender(int i, int i2, boolean z) {
        this(ByteOrder.BIG_ENDIAN, i, i2, z);
    }

    public LengthFieldPrepender(ByteOrder byteOrder, int i, int i2, boolean z) {
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 8) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "lengthFieldLength must be either 1, 2, 3, 4, or 8: "));
        }
        this.byteOrder = (ByteOrder) ObjectUtil.checkNotNull(byteOrder, "byteOrder");
        this.lengthFieldLength = i;
        this.lengthIncludesLengthFieldLength = z;
        this.lengthAdjustment = i2;
    }
}
