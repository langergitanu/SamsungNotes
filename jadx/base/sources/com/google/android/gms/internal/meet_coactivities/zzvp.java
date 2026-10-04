package com.google.android.gms.internal.meet_coactivities;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
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
public final class zzvp {
    public static final zzvp zza;
    public static final zzvp zzb;
    public static final zzvp zzc;
    public static final zzvp zzd;
    public static final zzvp zze;
    public static final zzvp zzf;
    public static final zzvp zzg;
    public static final zzvp zzh;
    public static final zzvp zzi;
    public static final zzvp zzj;
    public static final zzvp zzk;
    public static final zzvp zzl;
    public static final zzvp zzm;
    public static final zzvp zzn;
    public static final zzvp zzo;
    public static final zzvp zzp;
    public static final zzvp zzq;
    public static final zzvp zzr;
    private static final /* synthetic */ zzvp[] zzs;
    private final zzvq zzt;
    private final int zzu;

    static {
        zzvp zzvpVar = new zzvp("DOUBLE", 0, zzvq.DOUBLE, 1);
        zza = zzvpVar;
        zzvp zzvpVar2 = new zzvp("FLOAT", 1, zzvq.FLOAT, 5);
        zzb = zzvpVar2;
        zzvq zzvqVar = zzvq.LONG;
        zzvp zzvpVar3 = new zzvp("INT64", 2, zzvqVar, 0);
        zzc = zzvpVar3;
        zzvp zzvpVar4 = new zzvp("UINT64", 3, zzvqVar, 0);
        zzd = zzvpVar4;
        zzvq zzvqVar2 = zzvq.INT;
        zzvp zzvpVar5 = new zzvp("INT32", 4, zzvqVar2, 0);
        zze = zzvpVar5;
        zzvp zzvpVar6 = new zzvp("FIXED64", 5, zzvqVar, 1);
        zzf = zzvpVar6;
        zzvp zzvpVar7 = new zzvp("FIXED32", 6, zzvqVar2, 5);
        zzg = zzvpVar7;
        zzvp zzvpVar8 = new zzvp("BOOL", 7, zzvq.BOOLEAN, 0);
        zzh = zzvpVar8;
        zzvp zzvpVar9 = new zzvp("STRING", 8, zzvq.STRING, 2);
        zzi = zzvpVar9;
        zzvq zzvqVar3 = zzvq.MESSAGE;
        zzvp zzvpVar10 = new zzvp("GROUP", 9, zzvqVar3, 3);
        zzj = zzvpVar10;
        zzvp zzvpVar11 = new zzvp("MESSAGE", 10, zzvqVar3, 2);
        zzk = zzvpVar11;
        zzvp zzvpVar12 = new zzvp("BYTES", 11, zzvq.BYTE_STRING, 2);
        zzl = zzvpVar12;
        zzvp zzvpVar13 = new zzvp("UINT32", 12, zzvqVar2, 0);
        zzm = zzvpVar13;
        zzvp zzvpVar14 = new zzvp("ENUM", 13, zzvq.ENUM, 0);
        zzn = zzvpVar14;
        zzvp zzvpVar15 = new zzvp("SFIXED32", 14, zzvqVar2, 5);
        zzo = zzvpVar15;
        zzvp zzvpVar16 = new zzvp("SFIXED64", 15, zzvqVar, 1);
        zzp = zzvpVar16;
        zzvp zzvpVar17 = new zzvp("SINT32", 16, zzvqVar2, 0);
        zzq = zzvpVar17;
        zzvp zzvpVar18 = new zzvp("SINT64", 17, zzvqVar, 0);
        zzr = zzvpVar18;
        zzs = new zzvp[]{zzvpVar, zzvpVar2, zzvpVar3, zzvpVar4, zzvpVar5, zzvpVar6, zzvpVar7, zzvpVar8, zzvpVar9, zzvpVar10, zzvpVar11, zzvpVar12, zzvpVar13, zzvpVar14, zzvpVar15, zzvpVar16, zzvpVar17, zzvpVar18};
    }

    private zzvp(String str, int i, zzvq zzvqVar, int i2) {
        this.zzt = zzvqVar;
        this.zzu = i2;
    }

    public static zzvp[] values() {
        return (zzvp[]) zzs.clone();
    }

    public final int zza() {
        return this.zzu;
    }

    public final zzvq zzb() {
        return this.zzt;
    }
}
