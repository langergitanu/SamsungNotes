package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo;

import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9870a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7020a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ StickyMemoView f7021b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ StickyMemoManager f7022c;

    public /* synthetic */ RunnableC9870a(StickyMemoView stickyMemoView, StickyMemoManager stickyMemoManager) {
        this.f7021b = stickyMemoView;
        this.f7022c = stickyMemoManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7020a) {
            case 0:
                StickyMemoManager.detachMemoView$lambda$23(this.f7022c, this.f7021b);
                break;
            default:
                StickyMemoManager.releaseMemoView$lambda$21(this.f7021b, this.f7022c);
                break;
        }
    }

    public /* synthetic */ RunnableC9870a(StickyMemoManager stickyMemoManager, StickyMemoView stickyMemoView) {
        this.f7022c = stickyMemoManager;
        this.f7021b = stickyMemoView;
    }
}
