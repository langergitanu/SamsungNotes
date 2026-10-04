package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmm {
    public static /* synthetic */ boolean zza(int i, zzlk zzlkVar, StringBuilder sb) {
        if (i - 1 != 0 || zzlkVar == zzlk.zza) {
            return false;
        }
        sb.append(zzlkVar.zzb());
        sb.append('.');
        sb.append(zzlkVar.zzd());
        sb.append(':');
        sb.append(zzlkVar.zza());
        return true;
    }
}
