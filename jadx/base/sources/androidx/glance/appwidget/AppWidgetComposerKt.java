package androidx.glance.appwidget;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.compose.p109ui.unit.DpSize;
import androidx.glance.ExperimentalGlanceApi;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.SizeMode;
import androidx.glance.appwidget.UnmanagedSessionReceiver;
import androidx.glance.session.SessionWorkerKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001aM\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aL\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, m13886d2 = {"compose", "Landroid/widget/RemoteViews;", "Landroidx/glance/appwidget/GlanceAppWidget;", "context", "Landroid/content/Context;", "id", "Landroidx/glance/GlanceId;", "options", "Landroid/os/Bundle;", "size", "Landroidx/compose/ui/unit/DpSize;", "state", "", "compose-DR8WL-M", "(Landroidx/glance/appwidget/GlanceAppWidget;Landroid/content/Context;Landroidx/glance/GlanceId;Landroid/os/Bundle;Landroidx/compose/ui/unit/DpSize;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runComposition", "Lkotlinx/coroutines/flow/Flow;", "sizes", "", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppWidgetComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetComposer.kt\nandroidx/glance/appwidget/AppWidgetComposerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public final class AppWidgetComposerKt {

    /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetComposerKt$runComposition$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroid/widget/RemoteViews;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetComposerKt$runComposition$1", m14021f = "AppWidgetComposer.kt", m14022i = {}, m14023l = {104}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nAppWidgetComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetComposer.kt\nandroidx/glance/appwidget/AppWidgetComposerKt$runComposition$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
    public static final class C28251 extends SuspendLambda implements Function2<FlowCollector<? super RemoteViews>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ GlanceId $id;
        final /* synthetic */ Bundle $options;
        final /* synthetic */ List<DpSize> $sizes;
        final /* synthetic */ Object $state;
        final /* synthetic */ GlanceAppWidget $this_runComposition;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetComposerKt$runComposition$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetComposerKt$runComposition$1$1", m14021f = "AppWidgetComposer.kt", m14022i = {}, m14023l = {116}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowCollector<RemoteViews> $$this$flow;
            final /* synthetic */ Context $context;
            final /* synthetic */ GlanceId $id;
            final /* synthetic */ AppWidgetSession $session;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetComposerKt$runComposition$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetComposerKt$runComposition$1$1$1", m14021f = "AppWidgetComposer.kt", m14022i = {}, m14023l = {108}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C145631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ GlanceId $id;
                final /* synthetic */ AppWidgetSession $session;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C145631(GlanceId glanceId, AppWidgetSession appWidgetSession, Continuation<? super C145631> continuation) {
                    super(2, continuation);
                    this.$id = glanceId;
                    this.$session = appWidgetSession;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C145631(this.$id, this.$session, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        UnmanagedSessionReceiver.Companion companion = UnmanagedSessionReceiver.INSTANCE;
                        int appWidgetId = ((AppWidgetId) this.$id).getAppWidgetId();
                        AppWidgetSession appWidgetSession = this.$session;
                        this.label = 1;
                        if (companion.registerSession(appWidgetId, appWidgetSession, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new KotlinNothingValueException();
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C145631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: renamed from: androidx.glance.appwidget.AppWidgetComposerKt$runComposition$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetComposerKt$runComposition$1$1$2", m14021f = "AppWidgetComposer.kt", m14022i = {}, m14023l = {111}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ Context $context;
                final /* synthetic */ AppWidgetSession $session;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(AppWidgetSession appWidgetSession, Context context, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$session = appWidgetSession;
                    this.$context = context;
                    this.$$this$coroutineScope = coroutineScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass2(this.$session, this.$context, this.$$this$coroutineScope, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        AppWidgetSession appWidgetSession = this.$session;
                        Context context = this.$context;
                        this.label = 1;
                        if (SessionWorkerKt.runSession(appWidgetSession, context, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    CoroutineScopeKt.cancel$default(this.$$this$coroutineScope, null, 1, null);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(AppWidgetSession appWidgetSession, GlanceId glanceId, Context context, FlowCollector<? super RemoteViews> flowCollector, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$session = appWidgetSession;
                this.$id = glanceId;
                this.$context = context;
                this.$$this$flow = flowCollector;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$session, this.$id, this.$context, this.$$this$flow, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C145631(this.$id, this.$session, null), 3, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.$session, this.$context, coroutineScope, null), 3, null);
                    Flow flowFilterNotNull = FlowKt.filterNotNull(this.$session.getLastRemoteViews$glance_appwidget_release());
                    final FlowCollector<RemoteViews> flowCollector = this.$$this$flow;
                    FlowCollector flowCollector2 = new FlowCollector() { // from class: androidx.glance.appwidget.AppWidgetComposerKt.runComposition.1.1.3
                        @Nullable
                        public final Object emit(@NotNull RemoteViews remoteViews, @NotNull Continuation<? super Unit> continuation) {
                            Object objEmit = flowCollector.emit(remoteViews, continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                        }

                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((RemoteViews) obj2, (Continuation<? super Unit>) continuation);
                        }
                    };
                    this.label = 1;
                    if (flowFilterNotNull.collect(flowCollector2, this) == coroutine_suspended) {
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
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28251(GlanceId glanceId, List<DpSize> list, Bundle bundle, Context context, GlanceAppWidget glanceAppWidget, Object obj, Continuation<? super C28251> continuation) {
            super(2, continuation);
            this.$id = glanceId;
            this.$sizes = list;
            this.$options = bundle;
            this.$context = context;
            this.$this_runComposition = glanceAppWidget;
            this.$state = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C28251 c28251 = new C28251(this.$id, this.$sizes, this.$options, this.$context, this.$this_runComposition, this.$state, continuation);
            c28251.L$0 = obj;
            return c28251;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Bundle bundleOptionsBundleOf;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                GlanceId glanceId = this.$id;
                Intrinsics.checkNotNull(glanceId, "null cannot be cast to non-null type androidx.glance.appwidget.AppWidgetId");
                AppWidgetId appWidgetId = (AppWidgetId) glanceId;
                List<DpSize> list = this.$sizes;
                if (list != null) {
                    Bundle bundle = this.$options;
                    bundleOptionsBundleOf = AppWidgetUtilsKt.optionsBundleOf(list);
                    bundleOptionsBundleOf.putAll(bundle);
                } else {
                    bundleOptionsBundleOf = this.$options;
                }
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(new AppWidgetSession(this.$this_runComposition, appWidgetId, bundleOptionsBundleOf, null, new ComponentName(this.$context, (Class<?>) UnmanagedSessionReceiver.class), this.$sizes != null ? SizeMode.Exact.INSTANCE : ((this.$this_runComposition.getSizeMode() instanceof SizeMode.Responsive) || AppWidgetUtilsKt.isRealId((AppWidgetId) this.$id)) ? this.$this_runComposition.getSizeMode() : SizeMode.Exact.INSTANCE, false, this.$state, 8, null), this.$id, this.$context, flowCollector, null);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
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
        public final Object invoke(@NotNull FlowCollector<? super RemoteViews> flowCollector, @Nullable Continuation<? super Unit> continuation) {
            return ((C28251) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: compose-DR8WL-M, reason: not valid java name */
    public static final Object m21261composeDR8WLM(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull GlanceId glanceId, @Nullable Bundle bundle, @Nullable DpSize dpSize, @Nullable Object obj, @NotNull Continuation<? super RemoteViews> continuation) {
        List listListOf;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (dpSize != null) {
            dpSize.getPackedValue();
            listListOf = CollectionsKt.listOf(dpSize);
        } else {
            listListOf = null;
        }
        return FlowKt.first(runComposition(glanceAppWidget, context, glanceId, bundle2, listListOf, obj), continuation);
    }

    /* JADX INFO: renamed from: compose-DR8WL-M$default, reason: not valid java name */
    public static /* synthetic */ Object m21262composeDR8WLM$default(GlanceAppWidget glanceAppWidget, Context context, GlanceId glanceId, Bundle bundle, DpSize dpSize, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            glanceId = AppWidgetUtilsKt.createFakeAppWidgetId();
        }
        return m21261composeDR8WLM(glanceAppWidget, context, glanceId, (i & 4) != 0 ? null : bundle, (i & 8) != 0 ? null : dpSize, (i & 16) != 0 ? null : obj, continuation);
    }

    @ExperimentalGlanceApi
    @SuppressLint({"PrimitiveInCollection"})
    @NotNull
    public static final Flow<RemoteViews> runComposition(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull GlanceId id, @NotNull Bundle options, @Nullable List<DpSize> list, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(glanceAppWidget, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(options, "options");
        return FlowKt.flow(new C28251(id, list, options, context, glanceAppWidget, obj, null));
    }

    public static /* synthetic */ Flow runComposition$default(GlanceAppWidget glanceAppWidget, Context context, GlanceId glanceId, Bundle bundle, List list, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            glanceId = AppWidgetUtilsKt.createFakeAppWidgetId();
        }
        GlanceId glanceId2 = glanceId;
        if ((i & 4) != 0) {
            bundle = new Bundle();
        }
        return runComposition(glanceAppWidget, context, glanceId2, bundle, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : obj);
    }
}
