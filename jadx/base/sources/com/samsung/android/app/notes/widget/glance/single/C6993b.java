package com.samsung.android.app.notes.widget.glance.single;

import android.content.Context;
import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview;
import com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.single.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6993b implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4642a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetSingleGlanceTheme f4643b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f4644c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f4645d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f4646e;

    public /* synthetic */ C6993b(WidgetSingleGlance widgetSingleGlance, Context context, WidgetSingleGlanceTheme widgetSingleGlanceTheme, int i) {
        this.f4645d = widgetSingleGlance;
        this.f4646e = context;
        this.f4643b = widgetSingleGlanceTheme;
        this.f4644c = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4642a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetSingleGlance.WidgetLoading$lambda$11((WidgetSingleGlance) this.f4645d, (Context) this.f4646e, this.f4643b, this.f4644c, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetSingleGlanceSettingPreview.TextContentWidgetTemplate$lambda$12((WidgetSingleGlanceSettingPreview) this.f4645d, this.f4643b, (String) this.f4646e, this.f4644c, (Composer) obj, iIntValue2);
        }
    }

    public /* synthetic */ C6993b(WidgetSingleGlanceSettingPreview widgetSingleGlanceSettingPreview, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i) {
        this.f4645d = widgetSingleGlanceSettingPreview;
        this.f4643b = widgetSingleGlanceTheme;
        this.f4646e = str;
        this.f4644c = i;
    }
}
