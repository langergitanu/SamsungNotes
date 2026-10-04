package com.samsung.android.support.senl.p148nt.composer.main.base.model.info;

import androidx.glance.AbstractC2821a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DragAndDropInfo {
    private boolean mEnable = false;
    private int mShadowViewHeight;
    private int mShadowViewWidth;

    public void clear() {
        this.mEnable = false;
        this.mShadowViewWidth = 0;
        this.mShadowViewHeight = 0;
    }

    public int getShadowViewHeight() {
        return this.mShadowViewHeight;
    }

    public int getShadowViewWidth() {
        return this.mShadowViewWidth;
    }

    public boolean isEnabled() {
        return this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void setShadowViewHeight(int i) {
        this.mShadowViewHeight = i;
    }

    public void setShadowViewWidth(int i) {
        this.mShadowViewWidth = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DragAndDropInfo{mEnable=");
        sb.append(this.mEnable);
        sb.append("'mShadowViewWidth=");
        sb.append(this.mShadowViewWidth);
        sb.append("'mShadowViewHeight=");
        return AbstractC2821a.m2223n(sb, "'}", this.mShadowViewHeight);
    }
}
