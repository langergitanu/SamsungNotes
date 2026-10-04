package io.grpc.netty;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class JettyTlsUtil {
    private static Throwable jettyAlpnUnavailabilityCause;
    private static Throwable jettyNpnUnavailabilityCause;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Java9AlpnUnavailabilityCauseHolder {
        static final Throwable cause = checkAlpnAvailability();

        private Java9AlpnUnavailabilityCauseHolder() {
        }

        public static Throwable checkAlpnAvailability() {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                ((Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.grpc.netty.JettyTlsUtil.Java9AlpnUnavailabilityCauseHolder.1
                    @Override // java.security.PrivilegedExceptionAction
                    public Method run() {
                        return SSLEngine.class.getMethod("getApplicationProtocol", null);
                    }
                })).invoke(sSLContext.createSSLEngine(), null);
                return null;
            } catch (Throwable th) {
                return th;
            }
        }
    }

    private JettyTlsUtil() {
    }

    public static Throwable getJava9AlpnUnavailabilityCause() {
        return Java9AlpnUnavailabilityCauseHolder.cause;
    }

    public static synchronized Throwable getJettyAlpnUnavailabilityCause() {
        try {
            if (jettyAlpnUnavailabilityCause == null) {
                isJettyAlpnConfigured();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jettyAlpnUnavailabilityCause;
    }

    public static synchronized Throwable getJettyNpnUnavailabilityCause() {
        try {
            if (jettyNpnUnavailabilityCause == null) {
                isJettyNpnConfigured();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jettyNpnUnavailabilityCause;
    }

    public static boolean isJava9AlpnAvailable() {
        return getJava9AlpnUnavailabilityCause() == null;
    }

    public static synchronized boolean isJettyAlpnConfigured() {
        try {
            Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
        } catch (ClassNotFoundException e) {
            jettyAlpnUnavailabilityCause = e;
            return false;
        }
        return true;
    }

    public static synchronized boolean isJettyNpnConfigured() {
        try {
            Class.forName("org.eclipse.jetty.npn.NextProtoNego", true, null);
        } catch (ClassNotFoundException e) {
            jettyNpnUnavailabilityCause = e;
            return false;
        }
        return true;
    }
}
