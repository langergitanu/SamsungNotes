package androidx.glance.appwidget;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$onReceive$1$1", m14021f = "GlanceAppWidgetReceiver.kt", m14022i = {}, m14023l = {STBorder.INT_ZIG_ZAG_STITCH}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class GlanceAppWidgetReceiver$onReceive$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionKey;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $id;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GlanceAppWidgetReceiver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceAppWidgetReceiver$onReceive$1$1(GlanceAppWidgetReceiver glanceAppWidgetReceiver, Context context, int i, String str, Continuation<? super GlanceAppWidgetReceiver$onReceive$1$1> continuation) {
        super(2, continuation);
        this.this$0 = glanceAppWidgetReceiver;
        this.$context = context;
        this.$id = i;
        this.$actionKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlanceAppWidgetReceiver$onReceive$1$1 glanceAppWidgetReceiver$onReceive$1$1 = new GlanceAppWidgetReceiver$onReceive$1$1(this.this$0, this.$context, this.$id, this.$actionKey, continuation);
        glanceAppWidgetReceiver$onReceive$1$1.L$0 = obj;
        return glanceAppWidgetReceiver$onReceive$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.updateManager((CoroutineScope) this.L$0, this.$context);
            GlanceAppWidget glanceAppWidget = this.this$0.getGlanceAppWidget();
            Context context = this.$context;
            int i2 = this.$id;
            String str = this.$actionKey;
            this.label = 1;
            if (GlanceAppWidget.triggerAction$glance_appwidget_release$default(glanceAppWidget, context, i2, str, null, this, 8, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlanceAppWidgetReceiver$onReceive$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
