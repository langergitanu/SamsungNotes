package androidx.glance.appwidget;

import android.os.Bundle;
import androidx.glance.session.SessionManagerScope;
import com.sun.imageio.plugins.jpeg.JPEG;
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
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidget$resize$2", m14021f = "GlanceAppWidget.kt", m14022i = {}, m14023l = {JPEG.APP5}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class GlanceAppWidget$resize$2 extends SuspendLambda implements Function3<SessionManagerScope, AppWidgetSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $options;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceAppWidget$resize$2(Bundle bundle, Continuation<? super GlanceAppWidget$resize$2> continuation) {
        super(3, continuation);
        this.$options = bundle;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @NotNull AppWidgetSession appWidgetSession, @Nullable Continuation<? super Unit> continuation) {
        GlanceAppWidget$resize$2 glanceAppWidget$resize$2 = new GlanceAppWidget$resize$2(this.$options, continuation);
        glanceAppWidget$resize$2.L$0 = appWidgetSession;
        return glanceAppWidget$resize$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AppWidgetSession appWidgetSession = (AppWidgetSession) this.L$0;
            Bundle bundle = this.$options;
            this.label = 1;
            if (appWidgetSession.updateAppWidgetOptions(bundle, this) == coroutine_suspended) {
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
