package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import java.util.EventListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface GenericFutureListener<F extends Future<?>> extends EventListener {
    void operationComplete(F f);
}
