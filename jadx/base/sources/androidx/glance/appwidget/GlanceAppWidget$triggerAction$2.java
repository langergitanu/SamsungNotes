package androidx.glance.appwidget;

import androidx.glance.session.SessionManagerScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;", "session", "Landroidx/glance/appwidget/AppWidgetSession;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidget$triggerAction$2", m14021f = "GlanceAppWidget.kt", m14022i = {}, m14023l = {202}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class GlanceAppWidget$triggerAction$2 extends SuspendLambda implements Function3<SessionManagerScope, AppWidgetSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionKey;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceAppWidget$triggerAction$2(String str, Continuation<? super GlanceAppWidget$triggerAction$2> continuation) {
        super(3, continuation);
        this.$actionKey = str;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @NotNull AppWidgetSession appWidgetSession, @Nullable Continuation<? super Unit> continuation) {
        GlanceAppWidget$triggerAction$2 glanceAppWidget$triggerAction$2 = new GlanceAppWidget$triggerAction$2(this.$actionKey, continuation);
        glanceAppWidget$triggerAction$2.L$0 = appWidgetSession;
        return glanceAppWidget$triggerAction$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AppWidgetSession appWidgetSession = (AppWidgetSession) this.L$0;
            String str = this.$actionKey;
            this.label = 1;
            if (appWidgetSession.runLambda(str, this) == coroutine_suspended) {
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
