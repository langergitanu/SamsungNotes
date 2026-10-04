package com.samsung.android.support.senl.p148nt.base.common.data;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TemplateItem implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean mBase;
    private String mDrawablePath;
    private int mDrawableResId;
    private int mDynamicIndex;
    private int mDynamicType;
    private boolean mExpand;
    private int mHeight;
    private int mLoadItemIndex;
    private int mMode;
    private String mName;
    private int mPageCount;
    private String mPath;
    private List<Uri> mPdfUris;
    private boolean mSelected;
    private int mType;
    private String mUuid;
    private int mWidth;

    public TemplateItem(int i, int i2, String str, String str2, int i4) {
        this(i, i2, str, str2, i4, true);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TemplateItem)) {
            return false;
        }
        TemplateItem templateItem = (TemplateItem) obj;
        if (this.mType == templateItem.mType && this.mName.equals(templateItem.mName) && this.mPath.equals(templateItem.mPath) && this.mDynamicType == templateItem.mDynamicType && this.mDynamicIndex == templateItem.mDynamicIndex) {
            return true;
        }
        return super.equals(obj);
    }

    public String getDrawablePath() {
        return this.mDrawablePath;
    }

    public int getDrawableResId() {
        return this.mDrawableResId;
    }

    public int getDynamicIndex() {
        return this.mDynamicIndex;
    }

    public int getDynamicType() {
        return this.mDynamicType;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getLoadItemIndex() {
        return this.mLoadItemIndex;
    }

    public int getMode() {
        return this.mMode;
    }

    public String getName() {
        return this.mName;
    }

    public int getPageCount() {
        return this.mPageCount;
    }

    public String getPath() {
        return this.mPath;
    }

    public List<Uri> getPdfUris() {
        return this.mPdfUris;
    }

    public boolean getSelected() {
        return this.mSelected;
    }

    public int getType() {
        return this.mType;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isBase() {
        return this.mBase;
    }

    public boolean isExpanded() {
        return this.mExpand;
    }

    public void setDrawablePath(String str) {
        this.mDrawablePath = str;
    }

    public void setDrawableResId(int i) {
        this.mDrawableResId = i;
    }

    public void setExpand(boolean z) {
        this.mExpand = z;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setMode(int i) {
        if (this.mBase && i == 1) {
            return;
        }
        this.mMode = i;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPageCount(int i) {
        this.mPageCount = i;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setPdfUris(List<Uri> list, int i) {
        this.mPdfUris = list;
        this.mLoadItemIndex = i;
    }

    public void setSelected(boolean z) {
        this.mSelected = z;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public TemplateItem(int i, int i2, String str, String str2, int i4, boolean z) {
        this(i, i2, str, "", str2, null, i4, z, 0, 0);
    }

    public TemplateItem(int i, int i2, String str, String str2, String str3, boolean z) {
        this(i, i2, str, "", str2, str3, -1, z, 0, 0);
    }

    public TemplateItem(int i, int i2, String str, String str2, String str3, String str4, boolean z) {
        this(i, i2, str, str2, str3, str4, -1, z, 0, 0);
    }

    public TemplateItem(int i, String str) {
        this(i, 0, str, (String) null, -1, true);
    }

    public TemplateItem(int i, int i2, int i4, String str, int i5) {
        this(i, 0, str, (String) null, i5, true);
        this.mDynamicType = i2;
        this.mDynamicIndex = i4;
    }

    public TemplateItem(int i, int i2, String str, String str2, String str3, String str4, int i4, boolean z, int i5, int i6) {
        this.mSelected = false;
        this.mType = i;
        this.mMode = i2;
        this.mName = str;
        this.mUuid = str2;
        this.mPath = str3;
        this.mDrawablePath = str4;
        this.mDrawableResId = i4;
        this.mBase = z;
        this.mWidth = i5;
        this.mHeight = i6;
    }
}
