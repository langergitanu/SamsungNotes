package io.netty.handler.codec.socksx.p189v4;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSocks4CommandResponse extends AbstractSocks4Message implements Socks4CommandResponse {
    private final String dstAddr;
    private final int dstPort;
    private final Socks4CommandStatus status;

    public DefaultSocks4CommandResponse(Socks4CommandStatus socks4CommandStatus) {
        this(socks4CommandStatus, null, 0);
    }

    @Override // io.netty.handler.codec.socksx.p189v4.Socks4CommandResponse
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.p189v4.Socks4CommandResponse
    public int dstPort() {
        return this.dstPort;
    }

    @Override // io.netty.handler.codec.socksx.p189v4.Socks4CommandResponse
    public Socks4CommandStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(96);
        sb.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(dstAddr: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", dstAddr: ");
        }
        sb.append(dstAddr());
        sb.append(", dstPort: ");
        sb.append(dstPort());
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }

    public DefaultSocks4CommandResponse(Socks4CommandStatus socks4CommandStatus, String str, int i) {
        if (str != null && !NetUtil.isValidIpV4Address(str)) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("dstAddr: ", str, " (expected: a valid IPv4 address)"));
        }
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "dstPort: ", " (expected: 0~65535)"));
        }
        this.status = (Socks4CommandStatus) ObjectUtil.checkNotNull(socks4CommandStatus, "cmdStatus");
        this.dstAddr = str;
        this.dstPort = i;
    }
}
