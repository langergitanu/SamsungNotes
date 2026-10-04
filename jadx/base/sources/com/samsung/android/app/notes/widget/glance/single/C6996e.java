package com.samsung.android.app.notes.widget.glance.single;

import android.content.Context;
import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.single.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6996e implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4669a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetSingleGlance f4670b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Context f4671c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f4672d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ WidgetSingleGlanceTheme f4673e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ String f4674f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ int f4675g;

    public /* synthetic */ C6996e(WidgetSingleGlance widgetSingleGlance, Context context, int i, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i2, int i4) {
        this.f4669a = i4;
        this.f4670b = widgetSingleGlance;
        this.f4671c = context;
        this.f4672d = i;
        this.f4673e = widgetSingleGlanceTheme;
        this.f4674f = str;
        this.f4675g = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4669a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetSingleGlance.WidgetEmptySmall$lambda$15(this.f4670b, this.f4671c, this.f4672d, this.f4673e, this.f4674f, this.f4675g, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetSingleGlance.ViewMore$lambda$8(this.f4670b, this.f4671c, this.f4672d, this.f4673e, this.f4674f, this.f4675g, (Composer) obj, iIntValue2);
        }
    }
}
