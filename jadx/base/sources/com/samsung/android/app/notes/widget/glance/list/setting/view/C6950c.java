package com.samsung.android.app.notes.widget.glance.list.setting.view;

import androidx.compose.runtime.Composer;
import androidx.glance.oneui.template.TypedTextData;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6950c implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4559a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetListGlanceSettingPreview f4560b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ WidgetListGlanceTheme f4561c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ TypedTextData f4562d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4563e;

    public /* synthetic */ C6950c(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, TypedTextData typedTextData, int i, int i2) {
        this.f4559a = i2;
        this.f4560b = widgetListGlanceSettingPreview;
        this.f4561c = widgetListGlanceTheme;
        this.f4562d = typedTextData;
        this.f4563e = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4559a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetListGlanceSettingPreview.titleText$lambda$35(this.f4560b, this.f4561c, this.f4562d, this.f4563e, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetListGlanceSettingPreview.timeText$lambda$36(this.f4560b, this.f4561c, this.f4562d, this.f4563e, (Composer) obj, iIntValue2);
        }
    }
}
