package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageLayoutStatePhone extends PageLayoutState {
    public PageLayoutStatePhone(PageLayoutState.Contract contract) {
        super(contract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState
    public void setLandscapeState() {
        super.setLandscapeState();
        syncSettingData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState
    public void setPortraitState() {
        super.setPortraitState();
        if (isTwoPage()) {
            this.mColumn = 1;
        }
        updateFitToScreen();
    }
}
