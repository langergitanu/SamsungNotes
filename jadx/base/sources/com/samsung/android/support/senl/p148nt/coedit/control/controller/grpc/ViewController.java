package com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc;

import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ViewController implements ViewControllerContract {
    private ViewControllerContract mViewContract;

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract
    public void handleDeviceListChange(String str) {
        this.mViewContract.handleDeviceListChange(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract
    public void onEditorUpdate(String str, String str2) {
        this.mViewContract.onEditorUpdate(str, str2);
    }

    public void releaseGrpcContract() {
        this.mViewContract = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract
    public void saveUndownloadedStrokeInfo(String str, String str2) {
        this.mViewContract.saveUndownloadedStrokeInfo(str, str2);
    }

    public void setGrpcContract(ViewControllerContract viewControllerContract) {
        this.mViewContract = viewControllerContract;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract
    public void showToast(String str) {
        this.mViewContract.showToast(str);
    }
}
