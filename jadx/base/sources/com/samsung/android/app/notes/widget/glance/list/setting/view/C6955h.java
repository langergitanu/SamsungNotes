package com.samsung.android.app.notes.widget.glance.list.setting.view;

import com.samsung.android.app.notes.widget.glance.list.common.WidgetListGlanceItem;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6955h implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4582a;

    public /* synthetic */ C6955h(int i) {
        this.f4582a = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4582a) {
            case 0:
                return WidgetListGlanceSettingPreview.ComposeListItem$lambda$33$lambda$32$lambda$31$lambda$21(((Integer) obj).intValue(), (WidgetListGlanceItem) obj2);
            case 1:
                return Integer.valueOf(ComposerManager.closeComposerOverCount$lambda$1((ComposerManager.ComposerInfo) obj, (ComposerManager.ComposerInfo) obj2));
            case 2:
                return Integer.valueOf(ConvertSpenTextToSpannable.convertObjectSpan$lambda$0((SpenObjectSpan) obj, (SpenObjectSpan) obj2));
            case 3:
                return CombinedContext.toString$lambda$2((String) obj, (CoroutineContext.Element) obj2);
            case 4:
                return CoroutineContext.DefaultImpls.plus$lambda$0((CoroutineContext) obj, (CoroutineContext.Element) obj2);
            case 5:
                return Boolean.valueOf(CoroutineContextKt.hasCopyableElements$lambda$0(((Boolean) obj).booleanValue(), (CoroutineContext.Element) obj2));
            case 6:
                return CoroutineContextKt.foldCopies$lambda$2((CoroutineContext) obj, (CoroutineContext.Element) obj2);
            case 7:
                return ConcurrentWeakMap._get_keys_$lambda$0(obj, obj2);
            case 8:
                return ConcurrentWeakMap._get_entries_$lambda$1(obj, obj2);
            default:
                return Integer.valueOf(SafeCollector.collectContextSize$lambda$0(((Integer) obj).intValue(), (CoroutineContext.Element) obj2));
        }
    }
}
