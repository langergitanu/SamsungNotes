package com.samsung.android.app.notes.widget.glance.setting.view;

import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorAdapter;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.setting.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC6974a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4620a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetCreatorAdapter.WidgetCreatorListViewHolder f4621b;

    public /* synthetic */ RunnableC6974a(WidgetCreatorAdapter.WidgetCreatorListViewHolder widgetCreatorListViewHolder, int i) {
        this.f4620a = i;
        this.f4621b = widgetCreatorListViewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4620a) {
            case 0:
                WidgetCreatorAdapter.onBindViewHolder$lambda$1$lambda$0(this.f4621b);
                break;
            default:
                WidgetCreatorAdapter.onBindViewHolder$lambda$3$lambda$2(this.f4621b);
                break;
        }
    }
}
