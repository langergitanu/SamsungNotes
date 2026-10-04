package okhttp3;

import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class EventListener {
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener.1
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Factory {
        EventListener create(Call call);
    }

    public static Factory factory(EventListener eventListener) {
        return new C11253j(eventListener, 16);
    }

    public void callEnd(Call call) {
    }

    public void callStart(Call call) {
    }

    public void requestBodyStart(Call call) {
    }

    public void requestHeadersStart(Call call) {
    }

    public void responseBodyStart(Call call) {
    }

    public void responseHeadersStart(Call call) {
    }

    public void secureConnectStart(Call call) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EventListener lambda$factory$0(EventListener eventListener, Call call) {
        return eventListener;
    }

    public void callFailed(Call call, IOException iOException) {
    }

    public void connectionAcquired(Call call, Connection connection) {
    }

    public void connectionReleased(Call call, Connection connection) {
    }

    public void dnsStart(Call call, String str) {
    }

    public void requestBodyEnd(Call call, long j) {
    }

    public void requestFailed(Call call, IOException iOException) {
    }

    public void requestHeadersEnd(Call call, Request request) {
    }

    public void responseBodyEnd(Call call, long j) {
    }

    public void responseFailed(Call call, IOException iOException) {
    }

    public void responseHeadersEnd(Call call, Response response) {
    }

    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
    }
}
