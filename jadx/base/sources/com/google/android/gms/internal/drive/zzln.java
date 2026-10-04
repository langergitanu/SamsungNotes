package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
final class zzln {
    private static final zzll zztz = zzeb();
    private static final zzll zzua = new zzlm();

    public static zzll zzdz() {
        return zztz;
    }

    public static zzll zzea() {
        return zzua;
    }

    private static zzll zzeb() {
        try {
            return (zzll) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
