package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.animation.core.InfiniteTransition$run$1$1", m14021f = "InfiniteTransition.kt", m14022i = {0, 0, 1, 1}, m14023l = {181, 205}, m14024m = "invokeSuspend", m14025n = {"$this$LaunchedEffect", "durationScale", "$this$LaunchedEffect", "durationScale"}, m14026s = {"L$0", "L$1", "L$0", "L$1"})
public final class InfiniteTransition$run$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<State<Long>> $toolingOverride;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InfiniteTransition this$0;

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$1$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT, ""}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.animation.core.InfiniteTransition$run$1$1$3", m14021f = "InfiniteTransition.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C07213 extends SuspendLambda implements Function2<Float, Continuation<? super Boolean>, Object> {
        /* synthetic */ float F$0;
        int label;

        public C07213(Continuation<? super C07213> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C07213 c07213 = new C07213(continuation);
            c07213.F$0 = ((Number) obj).floatValue();
            return c07213;
        }

        @Nullable
        public final Object invoke(float f, @Nullable Continuation<? super Boolean> continuation) {
            return ((C07213) create(Float.valueOf(f), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.F$0 > 0.0f);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Float f, Continuation<? super Boolean> continuation) {
            return invoke(f.floatValue(), continuation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfiniteTransition$run$1$1(MutableState<State<Long>> mutableState, InfiniteTransition infiniteTransition, Continuation<? super InfiniteTransition$run$1$1> continuation) {
        super(2, continuation);
        this.$toolingOverride = mutableState;
        this.this$0 = infiniteTransition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        InfiniteTransition$run$1$1 infiniteTransition$run$1$1 = new InfiniteTransition$run$1$1(this.$toolingOverride, this.this$0, continuation);
        infiniteTransition$run$1$1.L$0 = obj;
        return infiniteTransition$run$1$1;
    }

    /* JADX WARN: Path cross not found for [B:11:0x0040, B:16:0x005d], limit reached: 18 */
    /* JADX WARN: Path cross not found for [B:16:0x005d, B:11:0x0040], limit reached: 18 */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[PHI: r1 r8
      0x0056: PHI (r1v2 kotlin.jvm.internal.Ref$FloatRef) = (r1v3 kotlin.jvm.internal.Ref$FloatRef), (r1v5 kotlin.jvm.internal.Ref$FloatRef) binds: [B:12:0x0053, B:9:0x0023] A[DONT_GENERATE, DONT_INLINE]
      0x0056: PHI (r8v3 kotlinx.coroutines.CoroutineScope) = (r8v4 kotlinx.coroutines.CoroutineScope), (r8v5 kotlinx.coroutines.CoroutineScope) binds: [B:12:0x0053, B:9:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005b -> B:11:0x0040). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0076 -> B:11:0x0040). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        final CoroutineScope coroutineScope;
        final Ref.FloatRef floatRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            floatRef = new Ref.FloatRef();
            floatRef.element = 1.0f;
        } else if (i == 1) {
            floatRef = (Ref.FloatRef) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope2;
            if (floatRef.element == 0.0f) {
                Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Float>() { // from class: androidx.compose.animation.core.InfiniteTransition$run$1$1.2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Float invoke() {
                        return Float.valueOf(SuspendAnimationKt.getDurationScale(coroutineScope.getCoroutineContext()));
                    }
                });
                C07213 c07213 = new C07213(null);
                this.L$0 = coroutineScope;
                this.L$1 = floatRef;
                this.label = 2;
                if (FlowKt.first(flowSnapshotFlow, c07213, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) this.L$1;
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope3;
        }
        final MutableState<State<Long>> mutableState = this.$toolingOverride;
        final InfiniteTransition infiniteTransition = this.this$0;
        Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.InfiniteTransition$run$1$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                State<Long> value = mutableState.getValue();
                long jLongValue = value != null ? value.getValue().longValue() : j;
                int i2 = 0;
                if (infiniteTransition.startTimeNanos == Long.MIN_VALUE || floatRef.element != SuspendAnimationKt.getDurationScale(coroutineScope.getCoroutineContext())) {
                    infiniteTransition.startTimeNanos = j;
                    MutableVector mutableVector = infiniteTransition._animations;
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        Object[] content = mutableVector.getContent();
                        int i4 = 0;
                        do {
                            ((InfiniteTransition.TransitionAnimationState) content[i4]).reset$animation_core_release();
                            i4++;
                        } while (i4 < size);
                    }
                    floatRef.element = SuspendAnimationKt.getDurationScale(coroutineScope.getCoroutineContext());
                }
                if (floatRef.element != 0.0f) {
                    infiniteTransition.onFrame((long) ((jLongValue - infiniteTransition.startTimeNanos) / floatRef.element));
                    return;
                }
                MutableVector mutableVector2 = infiniteTransition._animations;
                int size2 = mutableVector2.getSize();
                if (size2 > 0) {
                    Object[] content2 = mutableVector2.getContent();
                    do {
                        ((InfiniteTransition.TransitionAnimationState) content2[i2]).skipToEnd$animation_core_release();
                        i2++;
                    } while (i2 < size2);
                }
            }
        };
        this.L$0 = coroutineScope;
        this.L$1 = floatRef;
        this.label = 1;
        if (InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, this) != coroutine_suspended) {
            if (floatRef.element == 0.0f) {
            }
            final MutableState<State<Long>> mutableState2 = this.$toolingOverride;
            final InfiniteTransition infiniteTransition2 = this.this$0;
            Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.InfiniteTransition$run$1$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                    invoke(l.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j) {
                    State<Long> value = mutableState2.getValue();
                    long jLongValue = value != null ? value.getValue().longValue() : j;
                    int i2 = 0;
                    if (infiniteTransition2.startTimeNanos == Long.MIN_VALUE || floatRef.element != SuspendAnimationKt.getDurationScale(coroutineScope.getCoroutineContext())) {
                        infiniteTransition2.startTimeNanos = j;
                        MutableVector mutableVector = infiniteTransition2._animations;
                        int size = mutableVector.getSize();
                        if (size > 0) {
                            Object[] content = mutableVector.getContent();
                            int i4 = 0;
                            do {
                                ((InfiniteTransition.TransitionAnimationState) content[i4]).reset$animation_core_release();
                                i4++;
                            } while (i4 < size);
                        }
                        floatRef.element = SuspendAnimationKt.getDurationScale(coroutineScope.getCoroutineContext());
                    }
                    if (floatRef.element != 0.0f) {
                        infiniteTransition2.onFrame((long) ((jLongValue - infiniteTransition2.startTimeNanos) / floatRef.element));
                        return;
                    }
                    MutableVector mutableVector2 = infiniteTransition2._animations;
                    int size2 = mutableVector2.getSize();
                    if (size2 > 0) {
                        Object[] content2 = mutableVector2.getContent();
                        do {
                            ((InfiniteTransition.TransitionAnimationState) content2[i2]).skipToEnd$animation_core_release();
                            i2++;
                        } while (i2 < size2);
                    }
                }
            };
            this.L$0 = coroutineScope;
            this.L$1 = floatRef;
            this.label = 1;
            if (InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function12, this) != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((InfiniteTransition$run$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
