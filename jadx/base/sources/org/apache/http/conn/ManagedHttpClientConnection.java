package org.apache.http.conn;

import java.net.Socket;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpInetConnection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ManagedHttpClientConnection extends HttpClientConnection, HttpInetConnection {
    void bind(Socket socket);

    String getId();

    SSLSession getSSLSession();

    Socket getSocket();
}
