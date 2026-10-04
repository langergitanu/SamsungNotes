package org.apache.http.impl.conn;

import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.conn.DnsResolver;
import org.apache.http.util.Args;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InMemoryDnsResolver implements DnsResolver {
    private static final String TAG = "HttpClient";
    private final Map<String, InetAddress[]> dnsMap = new ConcurrentHashMap();

    public void add(String str, InetAddress... inetAddressArr) {
        Args.notNull(str, "Host name");
        Args.notNull(inetAddressArr, "Array of IP addresses");
        this.dnsMap.put(str, inetAddressArr);
    }

    @Override // org.apache.http.conn.DnsResolver
    public InetAddress[] resolve(String str) throws UnknownHostException {
        InetAddress[] inetAddressArr = this.dnsMap.get(str);
        if (Log.isLoggable(TAG, 4)) {
            AbstractC11014a.m12338w(AbstractC0000a.m15l("Resolving ", str, " to "), Arrays.deepToString(inetAddressArr), TAG);
        }
        if (inetAddressArr != null) {
            return inetAddressArr;
        }
        throw new UnknownHostException(String.valueOf(str).concat(" cannot be resolved"));
    }
}
