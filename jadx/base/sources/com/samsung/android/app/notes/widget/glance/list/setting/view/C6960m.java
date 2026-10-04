package com.samsung.android.app.notes.widget.glance.list.setting.view;

import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingBgShapeView;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingView;
import com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceBgShapeView;
import com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingView;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6960m implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4597a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f4598b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ BaseWidgetSettingView f4599c;

    public /* synthetic */ C6960m(BaseWidgetSettingView baseWidgetSettingView, int i, int i2) {
        this.f4597a = i2;
        this.f4599c = baseWidgetSettingView;
        this.f4598b = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f4597a) {
            case 0:
                return WidgetListGlanceSettingView.initSettingBackgroundShape$lambda$4$lambda$3$lambda$2((WidgetListGlanceSettingView) this.f4599c, this.f4598b, (WidgetListGlanceSettingBgShapeView) obj);
            case 1:
                return WidgetCreatorSettingView.initSettingBackgroundShape$lambda$7$lambda$6$lambda$5((WidgetCreatorSettingView) this.f4599c, this.f4598b, (WidgetCreatorSettingBgShapeView) obj);
            default:
                return WidgetSingleGlanceSettingView.initSettingBackgroundShape$lambda$7$lambda$6$lambda$5((WidgetSingleGlanceSettingView) this.f4599c, this.f4598b, (WidgetSingleGlanceBgShapeView) obj);
        }
    }
}
