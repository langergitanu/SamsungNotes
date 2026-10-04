package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NetworkDispatcher extends Thread {
    private final Cache mCache;
    private final ResponseDelivery mDelivery;
    private final Network mNetwork;
    private final BlockingQueue<Request<?>> mQueue;
    private volatile boolean mQuit = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.mQueue = blockingQueue;
        this.mNetwork = network;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    @TargetApi(14)
    private void addTrafficStatsTag(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    private void parseAndDeliverNetworkError(Request<?> request, VolleyError volleyError) {
        this.mDelivery.postError(request, request.parseNetworkError(volleyError));
    }

    private void processRequest() {
        processRequest(this.mQueue.take());
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.m3089e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    @VisibleForTesting
    public void processRequest(Request<?> request) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        request.sendEvent(3);
        try {
            try {
                try {
                    request.addMarker("network-queue-take");
                    if (request.isCanceled()) {
                        request.finish("network-discard-cancelled");
                        request.notifyListenerResponseNotUsable();
                        return;
                    }
                    addTrafficStatsTag(request);
                    NetworkResponse networkResponsePerformRequest = this.mNetwork.performRequest(request);
                    request.addMarker("network-http-complete");
                    if (networkResponsePerformRequest.notModified && request.hasHadResponseDelivered()) {
                        request.finish("not-modified");
                        request.notifyListenerResponseNotUsable();
                        return;
                    }
                    Response<?> networkResponse = request.parseNetworkResponse(networkResponsePerformRequest);
                    request.addMarker("network-parse-complete");
                    if (request.shouldCache() && networkResponse.cacheEntry != null) {
                        this.mCache.put(request.getCacheKey(), networkResponse.cacheEntry);
                        request.addMarker("network-cache-written");
                    }
                    request.markDelivered();
                    this.mDelivery.postResponse(request, networkResponse);
                    request.notifyListenerResponseReceived(networkResponse);
                } catch (VolleyError e) {
                    e.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    parseAndDeliverNetworkError(request, e);
                    request.notifyListenerResponseNotUsable();
                }
            } catch (Exception e2) {
                VolleyLog.m3090e(e2, "Unhandled exception %s", e2.toString());
                VolleyError volleyError = new VolleyError(e2);
                volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.mDelivery.postError(request, volleyError);
                request.notifyListenerResponseNotUsable();
            }
        } finally {
            request.sendEvent(4);
        }
    }
}
