package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10781c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7242a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingQTLayout f7243b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ SettingQTLayout.AnimationType f7244c;

    public /* synthetic */ RunnableC10781c(SettingQTLayout settingQTLayout, SettingQTLayout.AnimationType animationType, int i) {
        this.f7242a = i;
        this.f7243b = settingQTLayout;
        this.f7244c = animationType;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7242a) {
            case 0:
                this.f7243b.endAnimation(this.f7244c);
                break;
            default:
                this.f7243b.endAnimation(this.f7244c);
                break;
        }
    }
}
