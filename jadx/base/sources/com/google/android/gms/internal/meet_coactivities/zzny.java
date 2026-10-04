package com.google.android.gms.internal.meet_coactivities;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzny extends zznr {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zznq zzc;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    final class zza {
        public static boolean zza() {
            return zzny.zzt();
        }
    }

    static {
        String str = Build.FINGERPRINT;
        boolean z = true;
        if (str != null && !"robolectric".equals(str)) {
            z = false;
        }
        zzb = z;
        zzc = new zznq() { // from class: com.google.android.gms.internal.meet_coactivities.zzny.1
            @Override // com.google.android.gms.internal.meet_coactivities.zznq
            public zzlk zza(Class<?> cls, int i) {
                return zzlk.zza;
            }

            @Override // com.google.android.gms.internal.meet_coactivities.zznq
            public String zzb(Class<? extends zzko<?>> cls) {
                StackTraceElement stackTraceElementZza;
                if (zzny.zza) {
                    try {
                        if (cls.equals(zzny.zzp())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zzny.zzb || (stackTraceElementZza = zzph.zza(cls, 1)) == null) {
                    return null;
                }
                return stackTraceElementZza.getClassName();
            }
        };
    }

    public static Class<?> zzp() {
        return VMStack.getStackClass2();
    }

    public static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzt() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", null);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zznr
    public zzmn zze(String str) {
        return zzoc.zze(str);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zznr
    public zznq zzh() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zznr
    public zzoj zzj() {
        return zzod.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zznr
    public String zzm() {
        return "platform: Android";
    }
}
