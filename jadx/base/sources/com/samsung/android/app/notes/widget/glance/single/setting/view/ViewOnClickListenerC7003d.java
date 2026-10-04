package com.samsung.android.app.notes.widget.glance.single.setting.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.single.setting.view.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnClickListenerC7003d implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4713a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetSingleGlanceSettingView f4714b;

    public /* synthetic */ ViewOnClickListenerC7003d(WidgetSingleGlanceSettingView widgetSingleGlanceSettingView, int i) {
        this.f4713a = i;
        this.f4714b = widgetSingleGlanceSettingView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4713a) {
            case 0:
                WidgetSingleGlanceSettingView.initChange$lambda$2(this.f4714b, view);
                break;
            default:
                WidgetSingleGlanceSettingView.initBackgroundOnOff$lambda$10(this.f4714b, view);
                break;
        }
    }
}
