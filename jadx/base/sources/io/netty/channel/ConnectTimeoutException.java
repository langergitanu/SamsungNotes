package io.netty.channel;

import java.net.ConnectException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ConnectTimeoutException extends ConnectException {
    private static final long serialVersionUID = 2317065249988317463L;

    public ConnectTimeoutException(String str) {
        super(str);
    }

    public ConnectTimeoutException() {
    }
}
