package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SslCompletionEvent {
    private final Throwable cause;

    public SslCompletionEvent() {
        this.cause = null;
    }

    public final Throwable cause() {
        return this.cause;
    }

    public final boolean isSuccess() {
        return this.cause == null;
    }

    public String toString() {
        Throwable thCause = cause();
        if (thCause == null) {
            return getClass().getSimpleName().concat("(SUCCESS)");
        }
        return getClass().getSimpleName() + PropertyUtils.MAPPED_DELIM + thCause + PropertyUtils.MAPPED_DELIM2;
    }

    public SslCompletionEvent(Throwable th) {
        this.cause = (Throwable) ObjectUtil.checkNotNull(th, "cause");
    }
}
