package com.google.android.gms.internal.meet_coactivities;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zznp {
    private static final zznr zza = zzb(zznr.zzd);

    private static zznr zzb(String[] strArr) {
        zznr zznrVarZza;
        try {
            zznrVarZza = zzns.zza();
        } catch (NoClassDefFoundError unused) {
            zznrVarZza = null;
        }
        if (zznrVarZza != null) {
            return zznrVarZza;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zznr) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
