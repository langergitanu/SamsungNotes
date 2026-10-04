package org.apache.http.impl.client;

import com.microsoft.identity.common.java.AuthenticationConstants;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.SystemProperties;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@ThreadSafe
public class SystemDefaultCredentialsProvider implements CredentialsProvider {
    private static final Map<String, String> SCHEME_MAP;
    private final BasicCredentialsProviderHC4 internal = new BasicCredentialsProviderHC4();

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        SCHEME_MAP = concurrentHashMap;
        Locale locale = Locale.ENGLISH;
        concurrentHashMap.put("Basic".toUpperCase(locale), "Basic");
        concurrentHashMap.put("Digest".toUpperCase(locale), "Digest");
        concurrentHashMap.put("NTLM".toUpperCase(locale), "NTLM");
        concurrentHashMap.put(AuthSchemes.SPNEGO.toUpperCase(locale), "SPNEGO");
        concurrentHashMap.put("Kerberos".toUpperCase(locale), "Kerberos");
    }

    private static PasswordAuthentication getSystemCreds(AuthScope authScope, Authenticator.RequestorType requestorType) {
        String host = authScope.getHost();
        int port = authScope.getPort();
        return Authenticator.requestPasswordAuthentication(host, null, port, port == 443 ? AuthenticationConstants.HTTPS_PROTOCOL_STRING : "http", null, translateScheme(authScope.getScheme()), null, requestorType);
    }

    private static String translateScheme(String str) {
        if (str == null) {
            return null;
        }
        String str2 = SCHEME_MAP.get(str);
        return str2 != null ? str2 : str;
    }

    @Override // org.apache.http.client.CredentialsProvider
    public void clear() {
        this.internal.clear();
    }

    @Override // org.apache.http.client.CredentialsProvider
    public Credentials getCredentials(AuthScope authScope) {
        Args.notNull(authScope, "Auth scope");
        Credentials credentials = this.internal.getCredentials(authScope);
        if (credentials != null) {
            return credentials;
        }
        if (authScope.getHost() != null) {
            PasswordAuthentication systemCreds = getSystemCreds(authScope, Authenticator.RequestorType.SERVER);
            if (systemCreds == null) {
                systemCreds = getSystemCreds(authScope, Authenticator.RequestorType.PROXY);
            }
            if (systemCreds != null) {
                String property = System.getProperty(SystemProperties.HTTP_AUTH_NTLM_DOMAIN);
                return property != null ? new NTCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()), null, property) : "NTLM".equalsIgnoreCase(authScope.getScheme()) ? new NTCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()), null, null) : new UsernamePasswordCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()));
            }
        }
        return null;
    }

    @Override // org.apache.http.client.CredentialsProvider
    public void setCredentials(AuthScope authScope, Credentials credentials) {
        this.internal.setCredentials(authScope, credentials);
    }
}
