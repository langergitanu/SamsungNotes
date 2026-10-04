package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.internal.C5224h;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AssetPackState {
    /* JADX INFO: renamed from: a */
    public static AssetPackState m3623a(Bundle bundle, String str, C5069bz c5069bz, InterfaceC5042az interfaceC5042az) {
        return m3624a(str, interfaceC5042az.mo3677a(bundle.getInt(C5224h.m3993a("status", str)), str), bundle.getInt(C5224h.m3993a("error_code", str)), bundle.getLong(C5224h.m3993a("bytes_downloaded", str)), bundle.getLong(C5224h.m3993a("total_bytes_to_download", str)), c5069bz.m3742b(str));
    }

    public abstract long bytesDownloaded();

    @AssetPackErrorCode
    public abstract int errorCode();

    public abstract String name();

    @AssetPackStatus
    public abstract int status();

    public abstract long totalBytesToDownload();

    public abstract int transferProgressPercentage();

    /* JADX INFO: renamed from: a */
    public static AssetPackState m3624a(@NonNull String str, @AssetPackStatus int i, @AssetPackErrorCode int i2, long j, long j2, double d) {
        return new C5051bh(str, i, i2, j, j2, (int) Math.rint(d * 100.0d));
    }
}
