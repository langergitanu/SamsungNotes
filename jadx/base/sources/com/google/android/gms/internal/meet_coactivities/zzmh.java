package com.google.android.gms.internal.meet_coactivities;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmh {
    public static final zzmh zza;
    public static final zzmh zzb;
    public static final zzmh zzc;
    public static final zzmh zzd;
    public static final zzmh zze;
    public static final zzmh zzf;
    public static final zzmh zzg;
    public static final zzmh zzh;
    public static final zzmh zzi;
    public static final zzmh zzj;
    private static final zzmh[] zzk;
    private static final /* synthetic */ zzmh[] zzl;
    private final char zzm;
    private final zzmj zzn;
    private final int zzo;
    private final String zzp;

    static {
        zzmh zzmhVar = new zzmh("STRING", 0, 's', zzmj.GENERAL, "-#", true);
        zza = zzmhVar;
        zzmh zzmhVar2 = new zzmh("BOOLEAN", 1, 'b', zzmj.BOOLEAN, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, true);
        zzb = zzmhVar2;
        zzmh zzmhVar3 = new zzmh("CHAR", 2, DeviceInfoUtil.FLAVOR_TYPE_C, zzmj.CHARACTER, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, true);
        zzc = zzmhVar3;
        zzmj zzmjVar = zzmj.INTEGRAL;
        zzmh zzmhVar4 = new zzmh("DECIMAL", 3, 'd', zzmjVar, "-0+ ,(", false);
        zzd = zzmhVar4;
        zzmh zzmhVar5 = new zzmh("OCTAL", 4, 'o', zzmjVar, "-#0(", false);
        zze = zzmhVar5;
        zzmh zzmhVar6 = new zzmh("HEX", 5, 'x', zzmjVar, "-#0(", true);
        zzf = zzmhVar6;
        zzmj zzmjVar2 = zzmj.FLOAT;
        zzmh zzmhVar7 = new zzmh("FLOAT", 6, 'f', zzmjVar2, "-#0+ ,(", false);
        zzg = zzmhVar7;
        zzmh zzmhVar8 = new zzmh("EXPONENT", 7, 'e', zzmjVar2, "-#0+ (", true);
        zzh = zzmhVar8;
        zzmh zzmhVar9 = new zzmh("GENERAL", 8, DeviceInfoUtil.FLAVOR_TYPE_G, zzmjVar2, "-0+ ,(", true);
        zzi = zzmhVar9;
        zzmh zzmhVar10 = new zzmh("EXPONENT_HEX", 9, 'a', zzmjVar2, "-#0+ ", true);
        zzj = zzmhVar10;
        zzl = new zzmh[]{zzmhVar, zzmhVar2, zzmhVar3, zzmhVar4, zzmhVar5, zzmhVar6, zzmhVar7, zzmhVar8, zzmhVar9, zzmhVar10};
        zzk = new zzmh[26];
        for (zzmh zzmhVar11 : values()) {
            zzk[zzf(zzmhVar11.zzm)] = zzmhVar11;
        }
    }

    private zzmh(String str, int i, char c, zzmj zzmjVar, String str2, boolean z) {
        this.zzm = c;
        this.zzn = zzmjVar;
        this.zzo = zzmi.zzd(str2, z);
        this.zzp = "%" + c;
    }

    public static zzmh[] values() {
        return (zzmh[]) zzl.clone();
    }

    public static zzmh zzc(char c) {
        zzmh zzmhVar = zzk[zzf(c)];
        if ((c & ' ') != 0) {
            return zzmhVar;
        }
        if (zzmhVar == null || (zzmhVar.zzo & 128) == 0) {
            return null;
        }
        return zzmhVar;
    }

    private static int zzf(char c) {
        return (c | ' ') - 97;
    }

    public final char zza() {
        return this.zzm;
    }

    public final int zzb() {
        return this.zzo;
    }

    public final zzmj zzd() {
        return this.zzn;
    }

    public final String zze() {
        return this.zzp;
    }
}
