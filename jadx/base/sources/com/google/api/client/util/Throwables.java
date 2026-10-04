package com.google.api.client.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Throwables {
    private Throwables() {
    }

    public static RuntimeException propagate(Throwable th) {
        return com.google.api.client.repackaged.com.google.common.base.Throwables.propagate(th);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X */
    public static void propagateIfPossible(Throwable th) throws X {
        com.google.api.client.repackaged.com.google.common.base.Throwables.propagateIfPossible(th);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X */
    public static <X extends Throwable> void propagateIfPossible(Throwable th, Class<X> cls) throws X {
        com.google.api.client.repackaged.com.google.common.base.Throwables.propagateIfPossible(th, cls);
    }
}
