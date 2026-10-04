package com.google.android.gms.internal.fido;

import java.io.IOException;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzch {
    private static final zzch zza = new zzcf("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzch zzb = new zzcf("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzch zzc = new zzcg("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final zzch zzd = new zzcg("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final zzch zze = new zzce("base16()", BinTools.hex);

    public static zzch zzf() {
        return zze;
    }

    public abstract void zzb(Appendable appendable, byte[] bArr, int i, int i2);

    public abstract int zzc(int i);

    public abstract zzch zzd();

    public final String zzg(byte[] bArr, int i, int i2) {
        zzap.zze(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zzc(i2));
        try {
            zzb(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
