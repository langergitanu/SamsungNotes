package org.apache.http.impl.conn;

import android.util.Log;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
class HttpClientConnectionOperator {
    static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
    private static final String TAG = "HttpClient";
    private final DnsResolver dnsResolver;
    private final SchemePortResolver schemePortResolver;
    private final Lookup<ConnectionSocketFactory> socketFactoryRegistry;

    public HttpClientConnectionOperator(Lookup<ConnectionSocketFactory> lookup, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        Args.notNull(lookup, "Socket factory registry");
        this.socketFactoryRegistry = lookup;
        this.schemePortResolver = schemePortResolver == null ? DefaultSchemePortResolver.INSTANCE : schemePortResolver;
        this.dnsResolver = dnsResolver == null ? SystemDefaultDnsResolver.INSTANCE : dnsResolver;
    }

    private static String getConnectTimeoutMessage(IOException iOException, HttpHost httpHost, InetAddress... inetAddressArr) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("Connect to ");
        sb.append(httpHost != null ? httpHost.toHostString() : "remote host");
        if (inetAddressArr == null || inetAddressArr.length <= 0) {
            str = "";
        } else {
            str = " " + Arrays.asList(inetAddressArr);
        }
        sb.append(str);
        if (iOException == null || iOException.getMessage() == null) {
            str2 = " timed out";
        } else {
            str2 = " failed: " + iOException.getMessage();
        }
        sb.append(str2);
        return sb.toString();
    }

    private Lookup<ConnectionSocketFactory> getSocketFactoryRegistry(HttpContext httpContext) {
        Lookup<ConnectionSocketFactory> lookup = (Lookup) httpContext.getAttribute("http.socket-factory-registry");
        return lookup == null ? this.socketFactoryRegistry : lookup;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void connect(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, InetSocketAddress inetSocketAddress, int i, SocketConfig socketConfig, HttpContext httpContext) throws SocketException, ConnectTimeoutException, UnsupportedSchemeException {
        boolean z;
        boolean z2;
        HttpContext httpContext2 = httpContext;
        ConnectionSocketFactory connectionSocketFactoryLookup = getSocketFactoryRegistry(httpContext2).lookup(httpHost.getSchemeName());
        if (connectionSocketFactoryLookup == null) {
            throw new UnsupportedSchemeException(String.valueOf(httpHost.getSchemeName()).concat(" protocol is not supported"));
        }
        InetAddress[] inetAddressArrResolve = this.dnsResolver.resolve(httpHost.getHostName());
        int iResolve = this.schemePortResolver.resolve(httpHost);
        int i2 = 0;
        while (i2 < inetAddressArrResolve.length) {
            InetAddress inetAddress = inetAddressArrResolve[i2];
            if (i2 == inetAddressArrResolve.length - 1) {
                z = true;
                z2 = true;
            } else {
                z = true;
                z2 = false;
            }
            Socket socketCreateSocket = connectionSocketFactoryLookup.createSocket(httpContext2);
            socketCreateSocket.setSoTimeout(socketConfig.getSoTimeout());
            socketCreateSocket.setReuseAddress(socketConfig.isSoReuseAddress());
            socketCreateSocket.setTcpNoDelay(socketConfig.isTcpNoDelay());
            socketCreateSocket.setKeepAlive(socketConfig.isSoKeepAlive());
            int soLinger = socketConfig.getSoLinger();
            if (soLinger >= 0) {
                if (soLinger <= 0) {
                    z = false;
                }
                socketCreateSocket.setSoLinger(z, soLinger);
            }
            managedHttpClientConnection.bind(socketCreateSocket);
            InetSocketAddress inetSocketAddress2 = new InetSocketAddress(inetAddress, iResolve);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Connecting to " + inetSocketAddress2);
            }
            try {
                managedHttpClientConnection.bind(connectionSocketFactoryLookup.connectSocket(i, socketCreateSocket, httpHost, inetSocketAddress2, inetSocketAddress, httpContext2));
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Connection established " + managedHttpClientConnection);
                    return;
                }
                return;
            } catch (ConnectException e) {
                if (z2) {
                    if (!"Connection timed out".equals(e.getMessage())) {
                        throw new HttpHostConnectException(httpHost, e);
                    }
                    ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException(getConnectTimeoutMessage(e, httpHost, inetAddressArrResolve));
                    connectTimeoutException.initCause(e);
                    throw connectTimeoutException;
                }
                if (!Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Connect to " + inetSocketAddress2 + " timed out. Connection will be retried using another IP address");
                }
                i2++;
                httpContext2 = httpContext;
            } catch (SocketTimeoutException e2) {
                if (z2) {
                    new ConnectTimeoutException(getConnectTimeoutMessage(e2, httpHost, inetAddressArrResolve)).initCause(e2);
                }
                if (!Log.isLoggable(TAG, 3)) {
                }
                i2++;
                httpContext2 = httpContext;
            }
        }
    }

    public void upgrade(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, HttpContext httpContext) throws UnsupportedSchemeException {
        ConnectionSocketFactory connectionSocketFactoryLookup = getSocketFactoryRegistry(HttpClientContext.adapt(httpContext)).lookup(httpHost.getSchemeName());
        if (connectionSocketFactoryLookup == null) {
            throw new UnsupportedSchemeException(String.valueOf(httpHost.getSchemeName()).concat(" protocol is not supported"));
        }
        if (!(connectionSocketFactoryLookup instanceof LayeredConnectionSocketFactory)) {
            throw new UnsupportedSchemeException(String.valueOf(httpHost.getSchemeName()).concat(" protocol does not support connection upgrade"));
        }
        managedHttpClientConnection.bind(((LayeredConnectionSocketFactory) connectionSocketFactoryLookup).createLayeredSocket(managedHttpClientConnection.getSocket(), httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpContext));
    }
}
