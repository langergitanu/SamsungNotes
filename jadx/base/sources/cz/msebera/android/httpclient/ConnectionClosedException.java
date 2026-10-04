package cz.msebera.android.httpclient;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ConnectionClosedException extends IOException {
    private static final long serialVersionUID = 617550366255636674L;

    public ConnectionClosedException() {
        super("Connection is closed");
    }

    public ConnectionClosedException(String str) {
        super(HttpException.clean(str));
    }

    public ConnectionClosedException(String str, Object... objArr) {
        super(HttpException.clean(String.format(str, objArr)));
    }
}
