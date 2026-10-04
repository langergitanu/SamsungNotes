package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.C5131a;
import com.google.android.play.core.tasks.AbstractC5346j;

/* JADX INFO: loaded from: classes5.dex */
public class AssetPackException extends AbstractC5346j {

    /* JADX INFO: renamed from: a */
    @AssetPackErrorCode
    private final int f2498a;

    public AssetPackException(@AssetPackErrorCode int i) {
        super(String.format("Asset Pack Download Error(%d): %s", Integer.valueOf(i), C5131a.m3845a(i)));
        if (i == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
        this.f2498a = i;
    }

    @Override // com.google.android.play.core.tasks.AbstractC5346j
    @AssetPackErrorCode
    public int getErrorCode() {
        return this.f2498a;
    }
}
