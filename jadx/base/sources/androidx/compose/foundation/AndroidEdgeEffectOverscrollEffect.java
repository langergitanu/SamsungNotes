package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p109ui.input.pointer.PointerId;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.platform.InspectableValueKt;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.Velocity;
import androidx.compose.p109ui.unit.VelocityKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010#\u001a\u00020\u001fH\u0002J?\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\"\u0010'\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0)\u0012\u0006\u0012\u0004\u0018\u00010*0(H\u0096@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J6\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c02H\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u001cH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\b9J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001a\u0010?\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010>J\u001a\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bB\u0010>J\u001a\u0010C\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010>J\u001a\u0010E\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020\u0011H\u0002J\u001a\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\bK\u0010LR\u0016\u0010\u0007\u001a\u00020\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, m13886d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "scrollCycleInProgress", "animateToRelease", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "displacement", "displacement-F1C5BW0$foundation_release", "()J", "invalidateOverscroll", "invalidateOverscroll$foundation_release", "pullBottom", "", "scroll", "pullBottom-k-4lQ0M", "(J)F", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "pullTop", "pullTop-k-4lQ0M", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "updateSize", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidOverscroll.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidOverscroll.android.kt\nandroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect\n+ 2 InspectableValue.kt\nandroidx/compose/ui/platform/InspectableValueKt\n+ 3 AndroidOverscroll.android.kt\nandroidx/compose/foundation/EdgeEffectWrapper\n*L\n1#1,875:1\n135#2:876\n135#2:877\n806#3,5:878\n806#3,5:883\n*S KotlinDebug\n*F\n+ 1 AndroidOverscroll.android.kt\nandroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect\n*L\n664#1:876\n674#1:877\n585#1:878,5\n691#1:883,5\n*E\n"})
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private long containerSize;

    @NotNull
    private final EdgeEffectWrapper edgeEffectWrapper;

    @NotNull
    private final Modifier effectModifier;
    private boolean invalidationEnabled;

    @Nullable
    private PointerId pointerId;

    @Nullable
    private Offset pointerPosition;

    @NotNull
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;

    public AndroidEdgeEffectOverscrollEffect(@NotNull Context context, @NotNull OverscrollConfiguration overscrollConfiguration) {
        Modifier drawGlowOverscrollModifier;
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m18579toArgb8_81llA(overscrollConfiguration.getGlowColor()));
        this.edgeEffectWrapper = edgeEffectWrapper;
        Unit unit = Unit.INSTANCE;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(unit, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m18362getZeroNHjbRc();
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, unit, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null));
        if (Build.VERSION.SDK_INT >= 31) {
            drawGlowOverscrollModifier = new DrawStretchOverscrollModifier(this, edgeEffectWrapper, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("overscroll");
                    inspectorInfo.setValue(this.this$0);
                }
            } : InspectableValueKt.getNoInspectorInfo());
        } else {
            drawGlowOverscrollModifier = new DrawGlowOverscrollModifier(this, edgeEffectWrapper, overscrollConfiguration, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("overscroll");
                    inspectorInfo.setValue(this.this$0);
                }
            } : InspectableValueKt.getNoInspectorInfo());
        }
        this.effectModifier = modifierPointerInput.then(drawGlowOverscrollModifier);
    }

    private final void animateToRelease() {
        boolean zIsFinished;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = edgeEffect.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished = edgeEffect2.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished = edgeEffect3.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished = edgeEffect4.isFinished() || zIsFinished;
        }
        if (zIsFinished) {
            invalidateOverscroll$foundation_release();
        }
    }

    /* JADX INFO: renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m15385pullBottomk4lQ0M(long scroll) {
        float fM18284getXimpl = Offset.m18284getXimpl(m15392displacementF1C5BW0$foundation_release());
        float fM18285getYimpl = Offset.m18285getYimpl(scroll) / Size.m18350getHeightimpl(this.containerSize);
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateBottomEffect) == 0.0f ? Size.m18350getHeightimpl(this.containerSize) * (-edgeEffectCompat.onPullDistanceCompat(orCreateBottomEffect, -fM18285getYimpl, 1 - fM18284getXimpl)) : Offset.m18285getYimpl(scroll);
    }

    /* JADX INFO: renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m15386pullLeftk4lQ0M(long scroll) {
        float fM18285getYimpl = Offset.m18285getYimpl(m15392displacementF1C5BW0$foundation_release());
        float fM18284getXimpl = Offset.m18284getXimpl(scroll) / Size.m18353getWidthimpl(this.containerSize);
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateLeftEffect) == 0.0f ? Size.m18353getWidthimpl(this.containerSize) * edgeEffectCompat.onPullDistanceCompat(orCreateLeftEffect, fM18284getXimpl, 1 - fM18285getYimpl) : Offset.m18284getXimpl(scroll);
    }

    /* JADX INFO: renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m15387pullRightk4lQ0M(long scroll) {
        float fM18285getYimpl = Offset.m18285getYimpl(m15392displacementF1C5BW0$foundation_release());
        float fM18284getXimpl = Offset.m18284getXimpl(scroll) / Size.m18353getWidthimpl(this.containerSize);
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateRightEffect) == 0.0f ? Size.m18353getWidthimpl(this.containerSize) * (-edgeEffectCompat.onPullDistanceCompat(orCreateRightEffect, -fM18284getXimpl, fM18285getYimpl)) : Offset.m18284getXimpl(scroll);
    }

    /* JADX INFO: renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m15388pullTopk4lQ0M(long scroll) {
        float fM18284getXimpl = Offset.m18284getXimpl(m15392displacementF1C5BW0$foundation_release());
        float fM18285getYimpl = Offset.m18285getYimpl(scroll) / Size.m18350getHeightimpl(this.containerSize);
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateTopEffect) == 0.0f ? Size.m18350getHeightimpl(this.containerSize) * edgeEffectCompat.onPullDistanceCompat(orCreateTopEffect, fM18285getYimpl, fM18284getXimpl) : Offset.m18285getYimpl(scroll);
    }

    /* JADX INFO: renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m15389releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean z;
        if (!this.edgeEffectWrapper.isLeftAnimating() || Offset.m18284getXimpl(delta) >= 0.0f) {
            z = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Offset.m18284getXimpl(delta));
            z = !this.edgeEffectWrapper.isLeftAnimating();
        }
        if (this.edgeEffectWrapper.isRightAnimating() && Offset.m18284getXimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Offset.m18284getXimpl(delta));
            z = z || !this.edgeEffectWrapper.isRightAnimating();
        }
        if (this.edgeEffectWrapper.isTopAnimating() && Offset.m18285getYimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Offset.m18285getYimpl(delta));
            z = z || !this.edgeEffectWrapper.isTopAnimating();
        }
        if (!this.edgeEffectWrapper.isBottomAnimating() || Offset.m18285getYimpl(delta) <= 0.0f) {
            return z;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Offset.m18285getYimpl(delta));
        return z || !this.edgeEffectWrapper.isBottomAnimating();
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        if (this.edgeEffectWrapper.isLeftStretched()) {
            m15386pullLeftk4lQ0M(Offset.INSTANCE.m18300getZeroF1C5BW0());
            z = true;
        } else {
            z = false;
        }
        if (this.edgeEffectWrapper.isRightStretched()) {
            m15387pullRightk4lQ0M(Offset.INSTANCE.m18300getZeroF1C5BW0());
            z = true;
        }
        if (this.edgeEffectWrapper.isTopStretched()) {
            m15388pullTopk4lQ0M(Offset.INSTANCE.m18300getZeroF1C5BW0());
            z = true;
        }
        if (!this.edgeEffectWrapper.isBottomStretched()) {
            return z;
        }
        m15385pullBottomk4lQ0M(Offset.INSTANCE.m18300getZeroF1C5BW0());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r13.invoke(r11, r0) == r1) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.OverscrollEffect
    @Nullable
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo15390applyToFlingBMRW4eQ(long j, @NotNull Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        float fM21205getXimpl;
        float fM21206getYimpl;
        long jM21208minusAH228Gc;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect;
        long jM21208minusAH228Gc2;
        if (continuation instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) continuation;
            int i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = i - Integer.MIN_VALUE;
            } else {
                androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
            }
        }
        Object objInvoke = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objInvoke);
                return Unit.INSTANCE;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jM21208minusAH228Gc = androidEdgeEffectOverscrollEffect$applyToFling$1.J$0;
            androidEdgeEffectOverscrollEffect = (AndroidEdgeEffectOverscrollEffect) androidEdgeEffectOverscrollEffect$applyToFling$1.L$0;
            ResultKt.throwOnFailure(objInvoke);
            jM21208minusAH228Gc2 = Velocity.m21208minusAH228Gc(jM21208minusAH228Gc, ((Velocity) objInvoke).getPackedValue());
            androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
            if (Velocity.m21205getXimpl(jM21208minusAH228Gc2) <= 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m21205getXimpl(jM21208minusAH228Gc2)));
            } else if (Velocity.m21205getXimpl(jM21208minusAH228Gc2) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m21205getXimpl(jM21208minusAH228Gc2)));
            }
            if (Velocity.m21206getYimpl(jM21208minusAH228Gc2) <= 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m21206getYimpl(jM21208minusAH228Gc2)));
            } else if (Velocity.m21206getYimpl(jM21208minusAH228Gc2) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m21206getYimpl(jM21208minusAH228Gc2)));
            }
            if (!Velocity.m21204equalsimpl0(jM21208minusAH228Gc2, Velocity.INSTANCE.m21216getZero9UxMQ8M())) {
                androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation_release();
            }
            androidEdgeEffectOverscrollEffect.animateToRelease();
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(objInvoke);
        if (Size.m18355isEmptyimpl(this.containerSize)) {
            Velocity velocityM21196boximpl = Velocity.m21196boximpl(j);
            androidEdgeEffectOverscrollEffect$applyToFling$1.label = 1;
        } else {
            if (Velocity.m21205getXimpl(j) > 0.0f && this.edgeEffectWrapper.isLeftStretched()) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m21205getXimpl(j)));
                fM21205getXimpl = Velocity.m21205getXimpl(j);
            } else if (Velocity.m21205getXimpl(j) >= 0.0f || !this.edgeEffectWrapper.isRightStretched()) {
                fM21205getXimpl = 0.0f;
            } else {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m21205getXimpl(j)));
                fM21205getXimpl = Velocity.m21205getXimpl(j);
            }
            if (Velocity.m21206getYimpl(j) > 0.0f && this.edgeEffectWrapper.isTopStretched()) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m21206getYimpl(j)));
                fM21206getYimpl = Velocity.m21206getYimpl(j);
            } else if (Velocity.m21206getYimpl(j) >= 0.0f || !this.edgeEffectWrapper.isBottomStretched()) {
                fM21206getYimpl = 0.0f;
            } else {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m21206getYimpl(j)));
                fM21206getYimpl = Velocity.m21206getYimpl(j);
            }
            long jVelocity = VelocityKt.Velocity(fM21205getXimpl, fM21206getYimpl);
            if (!Velocity.m21204equalsimpl0(jVelocity, Velocity.INSTANCE.m21216getZero9UxMQ8M())) {
                invalidateOverscroll$foundation_release();
            }
            jM21208minusAH228Gc = Velocity.m21208minusAH228Gc(j, jVelocity);
            Velocity velocityM21196boximpl2 = Velocity.m21196boximpl(jM21208minusAH228Gc);
            androidEdgeEffectOverscrollEffect$applyToFling$1.L$0 = this;
            androidEdgeEffectOverscrollEffect$applyToFling$1.J$0 = jM21208minusAH228Gc;
            androidEdgeEffectOverscrollEffect$applyToFling$1.label = 2;
            objInvoke = function2.invoke(velocityM21196boximpl2, androidEdgeEffectOverscrollEffect$applyToFling$1);
            if (objInvoke != coroutine_suspended) {
                androidEdgeEffectOverscrollEffect = this;
                jM21208minusAH228Gc2 = Velocity.m21208minusAH228Gc(jM21208minusAH228Gc, ((Velocity) objInvoke).getPackedValue());
                androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
                if (Velocity.m21205getXimpl(jM21208minusAH228Gc2) <= 0.0f) {
                }
                if (Velocity.m21206getYimpl(jM21208minusAH228Gc2) <= 0.0f) {
                }
                if (!Velocity.m21204equalsimpl0(jM21208minusAH228Gc2, Velocity.INSTANCE.m21216getZero9UxMQ8M())) {
                }
                androidEdgeEffectOverscrollEffect.animateToRelease();
                return Unit.INSTANCE;
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011b A[ADDED_TO_REGION] */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo15391applyToScrollRhakbz0(long delta, int source, @NotNull Function1<? super Offset, Offset> performScroll) {
        float fM15385pullBottomk4lQ0M;
        boolean z;
        boolean z2;
        if (Size.m18355isEmptyimpl(this.containerSize)) {
            return performScroll.invoke(Offset.m18273boximpl(delta)).getPackedValue();
        }
        boolean z3 = true;
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        float fM15387pullRightk4lQ0M = 0.0f;
        if (Offset.m18285getYimpl(delta) != 0.0f) {
            if (this.edgeEffectWrapper.isTopStretched()) {
                fM15385pullBottomk4lQ0M = m15388pullTopk4lQ0M(delta);
                if (!this.edgeEffectWrapper.isTopStretched()) {
                    this.edgeEffectWrapper.getOrCreateTopEffect().onRelease();
                }
            } else if (this.edgeEffectWrapper.isBottomStretched()) {
                fM15385pullBottomk4lQ0M = m15385pullBottomk4lQ0M(delta);
                if (!this.edgeEffectWrapper.isBottomStretched()) {
                    this.edgeEffectWrapper.getOrCreateBottomEffect().onRelease();
                }
            } else {
                fM15385pullBottomk4lQ0M = 0.0f;
            }
        }
        if (Offset.m18284getXimpl(delta) != 0.0f) {
            if (this.edgeEffectWrapper.isLeftStretched()) {
                fM15387pullRightk4lQ0M = m15386pullLeftk4lQ0M(delta);
                if (!this.edgeEffectWrapper.isLeftStretched()) {
                    this.edgeEffectWrapper.getOrCreateLeftEffect().onRelease();
                }
            } else if (this.edgeEffectWrapper.isRightStretched()) {
                fM15387pullRightk4lQ0M = m15387pullRightk4lQ0M(delta);
                if (!this.edgeEffectWrapper.isRightStretched()) {
                    this.edgeEffectWrapper.getOrCreateRightEffect().onRelease();
                }
            }
        }
        long jOffset = OffsetKt.Offset(fM15387pullRightk4lQ0M, fM15385pullBottomk4lQ0M);
        if (!Offset.m18281equalsimpl0(jOffset, Offset.INSTANCE.m18300getZeroF1C5BW0())) {
            invalidateOverscroll$foundation_release();
        }
        long jM18288minusMKHz9U = Offset.m18288minusMKHz9U(delta, jOffset);
        long packedValue = performScroll.invoke(Offset.m18273boximpl(jM18288minusMKHz9U)).getPackedValue();
        long jM18288minusMKHz9U2 = Offset.m18288minusMKHz9U(jM18288minusMKHz9U, packedValue);
        boolean z4 = false;
        if (NestedScrollSource.m19609equalsimpl0(source, NestedScrollSource.INSTANCE.m19621getUserInputWNlRxjI())) {
            if (Offset.m18284getXimpl(jM18288minusMKHz9U2) > 0.5f) {
                m15386pullLeftk4lQ0M(jM18288minusMKHz9U2);
            } else if (Offset.m18284getXimpl(jM18288minusMKHz9U2) < -0.5f) {
                m15387pullRightk4lQ0M(jM18288minusMKHz9U2);
            } else {
                z = false;
                if (Offset.m18285getYimpl(jM18288minusMKHz9U2) <= 0.5f) {
                    m15388pullTopk4lQ0M(jM18288minusMKHz9U2);
                } else if (Offset.m18285getYimpl(jM18288minusMKHz9U2) < -0.5f) {
                    m15385pullBottomk4lQ0M(jM18288minusMKHz9U2);
                } else {
                    z2 = false;
                    if (!z && !z2) {
                        z3 = false;
                    }
                    z4 = z3;
                }
                z2 = true;
                if (!z) {
                    z3 = false;
                }
                z4 = z3;
            }
            z = true;
            if (Offset.m18285getYimpl(jM18288minusMKHz9U2) <= 0.5f) {
            }
            z2 = true;
            if (!z) {
            }
            z4 = z3;
        }
        if (m15389releaseOppositeOverscrollk4lQ0M(delta) || z4) {
            invalidateOverscroll$foundation_release();
        }
        return Offset.m18289plusMKHz9U(jOffset, packedValue);
    }

    /* JADX INFO: renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m15392displacementF1C5BW0$foundation_release() {
        Offset offset = this.pointerPosition;
        long packedValue = offset != null ? offset.getPackedValue() : SizeKt.m18363getCenteruvyYCjk(this.containerSize);
        return OffsetKt.Offset(Offset.m18284getXimpl(packedValue) / Size.m18353getWidthimpl(this.containerSize), Offset.m18285getYimpl(packedValue) / Size.m18350getHeightimpl(this.containerSize));
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    @NotNull
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    /* JADX INFO: renamed from: getInvalidationEnabled$foundation_release, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    @NotNull
    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        return (edgeEffect4 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect4) == 0.0f) ? false : true;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX INFO: renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m15393updateSizeuvyYCjk$foundation_release(long size) {
        boolean zM18349equalsimpl0 = Size.m18349equalsimpl0(this.containerSize, Size.INSTANCE.m18362getZeroNHjbRc());
        boolean zM18349equalsimpl02 = Size.m18349equalsimpl0(size, this.containerSize);
        this.containerSize = size;
        if (!zM18349equalsimpl02) {
            this.edgeEffectWrapper.m15464setSizeozmzZPI(IntSizeKt.IntSize(MathKt.roundToInt(Size.m18353getWidthimpl(size)), MathKt.roundToInt(Size.m18350getHeightimpl(size))));
        }
        if (zM18349equalsimpl0 || zM18349equalsimpl02) {
            return;
        }
        invalidateOverscroll$foundation_release();
        animateToRelease();
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }
}
