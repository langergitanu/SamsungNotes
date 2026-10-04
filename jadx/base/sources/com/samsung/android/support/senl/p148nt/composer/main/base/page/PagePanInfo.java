package com.samsung.android.support.senl.p148nt.composer.main.base.page;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.util.SpenPagePan;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PagePanInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private float mContentPanX;
    private float mContentPanY;
    private int mPageIndex;
    private float mPagePanX;
    private float mPagePanY;

    public PagePanInfo() {
        this.mContentPanX = 0.0f;
        this.mContentPanY = 0.0f;
        this.mPageIndex = 0;
        this.mPagePanX = 0.0f;
        this.mPagePanY = 0.0f;
    }

    public static PagePanInfo convertToPagePan(PointF pointF, SpenPagePan spenPagePan) {
        return new PagePanInfo(pointF, spenPagePan.pageIndex, spenPagePan.pan);
    }

    public static SpenPagePan convertToSpenPagePan(PagePanInfo pagePanInfo) {
        SpenPagePan spenPagePan = new SpenPagePan();
        spenPagePan.pageIndex = pagePanInfo.getPageIndex();
        spenPagePan.pan = pagePanInfo.getPan();
        return spenPagePan;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PagePanInfo)) {
            return false;
        }
        PagePanInfo pagePanInfo = (PagePanInfo) obj;
        return this.mContentPanX == pagePanInfo.mContentPanX && this.mContentPanY == pagePanInfo.mContentPanY && this.mPageIndex == pagePanInfo.mPageIndex && this.mPagePanX == pagePanInfo.mPagePanX && this.mPagePanY == pagePanInfo.mPagePanY;
    }

    public float getContentPanX() {
        return this.mContentPanX;
    }

    public float getContentPanY() {
        return this.mContentPanY;
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public PointF getPan() {
        return new PointF(this.mPagePanX, this.mPagePanY);
    }

    @NonNull
    public String toString() {
        return "contentPan.x " + this.mContentPanX + " contentPan.y " + this.mContentPanY + " index: " + this.mPageIndex + " mPan.x " + this.mPagePanX + " mPan.y " + this.mPagePanY;
    }

    public PagePanInfo(PointF pointF, int i, PointF pointF2) {
        this.mContentPanX = pointF.x;
        this.mContentPanY = pointF.y;
        this.mPageIndex = i;
        this.mPagePanX = pointF2.x;
        this.mPagePanY = pointF2.y;
    }
}
