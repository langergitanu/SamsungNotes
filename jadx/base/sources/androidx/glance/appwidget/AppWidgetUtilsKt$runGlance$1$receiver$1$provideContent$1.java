package androidx.glance.appwidget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1", m14021f = "AppWidgetUtils.kt", m14022i = {0}, m14023l = {332}, m14024m = "provideContent", m14025n = {"content"}, m14026s = {"L$0"})
public final class AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppWidgetUtilsKt$runGlance$1$receiver$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1(AppWidgetUtilsKt$runGlance$1$receiver$1 appWidgetUtilsKt$runGlance$1$receiver$1, Continuation<? super AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1> continuation) {
        super(continuation);
        this.this$0 = appWidgetUtilsKt$runGlance$1$receiver$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.provideContent(null, this);
    }
}
