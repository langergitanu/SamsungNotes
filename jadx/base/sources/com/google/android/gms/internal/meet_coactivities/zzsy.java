package com.google.android.gms.internal.meet_coactivities;

import com.google.android.gms.internal.meet_coactivities.zzss;
import com.google.android.gms.internal.meet_coactivities.zzsy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzsy<MessageType extends zzsy<MessageType, BuilderType>, BuilderType extends zzss<MessageType, BuilderType>> extends zzqz<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    public static final /* synthetic */ int zzd = 0;
    private int zze = -1;
    protected zzvf zzc = zzvf.zzc();

    public static zzsy zzC(Class cls) {
        Map map = zzb;
        zzsy zzsyVar = (zzsy) map.get(cls);
        if (zzsyVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzsyVar = (zzsy) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzsyVar != null) {
            return zzsyVar;
        }
        zzsy zzsyVar2 = (zzsy) ((zzsy) zzvl.zze(cls)).zzi(6, null, null);
        if (zzsyVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzsyVar2);
        return zzsyVar2;
    }

    public static zzsy zzE(zzsy zzsyVar, byte[] bArr, zzsj zzsjVar) throws zzti {
        zzsy zzsyVarZzd = zzd(zzsyVar, bArr, 0, bArr.length, zzsjVar);
        if (zzsyVarZzd == null || zzsyVarZzd.zzU()) {
            return zzsyVarZzd;
        }
        throw new zzvd(zzsyVarZzd).zza();
    }

    public static zztc zzF() {
        return zzsz.zzf();
    }

    public static zztf zzG() {
        return zzun.zze();
    }

    public static zztf zzH(zztf zztfVar) {
        int size = zztfVar.size();
        return zztfVar.zzd(size == 0 ? 10 : size + size);
    }

    public static Object zzJ(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzK(zzue zzueVar, String str, Object[] objArr) {
        return new zzuo(zzueVar, str, objArr);
    }

    public static void zzN(Class cls, zzsy zzsyVar) {
        zzsyVar.zzM();
        zzb.put(cls, zzsyVar);
    }

    public static final boolean zzP(zzsy zzsyVar, boolean z) {
        byte bByteValue = ((Byte) zzsyVar.zzi(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzum.zza().zzb(zzsyVar.getClass()).zzl(zzsyVar);
        if (z) {
            zzsyVar.zzi(2, true != zZzl ? null : zzsyVar, null);
        }
        return zZzl;
    }

    private final int zzc(zzuq zzuqVar) {
        return zzum.zza().zzb(getClass()).zza(this);
    }

    private static zzsy zzd(zzsy zzsyVar, byte[] bArr, int i, int i2, zzsj zzsjVar) throws zzti {
        if (i2 == 0) {
            return zzsyVar;
        }
        zzsy zzsyVarZzD = zzsyVar.zzD();
        try {
            zzuq zzuqVarZzb = zzum.zza().zzb(zzsyVarZzD.getClass());
            zzuqVarZzb.zzi(zzsyVarZzD, bArr, 0, i2, new zzre(zzsjVar));
            zzuqVarZzb.zzf(zzsyVarZzD);
            return zzsyVarZzD;
        } catch (zzti e) {
            if (e.zzk()) {
                throw new zzti(e);
            }
            throw e;
        } catch (zzvd e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzti) {
                throw ((zzti) e3.getCause());
            }
            throw new zzti(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw zzti.zzi();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzum.zza().zzb(getClass()).zzk(this, (zzsy) obj);
    }

    public final int hashCode() {
        if (zzQ()) {
            return zzy();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzy = zzy();
        this.zza = iZzy;
        return iZzy;
    }

    public final String toString() {
        return zzug.zza(this, super.toString());
    }

    public final zzss zzA() {
        return (zzss) zzi(5, null, null);
    }

    public final zzss zzB() {
        zzss zzssVar = (zzss) zzi(5, null, null);
        zzssVar.zzj(this);
        return zzssVar;
    }

    public final zzsy zzD() {
        return (zzsy) zzi(4, null, null);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzue
    public final zzul zzI() {
        return (zzul) zzi(7, null, null);
    }

    public final void zzL() {
        zzum.zza().zzb(getClass()).zzf(this);
        zzM();
    }

    public final void zzM() {
        this.zze &= Integer.MAX_VALUE;
    }

    public final void zzO(int i) {
        this.zze = (this.zze & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzQ() {
        return (this.zze & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzue
    public final /* synthetic */ zzud zzR() {
        return (zzss) zzi(5, null, null);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzue
    public final void zzS(zzsb zzsbVar) {
        zzum.zza().zzb(getClass()).zzj(this, zzsc.zza(zzsbVar));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuf
    public final /* synthetic */ zzue zzT() {
        return (zzsy) zzi(6, null, null);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuf
    public final boolean zzU() {
        return zzP(this, true);
    }

    public abstract Object zzi(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.meet_coactivities.zzqz
    public final int zzv(zzuq zzuqVar) {
        if (zzQ()) {
            int iZza = zzuqVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(AbstractC0000a.m11h(iZza, "serialized size must be non-negative, was "));
        }
        int i = this.zze & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzuqVar.zza(this);
        if (iZza2 < 0) {
            throw new IllegalStateException(AbstractC0000a.m11h(iZza2, "serialized size must be non-negative, was "));
        }
        this.zze = (this.zze & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    public final int zzy() {
        return zzum.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzue
    public final int zzz() {
        if (zzQ()) {
            int iZzc = zzc(null);
            if (iZzc >= 0) {
                return iZzc;
            }
            throw new IllegalStateException(AbstractC0000a.m11h(iZzc, "serialized size must be non-negative, was "));
        }
        int i = this.zze & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZzc2 = zzc(null);
        if (iZzc2 < 0) {
            throw new IllegalStateException(AbstractC0000a.m11h(iZzc2, "serialized size must be non-negative, was "));
        }
        this.zze = (this.zze & Integer.MIN_VALUE) | iZzc2;
        return iZzc2;
    }
}
