package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzhi {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc;
    private static final boolean zzd;
    private static final zzhh zze;
    private static final boolean zzf;
    private static final boolean zzg;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    static {
        boolean z;
        boolean z2;
        zzhh zzhhVar;
        Unsafe unsafeZzg = zzg();
        zzb = unsafeZzg;
        zzc = zzdr.zza();
        Class cls = Long.TYPE;
        boolean zZzs = zzs(cls);
        zzd = zZzs;
        Class cls2 = Integer.TYPE;
        boolean zZzs2 = zzs(cls2);
        zzhh zzhfVar = null;
        if (unsafeZzg != null) {
            if (zZzs) {
                zzhfVar = new zzhg(unsafeZzg);
            } else if (zZzs2) {
                zzhfVar = new zzhf(unsafeZzg);
            }
        }
        zze = zzhfVar;
        if (zzhfVar == null) {
            z = false;
        } else {
            try {
                Class<?> cls3 = zzhfVar.zza.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (zzy() != null) {
                    z = true;
                }
            } catch (Throwable th) {
                zzh(th);
            }
        }
        zzf = z;
        zzhh zzhhVar2 = zze;
        if (zzhhVar2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls4 = zzhhVar2.zza.getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                cls4.getMethod("getInt", Object.class, cls);
                cls4.getMethod("putInt", Object.class, cls, cls2);
                cls4.getMethod("getLong", Object.class, cls);
                cls4.getMethod("putLong", Object.class, cls, cls);
                cls4.getMethod("getObject", Object.class, cls);
                cls4.getMethod("putObject", Object.class, cls, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                zzh(th2);
                z2 = false;
            }
        }
        zzg = z2;
        zzw(byte[].class);
        zzw(boolean[].class);
        zzx(boolean[].class);
        zzw(int[].class);
        zzx(int[].class);
        zzw(long[].class);
        zzx(long[].class);
        zzw(float[].class);
        zzx(float[].class);
        zzw(double[].class);
        zzx(double[].class);
        zzw(Object[].class);
        zzx(Object[].class);
        Field fieldZzy = zzy();
        if (fieldZzy != null && (zzhhVar = zze) != null) {
            zzhhVar.zzk(fieldZzy);
        }
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzhi() {
    }

    public static double zza(Object obj, long j) {
        return zze.zza(obj, j);
    }

    public static float zzb(Object obj, long j) {
        return zze.zzb(obj, j);
    }

    public static int zzc(Object obj, long j) {
        return zze.zzi(obj, j);
    }

    public static long zzd(Object obj, long j) {
        return zze.zzj(obj, j);
    }

    public static Object zze(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zzf(Object obj, long j) {
        return zze.zzl(obj, j);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhe());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzhi.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        long j2 = (-4) & j;
        zzhh zzhhVar = zze;
        int iZzi = zzhhVar.zzi(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzhhVar.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & iZzi));
    }

    public static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        long j2 = (-4) & j;
        zzhh zzhhVar = zze;
        int i = (((int) j) & 3) << 3;
        zzhhVar.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzhhVar.zzi(obj, j2)));
    }

    public static void zzk(Object obj, long j, boolean z) {
        zze.zzc(obj, j, z);
    }

    public static void zzl(Object obj, long j, double d) {
        zze.zzd(obj, j, d);
    }

    public static void zzm(Object obj, long j, float f) {
        zze.zze(obj, j, f);
    }

    public static void zzn(Object obj, long j, int i) {
        zze.zzm(obj, j, i);
    }

    public static void zzo(Object obj, long j, long j2) {
        zze.zzn(obj, j, j2);
    }

    public static void zzp(Object obj, long j, Object obj2) {
        zze.zzo(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzq(Object obj, long j) {
        return ((byte) ((zze.zzi(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzr(Object obj, long j) {
        return ((byte) ((zze.zzi(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    public static boolean zzs(Class cls) {
        int i = zzdr.zza;
        try {
            Class cls2 = zzc;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzt(Object obj, long j) {
        return zze.zzf(obj, j);
    }

    public static boolean zzu() {
        return zzg;
    }

    public static boolean zzv() {
        return zzf;
    }

    private static int zzw(Class cls) {
        if (zzg) {
            return zze.zzg(cls);
        }
        return -1;
    }

    private static int zzx(Class cls) {
        if (zzg) {
            return zze.zzh(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i = zzdr.zza;
        Field fieldZzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (fieldZzz != null) {
            return fieldZzz;
        }
        Field fieldZzz2 = zzz(Buffer.class, "address");
        if (fieldZzz2 == null || fieldZzz2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzz2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
