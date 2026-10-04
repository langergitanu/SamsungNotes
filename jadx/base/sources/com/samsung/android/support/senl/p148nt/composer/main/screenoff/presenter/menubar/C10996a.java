package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.scroll.ScrollPresenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10996a implements SpenZoomListenerImpl.ZoomListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7345a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7346b;

    public /* synthetic */ C10996a(Object obj, int i) {
        this.f7345a = i;
        this.f7346b = obj;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl.ZoomListener
    public final void onZoom(float f, float f4, float f5, float f6, float f7) {
        switch (this.f7345a) {
            case 0:
                MenuBarPresenter.makeZoomListener$lambda$0((MenuBarPresenter) this.f7346b, f, f4, f5, f6, f7);
                break;
            default:
                ScrollPresenter.makeZoomListener$lambda$1((ScrollPresenter) this.f7346b, f, f4, f5, f6, f7);
                break;
        }
    }
}
