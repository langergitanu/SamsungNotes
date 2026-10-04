package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.ConnectionBackoffStrategy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NullBackoffStrategy implements ConnectionBackoffStrategy {
    @Override // org.apache.http.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(Throwable th) {
        return false;
    }

    @Override // org.apache.http.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(HttpResponse httpResponse) {
        return false;
    }
}
