package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.widget.CompoundButton;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8785i implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6309a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CompoundButton f6310b;

    public /* synthetic */ RunnableC8785i(CompoundButton compoundButton, int i) {
        this.f6309a = i;
        this.f6310b = compoundButton;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6309a) {
            case 0:
                SettingsSyncToMicrosoftPrefFragment.initLayout$lambda$2$lambda$1(this.f6310b);
                break;
            default:
                SettingsSyncWithSamsungAccountPrefFragment.initLayout$lambda$17$lambda$16$lambda$15(this.f6310b);
                break;
        }
    }
}
