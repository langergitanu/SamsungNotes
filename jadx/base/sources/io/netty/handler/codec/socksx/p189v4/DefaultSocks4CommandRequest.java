package io.netty.handler.codec.socksx.p189v4;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSocks4CommandRequest extends AbstractSocks4Message implements Socks4CommandRequest {
    private final String dstAddr;
    private final int dstPort;
    private final Socks4CommandType type;
    private final String userId;

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i) {
        this(socks4CommandType, str, i, "");
    }

    @Override // io.netty.handler.codec.socksx.p189v4.Socks4CommandRequest
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.p189v4.Socks4CommandRequest
    public int dstPort() {
        return this.dstPort;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(type: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", type: ");
        }
        sb.append(type());
        sb.append(", dstAddr: ");
        sb.append(dstAddr());
        sb.append(", dstPort: ");
        sb.append(dstPort());
        sb.append(", userId: ");
        sb.append(userId());
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }

    @Override // io.netty.handler.codec.socksx.p189v4.Socks4CommandRequest
    public Socks4CommandType type() {
        return this.type;
    }

    @Override // io.netty.handler.codec.socksx.p189v4.Socks4CommandRequest
    public String userId() {
        return this.userId;
    }

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i, String str2) {
        if (i <= 0 || i >= 65536) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "dstPort: ", " (expected: 1~65535)"));
        }
        this.type = (Socks4CommandType) ObjectUtil.checkNotNull(socks4CommandType, "type");
        this.dstAddr = IDN.toASCII((String) ObjectUtil.checkNotNull(str, "dstAddr"));
        this.userId = (String) ObjectUtil.checkNotNull(str2, SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID);
        this.dstPort = i;
    }
}
