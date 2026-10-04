package com.samsung.android.sdk.pen.setting.quicktool;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPatternLayout;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.quicktool.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7661m implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5104a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f5105b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f5106c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f5107d;

    public /* synthetic */ RunnableC7661m(int i, int i2, Object obj, boolean z) {
        this.f5104a = i2;
        this.f5107d = obj;
        this.f5106c = i;
        this.f5105b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5104a) {
            case 0:
                SpenSettingQTPatternLayout.startItemAnimation$lambda$2$lambda$1(this.f5105b, this.f5106c, (SpenSettingQTPatternLayout) this.f5107d);
                break;
            case 1:
                SettingsSyncWithSamsungAccountPrefFragment.updateSyncNow$lambda$22((SettingsSyncWithSamsungAccountPrefFragment) this.f5107d, this.f5105b, this.f5106c);
                break;
            case 2:
                ((ComposerViewPresenter) this.f5107d).lambda$hideProgress$7(this.f5106c, this.f5105b);
                break;
            case 3:
                ((AiContextMenuPresenter) this.f5107d).lambda$show$0(this.f5106c, this.f5105b);
                break;
            default:
                SettingQTPatternLayout.startItemAnimation$lambda$2$lambda$1(this.f5105b, this.f5106c, (SettingQTPatternLayout) this.f5107d);
                break;
        }
    }

    public /* synthetic */ RunnableC7661m(SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment, boolean z, int i) {
        this.f5104a = 1;
        this.f5107d = settingsSyncWithSamsungAccountPrefFragment;
        this.f5105b = z;
        this.f5106c = i;
    }

    public /* synthetic */ RunnableC7661m(boolean z, int i, ConstraintLayout constraintLayout, int i2) {
        this.f5104a = i2;
        this.f5105b = z;
        this.f5106c = i;
        this.f5107d = constraintLayout;
    }
}
