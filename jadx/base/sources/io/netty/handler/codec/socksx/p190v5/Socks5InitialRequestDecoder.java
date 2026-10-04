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
public class Socks5InitialRequestDecoder extends ReplayingDecoder<State> {

    /* JADX INFO: renamed from: io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126471 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socksx$v5$Socks5InitialRequestDecoder$State */
        static final /* synthetic */ int[] f8928x266223ae;

        static {
            int[] iArr = new int[State.values().length];
            f8928x266223ae = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8928x266223ae[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8928x266223ae[State.FAILURE.ordinal()] = 3;
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

    public Socks5InitialRequestDecoder() {
        super(State.INIT);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        checkpoint(State.FAILURE);
        DefaultSocks5InitialRequest defaultSocks5InitialRequest = new DefaultSocks5InitialRequest(Socks5AuthMethod.NO_AUTH);
        defaultSocks5InitialRequest.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks5InitialRequest);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        try {
            int i = C126471.f8928x266223ae[state().ordinal()];
            if (i == 1) {
                byte b = byteBuf.readByte();
                SocksVersion socksVersion = SocksVersion.SOCKS5;
                if (b != socksVersion.byteValue()) {
                    throw new DecoderException("unsupported version: " + ((int) b) + " (expected: " + ((int) socksVersion.byteValue()) + PropertyUtils.MAPPED_DELIM2);
                }
                int unsignedByte = byteBuf.readUnsignedByte();
                Socks5AuthMethod[] socks5AuthMethodArr = new Socks5AuthMethod[unsignedByte];
                for (int i2 = 0; i2 < unsignedByte; i2++) {
                    socks5AuthMethodArr[i2] = Socks5AuthMethod.valueOf(byteBuf.readByte());
                }
                list.add(new DefaultSocks5InitialRequest(socks5AuthMethodArr));
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
