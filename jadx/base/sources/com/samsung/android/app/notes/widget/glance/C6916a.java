package com.samsung.android.app.notes.widget.glance;

import androidx.compose.runtime.Composer;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import com.samsung.android.app.notes.widget.glance.list.WidgetListGlance;
import com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance;
import com.samsung.android.app.notes.widget.lockbrief.WidgetCreatorLockBrief;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6916a implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4491a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f4492b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ GlanceTemplateAppWidget f4493c;

    public /* synthetic */ C6916a(GlanceTemplateAppWidget glanceTemplateAppWidget, int i, int i2) {
        this.f4491a = i2;
        this.f4493c = glanceTemplateAppWidget;
        this.f4492b = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4491a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetCreator.TemplateContent$lambda$1((WidgetCreator) this.f4493c, this.f4492b, (Composer) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetListGlance.TemplateContent$lambda$0((WidgetListGlance) this.f4493c, this.f4492b, (Composer) obj, iIntValue2);
            case 2:
                int iIntValue3 = ((Integer) obj2).intValue();
                return WidgetSingleGlance.TemplateContent$lambda$0((WidgetSingleGlance) this.f4493c, this.f4492b, (Composer) obj, iIntValue3);
            default:
                int iIntValue4 = ((Integer) obj2).intValue();
                return WidgetCreatorLockBrief.TemplateContent$lambda$1((WidgetCreatorLockBrief) this.f4493c, this.f4492b, (Composer) obj, iIntValue4);
        }
    }
}
