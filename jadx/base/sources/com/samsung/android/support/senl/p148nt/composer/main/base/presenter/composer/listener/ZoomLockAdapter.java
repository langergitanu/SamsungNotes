package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.sdk.composer.listener.SpenNoteDeltaZoomListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ZoomLockAdapter extends SpenNoteDeltaZoomListener {
    @Override // com.samsung.android.sdk.composer.listener.SpenNoteDeltaZoomListener
    public void onMovementLockedChanged(boolean z) {
        super.onMovementLockedChanged(z);
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenNoteDeltaZoomListener
    public void onZoomableChanged(boolean z) {
        super.onZoomableChanged(z);
    }
}
