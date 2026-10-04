package io.netty.handler.codec.socksx.p189v4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.NetUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks4ClientDecoder extends ReplayingDecoder<State> {

    /* JADX INFO: renamed from: io.netty.handler.codec.socksx.v4.Socks4ClientDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126411 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ClientDecoder$State */
        static final /* synthetic */ int[] f8924x6ab6e36e;

        static {
            int[] iArr = new int[State.values().length];
            f8924x6ab6e36e = iArr;
            try {
                iArr[State.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8924x6ab6e36e[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8924x6ab6e36e[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        START,
        SUCCESS,
        FAILURE
    }

    public Socks4ClientDecoder() {
        super(State.START);
        setSingleDecode(true);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        DefaultSocks4CommandResponse defaultSocks4CommandResponse = new DefaultSocks4CommandResponse(Socks4CommandStatus.REJECTED_OR_FAILED);
        defaultSocks4CommandResponse.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks4CommandResponse);
        checkpoint(State.FAILURE);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        try {
            int i = C126411.f8924x6ab6e36e[state().ordinal()];
            if (i == 1) {
                short unsignedByte = byteBuf.readUnsignedByte();
                if (unsignedByte != 0) {
                    throw new DecoderException("unsupported reply version: " + ((int) unsignedByte) + " (expected: 0)");
                }
                list.add(new DefaultSocks4CommandResponse(Socks4CommandStatus.valueOf(byteBuf.readByte()), NetUtil.intToIpAddress(byteBuf.readInt()), byteBuf.readUnsignedShort()));
                checkpoint(State.SUCCESS);
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                byteBuf.skipBytes(actualReadableBytes());
                return;
            }
            int iActualReadableBytes = actualReadableBytes();
            if (iActualReadableBytes > 0) {
                list.add(byteBuf.readRetainedSlice(iActualReadableBytes));
            }
        } catch (Exception e) {
            fail(list, e);
        }
    }
}
