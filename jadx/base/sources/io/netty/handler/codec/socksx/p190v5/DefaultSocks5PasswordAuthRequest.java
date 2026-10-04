package io.netty.handler.codec.socksx.p190v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSocks5PasswordAuthRequest extends AbstractSocks5Message implements Socks5PasswordAuthRequest {
    private final String password;
    private final String username;

    public DefaultSocks5PasswordAuthRequest(String str, String str2) {
        ObjectUtil.checkNotNull(str, "username");
        ObjectUtil.checkNotNull(str2, "password");
        if (str.length() > 255) {
            throw new IllegalArgumentException("username: **** (expected: less than 256 chars)");
        }
        if (str2.length() > 255) {
            throw new IllegalArgumentException("password: **** (expected: less than 256 chars)");
        }
        this.username = str;
        this.password = str2;
    }

    @Override // io.netty.handler.codec.socksx.p190v5.Socks5PasswordAuthRequest
    public String password() {
        return this.password;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(username: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", username: ");
        }
        sb.append(username());
        sb.append(", password: ****)");
        return sb.toString();
    }

    @Override // io.netty.handler.codec.socksx.p190v5.Socks5PasswordAuthRequest
    public String username() {
        return this.username;
    }
}
