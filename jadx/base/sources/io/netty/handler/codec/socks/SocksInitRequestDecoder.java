package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SocksInitRequestDecoder extends ReplayingDecoder<State> {

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksInitRequestDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126381 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State */
        static final /* synthetic */ int[] f8919x5e58f624;

        static {
            int[] iArr = new int[State.values().length];
            f8919x5e58f624 = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8919x5e58f624[State.READ_AUTH_SCHEMES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_AUTH_SCHEMES
    }

    public SocksInitRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        ?? arrayList;
        int i = C126381.f8919x5e58f624[state().ordinal()];
        if (i == 1) {
            if (byteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
                channelHandlerContext.pipeline().remove(this);
            }
            checkpoint(State.READ_AUTH_SCHEMES);
        } else if (i != 2) {
            throw new Error();
        }
        byte b = byteBuf.readByte();
        if (b > 0) {
            arrayList = new ArrayList(b);
            for (int i2 = 0; i2 < b; i2++) {
                arrayList.add(SocksAuthScheme.valueOf(byteBuf.readByte()));
            }
        } else {
            arrayList = Collections.EMPTY_LIST;
        }
        list.add(new SocksInitRequest(arrayList));
        channelHandlerContext.pipeline().remove(this);
    }
}
