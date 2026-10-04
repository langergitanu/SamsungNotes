package io.opentelemetry.context;

import io.opentelemetry.context.ThreadLocalContextStorage;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Scope extends AutoCloseable {
    static Scope noop() {
        return ThreadLocalContextStorage.NoopScope.INSTANCE;
    }

    @Override // java.lang.AutoCloseable
    void close();
}
