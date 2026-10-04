package androidx.glance.appwidget;

import android.content.Context;
import androidx.glance.appwidget.GlanceRemoteViewsService;
import androidx.glance.session.Session;
import androidx.glance.session.SessionManagerScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$startSessionIfNeededAndWaitUntilReady$job$1$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Landroidx/glance/session/SessionManagerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$startSessionIfNeededAndWaitUntilReady$job$1$1", m14021f = "GlanceRemoteViewsService.kt", m14022i = {0, 1}, m14023l = {134, 139, 141}, m14024m = "invokeSuspend", m14025n = {"$this$runWithLock", "$this$runWithLock"}, m14026s = {"L$0", "L$0"})
public final class C2867xda8a0f13 extends SuspendLambda implements Function2<SessionManagerScope, Continuation<? super Job>, Object> {
    final /* synthetic */ AppWidgetId $glanceId;
    final /* synthetic */ GlanceAppWidget $widget;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GlanceRemoteViewsService.GlanceRemoteViewsFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2867xda8a0f13(GlanceRemoteViewsService.GlanceRemoteViewsFactory glanceRemoteViewsFactory, AppWidgetId appWidgetId, GlanceAppWidget glanceAppWidget, Continuation<? super C2867xda8a0f13> continuation) {
        super(2, continuation);
        this.this$0 = glanceRemoteViewsFactory;
        this.$glanceId = appWidgetId;
        this.$widget = glanceAppWidget;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C2867xda8a0f13 c2867xda8a0f13 = new C2867xda8a0f13(this.this$0, this.$glanceId, this.$widget, continuation);
        c2867xda8a0f13.L$0 = obj;
        return c2867xda8a0f13;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @Nullable Continuation<? super Job> continuation) {
        return ((C2867xda8a0f13) create(sessionManagerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0099 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        SessionManagerScope sessionManagerScope;
        Object objIsSessionRunning;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sessionManagerScope = (SessionManagerScope) this.L$0;
            Context context = this.this$0.context;
            String sessionKey = AppWidgetUtilsKt.toSessionKey(this.$glanceId);
            this.L$0 = sessionManagerScope;
            this.label = 1;
            objIsSessionRunning = sessionManagerScope.isSessionRunning(context, sessionKey, this);
            if (objIsSessionRunning != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            sessionManagerScope = (SessionManagerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            Session session = sessionManagerScope.getSession(AppWidgetUtilsKt.toSessionKey(this.$glanceId));
            Intrinsics.checkNotNull(session, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetSession");
            this.L$0 = null;
            this.label = 3;
            Object objWaitForReady = ((AppWidgetSession) session).waitForReady(this);
            return objWaitForReady != coroutine_suspended ? coroutine_suspended : objWaitForReady;
        }
        sessionManagerScope = (SessionManagerScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        objIsSessionRunning = obj;
        if (((Boolean) objIsSessionRunning).booleanValue()) {
            return null;
        }
        Context context2 = this.this$0.context;
        AppWidgetSession appWidgetSession = new AppWidgetSession(this.$widget, this.$glanceId, null, null, null, null, false, null, 252, null);
        this.L$0 = sessionManagerScope;
        this.label = 2;
        if (sessionManagerScope.startSession(context2, appWidgetSession, this) != coroutine_suspended) {
            Session session2 = sessionManagerScope.getSession(AppWidgetUtilsKt.toSessionKey(this.$glanceId));
            Intrinsics.checkNotNull(session2, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetSession");
            this.L$0 = null;
            this.label = 3;
            Object objWaitForReady2 = ((AppWidgetSession) session2).waitForReady(this);
            if (objWaitForReady2 != coroutine_suspended) {
            }
        }
    }
}
