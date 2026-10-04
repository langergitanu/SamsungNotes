package com.google.android.gms.internal.meet_coactivities;

import com.google.common.math.LongMath;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvs {
    static {
        zzsf zzsfVarZze = zzsg.zze();
        zzsfVarZze.zzb(-315576000000L);
        zzsfVarZze.zza(-999999999);
        zzsf zzsfVarZze2 = zzsg.zze();
        zzsfVarZze2.zzb(315576000000L);
        zzsfVarZze2.zza(999999999);
        zzsf zzsfVarZze3 = zzsg.zze();
        zzsfVarZze3.zzb(0L);
        zzsfVarZze3.zza(0);
    }

    public static zzsg zza(long j, int i) {
        if (i <= -1000000000 || i >= 1000000000) {
            j = LongMath.checkedAdd(j, i / 1000000000);
            i %= 1000000000;
        }
        if (j > 0 && i < 0) {
            i += 1000000000;
            j--;
        }
        if (j < 0 && i > 0) {
            i -= 1000000000;
            j++;
        }
        zzsf zzsfVarZze = zzsg.zze();
        zzsfVarZze.zzb(j);
        zzsfVarZze.zza(i);
        zzsg zzsgVar = (zzsg) zzsfVarZze.zzk();
        long jZzd = zzsgVar.zzd();
        int iZzc = zzsgVar.zzc();
        if (jZzd >= -315576000000L && jZzd <= 315576000000L && iZzc >= -999999999 && iZzc < 1000000000 && ((jZzd >= 0 && iZzc >= 0) || (jZzd <= 0 && iZzc <= 0))) {
            return zzsgVar;
        }
        throw new IllegalArgumentException("Duration is not valid. See proto definition for valid values. Seconds (" + jZzd + ") must be in range [-315,576,000,000, +315,576,000,000]. Nanos (" + iZzc + ") must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds");
    }
}
