package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerViewContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCVListenerManager {
    private SCVActionListenerImpl mSCVActionListener;
    private final SCVScrollZoomController mScrollZoomController;
    private SimpleComposerViewContract.IView mView;

    public SCVListenerManager(SCVScrollZoomController sCVScrollZoomController) {
        this.mScrollZoomController = sCVScrollZoomController;
    }

    public void init(SimpleComposerViewContract.IView iView) {
        this.mView = iView;
        SCVActionListenerImpl sCVActionListenerImpl = new SCVActionListenerImpl(this.mScrollZoomController);
        this.mSCVActionListener = sCVActionListenerImpl;
        this.mView.setActionListener(sCVActionListenerImpl);
    }

    public void release() {
        this.mView.setActionListener(null);
    }
}
