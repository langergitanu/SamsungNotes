package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: loaded from: classes5.dex */
final class zzjh extends zzjm {
    private final int zznv;
    private final int zznw;

    public zzjh(byte[] bArr, int i, int i2) {
        super(bArr);
        zzjc.zzb(i, i + i2, bArr.length);
        this.zznv = i;
        this.zznw = i2;
    }

    @Override // com.google.android.gms.internal.drive.zzjm, com.google.android.gms.internal.drive.zzjc
    public final int size() {
        return this.zznw;
    }

    @Override // com.google.android.gms.internal.drive.zzjm
    public final int zzbw() {
        return this.zznv;
    }

    @Override // com.google.android.gms.internal.drive.zzjm, com.google.android.gms.internal.drive.zzjc
    public final byte zzs(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzny[this.zznv + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC4539a.m3197g(22, i, "Index < 0: "));
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append("Index > length: ");
        sb.append(i);
        sb.append(SQLKeyword.COMMA);
        sb.append(size);
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }

    @Override // com.google.android.gms.internal.drive.zzjm, com.google.android.gms.internal.drive.zzjc
    public final byte zzt(int i) {
        return this.zzny[this.zznv + i];
    }
}
