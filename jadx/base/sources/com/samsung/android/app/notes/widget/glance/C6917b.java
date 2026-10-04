package com.samsung.android.app.notes.widget.glance;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance;
import com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6917b implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4494a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f4495b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f4496c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f4497d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ GlanceTemplateAppWidget f4498e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f4499f;

    public /* synthetic */ C6917b(GlanceTemplateAppWidget glanceTemplateAppWidget, Context context, int i, Object obj, int i2, int i4) {
        this.f4494a = i4;
        this.f4498e = glanceTemplateAppWidget;
        this.f4495b = context;
        this.f4496c = i;
        this.f4499f = obj;
        this.f4497d = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4494a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetCreator.GridContent$lambda$2((WidgetCreator) this.f4498e, this.f4495b, this.f4496c, (List) this.f4499f, this.f4497d, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetSingleGlance.WidgetConvertDoc$lambda$10((WidgetSingleGlance) this.f4498e, this.f4495b, this.f4496c, (WidgetSingleGlanceTheme) this.f4499f, this.f4497d, (Composer) obj, iIntValue2);
        }
    }
}
