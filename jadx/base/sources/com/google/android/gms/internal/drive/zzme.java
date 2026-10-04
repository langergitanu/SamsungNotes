package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

/* JADX INFO: loaded from: classes5.dex */
final class zzme implements zzlo {
    private final int flags;
    private final String info;
    private final Object[] zzue;
    private final zzlq zzuh;

    public zzme(zzlq zzlqVar, String str, Object[] objArr) {
        this.zzuh = zzlqVar;
        this.info = str;
        this.zzue = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.flags = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.flags = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.drive.zzlo
    public final int zzec() {
        return (this.flags & 1) == 1 ? zzkk.zze.zzsf : zzkk.zze.zzsg;
    }

    @Override // com.google.android.gms.internal.drive.zzlo
    public final boolean zzed() {
        return (this.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.drive.zzlo
    public final zzlq zzee() {
        return this.zzuh;
    }

    public final String zzek() {
        return this.info;
    }

    public final Object[] zzel() {
        return this.zzue;
    }
}
