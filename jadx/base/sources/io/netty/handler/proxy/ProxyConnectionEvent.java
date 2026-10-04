package io.netty.handler.proxy;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ProxyConnectionEvent {
    private final String authScheme;
    private final SocketAddress destinationAddress;
    private final String protocol;
    private final SocketAddress proxyAddress;
    private String strVal;

    public ProxyConnectionEvent(String str, String str2, SocketAddress socketAddress, SocketAddress socketAddress2) {
        this.protocol = (String) ObjectUtil.checkNotNull(str, "protocol");
        this.authScheme = (String) ObjectUtil.checkNotNull(str2, "authScheme");
        this.proxyAddress = (SocketAddress) ObjectUtil.checkNotNull(socketAddress, "proxyAddress");
        this.destinationAddress = (SocketAddress) ObjectUtil.checkNotNull(socketAddress2, "destinationAddress");
    }

    public String authScheme() {
        return this.authScheme;
    }

    public <T extends SocketAddress> T destinationAddress() {
        return (T) this.destinationAddress;
    }

    public String protocol() {
        return this.protocol;
    }

    public <T extends SocketAddress> T proxyAddress() {
        return (T) this.proxyAddress;
    }

    public String toString() {
        String str = this.strVal;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(StringUtil.simpleClassName(this));
        sb.append(PropertyUtils.MAPPED_DELIM);
        sb.append(this.protocol);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.authScheme);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.proxyAddress);
        sb.append(" => ");
        sb.append(this.destinationAddress);
        sb.append(PropertyUtils.MAPPED_DELIM2);
        String string = sb.toString();
        this.strVal = string;
        return string;
    }
}
