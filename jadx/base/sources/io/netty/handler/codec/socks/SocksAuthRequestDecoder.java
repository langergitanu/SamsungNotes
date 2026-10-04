package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SocksAuthRequestDecoder extends ReplayingDecoder<State> {
    private String username;

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksAuthRequestDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126321 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socks$SocksAuthRequestDecoder$State */
        static final /* synthetic */ int[] f8911xb63b32bc;

        static {
            int[] iArr = new int[State.values().length];
            f8911xb63b32bc = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8911xb63b32bc[State.READ_USERNAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8911xb63b32bc[State.READ_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_USERNAME,
        READ_PASSWORD
    }

    public SocksAuthRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i = C126321.f8911xb63b32bc[state().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new Error();
                }
            }
            list.add(new SocksAuthRequest(this.username, SocksCommonUtils.readUsAscii(byteBuf, byteBuf.readByte())));
            channelHandlerContext.pipeline().remove(this);
        }
        if (byteBuf.readByte() != SocksSubnegotiationVersion.AUTH_PASSWORD.byteValue()) {
            list.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
            channelHandlerContext.pipeline().remove(this);
        }
        checkpoint(State.READ_USERNAME);
        this.username = SocksCommonUtils.readUsAscii(byteBuf, byteBuf.readByte());
        checkpoint(State.READ_PASSWORD);
        list.add(new SocksAuthRequest(this.username, SocksCommonUtils.readUsAscii(byteBuf, byteBuf.readByte())));
        channelHandlerContext.pipeline().remove(this);
    }
}
