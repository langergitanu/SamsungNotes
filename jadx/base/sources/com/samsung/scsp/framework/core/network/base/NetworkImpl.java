package com.samsung.scsp.framework.core.network.base;

import android.net.TrafficStats;
import android.text.TextUtils;
import com.google.api.client.googleapis.MethodOverride;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.opencsv.bean.C6617b;
import com.samsung.scsp.common.Header;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.DefaultErrorListener;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.identity.ScspCorePreferences;
import com.samsung.scsp.framework.core.listeners.NetworkStatusAndProtocolListener;
import com.samsung.scsp.framework.core.listeners.NetworkStatusListener;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import com.samsung.scsp.framework.core.network.ResponseUtil;
import com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.brotli.dec.BrotliInputStream;
import p074R1.C0231c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NetworkImpl implements Network {
    private static final String DELETE = "DELETE";
    private static final String GET = "GET";
    private static final String HEAD = "HEAD";
    private static final String LINE_FEED = "\r\n";
    private static final String PATCH = "PATCH";
    private static final String POST = "POST";
    private static final String PUT = "PUT";
    private final Predicate<String> networkPolicyPredicate;
    private static final PayloadWriterVisitor<OutputStream> visitor = new PayloadWriterVisitorImpl();
    private static volatile SSLContext sslContext = null;
    private final Logger logger = Logger.get("NetworkImpl");
    private final Queue<HttpURLConnection> connectionQueue = new ConcurrentLinkedQueue();
    private final Object CLOSING_LOCK = new Object();
    private boolean isClosing = false;
    private final Network.ErrorListener errorListener = new DefaultErrorListener();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ConnectionSetter {
        void setup(HttpURLConnection httpURLConnection);
    }

    public NetworkImpl(Predicate<String> predicate) {
        if (predicate != null) {
            this.networkPolicyPredicate = predicate;
        } else {
            this.networkPolicyPredicate = new C11673c(1);
        }
    }

    private void checkNetworkClosing() {
        synchronized (this.CLOSING_LOCK) {
            try {
                if (this.isClosing) {
                    throw new ScspException(ScspException.Code.RUNTIME_NETWORK_ERROR, "Network is closing, try again later.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void closeSilently(Closeable closeable) {
        Objects.requireNonNull(closeable);
        FaultBarrier.run(new C11679i(closeable, 1), true);
    }

    private void configureConnection(HttpURLConnection httpURLConnection, HttpRequest httpRequest, Map<String, String> map) {
        httpURLConnection.setReadTimeout(httpRequest.getTimeOut());
        httpURLConnection.setConnectTimeout(httpRequest.getTimeOut());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static void disconnect(final HttpURLConnection httpURLConnection) {
        final int i = 0;
        FaultBarrier.run(new FaultBarrier.ThrowableRunnable() { // from class: com.samsung.scsp.framework.core.network.base.h
            @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
            public final void run() {
                switch (i) {
                    case 0:
                        NetworkImpl.lambda$disconnect$15(httpURLConnection);
                        break;
                    case 1:
                        NetworkImpl.lambda$disconnect$16(httpURLConnection);
                        break;
                    default:
                        NetworkImpl.lambda$disconnect$17(httpURLConnection);
                        break;
                }
            }
        }, true);
        final int i2 = 1;
        FaultBarrier.run(new FaultBarrier.ThrowableRunnable() { // from class: com.samsung.scsp.framework.core.network.base.h
            @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
            public final void run() {
                switch (i2) {
                    case 0:
                        NetworkImpl.lambda$disconnect$15(httpURLConnection);
                        break;
                    case 1:
                        NetworkImpl.lambda$disconnect$16(httpURLConnection);
                        break;
                    default:
                        NetworkImpl.lambda$disconnect$17(httpURLConnection);
                        break;
                }
            }
        }, true);
        final int i4 = 2;
        FaultBarrier.run(new FaultBarrier.ThrowableRunnable() { // from class: com.samsung.scsp.framework.core.network.base.h
            @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
            public final void run() {
                switch (i4) {
                    case 0:
                        NetworkImpl.lambda$disconnect$15(httpURLConnection);
                        break;
                    case 1:
                        NetworkImpl.lambda$disconnect$16(httpURLConnection);
                        break;
                    default:
                        NetworkImpl.lambda$disconnect$17(httpURLConnection);
                        break;
                }
            }
        }, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.samsung.scsp.framework.core.network.Network$StreamListener] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void execute(final HttpRequest httpRequest, ConnectionSetter connectionSetter, Network.StreamListener streamListener) throws Throwable {
        InputStream inputStream;
        if (!this.networkPolicyPredicate.test(httpRequest.getUrl())) {
            throw new ScspException(80300002, "Network is not allowed.");
        }
        final int i = 0;
        FaultBarrier.run(new FaultBarrier.ThrowableRunnable() { // from class: com.samsung.scsp.framework.core.network.base.b
            @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
            public final void run() {
                switch (i) {
                    case 0:
                        httpRequest.begin();
                        break;
                    case 1:
                        httpRequest.end();
                        break;
                    default:
                        httpRequest.error(ScspException.Code.RUNTIME_NETWORK_ERROR);
                        break;
                }
            }
        });
        ?? r2 = 1;
        InputStream inputStream2 = null;
        try {
            try {
                TrafficStats.setThreadStatsTag(1);
                HttpURLConnection connection = getConnection(httpRequest);
                try {
                    connectionSetter.setup(connection);
                    int responseCode = connection.getResponseCode();
                    TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                    treeMap.putAll((Map) connection.getHeaderFields().entrySet().stream().filter(new C11673c(0)).collect(Collectors.toMap(new C6617b(7), new C11674d())));
                    treeMap.put(Network.HTTP_STATUS, Arrays.asList(Integer.toString(responseCode)));
                    NetworkStatusListener networkStatusListener = httpRequest.getNetworkStatusListener();
                    if (networkStatusListener instanceof NetworkStatusAndProtocolListener) {
                        ((NetworkStatusAndProtocolListener) networkStatusListener).onNegotiatedProtocol(ApplicationProtocolNames.HTTP_1_1);
                    }
                    if (ResponseUtil.responsible().test(Integer.valueOf(responseCode))) {
                        String headerField = connection.getHeaderField("Content-Encoding");
                        if (streamListener != 0) {
                            if (!TextUtils.isEmpty(headerField) && "gzip".equals(headerField.toLowerCase(Locale.getDefault()).trim())) {
                                final int i2 = 0;
                                this.logger.m12931d(new Supplier() { // from class: com.samsung.scsp.framework.core.network.base.e
                                    @Override // java.util.function.Supplier
                                    public final Object get() {
                                        switch (i2) {
                                            case 0:
                                                return NetworkImpl.lambda$execute$9();
                                            case 1:
                                                return NetworkImpl.lambda$execute$10();
                                            default:
                                                return NetworkImpl.lambda$execute$11();
                                        }
                                    }
                                });
                                inputStream = new GZIPInputStream(connection.getInputStream());
                            } else if (TextUtils.isEmpty(headerField) || !Header.f8126BR.equals(headerField.toLowerCase(Locale.getDefault()).trim())) {
                                final int i4 = 2;
                                this.logger.m12931d(new Supplier() { // from class: com.samsung.scsp.framework.core.network.base.e
                                    @Override // java.util.function.Supplier
                                    public final Object get() {
                                        switch (i4) {
                                            case 0:
                                                return NetworkImpl.lambda$execute$9();
                                            case 1:
                                                return NetworkImpl.lambda$execute$10();
                                            default:
                                                return NetworkImpl.lambda$execute$11();
                                        }
                                    }
                                });
                                inputStream = connection.getInputStream();
                            } else {
                                final int i5 = 1;
                                this.logger.m12931d(new Supplier() { // from class: com.samsung.scsp.framework.core.network.base.e
                                    @Override // java.util.function.Supplier
                                    public final Object get() {
                                        switch (i5) {
                                            case 0:
                                                return NetworkImpl.lambda$execute$9();
                                            case 1:
                                                return NetworkImpl.lambda$execute$10();
                                            default:
                                                return NetworkImpl.lambda$execute$11();
                                        }
                                    }
                                });
                                inputStream = new BrotliInputStream(connection.getInputStream());
                            }
                            inputStream2 = inputStream;
                            streamListener.onStream(httpRequest, treeMap, inputStream2);
                        }
                    } else if (ResponseUtil.redirected().test(Integer.valueOf(responseCode))) {
                        String headerField2 = connection.getHeaderField("Location");
                        this.logger.m12934i("[" + httpRequest.getName() + "][" + httpRequest.hashCode() + "][redirected]");
                        this.logger.m12931d(new C11676f(httpRequest, headerField2));
                        httpRequest.setUrl(headerField2);
                        execute(httpRequest, connectionSetter, streamListener);
                    } else {
                        this.errorListener.onError(httpRequest, treeMap, responseCode, connection.getErrorStream());
                    }
                    final int i6 = 1;
                    FaultBarrier.run(new FaultBarrier.ThrowableRunnable() { // from class: com.samsung.scsp.framework.core.network.base.b
                        @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
                        public final void run() {
                            switch (i6) {
                                case 0:
                                    httpRequest.begin();
                                    break;
                                case 1:
                                    httpRequest.end();
                                    break;
                                default:
                                    httpRequest.error(ScspException.Code.RUNTIME_NETWORK_ERROR);
                                    break;
                            }
                        }
                    });
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    disconnect(connection);
                    this.connectionQueue.remove(connection);
                    this.logger.m12934i("Connection is removed.");
                    NetworkStatusListener networkStatusListener2 = httpRequest.getNetworkStatusListener();
                    if (networkStatusListener2 != null) {
                        networkStatusListener2.onClosed(connection.hashCode());
                    }
                } catch (ScspException e) {
                    e = e;
                    FaultBarrier.run(new C11671a(httpRequest, e, 3));
                    throw e;
                } catch (IOException e2) {
                    e = e2;
                    final int i7 = 2;
                    FaultBarrier.run(new FaultBarrier.ThrowableRunnable() { // from class: com.samsung.scsp.framework.core.network.base.b
                        @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
                        public final void run() {
                            switch (i7) {
                                case 0:
                                    httpRequest.begin();
                                    break;
                                case 1:
                                    httpRequest.end();
                                    break;
                                default:
                                    httpRequest.error(ScspException.Code.RUNTIME_NETWORK_ERROR);
                                    break;
                            }
                        }
                    });
                    throw new ScspException(ScspException.Code.RUNTIME_NETWORK_ERROR, "IOException occurred during network use.", e);
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                if (r2 != 0) {
                    throw th;
                }
                disconnect(r2);
                this.connectionQueue.remove(r2);
                this.logger.m12934i("Connection is removed.");
                NetworkStatusListener networkStatusListener3 = httpRequest.getNetworkStatusListener();
                if (networkStatusListener3 == null) {
                    throw th;
                }
                networkStatusListener3.onClosed(r2.hashCode());
                throw th;
            }
        } catch (ScspException e3) {
            e = e3;
        } catch (IOException e5) {
            e = e5;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            if (0 != 0) {
            }
            if (r2 != 0) {
            }
        }
    }

    private HttpURLConnection getConnection(HttpRequest httpRequest) throws ScspException {
        HashMap map = new HashMap();
        int headerCount = httpRequest.getHeaderCount();
        for (int i = 0; i < headerCount; i++) {
            map.put(httpRequest.getHeaderKey(i), httpRequest.getHeaderValue(i));
        }
        this.logger.m12931d(new C11676f(map, httpRequest));
        this.logger.m12934i(String.format("[%s][%s][%s][%s]", httpRequest.getName(), Integer.valueOf(httpRequest.hashCode()), httpRequest.getAnonymizedUrl(), ScspCorePreferences.get().dvcId.get()));
        try {
            URL url = new URL(httpRequest.getUrl());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (url.getProtocol().equals(AuthenticationConstants.HTTPS_PROTOCOL_STRING)) {
                this.logger.m12934i("Create SSLContext.");
                SSLContext sSLContext = SSLContextFactory.get();
                if (sSLContext != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
                }
            }
            this.connectionQueue.add(httpURLConnection);
            this.logger.m12934i("Connection is added.");
            httpURLConnection.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(true);
            configureConnection(httpURLConnection, httpRequest, map);
            NetworkStatusListener networkStatusListener = httpRequest.getNetworkStatusListener();
            if (networkStatusListener != null) {
                networkStatusListener.onStarted(httpURLConnection.hashCode());
            }
            return httpURLConnection;
        } catch (IOException e) {
            throw new ScspException(ScspException.Code.RUNTIME_NETWORK_ERROR, "IOException occurred during network use.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$close$4(HttpURLConnection httpURLConnection) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$close$5(int i, HttpURLConnection httpURLConnection) {
        return httpURLConnection.hashCode() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$close$6(Predicate predicate) {
        synchronized (this.CLOSING_LOCK) {
            this.isClosing = true;
            this.logger.m12934i("close request.");
            for (HttpURLConnection httpURLConnection : this.connectionQueue) {
                this.logger.m12934i("finding connection to close." + httpURLConnection.hashCode());
                if (predicate.test(httpURLConnection)) {
                    try {
                        if (httpURLConnection.getDoOutput()) {
                            this.logger.m12934i("conn has output, will be close...");
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    disconnect(httpURLConnection);
                    this.logger.m12934i("Connection is closed.");
                }
            }
            this.isClosing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$disconnect$15(HttpURLConnection httpURLConnection) {
        closeSilently(httpURLConnection.getInputStream());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$disconnect$16(HttpURLConnection httpURLConnection) {
        closeSilently(httpURLConnection.getErrorStream());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$disconnect$17(HttpURLConnection httpURLConnection) {
        closeSilently(httpURLConnection.getOutputStream());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$execute$10() {
        return "contentEncoding BR";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$execute$11() {
        return "contentEncoding else";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$execute$12(HttpRequest httpRequest, String str) {
        return "[" + httpRequest.getName() + "][" + httpRequest.hashCode() + "][" + str + "][redirected]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$execute$14(HttpRequest httpRequest, ScspException scspException) {
        httpRequest.error(scspException.rcode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$execute$8(Map.Entry entry) {
        return entry.getKey() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$execute$9() {
        return "contentEncoding GZIP";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getConnection$7(Map map, HttpRequest httpRequest) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(':');
            sb.append((String) map.get(str));
            sb.append(',');
        }
        if (sb.length() <= 0) {
            return "[" + httpRequest.getName() + "][" + httpRequest.hashCode() + "][ header - NONE]";
        }
        return "[" + httpRequest.getName() + "][" + httpRequest.hashCode() + "][ header - " + sb.substring(0, sb.length() - 1) + " ]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.io.OutputStream] */
    public static /* synthetic */ void lambda$patch$3(HttpRequest httpRequest, Network.StreamListener streamListener, HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.setRequestProperty(MethodOverride.HEADER, "PATCH");
        httpURLConnection.setRequestMethod("PATCH");
        httpURLConnection.setDoOutput(true);
        if (httpRequest.getSupportChunkedStreaming()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        httpURLConnection.setRequestProperty("Content-Type", httpRequest.getContentType(0));
        Object content = httpRequest.getContent(0);
        if (content != null) {
            PayloadWriterVisitor.Payload payload = new PayloadWriterVisitor.Payload();
            payload.httpRequest = httpRequest;
            payload.streamListener = streamListener;
            payload.output = httpURLConnection.getOutputStream();
            payload.content = content;
            httpRequest.getPayloadWriter(0).accept(payload, visitor);
        }
        httpURLConnection.getOutputStream().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r14v1, types: [T, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v2, types: [T, java.io.OutputStream] */
    public static /* synthetic */ void lambda$post$1(HttpRequest httpRequest, Network.StreamListener streamListener, HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        if (httpRequest.getSupportChunkedStreaming()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        int partCount = httpRequest.getPartCount();
        if (partCount > 1) {
            String boundary = httpRequest.getBoundary();
            String charset = httpRequest.getCharset();
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            ?? outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream) outputStream, charset);
            PrintWriter printWriter = new PrintWriter((Writer) outputStreamWriter, true);
            printWriter.append((CharSequence) "\r\n");
            printWriter.append((CharSequence) "--").append((CharSequence) boundary);
            try {
                PayloadWriterVisitor.Payload payload = new PayloadWriterVisitor.Payload();
                payload.httpRequest = httpRequest;
                payload.streamListener = streamListener;
                payload.output = outputStream;
                for (int i = 0; i < partCount; i++) {
                    Map<String, String> partHeaders = httpRequest.getPartHeaders(i);
                    if (partHeaders != null) {
                        for (String str : partHeaders.keySet()) {
                            printWriter.append((CharSequence) "\r\n");
                            printWriter.append((CharSequence) str).append((CharSequence) ": ").append((CharSequence) partHeaders.get(str));
                        }
                        printWriter.append((CharSequence) "\r\n");
                        printWriter.append((CharSequence) "Content-Type").append((CharSequence) ": ").append((CharSequence) httpRequest.getContentType(i));
                        printWriter.append((CharSequence) "\r\n").append((CharSequence) "\r\n");
                        printWriter.flush();
                    }
                    payload.content = httpRequest.getContent(i);
                    httpRequest.getPayloadWriter(i).accept(payload, visitor);
                    printWriter.append((CharSequence) "\r\n").append((CharSequence) "--").append((CharSequence) boundary);
                    printWriter.flush();
                }
                printWriter.append((CharSequence) "--");
                printWriter.append((CharSequence) "\r\n");
                printWriter.flush();
                printWriter.close();
                outputStreamWriter.close();
            } catch (Throwable th) {
                printWriter.close();
                outputStreamWriter.close();
                throw th;
            }
        } else {
            httpURLConnection.setRequestProperty("Content-Type", httpRequest.getContentType(0));
            PayloadWriterVisitor.Payload payload2 = new PayloadWriterVisitor.Payload();
            payload2.httpRequest = httpRequest;
            payload2.streamListener = streamListener;
            payload2.output = httpURLConnection.getOutputStream();
            payload2.transferred = httpRequest.getRange();
            Object content = httpRequest.getContent(0);
            if (content != null) {
                payload2.content = content;
                payload2.length = httpRequest.getLength();
                httpRequest.getPayloadWriter(0).accept(payload2, visitor);
            }
        }
        httpURLConnection.getOutputStream().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.io.OutputStream] */
    public static /* synthetic */ void lambda$put$2(HttpRequest httpRequest, Network.StreamListener streamListener, HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.setRequestMethod("PUT");
        httpURLConnection.setDoOutput(true);
        if (httpRequest.getSupportChunkedStreaming()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        httpURLConnection.setRequestProperty("Content-Type", httpRequest.getContentType(0));
        Object content = httpRequest.getContent(0);
        if (content != null) {
            PayloadWriterVisitor.Payload payload = new PayloadWriterVisitor.Payload();
            payload.httpRequest = httpRequest;
            payload.streamListener = streamListener;
            payload.transferred = httpRequest.getRange();
            payload.output = httpURLConnection.getOutputStream();
            payload.content = content;
            payload.length = httpRequest.getLength();
            httpRequest.getPayloadWriter(0).accept(payload, visitor);
        }
        httpURLConnection.getOutputStream().close();
    }

    private void simpleMethod(String str, HttpRequest httpRequest, Network.StreamListener streamListener) throws Throwable {
        this.logger.m12934i(str);
        checkNetworkClosing();
        execute(httpRequest, new C11679i(str, 0), streamListener);
    }

    @Override // com.samsung.scsp.framework.core.network.Network
    public void close() {
        close(new C11673c(2));
    }

    @Override // com.samsung.scsp.framework.core.network.Network
    public void delete(HttpRequest httpRequest, Network.StreamListener streamListener) throws Throwable {
        simpleMethod("DELETE", httpRequest, streamListener);
    }

    @Override // com.samsung.scsp.framework.core.network.Network
    public void get(HttpRequest httpRequest, Network.StreamListener streamListener) throws Throwable {
        simpleMethod("GET", httpRequest, streamListener);
    }

    @Override // com.samsung.scsp.framework.core.network.Network
    public void head(HttpRequest httpRequest, Network.StreamListener streamListener) throws Throwable {
        simpleMethod("HEAD", httpRequest, streamListener);
    }

    @Override // com.samsung.scsp.framework.core.network.Network
    public void patch(HttpRequest httpRequest, Network.StreamListener streamListener) throws Throwable {
        this.logger.m12934i("patch");
        checkNetworkClosing();
        execute(httpRequest, new C11671a(httpRequest, streamListener, 1), streamListener);
    }

    @Override // com.samsung.scsp.framework.core.network.Network
    public void post(HttpRequest httpRequest, Network.StreamListener streamListener) throws Throwable {
        this.logger.m12934i("post");
        checkNetworkClosing();
        execute(httpRequest, new C11671a(httpRequest, streamListener, 0), streamListener);
    }

    @Override // com.samsung.scsp.framework.core.network.Network
    public void put(HttpRequest httpRequest, Network.StreamListener streamListener) throws Throwable {
        this.logger.m12934i("put");
        checkNetworkClosing();
        execute(httpRequest, new C11671a(httpRequest, streamListener, 2), streamListener);
    }

    @Override // com.samsung.scsp.framework.core.network.Network
    public void close(int i) {
        close(new C0231c(i, 5));
    }

    private void close(final Predicate<HttpURLConnection> predicate) {
        new Thread(new Runnable() { // from class: com.samsung.scsp.framework.core.network.base.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f8239a.lambda$close$6(predicate);
            }
        }, "CLOSE_NETWORK").start();
    }
}
