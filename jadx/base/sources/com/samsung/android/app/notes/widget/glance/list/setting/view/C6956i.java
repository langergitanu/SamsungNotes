package com.samsung.android.app.notes.widget.glance.list.setting.view;

import android.content.Context;
import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6956i implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4583a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetListGlanceSettingPreview f4584b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Context f4585c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ WidgetListGlanceTheme f4586d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4587e;

    public /* synthetic */ C6956i(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, Context context, WidgetListGlanceTheme widgetListGlanceTheme, int i, int i2) {
        this.f4583a = i2;
        this.f4584b = widgetListGlanceSettingPreview;
        this.f4585c = context;
        this.f4586d = widgetListGlanceTheme;
        this.f4587e = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4583a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetListGlanceSettingPreview.WidgetEmptyMedium$lambda$10(this.f4584b, this.f4585c, this.f4586d, this.f4587e, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetListGlanceSettingPreview.WidgetEmptySmall$lambda$16(this.f4584b, this.f4585c, this.f4586d, this.f4587e, (Composer) obj, iIntValue2);
        }
    }
}
