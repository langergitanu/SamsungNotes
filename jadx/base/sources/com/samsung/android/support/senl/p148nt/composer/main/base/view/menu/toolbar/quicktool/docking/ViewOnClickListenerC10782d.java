package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10782d implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7251a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingQTPenLayout f7252b;

    public /* synthetic */ ViewOnClickListenerC10782d(SettingQTPenLayout settingQTPenLayout, int i) {
        this.f7251a = i;
        this.f7252b = settingQTPenLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7251a) {
            case 0:
                SettingQTPenLayout.initView$lambda$0(this.f7252b, view);
                break;
            case 1:
                SettingQTPenLayout.initView$lambda$2$lambda$1(this.f7252b, view);
                break;
            case 2:
                SettingQTPenLayout.initView$lambda$4$lambda$3(this.f7252b, view);
                break;
            default:
                SettingQTPenLayout.setupEyedropperItem$lambda$6$lambda$5(this.f7252b, view);
                break;
        }
    }
}
