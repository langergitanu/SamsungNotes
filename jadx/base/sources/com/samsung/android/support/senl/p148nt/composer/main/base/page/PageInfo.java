package com.samsung.android.support.senl.p148nt.composer.main.base.page;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean mDirty;
    private int mHeight;
    private String mPageId;
    private int mPageIndex;
    private long mPageModifiedTime;
    private float mRatio;
    private transient long mThumbnailCreatedTime;
    private String mThumbnailFilePath;
    private transient Integer mThumbnailHeight;
    private transient float mThumbnailRatio;
    private transient Integer mThumbnailWidth;
    private int mWidth;

    public PageInfo(int i, int i2, int i4, String str) {
        this.mRatio = -1.0f;
        this.mDirty = false;
        this.mThumbnailWidth = null;
        this.mThumbnailHeight = null;
        this.mThumbnailCreatedTime = 0L;
        this.mPageIndex = i;
        this.mWidth = i2;
        this.mHeight = i4;
        this.mRatio = calcRatio(i2, i4);
        this.mPageId = str;
    }

    private static float calcRatio(int i, int i2) {
        if (i2 == 0 || i == 0) {
            return 1.0f;
        }
        return i2 / i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getPageId() {
        return this.mPageId;
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public long getPageModifiedTime() {
        return this.mPageModifiedTime;
    }

    public float getRatio() {
        return this.mRatio;
    }

    public long getThumbnailCreatedTime() {
        return this.mThumbnailCreatedTime;
    }

    public String getThumbnailFilePath() {
        return this.mThumbnailFilePath;
    }

    public int getThumbnailHeight() {
        if (this.mThumbnailHeight == null) {
            this.mThumbnailHeight = Integer.valueOf((int) (this.mThumbnailRatio * this.mHeight));
        }
        return this.mThumbnailHeight.intValue();
    }

    public int getThumbnailWidth() {
        if (this.mThumbnailWidth == null) {
            this.mThumbnailWidth = Integer.valueOf((int) (this.mThumbnailRatio * this.mWidth));
        }
        return this.mThumbnailWidth.intValue();
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isDirty() {
        return this.mDirty;
    }

    public void setDirty(boolean z) {
        this.mDirty = z;
    }

    public void setPageId(String str) {
        this.mPageId = str;
    }

    public void setPageIndex(int i) {
        this.mPageIndex = i;
    }

    public void setPageModifiedTime(long j) {
        this.mPageModifiedTime = j;
    }

    public void setThumbnailFilePath(String str) {
        this.mThumbnailFilePath = str;
        this.mThumbnailCreatedTime = System.currentTimeMillis();
    }

    public void setThumbnailRatio(float f) {
        this.mThumbnailRatio = f;
    }

    @NonNull
    public String toString() {
        return "index: " + this.mPageIndex + " w: " + this.mWidth + " h: " + this.mHeight + " r: " + this.mRatio + " path : " + this.mThumbnailFilePath + " dirty: " + this.mDirty + " page Id: " + this.mPageId + " modifiedTime: " + this.mPageModifiedTime;
    }

    public PageInfo(int i, int i2, int i4, String str, String str2, boolean z, long j) {
        this(i, i2, i4, calcRatio(i2, i4), str, str2, z, j);
    }

    private PageInfo(int i, int i2, int i4, float f, String str, String str2, boolean z, long j) {
        this.mThumbnailWidth = null;
        this.mThumbnailHeight = null;
        this.mThumbnailCreatedTime = 0L;
        this.mPageIndex = i;
        this.mWidth = i2;
        this.mHeight = i4;
        this.mRatio = f;
        this.mThumbnailFilePath = str;
        this.mPageId = str2;
        this.mDirty = z;
        this.mPageModifiedTime = j;
    }
}
