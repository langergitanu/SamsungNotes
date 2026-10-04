package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.LayoutRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.SizeMode;
import androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt;
import androidx.glance.appwidget.multiprocess.MultiProcessSessionManagerKt;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.session.Session;
import androidx.glance.session.SessionManager;
import androidx.glance.session.SessionManagerKt;
import androidx.glance.session.SessionManagerScope;
import androidx.glance.state.GlanceState;
import androidx.glance.state.GlanceStateDefinition;
import androidx.glance.state.PreferencesGlanceStateDefinition;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001aH¦@¢\u0006\u0002\u0010\u001eJ(\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0080@¢\u0006\u0004\b$\u0010%J4\u0010&\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0080@¢\u0006\u0004\b)\u0010*J\u001e\u0010+\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001eJ,\u0010+\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0080@¢\u0006\u0004\b,\u0010%J]\u0010-\u001a\u00020\u0012*\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020.2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2-\u0010/\u001a)\b\u0001\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u000100¢\u0006\u0002\b4H\u0082@¢\u0006\u0002\u00105R\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00066"}, m13886d2 = {"Landroidx/glance/appwidget/GlanceAppWidget;", "", "errorUiLayout", "", "(I)V", "getErrorUiLayout$glance_appwidget_release", "()I", "sessionManager", "Landroidx/glance/session/SessionManager;", "sizeMode", "Landroidx/glance/appwidget/SizeMode;", "getSizeMode", "()Landroidx/glance/appwidget/SizeMode;", "stateDefinition", "Landroidx/glance/state/GlanceStateDefinition;", "getStateDefinition", "()Landroidx/glance/state/GlanceStateDefinition;", "deleted", "", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "deleted$glance_appwidget_release", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCompositionError", "glanceId", "Landroidx/glance/GlanceId;", "throwable", "", "onDelete", "(Landroid/content/Context;Landroidx/glance/GlanceId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provideGlance", "id", "resize", "options", "Landroid/os/Bundle;", "resize$glance_appwidget_release", "(Landroid/content/Context;ILandroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerAction", "actionKey", "", "triggerAction$glance_appwidget_release", "(Landroid/content/Context;ILjava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.ARG_UPDATE, "update$glance_appwidget_release", "getOrCreateAppWidgetSession", "Landroidx/glance/appwidget/AppWidgetId;", "block", "Lkotlin/Function3;", "Landroidx/glance/session/SessionManagerScope;", "Landroidx/glance/appwidget/AppWidgetSession;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/glance/session/SessionManager;Landroid/content/Context;Landroidx/glance/appwidget/AppWidgetId;Landroid/os/Bundle;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceAppWidget.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidget.kt\nandroidx/glance/appwidget/GlanceAppWidget\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,327:1\n1#2:328\n*E\n"})
public abstract class GlanceAppWidget {
    public static final int $stable = 8;
    private final int errorUiLayout;

    @NotNull
    private final SessionManager sessionManager;

    @NotNull
    private final SizeMode sizeMode;

    @Nullable
    private final GlanceStateDefinition<?> stateDefinition;

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidget$getOrCreateAppWidgetSession$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidget$getOrCreateAppWidgetSession$2", m14021f = "GlanceAppWidget.kt", m14022i = {0, 1}, m14023l = {273, 274, 277}, m14024m = "invokeSuspend", m14025n = {"$this$runWithLock", "$this$runWithLock"}, m14026s = {"L$0", "L$0"})
    public static final class C28482 extends SuspendLambda implements Function2<SessionManagerScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<SessionManagerScope, AppWidgetSession, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Context $context;
        final /* synthetic */ AppWidgetId $glanceId;
        final /* synthetic */ Bundle $options;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GlanceAppWidget this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C28482(Context context, AppWidgetId appWidgetId, GlanceAppWidget glanceAppWidget, Bundle bundle, Function3<? super SessionManagerScope, ? super AppWidgetSession, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super C28482> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$glanceId = appWidgetId;
            this.this$0 = glanceAppWidget;
            this.$options = bundle;
            this.$block = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C28482 c28482 = new C28482(this.$context, this.$glanceId, this.this$0, this.$options, this.$block, continuation);
            c28482.L$0 = obj;
            return c28482;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C28482) create(sessionManagerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
        
            if (r5.invoke(r2, (androidx.glance.appwidget.AppWidgetSession) r4, r17) != r1) goto L23;
         */
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
                Context context = this.$context;
                String sessionKey = AppWidgetUtilsKt.toSessionKey(this.$glanceId);
                this.L$0 = sessionManagerScope;
                this.label = 1;
                objIsSessionRunning = sessionManagerScope.isSessionRunning(context, sessionKey, this);
                if (objIsSessionRunning != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                sessionManagerScope = (SessionManagerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objIsSessionRunning = obj;
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                sessionManagerScope = (SessionManagerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Session session = sessionManagerScope.getSession(AppWidgetUtilsKt.toSessionKey(this.$glanceId));
                Intrinsics.checkNotNull(session, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetSession");
                Function3<SessionManagerScope, AppWidgetSession, Continuation<? super Unit>, Object> function3 = this.$block;
                this.L$0 = null;
                this.label = 3;
            }
            if (!((Boolean) objIsSessionRunning).booleanValue()) {
                Context context2 = this.$context;
                AppWidgetSession appWidgetSession = new AppWidgetSession(this.this$0, this.$glanceId, this.$options, null, null, null, false, null, 248, null);
                this.L$0 = sessionManagerScope;
                this.label = 2;
                if (sessionManagerScope.startSession(context2, appWidgetSession, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            Session session2 = sessionManagerScope.getSession(AppWidgetUtilsKt.toSessionKey(this.$glanceId));
            Intrinsics.checkNotNull(session2, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetSession");
            Function3<SessionManagerScope, AppWidgetSession, Continuation<? super Unit>, Object> function32 = this.$block;
            this.L$0 = null;
            this.label = 3;
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidget$update$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidget$update$4", m14021f = "GlanceAppWidget.kt", m14022i = {0}, m14023l = {175, 178, 182}, m14024m = "invokeSuspend", m14025n = {"$this$runWithLock"}, m14026s = {"L$0"})
    public static final class C28494 extends SuspendLambda implements Function2<SessionManagerScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ AppWidgetId $glanceId;
        final /* synthetic */ Bundle $options;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GlanceAppWidget this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28494(Context context, AppWidgetId appWidgetId, GlanceAppWidget glanceAppWidget, Bundle bundle, Continuation<? super C28494> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$glanceId = appWidgetId;
            this.this$0 = glanceAppWidget;
            this.$options = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C28494 c28494 = new C28494(this.$context, this.$glanceId, this.this$0, this.$options, continuation);
            c28494.L$0 = obj;
            return c28494;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C28494) create(sessionManagerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x008e, code lost:
        
            if (r2.startSession(r3, r7, r18) == r1) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00ad, code lost:
        
            if (((androidx.glance.appwidget.AppWidgetSession) r2).updateGlance(r18) == r1) goto L24;
         */
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
                Context context = this.$context;
                String sessionKey = AppWidgetUtilsKt.toSessionKey(this.$glanceId);
                this.L$0 = sessionManagerScope;
                this.label = 1;
                objIsSessionRunning = sessionManagerScope.isSessionRunning(context, sessionKey, this);
                if (objIsSessionRunning != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            sessionManagerScope = (SessionManagerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            objIsSessionRunning = obj;
            boolean zBooleanValue = ((Boolean) objIsSessionRunning).booleanValue();
            GlanceLog.INSTANCE.m2301i("GWT:AppWidget", "Update " + this.$glanceId + " widget / isRunning : " + zBooleanValue);
            if (zBooleanValue) {
                Session session = sessionManagerScope.getSession(AppWidgetUtilsKt.toSessionKey(this.$glanceId));
                Intrinsics.checkNotNull(session, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetSession");
                this.L$0 = null;
                this.label = 3;
            } else {
                Context context2 = this.$context;
                AppWidgetSession appWidgetSession = new AppWidgetSession(this.this$0, this.$glanceId, this.$options, null, null, null, false, null, 248, null);
                this.L$0 = null;
                this.label = 2;
            }
            return coroutine_suspended;
        }
    }

    public GlanceAppWidget() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getOrCreateAppWidgetSession(SessionManager sessionManager, Context context, AppWidgetId appWidgetId, Bundle bundle, Function3<? super SessionManagerScope, ? super AppWidgetSession, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objRunWithLock = sessionManager.runWithLock(new C28482(context, appWidgetId, this, bundle, function3, null), continuation);
        return objRunWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunWithLock : Unit.INSTANCE;
    }

    public static /* synthetic */ Object getOrCreateAppWidgetSession$default(GlanceAppWidget glanceAppWidget, SessionManager sessionManager, Context context, AppWidgetId appWidgetId, Bundle bundle, Function3 function3, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrCreateAppWidgetSession");
        }
        if ((i & 4) != 0) {
            bundle = null;
        }
        return glanceAppWidget.getOrCreateAppWidgetSession(sessionManager, context, appWidgetId, bundle, function3, continuation);
    }

    public static /* synthetic */ Object onDelete$suspendImpl(GlanceAppWidget glanceAppWidget, Context context, GlanceId glanceId, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object triggerAction$glance_appwidget_release$default(GlanceAppWidget glanceAppWidget, Context context, int i, String str, Bundle bundle, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: triggerAction");
        }
        if ((i2 & 8) != 0) {
            bundle = null;
        }
        return glanceAppWidget.triggerAction$glance_appwidget_release(context, i, str, bundle, continuation);
    }

    public static /* synthetic */ Object update$glance_appwidget_release$default(GlanceAppWidget glanceAppWidget, Context context, int i, Bundle bundle, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        return glanceAppWidget.update$glance_appwidget_release(context, i, bundle, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b3, code lost:
    
        if (androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt.deletedAtMultiProcess(r9, r10, r12, r0) == r1) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b7, code lost:
    
        r4 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cf, code lost:
    
        if (r2.runWithLock(r4, r0) == r1) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object deleted$glance_appwidget_release(@NotNull Context context, int i, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        GlanceAppWidget$deleted$1 glanceAppWidget$deleted$1;
        AppWidgetId appWidgetId;
        GlanceAppWidget glanceAppWidget;
        Context context2;
        int i2;
        AppWidgetId appWidgetId2;
        Throwable th;
        AppWidgetId appWidgetId3;
        Throwable th2;
        Context context3;
        GlanceStateDefinition<?> stateDefinition;
        AppWidgetId appWidgetId4;
        Context context4;
        GlanceStateDefinition<?> stateDefinition2;
        Context context5;
        GlanceStateDefinition<?> stateDefinition3;
        if (continuation instanceof GlanceAppWidget$deleted$1) {
            glanceAppWidget$deleted$1 = (GlanceAppWidget$deleted$1) continuation;
            int i4 = glanceAppWidget$deleted$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                glanceAppWidget$deleted$1.label = i4 - Integer.MIN_VALUE;
            } else {
                glanceAppWidget$deleted$1 = new GlanceAppWidget$deleted$1(this, continuation);
            }
        }
        Object obj = glanceAppWidget$deleted$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (glanceAppWidget$deleted$1.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                appWidgetId = new AppWidgetId(i);
                if (!MultiProcessSessionManagerKt.isMainProcess(context)) {
                    glanceAppWidget$deleted$1.L$0 = this;
                    glanceAppWidget$deleted$1.L$1 = context;
                    glanceAppWidget$deleted$1.L$2 = appWidgetId;
                    glanceAppWidget$deleted$1.I$0 = i;
                    glanceAppWidget$deleted$1.label = 1;
                    break;
                } else {
                    SessionManager sessionManager = this.sessionManager;
                    GlanceAppWidget$deleted$2 glanceAppWidget$deleted$2 = new GlanceAppWidget$deleted$2(appWidgetId, null);
                    glanceAppWidget$deleted$1.L$0 = this;
                    glanceAppWidget$deleted$1.L$1 = context;
                    glanceAppWidget$deleted$1.L$2 = appWidgetId;
                    glanceAppWidget$deleted$1.I$0 = i;
                    glanceAppWidget$deleted$1.label = 2;
                    break;
                }
                try {
                    glanceAppWidget$deleted$1.L$0 = glanceAppWidget;
                    glanceAppWidget$deleted$1.L$1 = context;
                    glanceAppWidget$deleted$1.L$2 = appWidgetId;
                    glanceAppWidget$deleted$1.I$0 = i;
                    glanceAppWidget$deleted$1.label = 3;
                    break;
                } catch (CancellationException unused) {
                    context2 = context;
                    appWidgetId3 = appWidgetId;
                    stateDefinition2 = glanceAppWidget.getStateDefinition();
                    if (stateDefinition2 != null) {
                    }
                    LayoutConfiguration.INSTANCE.delete(context2, appWidgetId3);
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    context2 = context;
                    i2 = i;
                    appWidgetId2 = appWidgetId;
                    th = th3;
                    try {
                        GlanceLog.INSTANCE.m2300e("GWT:AppWidget", "Error in user-provided deletion callback", th);
                        stateDefinition = glanceAppWidget.getStateDefinition();
                        if (stateDefinition != null) {
                        }
                        LayoutConfiguration.INSTANCE.delete(context2, appWidgetId2);
                        return Unit.INSTANCE;
                    } catch (Throwable th4) {
                        th = th4;
                        GlanceStateDefinition<?> stateDefinition4 = glanceAppWidget.getStateDefinition();
                        if (stateDefinition4 != null) {
                            GlanceState glanceState = GlanceState.INSTANCE;
                            String strCreateUniqueRemoteUiName = AppWidgetUtilsKt.createUniqueRemoteUiName(i2);
                            glanceAppWidget$deleted$1.L$0 = context2;
                            glanceAppWidget$deleted$1.L$1 = appWidgetId2;
                            glanceAppWidget$deleted$1.L$2 = th;
                            glanceAppWidget$deleted$1.label = 7;
                            if (glanceState.deleteStore(context2, stateDefinition4, strCreateUniqueRemoteUiName, glanceAppWidget$deleted$1) != coroutine_suspended) {
                                th2 = th;
                                context3 = context2;
                                th = th2;
                                context2 = context3;
                            }
                        }
                        LayoutConfiguration.INSTANCE.delete(context2, appWidgetId2);
                        throw th;
                    }
                }
                if (glanceAppWidget.onDelete(context, appWidgetId, glanceAppWidget$deleted$1) != coroutine_suspended) {
                    context2 = context;
                    appWidgetId3 = appWidgetId;
                    stateDefinition3 = glanceAppWidget.getStateDefinition();
                    if (stateDefinition3 != null) {
                        GlanceState glanceState2 = GlanceState.INSTANCE;
                        String strCreateUniqueRemoteUiName2 = AppWidgetUtilsKt.createUniqueRemoteUiName(i);
                        glanceAppWidget$deleted$1.L$0 = context2;
                        glanceAppWidget$deleted$1.L$1 = appWidgetId3;
                        glanceAppWidget$deleted$1.L$2 = null;
                        glanceAppWidget$deleted$1.label = 4;
                        if (glanceState2.deleteStore(context2, stateDefinition3, strCreateUniqueRemoteUiName2, glanceAppWidget$deleted$1) != coroutine_suspended) {
                            context5 = context2;
                            context2 = context5;
                        }
                    }
                    LayoutConfiguration.INSTANCE.delete(context2, appWidgetId3);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            case 1:
            case 2:
                i = glanceAppWidget$deleted$1.I$0;
                AppWidgetId appWidgetId5 = (AppWidgetId) glanceAppWidget$deleted$1.L$2;
                Context context6 = (Context) glanceAppWidget$deleted$1.L$1;
                glanceAppWidget = (GlanceAppWidget) glanceAppWidget$deleted$1.L$0;
                ResultKt.throwOnFailure(obj);
                appWidgetId = appWidgetId5;
                context = context6;
                glanceAppWidget$deleted$1.L$0 = glanceAppWidget;
                glanceAppWidget$deleted$1.L$1 = context;
                glanceAppWidget$deleted$1.L$2 = appWidgetId;
                glanceAppWidget$deleted$1.I$0 = i;
                glanceAppWidget$deleted$1.label = 3;
                if (glanceAppWidget.onDelete(context, appWidgetId, glanceAppWidget$deleted$1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 3:
                i2 = glanceAppWidget$deleted$1.I$0;
                appWidgetId2 = (AppWidgetId) glanceAppWidget$deleted$1.L$2;
                context2 = (Context) glanceAppWidget$deleted$1.L$1;
                glanceAppWidget = (GlanceAppWidget) glanceAppWidget$deleted$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i = i2;
                    appWidgetId3 = appWidgetId2;
                    stateDefinition3 = glanceAppWidget.getStateDefinition();
                    if (stateDefinition3 != null) {
                    }
                } catch (CancellationException unused2) {
                    i = i2;
                    appWidgetId3 = appWidgetId2;
                    stateDefinition2 = glanceAppWidget.getStateDefinition();
                    if (stateDefinition2 != null) {
                        GlanceState glanceState3 = GlanceState.INSTANCE;
                        String strCreateUniqueRemoteUiName3 = AppWidgetUtilsKt.createUniqueRemoteUiName(i);
                        glanceAppWidget$deleted$1.L$0 = context2;
                        glanceAppWidget$deleted$1.L$1 = appWidgetId3;
                        glanceAppWidget$deleted$1.L$2 = null;
                        glanceAppWidget$deleted$1.label = 5;
                        if (glanceState3.deleteStore(context2, stateDefinition2, strCreateUniqueRemoteUiName3, glanceAppWidget$deleted$1) != coroutine_suspended) {
                            context5 = context2;
                            break;
                        }
                        return coroutine_suspended;
                    }
                    LayoutConfiguration.INSTANCE.delete(context2, appWidgetId3);
                    return Unit.INSTANCE;
                } catch (Throwable th5) {
                    th = th5;
                    GlanceLog.INSTANCE.m2300e("GWT:AppWidget", "Error in user-provided deletion callback", th);
                    stateDefinition = glanceAppWidget.getStateDefinition();
                    if (stateDefinition != null) {
                        GlanceState glanceState4 = GlanceState.INSTANCE;
                        String strCreateUniqueRemoteUiName4 = AppWidgetUtilsKt.createUniqueRemoteUiName(i2);
                        glanceAppWidget$deleted$1.L$0 = context2;
                        glanceAppWidget$deleted$1.L$1 = appWidgetId2;
                        glanceAppWidget$deleted$1.L$2 = null;
                        glanceAppWidget$deleted$1.label = 6;
                        if (glanceState4.deleteStore(context2, stateDefinition, strCreateUniqueRemoteUiName4, glanceAppWidget$deleted$1) != coroutine_suspended) {
                            appWidgetId4 = appWidgetId2;
                            context4 = context2;
                            context2 = context4;
                            appWidgetId2 = appWidgetId4;
                        }
                    }
                    LayoutConfiguration.INSTANCE.delete(context2, appWidgetId2);
                    return Unit.INSTANCE;
                }
                LayoutConfiguration.INSTANCE.delete(context2, appWidgetId3);
                return Unit.INSTANCE;
            case 4:
                appWidgetId3 = (AppWidgetId) glanceAppWidget$deleted$1.L$1;
                context5 = (Context) glanceAppWidget$deleted$1.L$0;
                ResultKt.throwOnFailure(obj);
                context2 = context5;
                LayoutConfiguration.INSTANCE.delete(context2, appWidgetId3);
                return Unit.INSTANCE;
            case 5:
                appWidgetId3 = (AppWidgetId) glanceAppWidget$deleted$1.L$1;
                context5 = (Context) glanceAppWidget$deleted$1.L$0;
                ResultKt.throwOnFailure(obj);
                context2 = context5;
                LayoutConfiguration.INSTANCE.delete(context2, appWidgetId3);
                return Unit.INSTANCE;
            case 6:
                appWidgetId4 = (AppWidgetId) glanceAppWidget$deleted$1.L$1;
                context4 = (Context) glanceAppWidget$deleted$1.L$0;
                ResultKt.throwOnFailure(obj);
                context2 = context4;
                appWidgetId2 = appWidgetId4;
                LayoutConfiguration.INSTANCE.delete(context2, appWidgetId2);
                return Unit.INSTANCE;
            case 7:
                th2 = (Throwable) glanceAppWidget$deleted$1.L$2;
                appWidgetId2 = (AppWidgetId) glanceAppWidget$deleted$1.L$1;
                context3 = (Context) glanceAppWidget$deleted$1.L$0;
                ResultKt.throwOnFailure(obj);
                th = th2;
                context2 = context3;
                LayoutConfiguration.INSTANCE.delete(context2, appWidgetId2);
                throw th;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: getErrorUiLayout$glance_appwidget_release, reason: from getter */
    public int getErrorUiLayout() {
        return this.errorUiLayout;
    }

    @NotNull
    public SizeMode getSizeMode() {
        return this.sizeMode;
    }

    @Nullable
    public GlanceStateDefinition<?> getStateDefinition() {
        return this.stateDefinition;
    }

    public void onCompositionError(@NotNull Context context, @NotNull GlanceId glanceId, int appWidgetId, @NotNull Throwable throwable) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glanceId, "glanceId");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (getErrorUiLayout() == 0) {
            throw throwable;
        }
        AppWidgetManager.getInstance(context).updateAppWidget(appWidgetId, new RemoteViews(context.getPackageName(), getErrorUiLayout()));
    }

    @Nullable
    public Object onDelete(@NotNull Context context, @NotNull GlanceId glanceId, @NotNull Continuation<? super Unit> continuation) {
        return onDelete$suspendImpl(this, context, glanceId, continuation);
    }

    @Nullable
    public abstract Object provideGlance(@NotNull Context context, @NotNull GlanceId glanceId, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    public final Object resize$glance_appwidget_release(@NotNull Context context, int i, @NotNull Bundle bundle, @NotNull Continuation<? super Unit> continuation) {
        if ((getSizeMode() instanceof SizeMode.Single) || (Build.VERSION.SDK_INT > 31 && (getSizeMode() instanceof SizeMode.Responsive))) {
            return Unit.INSTANCE;
        }
        AppWidgetId appWidgetId = new AppWidgetId(i);
        if (MultiProcessSessionManagerKt.isMainProcess(context)) {
            Object orCreateAppWidgetSession = getOrCreateAppWidgetSession(this.sessionManager, context, appWidgetId, bundle, new GlanceAppWidget$resize$2(bundle, null), continuation);
            return orCreateAppWidgetSession == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orCreateAppWidgetSession : Unit.INSTANCE;
        }
        Object objResizeMultiProcessWidget = MultiProcessAppWidgetKt.resizeMultiProcessWidget(this, context, appWidgetId, bundle, continuation);
        return objResizeMultiProcessWidget == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objResizeMultiProcessWidget : Unit.INSTANCE;
    }

    @Nullable
    public final Object triggerAction$glance_appwidget_release(@NotNull Context context, int i, @NotNull String str, @Nullable Bundle bundle, @NotNull Continuation<? super Unit> continuation) {
        AppWidgetId appWidgetId = new AppWidgetId(i);
        if (MultiProcessSessionManagerKt.isMainProcess(context)) {
            Object orCreateAppWidgetSession = getOrCreateAppWidgetSession(this.sessionManager, context, appWidgetId, bundle, new GlanceAppWidget$triggerAction$2(str, null), continuation);
            return orCreateAppWidgetSession == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orCreateAppWidgetSession : Unit.INSTANCE;
        }
        Object objTriggerMultiProcessAction = MultiProcessAppWidgetKt.triggerMultiProcessAction(this, context, appWidgetId, str, bundle, continuation);
        return objTriggerMultiProcessAction == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTriggerMultiProcessAction : Unit.INSTANCE;
    }

    @Nullable
    public final Object update(@NotNull Context context, @NotNull GlanceId glanceId, @NotNull Continuation<? super Unit> continuation) {
        if (!(glanceId instanceof AppWidgetId) || !AppWidgetUtilsKt.isRealId((AppWidgetId) glanceId)) {
            throw new IllegalArgumentException("Invalid Glance ID");
        }
        Object objUpdate$glance_appwidget_release$default = update$glance_appwidget_release$default(this, context, ((AppWidgetId) glanceId).getAppWidgetId(), null, continuation, 4, null);
        return objUpdate$glance_appwidget_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdate$glance_appwidget_release$default : Unit.INSTANCE;
    }

    @Nullable
    public final Object update$glance_appwidget_release(@NotNull Context context, int i, @Nullable Bundle bundle, @NotNull Continuation<? super Unit> continuation) {
        Tracing.INSTANCE.beginGlanceAppWidgetUpdate();
        if (AppWidgetManager.getInstance(context).getAppWidgetInfo(i) == null) {
            GlanceLog.INSTANCE.m2301i("GWT:AppWidget", "Widget id(" + i + ") is not bound");
            return Unit.INSTANCE;
        }
        AppWidgetId appWidgetId = new AppWidgetId(i);
        if (MultiProcessSessionManagerKt.isMainProcess(context)) {
            Object objRunWithLock = this.sessionManager.runWithLock(new C28494(context, appWidgetId, this, bundle, null), continuation);
            return objRunWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunWithLock : Unit.INSTANCE;
        }
        Object objUpdateMultiProcessWidget = MultiProcessAppWidgetKt.updateMultiProcessWidget(this, context, appWidgetId, continuation);
        return objUpdateMultiProcessWidget == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateMultiProcessWidget : Unit.INSTANCE;
    }

    public GlanceAppWidget(@LayoutRes int i) {
        this.errorUiLayout = i;
        this.sessionManager = SessionManagerKt.getGlanceSessionManager();
        this.sizeMode = SizeMode.Single.INSTANCE;
        this.stateDefinition = PreferencesGlanceStateDefinition.INSTANCE;
    }

    public /* synthetic */ GlanceAppWidget(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C2902R.layout.glance_error_layout : i);
    }
}
