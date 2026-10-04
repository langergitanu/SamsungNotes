package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.addons.brush.viewmodel.menu.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7966a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5710a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SubMenuLayoutViewModel f5711b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f5712c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ boolean f5713d;

    public /* synthetic */ RunnableC7966a(SubMenuLayoutViewModel subMenuLayoutViewModel, View view, boolean z, int i) {
        this.f5710a = i;
        this.f5711b = subMenuLayoutViewModel;
        this.f5712c = view;
        this.f5713d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5710a) {
            case 0:
                SubMenuLayoutViewModel.setLayoutMarginStart$lambda$1(this.f5711b, this.f5712c, this.f5713d);
                break;
            default:
                SubMenuLayoutViewModel.setLayoutMarginEnd$lambda$2(this.f5711b, this.f5712c, this.f5713d);
                break;
        }
    }
}
