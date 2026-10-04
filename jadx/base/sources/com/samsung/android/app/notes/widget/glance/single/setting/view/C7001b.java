package com.samsung.android.app.notes.widget.glance.single.setting.view;

import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.single.setting.view.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7001b implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4705a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetSingleGlanceSettingPreview f4706b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ WidgetSingleGlanceTheme f4707c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f4708d;

    public /* synthetic */ C7001b(WidgetSingleGlanceSettingPreview widgetSingleGlanceSettingPreview, WidgetSingleGlanceTheme widgetSingleGlanceTheme, int i, int i2) {
        this.f4705a = i2;
        this.f4706b = widgetSingleGlanceSettingPreview;
        this.f4707c = widgetSingleGlanceTheme;
        this.f4708d = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f4705a;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                return WidgetSingleGlanceSettingPreview.WidgetEmpty$lambda$14(this.f4706b, this.f4707c, this.f4708d, composer, iIntValue);
            default:
                return WidgetSingleGlanceSettingPreview.ViewMore$lambda$10(this.f4706b, this.f4707c, this.f4708d, composer, iIntValue);
        }
    }
}
