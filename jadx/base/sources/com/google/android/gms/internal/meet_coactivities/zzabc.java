package com.google.android.gms.internal.meet_coactivities;

import androidx.compose.runtime.AbstractC1974b;
import com.google.common.base.Charsets;
import com.yubico.yubikit.core.fido.CtapException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzabc implements zzzu {
    private static final byte[] zza = {48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 65, 66, 67, 68, 69, 70};

    private zzabc() {
        throw null;
    }

    private static boolean zzb(byte b) {
        return b < 32 || b >= 126 || b == 37;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzu
    public final /* bridge */ /* synthetic */ byte[] zza(Object obj) {
        byte[] bytes = ((String) obj).getBytes(Charsets.UTF_8);
        int i = 0;
        while (true) {
            int length = bytes.length;
            if (i >= length) {
                return bytes;
            }
            if (zzb(bytes[i])) {
                byte[] bArr = new byte[AbstractC1974b.m1304A(length, i, 3, i)];
                if (i != 0) {
                    System.arraycopy(bytes, 0, bArr, 0, i);
                }
                int i2 = i;
                while (i < bytes.length) {
                    int i4 = i2 + 1;
                    byte b = bytes[i];
                    if (zzb(b)) {
                        bArr[i2] = 37;
                        byte[] bArr2 = zza;
                        bArr[i4] = bArr2[(b >> 4) & 15];
                        bArr[i2 + 2] = bArr2[b & 15];
                        i2 += 3;
                    } else {
                        bArr[i2] = b;
                        i2 = i4;
                    }
                    i++;
                }
                return Arrays.copyOf(bArr, i2);
            }
            i++;
        }
    }

    public /* synthetic */ zzabc(zzabb zzabbVar) {
    }
}
