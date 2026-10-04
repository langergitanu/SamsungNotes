package com.samsung.android.app.notes.widget.glance.list.setting.view;

import androidx.compose.runtime.Composer;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingPreview;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6953f implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4573a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ long f4574b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f4575c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f4576d;

    public /* synthetic */ C6953f(Object obj, long j, int i, int i2) {
        this.f4573a = i2;
        this.f4576d = obj;
        this.f4574b = j;
        this.f4575c = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4573a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return WidgetListGlanceSettingPreview.setContent$lambda$1((WidgetListGlanceSettingPreview) this.f4576d, this.f4574b, this.f4575c, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return WidgetCreatorSettingPreview.setContent$lambda$1((WidgetCreatorSettingPreview) this.f4576d, this.f4574b, this.f4575c, (Composer) obj, iIntValue2);
        }
    }
}
