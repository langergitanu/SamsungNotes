package com.samsung.android.app.notes.widget.glance.list.setting.view;

import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6954g implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4577a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ WidgetListGlanceSettingPreview f4578b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ WidgetListGlanceTheme f4579c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ List f4580d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4581e;

    public /* synthetic */ C6954g(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, List list, int i, int i2) {
        this.f4577a = i2;
        this.f4578b = widgetListGlanceSettingPreview;
        this.f4579c = widgetListGlanceTheme;
        this.f4580d = list;
        this.f4581e = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4577a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetListGlanceSettingPreview.ComposeListItem$lambda$34(this.f4578b, this.f4579c, this.f4580d, this.f4581e, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetListGlanceSettingPreview.ListCustom$lambda$20(this.f4578b, this.f4579c, this.f4580d, this.f4581e, (Composer) obj, iIntValue2);
        }
    }
}
