package io.netty.handler.codec.socksx.p190v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks5PasswordAuthRequestDecoder extends ReplayingDecoder<State> {

    /* JADX INFO: renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequestDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126491 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5PasswordAuthRequestDecoder$State */
        static final /* synthetic */ int[] f8930xa51101bd;

        static {
            int[] iArr = new int[State.values().length];
            f8930xa51101bd = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8930xa51101bd[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8930xa51101bd[State.FAILURE.ordinal()] = 3;
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

    public Socks5PasswordAuthRequestDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5PasswordAuthRequest defaultSocks5PasswordAuthRequest = new DefaultSocks5PasswordAuthRequest("", "");
        defaultSocks5PasswordAuthRequest.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks5PasswordAuthRequest);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        try {
            int i = C126491.f8930xa51101bd[state().ordinal()];
            if (i == 1) {
                int i2 = byteBuf.readerIndex();
                byte b = byteBuf.getByte(i2);
                if (b != 1) {
                    throw new DecoderException("unsupported subnegotiation version: " + ((int) b) + " (expected: 1)");
                }
                short unsignedByte = byteBuf.getUnsignedByte(i2 + 1);
                int i4 = i2 + 2;
                short unsignedByte2 = byteBuf.getUnsignedByte(i4 + unsignedByte);
                byteBuf.skipBytes(unsignedByte + unsignedByte2 + 3);
                Charset charset = CharsetUtil.US_ASCII;
                list.add(new DefaultSocks5PasswordAuthRequest(byteBuf.toString(i4, unsignedByte, charset), byteBuf.toString(i2 + 3 + unsignedByte, unsignedByte2, charset)));
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
