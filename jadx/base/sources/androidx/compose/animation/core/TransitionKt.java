package androidx.compose.animation.core;

import androidx.annotation.RestrictTo;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.Transition.TransitionAnimationState;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u001b\u001a\u0002H\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u001c\u001a3\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u001d2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a\u0082\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020!0\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010,\u001a\u0082\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010,\u001a\u0082\u0001\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010,\u001a\u0082\u0001\u0010/\u001a\b\u0012\u0004\u0012\u0002000 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002000%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002000\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010,\u001a\u0082\u0001\u00101\u001a\b\u0012\u0004\u0012\u0002020 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002020%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002020\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010,\u001a\u0082\u0001\u00103\u001a\b\u0012\u0004\u0012\u0002040 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002040%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002040\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010,\u001a\u0082\u0001\u00105\u001a\b\u0012\u0004\u0012\u0002060 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002060%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002060\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010,\u001a\u0082\u0001\u00107\u001a\b\u0012\u0004\u0012\u0002080 \"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00132*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002080%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002080\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010,\u001a¦\u0001\u00109\u001a\b\u0012\u0004\u0012\u0002H\u00140 \"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010:*\u00020;*\b\u0012\u0004\u0012\u0002H\"0\u00132\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0=2*\b\n\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140%0\u000f¢\u0006\u0002\b&¢\u0006\u0002\b'2\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u00140\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010>\u001a\\\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\"0\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\u0010@\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H\u00140\u000f¢\u0006\u0002\b&H\u0087\b¢\u0006\u0002\u0010B\u001aA\u0010C\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\"0\u00132\u0006\u0010D\u001a\u0002H\u00142\u0006\u0010\u001b\u001a\u0002H\u00142\u0006\u0010E\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010F\u001aa\u0010G\u001a\u0018\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0HR\b\u0012\u0004\u0012\u0002H\"0\u0013\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010:*\u00020;*\b\u0012\u0004\u0012\u0002H\"0\u00132\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0=2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010I\u001am\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00140 \"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010:*\u00020;*\b\u0012\u0004\u0012\u0002H\"0\u00132\u0006\u0010K\u001a\u0002H\u00142\u0006\u0010L\u001a\u0002H\u00142\f\u0010M\u001a\b\u0012\u0004\u0012\u0002H\u00140%2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0=2\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010N\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\b\u001a\u00020\t8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u001e\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, m13886d2 = {"AnimationDebugDurationScale", "", "NoReset", "", "ResetAnimationSnap", "ResetAnimationSnapCurrent", "ResetAnimationSnapTarget", "ResetNoSnap", "SeekableStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSeekableStateObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver$delegate", "Lkotlin/Lazy;", "SeekableTransitionStateTotalDurationChanged", "Lkotlin/Function1;", "Landroidx/compose/animation/core/SeekableTransitionState;", "", "rememberTransition", "Landroidx/compose/animation/core/Transition;", "T", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "label", "", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "updateTransition", "targetState", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "animateDp", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "S", "transitionSpec", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "animateInt", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateValue", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createChildTransition", "transformToChildState", "parentState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/TransitionKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,2185:1\n1884#1,7:2258\n1884#1,7:2265\n1884#1,7:2272\n1884#1,7:2279\n1884#1,7:2286\n1884#1,7:2293\n1884#1,7:2300\n1884#1,7:2307\n1225#2,6:2186\n1225#2,6:2192\n1225#2,6:2198\n1225#2,6:2204\n1225#2,6:2210\n1225#2,6:2216\n1225#2,6:2222\n1225#2,6:2228\n1225#2,6:2234\n1225#2,6:2240\n1225#2,6:2246\n1225#2,6:2252\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/TransitionKt\n*L\n1969#1:2258,7\n2000#1:2265,7\n2031#1:2272,7\n2062#1:2279,7\n2093#1:2286,7\n2124#1:2293,7\n2154#1:2300,7\n2184#1:2307,7\n93#1:2186,6\n95#1:2192,6\n822#1:2198,6\n826#1:2204,6\n837#1:2210,6\n1781#1:2216,6\n1782#1:2222,6\n1814#1:2228,6\n1827#1:2234,6\n1831#1:2240,6\n1902#1:2246,6\n1925#1:2252,6\n*E\n"})
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;
    private static final float NoReset = -1.0f;
    private static final float ResetAnimationSnap = -3.0f;
    private static final float ResetAnimationSnapCurrent = -4.0f;
    private static final float ResetAnimationSnapTarget = -5.0f;
    private static final float ResetNoSnap = -2.0f;

    @NotNull
    private static final Function1<SeekableTransitionState<?>, Unit> SeekableTransitionStateTotalDurationChanged = new Function1<SeekableTransitionState<?>, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableTransitionStateTotalDurationChanged$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SeekableTransitionState<?> seekableTransitionState) {
            invoke2(seekableTransitionState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SeekableTransitionState<?> seekableTransitionState) {
            seekableTransitionState.onTotalDurationChanged$animation_core_release();
        }
    };

    @NotNull
    private static final Lazy SeekableStateObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SnapshotStateObserver>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SnapshotStateObserver invoke() {
            SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                    invoke2((Function0<Unit>) function0);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Function0<Unit> function0) {
                    function0.invoke();
                }
            });
            snapshotStateObserver.start();
            return snapshotStateObserver;
        }
    });

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<C2256Dp> animateDp(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<C2256Dp>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, C2256Dp> function32, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<C2256Dp>>() { // from class: androidx.compose.animation.core.TransitionKt.animateDp.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<C2256Dp> invoke(Object obj, Composer composer2, Integer num) {
                    return invoke((Transition.Segment) obj, composer2, num.intValue());
                }

                @Composable
                @NotNull
                public final SpringSpec<C2256Dp> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i4) {
                    composer2.startReplaceGroup(-575880366);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-575880366, i4, -1, "androidx.compose.animation.core.animateDp.<anonymous> (Transition.kt:1994)");
                    }
                    SpringSpec<C2256Dp> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, C2256Dp.m20966boximpl(VisibilityThresholdsKt.getVisibilityThreshold(C2256Dp.INSTANCE)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        int i4 = i & 14;
        int i5 = i << 3;
        int i6 = i4 | (i5 & 896) | (i5 & 7168) | (i5 & 57344);
        int i7 = (i6 >> 9) & 112;
        return createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i7)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i7)), function3.invoke(transition.getSegment(), composer, Integer.valueOf((i6 >> 3) & 112)), VectorConvertersKt.getVectorConverter(C2256Dp.INSTANCE), str2, composer, (i6 & 14) | ((i6 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Float> animateFloat(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Float> function32, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Float>>() { // from class: androidx.compose.animation.core.TransitionKt.animateFloat.1
                @Composable
                @NotNull
                public final SpringSpec<Float> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i4) {
                    composer2.startReplaceGroup(-522164544);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-522164544, i4, -1, "androidx.compose.animation.core.animateFloat.<anonymous> (Transition.kt:1964)");
                    }
                    SpringSpec<Float> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<Float> invoke(Object obj, Composer composer2, Integer num) {
                    return invoke((Transition.Segment) obj, composer2, num.intValue());
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        int i4 = i & 14;
        int i5 = i << 3;
        int i6 = i4 | (i5 & 896) | (i5 & 7168) | (i5 & 57344);
        int i7 = (i6 >> 9) & 112;
        return createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i7)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i7)), function3.invoke(transition.getSegment(), composer, Integer.valueOf((i6 >> 3) & 112)), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), str2, composer, (i6 & 14) | ((i6 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Integer> animateInt(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Integer> function32, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Integer>>() { // from class: androidx.compose.animation.core.TransitionKt.animateInt.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<Integer> invoke(Object obj, Composer composer2, Integer num) {
                    return invoke((Transition.Segment) obj, composer2, num.intValue());
                }

                @Composable
                @NotNull
                public final SpringSpec<Integer> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i4) {
                    composer2.startReplaceGroup(-785273069);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-785273069, i4, -1, "androidx.compose.animation.core.animateInt.<anonymous> (Transition.kt:2118)");
                    }
                    SpringSpec<Integer> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, 1, 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        int i4 = i & 14;
        int i5 = i << 3;
        int i6 = i4 | (i5 & 896) | (i5 & 7168) | (i5 & 57344);
        int i7 = (i6 >> 9) & 112;
        return createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i7)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i7)), function3.invoke(transition.getSegment(), composer, Integer.valueOf((i6 >> 3) & 112)), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), str2, composer, (i6 & 14) | ((i6 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<IntOffset> animateIntOffset(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, IntOffset> function32, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<IntOffset>>() { // from class: androidx.compose.animation.core.TransitionKt.animateIntOffset.1
                @Composable
                @NotNull
                public final SpringSpec<IntOffset> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i4) {
                    composer2.startReplaceGroup(-1953479610);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1953479610, i4, -1, "androidx.compose.animation.core.animateIntOffset.<anonymous> (Transition.kt:2088)");
                    }
                    SpringSpec<IntOffset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m21087boximpl(IntOffsetKt.IntOffset(1, 1)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<IntOffset> invoke(Object obj, Composer composer2, Integer num) {
                    return invoke((Transition.Segment) obj, composer2, num.intValue());
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        int i4 = i & 14;
        int i5 = i << 3;
        int i6 = i4 | (i5 & 896) | (i5 & 7168) | (i5 & 57344);
        int i7 = (i6 >> 9) & 112;
        return createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i7)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i7)), function3.invoke(transition.getSegment(), composer, Integer.valueOf((i6 >> 3) & 112)), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), str2, composer, (i6 & 14) | ((i6 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<IntSize> animateIntSize(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, IntSize> function32, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.core.TransitionKt.animateIntSize.1
                @Composable
                @NotNull
                public final SpringSpec<IntSize> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i4) {
                    composer2.startReplaceGroup(967893300);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(967893300, i4, -1, "androidx.compose.animation.core.animateIntSize.<anonymous> (Transition.kt:2149)");
                    }
                    SpringSpec<IntSize> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m21130boximpl(IntSizeKt.IntSize(1, 1)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(Object obj, Composer composer2, Integer num) {
                    return invoke((Transition.Segment) obj, composer2, num.intValue());
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        int i4 = i & 14;
        int i5 = i << 3;
        int i6 = i4 | (i5 & 896) | (i5 & 7168) | (i5 & 57344);
        int i7 = (i6 >> 9) & 112;
        return createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i7)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i7)), function3.invoke(transition.getSegment(), composer, Integer.valueOf((i6 >> 3) & 112)), VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), str2, composer, (i6 & 14) | ((i6 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Offset> animateOffset(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Offset> function32, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Offset>>() { // from class: androidx.compose.animation.core.TransitionKt.animateOffset.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<Offset> invoke(Object obj, Composer composer2, Integer num) {
                    return invoke((Transition.Segment) obj, composer2, num.intValue());
                }

                @Composable
                @NotNull
                public final SpringSpec<Offset> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i4) {
                    composer2.startReplaceGroup(1623385561);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1623385561, i4, -1, "androidx.compose.animation.core.animateOffset.<anonymous> (Transition.kt:2025)");
                    }
                    SpringSpec<Offset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m18273boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        int i4 = i & 14;
        int i5 = i << 3;
        int i6 = i4 | (i5 & 896) | (i5 & 7168) | (i5 & 57344);
        int i7 = (i6 >> 9) & 112;
        return createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i7)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i7)), function3.invoke(transition.getSegment(), composer, Integer.valueOf((i6 >> 3) & 112)), VectorConvertersKt.getVectorConverter(Offset.INSTANCE), str2, composer, (i6 & 14) | ((i6 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Rect> animateRect(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Rect> function32, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Rect>>() { // from class: androidx.compose.animation.core.TransitionKt.animateRect.1
                @Composable
                @NotNull
                public final SpringSpec<Rect> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i4) {
                    composer2.startReplaceGroup(691336298);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(691336298, i4, -1, "androidx.compose.animation.core.animateRect.<anonymous> (Transition.kt:2179)");
                    }
                    SpringSpec<Rect> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<Rect> invoke(Object obj, Composer composer2, Integer num) {
                    return invoke((Transition.Segment) obj, composer2, num.intValue());
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        int i4 = i & 14;
        int i5 = i << 3;
        int i6 = i4 | (i5 & 896) | (i5 & 7168) | (i5 & 57344);
        int i7 = (i6 >> 9) & 112;
        return createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i7)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i7)), function3.invoke(transition.getSegment(), composer, Integer.valueOf((i6 >> 3) & 112)), VectorConvertersKt.getVectorConverter(Rect.INSTANCE), str2, composer, (i6 & 14) | ((i6 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Size> animateSize(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Size> function32, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Size>>() { // from class: androidx.compose.animation.core.TransitionKt.animateSize.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<Size> invoke(Object obj, Composer composer2, Integer num) {
                    return invoke((Transition.Segment) obj, composer2, num.intValue());
                }

                @Composable
                @NotNull
                public final SpringSpec<Size> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i4) {
                    composer2.startReplaceGroup(-1607152761);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1607152761, i4, -1, "androidx.compose.animation.core.animateSize.<anonymous> (Transition.kt:2056)");
                    }
                    SpringSpec<Size> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m18341boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.INSTANCE)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
        }
        if ((i2 & 2) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        int i4 = i & 14;
        int i5 = i << 3;
        int i6 = i4 | (i5 & 896) | (i5 & 7168) | (i5 & 57344);
        int i7 = (i6 >> 9) & 112;
        return createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i7)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i7)), function3.invoke(transition.getSegment(), composer, Integer.valueOf((i6 >> 3) & 112)), VectorConvertersKt.getVectorConverter(Size.INSTANCE), str2, composer, (i6 & 14) | ((i6 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S, T, V extends AnimationVector> State<T> animateValue(@NotNull Transition<S> transition, @NotNull TwoWayConverter<T, V> twoWayConverter, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, ? extends T> function32, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            function3 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<T>>() { // from class: androidx.compose.animation.core.TransitionKt.animateValue.1
                @Composable
                @NotNull
                public final SpringSpec<T> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer2, int i4) {
                    composer2.startReplaceGroup(-895531546);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-895531546, i4, -1, "androidx.compose.animation.core.animateValue.<anonymous> (Transition.kt:1880)");
                    }
                    SpringSpec<T> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Composer composer2, Integer num) {
                    return invoke((Transition.Segment) obj, composer2, num.intValue());
                }
            };
        }
        if ((i2 & 4) != 0) {
            str = "ValueAnimation";
        }
        int i4 = (i >> 9) & 112;
        return createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i4)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i4)), function3.invoke(transition.getSegment(), composer, Integer.valueOf((i >> 3) & 112)), twoWayConverter, str, composer, (i & 14) | (57344 & (i << 9)) | ((i << 6) & 458752));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @NotNull
    @ExperimentalTransitionApi
    @Composable
    public static final <S, T> Transition<T> createChildTransition(@NotNull Transition<S> transition, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, ? extends T> function3, @Nullable Composer composer, int i, int i2) {
        boolean z = true;
        if ((i2 & 1) != 0) {
            str = "ChildTransition";
        }
        String str2 = str;
        int i4 = i & 14;
        if (((i4 ^ 6) <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z = false;
        }
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = transition.getCurrentState();
            composer.updateRememberedValue(objRememberedValue);
        }
        if (transition.isSeeking()) {
            objRememberedValue = transition.getCurrentState();
        }
        int i5 = (i >> 3) & 112;
        return createChildTransitionInternal(transition, function3.invoke(objRememberedValue, composer, Integer.valueOf(i5)), function3.invoke(transition.getTargetState(), composer, Integer.valueOf(i5)), str2, composer, i4 | ((i << 6) & 7168));
    }

    @Composable
    @PublishedApi
    @NotNull
    public static final <S, T> Transition<T> createChildTransitionInternal(@NotNull final Transition<S> transition, T t, T t2, @NotNull String str, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, i, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1825)");
        }
        int i2 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i2 > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Transition(new MutableTransitionState(t), transition, transition.getLabel() + " > " + str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<T> transition2 = (Transition) objRememberedValue;
        if ((i2 <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z = false;
        }
        boolean zChanged = composer.changed(transition2) | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
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
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    transition.addTransition$animation_core_release(transition2);
                    final Transition<S> transition3 = transition;
                    final Transition<T> transition4 = transition2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition3.removeTransition$animation_core_release(transition4);
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t, t2, transition.getLastSeekedTimeNanos());
        } else {
            transition2.updateTarget$animation_core_release(t2);
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition2;
    }

    @Composable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(@NotNull final Transition<S> transition, @NotNull TwoWayConverter<T, V> twoWayConverter, @Nullable String str, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, i, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1779)");
        }
        int i4 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i4 > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = transition.new DeferredAnimation(twoWayConverter, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) objRememberedValue;
        if ((i4 <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z = false;
        }
        boolean zChangedInstance = composer.changedInstance(deferredAnimation) | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    final Transition<S> transition2 = transition;
                    final Transition<S>.DeferredAnimation<T, V> deferredAnimation2 = deferredAnimation;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.removeAnimation$animation_core_release(deferredAnimation2);
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(deferredAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return deferredAnimation;
    }

    @Composable
    @PublishedApi
    @NotNull
    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(@NotNull final Transition<S> transition, T t, T t2, @NotNull FiniteAnimationSpec<T> finiteAnimationSpec, @NotNull TwoWayConverter<T, V> twoWayConverter, @NotNull String str, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304821198, i, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1900)");
        }
        int i2 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i2 > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object transitionAnimationState = transition.new TransitionAnimationState(t, AnimationStateKt.createZeroVectorFrom(twoWayConverter, t2), twoWayConverter, str);
            composer.updateRememberedValue(transitionAnimationState);
            objRememberedValue = transitionAnimationState;
        }
        final Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) objRememberedValue;
        if (transition.isSeeking()) {
            transitionAnimationState2.updateInitialAndTargetValue$animation_core_release(t, t2, finiteAnimationSpec);
        } else {
            transitionAnimationState2.updateTargetValue$animation_core_release(t2, finiteAnimationSpec);
        }
        if ((i2 <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z = false;
        }
        boolean zChanged = composer.changed(transitionAnimationState2) | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
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
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    transition.addAnimation$animation_core_release(transitionAnimationState2);
                    final Transition<S> transition2 = transition;
                    final Transition<S>.TransitionAnimationState<T, V> transitionAnimationState3 = transitionAnimationState2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.removeAnimation$animation_core_release(transitionAnimationState3);
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(transitionAnimationState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transitionAnimationState2;
    }

    @NotNull
    public static final SnapshotStateObserver getSeekableStateObserver() {
        return (SnapshotStateObserver) SeekableStateObserver$delegate.getValue();
    }

    @Composable
    @NotNull
    public static final <T> Transition<T> rememberTransition(@NotNull TransitionState<T> transitionState, @Nullable String str, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1643203617, i, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:820)");
        }
        int i4 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i4 > 4 && composer.changed(transitionState)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Transition((TransitionState) transitionState, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<T> transition = (Transition) objRememberedValue;
        if (transitionState instanceof SeekableTransitionState) {
            composer.startReplaceGroup(1030413636);
            T currentState = transitionState.getCurrentState();
            T targetState = transitionState.getTargetState();
            if ((i4 <= 4 || !composer.changed(transitionState)) && (i & 6) != 4) {
                z = false;
            }
            Object objRememberedValue2 = composer.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new TransitionKt$rememberTransition$1$1(transitionState, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(currentState, targetState, (Function2) objRememberedValue2, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1030875195);
            transition.animateTo$animation_core_release(transitionState.getTargetState(), composer, 0);
            composer.endReplaceGroup();
        }
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.onDisposed$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition;
    }

    @Composable
    @NotNull
    public static final <T> Transition<T> updateTransition(T t, @Nullable String str, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:91)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new Transition(t, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<T> transition = (Transition) objRememberedValue;
        transition.animateTo$animation_core_release(t, composer, (i & 8) | 48 | (i & 14));
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.onDisposed$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition;
    }

    @Deprecated(message = "Use rememberTransition() instead", replaceWith = @ReplaceWith(expression = "rememberTransition(transitionState, label)", imports = {}))
    @Composable
    @NotNull
    public static final <T> Transition<T> updateTransition(@NotNull MutableTransitionState<T> mutableTransitionState, @Nullable String str, @Nullable Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:873)");
        }
        Transition<T> transitionRememberTransition = rememberTransition(mutableTransitionState, str, composer, i & 126, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transitionRememberTransition;
    }
}
