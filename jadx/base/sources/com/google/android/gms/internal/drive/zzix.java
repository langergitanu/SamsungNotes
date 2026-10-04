package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
final class zzix {
    private static final Class<?> zzni = zzj("libcore.io.Memory");
    private static final boolean zznj;

    static {
        zznj = zzj("org.robolectric.Robolectric") != null;
    }

    public static boolean zzbr() {
        return (zzni == null || zznj) ? false : true;
    }

    public static Class<?> zzbs() {
        return zzni;
    }

    private static <T> Class<T> zzj(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
