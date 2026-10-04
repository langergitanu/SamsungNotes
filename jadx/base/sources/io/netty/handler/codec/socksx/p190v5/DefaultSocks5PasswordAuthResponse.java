package io.netty.handler.codec.socksx.p190v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSocks5PasswordAuthResponse extends AbstractSocks5Message implements Socks5PasswordAuthResponse {
    private final Socks5PasswordAuthStatus status;

    public DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus socks5PasswordAuthStatus) {
        this.status = (Socks5PasswordAuthStatus) ObjectUtil.checkNotNull(socks5PasswordAuthStatus, "status");
    }

    @Override // io.netty.handler.codec.socksx.p190v5.Socks5PasswordAuthResponse
    public Socks5PasswordAuthStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(status: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", status: ");
        }
        sb.append(status());
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}
