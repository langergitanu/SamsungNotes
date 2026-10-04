package com.samsung.android.app.notes.widget.glance.list.setting.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnClickListenerC6959l implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4595a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetListGlanceSettingView f4596b;

    public /* synthetic */ ViewOnClickListenerC6959l(WidgetListGlanceSettingView widgetListGlanceSettingView, int i) {
        this.f4595a = i;
        this.f4596b = widgetListGlanceSettingView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4595a) {
            case 0:
                WidgetListGlanceSettingView.initBackgroundOnOff$lambda$7(this.f4596b, view);
                break;
            default:
                WidgetListGlanceSettingView.initSettingListGlance$lambda$5(this.f4596b, view);
                break;
        }
    }
}
