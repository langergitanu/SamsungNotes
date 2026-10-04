package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SocksInitResponseDecoder extends ReplayingDecoder<State> {

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksInitResponseDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126391 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State */
        static final /* synthetic */ int[] f8920x7a2ae92e;

        static {
            int[] iArr = new int[State.values().length];
            f8920x7a2ae92e = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8920x7a2ae92e[State.READ_PREFERRED_AUTH_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_PREFERRED_AUTH_TYPE
    }

    public SocksInitResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i = C126391.f8920x7a2ae92e[state().ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new Error();
            }
        } else {
            if (byteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE);
                channelHandlerContext.pipeline().remove(this);
            }
            checkpoint(State.READ_PREFERRED_AUTH_TYPE);
        }
        list.add(new SocksInitResponse(SocksAuthScheme.valueOf(byteBuf.readByte())));
        channelHandlerContext.pipeline().remove(this);
    }
}
