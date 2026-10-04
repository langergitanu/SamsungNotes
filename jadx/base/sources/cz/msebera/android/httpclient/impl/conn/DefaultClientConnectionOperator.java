package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.protocol.ClientContext;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpInetSocketAddress;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    protected final DnsResolver dnsResolver;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    protected final SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = new SystemDefaultDnsResolver();
    }

    private SchemeRegistry getSchemeRegistry(HttpContext httpContext) {
        SchemeRegistry schemeRegistry = (SchemeRegistry) httpContext.getAttribute(ClientContext.SCHEME_REGISTRY);
        return schemeRegistry == null ? this.schemeRegistry : schemeRegistry;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionOperator
    public OperatedClientConnection createConnection() {
        return new DefaultClientConnection();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4 A[SYNTHETIC] */
    @Override // cz.msebera.android.httpclient.conn.ClientConnectionOperator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void openConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, InetAddress inetAddress, HttpContext httpContext, HttpParams httpParams) throws SocketException, ConnectTimeoutException {
        InetAddress inetAddress2 = inetAddress;
        Args.notNull(operatedClientConnection, "Connection");
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpParams, "HTTP parameters");
        int i = 1;
        Asserts.check(!operatedClientConnection.isOpen(), "Connection must not be open");
        Scheme scheme = getSchemeRegistry(httpContext).getScheme(httpHost.getSchemeName());
        SchemeSocketFactory schemeSocketFactory = scheme.getSchemeSocketFactory();
        InetAddress[] inetAddressArrResolveHostname = resolveHostname(httpHost.getHostName());
        int iResolvePort = scheme.resolvePort(httpHost.getPort());
        int i2 = 0;
        int i4 = 0;
        while (i4 < inetAddressArrResolveHostname.length) {
            InetAddress inetAddress3 = inetAddressArrResolveHostname[i4];
            int i5 = i4 == inetAddressArrResolveHostname.length - i ? i : i2;
            Socket socketCreateSocket = schemeSocketFactory.createSocket(httpParams);
            operatedClientConnection.opening(socketCreateSocket, httpHost);
            HttpInetSocketAddress httpInetSocketAddress = new HttpInetSocketAddress(httpHost, inetAddress3, iResolvePort);
            InetSocketAddress inetSocketAddress = inetAddress2 != null ? new InetSocketAddress(inetAddress2, i2) : null;
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connecting to " + httpInetSocketAddress);
            }
            try {
                Socket socketConnectSocket = schemeSocketFactory.connectSocket(socketCreateSocket, httpInetSocketAddress, inetSocketAddress, httpParams);
                if (socketCreateSocket != socketConnectSocket) {
                    operatedClientConnection.opening(socketConnectSocket, httpHost);
                    socketCreateSocket = socketConnectSocket;
                }
                prepareSocket(socketCreateSocket, httpContext, httpParams);
                operatedClientConnection.openCompleted(schemeSocketFactory.isSecure(socketCreateSocket), httpParams);
                return;
            } catch (ConnectTimeoutException e) {
                if (i5 != 0) {
                    throw e;
                }
                if (!this.log.isDebugEnabled()) {
                    this.log.debug("Connect to " + httpInetSocketAddress + " timed out. Connection will be retried using another IP address");
                }
                i4++;
                inetAddress2 = inetAddress;
                i = 1;
                i2 = 0;
            } catch (ConnectException e2) {
                if (i5 != 0) {
                    throw e2;
                }
                if (!this.log.isDebugEnabled()) {
                }
                i4++;
                inetAddress2 = inetAddress;
                i = 1;
                i2 = 0;
            }
        }
    }

    public void prepareSocket(Socket socket, HttpContext httpContext, HttpParams httpParams) throws SocketException {
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(httpParams));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(httpParams));
        int linger = HttpConnectionParams.getLinger(httpParams);
        if (linger >= 0) {
            socket.setSoLinger(linger > 0, linger);
        }
    }

    public InetAddress[] resolveHostname(String str) {
        return this.dnsResolver.resolve(str);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionOperator
    public void updateSecureConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, HttpContext httpContext, HttpParams httpParams) throws SocketException {
        Args.notNull(operatedClientConnection, "Connection");
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpParams, "Parameters");
        Asserts.check(operatedClientConnection.isOpen(), "Connection must be open");
        Scheme scheme = getSchemeRegistry(httpContext).getScheme(httpHost.getSchemeName());
        Asserts.check(scheme.getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory, "Socket factory must implement SchemeLayeredSocketFactory");
        SchemeLayeredSocketFactory schemeLayeredSocketFactory = (SchemeLayeredSocketFactory) scheme.getSchemeSocketFactory();
        Socket socketCreateLayeredSocket = schemeLayeredSocketFactory.createLayeredSocket(operatedClientConnection.getSocket(), httpHost.getHostName(), scheme.resolvePort(httpHost.getPort()), httpParams);
        prepareSocket(socketCreateLayeredSocket, httpContext, httpParams);
        operatedClientConnection.update(socketCreateLayeredSocket, httpHost, schemeLayeredSocketFactory.isSecure(socketCreateLayeredSocket), httpParams);
    }

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        Args.notNull(schemeRegistry, "Scheme registry");
        Args.notNull(dnsResolver, "DNS resolver");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = dnsResolver;
    }
}
