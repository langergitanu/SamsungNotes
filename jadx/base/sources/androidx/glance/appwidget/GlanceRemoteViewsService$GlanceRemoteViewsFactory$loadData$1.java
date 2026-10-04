package androidx.glance.appwidget;

import androidx.glance.appwidget.GlanceRemoteViewsService;
import androidx.glance.oneui.common.GlanceLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1", m14021f = "GlanceRemoteViewsService.kt", m14022i = {}, m14023l = {115}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GlanceRemoteViewsService.GlanceRemoteViewsFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1(GlanceRemoteViewsService.GlanceRemoteViewsFactory glanceRemoteViewsFactory, Continuation<? super GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = glanceRemoteViewsFactory;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppWidgetId appWidgetId = new AppWidgetId(this.this$0.appWidgetId);
                GlanceRemoteViewsService.GlanceRemoteViewsFactory glanceRemoteViewsFactory = this.this$0;
                this.label = 1;
                if (glanceRemoteViewsFactory.startSessionIfNeededAndWaitUntilReady(appWidgetId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (ClosedSendChannelException e) {
            GlanceLog.INSTANCE.m2300e(GlanceRemoteViewsService.TAG, "Error when trying to start session for list items", e);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
