package com.samsung.android.app.notes.widget.glance.setting.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.setting.view.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnClickListenerC6976c implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4625a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetCreatorSettingView f4626b;

    public /* synthetic */ ViewOnClickListenerC6976c(WidgetCreatorSettingView widgetCreatorSettingView, int i) {
        this.f4625a = i;
        this.f4626b = widgetCreatorSettingView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4625a) {
            case 0:
                WidgetCreatorSettingView.initBackgroundOnOff$lambda$1(this.f4626b, view);
                break;
            default:
                WidgetCreatorSettingView.initShortcutComponent$lambda$4(this.f4626b, view);
                break;
        }
    }
}
