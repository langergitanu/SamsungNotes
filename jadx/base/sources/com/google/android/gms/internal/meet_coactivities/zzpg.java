package com.google.android.gms.internal.meet_coactivities;

import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class zzpg extends zzpe {
    private static final String zza;

    static {
        String property;
        try {
            property = System.getProperty(SystemProperties.LINE_SEPARATOR);
        } catch (SecurityException unused) {
        }
        if (!property.matches("\\n|\\r(?:\\n)?")) {
            property = "\n";
        }
        zza = property;
    }

    public static int zzc(String str, int i) {
        while (i < str.length()) {
            int i2 = i + 1;
            if (str.charAt(i) != '%') {
                i = i2;
            } else {
                if (i2 >= str.length()) {
                    throw zzpf.zzd("trailing unquoted '%' character", str, i);
                }
                char cCharAt = str.charAt(i2);
                if (cCharAt != '%' && cCharAt != 'n') {
                    return i;
                }
                i += 2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzpe
    public final void zzb(StringBuilder sb, String str, int i, int i2) {
        int i4 = i;
        while (i < i2) {
            int i5 = i + 1;
            if (str.charAt(i) == '%') {
                if (i5 == i2) {
                    break;
                }
                char cCharAt = str.charAt(i5);
                if (cCharAt == '%') {
                    sb.append((CharSequence) str, i4, i5);
                } else if (cCharAt == 'n') {
                    sb.append((CharSequence) str, i4, i);
                    sb.append(zza);
                }
                i4 = i + 2;
                i = i4;
            }
            i = i5;
        }
        if (i4 < i2) {
            sb.append((CharSequence) str, i4, i2);
        }
    }
}
