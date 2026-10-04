package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020\tH\u0002J\u0015\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0000¢\u0006\u0002\b0J\r\u00101\u001a\u00020\u0007H\u0000¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0014H\u0000¢\u0006\u0002\b4R+\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000fR\u0011\u0010%\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b&\u0010\u000fR\u0014\u0010'\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000f¨\u00065"}, m13886d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshState;", "", "animationScope", "Lkotlinx/coroutines/CoroutineScope;", "onRefreshState", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "", "refreshingOffset", "", "threshold", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/State;FF)V", "<set-?>", "_position", "get_position", "()F", "set_position", "(F)V", "_position$delegate", "Landroidx/compose/runtime/MutableState;", "", "_refreshing", "get_refreshing", "()Z", "set_refreshing", "(Z)V", "_refreshing$delegate", "adjustedDistancePulled", "getAdjustedDistancePulled", "adjustedDistancePulled$delegate", "Landroidx/compose/runtime/State;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "position", "getPosition$material_release", "progress", "getProgress", "refreshing", "getRefreshing$material_release", "getThreshold$material_release", "animateIndicatorTo", "Lkotlinx/coroutines/Job;", TypedValues.Cycle.S_WAVE_OFFSET, "calculateIndicatorPosition", "onPull", "pullDelta", "onPull$material_release", "onRelease", "onRelease$material_release", "setRefreshing", "setRefreshing$material_release", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@ExperimentalMaterialApi
public final class PullRefreshState {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: _position$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState _position;

    /* JADX INFO: renamed from: _refreshing$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState _refreshing;

    /* JADX INFO: renamed from: adjustedDistancePulled$delegate, reason: from kotlin metadata */
    @NotNull
    private final State adjustedDistancePulled;

    @NotNull
    private final CoroutineScope animationScope;

    /* JADX INFO: renamed from: distancePulled$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState distancePulled;

    @NotNull
    private final State<Function0<Unit>> onRefreshState;
    private final float refreshingOffset;
    private final float threshold;

    /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1", m14021f = "PullRefreshState.kt", m14022i = {}, m14023l = {155}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C16971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $offset;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16971(float f, Continuation<? super C16971> continuation) {
            super(2, continuation);
            this.$offset = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return PullRefreshState.this.new C16971(this.$offset, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float f = PullRefreshState.this.get_position();
                float f4 = this.$offset;
                final PullRefreshState pullRefreshState = PullRefreshState.this;
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshState.animateIndicatorTo.1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Float f5, Float f6) {
                        invoke(f5.floatValue(), f6.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f5, float f6) {
                        pullRefreshState.set_position(f5);
                    }
                };
                this.label = 1;
                if (SuspendAnimationKt.animate$default(f, f4, 0.0f, null, function2, this, 12, null) == coroutine_suspended) {
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
            return ((C16971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PullRefreshState(@NotNull CoroutineScope animationScope, @NotNull State<? extends Function0<Unit>> onRefreshState, float f, float f4) {
        Intrinsics.checkNotNullParameter(animationScope, "animationScope");
        Intrinsics.checkNotNullParameter(onRefreshState, "onRefreshState");
        this.animationScope = animationScope;
        this.onRefreshState = onRefreshState;
        this.refreshingOffset = f;
        this.threshold = f4;
        this.adjustedDistancePulled = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material.pullrefresh.PullRefreshState$adjustedDistancePulled$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                return Float.valueOf(this.this$0.getDistancePulled() * 0.5f);
            }
        });
        this._refreshing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        Float fValueOf = Float.valueOf(0.0f);
        this._position = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.distancePulled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
    }

    private final Job animateIndicatorTo(float offset) {
        return BuildersKt__Builders_commonKt.launch$default(this.animationScope, null, null, new C16971(offset, null), 3, null);
    }

    private final float calculateIndicatorPosition() {
        if (getAdjustedDistancePulled() <= this.threshold) {
            return getAdjustedDistancePulled();
        }
        float fCoerceIn = RangesKt.coerceIn(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        float fPow = fCoerceIn - (((float) Math.pow(fCoerceIn, 2)) / 4);
        float f = this.threshold;
        return (fPow * f) + f;
    }

    private final float getAdjustedDistancePulled() {
        return ((Number) this.adjustedDistancePulled.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float getDistancePulled() {
        return ((Number) this.distancePulled.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float get_position() {
        return ((Number) this._position.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean get_refreshing() {
        return ((Boolean) this._refreshing.getValue()).booleanValue();
    }

    private final void setDistancePulled(float f) {
        this.distancePulled.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_position(float f) {
        this._position.setValue(Float.valueOf(f));
    }

    private final void set_refreshing(boolean z) {
        this._refreshing.setValue(Boolean.valueOf(z));
    }

    public final float getPosition$material_release() {
        return get_position();
    }

    public final float getProgress() {
        return getAdjustedDistancePulled() / this.threshold;
    }

    public final boolean getRefreshing$material_release() {
        return get_refreshing();
    }

    /* JADX INFO: renamed from: getThreshold$material_release, reason: from getter */
    public final float getThreshold() {
        return this.threshold;
    }

    public final float onPull$material_release(float pullDelta) {
        if (get_refreshing()) {
            return 0.0f;
        }
        float fCoerceAtLeast = RangesKt.coerceAtLeast(getDistancePulled() + pullDelta, 0.0f);
        float distancePulled = fCoerceAtLeast - getDistancePulled();
        setDistancePulled(fCoerceAtLeast);
        set_position(calculateIndicatorPosition());
        return distancePulled;
    }

    public final void onRelease$material_release() {
        if (!get_refreshing()) {
            if (getAdjustedDistancePulled() > this.threshold) {
                this.onRefreshState.getValue().invoke();
            } else {
                animateIndicatorTo(0.0f);
            }
        }
        setDistancePulled(0.0f);
    }

    public final void setRefreshing$material_release(boolean refreshing) {
        if (get_refreshing() != refreshing) {
            set_refreshing(refreshing);
            setDistancePulled(0.0f);
            animateIndicatorTo(refreshing ? this.refreshingOffset : 0.0f);
        }
    }
}
