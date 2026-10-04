package androidx.glance.appwidget;

import android.content.Context;
import androidx.glance.oneui.common.GlanceLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$onUpdate$1$1$1", m14021f = "GlanceAppWidgetReceiver.kt", m14022i = {}, m14023l = {111}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class GlanceAppWidgetReceiver$onUpdate$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int[] $appWidgetIds;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $it;
    int label;
    final /* synthetic */ GlanceAppWidgetReceiver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceAppWidgetReceiver$onUpdate$1$1$1(GlanceAppWidgetReceiver glanceAppWidgetReceiver, Context context, int i, int[] iArr, Continuation<? super GlanceAppWidgetReceiver$onUpdate$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = glanceAppWidgetReceiver;
        this.$context = context;
        this.$it = i;
        this.$appWidgetIds = iArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlanceAppWidgetReceiver$onUpdate$1$1$1(this.this$0, this.$context, this.$it, this.$appWidgetIds, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        GlanceAppWidgetReceiver$onUpdate$1$1$1 glanceAppWidgetReceiver$onUpdate$1$1$1;
        Exception exc;
        GlanceAppWidget glanceAppWidget;
        Context context;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                glanceAppWidget = this.this$0.getGlanceAppWidget();
                context = this.$context;
                i = this.$it;
                this.label = 1;
                glanceAppWidgetReceiver$onUpdate$1$1$1 = this;
            } catch (Exception e) {
                e = e;
                glanceAppWidgetReceiver$onUpdate$1$1$1 = this;
            }
            try {
                if (GlanceAppWidget.update$glance_appwidget_release$default(glanceAppWidget, context, i, null, glanceAppWidgetReceiver$onUpdate$1$1$1, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception e2) {
                e = e2;
                exc = e;
                String string = !(exc instanceof IllegalArgumentException) ? "Invalid AppWidgetId Error" : exc.toString();
                GlanceLog.INSTANCE.m2299e("GWT:AppWidgetReceiver", string + " / AppWidgetProvider : " + glanceAppWidgetReceiver$onUpdate$1$1$1.this$0.getClass() + " AppWidgetIds : {" + ArraysKt___ArraysKt.joinToString$default(glanceAppWidgetReceiver$onUpdate$1$1$1.$appWidgetIds, (CharSequence) ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "}");
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e3) {
                exc = e3;
                glanceAppWidgetReceiver$onUpdate$1$1$1 = this;
                if (!(exc instanceof IllegalArgumentException)) {
                }
                GlanceLog.INSTANCE.m2299e("GWT:AppWidgetReceiver", string + " / AppWidgetProvider : " + glanceAppWidgetReceiver$onUpdate$1$1$1.this$0.getClass() + " AppWidgetIds : {" + ArraysKt___ArraysKt.joinToString$default(glanceAppWidgetReceiver$onUpdate$1$1$1.$appWidgetIds, (CharSequence) ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "}");
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlanceAppWidgetReceiver$onUpdate$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
