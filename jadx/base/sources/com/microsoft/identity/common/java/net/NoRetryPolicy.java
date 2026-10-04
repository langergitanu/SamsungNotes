package com.microsoft.identity.common.java.net;

import java.util.concurrent.Callable;
import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ThreadSafe
public class NoRetryPolicy implements IRetryPolicy<HttpResponse> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.identity.common.java.net.IRetryPolicy
    public HttpResponse attempt(Callable<HttpResponse> callable) {
        return callable.call();
    }
}
