package androidx.glance.appwidget;

import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidget", m14021f = "GlanceAppWidget.kt", m14022i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6}, m14023l = {132, 134, 139, 146, 146, 146, 146}, m14024m = "deleted$glance_appwidget_release", m14025n = {"this", "context", "glanceId", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "this", "context", "glanceId", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "this", "context", "glanceId", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "context", "glanceId", "context", "glanceId", "context", "glanceId", "context", "glanceId"}, m14026s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class GlanceAppWidget$deleted$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GlanceAppWidget this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceAppWidget$deleted$1(GlanceAppWidget glanceAppWidget, Continuation<? super GlanceAppWidget$deleted$1> continuation) {
        super(continuation);
        this.this$0 = glanceAppWidget;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deleted$glance_appwidget_release(null, 0, this);
    }
}
