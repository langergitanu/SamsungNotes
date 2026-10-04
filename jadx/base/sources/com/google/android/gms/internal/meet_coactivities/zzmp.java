package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Locale;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmp {
    static final Locale zza = Locale.ROOT;

    public static String zza(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            if (obj.getClass().isArray()) {
                return obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : Arrays.toString((Object[]) obj);
            }
            String string = obj.toString();
            return string != null ? string : zzd(obj, "toString() returned null");
        } catch (RuntimeException e) {
            return zze(obj, e);
        }
    }

    public static void zzb(StringBuilder sb, Number number, zzmi zzmiVar) {
        boolean zZzk = zzmiVar.zzk();
        long jLongValue = number.longValue();
        if (number instanceof Long) {
            zzf(sb, jLongValue, zZzk);
            return;
        }
        if (number instanceof Integer) {
            zzf(sb, jLongValue & 4294967295L, zZzk);
            return;
        }
        if (number instanceof Byte) {
            zzf(sb, jLongValue & 255, zZzk);
            return;
        }
        if (number instanceof Short) {
            zzf(sb, jLongValue & 65535, zZzk);
        } else {
            if (!(number instanceof BigInteger)) {
                throw new IllegalStateException("unsupported number type: ".concat(String.valueOf(number.getClass())));
            }
            String string = ((BigInteger) number).toString(16);
            if (zZzk) {
                string = string.toUpperCase(zza);
            }
            sb.append(string);
        }
    }

    public static void zzc(Formattable formattable, StringBuilder sb, zzmi zzmiVar) {
        int iZza = zzmiVar.zza();
        int i = iZza & 162;
        if (i != 0) {
            i = ((iZza & 32) != 0 ? 1 : 0) | ((iZza & 128) != 0 ? 2 : 0) | ((iZza & 2) != 0 ? 4 : 0);
        }
        int length = sb.length();
        Formatter formatter = new Formatter(sb, zza);
        try {
            formattable.formatTo(formatter, i, zzmiVar.zzc(), zzmiVar.zzb());
        } catch (RuntimeException e) {
            sb.setLength(length);
            try {
                formatter.out().append(zze(formattable, e));
            } catch (IOException unused) {
            }
        }
    }

    private static String zzd(Object obj, String str) {
        return AbstractC0622a.m1170p(str, "}", AbstractC0541b.m780v(Parse.BRACKET_LCB, System.identityHashCode(obj), obj.getClass().getName(), Log.TAG_SEPARATOR, ": "));
    }

    private static String zze(Object obj, RuntimeException runtimeException) {
        String simpleName;
        try {
            simpleName = runtimeException.toString();
        } catch (RuntimeException e) {
            simpleName = e.getClass().getSimpleName();
        }
        return zzd(obj, simpleName);
    }

    private static void zzf(StringBuilder sb, long j, boolean z) {
        if (j == 0) {
            sb.append("0");
            return;
        }
        String str = true != z ? "0123456789abcdef" : BinTools.hex;
        for (int iNumberOfLeadingZeros = (63 - Long.numberOfLeadingZeros(j)) & (-4); iNumberOfLeadingZeros >= 0; iNumberOfLeadingZeros -= 4) {
            sb.append(str.charAt((int) ((j >>> iNumberOfLeadingZeros) & 15)));
        }
    }
}
