package cz.msebera.android.httpclient.impl.conn;

import androidx.appcompat.widget.AbstractC0541b;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InMemoryDnsResolver implements DnsResolver {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(InMemoryDnsResolver.class);
    private final Map<String, InetAddress[]> dnsMap = new ConcurrentHashMap();

    public void add(String str, InetAddress... inetAddressArr) {
        Args.notNull(str, "Host name");
        Args.notNull(inetAddressArr, "Array of IP addresses");
        this.dnsMap.put(str, inetAddressArr);
    }

    @Override // cz.msebera.android.httpclient.conn.DnsResolver
    public InetAddress[] resolve(String str) throws UnknownHostException {
        InetAddress[] inetAddressArr = this.dnsMap.get(str);
        if (this.log.isInfoEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            StringBuilder sbM15l = AbstractC0000a.m15l("Resolving ", str, " to ");
            sbM15l.append(Arrays.deepToString(inetAddressArr));
            httpClientAndroidLog.info(sbM15l.toString());
        }
        if (inetAddressArr != null) {
            return inetAddressArr;
        }
        throw new UnknownHostException(AbstractC0541b.m756B(str, " cannot be resolved"));
    }
}
