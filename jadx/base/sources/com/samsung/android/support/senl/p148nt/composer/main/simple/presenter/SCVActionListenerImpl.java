package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter;

import com.samsung.android.sdk.composer.listener.SpenComposerActionListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCVActionListenerImpl extends SpenComposerActionListener {
    SCVScrollZoomController mScrollZoomController;

    public SCVActionListenerImpl(SCVScrollZoomController sCVScrollZoomController) {
        this.mScrollZoomController = sCVScrollZoomController;
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onInitLayoutFinished() {
        this.mScrollZoomController.restoreLastPosition();
    }
}
