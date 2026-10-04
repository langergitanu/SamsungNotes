package com.google.android.gms.internal.meet_coactivities;

import com.microsoft.identity.common.java.AuthenticationConstants;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzalz {
    public static final PasswordAuthentication zza(String str, InetAddress inetAddress, int i, String str2, String str3, String str4) {
        URL url;
        try {
            url = new URL(AuthenticationConstants.HTTPS_PROTOCOL_STRING, str, i, "");
        } catch (MalformedURLException unused) {
            zzamb.zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl$1", "requestPasswordAuthentication", "failed to create URL for Authenticator: {0} {1}", new Object[]{AuthenticationConstants.HTTPS_PROTOCOL_STRING, str});
            url = null;
        }
        return Authenticator.requestPasswordAuthentication(str, inetAddress, i, AuthenticationConstants.HTTPS_PROTOCOL_STRING, "", null, url, Authenticator.RequestorType.PROXY);
    }
}
