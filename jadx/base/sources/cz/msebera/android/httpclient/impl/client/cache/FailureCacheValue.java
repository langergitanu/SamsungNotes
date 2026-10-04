package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class FailureCacheValue {
    private final long creationTimeInNanos = System.nanoTime();
    private final int errorCount;
    private final String key;

    public FailureCacheValue(String str, int i) {
        this.key = str;
        this.errorCount = i;
    }

    public long getCreationTimeInNanos() {
        return this.creationTimeInNanos;
    }

    public int getErrorCount() {
        return this.errorCount;
    }

    public String getKey() {
        return this.key;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[entry creationTimeInNanos=");
        sb.append(this.creationTimeInNanos);
        sb.append("; key=");
        sb.append(this.key);
        sb.append("; errorCount=");
        return AbstractC0000a.m13j(sb, this.errorCount, PropertyUtils.INDEXED_DELIM2);
    }
}
