package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.inapp.view.setting.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnClickListenerC8077a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6106a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InAppSettingTextModeLayout f6107b;

    public /* synthetic */ ViewOnClickListenerC8077a(InAppSettingTextModeLayout inAppSettingTextModeLayout, int i) {
        this.f6106a = i;
        this.f6107b = inAppSettingTextModeLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6106a) {
            case 0:
                InAppSettingTextModeLayout.initColorPicker$lambda$3(this.f6107b, view);
                break;
            case 1:
                InAppSettingTextModeLayout.initColorPicker$lambda$5(this.f6107b, view);
                break;
            default:
                InAppSettingTextModeLayout.initColorSetting$lambda$1(this.f6107b, view);
                break;
        }
    }
}
