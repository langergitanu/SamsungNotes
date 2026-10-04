package androidx.glance.appwidget;

import android.annotation.SuppressLint;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.UnmanagedSessionReceiver;
import androidx.glance.appwidget.action.LambdaActionBroadcasts;
import androidx.glance.appwidget.util.OneTimeUpdateKt;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.session.SessionWorkerKt;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/UnmanagedSessionReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class UnmanagedSessionReceiver extends BroadcastReceiver {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SuppressLint({"PrimitiveInCollection"})
    @NotNull
    private static final Map<Integer, Companion.Registration> activeSessions = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0005J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\rR\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/appwidget/UnmanagedSessionReceiver$Companion;", "", "()V", "activeSessions", "", "", "Landroidx/glance/appwidget/UnmanagedSessionReceiver$Companion$Registration;", "getSession", "Landroidx/glance/appwidget/AppWidgetSession;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "registerSession", "", "session", "(ILandroidx/glance/appwidget/AppWidgetSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Registration", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nUnmanagedSessionReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnmanagedSessionReceiver.kt\nandroidx/glance/appwidget/UnmanagedSessionReceiver$Companion\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,138:1\n314#2,11:139\n*S KotlinDebug\n*F\n+ 1 UnmanagedSessionReceiver.kt\nandroidx/glance/appwidget/UnmanagedSessionReceiver$Companion\n*L\n117#1:139,11\n*E\n"})
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Landroidx/glance/appwidget/UnmanagedSessionReceiver$Companion$Registration;", "", "session", "Landroidx/glance/appwidget/AppWidgetSession;", "coroutine", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Landroidx/glance/appwidget/AppWidgetSession;Lkotlinx/coroutines/CancellableContinuation;)V", "getCoroutine", "()Lkotlinx/coroutines/CancellableContinuation;", "getSession", "()Landroidx/glance/appwidget/AppWidgetSession;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class Registration {

            @NotNull
            private final CancellableContinuation<?> coroutine;

            @NotNull
            private final AppWidgetSession session;

            public Registration(@NotNull AppWidgetSession session, @NotNull CancellableContinuation<?> coroutine) {
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(coroutine, "coroutine");
                this.session = session;
                this.coroutine = coroutine;
            }

            @NotNull
            public final CancellableContinuation<?> getCoroutine() {
                return this.coroutine;
            }

            @NotNull
            public final AppWidgetSession getSession() {
                return this.session;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final AppWidgetSession getSession(int appWidgetId) {
            AppWidgetSession session;
            synchronized (UnmanagedSessionReceiver.INSTANCE) {
                Registration registration = (Registration) UnmanagedSessionReceiver.activeSessions.get(Integer.valueOf(appWidgetId));
                session = registration != null ? registration.getSession() : null;
            }
            return session;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object registerSession(final int i, @NotNull AppWidgetSession appWidgetSession, @NotNull Continuation<?> continuation) {
            UnmanagedSessionReceiver$Companion$registerSession$1 unmanagedSessionReceiver$Companion$registerSession$1;
            CancellableContinuation<?> coroutine;
            if (continuation instanceof UnmanagedSessionReceiver$Companion$registerSession$1) {
                unmanagedSessionReceiver$Companion$registerSession$1 = (UnmanagedSessionReceiver$Companion$registerSession$1) continuation;
                int i2 = unmanagedSessionReceiver$Companion$registerSession$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    unmanagedSessionReceiver$Companion$registerSession$1.label = i2 - Integer.MIN_VALUE;
                } else {
                    unmanagedSessionReceiver$Companion$registerSession$1 = new UnmanagedSessionReceiver$Companion$registerSession$1(this, continuation);
                }
            }
            Object obj = unmanagedSessionReceiver$Companion$registerSession$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = unmanagedSessionReceiver$Companion$registerSession$1.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                unmanagedSessionReceiver$Companion$registerSession$1.L$0 = appWidgetSession;
                unmanagedSessionReceiver$Companion$registerSession$1.I$0 = i;
                unmanagedSessionReceiver$Companion$registerSession$1.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(unmanagedSessionReceiver$Companion$registerSession$1), 1);
                cancellableContinuationImpl.initCancellability();
                synchronized (UnmanagedSessionReceiver.INSTANCE) {
                    try {
                        Registration registration = (Registration) UnmanagedSessionReceiver.activeSessions.get(Boxing.boxInt(i));
                        if (registration != null && (coroutine = registration.getCoroutine()) != null) {
                            Result.Companion companion = Result.INSTANCE;
                            coroutine.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(new IllegalStateException("Another session for " + i + " has started"))));
                        }
                        UnmanagedSessionReceiver.activeSessions.put(Boxing.boxInt(i), new Registration(appWidgetSession, cancellableContinuationImpl));
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.glance.appwidget.UnmanagedSessionReceiver$Companion$registerSession$2$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                        invoke2(th2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Throwable th2) {
                        UnmanagedSessionReceiver.Companion companion2 = UnmanagedSessionReceiver.INSTANCE;
                        int i5 = i;
                        synchronized (companion2) {
                            UnmanagedSessionReceiver.activeSessions.remove(Integer.valueOf(i5));
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(unmanagedSessionReceiver$Companion$registerSession$1);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.UnmanagedSessionReceiver$onReceive$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.UnmanagedSessionReceiver$onReceive$2", m14021f = "UnmanagedSessionReceiver.kt", m14022i = {}, m14023l = {71}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C29192 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ AppWidgetManager $manager;
        final /* synthetic */ int $widgetId;
        int label;

        /* JADX INFO: renamed from: androidx.glance.appwidget.UnmanagedSessionReceiver$onReceive$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.appwidget.UnmanagedSessionReceiver$onReceive$2$1", m14021f = "UnmanagedSessionReceiver.kt", m14022i = {}, m14023l = {80}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ Intent $intent;
            final /* synthetic */ AppWidgetManager $manager;
            final /* synthetic */ int $widgetId;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AppWidgetManager appWidgetManager, int i, Intent intent, Context context, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$manager = appWidgetManager;
                this.$widgetId = i;
                this.$intent = intent;
                this.$context = context;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$manager, this.$widgetId, this.$intent, this.$context, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ComponentName componentName = this.$manager.getAppWidgetInfo(this.$widgetId).provider;
                    Bundle appWidgetOptions = this.$manager.getAppWidgetOptions(this.$widgetId);
                    Object objNewInstance = Class.forName(componentName.getClassName()).getDeclaredConstructor(null).newInstance(null);
                    GlanceLog.Companion companion = GlanceLog.INSTANCE;
                    StringBuilder sbM780v = AbstractC0541b.m780v("onReceive : ", this.$widgetId, this.$intent.getAction(), SQLKeyword.COMMA, SQLKeyword.COMMA);
                    sbM780v.append(componentName);
                    companion.m2301i("GWT:SessionReceiver", sbM780v.toString());
                    if (objNewInstance instanceof GlanceAppWidgetReceiver) {
                        GlanceAppWidget glanceAppWidget = ((GlanceAppWidgetReceiver) objNewInstance).getGlanceAppWidget();
                        Context context = this.$context;
                        AppWidgetId appWidgetId = new AppWidgetId(this.$widgetId);
                        this.label = 1;
                        if (OneTimeUpdateKt.updateForOneTime(glanceAppWidget, context, appWidgetId, appWidgetOptions, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29192(int i, AppWidgetManager appWidgetManager, Intent intent, Context context, Continuation<? super C29192> continuation) {
            super(2, continuation);
            this.$widgetId = i;
            this.$manager = appWidgetManager;
            this.$intent = intent;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C29192(this.$widgetId, this.$manager, this.$intent, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Duration.Companion companion = Duration.INSTANCE;
                    long duration = DurationKt.toDuration(3, DurationUnit.SECONDS);
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$manager, this.$widgetId, this.$intent, this.$context, null);
                    this.label = 1;
                    if (TimeoutKt.m23703withTimeoutKLykuaI(duration, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                GlanceLog.INSTANCE.m2301i("GWT:SessionReceiver", "Finished " + this.$widgetId + " force update by " + e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C29192) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!Intrinsics.areEqual(intent.getAction(), LambdaActionBroadcasts.ActionTriggerLambda)) {
            if (Intrinsics.areEqual(intent.getAction(), SessionWorkerKt.FORCE_UPDATE_APP_WIDGET)) {
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                CoroutineBroadcastReceiverKt.goAsync(this, Dispatchers.getDefault(), new C29192(intent.getIntExtra(SessionWorkerKt.FORCE_UPDATE_WIDGET_ID, 0), appWidgetManager, intent, context, null));
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra(LambdaActionBroadcasts.ExtraActionKey);
        if (stringExtra == null) {
            throw new IllegalStateException("Intent is missing ActionKey extra");
        }
        int intExtra = intent.getIntExtra(LambdaActionBroadcasts.ExtraAppWidgetId, -1);
        if (intExtra == -1) {
            throw new IllegalStateException("Intent is missing AppWidgetId extra");
        }
        AppWidgetSession session = INSTANCE.getSession(intExtra);
        Unit unit = null;
        if (session != null) {
            CoroutineBroadcastReceiverKt.goAsync(this, Dispatchers.getMain(), new UnmanagedSessionReceiver$onReceive$1$1(session, stringExtra, null));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            GlanceLog.INSTANCE.m2299e("GWT:SessionReceiver", "A lambda created by an unmanaged glance session cannot be servicedbecause that session is no longer running.");
        }
    }
}
