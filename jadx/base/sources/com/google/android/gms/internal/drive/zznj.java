package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
final class zznj extends IllegalArgumentException {
    public zznj(int i, int i2) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
        super(sb.toString());
    }
}
