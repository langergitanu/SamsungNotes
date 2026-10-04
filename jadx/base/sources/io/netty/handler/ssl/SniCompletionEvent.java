package io.netty.handler.ssl;

import androidx.collection.AbstractC0622a;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class SniCompletionEvent extends SslCompletionEvent {
    private final String hostname;

    public SniCompletionEvent(String str) {
        this.hostname = str;
    }

    public String hostname() {
        return this.hostname;
    }

    @Override // io.netty.handler.ssl.SslCompletionEvent
    public String toString() {
        Throwable thCause = cause();
        if (thCause == null) {
            return AbstractC0622a.m1170p(this.hostname, "'\")", new StringBuilder("SniCompletionEvent(SUCCESS='"));
        }
        return "SniCompletionEvent(" + thCause + PropertyUtils.MAPPED_DELIM2;
    }

    public SniCompletionEvent(String str, Throwable th) {
        super(th);
        this.hostname = str;
    }

    public SniCompletionEvent(Throwable th) {
        this(null, th);
    }
}
