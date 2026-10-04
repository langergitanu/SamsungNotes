package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.content.res.Configuration;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutStateFold;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutStatePhone;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.DocPageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CvPageSettingController {
    private static final String TAG = Logger.createTag("CvPageSettingController");
    private NoteManager mNoteManager;
    private PageLayoutState mPageLayoutState;
    private PageManager mPageManager;
    private DocumentPageRatio.PageRatioType mPageRatioType = DocumentPageRatio.PageRatioType.A4_PORTRAIT;
    private ComposerControllerContract mView;

    private PageLayoutState createPageLayoutState() {
        return ModelFeature.getFeature().isFoldableModel() ? new PageLayoutStateFold(createPageLayoutStateContract()) : new PageLayoutStatePhone(createPageLayoutStateContract());
    }

    private PageLayoutState.Contract createPageLayoutStateContract() {
        return new PageLayoutState.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.CvPageSettingController.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.page.PageLayoutState.Contract
            public DocPageInfo getDocPageInfo() {
                return CvPageSettingController.this.mPageManager.getDocPageInfo();
            }
        };
    }

    private void updateStateByOrientation(int i) {
        if (i == 2) {
            this.mPageLayoutState.setLandscapeState();
        } else {
            this.mPageLayoutState.setPortraitState();
        }
        updateView();
    }

    private void updateView() {
        Logger.m10999d(TAG, "updateView# " + this.mPageLayoutState);
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.setPageLayoutAll(this.mPageLayoutState.getColumn(), this.mPageLayoutState.getRow(), this.mPageLayoutState.isFitToScreen(), this.mPageLayoutState.isVertical());
        }
    }

    public PageLayoutState getPageLayoutState() {
        return this.mPageLayoutState;
    }

    public DocumentPageRatio.PageRatioType getPageRatioType() {
        return this.mPageRatioType;
    }

    public void init(PageManager pageManager, NoteManager noteManager) {
        this.mPageManager = pageManager;
        this.mNoteManager = noteManager;
        this.mPageLayoutState = createPageLayoutState();
    }

    public void onConfigurationChanged(Configuration configuration, boolean z) {
        boolean zIsSubDisplay = DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(configuration);
        int multiWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(configuration);
        boolean z2 = true;
        if (this.mPageLayoutState.isSubDisplay() != zIsSubDisplay) {
            this.mPageLayoutState.setSubDisplay(zIsSubDisplay);
            z = true;
        }
        if (this.mPageLayoutState.getWindowMode() != multiWindowMode) {
            this.mPageLayoutState.setWindowMode(multiWindowMode);
        } else {
            z2 = z;
        }
        if (z2) {
            updateStateByOrientation(configuration.orientation);
        }
    }

    public void setPageLayout(int i, int i2, boolean z) {
        Logger.m10999d(TAG, "setPageLayout# before# " + this.mPageLayoutState);
        this.mPageLayoutState.setPageLayout(i, i2, z);
        updateView();
    }

    public void setPageRatioType(DocumentPageRatio.PageRatioType pageRatioType) {
        Logger.m11003i(TAG, "setPageRatioType# " + pageRatioType + " before: " + this.mPageRatioType);
        if (this.mPageRatioType.equals(pageRatioType)) {
            return;
        }
        this.mPageRatioType = pageRatioType;
        this.mNoteManager.changePageHeight(pageRatioType);
    }

    public void setView(ComposerControllerContract composerControllerContract) {
        this.mView = composerControllerContract;
        if (composerControllerContract == null) {
            return;
        }
        Configuration configuration = composerControllerContract.getView().getResources().getConfiguration();
        boolean zIsSubDisplay = DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(configuration);
        int multiWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(configuration);
        String str = TAG;
        StringBuilder sb = new StringBuilder("setView# ");
        sb.append(configuration.orientation);
        sb.append("/");
        sb.append(zIsSubDisplay);
        sb.append("/");
        AbstractC8014b.m7221w(sb, str, multiWindowMode);
        this.mPageLayoutState.setSubDisplay(zIsSubDisplay);
        this.mPageLayoutState.setOrientation(configuration.orientation);
        this.mPageLayoutState.setWindowMode(multiWindowMode);
        this.mPageLayoutState.syncSettingData();
        updateStateByOrientation(configuration.orientation);
    }

    public void updatePageLayoutByPageType(boolean z) {
        if (z) {
            this.mPageManager.getDocPageInfo().loadPageLayoutDefaultForSingle();
        } else {
            this.mPageManager.getDocPageInfo().loadPageLayoutSetting();
        }
        this.mPageLayoutState.syncSettingData();
        updateView();
    }
}
