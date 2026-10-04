package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzph {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzpl zzb;

    static {
        zzpl zzpmVar;
        int i = 0;
        while (true) {
            if (i >= 2) {
                zzpmVar = new zzpm();
                break;
            }
            zzpmVar = null;
            try {
                zzpmVar = (zzpl) Class.forName(zza[i]).asSubclass(zzpl.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzpmVar != null) {
                break;
            } else {
                i++;
            }
        }
        zzb = zzpmVar;
    }

    public static StackTraceElement zza(Class cls, int i) {
        zzpi.zza(cls, "target");
        return zzb.zza(cls, 2);
    }

    public static StackTraceElement[] zzb(Class cls, int i, int i2) {
        if (i > 0 || i == -1) {
            return zzb.zzb(cls, i, 2);
        }
        throw new IllegalArgumentException("invalid maximum depth: 0");
    }
}
