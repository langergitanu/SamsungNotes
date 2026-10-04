package io.netty.handler.ssl;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class Java8SslUtils {
    private Java8SslUtils() {
    }

    public static boolean checkSniHostnameMatch(Collection<?> collection, byte[] bArr) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        SNIHostName sNIHostName = new SNIHostName(bArr);
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            SNIMatcher sNIMatcher = (SNIMatcher) it.next();
            if (sNIMatcher.getType() == 0 && sNIMatcher.matches(sNIHostName)) {
                return true;
            }
        }
        return false;
    }

    public static List getSniHostName(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? Collections.EMPTY_LIST : Collections.singletonList(new SNIHostName(bArr));
    }

    public static List<String> getSniHostNames(SSLParameters sSLParameters) {
        List<SNIServerName> serverNames = sSLParameters.getServerNames();
        if (serverNames == null || serverNames.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(serverNames.size());
        for (SNIServerName sNIServerName : serverNames) {
            if (!(sNIServerName instanceof SNIHostName)) {
                throw new IllegalArgumentException("Only " + SNIHostName.class.getName() + " instances are supported, but found: " + sNIServerName);
            }
            arrayList.add(((SNIHostName) sNIServerName).getAsciiName());
        }
        return arrayList;
    }

    public static boolean getUseCipherSuitesOrder(SSLParameters sSLParameters) {
        return sSLParameters.getUseCipherSuitesOrder();
    }

    public static boolean isValidHostNameForSNI(String str) {
        try {
            new SNIHostName(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static void setSNIMatchers(SSLParameters sSLParameters, Collection<?> collection) {
        sSLParameters.setSNIMatchers(collection);
    }

    public static void setSniHostNames(SSLParameters sSLParameters, List<String> list) {
        sSLParameters.setServerNames(getSniHostNames(list));
    }

    public static void setUseCipherSuitesOrder(SSLParameters sSLParameters, boolean z) {
        sSLParameters.setUseCipherSuitesOrder(z);
    }

    public static List getSniHostNames(List<String> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new SNIHostName(it.next().getBytes(CharsetUtil.UTF_8)));
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }
}
