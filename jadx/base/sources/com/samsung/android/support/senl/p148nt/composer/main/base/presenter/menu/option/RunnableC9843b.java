package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9843b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7007a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ OptionMenuBackPresenter f7008b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Activity f7009c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ boolean f7010d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ String f7011e;

    public /* synthetic */ RunnableC9843b(OptionMenuBackPresenter optionMenuBackPresenter, Activity activity, boolean z, String str, int i) {
        this.f7007a = i;
        this.f7008b = optionMenuBackPresenter;
        this.f7009c = activity;
        this.f7010d = z;
        this.f7011e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7007a) {
            case 0:
                this.f7008b.lambda$saveOnEditMode$0(this.f7009c, this.f7010d, this.f7011e);
                break;
            default:
                this.f7008b.lambda$saveOnManualSave$1(this.f7009c, this.f7010d, this.f7011e);
                break;
        }
    }
}
