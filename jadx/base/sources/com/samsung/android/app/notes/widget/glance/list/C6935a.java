package com.samsung.android.app.notes.widget.glance.list;

import android.content.Context;
import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6935a implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4500a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetListGlance f4501b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Context f4502c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f4503d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4504e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ WidgetListGlanceTheme f4505f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ String f4506g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ int f4507h;

    public /* synthetic */ C6935a(WidgetListGlance widgetListGlance, Context context, int i, int i2, WidgetListGlanceTheme widgetListGlanceTheme, String str, int i4, int i5) {
        this.f4500a = i5;
        this.f4501b = widgetListGlance;
        this.f4502c = context;
        this.f4503d = i;
        this.f4504e = i2;
        this.f4505f = widgetListGlanceTheme;
        this.f4506g = str;
        this.f4507h = i4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4500a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetListGlance.WidgetListEmpty_gaecCbA$lambda$4(this.f4501b, this.f4502c, this.f4503d, this.f4504e, this.f4505f, this.f4506g, this.f4507h, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetListGlance.WidgetEmptyMedium_gaecCbA$lambda$5(this.f4501b, this.f4502c, this.f4503d, this.f4504e, this.f4505f, this.f4506g, this.f4507h, (Composer) obj, iIntValue2);
        }
    }
}
