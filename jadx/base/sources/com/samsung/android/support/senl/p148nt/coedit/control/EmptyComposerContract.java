package com.samsung.android.support.senl.p148nt.coedit.control;

import com.samsung.android.support.senl.ntnl.coedit.CoeditDeviceInfo;
import com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class EmptyComposerContract implements ICoeditHandler.ComposerContract {
    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public boolean canShowProgress() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public String getWorkspaceId() {
        return "";
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public int getXmlDataWeight() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public void hideInitProgress(String str) {
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public boolean hideProgress(String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public boolean isCoeditUpdateListenerNonNull() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public boolean isDeleteOnlyMode() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public boolean isEditMode() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public boolean isEditModeWithReadOnly() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public boolean isFixedReadPermission() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public void onClickCloseComposer() {
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public void onEditorUpdate(String str, String str2) {
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public void onListUpdate(List<CoeditDeviceInfo> list) {
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public void requestReopen(String str, boolean z, String str2) {
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public void requestSaveToDevice(int i) {
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public void setDeleteOnlyMode(boolean z) {
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public void setFixedReadPermission(boolean z, String str) {
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public void setRequestUpdate(boolean z) {
    }

    @Override // com.samsung.android.support.senl.nt.coedit.control.ICoeditHandler.ComposerContract
    public boolean showProgress(String str) {
        return false;
    }
}
