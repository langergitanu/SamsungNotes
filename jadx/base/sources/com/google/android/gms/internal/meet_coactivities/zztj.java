package com.google.android.gms.internal.meet_coactivities;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
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
public final class zztj {
    public static final zztj zza;
    public static final zztj zzb;
    public static final zztj zzc;
    public static final zztj zzd;
    public static final zztj zze;
    public static final zztj zzf;
    public static final zztj zzg;
    public static final zztj zzh;
    public static final zztj zzi;
    public static final zztj zzj;
    private static final /* synthetic */ zztj[] zzk;
    private final Class zzl;

    static {
        zztj zztjVar = new zztj("VOID", 0, Void.class, Void.class, null);
        zza = zztjVar;
        Class cls = Integer.TYPE;
        zztj zztjVar2 = new zztj("INT", 1, cls, Integer.class, 0);
        zzb = zztjVar2;
        zztj zztjVar3 = new zztj("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zztjVar3;
        zztj zztjVar4 = new zztj("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zztjVar4;
        zztj zztjVar5 = new zztj("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zztjVar5;
        zztj zztjVar6 = new zztj("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zztjVar6;
        zztj zztjVar7 = new zztj("STRING", 6, String.class, String.class, "");
        zzg = zztjVar7;
        zztj zztjVar8 = new zztj("BYTE_STRING", 7, zzrq.class, zzrq.class, zzrq.zzb);
        zzh = zztjVar8;
        zztj zztjVar9 = new zztj("ENUM", 8, cls, Integer.class, null);
        zzi = zztjVar9;
        zztj zztjVar10 = new zztj("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zztjVar10;
        zzk = new zztj[]{zztjVar, zztjVar2, zztjVar3, zztjVar4, zztjVar5, zztjVar6, zztjVar7, zztjVar8, zztjVar9, zztjVar10};
    }

    private zztj(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzl = cls2;
    }

    public static zztj[] values() {
        return (zztj[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}
