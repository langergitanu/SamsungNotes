package androidx.glance.appwidget.multiprocess;

import android.content.Context;
import android.os.Bundle;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.AppWidgetUtilsKt;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.session.Session;
import androidx.glance.session.SessionManager;
import androidx.glance.session.SessionManagerScope;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0080@¢\u0006\u0002\u0010\t\u001ae\u0010\n\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2-\u0010\u0010\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0011¢\u0006\u0002\b\u0016H\u0082@¢\u0006\u0002\u0010\u0017\u001a.\u0010\u0018\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0080@¢\u0006\u0002\u0010\u0019\u001a6\u0010\u001a\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0080@¢\u0006\u0002\u0010\u001c\u001a\"\u0010\u001d\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0080@¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "deletedAtMultiProcess", "", "Landroidx/glance/appwidget/GlanceAppWidget;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "Landroidx/glance/appwidget/AppWidgetId;", "(Landroidx/glance/appwidget/GlanceAppWidget;Landroid/content/Context;Landroidx/glance/appwidget/AppWidgetId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateMultiProcessSession", "Landroidx/glance/session/SessionManager;", "widget", "glanceId", "options", "Landroid/os/Bundle;", "block", "Lkotlin/Function3;", "Landroidx/glance/session/SessionManagerScope;", "Landroidx/glance/appwidget/multiprocess/MultiProcessSession;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/glance/session/SessionManager;Landroidx/glance/appwidget/GlanceAppWidget;Landroid/content/Context;Landroidx/glance/appwidget/AppWidgetId;Landroid/os/Bundle;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resizeMultiProcessWidget", "(Landroidx/glance/appwidget/GlanceAppWidget;Landroid/content/Context;Landroidx/glance/appwidget/AppWidgetId;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerMultiProcessAction", "actionKey", "(Landroidx/glance/appwidget/GlanceAppWidget;Landroid/content/Context;Landroidx/glance/appwidget/AppWidgetId;Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMultiProcessWidget", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class MultiProcessAppWidgetKt {

    @NotNull
    private static final String TAG = "GWT:MultiProcess";

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$deletedAtMultiProcess$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$deletedAtMultiProcess$2", m14021f = "MultiProcessAppWidget.kt", m14022i = {}, m14023l = {21}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C29782 extends SuspendLambda implements Function2<SessionManagerScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppWidgetId $appWidgetId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29782(AppWidgetId appWidgetId, Continuation<? super C29782> continuation) {
            super(2, continuation);
            this.$appWidgetId = appWidgetId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C29782 c29782 = new C29782(this.$appWidgetId, continuation);
            c29782.L$0 = obj;
            return c29782;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C29782) create(sessionManagerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SessionManagerScope sessionManagerScope = (SessionManagerScope) this.L$0;
                String sessionKey = AppWidgetUtilsKt.toSessionKey(this.$appWidgetId);
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

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$getOrCreateMultiProcessSession$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$getOrCreateMultiProcessSession$2", m14021f = "MultiProcessAppWidget.kt", m14022i = {0, 1}, m14023l = {86, 87, 90}, m14024m = "invokeSuspend", m14025n = {"$this$runWithLock", "$this$runWithLock"}, m14026s = {"L$0", "L$0"})
    public static final class C29792 extends SuspendLambda implements Function2<SessionManagerScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<SessionManagerScope, MultiProcessSession, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Context $context;
        final /* synthetic */ AppWidgetId $glanceId;
        final /* synthetic */ GlanceAppWidget $widget;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29792(Context context, AppWidgetId appWidgetId, GlanceAppWidget glanceAppWidget, Function3<? super SessionManagerScope, ? super MultiProcessSession, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super C29792> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$glanceId = appWidgetId;
            this.$widget = glanceAppWidget;
            this.$block = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C29792 c29792 = new C29792(this.$context, this.$glanceId, this.$widget, this.$block, continuation);
            c29792.L$0 = obj;
            return c29792;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C29792) create(sessionManagerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
        
            if (r3.invoke(r1, (androidx.glance.appwidget.multiprocess.MultiProcessSession) r12, r11) != r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            SessionManagerScope sessionManagerScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SessionManagerScope sessionManagerScope2 = (SessionManagerScope) this.L$0;
                Context context = this.$context;
                String sessionKey = AppWidgetUtilsKt.toSessionKey(this.$glanceId);
                this.L$0 = sessionManagerScope2;
                this.label = 1;
                Object objIsSessionRunning = sessionManagerScope2.isSessionRunning(context, sessionKey, this);
                if (objIsSessionRunning != coroutine_suspended) {
                    sessionManagerScope = sessionManagerScope2;
                    obj = objIsSessionRunning;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                sessionManagerScope = (SessionManagerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
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
                Intrinsics.checkNotNull(session, "null cannot be cast to non-null type androidx.glance.appwidget.multiprocess.MultiProcessSession");
                Function3<SessionManagerScope, MultiProcessSession, Continuation<? super Unit>, Object> function3 = this.$block;
                this.L$0 = null;
                this.label = 3;
            }
            if (!((Boolean) obj).booleanValue()) {
                Context context2 = this.$context;
                MultiProcessSession multiProcessSession = new MultiProcessSession(this.$glanceId, this.$widget, null, 4, null);
                this.L$0 = sessionManagerScope;
                this.label = 2;
                if (sessionManagerScope.startSession(context2, multiProcessSession, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            Session session2 = sessionManagerScope.getSession(AppWidgetUtilsKt.toSessionKey(this.$glanceId));
            Intrinsics.checkNotNull(session2, "null cannot be cast to non-null type androidx.glance.appwidget.multiprocess.MultiProcessSession");
            Function3<SessionManagerScope, MultiProcessSession, Continuation<? super Unit>, Object> function32 = this.$block;
            this.L$0 = null;
            this.label = 3;
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$resizeMultiProcessWidget$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;", "session", "Landroidx/glance/appwidget/multiprocess/MultiProcessSession;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$resizeMultiProcessWidget$2", m14021f = "MultiProcessAppWidget.kt", m14022i = {}, m14023l = {75}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C29802 extends SuspendLambda implements Function3<SessionManagerScope, MultiProcessSession, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $options;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29802(Bundle bundle, Continuation<? super C29802> continuation) {
            super(3, continuation);
            this.$options = bundle;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @NotNull MultiProcessSession multiProcessSession, @Nullable Continuation<? super Unit> continuation) {
            C29802 c29802 = new C29802(this.$options, continuation);
            c29802.L$0 = multiProcessSession;
            return c29802.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MultiProcessSession multiProcessSession = (MultiProcessSession) this.L$0;
                Bundle bundle = this.$options;
                if (bundle == null) {
                    bundle = Bundle.EMPTY;
                }
                Intrinsics.checkNotNull(bundle);
                this.label = 1;
                if (multiProcessSession.updateAppWidgetOptions(bundle, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$triggerMultiProcessAction$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;", "session", "Landroidx/glance/appwidget/multiprocess/MultiProcessSession;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$triggerMultiProcessAction$2", m14021f = "MultiProcessAppWidget.kt", m14022i = {}, m14023l = {58}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C29812 extends SuspendLambda implements Function3<SessionManagerScope, MultiProcessSession, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $actionKey;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29812(String str, Continuation<? super C29812> continuation) {
            super(3, continuation);
            this.$actionKey = str;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @NotNull MultiProcessSession multiProcessSession, @Nullable Continuation<? super Unit> continuation) {
            C29812 c29812 = new C29812(this.$actionKey, continuation);
            c29812.L$0 = multiProcessSession;
            return c29812.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MultiProcessSession multiProcessSession = (MultiProcessSession) this.L$0;
                String str = this.$actionKey;
                this.label = 1;
                if (multiProcessSession.runLambda(str, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$updateMultiProcessWidget$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessAppWidgetKt$updateMultiProcessWidget$2", m14021f = "MultiProcessAppWidget.kt", m14022i = {0}, m14023l = {32, 36, 40}, m14024m = "invokeSuspend", m14025n = {"$this$runWithLock"}, m14026s = {"L$0"})
    public static final class C29822 extends SuspendLambda implements Function2<SessionManagerScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ AppWidgetId $glanceId;
        final /* synthetic */ GlanceAppWidget $widget;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29822(Context context, AppWidgetId appWidgetId, GlanceAppWidget glanceAppWidget, Continuation<? super C29822> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$glanceId = appWidgetId;
            this.$widget = glanceAppWidget;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C29822 c29822 = new C29822(this.$context, this.$glanceId, this.$widget, continuation);
            c29822.L$0 = obj;
            return c29822;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C29822) create(sessionManagerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0087, code lost:
        
            if (r1.startSession(r12, r5, r11) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a6, code lost:
        
            if (((androidx.glance.appwidget.multiprocess.MultiProcessSession) r12).updateGlance(r11) == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            SessionManagerScope sessionManagerScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sessionManagerScope = (SessionManagerScope) this.L$0;
                Context context = this.$context;
                String sessionKey = AppWidgetUtilsKt.toSessionKey(this.$glanceId);
                this.L$0 = sessionManagerScope;
                this.label = 1;
                obj = sessionManagerScope.isSessionRunning(context, sessionKey, this);
                if (obj != coroutine_suspended) {
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
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            GlanceLog.INSTANCE.m2301i(MultiProcessAppWidgetKt.TAG, "Update " + this.$glanceId.getAppWidgetId() + " at not default process / " + zBooleanValue);
            if (zBooleanValue) {
                Session session = sessionManagerScope.getSession(AppWidgetUtilsKt.toSessionKey(this.$glanceId));
                Intrinsics.checkNotNull(session, "null cannot be cast to non-null type androidx.glance.appwidget.multiprocess.MultiProcessSession");
                this.L$0 = null;
                this.label = 3;
            } else {
                Context context2 = this.$context;
                MultiProcessSession multiProcessSession = new MultiProcessSession(this.$glanceId, this.$widget, null, 4, null);
                this.L$0 = null;
                this.label = 2;
            }
            return coroutine_suspended;
        }
    }

    @Nullable
    public static final Object deletedAtMultiProcess(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull AppWidgetId appWidgetId, @NotNull Continuation<? super Unit> continuation) {
        Object objRunWithLock = MultiProcessSessionManager.INSTANCE.runWithLock(new C29782(appWidgetId, null), continuation);
        return objRunWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunWithLock : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getOrCreateMultiProcessSession(SessionManager sessionManager, GlanceAppWidget glanceAppWidget, Context context, AppWidgetId appWidgetId, Bundle bundle, Function3<? super SessionManagerScope, ? super MultiProcessSession, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objRunWithLock = sessionManager.runWithLock(new C29792(context, appWidgetId, glanceAppWidget, function3, null), continuation);
        return objRunWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunWithLock : Unit.INSTANCE;
    }

    public static /* synthetic */ Object getOrCreateMultiProcessSession$default(SessionManager sessionManager, GlanceAppWidget glanceAppWidget, Context context, AppWidgetId appWidgetId, Bundle bundle, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            bundle = null;
        }
        return getOrCreateMultiProcessSession(sessionManager, glanceAppWidget, context, appWidgetId, bundle, function3, continuation);
    }

    @Nullable
    public static final Object resizeMultiProcessWidget(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull AppWidgetId appWidgetId, @Nullable Bundle bundle, @NotNull Continuation<? super Unit> continuation) {
        GlanceLog.INSTANCE.m2301i(TAG, "resize at not default process / " + appWidgetId.getAppWidgetId());
        Object orCreateMultiProcessSession = getOrCreateMultiProcessSession(MultiProcessSessionManager.INSTANCE, glanceAppWidget, context, appWidgetId, bundle, new C29802(bundle, null), continuation);
        return orCreateMultiProcessSession == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orCreateMultiProcessSession : Unit.INSTANCE;
    }

    public static /* synthetic */ Object resizeMultiProcessWidget$default(GlanceAppWidget glanceAppWidget, Context context, AppWidgetId appWidgetId, Bundle bundle, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            bundle = null;
        }
        return resizeMultiProcessWidget(glanceAppWidget, context, appWidgetId, bundle, continuation);
    }

    @Nullable
    public static final Object triggerMultiProcessAction(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull AppWidgetId appWidgetId, @NotNull String str, @Nullable Bundle bundle, @NotNull Continuation<? super Unit> continuation) {
        GlanceLog.INSTANCE.m2301i(TAG, "triggerAction " + str + " / " + appWidgetId.getAppWidgetId());
        Object orCreateMultiProcessSession = getOrCreateMultiProcessSession(MultiProcessSessionManager.INSTANCE, glanceAppWidget, context, appWidgetId, bundle, new C29812(str, null), continuation);
        return orCreateMultiProcessSession == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orCreateMultiProcessSession : Unit.INSTANCE;
    }

    public static /* synthetic */ Object triggerMultiProcessAction$default(GlanceAppWidget glanceAppWidget, Context context, AppWidgetId appWidgetId, String str, Bundle bundle, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            bundle = null;
        }
        return triggerMultiProcessAction(glanceAppWidget, context, appWidgetId, str, bundle, continuation);
    }

    @Nullable
    public static final Object updateMultiProcessWidget(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull AppWidgetId appWidgetId, @NotNull Continuation<? super Unit> continuation) {
        Object objRunWithLock = MultiProcessSessionManager.INSTANCE.runWithLock(new C29822(context, appWidgetId, glanceAppWidget, null), continuation);
        return objRunWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunWithLock : Unit.INSTANCE;
    }
}
