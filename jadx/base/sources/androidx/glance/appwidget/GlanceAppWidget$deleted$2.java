package androidx.glance.appwidget;

import androidx.glance.session.SessionManagerScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidget$deleted$2", m14021f = "GlanceAppWidget.kt", m14022i = {}, m14023l = {135}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class GlanceAppWidget$deleted$2 extends SuspendLambda implements Function2<SessionManagerScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppWidgetId $glanceId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceAppWidget$deleted$2(AppWidgetId appWidgetId, Continuation<? super GlanceAppWidget$deleted$2> continuation) {
        super(2, continuation);
        this.$glanceId = appWidgetId;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlanceAppWidget$deleted$2 glanceAppWidget$deleted$2 = new GlanceAppWidget$deleted$2(this.$glanceId, continuation);
        glanceAppWidget$deleted$2.L$0 = obj;
        return glanceAppWidget$deleted$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlanceAppWidget$deleted$2) create(sessionManagerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SessionManagerScope sessionManagerScope = (SessionManagerScope) this.L$0;
            String sessionKey = AppWidgetUtilsKt.toSessionKey(this.$glanceId);
            this.label = 1;
            if (sessionManagerScope.closeSession(sessionKey, this) == coroutine_suspended) {
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
}
