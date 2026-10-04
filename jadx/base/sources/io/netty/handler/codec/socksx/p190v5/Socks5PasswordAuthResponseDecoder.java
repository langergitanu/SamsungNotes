package io.netty.handler.codec.socksx.p190v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks5PasswordAuthResponseDecoder extends ReplayingDecoder<State> {

    /* JADX INFO: renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponseDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126501 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthResponseDecoder$State */
        static final /* synthetic */ int[] f8931xa7450b5;

        static {
            int[] iArr = new int[State.values().length];
            f8931xa7450b5 = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8931xa7450b5[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8931xa7450b5[State.FAILURE.ordinal()] = 3;
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

    public Socks5PasswordAuthResponseDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5PasswordAuthResponse defaultSocks5PasswordAuthResponse = new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.FAILURE);
        defaultSocks5PasswordAuthResponse.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks5PasswordAuthResponse);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        try {
            int i = C126501.f8931xa7450b5[state().ordinal()];
            if (i == 1) {
                byte b = byteBuf.readByte();
                if (b != 1) {
                    throw new DecoderException("unsupported subnegotiation version: " + ((int) b) + " (expected: 1)");
                }
                list.add(new DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus.valueOf(byteBuf.readByte())));
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
