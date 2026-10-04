package io.netty.handler.codec.socksx.p190v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks5InitialResponseDecoder extends ReplayingDecoder<State> {

    /* JADX INFO: renamed from: io.netty.handler.codec.socksx.v5.Socks5InitialResponseDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126481 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5InitialResponseDecoder$State */
        static final /* synthetic */ int[] f8929xb3476ce4;

        static {
            int[] iArr = new int[State.values().length];
            f8929xb3476ce4 = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8929xb3476ce4[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8929xb3476ce4[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        INIT,
        SUCCESS,
        FAILURE
    }

    public Socks5InitialResponseDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5InitialResponse defaultSocks5InitialResponse = new DefaultSocks5InitialResponse(Socks5AuthMethod.UNACCEPTED);
        defaultSocks5InitialResponse.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks5InitialResponse);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        try {
            int i = C126481.f8929xb3476ce4[state().ordinal()];
            if (i == 1) {
                byte b = byteBuf.readByte();
                SocksVersion socksVersion = SocksVersion.SOCKS5;
                if (b != socksVersion.byteValue()) {
                    throw new DecoderException("unsupported version: " + ((int) b) + " (expected: " + ((int) socksVersion.byteValue()) + PropertyUtils.MAPPED_DELIM2);
                }
                list.add(new DefaultSocks5InitialResponse(Socks5AuthMethod.valueOf(byteBuf.readByte())));
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
