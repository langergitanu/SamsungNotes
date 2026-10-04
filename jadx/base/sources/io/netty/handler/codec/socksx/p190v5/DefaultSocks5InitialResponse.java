package io.netty.handler.codec.socksx.p190v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSocks5InitialResponse extends AbstractSocks5Message implements Socks5InitialResponse {
    private final Socks5AuthMethod authMethod;

    public DefaultSocks5InitialResponse(Socks5AuthMethod socks5AuthMethod) {
        this.authMethod = (Socks5AuthMethod) ObjectUtil.checkNotNull(socks5AuthMethod, "authMethod");
    }

    @Override // io.netty.handler.codec.socksx.p190v5.Socks5InitialResponse
    public Socks5AuthMethod authMethod() {
        return this.authMethod;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(authMethod: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", authMethod: ");
        }
        sb.append(authMethod());
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}
