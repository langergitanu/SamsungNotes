package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.p130io.BaseEncoding;
import io.grpc.Metadata;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@NotThreadSafe
public final class zzzv {
    private Object[] zzd;
    private int zze;
    private static final Logger zzc = Logger.getLogger(zzzv.class.getName());
    public static final zzzo zza = new zzzl();
    static final BaseEncoding zzb = BaseEncoding.base64().omitPadding();

    public zzzv() {
    }

    private final int zzh() {
        Object[] objArr = this.zzd;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    private final Object zzi(int i) {
        return this.zzd[i + i + 1];
    }

    private final void zzj(int i) {
        Object[] objArr = new Object[i];
        if (!zzk()) {
            Object[] objArr2 = this.zzd;
            int i2 = this.zze;
            System.arraycopy(objArr2, 0, objArr, 0, i2 + i2);
        }
        this.zzd = objArr;
    }

    private final boolean zzk() {
        return this.zze == 0;
    }

    private final byte[] zzl(int i) {
        return (byte[]) this.zzd[i + i];
    }

    private final byte[] zzm(int i) {
        Object objZzi = zzi(i);
        if (objZzi instanceof byte[]) {
            return (byte[]) objZzi;
        }
        throw null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i = 0; i < this.zze; i++) {
            if (i != 0) {
                sb.append(',');
            }
            byte[] bArrZzl = zzl(i);
            Charset charset = Charsets.US_ASCII;
            String str = new String(bArrZzl, charset);
            sb.append(str);
            sb.append('=');
            if (str.endsWith(Metadata.BINARY_HEADER_SUFFIX)) {
                sb.append(zzb.encode(zzm(i)));
            } else {
                sb.append(new String(zzm(i), charset));
            }
        }
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }

    public final int zza() {
        return this.zze;
    }

    @Nullable
    public final Object zzb(zzzq zzzqVar) {
        int i = this.zze;
        do {
            i--;
            if (i < 0) {
                return null;
            }
        } while (!Arrays.equals(zzzqVar.zzd(), zzl(i)));
        Object objZzi = zzi(i);
        if (objZzi instanceof byte[]) {
            return zzzqVar.zza((byte[]) objZzi);
        }
        throw null;
    }

    public final void zzd(zzzq zzzqVar) {
        if (zzk()) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            int i4 = this.zze;
            if (i >= i4) {
                Arrays.fill(this.zzd, i2 + i2, i4 + i4, (Object) null);
                this.zze = i2;
                return;
            }
            if (!Arrays.equals(zzzqVar.zzd(), zzl(i))) {
                int i5 = i2 + i2;
                this.zzd[i5] = zzl(i);
                Object objZzi = zzi(i);
                if (this.zzd instanceof byte[][]) {
                    zzj(zzh());
                }
                this.zzd[i5 + 1] = objZzi;
                i2++;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zze(zzzv zzzvVar) {
        if (zzzvVar.zzk()) {
            return;
        }
        int iZzh = zzh();
        int i = this.zze;
        int i2 = i + i;
        int i4 = iZzh - i2;
        if (!zzk()) {
            int i5 = zzzvVar.zze;
            if (i4 < i5 + i5) {
                int i6 = zzzvVar.zze;
                zzj(i6 + i6 + i2);
            }
        }
        Object[] objArr = zzzvVar.zzd;
        Object[] objArr2 = this.zzd;
        int i7 = this.zze;
        int i8 = zzzvVar.zze;
        System.arraycopy(objArr, 0, objArr2, i7 + i7, i8 + i8);
        this.zze += zzzvVar.zze;
    }

    public final void zzf(zzzq zzzqVar, Object obj) {
        Preconditions.checkNotNull(zzzqVar, "key");
        Preconditions.checkNotNull(obj, "value");
        int i = this.zze;
        int i2 = i + i;
        if (i2 == 0 || i2 == zzh()) {
            zzj(Math.max(i2 + i2, 8));
        }
        int i4 = this.zze;
        this.zzd[i4 + i4] = zzzqVar.zzd();
        int i5 = this.zze;
        this.zzd[i5 + i5 + 1] = zzzqVar.zzb(obj);
        this.zze++;
    }

    @Nullable
    public final Object[] zzg() {
        int i = this.zze;
        Object[] objArr = new Object[i + i];
        for (int i2 = 0; i2 < this.zze; i2++) {
            int i4 = i2 + i2;
            objArr[i4] = zzl(i2);
            Object objZzi = zzi(i2);
            if (!(objZzi instanceof byte[])) {
                throw null;
            }
            objArr[i4 + 1] = objZzi;
        }
        return objArr;
    }

    public zzzv(int i, Object[] objArr) {
        this.zze = i;
        this.zzd = objArr;
    }
}
