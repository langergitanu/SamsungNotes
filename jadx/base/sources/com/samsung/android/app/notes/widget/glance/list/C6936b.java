package com.samsung.android.app.notes.widget.glance.list;

import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.Composer;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance;
import com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6936b implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4508a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ GlanceTemplateAppWidget f4509b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4510c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f4511d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f4512e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f4513f;

    public /* synthetic */ C6936b(GlanceTemplateAppWidget glanceTemplateAppWidget, Object obj, Object obj2, Object obj3, int i, int i2) {
        this.f4508a = i2;
        this.f4509b = glanceTemplateAppWidget;
        this.f4510c = obj;
        this.f4511d = obj2;
        this.f4512e = obj3;
        this.f4513f = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4508a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetListGlance.ListTempCustom$lambda$2((WidgetListGlance) this.f4509b, (WidgetListGlanceTheme) this.f4510c, (List) this.f4511d, (String) this.f4512e, this.f4513f, (Composer) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetListGlance.ListTemp$lambda$1((WidgetListGlance) this.f4509b, (WidgetListGlanceTheme) this.f4510c, (List) this.f4511d, (String) this.f4512e, this.f4513f, (Composer) obj, iIntValue2);
            default:
                int iIntValue3 = ((Integer) obj2).intValue();
                return WidgetSingleGlance.ViewMore$lambda$9((WidgetSingleGlance) this.f4509b, (Context) this.f4510c, (WidgetSingleGlanceTheme) this.f4511d, (Intent) this.f4512e, this.f4513f, (Composer) obj, iIntValue3);
        }
    }
}
