package org.apache.commons.text.lookup;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class IllegalArgumentExceptions {
    private IllegalArgumentExceptions() {
    }

    public static IllegalArgumentException format(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr));
    }

    public static IllegalArgumentException format(Throwable th, String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr), th);
    }
}
