package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.sdk.composer.listener.SpenThumbnailChangeListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ThumbnailChangeListenerImpl implements SpenThumbnailChangeListener {
    private static final String TAG = Logger.createTag("ThumbnailChangeListenerImpl");
    private final ListenerImplContract.IPresenter mPresenter;

    public ThumbnailChangeListenerImpl(ListenerImplContract.IPresenter iPresenter) {
        this.mPresenter = iPresenter;
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenThumbnailChangeListener
    public void onThumbnailChanged(int i) {
        AbstractC0000a.m3D(i, "onThumbnailChanged# ", TAG);
        this.mPresenter.getThumbnailUpdateHandler().updateThumbnail(i);
    }
}
