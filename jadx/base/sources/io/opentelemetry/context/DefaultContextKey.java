package io.opentelemetry.context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class DefaultContextKey<T> implements ContextKey<T> {
    private final String name;

    public DefaultContextKey(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
