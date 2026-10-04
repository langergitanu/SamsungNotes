package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "listen", "Lkotlinx/coroutines/Job;", "Landroidx/work/impl/constraints/WorkConstraintsTracker;", "spec", "Landroidx/work/impl/model/WorkSpec;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;", "work-runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class WorkConstraintsTrackerKt {

    @NotNull
    private static final String TAG;

    /* JADX INFO: renamed from: androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", m14021f = "WorkConstraintsTracker.kt", m14022i = {}, m14023l = {54}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C40521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OnConstraintsStateChangedListener $listener;
        final /* synthetic */ WorkSpec $spec;
        final /* synthetic */ WorkConstraintsTracker $this_listen;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C40521(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, Continuation<? super C40521> continuation) {
            super(2, continuation);
            this.$this_listen = workConstraintsTracker;
            this.$spec = workSpec;
            this.$listener = onConstraintsStateChangedListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C40521(this.$this_listen, this.$spec, this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<ConstraintsState> flowTrack = this.$this_listen.track(this.$spec);
                final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.$listener;
                final WorkSpec workSpec = this.$spec;
                FlowCollector<? super ConstraintsState> flowCollector = new FlowCollector() { // from class: androidx.work.impl.constraints.WorkConstraintsTrackerKt.listen.1.1
                    @Nullable
                    public final Object emit(@NotNull ConstraintsState constraintsState, @NotNull Continuation<? super Unit> continuation) {
                        onConstraintsStateChangedListener.onConstraintsStateChanged(workSpec, constraintsState);
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ConstraintsState) obj2, (Continuation<? super Unit>) continuation);
                    }
                };
                this.label = 1;
                if (flowTrack.collect(flowCollector, this) == coroutine_suspended) {
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
            return ((C40521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkConstraintsTracker");
        Intrinsics.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"WorkConstraintsTracker\")");
        TAG = strTagWithPrefix;
    }

    @NotNull
    public static final Job listen(@NotNull WorkConstraintsTracker workConstraintsTracker, @NotNull WorkSpec spec, @NotNull CoroutineDispatcher dispatcher, @NotNull OnConstraintsStateChangedListener listener) {
        Intrinsics.checkNotNullParameter(workConstraintsTracker, "<this>");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher.plus(completableJobJob$default)), null, null, new C40521(workConstraintsTracker, spec, listener, null), 3, null);
        return completableJobJob$default;
    }
}
