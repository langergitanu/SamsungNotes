package io.netty.handler.codec.socks;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class SocksAuthRequest extends SocksRequest {
    private static final SocksSubnegotiationVersion SUBNEGOTIATION_VERSION = SocksSubnegotiationVersion.AUTH_PASSWORD;
    private final String password;
    private final String username;

    public SocksAuthRequest(String str, String str2) {
        super(SocksRequestType.AUTH);
        ObjectUtil.checkNotNull(str, "username");
        ObjectUtil.checkNotNull(str2, "password");
        CharsetEncoder charsetEncoderEncoder = CharsetUtil.encoder(CharsetUtil.US_ASCII);
        if (!charsetEncoderEncoder.canEncode(str) || !charsetEncoderEncoder.canEncode(str2)) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("username: ", str, " or password: **** values should be in pure ascii"));
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("username: ", str, " exceeds 255 char limit"));
        }
        if (str2.length() > 255) {
            throw new IllegalArgumentException("password: **** exceeds 255 char limit");
        }
        this.username = str;
        this.password = str2;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(SUBNEGOTIATION_VERSION.byteValue());
        byteBuf.writeByte(this.username.length());
        String str = this.username;
        Charset charset = CharsetUtil.US_ASCII;
        byteBuf.writeCharSequence(str, charset);
        byteBuf.writeByte(this.password.length());
        byteBuf.writeCharSequence(this.password, charset);
    }

    public String password() {
        return this.password;
    }

    public String username() {
        return this.username;
    }
}
