package com.samsung.android.app.notes.widget.glance.list;

import android.content.Context;
import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6937c implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4514a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetListGlance f4515b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Context f4516c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f4517d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ WidgetListGlanceTheme f4518e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ String f4519f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ int f4520g;

    public /* synthetic */ C6937c(WidgetListGlance widgetListGlance, Context context, int i, WidgetListGlanceTheme widgetListGlanceTheme, String str, int i2, int i4) {
        this.f4514a = i4;
        this.f4515b = widgetListGlance;
        this.f4516c = context;
        this.f4517d = i;
        this.f4518e = widgetListGlanceTheme;
        this.f4519f = str;
        this.f4520g = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4514a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetListGlance.WidgetListExtraLargeCoverEmpty$lambda$7(this.f4515b, this.f4516c, this.f4517d, this.f4518e, this.f4519f, this.f4520g, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetListGlance.WidgetEmptySmall$lambda$6(this.f4515b, this.f4516c, this.f4517d, this.f4518e, this.f4519f, this.f4520g, (Composer) obj, iIntValue2);
        }
    }
}
