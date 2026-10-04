package com.samsung.android.support.senl.p148nt.composer.main.cover.model;

import android.graphics.drawable.Drawable;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverStickerData {
    private Drawable mDrawable;
    private final int mIndex;
    private String mPath;
    private final String mUuid;

    public CoverStickerData(String str) {
        this.mUuid = str;
        this.mIndex = CoverStickerUtils.getStickerIndex(str);
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void setDrawable(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public void setPath(String str) {
        this.mPath = str;
    }
}
