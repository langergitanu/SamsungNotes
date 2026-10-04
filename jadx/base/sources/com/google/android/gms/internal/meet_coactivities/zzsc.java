package com.google.android.gms.internal.meet_coactivities;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzsc implements zzvr {
    private final zzsb zza;

    private zzsc(zzsb zzsbVar) {
        byte[] bArr = zztg.zzb;
        this.zza = zzsbVar;
        zzsbVar.zza = this;
    }

    public static zzsc zza(zzsb zzsbVar) {
        zzsc zzscVar = zzsbVar.zza;
        return zzscVar != null ? zzscVar : new zzsc(zzsbVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzA(int i, long j) {
        this.zza.zzi(i, j);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzB(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzts)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzi(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Long) list.get(i5)).getClass();
                i4 += 8;
            }
            this.zza.zzs(i4);
            while (i2 < list.size()) {
                this.zza.zzj(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzts zztsVar = (zzts) list;
        if (!z) {
            while (i2 < zztsVar.size()) {
                this.zza.zzi(i, zztsVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zztsVar.size(); i7++) {
            zztsVar.zze(i7);
            i6 += 8;
        }
        this.zza.zzs(i6);
        while (i2 < zztsVar.size()) {
            this.zza.zzj(zztsVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzC(int i, int i2) {
        this.zza.zzr(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzD(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzsz)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzsb zzsbVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzsbVar.zzr(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int iZzz = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int iIntValue2 = ((Integer) list.get(i4)).intValue();
                iZzz += zzsb.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzs(iZzz);
            while (i2 < list.size()) {
                zzsb zzsbVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzsbVar2.zzs((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzsz zzszVar = (zzsz) list;
        if (!z) {
            while (i2 < zzszVar.size()) {
                zzsb zzsbVar3 = this.zza;
                int iZze = zzszVar.zze(i2);
                zzsbVar3.zzr(i, (iZze >> 31) ^ (iZze + iZze));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzz2 = 0;
        for (int i5 = 0; i5 < zzszVar.size(); i5++) {
            int iZze2 = zzszVar.zze(i5);
            iZzz2 += zzsb.zzz((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzs(iZzz2);
        while (i2 < zzszVar.size()) {
            zzsb zzsbVar4 = this.zza;
            int iZze3 = zzszVar.zze(i2);
            zzsbVar4.zzs((iZze3 >> 31) ^ (iZze3 + iZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzE(int i, long j) {
        this.zza.zzt(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzF(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzts)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzsb zzsbVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzsbVar.zzt(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int iZzA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long jLongValue2 = ((Long) list.get(i4)).longValue();
                iZzA += zzsb.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzs(iZzA);
            while (i2 < list.size()) {
                zzsb zzsbVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzsbVar2.zzu((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzts zztsVar = (zzts) list;
        if (!z) {
            while (i2 < zztsVar.size()) {
                zzsb zzsbVar3 = this.zza;
                long jZze = zztsVar.zze(i2);
                zzsbVar3.zzt(i, (jZze >> 63) ^ (jZze + jZze));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA2 = 0;
        for (int i5 = 0; i5 < zztsVar.size(); i5++) {
            long jZze2 = zztsVar.zze(i5);
            iZzA2 += zzsb.zzA((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzs(iZzA2);
        while (i2 < zztsVar.size()) {
            zzsb zzsbVar4 = this.zza;
            long jZze3 = zztsVar.zze(i2);
            zzsbVar4.zzu((jZze3 >> 63) ^ (jZze3 + jZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    @Deprecated
    public final void zzG(int i) {
        this.zza.zzq(i, 3);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzH(int i, String str) {
        this.zza.zzo(i, str);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzI(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zztp)) {
            while (i2 < list.size()) {
                this.zza.zzo(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zztp zztpVar = (zztp) list;
        while (i2 < list.size()) {
            Object objZzb = zztpVar.zzb();
            if (objZzb instanceof String) {
                this.zza.zzo(i, (String) objZzb);
            } else {
                this.zza.zze(i, (zzrq) objZzb);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzJ(int i, int i2) {
        this.zza.zzr(i, i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzK(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzsz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzr(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int iZzz = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzz += zzsb.zzz(((Integer) list.get(i4)).intValue());
            }
            this.zza.zzs(iZzz);
            while (i2 < list.size()) {
                this.zza.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzsz zzszVar = (zzsz) list;
        if (!z) {
            while (i2 < zzszVar.size()) {
                this.zza.zzr(i, zzszVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzz2 = 0;
        for (int i5 = 0; i5 < zzszVar.size(); i5++) {
            iZzz2 += zzsb.zzz(zzszVar.zze(i5));
        }
        this.zza.zzs(iZzz2);
        while (i2 < zzszVar.size()) {
            this.zza.zzs(zzszVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzL(int i, long j) {
        this.zza.zzt(i, j);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzM(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzts)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzt(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int iZzA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzA += zzsb.zzA(((Long) list.get(i4)).longValue());
            }
            this.zza.zzs(iZzA);
            while (i2 < list.size()) {
                this.zza.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzts zztsVar = (zzts) list;
        if (!z) {
            while (i2 < zztsVar.size()) {
                this.zza.zzt(i, zztsVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA2 = 0;
        for (int i5 = 0; i5 < zztsVar.size(); i5++) {
            iZzA2 += zzsb.zzA(zztsVar.zze(i5));
        }
        this.zza.zzs(iZzA2);
        while (i2 < zztsVar.size()) {
            this.zza.zzu(zztsVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzb(int i, boolean z) {
        this.zza.zzd(i, z);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzc(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzrg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Boolean) list.get(i5)).getClass();
                i4++;
            }
            this.zza.zzs(i4);
            while (i2 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzrg zzrgVar = (zzrg) list;
        if (!z) {
            while (i2 < zzrgVar.size()) {
                this.zza.zzd(i, zzrgVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzrgVar.size(); i7++) {
            zzrgVar.zzf(i7);
            i6++;
        }
        this.zza.zzs(i6);
        while (i2 < zzrgVar.size()) {
            this.zza.zzb(zzrgVar.zzf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzd(int i, zzrq zzrqVar) {
        this.zza.zze(i, zzrqVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zze(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzrq) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzf(int i, double d) {
        this.zza.zzi(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzg(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzsd)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzi(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Double) list.get(i5)).getClass();
                i4 += 8;
            }
            this.zza.zzs(i4);
            while (i2 < list.size()) {
                this.zza.zzj(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzsd zzsdVar = (zzsd) list;
        if (!z) {
            while (i2 < zzsdVar.size()) {
                this.zza.zzi(i, Double.doubleToRawLongBits(zzsdVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzsdVar.size(); i7++) {
            zzsdVar.zze(i7);
            i6 += 8;
        }
        this.zza.zzs(i6);
        while (i2 < zzsdVar.size()) {
            this.zza.zzj(Double.doubleToRawLongBits(zzsdVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    @Deprecated
    public final void zzh(int i) {
        this.zza.zzq(i, 4);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzi(int i, int i2) {
        this.zza.zzk(i, i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzj(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzsz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzk(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int iZzA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzA += zzsb.zzA(((Integer) list.get(i4)).intValue());
            }
            this.zza.zzs(iZzA);
            while (i2 < list.size()) {
                this.zza.zzl(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzsz zzszVar = (zzsz) list;
        if (!z) {
            while (i2 < zzszVar.size()) {
                this.zza.zzk(i, zzszVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA2 = 0;
        for (int i5 = 0; i5 < zzszVar.size(); i5++) {
            iZzA2 += zzsb.zzA(zzszVar.zze(i5));
        }
        this.zza.zzs(iZzA2);
        while (i2 < zzszVar.size()) {
            this.zza.zzl(zzszVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzk(int i, int i2) {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzl(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzsz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).getClass();
                i4 += 4;
            }
            this.zza.zzs(i4);
            while (i2 < list.size()) {
                this.zza.zzh(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzsz zzszVar = (zzsz) list;
        if (!z) {
            while (i2 < zzszVar.size()) {
                this.zza.zzg(i, zzszVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzszVar.size(); i7++) {
            zzszVar.zze(i7);
            i6 += 4;
        }
        this.zza.zzs(i6);
        while (i2 < zzszVar.size()) {
            this.zza.zzh(zzszVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzm(int i, long j) {
        this.zza.zzi(i, j);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzn(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzts)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzi(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Long) list.get(i5)).getClass();
                i4 += 8;
            }
            this.zza.zzs(i4);
            while (i2 < list.size()) {
                this.zza.zzj(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzts zztsVar = (zzts) list;
        if (!z) {
            while (i2 < zztsVar.size()) {
                this.zza.zzi(i, zztsVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zztsVar.size(); i7++) {
            zztsVar.zze(i7);
            i6 += 8;
        }
        this.zza.zzs(i6);
        while (i2 < zztsVar.size()) {
            this.zza.zzj(zztsVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzo(int i, float f) {
        this.zza.zzg(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzp(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzsq)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Float) list.get(i5)).getClass();
                i4 += 4;
            }
            this.zza.zzs(i4);
            while (i2 < list.size()) {
                this.zza.zzh(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzsq zzsqVar = (zzsq) list;
        if (!z) {
            while (i2 < zzsqVar.size()) {
                this.zza.zzg(i, Float.floatToRawIntBits(zzsqVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzsqVar.size(); i7++) {
            zzsqVar.zze(i7);
            i6 += 4;
        }
        this.zza.zzs(i6);
        while (i2 < zzsqVar.size()) {
            this.zza.zzh(Float.floatToRawIntBits(zzsqVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzq(int i, Object obj, zzuq zzuqVar) {
        zzsb zzsbVar = this.zza;
        zzsbVar.zzq(i, 3);
        zzuqVar.zzj((zzue) obj, zzsbVar.zza);
        zzsbVar.zzq(i, 4);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzr(int i, int i2) {
        this.zza.zzk(i, i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzs(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzsz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzk(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int iZzA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzA += zzsb.zzA(((Integer) list.get(i4)).intValue());
            }
            this.zza.zzs(iZzA);
            while (i2 < list.size()) {
                this.zza.zzl(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzsz zzszVar = (zzsz) list;
        if (!z) {
            while (i2 < zzszVar.size()) {
                this.zza.zzk(i, zzszVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA2 = 0;
        for (int i5 = 0; i5 < zzszVar.size(); i5++) {
            iZzA2 += zzsb.zzA(zzszVar.zze(i5));
        }
        this.zza.zzs(iZzA2);
        while (i2 < zzszVar.size()) {
            this.zza.zzl(zzszVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzt(int i, long j) {
        this.zza.zzt(i, j);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzu(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzts)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzt(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int iZzA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzA += zzsb.zzA(((Long) list.get(i4)).longValue());
            }
            this.zza.zzs(iZzA);
            while (i2 < list.size()) {
                this.zza.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzts zztsVar = (zzts) list;
        if (!z) {
            while (i2 < zztsVar.size()) {
                this.zza.zzt(i, zztsVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA2 = 0;
        for (int i5 = 0; i5 < zztsVar.size(); i5++) {
            iZzA2 += zzsb.zzA(zztsVar.zze(i5));
        }
        this.zza.zzs(iZzA2);
        while (i2 < zztsVar.size()) {
            this.zza.zzu(zztsVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzv(int i, zztw zztwVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.zza.zzq(i, 2);
            this.zza.zzs(zztx.zzb(zztwVar, entry.getKey(), entry.getValue()));
            zztx.zze(this.zza, zztwVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzw(int i, Object obj, zzuq zzuqVar) {
        zzue zzueVar = (zzue) obj;
        zzry zzryVar = (zzry) this.zza;
        zzryVar.zzs((i << 3) | 2);
        zzryVar.zzs(((zzqz) zzueVar).zzv(zzuqVar));
        zzuqVar.zzj(zzueVar, zzryVar.zza);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzx(int i, Object obj) {
        if (obj instanceof zzrq) {
            zzry zzryVar = (zzry) this.zza;
            zzryVar.zzs(11);
            zzryVar.zzr(2, i);
            zzryVar.zze(3, (zzrq) obj);
            zzryVar.zzs(12);
            return;
        }
        zzry zzryVar2 = (zzry) this.zza;
        zzryVar2.zzs(11);
        zzryVar2.zzr(2, i);
        zzryVar2.zzs(26);
        zzryVar2.zzn((zzue) obj);
        zzryVar2.zzs(12);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzy(int i, int i2) {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzvr
    public final void zzz(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzsz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzq(i, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).getClass();
                i4 += 4;
            }
            this.zza.zzs(i4);
            while (i2 < list.size()) {
                this.zza.zzh(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzsz zzszVar = (zzsz) list;
        if (!z) {
            while (i2 < zzszVar.size()) {
                this.zza.zzg(i, zzszVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzszVar.size(); i7++) {
            zzszVar.zze(i7);
            i6 += 4;
        }
        this.zza.zzs(i6);
        while (i2 < zzszVar.size()) {
            this.zza.zzh(zzszVar.zze(i2));
            i2++;
        }
    }
}
