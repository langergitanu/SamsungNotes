package com.samsung.android.app.notes.widget.glance.list.setting.view;

import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6951d implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4564a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetListGlanceSettingPreview f4565b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ WidgetListGlanceTheme f4566c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f4567d;

    public /* synthetic */ C6951d(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, int i, int i2) {
        this.f4564a = i2;
        this.f4565b = widgetListGlanceSettingPreview;
        this.f4566c = widgetListGlanceTheme;
        this.f4567d = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f4564a;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                return WidgetListGlanceSettingPreview.WidgetListSettingLoading$lambda$37(this.f4565b, this.f4566c, this.f4567d, composer, iIntValue);
            case 1:
                return WidgetListGlanceSettingPreview.WidgetListEmpty$lambda$2(this.f4565b, this.f4566c, this.f4567d, composer, iIntValue);
            default:
                return WidgetListGlanceSettingPreview.WidgetListExtraLargeCoverEmpty$lambda$19(this.f4565b, this.f4566c, this.f4567d, composer, iIntValue);
        }
    }
}
