package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapz {
    public static final /* synthetic */ int zza = 0;

    static {
        Object obj;
        Class<?> cls;
        zzapx zzapxVar;
        try {
            cls = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
            obj = null;
        } catch (Throwable th) {
            obj = th;
            cls = null;
        }
        if (cls != null) {
            try {
                zzapxVar = (zzapx) cls.asSubclass(zzapx.class).getConstructor(zzaqa.class).newInstance(zzapx.zza);
            } catch (Throwable th2) {
                obj = th2;
                zzapxVar = null;
            }
        } else {
            zzapxVar = null;
        }
        if (zzapxVar == null) {
            new zzapx(zzapx.zza);
        }
        if (obj != null) {
            try {
                if (Boolean.getBoolean("io.perfmark.PerfMark.debug")) {
                    Class<?> cls2 = Class.forName("java.util.logging.Logger");
                    Object objInvoke = cls2.getMethod("getLogger", String.class).invoke(null, zzapz.class.getName());
                    Class<?> cls3 = Class.forName("java.util.logging.Level");
                    cls2.getMethod("log", cls3, String.class, Throwable.class).invoke(objInvoke, cls3.getField("FINE").get(null), "Error during PerfMark.<clinit>", obj);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private zzapz() {
    }

    public static zzapy zza() {
        return zzapx.zzb;
    }
}
