package com.google.android.gms.internal.meet_coactivities;

import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpf extends RuntimeException {
    private zzpf(String str, String str2) {
        super(str);
    }

    public static zzpf zza(String str, String str2, int i) {
        return new zzpf(zze(str, str2, i, i + 1), str2);
    }

    public static zzpf zzb(String str, String str2) {
        return new zzpf(str, str2);
    }

    public static zzpf zzc(String str, String str2, int i, int i2) {
        return new zzpf(zze(str, str2, i, i2), str2);
    }

    public static zzpf zzd(String str, String str2, int i) {
        return new zzpf(zze(str, str2, i, -1), str2);
    }

    private static String zze(String str, String str2, int i, int i2) {
        if (i2 < 0) {
            i2 = str2.length();
        }
        StringBuilder sbM12325j = AbstractC11014a.m12325j(str, ": ");
        if (i > 8) {
            sbM12325j.append("...");
            sbM12325j.append((CharSequence) str2, i - 5, i);
        } else {
            sbM12325j.append((CharSequence) str2, 0, i);
        }
        sbM12325j.append(PropertyUtils.INDEXED_DELIM);
        sbM12325j.append(str2.substring(i, i2));
        sbM12325j.append(PropertyUtils.INDEXED_DELIM2);
        if (str2.length() - i2 > 8) {
            sbM12325j.append((CharSequence) str2, i2, i2 + 5);
            sbM12325j.append("...");
        } else {
            sbM12325j.append((CharSequence) str2, i2, str2.length());
        }
        return sbM12325j.toString();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this;
    }
}
