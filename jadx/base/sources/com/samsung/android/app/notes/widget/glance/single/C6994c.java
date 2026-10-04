package com.samsung.android.app.notes.widget.glance.single;

import android.content.Context;
import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.single.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6994c implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4647a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetSingleGlance f4648b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Context f4649c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f4650d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4651e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ WidgetSingleGlanceTheme f4652f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ String f4653g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ int f4654h;

    public /* synthetic */ C6994c(WidgetSingleGlance widgetSingleGlance, Context context, int i, int i2, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i4, int i5) {
        this.f4647a = i5;
        this.f4648b = widgetSingleGlance;
        this.f4649c = context;
        this.f4650d = i;
        this.f4651e = i2;
        this.f4652f = widgetSingleGlanceTheme;
        this.f4653g = str;
        this.f4654h = i4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4647a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetSingleGlance.WidgetEmpty_gaecCbA$lambda$12(this.f4648b, this.f4649c, this.f4650d, this.f4651e, this.f4652f, this.f4653g, this.f4654h, (Composer) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetSingleGlance.WidgetSingleExtraLargeCoverEmpty_gaecCbA$lambda$13(this.f4648b, this.f4649c, this.f4650d, this.f4651e, this.f4652f, this.f4653g, this.f4654h, (Composer) obj, iIntValue2);
            default:
                int iIntValue3 = ((Integer) obj2).intValue();
                return WidgetSingleGlance.WidgetEmptyMedium_gaecCbA$lambda$14(this.f4648b, this.f4649c, this.f4650d, this.f4651e, this.f4652f, this.f4653g, this.f4654h, (Composer) obj, iIntValue3);
        }
    }
}
