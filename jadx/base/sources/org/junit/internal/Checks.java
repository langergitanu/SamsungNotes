package org.junit.internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class Checks {
    private Checks() {
    }

    public static <T> T notNull(T t) {
        t.getClass();
        return t;
    }

    public static <T> T notNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
