package com.microsoft.identity.common.java.net;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class HttpUrlConnectionFactory {
    private static Queue<HttpURLConnection> sMockedConnectionQueue = new LinkedList();

    private HttpUrlConnectionFactory() {
    }

    public static void addMockedConnection(HttpURLConnection httpURLConnection) {
        sMockedConnectionQueue.add(httpURLConnection);
    }

    public static void clearMockedConnectionQueue() {
        sMockedConnectionQueue.clear();
    }

    public static HttpURLConnection createHttpURLConnection(URL url) {
        return !sMockedConnectionQueue.isEmpty() ? sMockedConnectionQueue.poll() : (HttpURLConnection) url.openConnection();
    }

    public static int getMockedConnectionCountInQueue() {
        return sMockedConnectionQueue.size();
    }
}
