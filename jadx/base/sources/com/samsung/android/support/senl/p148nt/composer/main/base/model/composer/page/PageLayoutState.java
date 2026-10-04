package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page;

import com.samsung.android.support.senl.p148nt.composer.main.base.page.DocPageInfo;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PageLayoutState {
    protected Contract mContract;
    protected int mOrientation;
    protected int mColumn = 1;
    protected int mRow = 1;
    protected boolean mFitToScreen = false;
    protected boolean mVertical = true;
    protected boolean mSubDisplay = false;
    protected int mWindowMode = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        DocPageInfo getDocPageInfo();
    }

    public PageLayoutState(Contract contract) {
        this.mContract = contract;
    }

    public int getColumn() {
        return this.mColumn;
    }

    public int getRow() {
        return this.mRow;
    }

    public int getWindowMode() {
        return this.mWindowMode;
    }

    public boolean isColumnRestrictionCase(int i) {
        return this.mOrientation == 1 && i > 1;
    }

    public boolean isFitToScreen() {
        return this.mFitToScreen;
    }

    public boolean isFullWindowMode() {
        return this.mWindowMode == 0;
    }

    public boolean isSubDisplay() {
        return this.mSubDisplay;
    }

    public boolean isTwoPage() {
        return this.mColumn == 2;
    }

    public boolean isTwoPageEnabled(boolean z) {
        return this.mOrientation == 2;
    }

    public boolean isVertical() {
        return this.mVertical;
    }

    public boolean isVerticalRestrictionCase(int i, boolean z) {
        return z && i > 1;
    }

    public void setLandscapeState() {
        setOrientation(2);
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setPageLayout(int i, int i2, boolean z) {
        if (isColumnRestrictionCase(i) || isVerticalRestrictionCase(i, z)) {
            return;
        }
        DocPageInfo docPageInfo = this.mContract.getDocPageInfo();
        docPageInfo.setPageLayoutColumn(i);
        docPageInfo.setPageLayoutRow(i2);
        docPageInfo.setPageLayoutFitToScreen(!z);
        docPageInfo.setScrollVertical(z);
        syncSettingData();
    }

    public void setPortraitState() {
        setOrientation(1);
    }

    public void setScrollVertical(boolean z) {
        DocPageInfo docPageInfo = this.mContract.getDocPageInfo();
        docPageInfo.setScrollVertical(z);
        docPageInfo.setPageLayoutFitToScreen(!z);
        if (z) {
            docPageInfo.setPageLayoutColumn(1);
        }
        syncSettingData();
    }

    public void setSubDisplay(boolean z) {
        this.mSubDisplay = z;
    }

    public void setTwoPage(boolean z) {
        DocPageInfo docPageInfo = this.mContract.getDocPageInfo();
        if (z) {
            docPageInfo.setPageLayoutColumn(2);
        } else {
            docPageInfo.setPageLayoutColumn(1);
        }
        syncSettingData();
    }

    public void setWindowMode(int i) {
        this.mWindowMode = i;
    }

    public void syncSettingData() {
        DocPageInfo docPageInfo = this.mContract.getDocPageInfo();
        this.mColumn = docPageInfo.getPageLayoutColumn();
        this.mRow = docPageInfo.getPageLayoutRow();
        this.mVertical = docPageInfo.isScrollVertical();
        this.mFitToScreen = docPageInfo.isPageLayoutFitToScreen();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PageLayoutState{, mColumn=");
        sb.append(this.mColumn);
        sb.append(", mRow=");
        sb.append(this.mRow);
        sb.append(", mFitToScreen=");
        sb.append(this.mFitToScreen);
        sb.append(", mVertical=");
        sb.append(this.mVertical);
        sb.append(", mOrientation=");
        sb.append(this.mOrientation);
        sb.append(", mSubDisplay=");
        sb.append(this.mSubDisplay);
        sb.append(", mWindowMode=");
        return AbstractC0000a.m13j(sb, this.mWindowMode, '}');
    }

    public void updateFitToScreen() {
        this.mFitToScreen = !isVertical();
    }
}
