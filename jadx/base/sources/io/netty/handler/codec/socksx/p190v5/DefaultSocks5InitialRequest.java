package io.netty.handler.codec.socksx.p190v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSocks5InitialRequest extends AbstractSocks5Message implements Socks5InitialRequest {
    private final List<Socks5AuthMethod> authMethods;

    public DefaultSocks5InitialRequest(Socks5AuthMethod... socks5AuthMethodArr) {
        ObjectUtil.checkNotNull(socks5AuthMethodArr, "authMethods");
        ArrayList arrayList = new ArrayList(socks5AuthMethodArr.length);
        for (Socks5AuthMethod socks5AuthMethod : socks5AuthMethodArr) {
            if (socks5AuthMethod == null) {
                break;
            }
            arrayList.add(socks5AuthMethod);
        }
        this.authMethods = Collections.unmodifiableList((List) ObjectUtil.checkNonEmpty(arrayList, XmlErrorCodes.LIST));
    }

    @Override // io.netty.handler.codec.socksx.p190v5.Socks5InitialRequest
    public List<Socks5AuthMethod> authMethods() {
        return this.authMethods;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(authMethods: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", authMethods: ");
        }
        sb.append(authMethods());
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }

    public DefaultSocks5InitialRequest(Iterable<Socks5AuthMethod> iterable) {
        Socks5AuthMethod next;
        ObjectUtil.checkNotNull(iterable, "authSchemes");
        ArrayList arrayList = new ArrayList();
        Iterator<Socks5AuthMethod> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next);
        }
        this.authMethods = Collections.unmodifiableList((List) ObjectUtil.checkNonEmpty(arrayList, XmlErrorCodes.LIST));
    }
}
