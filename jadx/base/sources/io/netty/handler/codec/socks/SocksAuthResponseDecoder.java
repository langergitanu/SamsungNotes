package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SocksAuthResponseDecoder extends ReplayingDecoder<State> {

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksAuthResponseDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126331 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State */
        static final /* synthetic */ int[] f8912x1e903f96;

        static {
            int[] iArr = new int[State.values().length];
            f8912x1e903f96 = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8912x1e903f96[State.READ_AUTH_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_AUTH_RESPONSE
    }

    public SocksAuthResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i = C126331.f8912x1e903f96[state().ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new Error();
            }
        } else {
            if (byteBuf.readByte() != SocksSubnegotiationVersion.AUTH_PASSWORD.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE);
                channelHandlerContext.pipeline().remove(this);
            }
            checkpoint(State.READ_AUTH_RESPONSE);
        }
        list.add(new SocksAuthResponse(SocksAuthStatus.valueOf(byteBuf.readByte())));
        channelHandlerContext.pipeline().remove(this);
    }
}
