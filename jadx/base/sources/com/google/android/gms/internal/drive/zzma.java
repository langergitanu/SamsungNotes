package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
final class zzma {
    private static final zzly zzuu = zzei();
    private static final zzly zzuv = new zzlz();

    public static zzly zzeg() {
        return zzuu;
    }

    public static zzly zzeh() {
        return zzuv;
    }

    private static zzly zzei() {
        try {
            return (zzly) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
