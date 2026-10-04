package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageLayoutStateFold extends PageLayoutState {
    public PageLayoutStateFold(PageLayoutState.Contract contract) {
        super(contract);
    }

    private boolean isColumnRestrictionWindowMode() {
        return (isFullWindowMode() || this.mOrientation == 2) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState
    public boolean isColumnRestrictionCase(int i) {
        return ((this.mOrientation == 1 && this.mSubDisplay) || isColumnRestrictionWindowMode()) && i > 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState
    public boolean isTwoPageEnabled(boolean z) {
        if (this.mSubDisplay || !z) {
            return super.isTwoPageEnabled(z);
        }
        return true;
    }

    public void setFoldLandscapeState() {
        syncSettingData();
    }

    public void setFoldPortraitState() {
        this.mColumn = 1;
        updateFitToScreen();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState
    public void setLandscapeState() {
        super.setLandscapeState();
        if (this.mSubDisplay) {
            setFoldLandscapeState();
        } else {
            syncSettingData();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState
    public void setPortraitState() {
        super.setPortraitState();
        if (this.mSubDisplay || !isFullWindowMode()) {
            setFoldPortraitState();
        } else {
            syncSettingData();
        }
    }
}
