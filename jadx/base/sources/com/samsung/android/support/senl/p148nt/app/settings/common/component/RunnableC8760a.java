package com.samsung.android.support.senl.p148nt.app.settings.common.component;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.common.component.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8760a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6286a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingsBaseFragment f6287b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f6288c;

    public /* synthetic */ RunnableC8760a(SettingsBaseFragment settingsBaseFragment, View view, int i) {
        this.f6286a = i;
        this.f6287b = settingsBaseFragment;
        this.f6288c = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6286a) {
            case 0:
                SettingsBaseFragment.updateListForVst$lambda$4$lambda$3(this.f6287b, this.f6288c);
                break;
            default:
                SettingsBaseFragment.updateListForMobile$lambda$6$lambda$5(this.f6287b, this.f6288c);
                break;
        }
    }
}
