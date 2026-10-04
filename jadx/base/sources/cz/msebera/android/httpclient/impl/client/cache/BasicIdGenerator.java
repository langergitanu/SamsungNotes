package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Locale;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE)
class BasicIdGenerator {
    private long count;
    private final String hostname;
    private final SecureRandom rnd;

    public BasicIdGenerator() {
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException unused) {
            hostName = StringLookupFactory.KEY_LOCALHOST;
        }
        this.hostname = hostName;
        try {
            this.rnd = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new Error(e);
        }
    }

    public synchronized void generate(StringBuilder sb) {
        this.count++;
        int iNextInt = this.rnd.nextInt();
        sb.append(System.currentTimeMillis());
        sb.append('.');
        Formatter formatter = new Formatter(sb, Locale.US);
        formatter.format("%1$016x-%2$08x", Long.valueOf(this.count), Integer.valueOf(iNextInt));
        formatter.close();
        sb.append('.');
        sb.append(this.hostname);
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();
        generate(sb);
        return sb.toString();
    }
}
