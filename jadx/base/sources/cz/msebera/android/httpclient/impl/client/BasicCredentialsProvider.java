package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.util.Args;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public class BasicCredentialsProvider implements CredentialsProvider {
    private final ConcurrentHashMap<AuthScope, Credentials> credMap = new ConcurrentHashMap<>();

    private static Credentials matchCredentials(Map<AuthScope, Credentials> map, AuthScope authScope) {
        Credentials credentials = map.get(authScope);
        if (credentials == null) {
            int i = -1;
            AuthScope authScope2 = null;
            for (AuthScope authScope3 : map.keySet()) {
                int iMatch = authScope.match(authScope3);
                if (iMatch > i) {
                    authScope2 = authScope3;
                    i = iMatch;
                }
            }
            if (authScope2 != null) {
                return map.get(authScope2);
            }
        }
        return credentials;
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public void clear() {
        this.credMap.clear();
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public Credentials getCredentials(AuthScope authScope) {
        Args.notNull(authScope, "Authentication scope");
        return matchCredentials(this.credMap, authScope);
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public void setCredentials(AuthScope authScope, Credentials credentials) {
        Args.notNull(authScope, "Authentication scope");
        this.credMap.put(authScope, credentials);
    }

    public String toString() {
        return this.credMap.toString();
    }
}
