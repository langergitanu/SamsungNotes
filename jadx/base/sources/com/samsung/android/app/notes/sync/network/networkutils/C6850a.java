package com.samsung.android.app.notes.sync.network.networkutils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBaseHC4;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import p012C1.RunnableC0045a;
import p042J1.AbstractC0146d;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6850a implements Comparable {

    /* JADX INFO: renamed from: d */
    public static final RequestConfig f4275d;

    /* JADX INFO: renamed from: e */
    public static final ConnectionConfig f4276e;

    /* JADX INFO: renamed from: f */
    public static final SocketConfig f4277f;

    /* JADX INFO: renamed from: g */
    public static final ArrayList f4278g = new ArrayList();

    /* JADX INFO: renamed from: h */
    public static final Handler f4279h;

    /* JADX INFO: renamed from: a */
    public PoolingHttpClientConnectionManager f4280a;

    /* JADX INFO: renamed from: b */
    public CloseableHttpClient f4281b;

    /* JADX INFO: renamed from: c */
    public int f4282c;

    static {
        final Looper mainLooper = Looper.getMainLooper();
        f4279h = new Handler(mainLooper) { // from class: com.samsung.android.app.notes.sync.network.networkutils.HttpClientSet$1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                C6850a c6850a = (C6850a) message.obj;
                if (c6850a != null) {
                    Debugger.m8607d("HttpClientSet", "receive msg : " + c6850a.hashCode() + ", cnt : " + c6850a.f4282c + ", msg : " + message.hashCode());
                    c6850a.m5017a();
                }
            }
        };
        f4276e = ConnectionConfig.custom().setCharset(Charset.forName("UTF-8")).setBufferSize(524288).build();
        f4277f = SocketConfig.custom().setSoTimeout(120000).build();
        f4275d = RequestConfig.custom().setConnectionRequestTimeout(29000).setConnectTimeout(29000).setSocketTimeout(120000).setExpectContinueEnabled(false).setStaleConnectionCheckEnabled(true).setRedirectsEnabled(false).build();
    }

    /* JADX INFO: renamed from: d */
    public static C6850a m5016d() {
        ArrayList<C6850a> arrayList = f4278g;
        synchronized (arrayList) {
            try {
                for (C6850a c6850a : arrayList) {
                    int i = c6850a.f4282c;
                    if (i == -1 || i == 0) {
                        Debugger.m8616s("HttpClientSet", "HttpClient " + super.hashCode() + " will be reused.. total : " + f4278g.size());
                        break;
                    }
                }
                c6850a = null;
                if (c6850a == null) {
                    c6850a = new C6850a();
                    c6850a.f4282c = 0;
                    c6850a.m5020e();
                    ArrayList arrayList2 = f4278g;
                    arrayList2.add(c6850a);
                    Debugger.m8616s("HttpClientSet", "HttpClient created.. total : " + arrayList2.size());
                }
                synchronized (c6850a) {
                    try {
                        if (c6850a.f4282c == -1) {
                            c6850a.m5020e();
                        }
                        c6850a.f4282c++;
                        Debugger.m8607d("HttpClientSet", "HttpClientSet getConnectionSet - set : " + super.hashCode() + ", requestCnt : " + c6850a.f4282c + ", total : " + f4278g.size());
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c6850a;
    }

    /* JADX INFO: renamed from: a */
    public final void m5017a() {
        Debugger.m8607d("HttpClientSet", "clear called : " + super.hashCode() + ", cnt : " + this.f4282c);
        synchronized (this) {
            try {
                if (this.f4282c != 0) {
                    return;
                }
                new SenlThreadFactory("HTTP_CLIENT_CLEAR").newThread(new RunnableC0045a(this, this, 6)).start();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m5018b() {
        synchronized (this) {
            try {
                this.f4282c--;
                Debugger.m8607d("HttpClientSet", "HttpClientSet close timer set - set : " + super.hashCode() + ", requestCnt : " + this.f4282c);
                this.f4280a.closeExpiredConnections();
                Message messageObtain = Message.obtain();
                int iHashCode = super.hashCode();
                messageObtain.what = iHashCode;
                messageObtain.obj = this;
                Handler handler = f4279h;
                if (handler.hasMessages(iHashCode)) {
                    handler.removeMessages(messageObtain.what);
                    Debugger.m8616s("HttpClientSet", "remove previous msg : " + super.hashCode() + ", cnt : " + this.f4282c + ", msg : " + messageObtain.hashCode());
                }
                handler.sendMessageDelayed(messageObtain, 120000L);
                Debugger.m8616s("HttpClientSet", "send msg : " + super.hashCode() + ", cnt : " + this.f4282c + ", msg : " + messageObtain.hashCode());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final CloseableHttpResponse m5019c(HttpRequestBaseHC4 httpRequestBaseHC4) {
        httpRequestBaseHC4.setConfig(f4275d);
        return this.f4281b.execute((HttpUriRequest) httpRequestBaseHC4);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.f4282c, ((C6850a) obj).f4282c);
    }

    /* JADX INFO: renamed from: e */
    public final void m5020e() {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        this.f4280a = poolingHttpClientConnectionManager;
        poolingHttpClientConnectionManager.setDefaultConnectionConfig(f4276e);
        this.f4280a.setDefaultSocketConfig(f4277f);
        HttpClientBuilder defaultRequestConfig = HttpClients.custom().setConnectionManager(this.f4280a).setDefaultRequestConfig(f4275d);
        boolean z = AbstractC0146d.f417a;
        this.f4281b = defaultRequestConfig.setUserAgent(SCloudPamHelper.getUserAgent()).build();
        this.f4282c = 0;
    }
}
