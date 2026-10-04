package io.netty.handler.codec.socksx.p189v4;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Socks4ServerDecoder extends ReplayingDecoder<State> {
    private static final int MAX_FIELD_LENGTH = 255;
    private String dstAddr;
    private int dstPort;
    private Socks4CommandType type;
    private String userId;

    /* JADX INFO: renamed from: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126421 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State */
        static final /* synthetic */ int[] f8925xc9960af6;

        static {
            int[] iArr = new int[State.values().length];
            f8925xc9960af6 = iArr;
            try {
                iArr[State.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8925xc9960af6[State.READ_USERID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8925xc9960af6[State.READ_DOMAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8925xc9960af6[State.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8925xc9960af6[State.FAILURE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        START,
        READ_USERID,
        READ_DOMAIN,
        SUCCESS,
        FAILURE
    }

    public Socks4ServerDecoder() {
        super(State.START);
        setSingleDecode(true);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        Socks4CommandType socks4CommandType = this.type;
        if (socks4CommandType == null) {
            socks4CommandType = Socks4CommandType.CONNECT;
        }
        String str = this.dstAddr;
        if (str == null) {
            str = "";
        }
        int i = this.dstPort;
        if (i == 0) {
            i = 65535;
        }
        String str2 = this.userId;
        DefaultSocks4CommandRequest defaultSocks4CommandRequest = new DefaultSocks4CommandRequest(socks4CommandType, str, i, str2 != null ? str2 : "");
        defaultSocks4CommandRequest.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks4CommandRequest);
        checkpoint(State.FAILURE);
    }

    private static String readString(String str, ByteBuf byteBuf) {
        int iBytesBefore = byteBuf.bytesBefore(256, (byte) 0);
        if (iBytesBefore < 0) {
            throw new DecoderException(AbstractC0541b.m773o("field '", str, "' longer than 255 chars"));
        }
        String string = byteBuf.readSlice(iBytesBefore).toString(CharsetUtil.US_ASCII);
        byteBuf.skipBytes(1);
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009d A[Catch: Exception -> 0x002a, TryCatch #0 {Exception -> 0x002a, blocks: (B:3:0x0003, B:14:0x0022, B:28:0x0097, B:30:0x009d, B:22:0x0066, B:24:0x0070, B:26:0x007a, B:27:0x0082, B:21:0x0058, B:18:0x002d, B:20:0x0039, B:32:0x00a5, B:33:0x00b6), top: B:36:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int iActualReadableBytes;
        try {
            int i = C126421.f8925xc9960af6[state().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return;
                            }
                            byteBuf.skipBytes(actualReadableBytes());
                            return;
                        }
                    }
                    iActualReadableBytes = actualReadableBytes();
                    if (iActualReadableBytes > 0) {
                        list.add(byteBuf.readRetainedSlice(iActualReadableBytes));
                        return;
                    }
                    return;
                }
                if (!"0.0.0.0".equals(this.dstAddr) && this.dstAddr.startsWith("0.0.0.")) {
                    this.dstAddr = readString("dstAddr", byteBuf);
                }
                list.add(new DefaultSocks4CommandRequest(this.type, this.dstAddr, this.dstPort, this.userId));
                checkpoint(State.SUCCESS);
                iActualReadableBytes = actualReadableBytes();
                if (iActualReadableBytes > 0) {
                }
            } else {
                short unsignedByte = byteBuf.readUnsignedByte();
                if (unsignedByte != SocksVersion.SOCKS4a.byteValue()) {
                    throw new DecoderException("unsupported protocol version: " + ((int) unsignedByte));
                }
                this.type = Socks4CommandType.valueOf(byteBuf.readByte());
                this.dstPort = byteBuf.readUnsignedShort();
                this.dstAddr = NetUtil.intToIpAddress(byteBuf.readInt());
                checkpoint(State.READ_USERID);
            }
            this.userId = readString("userid", byteBuf);
            checkpoint(State.READ_DOMAIN);
            if (!"0.0.0.0".equals(this.dstAddr)) {
                this.dstAddr = readString("dstAddr", byteBuf);
            }
            list.add(new DefaultSocks4CommandRequest(this.type, this.dstAddr, this.dstPort, this.userId));
            checkpoint(State.SUCCESS);
            iActualReadableBytes = actualReadableBytes();
            if (iActualReadableBytes > 0) {
            }
        } catch (Exception e) {
            fail(list, e);
        }
    }
}
