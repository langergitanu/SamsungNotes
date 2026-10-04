package androidx.compose.animation.core;

import androidx.annotation.RestrictTo;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\b\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001B!\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tB!\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bB/\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ'\u0010S\u001a\u00020#2\u0018\u0010T\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bUJ\u0019\u0010V\u001a\u00020#2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bXJ\u0017\u0010Y\u001a\u00020Z2\u0006\u0010D\u001a\u00028\u0000H\u0001¢\u0006\u0004\b[\u0010\\J\b\u0010]\u001a\u00020\u0012H\u0002J\r\u0010^\u001a\u00020ZH\u0000¢\u0006\u0002\b_J\b\u0010`\u001a\u00020ZH\u0002J\r\u0010a\u001a\u00020ZH\u0000¢\u0006\u0002\bbJ\u001d\u0010c\u001a\u00020Z2\u0006\u0010d\u001a\u00020\u00122\u0006\u0010e\u001a\u00020#H\u0000¢\u0006\u0002\bfJ\u001d\u0010c\u001a\u00020Z2\u0006\u0010g\u001a\u00020\u00122\u0006\u0010h\u001a\u00020iH\u0000¢\u0006\u0002\bfJ\r\u0010j\u001a\u00020ZH\u0000¢\u0006\u0002\bkJ\u0015\u0010l\u001a\u00020Z2\u0006\u0010g\u001a\u00020\u0012H\u0000¢\u0006\u0002\bmJ'\u0010n\u001a\u00020Z2\u0018\u0010o\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030pR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bqJ'\u0010n\u001a\u00020Z2\u0018\u0010T\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bqJ\u0019\u0010r\u001a\u00020#2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bsJ\u0015\u0010t\u001a\u00020Z2\u0006\u0010u\u001a\u00020iH\u0000¢\u0006\u0002\bvJ\b\u0010w\u001a\u00020ZH\u0002J\u0015\u0010x\u001a\u00020Z2\u0006\u00106\u001a\u00020\u0012H\u0000¢\u0006\u0002\byJ\u0015\u0010z\u001a\u00020Z2\u0006\u0010{\u001a\u00020|H\u0000¢\u0006\u0002\b}J(\u0010~\u001a\u00020Z2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010D\u001a\u00028\u00002\u0006\u00106\u001a\u00020\u0012H\u0007¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\t\u0010\u0081\u0001\u001a\u00020\u0006H\u0016J\u000f\u0010\u0082\u0001\u001a\u00020ZH\u0000¢\u0006\u0003\b\u0083\u0001J\u0019\u0010\u0084\u0001\u001a\u00020Z2\u0006\u0010D\u001a\u00028\u0000H\u0000¢\u0006\u0005\b\u0085\u0001\u0010GR&\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#8GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b(\u0010'R+\u0010)\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020#8G@AX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b)\u0010'\"\u0004\b*\u0010+R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u0019\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R$\u00106\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R7\u0010:\u001a\b\u0012\u0004\u0012\u00028\u0000092\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u0000098F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010-\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R+\u0010@\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\u0019\u001a\u0004\bA\u0010\u0015\"\u0004\bB\u0010\u0017R+\u0010D\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010-\u001a\u0004\bE\u0010!\"\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bJ\u0010\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010M\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u001c8F¢\u0006\u0006\u001a\u0004\bN\u0010\u001eR+\u0010O\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020#8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010-\u001a\u0004\bP\u0010'\"\u0004\bQ\u0010+¨\u0006\u008a\u0001"}, m13886d2 = {"Landroidx/compose/animation/core/Transition;", "S", "", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "label", "", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;)V", "initialState", "(Ljava/lang/Object;Ljava/lang/String;)V", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "parentTransition", "(Landroidx/compose/animation/core/TransitionState;Landroidx/compose/animation/core/Transition;Ljava/lang/String;)V", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "<set-?>", "", "_playTimeNanos", "get_playTimeNanos", "()J", "set_playTimeNanos", "(J)V", "_playTimeNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "_transitions", "animations", "", "getAnimations", "()Ljava/util/List;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "hasInitialValueAnimations", "", "getHasInitialValueAnimations$annotations", "()V", "getHasInitialValueAnimations", "()Z", "isRunning", "isSeeking", "setSeeking$animation_core_release", "(Z)V", "isSeeking$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "lastSeekedTimeNanos", "getLastSeekedTimeNanos$animation_core_release", "setLastSeekedTimeNanos$animation_core_release", "getParentTransition", "()Landroidx/compose/animation/core/Transition;", "value", "playTimeNanos", "getPlayTimeNanos", "setPlayTimeNanos", "Landroidx/compose/animation/core/Transition$Segment;", "segment", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "startTimeNanos", "getStartTimeNanos$animation_core_release", "setStartTimeNanos$animation_core_release", "startTimeNanos$delegate", "targetState", "getTargetState", "setTargetState$animation_core_release", "(Ljava/lang/Object;)V", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "transitions", "getTransitions", "updateChildrenNeeded", "getUpdateChildrenNeeded", "setUpdateChildrenNeeded", "updateChildrenNeeded$delegate", "addAnimation", "animation", "addAnimation$animation_core_release", "addTransition", "transition", "addTransition$animation_core_release", "animateTo", "", "animateTo$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "calculateTotalDurationNanos", "clearInitialAnimations", "clearInitialAnimations$animation_core_release", "onChildAnimationUpdated", "onDisposed", "onDisposed$animation_core_release", "onFrame", "scaledPlayTimeNanos", "scaleToEnd", "onFrame$animation_core_release", "frameTimeNanos", "durationScale", "", "onTransitionEnd", "onTransitionEnd$animation_core_release", "onTransitionStart", "onTransitionStart$animation_core_release", "removeAnimation", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "removeAnimation$animation_core_release", "removeTransition", "removeTransition$animation_core_release", "resetAnimationFraction", "fraction", "resetAnimationFraction$animation_core_release", "resetAnimations", "seekAnimations", "seekAnimations$animation_core_release", "setInitialAnimations", "animationState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialAnimations$animation_core_release", "setPlaytimeAfterInitialAndTargetStateEstablished", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "toString", "updateInitialValues", "updateInitialValues$animation_core_release", "updateTarget", "updateTarget$animation_core_release", "DeferredAnimation", "Segment", "SegmentImpl", "TransitionAnimationState", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Stable
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/Transition\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 SnapshotLongState.kt\nandroidx/compose/runtime/SnapshotLongStateKt__SnapshotLongStateKt\n+ 4 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 5 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 6 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 7 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n*L\n1#1,2185:1\n81#2:2186\n107#2,2:2187\n81#2:2189\n107#2,2:2190\n81#2:2198\n107#2,2:2199\n81#2:2201\n107#2,2:2202\n81#2:2222\n78#3:2192\n111#3,2:2193\n78#3:2195\n111#3,2:2196\n101#4,2:2204\n33#4,6:2206\n103#4:2212\n101#4,2:2213\n33#4,6:2215\n103#4:2221\n33#4,6:2223\n33#4,6:2229\n33#4,6:2235\n33#4,6:2241\n33#4,6:2247\n33#4,6:2253\n33#4,6:2259\n33#4,6:2265\n33#4,6:2271\n33#4,6:2298\n33#4,6:2304\n33#4,6:2310\n33#4,6:2316\n33#4,6:2322\n33#4,6:2328\n33#4,6:2334\n33#4,6:2340\n33#4,6:2346\n33#4,6:2352\n256#4,3:2358\n33#4,4:2361\n259#4,2:2365\n38#4:2367\n261#4:2368\n33#4,6:2369\n481#5:2277\n480#5,4:2278\n484#5,2:2285\n488#5:2291\n1225#6,3:2282\n1228#6,3:2288\n1225#6,6:2292\n480#7:2287\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/Transition\n*L\n934#1:2186\n934#1:2187,2\n941#1:2189\n941#1:2190,2\n973#1:2198\n973#1:2199,2\n993#1:2201\n993#1:2202,2\n1020#1:2222\n950#1:2192\n950#1:2193,2\n970#1:2195\n970#1:2196,2\n1009#1:2204,2\n1009#1:2206,6\n1009#1:2212\n1010#1:2213,2\n1010#1:2215,6\n1010#1:2221\n1024#1:2223,6\n1027#1:2229,6\n1062#1:2235,6\n1071#1:2241,6\n1109#1:2247,6\n1147#1:2253,6\n1160#1:2259,6\n1203#1:2265,6\n1204#1:2271,6\n1255#1:2298,6\n1258#1:2304,6\n1274#1:2310,6\n1277#1:2316,6\n1287#1:2322,6\n1288#1:2328,6\n1295#1:2334,6\n1298#1:2340,6\n1310#1:2346,6\n1311#1:2352,6\n1315#1:2358,3\n1315#1:2361,4\n1315#1:2365,2\n1315#1:2367\n1315#1:2368\n1324#1:2369,6\n1220#1:2277\n1220#1:2278,4\n1220#1:2285,2\n1220#1:2291\n1220#1:2282,3\n1220#1:2288,3\n1221#1:2292,6\n1220#1:2287\n*E\n"})
public final class Transition<S> {
    public static final int $stable = 0;

    @NotNull
    private final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;

    /* JADX INFO: renamed from: _playTimeNanos$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableLongState _playTimeNanos;

    @NotNull
    private final SnapshotStateList<Transition<?>> _transitions;

    /* JADX INFO: renamed from: isSeeking$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState isSeeking;

    @Nullable
    private final String label;
    private long lastSeekedTimeNanos;

    @Nullable
    private final Transition<?> parentTransition;

    /* JADX INFO: renamed from: segment$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState segment;

    /* JADX INFO: renamed from: startTimeNanos$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableLongState startTimeNanos;

    /* JADX INFO: renamed from: targetState$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState targetState;

    /* JADX INFO: renamed from: totalDurationNanos$delegate, reason: from kotlin metadata */
    @NotNull
    private final State totalDurationNanos;

    @NotNull
    private final TransitionState<S> transitionState;

    /* JADX INFO: renamed from: updateChildrenNeeded$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState updateChildrenNeeded;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001&B#\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJT\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192#\u0010\u001a\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d0\u001b¢\u0006\u0002\b\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00028\u00010\u001bJ\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%R{\u0010\r\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\f2.\u0010\n\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, m13886d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation;", "T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "data", "getData$animation_core_release", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core_release", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "setupSeeking", "", "setupSeeking$animation_core_release", "DeferredAnimationData", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/Transition$DeferredAnimation\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,2185:1\n81#2:2186\n107#2,2:2187\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/Transition$DeferredAnimation\n*L\n1669#1:2186\n1669#1:2187,2\n*E\n"})
    public final class DeferredAnimation<T, V extends AnimationVector> {

        /* JADX INFO: renamed from: data$delegate, reason: from kotlin metadata */
        @NotNull
        private final MutableState data = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

        @NotNull
        private final String label;

        @NotNull
        private final TwoWayConverter<T, V> typeConverter;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\b\b\u0004\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004Bk\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\f\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\t¢\u0006\u0002\u0010\u0011J\u0014\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\nR'\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R5\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R7\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, m13886d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "animation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getTargetValueByState", "()Lkotlin/jvm/functions/Function1;", "setTargetValueByState", "(Lkotlin/jvm/functions/Function1;)V", "getTransitionSpec", "setTransitionSpec", "value", "getValue", "()Ljava/lang/Object;", "updateAnimationStates", "", "segment", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {

            @NotNull
            private final Transition<S>.TransitionAnimationState<T, V> animation;

            @NotNull
            private Function1<? super S, ? extends T> targetValueByState;

            @NotNull
            private Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            public DeferredAnimationData(@NotNull Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, @NotNull Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1, @NotNull Function1<? super S, ? extends T> function12) {
                this.animation = transitionAnimationState;
                this.transitionSpec = function1;
                this.targetValueByState = function12;
            }

            @NotNull
            public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
                return this.animation;
            }

            @NotNull
            public final Function1<S, T> getTargetValueByState() {
                return this.targetValueByState;
            }

            @NotNull
            public final Function1<Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
                return this.transitionSpec;
            }

            @Override // androidx.compose.runtime.State
            public T getValue() {
                updateAnimationStates(Transition.this.getSegment());
                return this.animation.getValue();
            }

            public final void setTargetValueByState(@NotNull Function1<? super S, ? extends T> function1) {
                this.targetValueByState = function1;
            }

            public final void setTransitionSpec(@NotNull Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1) {
                this.transitionSpec = function1;
            }

            public final void updateAnimationStates(@NotNull Segment<S> segment) {
                T tInvoke = this.targetValueByState.invoke(segment.getTargetState());
                if (!Transition.this.isSeeking()) {
                    this.animation.updateTargetValue$animation_core_release(tInvoke, this.transitionSpec.invoke(segment));
                } else {
                    this.animation.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(segment.getInitialState()), tInvoke, this.transitionSpec.invoke(segment));
                }
            }
        }

        public DeferredAnimation(@NotNull TwoWayConverter<T, V> twoWayConverter, @NotNull String str) {
            this.typeConverter = twoWayConverter;
            this.label = str;
        }

        @NotNull
        public final State<T> animate(@NotNull Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec, @NotNull Function1<? super S, ? extends T> targetValueByState) {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release == null) {
                Transition<S> transition = Transition.this;
                data$animation_core_release = new DeferredAnimationData<>(transition.new TransitionAnimationState(targetValueByState.invoke(transition.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, targetValueByState.invoke(Transition.this.getCurrentState())), this.typeConverter, this.label), transitionSpec, targetValueByState);
                Transition<S> transition2 = Transition.this;
                setData$animation_core_release(data$animation_core_release);
                transition2.addAnimation$animation_core_release(data$animation_core_release.getAnimation());
            }
            Transition<S> transition3 = Transition.this;
            data$animation_core_release.setTargetValueByState(targetValueByState);
            data$animation_core_release.setTransitionSpec(transitionSpec);
            data$animation_core_release.updateAnimationStates(transition3.getSegment());
            return data$animation_core_release;
        }

        @Nullable
        public final Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> getData$animation_core_release() {
            return (DeferredAnimationData) this.data.getValue();
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final void setData$animation_core_release(@Nullable Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> deferredAnimationData) {
            this.data.setValue(deferredAnimationData);
        }

        public final void setupSeeking$animation_core_release() {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release != null) {
                Transition<S> transition = Transition.this;
                data$animation_core_release.getAnimation().updateInitialAndTargetValue$animation_core_release(data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getInitialState()), data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getTargetState()), data$animation_core_release.getTransitionSpec().invoke(transition.getSegment()));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, m13886d2 = {"Landroidx/compose/animation/core/Transition$Segment;", "S", "", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface Segment<S> {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static <S> boolean isTransitioningTo(@NotNull Segment<S> segment, S s, S s2) {
                return Segment.super.isTransitioningTo(s, s2);
            }
        }

        S getInitialState();

        S getTargetState();

        default boolean isTransitioningTo(S s, S s2) {
            return Intrinsics.areEqual(s, getInitialState()) && Intrinsics.areEqual(s2, getTargetState());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0003\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0010"}, m13886d2 = {"Landroidx/compose/animation/core/Transition$SegmentImpl;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class SegmentImpl<S> implements Segment<S> {
        private final S initialState;
        private final S targetState;

        public SegmentImpl(S s, S s2) {
            this.initialState = s;
            this.targetState = s2;
        }

        public boolean equals(@Nullable Object other) {
            if (!(other instanceof Segment)) {
                return false;
            }
            Segment segment = (Segment) other;
            return Intrinsics.areEqual(getInitialState(), segment.getInitialState()) && Intrinsics.areEqual(getTargetState(), segment.getTargetState());
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getTargetState() {
            return this.targetState;
        }

        public int hashCode() {
            S initialState = getInitialState();
            int iHashCode = (initialState != null ? initialState.hashCode() : 0) * 31;
            S targetState = getTargetState();
            return iHashCode + (targetState != null ? targetState.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B3\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010O\u001a\u00020PH\u0000¢\u0006\u0002\bQJ\u001d\u0010R\u001a\u00020P2\u0006\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020.H\u0000¢\u0006\u0002\bUJ\r\u0010V\u001a\u00020PH\u0000¢\u0006\u0002\bWJ\u0015\u0010X\u001a\u00020P2\u0006\u0010Y\u001a\u000208H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020P2\u0006\u0010S\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020P2\u0006\u0010^\u001a\u00020(H\u0000¢\u0006\u0002\b_J\b\u0010`\u001a\u00020\nH\u0016J!\u0010a\u001a\u00020P2\b\b\u0002\u0010\u0005\u001a\u00028\u00012\b\b\u0002\u0010b\u001a\u00020.H\u0002¢\u0006\u0002\u0010cJ-\u0010d\u001a\u00020P2\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010@\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\be\u0010fJ\r\u0010g\u001a\u00020PH\u0000¢\u0006\u0002\bhJ%\u0010i\u001a\u00020P2\u0006\u0010@\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\bj\u0010kRC\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001e8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010/\u001a\u00020.2\u0006\u0010\f\u001a\u00020.8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0014\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00105\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R+\u00109\u001a\u0002082\u0006\u0010\f\u001a\u0002088@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R+\u0010@\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0014\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010I\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010\u0014\u001a\u0004\bJ\u0010B\"\u0004\bK\u0010DR\u0010\u0010M\u001a\u00028\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010N¨\u0006l"}, m13886d2 = {"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "defaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "", "durationNanos", "getDurationNanos$animation_core_release", "()J", "setDurationNanos$animation_core_release", "(J)V", "durationNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "initialValueAnimation", "initialValueState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "getInitialValueState$animation_core_release", "()Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialValueState$animation_core_release", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;)V", "interruptionSpec", "", "isFinished", "isFinished$animation_core_release", "()Z", "setFinished$animation_core_release", "(Z)V", "isFinished$delegate", "isSeeking", "getLabel", "()Ljava/lang/String;", "", "resetSnapValue", "getResetSnapValue$animation_core_release", "()F", "setResetSnapValue$animation_core_release", "(F)V", "resetSnapValue$delegate", "Landroidx/compose/runtime/MutableFloatState;", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "useOnlyInitialValue", "value", "getValue", "setValue$animation_core_release", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "clearInitialAnimation", "", "clearInitialAnimation$animation_core_release", "onPlayTimeChanged", "playTimeNanos", "scaleToEnd", "onPlayTimeChanged$animation_core_release", "resetAnimation", "resetAnimation$animation_core_release", "resetAnimationValue", "fraction", "resetAnimationValue$animation_core_release", "seekTo", "seekTo$animation_core_release", "setInitialValueAnimation", "animationState", "setInitialValueAnimation$animation_core_release", "toString", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core_release", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateInitialValue", "updateInitialValue$animation_core_release", "updateTargetValue", "updateTargetValue$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @Stable
    @SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/Transition$TransitionAnimationState\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 SnapshotFloatState.kt\nandroidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt\n+ 4 SnapshotLongState.kt\nandroidx/compose/runtime/SnapshotLongStateKt__SnapshotLongStateKt\n*L\n1#1,2185:1\n81#2:2186\n107#2,2:2187\n81#2:2189\n107#2,2:2190\n81#2:2192\n107#2,2:2193\n81#2:2195\n107#2,2:2196\n81#2:2201\n107#2,2:2202\n79#3:2198\n112#3,2:2199\n78#4:2204\n111#4,2:2205\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/Transition$TransitionAnimationState\n*L\n1347#1:2186\n1347#1:2187,2\n1355#1:2189\n1355#1:2190,2\n1362#1:2192\n1362#1:2193,2\n1373#1:2195\n1373#1:2196,2\n1387#1:2201\n1387#1:2202,2\n1374#1:2198\n1374#1:2199,2\n1390#1:2204\n1390#1:2205,2\n*E\n"})
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {

        /* JADX INFO: renamed from: animation$delegate, reason: from kotlin metadata */
        @NotNull
        private final MutableState animation;

        /* JADX INFO: renamed from: animationSpec$delegate, reason: from kotlin metadata */
        @NotNull
        private final MutableState animationSpec;

        @NotNull
        private final SpringSpec<T> defaultSpring;

        /* JADX INFO: renamed from: durationNanos$delegate, reason: from kotlin metadata */
        @NotNull
        private final MutableLongState durationNanos;

        @Nullable
        private TargetBasedAnimation<T, V> initialValueAnimation;

        @Nullable
        private SeekableTransitionState.SeekingAnimationState initialValueState;

        @NotNull
        private final FiniteAnimationSpec<T> interruptionSpec;

        /* JADX INFO: renamed from: isFinished$delegate, reason: from kotlin metadata */
        @NotNull
        private final MutableState isFinished;
        private boolean isSeeking;

        @NotNull
        private final String label;

        /* JADX INFO: renamed from: resetSnapValue$delegate, reason: from kotlin metadata */
        @NotNull
        private final MutableFloatState resetSnapValue;

        /* JADX INFO: renamed from: targetValue$delegate, reason: from kotlin metadata */
        @NotNull
        private final MutableState targetValue;

        @NotNull
        private final TwoWayConverter<T, V> typeConverter;
        private boolean useOnlyInitialValue;

        /* JADX INFO: renamed from: value$delegate, reason: from kotlin metadata */
        @NotNull
        private final MutableState value;

        @NotNull
        private V velocityVector;

        public TransitionAnimationState(T t, @NotNull V v, @NotNull TwoWayConverter<T, V> twoWayConverter, @NotNull String str) {
            T tInvoke;
            this.typeConverter = twoWayConverter;
            this.label = str;
            this.targetValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            SpringSpec<T> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            this.defaultSpring = springSpecSpring$default;
            this.animationSpec = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(springSpecSpring$default, null, 2, null);
            this.animation = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), twoWayConverter, t, getTargetValue(), v), null, 2, null);
            this.isFinished = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            this.resetSnapValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(-1.0f);
            this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            this.velocityVector = v;
            this.durationNanos = SnapshotLongStateKt.mutableLongStateOf(getAnimation().getDurationNanos());
            Float f = VisibilityThresholdsKt.getVisibilityThresholdMap().get(twoWayConverter);
            if (f != null) {
                float fFloatValue = f.floatValue();
                V vInvoke = twoWayConverter.getConvertToVector().invoke(t);
                int size = vInvoke.getSize();
                for (int i = 0; i < size; i++) {
                    vInvoke.set$animation_core_release(i, fFloatValue);
                }
                tInvoke = this.typeConverter.getConvertFromVector().invoke(vInvoke);
            } else {
                tInvoke = null;
            }
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, tInvoke, 3, null);
        }

        private final T getTargetValue() {
            return this.targetValue.getValue();
        }

        private final void setAnimation(TargetBasedAnimation<T, V> targetBasedAnimation) {
            this.animation.setValue(targetBasedAnimation);
        }

        private final void setAnimationSpec(FiniteAnimationSpec<T> finiteAnimationSpec) {
            this.animationSpec.setValue(finiteAnimationSpec);
        }

        private final void setTargetValue(T t) {
            this.targetValue.setValue(t);
        }

        private final void updateAnimation(T initialValue, boolean isInterrupted) {
            TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
            if (Intrinsics.areEqual(targetBasedAnimation != null ? targetBasedAnimation.getTargetValue() : null, getTargetValue())) {
                setAnimation(new TargetBasedAnimation<>(this.interruptionSpec, this.typeConverter, initialValue, initialValue, AnimationVectorsKt.newInstance(this.velocityVector)));
                this.useOnlyInitialValue = true;
                setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
                return;
            }
            AnimationSpec animationSpec = (!isInterrupted || this.isSeeking || (getAnimationSpec() instanceof SpringSpec)) ? getAnimationSpec() : this.interruptionSpec;
            if (Transition.this.getPlayTimeNanos() > 0) {
                animationSpec = AnimationSpecKt.delayed(animationSpec, Transition.this.getPlayTimeNanos());
            }
            setAnimation(new TargetBasedAnimation<>(animationSpec, this.typeConverter, initialValue, getTargetValue(), this.velocityVector));
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = false;
            Transition.this.onChildAnimationUpdated();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateAnimation$default(TransitionAnimationState transitionAnimationState, Object obj, boolean z, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            if ((i & 2) != 0) {
                z = false;
            }
            transitionAnimationState.updateAnimation(obj, z);
        }

        public final void clearInitialAnimation$animation_core_release() {
            this.initialValueAnimation = null;
            this.initialValueState = null;
            this.useOnlyInitialValue = false;
        }

        @NotNull
        public final TargetBasedAnimation<T, V> getAnimation() {
            return (TargetBasedAnimation) this.animation.getValue();
        }

        @NotNull
        public final FiniteAnimationSpec<T> getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec.getValue();
        }

        public final long getDurationNanos$animation_core_release() {
            return this.durationNanos.getLongValue();
        }

        @Nullable
        /* JADX INFO: renamed from: getInitialValueState$animation_core_release, reason: from getter */
        public final SeekableTransitionState.SeekingAnimationState getInitialValueState() {
            return this.initialValueState;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        public final float getResetSnapValue$animation_core_release() {
            return this.resetSnapValue.getFloatValue();
        }

        @NotNull
        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        @Override // androidx.compose.runtime.State
        public T getValue() {
            return this.value.getValue();
        }

        public final boolean isFinished$animation_core_release() {
            return ((Boolean) this.isFinished.getValue()).booleanValue();
        }

        public final void onPlayTimeChanged$animation_core_release(long playTimeNanos, boolean scaleToEnd) {
            if (scaleToEnd) {
                playTimeNanos = getAnimation().getDurationNanos();
            }
            setValue$animation_core_release(getAnimation().getValueFromNanos(playTimeNanos));
            this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(playTimeNanos);
            if (getAnimation().isFinishedFromNanos(playTimeNanos)) {
                setFinished$animation_core_release(true);
            }
        }

        public final void resetAnimation$animation_core_release() {
            setResetSnapValue$animation_core_release(-2.0f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void resetAnimationValue$animation_core_release(float fraction) {
            if (fraction != -4.0f && fraction != -5.0f) {
                setResetSnapValue$animation_core_release(fraction);
                return;
            }
            TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
            if (targetBasedAnimation != null) {
                getAnimation().setMutableInitialValue$animation_core_release(targetBasedAnimation.getTargetValue());
                this.initialValueState = null;
                this.initialValueAnimation = null;
            }
            Object initialValue = fraction == -4.0f ? getAnimation().getInitialValue() : getAnimation().getTargetValue();
            getAnimation().setMutableInitialValue$animation_core_release(initialValue);
            getAnimation().setMutableTargetValue$animation_core_release(initialValue);
            setValue$animation_core_release(initialValue);
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
        }

        public final void seekTo$animation_core_release(long playTimeNanos) {
            if (getResetSnapValue$animation_core_release() == -1.0f) {
                this.isSeeking = true;
                if (Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                    setValue$animation_core_release(getAnimation().getTargetValue());
                } else {
                    setValue$animation_core_release(getAnimation().getValueFromNanos(playTimeNanos));
                    this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(playTimeNanos);
                }
            }
        }

        public final void setDurationNanos$animation_core_release(long j) {
            this.durationNanos.setLongValue(j);
        }

        public final void setFinished$animation_core_release(boolean z) {
            this.isFinished.setValue(Boolean.valueOf(z));
        }

        public final void setInitialValueAnimation$animation_core_release(@NotNull SeekableTransitionState.SeekingAnimationState animationState) {
            if (!Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                this.initialValueAnimation = getAnimation();
                this.initialValueState = animationState;
            }
            setAnimation(new TargetBasedAnimation<>(this.interruptionSpec, this.typeConverter, getValue(), getValue(), AnimationVectorsKt.newInstance(this.velocityVector)));
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = true;
        }

        public final void setInitialValueState$animation_core_release(@Nullable SeekableTransitionState.SeekingAnimationState seekingAnimationState) {
            this.initialValueState = seekingAnimationState;
        }

        public final void setResetSnapValue$animation_core_release(float f) {
            this.resetSnapValue.setFloatValue(f);
        }

        public void setValue$animation_core_release(T t) {
            this.value.setValue(t);
        }

        @NotNull
        public String toString() {
            return "current value: " + getValue() + ", target: " + getTargetValue() + ", spec: " + getAnimationSpec();
        }

        public final void updateInitialAndTargetValue$animation_core_release(T initialValue, T targetValue, @NotNull FiniteAnimationSpec<T> animationSpec) {
            setTargetValue(targetValue);
            setAnimationSpec(animationSpec);
            if (Intrinsics.areEqual(getAnimation().getInitialValue(), initialValue) && Intrinsics.areEqual(getAnimation().getTargetValue(), targetValue)) {
                return;
            }
            updateAnimation$default(this, initialValue, false, 2, null);
        }

        public final void updateInitialValue$animation_core_release() {
            TargetBasedAnimation<T, V> targetBasedAnimation;
            SeekableTransitionState.SeekingAnimationState seekingAnimationState = this.initialValueState;
            if (seekingAnimationState == null || (targetBasedAnimation = this.initialValueAnimation) == null) {
                return;
            }
            long jRoundToLong = MathKt.roundToLong(seekingAnimationState.getDurationNanos() * ((double) seekingAnimationState.getValue()));
            T valueFromNanos = targetBasedAnimation.getValueFromNanos(jRoundToLong);
            if (this.useOnlyInitialValue) {
                getAnimation().setMutableTargetValue$animation_core_release(valueFromNanos);
            }
            getAnimation().setMutableInitialValue$animation_core_release(valueFromNanos);
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            if (getResetSnapValue$animation_core_release() == -2.0f || this.useOnlyInitialValue) {
                setValue$animation_core_release(valueFromNanos);
            } else {
                seekTo$animation_core_release(Transition.this.getPlayTimeNanos());
            }
            if (jRoundToLong < seekingAnimationState.getDurationNanos()) {
                seekingAnimationState.setComplete(false);
            } else {
                this.initialValueState = null;
                this.initialValueAnimation = null;
            }
        }

        public final void updateTargetValue$animation_core_release(T targetValue, @NotNull FiniteAnimationSpec<T> animationSpec) {
            if (this.useOnlyInitialValue) {
                TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
                if (Intrinsics.areEqual(targetValue, targetBasedAnimation != null ? targetBasedAnimation.getTargetValue() : null)) {
                    return;
                }
            }
            if (Intrinsics.areEqual(getTargetValue(), targetValue) && getResetSnapValue$animation_core_release() == -1.0f) {
                return;
            }
            setTargetValue(targetValue);
            setAnimationSpec(animationSpec);
            updateAnimation(getResetSnapValue$animation_core_release() == -3.0f ? targetValue : getValue(), !isFinished$animation_core_release());
            setFinished$animation_core_release(getResetSnapValue$animation_core_release() == -3.0f);
            if (getResetSnapValue$animation_core_release() >= 0.0f) {
                setValue$animation_core_release(getAnimation().getValueFromNanos((long) (getResetSnapValue$animation_core_release() * getAnimation().getDurationNanos())));
            } else if (getResetSnapValue$animation_core_release() == -3.0f) {
                setValue$animation_core_release(targetValue);
            }
            this.useOnlyInitialValue = false;
            setResetSnapValue$animation_core_release(-1.0f);
        }
    }

    public Transition(@NotNull TransitionState<S> transitionState, @Nullable Transition<?> transition, @Nullable String str) {
        this.transitionState = transitionState;
        this.parentTransition = transition;
        this.label = str;
        this.targetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getCurrentState(), null, 2, null);
        this.segment = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), null, 2, null);
        this._playTimeNanos = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.startTimeNanos = SnapshotLongStateKt.mutableLongStateOf(Long.MIN_VALUE);
        Boolean bool = Boolean.FALSE;
        this.updateChildrenNeeded = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        this.isSeeking = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.totalDurationNanos = SnapshotStateKt.derivedStateOf(new Function0<Long>(this) { // from class: androidx.compose.animation.core.Transition$totalDurationNanos$2
            final /* synthetic */ Transition<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                return Long.valueOf(this.this$0.calculateTotalDurationNanos());
            }
        });
        transitionState.transitionConfigured$animation_core_release(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateTotalDurationNanos() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            jMax = Math.max(jMax, snapshotStateList.get(i).getDurationNanos$animation_core_release());
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            jMax = Math.max(jMax, snapshotStateList2.get(i2).calculateTotalDurationNanos());
        }
        return jMax;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getUpdateChildrenNeeded() {
        return ((Boolean) this.updateChildrenNeeded.getValue()).booleanValue();
    }

    private final long get_playTimeNanos() {
        return this._playTimeNanos.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded(true);
        if (isSeeking()) {
            SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
            int size = snapshotStateList.size();
            long jMax = 0;
            for (int i = 0; i < size; i++) {
                Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState = snapshotStateList.get(i);
                jMax = Math.max(jMax, transitionAnimationState.getDurationNanos$animation_core_release());
                transitionAnimationState.seekTo$animation_core_release(this.lastSeekedTimeNanos);
            }
            setUpdateChildrenNeeded(false);
        }
    }

    private final void resetAnimations() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).resetAnimation$animation_core_release();
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).resetAnimations();
        }
    }

    private final void setSegment(Segment<S> segment) {
        this.segment.setValue(segment);
    }

    private final void setUpdateChildrenNeeded(boolean z) {
        this.updateChildrenNeeded.setValue(Boolean.valueOf(z));
    }

    private final void set_playTimeNanos(long j) {
        this._playTimeNanos.setLongValue(j);
    }

    public final boolean addAnimation$animation_core_release(@NotNull Transition<S>.TransitionAnimationState<?, ?> animation) {
        return this._animations.add(animation);
    }

    public final boolean addTransition$animation_core_release(@NotNull Transition<?> transition) {
        return this._transitions.add(transition);
    }

    @Composable
    public final void animateTo$animation_core_release(final S s, @Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1493585151);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(s) : composerStartRestartGroup.changedInstance(s) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1493585151, i2, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1211)");
            }
            if (isSeeking()) {
                composerStartRestartGroup.startReplaceGroup(1823992347);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1822507602);
                updateTarget$animation_core_release(s);
                if (!Intrinsics.areEqual(s, getCurrentState()) || isRunning() || getUpdateChildrenNeeded()) {
                    composerStartRestartGroup.startReplaceGroup(1822738893);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                    }
                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    int i4 = i2 & 112;
                    boolean zChangedInstance = (i4 == 32) | composerStartRestartGroup.changedInstance(coroutineScope);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1

                            /* JADX INFO: renamed from: androidx.compose.animation.core.Transition$animateTo$1$1$1 */
                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                            @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
                            @DebugMetadata(m14020c = "androidx.compose.animation.core.Transition$animateTo$1$1$1", m14021f = "Transition.kt", m14022i = {0, 0}, m14023l = {1227}, m14024m = "invokeSuspend", m14025n = {"$this$launch", "durationScale"}, m14026s = {"L$0", "F$0"})
                            public static final class C07421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                float F$0;
                                private /* synthetic */ Object L$0;
                                int label;
                                final /* synthetic */ Transition<S> this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C07421(Transition<S> transition, Continuation<? super C07421> continuation) {
                                    super(2, continuation);
                                    this.this$0 = transition;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    C07421 c07421 = new C07421(this.this$0, continuation);
                                    c07421.L$0 = obj;
                                    return c07421;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object obj) {
                                    final float durationScale;
                                    CoroutineScope coroutineScope;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                                        durationScale = SuspendAnimationKt.getDurationScale(coroutineScope2.getCoroutineContext());
                                        coroutineScope = coroutineScope2;
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        durationScale = this.F$0;
                                        coroutineScope = (CoroutineScope) this.L$0;
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    while (CoroutineScopeKt.isActive(coroutineScope)) {
                                        final Transition<S> transition = this.this$0;
                                        Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.Transition.animateTo.1.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                invoke(l.longValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                                            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                                            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                             */
                                            public final void invoke(long j) {
                                                if (transition.isSeeking()) {
                                                    return;
                                                }
                                                transition.onFrame$animation_core_release(j, durationScale);
                                            }
                                        };
                                        this.L$0 = coroutineScope;
                                        this.F$0 = durationScale;
                                        this.label = 1;
                                        if (MonotonicFrameClockKt.withFrameNanos(function1, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                @Nullable
                                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                    return ((C07421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new C07421(this, null), 1, null);
                                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    EffectsKt.DisposableEffect(coroutineScope, this, (Function1) objRememberedValue2, composerStartRestartGroup, i4);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1823982427);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(this) { // from class: androidx.compose.animation.core.Transition$animateTo$2
                final /* synthetic */ Transition<S> $tmp1_rcvr;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$tmp1_rcvr = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                public final void invoke(@Nullable Composer composer2, int i5) {
                    this.$tmp1_rcvr.animateTo$animation_core_release(s, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void clearInitialAnimations$animation_core_release() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).clearInitialAnimation$animation_core_release();
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).clearInitialAnimations$animation_core_release();
        }
    }

    @NotNull
    public final List<Transition<S>.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations;
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    @InternalAnimationApi
    public final boolean getHasInitialValueAnimations() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            if (snapshotStateList.get(i).getInitialValueState() != null) {
                return true;
            }
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (snapshotStateList2.get(i2).getHasInitialValueAnimations()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: getLastSeekedTimeNanos$animation_core_release, reason: from getter */
    public final long getLastSeekedTimeNanos() {
        return this.lastSeekedTimeNanos;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Nullable
    public final Transition<?> getParentTransition() {
        return this.parentTransition;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final long getPlayTimeNanos() {
        Transition<?> transition = this.parentTransition;
        return transition != null ? transition.getPlayTimeNanos() : get_playTimeNanos();
    }

    @NotNull
    public final Segment<S> getSegment() {
        return (Segment) this.segment.getValue();
    }

    public final long getStartTimeNanos$animation_core_release() {
        return this.startTimeNanos.getLongValue();
    }

    public final S getTargetState() {
        return (S) this.targetState.getValue();
    }

    public final long getTotalDurationNanos() {
        return ((Number) this.totalDurationNanos.getValue()).longValue();
    }

    @NotNull
    public final List<Transition<?>> getTransitions() {
        return this._transitions;
    }

    public final boolean isRunning() {
        return getStartTimeNanos$animation_core_release() != Long.MIN_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking.getValue()).booleanValue();
    }

    public final void onDisposed$animation_core_release() {
        onTransitionEnd$animation_core_release();
        this.transitionState.transitionRemoved$animation_core_release();
    }

    public final void onFrame$animation_core_release(long frameTimeNanos, float durationScale) {
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(frameTimeNanos);
        }
        long startTimeNanos$animation_core_release = frameTimeNanos - getStartTimeNanos$animation_core_release();
        if (durationScale != 0.0f) {
            startTimeNanos$animation_core_release = MathKt.roundToLong(startTimeNanos$animation_core_release / ((double) durationScale));
        }
        setPlayTimeNanos(startTimeNanos$animation_core_release);
        onFrame$animation_core_release(startTimeNanos$animation_core_release, durationScale == 0.0f);
    }

    public final void onTransitionEnd$animation_core_release() {
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        TransitionState<S> transitionState = this.transitionState;
        if (transitionState instanceof MutableTransitionState) {
            transitionState.setCurrentState$animation_core_release(getTargetState());
        }
        setPlayTimeNanos(0L);
        this.transitionState.setRunning$animation_core_release(false);
        SnapshotStateList<Transition<?>> snapshotStateList = this._transitions;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).onTransitionEnd$animation_core_release();
        }
    }

    public final void onTransitionStart$animation_core_release(long frameTimeNanos) {
        setStartTimeNanos$animation_core_release(frameTimeNanos);
        this.transitionState.setRunning$animation_core_release(true);
    }

    public final void removeAnimation$animation_core_release(@NotNull Transition<S>.TransitionAnimationState<?, ?> animation) {
        this._animations.remove(animation);
    }

    public final boolean removeTransition$animation_core_release(@NotNull Transition<?> transition) {
        return this._transitions.remove(transition);
    }

    public final void resetAnimationFraction$animation_core_release(float fraction) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).resetAnimationValue$animation_core_release(fraction);
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).resetAnimationFraction$animation_core_release(fraction);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @JvmName(name = "seek")
    public final void seek(S initialState, S targetState, long playTimeNanos) {
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        this.transitionState.setRunning$animation_core_release(false);
        if (!isSeeking() || !Intrinsics.areEqual(getCurrentState(), initialState) || !Intrinsics.areEqual(getTargetState(), targetState)) {
            if (!Intrinsics.areEqual(getCurrentState(), initialState)) {
                TransitionState<S> transitionState = this.transitionState;
                if (transitionState instanceof MutableTransitionState) {
                    transitionState.setCurrentState$animation_core_release(initialState);
                }
            }
            setTargetState$animation_core_release(targetState);
            setSeeking$animation_core_release(true);
            setSegment(new SegmentImpl(initialState, targetState));
        }
        SnapshotStateList<Transition<?>> snapshotStateList = this._transitions;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            Transition<?> transition = snapshotStateList.get(i);
            Intrinsics.checkNotNull(transition, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if (transition.isSeeking()) {
                transition.seek(transition.getCurrentState(), transition.getTargetState(), playTimeNanos);
            }
        }
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList2 = this._animations;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).seekTo$animation_core_release(playTimeNanos);
        }
        this.lastSeekedTimeNanos = playTimeNanos;
    }

    public final void seekAnimations$animation_core_release(long playTimeNanos) {
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            setStartTimeNanos$animation_core_release(playTimeNanos);
        }
        setPlayTimeNanos(playTimeNanos);
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).seekTo$animation_core_release(playTimeNanos);
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Transition<?> transition = snapshotStateList2.get(i2);
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                transition.seekAnimations$animation_core_release(playTimeNanos);
            }
        }
    }

    public final void setInitialAnimations$animation_core_release(@NotNull SeekableTransitionState.SeekingAnimationState animationState) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).setInitialValueAnimation$animation_core_release(animationState);
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).setInitialAnimations$animation_core_release(animationState);
        }
    }

    public final void setLastSeekedTimeNanos$animation_core_release(long j) {
        this.lastSeekedTimeNanos = j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setPlayTimeNanos(long j) {
        if (this.parentTransition == null) {
            set_playTimeNanos(j);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setSeeking$animation_core_release(boolean z) {
        this.isSeeking.setValue(Boolean.valueOf(z));
    }

    public final void setStartTimeNanos$animation_core_release(long j) {
        this.startTimeNanos.setLongValue(j);
    }

    public final void setTargetState$animation_core_release(S s) {
        this.targetState.setValue(s);
    }

    @NotNull
    public String toString() {
        List<Transition<S>.TransitionAnimationState<?, ?>> animations = getAnimations();
        int size = animations.size();
        String str = "Transition animation values: ";
        for (int i = 0; i < size; i++) {
            str = str + animations.get(i) + SQLKeyword.COMMA;
        }
        return str;
    }

    public final void updateInitialValues$animation_core_release() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).updateInitialValue$animation_core_release();
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).updateInitialValues$animation_core_release();
        }
    }

    public final void updateTarget$animation_core_release(S targetState) {
        if (Intrinsics.areEqual(getTargetState(), targetState)) {
            return;
        }
        setSegment(new SegmentImpl(getTargetState(), targetState));
        if (!Intrinsics.areEqual(getCurrentState(), getTargetState())) {
            this.transitionState.setCurrentState$animation_core_release(getTargetState());
        }
        setTargetState$animation_core_release(targetState);
        if (!isRunning()) {
            setUpdateChildrenNeeded(true);
        }
        resetAnimations();
    }

    public final void removeAnimation$animation_core_release(@NotNull Transition<S>.DeferredAnimation<?, ?> deferredAnimation) {
        Transition<S>.TransitionAnimationState<?, ?> animation;
        Transition<S>.DeferredAnimationData<?, ?>.DeferredAnimationData<?, V> data$animation_core_release = deferredAnimation.getData$animation_core_release();
        if (data$animation_core_release == 0 || (animation = data$animation_core_release.getAnimation()) == null) {
            return;
        }
        removeAnimation$animation_core_release(animation);
    }

    public final void onFrame$animation_core_release(long scaledPlayTimeNanos, boolean scaleToEnd) {
        boolean z = true;
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(scaledPlayTimeNanos);
        } else if (!this.transitionState.isRunning$animation_core_release()) {
            this.transitionState.setRunning$animation_core_release(true);
        }
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState = snapshotStateList.get(i);
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                transitionAnimationState.onPlayTimeChanged$animation_core_release(scaledPlayTimeNanos, scaleToEnd);
            }
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                z = false;
            }
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Transition<?> transition = snapshotStateList2.get(i2);
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                transition.onFrame$animation_core_release(scaledPlayTimeNanos, scaleToEnd);
            }
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                z = false;
            }
        }
        if (z) {
            onTransitionEnd$animation_core_release();
        }
    }

    public /* synthetic */ Transition(TransitionState transitionState, Transition transition, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(transitionState, transition, (i & 4) != 0 ? null : str);
    }

    public /* synthetic */ Transition(TransitionState transitionState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(transitionState, (i & 2) != 0 ? null : str);
    }

    @InternalAnimationApi
    public static /* synthetic */ void getHasInitialValueAnimations$annotations() {
    }

    @PublishedApi
    public Transition(@NotNull TransitionState<S> transitionState, @Nullable String str) {
        this(transitionState, null, str);
    }

    public Transition(S s, @Nullable String str) {
        this(new MutableTransitionState(s), null, str);
    }

    public /* synthetic */ Transition(MutableTransitionState mutableTransitionState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableTransitionState, (i & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public Transition(@NotNull MutableTransitionState<S> mutableTransitionState, @Nullable String str) {
        this(mutableTransitionState, null, str);
        Intrinsics.checkNotNull(mutableTransitionState, "null cannot be cast to non-null type androidx.compose.animation.core.TransitionState<S of androidx.compose.animation.core.Transition>");
    }
}
