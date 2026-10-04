package com.samsung.android.support.senl.p148nt.composer.main.base.model.mde;

import android.app.Activity;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.CoeditAdapter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class EmptyCoeditController implements CoeditAdapter.ICoeditController {
    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void checkDeleteOnlyMode() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void clearCoeditCallback() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public String getWorkspaceId() {
        return "";
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void internalChannelOpen(SpenWNote spenWNote, CoeditAdapter.ActionCallback actionCallback) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void internalSnapRefresh() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void internalSnapRestart(String str, CoeditAdapter.ActionCallback actionCallback, CoeditAdapter.ActionCallback actionCallback2) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void internalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, CoeditAdapter.ActionCallback actionCallback, CoeditHandlerManager.Contract contract) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public boolean isCoeditMode() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public boolean isWritePermissionGranted() {
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public int pauseConcurrency(String str, CoeditAdapter.PauseTimeoutCallback pauseTimeoutCallback) {
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void readyCoedit(Activity activity, String str) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void requestReadPermission() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public int resumeConcurrency(String str) {
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void saveCoeditCache() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public void trimMemory(int i) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ICoeditController
    public boolean waitConnection(CoeditAdapter.ConnectionCallback connectionCallback) {
        return false;
    }
}
