package com.samsung.android.app.notes.widget.glance.list.setting.view;

import android.widget.CompoundButton;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingView;
import com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingView;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6958k implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4592a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f4593b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ BaseWidgetSettingView f4594c;

    public /* synthetic */ C6958k(BaseWidgetSettingView baseWidgetSettingView, String str, int i) {
        this.f4592a = i;
        this.f4594c = baseWidgetSettingView;
        this.f4593b = str;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.f4592a) {
            case 0:
                WidgetListGlanceSettingView.initBackgroundOnOff$lambda$6((WidgetListGlanceSettingView) this.f4594c, this.f4593b, compoundButton, z);
                break;
            case 1:
                WidgetCreatorSettingView.initBackgroundOnOff$lambda$0((WidgetCreatorSettingView) this.f4594c, this.f4593b, compoundButton, z);
                break;
            default:
                WidgetSingleGlanceSettingView.initBackgroundOnOff$lambda$9((WidgetSingleGlanceSettingView) this.f4594c, this.f4593b, compoundButton, z);
                break;
        }
    }
}
