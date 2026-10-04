package androidx.glance.appwidget.multiprocess;

import android.content.Context;
import android.os.Bundle;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.util.OneTimeUpdateKt;
import androidx.glance.oneui.common.GlanceLog;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "key", ""}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$scope$1$startCoroutineSession$2", m14021f = "MultiProcessSessionManager.kt", m14022i = {}, m14023l = {33}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class MultiProcessSessionManager$scope$1$startCoroutineSession$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CoroutineSession $session;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$scope$1$startCoroutineSession$2$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/appwidget/multiprocess/TimerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$scope$1$startCoroutineSession$2$1", m14021f = "MultiProcessSessionManager.kt", m14022i = {}, m14023l = {43}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C29841 extends SuspendLambda implements Function2<TimerScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $key;
        final /* synthetic */ CoroutineSession $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29841(CoroutineSession coroutineSession, String str, Context context, Continuation<? super C29841> continuation) {
            super(2, continuation);
            this.$session = coroutineSession;
            this.$key = str;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C29841(this.$session, this.$key, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull TimerScope timerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C29841) create(timerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception e) {
                GlanceLog.INSTANCE.m2301i("GWT:MultiProcessContext", "Finished " + this.$key + " session by " + e);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = ((MultiProcessSession) this.$session).getUpdatedAtLeastOnce().get();
                GlanceLog.INSTANCE.m2305w("GWT:MultiProcessContext", "Whether the widget needs to be forced to be updated is " + z);
                if (!z) {
                    int i2 = Integer.parseInt((String) CollectionsKt.last(StringsKt__StringsKt.split$default(this.$key, new String[]{CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR}, false, 0, 6, (Object) null)));
                    GlanceAppWidget widget = ((MultiProcessSession) this.$session).getWidget();
                    Context context = this.$context;
                    AppWidgetId appWidgetId = new AppWidgetId(i2);
                    Bundle options = ((MultiProcessSession) this.$session).getOptions();
                    this.label = 1;
                    if (OneTimeUpdateKt.updateForOneTime(widget, context, appWidgetId, options, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$scope$1$startCoroutineSession$2$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/appwidget/multiprocess/TimerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$scope$1$startCoroutineSession$2$2", m14021f = "MultiProcessSessionManager.kt", m14022i = {}, m14023l = {54}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C29852 extends SuspendLambda implements Function2<TimerScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ CoroutineSession $session;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$scope$1$startCoroutineSession$2$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", ""}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$scope$1$startCoroutineSession$2$2$1", m14021f = "MultiProcessSessionManager.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ TimerScope $$this$withTimer;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TimerScope timerScope, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.$$this$withTimer = timerScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$$this$withTimer, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$$this$withTimer.mo21354startTimerLRDsOJo(MultiProcessSessionManager.TIME_DURATION);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29852(CoroutineSession coroutineSession, Context context, Continuation<? super C29852> continuation) {
            super(2, continuation);
            this.$session = coroutineSession;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C29852 c29852 = new C29852(this.$session, this.$context, continuation);
            c29852.L$0 = obj;
            return c29852;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull TimerScope timerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C29852) create(timerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TimerScope timerScope = (TimerScope) this.L$0;
                    CoroutineSession coroutineSession = this.$session;
                    Context context = this.$context;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(timerScope, null);
                    this.label = 1;
                    if (coroutineSession.m21353runComposition0E7RQCE(context, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                }
            } catch (Exception e) {
                GlanceLog.INSTANCE.m2305w("GWT:MultiProcessContext", "MultiProcessSession " + this.$session.getKey() + " is finished by " + e + ",");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessSessionManager$scope$1$startCoroutineSession$2(CoroutineSession coroutineSession, Context context, Continuation<? super MultiProcessSessionManager$scope$1$startCoroutineSession$2> continuation) {
        super(2, continuation);
        this.$session = coroutineSession;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MultiProcessSessionManager$scope$1$startCoroutineSession$2 multiProcessSessionManager$scope$1$startCoroutineSession$2 = new MultiProcessSessionManager$scope$1$startCoroutineSession$2(this.$session, this.$context, continuation);
        multiProcessSessionManager$scope$1$startCoroutineSession$2.L$0 = obj;
        return multiProcessSessionManager$scope$1$startCoroutineSession$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            C29841 c29841 = new C29841(this.$session, str, this.$context, null);
            C29852 c29852 = new C29852(this.$session, this.$context, null);
            this.label = 1;
            if (TimerScopeKt.withTimer(str, c29841, c29852, this) == coroutine_suspended) {
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
    public final Object invoke(@NotNull String str, @Nullable Continuation<? super Unit> continuation) {
        return ((MultiProcessSessionManager$scope$1$startCoroutineSession$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
