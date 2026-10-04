package io.opentelemetry.api.internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class TemporaryBuffers {
    private static final ThreadLocal<char[]> CHAR_ARRAY = new ThreadLocal<>();

    private TemporaryBuffers() {
    }

    public static char[] chars(int i) {
        ThreadLocal<char[]> threadLocal = CHAR_ARRAY;
        char[] cArr = threadLocal.get();
        if (cArr != null && cArr.length >= i) {
            return cArr;
        }
        char[] cArr2 = new char[i];
        threadLocal.set(cArr2);
        return cArr2;
    }

    public static void clearChars() {
        CHAR_ARRAY.set(null);
    }
}
