package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteInAppPresenter implements RemoteFunctionContract.TargetClassContract {
    private static final String TAG = "RemoteInAppPresenter";
    private String mClassName = TAG;
    private final RemoteFunctionContract.PresenterContract mRemoteFunctionPresenter;

    public RemoteInAppPresenter(RemoteFunctionContract.PresenterContract presenterContract) {
        this.mRemoteFunctionPresenter = presenterContract;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.TargetClassContract
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteReceiverFunctionName("initialize")
    @RemoteConstant.RemoteFunctionName("init")
    public void init() {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "init", new Object[0]);
    }

    @RemoteConstant.RemoteFunctionName("initialize")
    public void initialize() {
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "onThemeChanged", Boolean.FALSE);
    }

    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("onThemeChanged")
    public void onThemeChanged(boolean z) {
        Logger.m8702i(TAG, "onThemeChanged " + z);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "onThemeChanged", Boolean.valueOf(z));
    }
}
