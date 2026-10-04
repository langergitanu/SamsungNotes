package com.samsung.android.support.senl.p148nt.coedit.control;

import android.app.Activity;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler;
import com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class EmptyCoeditHandler implements ICoeditHandler {
    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void checkDeleteOnlyMode() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void externalChannelOpen(SpenWNote spenWNote, String str, String str2, ExternalControlCallback externalControlCallback) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void externalSnapDownload(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void externalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void externalSnapUpload(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public int getState() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public CoeditConstants.User getUser() {
        return CoeditConstants.User.Unknown;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public String getUuid() {
        return "";
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void initialize(String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void internalChannelOpen(Activity activity, SpenWNote spenWNote, String str, String str2, CoeditControlCallback coeditControlCallback) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void internalSnapRefresh() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void internalSnapRestart(String str, SnapControlCallback snapControlCallback, CoeditControlCallback coeditControlCallback) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void internalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, SnapControlCallback snapControlCallback, ICoeditHandler.ComposerContract composerContract) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler, com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public boolean isClosingState() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public boolean isInitializing() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public boolean isSnapEndState() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public boolean isWritePermissionGranted() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public int pauseConcurrency(String str) {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void release(Runnable runnable, Runnable runnable2, String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void requestReadPermission() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public int resumeConcurrency(String str) {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void saveCoeditCache() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void setCancelled() {
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public int pauseConcurrency(String str, Runnable runnable) {
        return 0;
    }
}
