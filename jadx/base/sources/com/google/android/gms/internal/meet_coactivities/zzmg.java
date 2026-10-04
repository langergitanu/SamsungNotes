package com.google.android.gms.internal.meet_coactivities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Formattable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmg extends zzpd implements zzoz {
    protected final Object[] zza;
    protected final StringBuilder zzb;
    private int zzc;

    public zzmg(zznu zznuVar, Object[] objArr, StringBuilder sb) {
        super(zznuVar);
        this.zzc = 0;
        zzpi.zza(objArr, "arguments");
        this.zza = objArr;
        this.zzb = sb;
    }

    public static StringBuilder zzb(zzml zzmlVar, StringBuilder sb) {
        Object obj;
        if (zzmlVar.zzj() != null) {
            zzmg zzmgVar = new zzmg(zzmlVar.zzj(), zzmlVar.zzw(), sb);
            Object objZzj = zzmgVar.zzj();
            obj = objZzj;
            if (zzmlVar.zzw().length > zzmgVar.zzh()) {
                StringBuilder sb2 = (StringBuilder) objZzj;
                sb2.append(" [ERROR: UNUSED LOG ARGUMENTS]");
                return sb2;
            }
        } else {
            sb.append(zzmp.zza(zzmlVar.zzk()));
            obj = sb;
        }
        return (StringBuilder) obj;
    }

    private static void zzm(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(zzmp.zza(obj));
        sb.append("]");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzpd
    public final /* bridge */ /* synthetic */ Object zza() {
        zzi().zzb(this.zzb, zzk(), this.zzc, zzk().length());
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzpd
    public final void zzc(int i, int i2, zzoy zzoyVar) {
        zzi().zzb(this.zzb, zzk(), this.zzc, i);
        zzoyVar.zze(this, this.zza);
        this.zzc = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    @Override // com.google.android.gms.internal.meet_coactivities.zzoz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(Object obj, zzmh zzmhVar, zzmi zzmiVar) {
        boolean zIsValidCodePoint;
        int iOrdinal = zzmhVar.zzd().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                zIsValidCodePoint = obj instanceof Boolean;
            } else if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        throw null;
                    }
                    zIsValidCodePoint = (obj instanceof Double) || (obj instanceof Float) || (obj instanceof BigDecimal);
                } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof BigInteger)) {
                }
            } else if (!(obj instanceof Character)) {
                if ((obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short)) {
                    zIsValidCodePoint = Character.isValidCodePoint(((Number) obj).intValue());
                }
            }
            if (!zIsValidCodePoint) {
                zzm(this.zzb, obj, zzmhVar.zze());
                return;
            }
        }
        StringBuilder sb = this.zzb;
        int iOrdinal2 = zzmhVar.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                if (zzmiVar.zzj()) {
                    sb.append(obj);
                    return;
                }
            } else if (iOrdinal2 != 2) {
                if (iOrdinal2 != 3) {
                    if (iOrdinal2 == 5 && zzmiVar.zze(128, false, false).equals(zzmiVar)) {
                        zzmp.zzb(sb, (Number) obj, zzmiVar);
                        return;
                    }
                }
            } else if (zzmiVar.zzj()) {
                if (obj instanceof Character) {
                    sb.append(obj);
                    return;
                }
                int iIntValue = ((Number) obj).intValue();
                if ((iIntValue >>> 16) == 0) {
                    sb.append((char) iIntValue);
                    return;
                } else {
                    sb.append(Character.toChars(iIntValue));
                    return;
                }
            }
        } else if (obj instanceof Formattable) {
            zzmp.zzc((Formattable) obj, sb, zzmiVar);
            return;
        } else if (zzmiVar.zzj()) {
            sb.append(zzmp.zza(obj));
            return;
        }
        String strZze = zzmhVar.zze();
        if (!zzmiVar.zzj()) {
            int iZza = zzmhVar.zza();
            if (zzmiVar.zzk()) {
                iZza &= 65503;
            }
            StringBuilder sb2 = new StringBuilder("%");
            zzmiVar.zzh(sb2);
            sb2.append((char) iZza);
            strZze = sb2.toString();
        }
        sb.append(String.format(zzmp.zza, strZze, obj));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzoz
    public final void zze(Object obj, zzow zzowVar, zzmi zzmiVar) {
        if ((obj instanceof Date) || (obj instanceof Calendar) || (obj instanceof Long)) {
            StringBuilder sb = new StringBuilder("%");
            zzmiVar.zzh(sb);
            sb.append(true != zzmiVar.zzk() ? 't' : 'T');
            sb.append(zzowVar.zza());
            this.zzb.append(String.format(zzmp.zza, sb.toString(), obj));
            return;
        }
        zzm(this.zzb, obj, "%t" + zzowVar.zza());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzoz
    public final void zzf() {
        this.zzb.append("[ERROR: MISSING LOG ARGUMENT]");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzoz
    public final void zzg() {
        this.zzb.append("null");
    }
}
