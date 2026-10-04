package com.samsung.android.app.notes.widget.glance.list;

import androidx.compose.runtime.Composer;
import androidx.glance.oneui.template.CustomListItem;
import com.samsung.android.app.notes.widget.glance.list.WidgetListGlance;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6941g implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4541a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetListGlance.WidgetListItem f4542b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4543c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f4544d;

    public /* synthetic */ C6941g(WidgetListGlance.WidgetListItem widgetListItem, Object obj, int i, int i2) {
        this.f4541a = i2;
        this.f4542b = widgetListItem;
        this.f4543c = obj;
        this.f4544d = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4541a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetListGlance.WidgetListItem.TimeTextTemplate$lambda$2(this.f4542b, (WidgetListGlanceTheme) this.f4543c, this.f4544d, (Composer) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetListGlance.WidgetListItem.TitleTextTemplate$lambda$1(this.f4542b, (WidgetListGlanceTheme) this.f4543c, this.f4544d, (Composer) obj, iIntValue2);
            default:
                int iIntValue3 = ((Integer) obj2).intValue();
                return WidgetListGlance.WidgetListItem.CustomContent$lambda$0(this.f4542b, (CustomListItem) this.f4543c, this.f4544d, (Composer) obj, iIntValue3);
        }
    }
}
