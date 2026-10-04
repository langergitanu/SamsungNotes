package androidx.compose.material;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SliderKt;
import androidx.compose.material.Strings;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ShadowKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.PointMode;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.InspectableValueKt;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u001b\u001a\u007f\u0010\u001c\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010'\u001ak\u0010(\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00103\u001a}\u00104\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u00106\u001aK\u00107\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u00108\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u00105\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00109\u001aS\u0010:\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0003¢\u0006\u0002\u0010=\u001a1\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010D\u001a \u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a0\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a<\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a.\u0010P\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010!\u001a\u00020\"H\u0002\u001aI\u0010T\u001a\u00020\u0012*\u00020U2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u00032\u0006\u00105\u001a\u00020/2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010W\u001a\u00020\u0003H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a;\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\b\u0018\u00010[*\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0082@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001a\u0098\u0001\u0010d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0f2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010h\u001a\u00020 2\u0006\u0010R\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u00140f2\u001e\u0010j\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120k0fH\u0002\u001a\\\u0010l\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"H\u0002\u001aj\u0010m\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020@2\u0006\u00105\u001a\u00020/2\u0006\u0010R\u001a\u00020\b2\u0006\u0010h\u001a\u00020 2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00140f2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000b\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\r\"\u0013\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\r\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006p"}, m13886d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbPressedElevation", "ThumbRadius", "getThumbRadius", "()F", "ThumbRippleRadius", "TrackHeight", "getTrackHeight", "CorrectValueSideEffect", "", "scaleToOffset", "Lkotlin/Function1;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "RangeSlider", "onValueChange", "modifier", "enabled", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "interactionSource", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", WiggleAnimationConfig.KEY_SCALE, SAConstants.DETAIL_DEFAULT_IMAGE_BLANK, SAConstants.DETAIL_DEFAULT_PDF_NOTEBOOK, "x1", SAConstants.DETAIL_DEFAULT_IMAGE_LINED, SAConstants.DETAIL_DEFAULT_PDF_PLANNER_1, "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", TypedValues.Cycle.S_WAVE_OFFSET, "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SliderKt {

    @NotNull
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;

    @NotNull
    private static final TweenSpec<Float> SliderToTickAnimation;
    private static final float ThumbRadius = C2256Dp.m20968constructorimpl(10);
    private static final float ThumbRippleRadius = C2256Dp.m20968constructorimpl(24);
    private static final float ThumbDefaultElevation = C2256Dp.m20968constructorimpl(1);
    private static final float ThumbPressedElevation = C2256Dp.m20968constructorimpl(6);
    private static final float TrackHeight = C2256Dp.m20968constructorimpl(4);

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class C15872 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ int $steps;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ ClosedFloatingPointRange<Float> $value;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
        public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Float, Float> {
            final /* synthetic */ Ref.FloatRef $maxPx;
            final /* synthetic */ Ref.FloatRef $minPx;
            final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
                super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = closedFloatingPointRange;
                this.$minPx = floatRef;
                this.$maxPx = floatRef2;
            }

            @NotNull
            public final Float invoke(float f) {
                return Float.valueOf(C15872.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
        public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Float, Float> {
            final /* synthetic */ Ref.FloatRef $maxPx;
            final /* synthetic */ Ref.FloatRef $minPx;
            final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
                super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = closedFloatingPointRange;
                this.$minPx = floatRef;
                this.$maxPx = floatRef2;
            }

            @NotNull
            public final Float invoke(float f) {
                return Float.valueOf(C15872.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C15872(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, int i2, Function0<Unit> function0, List<Float> list, SliderColors sliderColors) {
            super(3);
            this.$valueRange = closedFloatingPointRange;
            this.$value = closedFloatingPointRange2;
            this.$$dirty = i;
            this.$onValueChangeState = state;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$enabled = z;
            this.$steps = i2;
            this.$onValueChangeFinished = function0;
            this.$tickFractions = list;
            this.$colors = sliderColors;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
            return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
            return SliderKt.scale(floatRef.element, floatRef2.element, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
            invoke(boxWithConstraintsScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer, int i) {
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((((i & 14) == 0 ? (composer.changed(BoxWithConstraints) ? 4 : 2) | i : i) & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652589923, i, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:313)");
            }
            boolean z = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            float fM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            floatRef.element = fM20921getMaxWidthimpl - density.mo15546toPx0680j_4(SliderKt.getThumbRadius());
            floatRef2.element = density.mo15546toPx0680j_4(SliderKt.getThumbRadius());
            Unit unit = Unit.INSTANCE;
            ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$value;
            ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(closedFloatingPointRange2, floatRef2, floatRef, closedFloatingPointRange.getStart().floatValue())), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            final MutableState mutableState = (MutableState) objRememberedValue;
            ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$value;
            ClosedFloatingPointRange<Float> closedFloatingPointRange4 = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(closedFloatingPointRange4, floatRef2, floatRef, closedFloatingPointRange3.getEndInclusive().floatValue())), null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            SliderKt.CorrectValueSideEffect(new AnonymousClass2(this.$valueRange, floatRef2, floatRef), this.$valueRange, RangesKt.rangeTo(floatRef2.element, floatRef.element), mutableState, this.$value.getStart().floatValue(), composer, ((this.$$dirty >> 9) & 112) | 3072);
            SliderKt.CorrectValueSideEffect(new AnonymousClass3(this.$valueRange, floatRef2, floatRef), this.$valueRange, RangesKt.rangeTo(floatRef2.element, floatRef.element), mutableState2, this.$value.getEndInclusive().floatValue(), composer, ((this.$$dirty >> 9) & 112) | 3072);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer), composer);
            }
            composer.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).getCoroutineScope();
            composer.endReplaceableGroup();
            final List<Float> list = this.$tickFractions;
            final Function0<Unit> function0 = this.$onValueChangeFinished;
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = this.$valueRange;
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1 */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {PopOverActivityWrapper.DEFAULT_WIDTH}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class C15881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ float $current;
                    final /* synthetic */ boolean $isStart;
                    final /* synthetic */ Ref.FloatRef $maxPx;
                    final /* synthetic */ Ref.FloatRef $minPx;
                    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
                    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
                    final /* synthetic */ MutableState<Float> $rawOffsetStart;
                    final /* synthetic */ float $target;
                    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C15881(float f, float f4, Function0<Unit> function0, boolean z, MutableState<Float> mutableState, MutableState<Float> mutableState2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Continuation<? super C15881> continuation) {
                        super(2, continuation);
                        this.$current = f;
                        this.$target = f4;
                        this.$onValueChangeFinished = function0;
                        this.$isStart = z;
                        this.$rawOffsetStart = mutableState;
                        this.$rawOffsetEnd = mutableState2;
                        this.$onValueChangeState = state;
                        this.$minPx = floatRef;
                        this.$maxPx = floatRef2;
                        this.$valueRange = closedFloatingPointRange;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new C15881(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null);
                            Float fBoxFloat = Boxing.boxFloat(this.$target);
                            TweenSpec tweenSpec = SliderKt.SliderToTickAnimation;
                            Float fBoxFloat2 = Boxing.boxFloat(0.0f);
                            final boolean z = this.$isStart;
                            final MutableState<Float> mutableState = this.$rawOffsetStart;
                            final MutableState<Float> mutableState2 = this.$rawOffsetEnd;
                            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
                            final Ref.FloatRef floatRef = this.$minPx;
                            final Ref.FloatRef floatRef2 = this.$maxPx;
                            final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
                            Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.2.gestureEndAction.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                                    invoke2(animatable);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull Animatable<Float, AnimationVector1D> animateTo) {
                                    Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                                    (z ? mutableState : mutableState2).setValue(animateTo.getValue());
                                    state.getValue().invoke(SliderKt.C15872.invoke$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange, RangesKt.rangeTo(mutableState.getValue().floatValue(), mutableState2.getValue().floatValue())));
                                }
                            };
                            this.label = 1;
                            if (animatableAnimatable$default.animateTo(fBoxFloat, tweenSpec, fBoxFloat2, function1, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Function0<Unit> function0 = this.$onValueChangeFinished;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((C15881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z2) {
                    float fFloatValue = (z2 ? mutableState : mutableState2).getValue().floatValue();
                    float fSnapValueToTick = SliderKt.snapValueToTick(fFloatValue, list, floatRef2.element, floatRef.element);
                    if (fFloatValue != fSnapValueToTick) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C15881(fFloatValue, fSnapValueToTick, function0, z2, mutableState, mutableState2, state, floatRef2, floatRef, closedFloatingPointRange5, null), 3, null);
                        return;
                    }
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }
            }, composer, 0);
            ClosedFloatingPointRange<Float> closedFloatingPointRange6 = this.$valueRange;
            Float fValueOf = Float.valueOf(floatRef2.element);
            Float fValueOf2 = Float.valueOf(floatRef.element);
            final ClosedFloatingPointRange<Float> closedFloatingPointRange7 = this.$value;
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state2 = this.$onValueChangeState;
            Object[] objArr = {mutableState, mutableState2, closedFloatingPointRange6, fValueOf, fValueOf2, closedFloatingPointRange7, state2};
            final ClosedFloatingPointRange<Float> closedFloatingPointRange8 = this.$valueRange;
            composer.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i2 = 0; i2 < 7; i2++) {
                zChanged |= composer.changed(objArr[i2]);
            }
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function2<Boolean, Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Float f) {
                        invoke(bool.booleanValue(), f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2, float f) {
                        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
                        if (z2) {
                            MutableState<Float> mutableState3 = mutableState;
                            mutableState3.setValue(Float.valueOf(mutableState3.getValue().floatValue() + f));
                            mutableState2.setValue(Float.valueOf(SliderKt.C15872.invoke$scaleToOffset(closedFloatingPointRange8, floatRef2, floatRef, closedFloatingPointRange7.getEndInclusive().floatValue())));
                            float fFloatValue = mutableState2.getValue().floatValue();
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(RangesKt.coerceIn(mutableState.getValue().floatValue(), floatRef2.element, fFloatValue), fFloatValue);
                        } else {
                            MutableState<Float> mutableState4 = mutableState2;
                            mutableState4.setValue(Float.valueOf(mutableState4.getValue().floatValue() + f));
                            mutableState.setValue(Float.valueOf(SliderKt.C15872.invoke$scaleToOffset(closedFloatingPointRange8, floatRef2, floatRef, closedFloatingPointRange7.getStart().floatValue())));
                            float fFloatValue2 = mutableState.getValue().floatValue();
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(fFloatValue2, RangesKt.coerceIn(mutableState2.getValue().floatValue(), fFloatValue2, floatRef.element));
                        }
                        state2.getValue().invoke(SliderKt.C15872.invoke$scaleToUserValue(floatRef2, floatRef, closedFloatingPointRange8, closedFloatingPointRangeRangeTo));
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(objRememberedValue4, composer, 0);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierRangeSliderPressDragModifier = SliderKt.rangeSliderPressDragModifier(companion2, this.$startInteractionSource, this.$endInteractionSource, mutableState, mutableState2, this.$enabled, z, fM20921getMaxWidthimpl, this.$valueRange, stateRememberUpdatedState, stateRememberUpdatedState2);
            final float fCoerceIn = RangesKt.coerceIn(this.$value.getStart().floatValue(), this.$valueRange.getStart().floatValue(), this.$value.getEndInclusive().floatValue());
            final float fCoerceIn2 = RangesKt.coerceIn(this.$value.getEndInclusive().floatValue(), this.$value.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
            float fCalcFraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), fCoerceIn);
            float fCalcFraction2 = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), fCoerceIn2);
            int iFloor = (int) Math.floor(this.$steps * fCalcFraction2);
            int iFloor2 = (int) Math.floor((1.0f - fCalcFraction) * this.$steps);
            boolean z2 = this.$enabled;
            State<Function1<ClosedFloatingPointRange<Float>, Unit>> state3 = this.$onValueChangeState;
            Float fValueOf3 = Float.valueOf(fCoerceIn2);
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state4 = this.$onValueChangeState;
            composer.startReplaceableGroup(511388516);
            boolean zChanged2 = composer.changed(state3) | composer.changed(fValueOf3);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f) {
                        state4.getValue().invoke(RangesKt.rangeTo(f, fCoerceIn2));
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierSliderSemantics = SliderKt.sliderSemantics(companion2, fCoerceIn, z2, (Function1) objRememberedValue5, this.$onValueChangeFinished, RangesKt.rangeTo(this.$valueRange.getStart().floatValue(), fCoerceIn2), iFloor);
            boolean z3 = this.$enabled;
            State<Function1<ClosedFloatingPointRange<Float>, Unit>> state5 = this.$onValueChangeState;
            Float fValueOf4 = Float.valueOf(fCoerceIn);
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state6 = this.$onValueChangeState;
            composer.startReplaceableGroup(511388516);
            boolean zChanged3 = composer.changed(state5) | composer.changed(fValueOf4);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f) {
                        state6.getValue().invoke(RangesKt.rangeTo(fCoerceIn, f));
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            composer.endReplaceableGroup();
            Modifier modifierSliderSemantics2 = SliderKt.sliderSemantics(companion2, fCoerceIn2, z3, (Function1) objRememberedValue6, this.$onValueChangeFinished, RangesKt.rangeTo(fCoerceIn, this.$valueRange.getEndInclusive().floatValue()), iFloor2);
            boolean z4 = this.$enabled;
            List<Float> list2 = this.$tickFractions;
            SliderColors sliderColors = this.$colors;
            float f = floatRef.element - floatRef2.element;
            MutableInteractionSource mutableInteractionSource = this.$startInteractionSource;
            MutableInteractionSource mutableInteractionSource2 = this.$endInteractionSource;
            int i4 = this.$$dirty;
            SliderKt.RangeSliderImpl(z4, fCalcFraction, fCalcFraction2, list2, sliderColors, f, mutableInteractionSource, mutableInteractionSource2, modifierRangeSliderPressDragModifier, modifierSliderSemantics, modifierSliderSemantics2, composer, ((i4 >> 9) & 14) | 14159872 | ((i4 >> 9) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class C15913 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $value;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
        public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Float, Float> {
            final /* synthetic */ Ref.FloatRef $maxPx;
            final /* synthetic */ Ref.FloatRef $minPx;
            final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
                super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = closedFloatingPointRange;
                this.$minPx = floatRef;
                this.$maxPx = floatRef2;
            }

            @NotNull
            public final Float invoke(float f) {
                return Float.valueOf(C15913.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C15913(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
            super(3);
            this.$valueRange = closedFloatingPointRange;
            this.$$dirty = i;
            this.$value = f;
            this.$interactionSource = mutableInteractionSource;
            this.$enabled = z;
            this.$tickFractions = list;
            this.$colors = sliderColors;
            this.$onValueChangeState = state;
            this.$onValueChangeFinished = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
            return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f) {
            return SliderKt.scale(floatRef.element, floatRef2.element, f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
            invoke(boxWithConstraintsScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer, int i) {
            int i2;
            Continuation continuation;
            final MutableState mutableState;
            MutableState mutableState2;
            Ref.FloatRef floatRef;
            Ref.FloatRef floatRef2;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 14) == 0) {
                i2 = (composer.changed(BoxWithConstraints) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2085116814, i, -1, "androidx.compose.material.Slider.<anonymous> (Slider.kt:174)");
            }
            boolean z = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            float fM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
            final Ref.FloatRef floatRef3 = new Ref.FloatRef();
            final Ref.FloatRef floatRef4 = new Ref.FloatRef();
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            floatRef3.element = Math.max(fM20921getMaxWidthimpl - density.mo15546toPx0680j_4(SliderKt.getThumbRadius()), 0.0f);
            floatRef4.element = Math.min(density.mo15546toPx0680j_4(SliderKt.getThumbRadius()), floatRef3.element);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer), composer);
            }
            composer.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            float f = this.$value;
            ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(closedFloatingPointRange, floatRef4, floatRef3, f)), null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableState mutableState3 = (MutableState) objRememberedValue2;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            final MutableState mutableState4 = (MutableState) objRememberedValue3;
            Object objValueOf = Float.valueOf(floatRef4.element);
            Object objValueOf2 = Float.valueOf(floatRef3.element);
            final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
            final State<Function1<Float, Unit>> state = this.$onValueChangeState;
            composer.startReplaceableGroup(1618982084);
            boolean zChanged = composer.changed(objValueOf) | composer.changed(objValueOf2) | composer.changed(closedFloatingPointRange2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == companion.getEmpty()) {
                continuation = null;
                mutableState = mutableState3;
                mutableState2 = mutableState4;
                floatRef = floatRef4;
                floatRef2 = floatRef3;
                objRememberedValue4 = new SliderDraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f4) {
                        invoke(f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f4) {
                        MutableState<Float> mutableState5 = mutableState;
                        mutableState5.setValue(Float.valueOf(mutableState4.getValue().floatValue() + mutableState5.getValue().floatValue() + f4));
                        mutableState4.setValue(Float.valueOf(0.0f));
                        state.getValue().invoke(Float.valueOf(SliderKt.C15913.invoke$scaleToUserValue(floatRef4, floatRef3, closedFloatingPointRange2, RangesKt.coerceIn(mutableState.getValue().floatValue(), floatRef4.element, floatRef3.element))));
                    }
                });
                composer.updateRememberedValue(objRememberedValue4);
            } else {
                floatRef2 = floatRef3;
                continuation = null;
                mutableState2 = mutableState4;
                mutableState = mutableState3;
                floatRef = floatRef4;
            }
            composer.endReplaceableGroup();
            final SliderDraggableState sliderDraggableState = (SliderDraggableState) objRememberedValue4;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$valueRange, floatRef, floatRef2);
            ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$valueRange;
            ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(floatRef.element, floatRef2.element);
            float f4 = this.$value;
            int i4 = this.$$dirty;
            SliderKt.CorrectValueSideEffect(anonymousClass2, closedFloatingPointRange3, closedFloatingPointRangeRangeTo, mutableState, f4, composer, ((i4 >> 9) & 112) | 3072 | ((i4 << 12) & 57344));
            final Ref.FloatRef floatRef5 = floatRef;
            final List<Float> list = this.$tickFractions;
            final Function0<Unit> function0 = this.$onValueChangeFinished;
            final Ref.FloatRef floatRef6 = floatRef2;
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1 */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {212}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class C15921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ float $current;
                    final /* synthetic */ SliderDraggableState $draggableState;
                    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                    final /* synthetic */ float $target;
                    final /* synthetic */ float $velocity;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C15921(SliderDraggableState sliderDraggableState, float f, float f4, float f5, Function0<Unit> function0, Continuation<? super C15921> continuation) {
                        super(2, continuation);
                        this.$draggableState = sliderDraggableState;
                        this.$current = f;
                        this.$target = f4;
                        this.$velocity = f5;
                        this.$onValueChangeFinished = function0;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new C15921(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SliderDraggableState sliderDraggableState = this.$draggableState;
                            float f = this.$current;
                            float f4 = this.$target;
                            float f5 = this.$velocity;
                            this.label = 1;
                            if (SliderKt.animateToTarget(sliderDraggableState, f, f4, f5, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Function0<Unit> function0 = this.$onValueChangeFinished;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((C15921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f5) {
                    invoke(f5.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f5) {
                    Function0<Unit> function02;
                    float fFloatValue = mutableState.getValue().floatValue();
                    float fSnapValueToTick = SliderKt.snapValueToTick(fFloatValue, list, floatRef5.element, floatRef6.element);
                    if (fFloatValue != fSnapValueToTick) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C15921(sliderDraggableState, fFloatValue, fSnapValueToTick, f5, function0, null), 3, null);
                    } else {
                        if (sliderDraggableState.isDragging() || (function02 = function0) == null) {
                            return;
                        }
                        function02.invoke();
                    }
                }
            }, composer, 0);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Continuation continuation2 = continuation;
            Modifier modifierSliderTapModifier = SliderKt.sliderTapModifier(companion2, sliderDraggableState, this.$interactionSource, fM20921getMaxWidthimpl, z, mutableState, stateRememberUpdatedState, mutableState2, this.$enabled);
            Orientation orientation = Orientation.Horizontal;
            boolean zIsDragging = sliderDraggableState.isDragging();
            boolean z2 = this.$enabled;
            boolean z3 = z;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged2 = composer.changed(stateRememberUpdatedState);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new SliderKt$Slider$3$drag$1$1(stateRememberUpdatedState, continuation2);
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierDraggable$default = DraggableKt.draggable$default(companion2, sliderDraggableState, orientation, z2, mutableInteractionSource, zIsDragging, null, (Function3) objRememberedValue5, z3, 32, null);
            float fCalcFraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), RangesKt.coerceIn(this.$value, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue()));
            boolean z4 = this.$enabled;
            List<Float> list2 = this.$tickFractions;
            SliderColors sliderColors = this.$colors;
            float f5 = floatRef6.element - floatRef5.element;
            MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            Modifier modifierThen = modifierSliderTapModifier.then(modifierDraggable$default);
            int i5 = this.$$dirty;
            SliderKt.SliderImpl(z4, fCalcFraction, list2, sliderColors, f5, mutableInteractionSource2, modifierThen, composer, ((i5 >> 6) & 458752) | ((i5 >> 9) & 14) | 512 | ((i5 >> 15) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$animateToTarget$2", m14021f = "Slider.kt", m14022i = {}, m14023l = {954}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C15982 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15982(float f, float f4, float f5, Continuation<? super C15982> continuation) {
            super(2, continuation);
            this.$current = f;
            this.$target = f4;
            this.$velocity = f5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C15982 c15982 = new C15982(this.$current, this.$target, this.$velocity, continuation);
            c15982.L$0 = obj;
            return c15982;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C15982) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final DragScope dragScope = (DragScope) this.L$0;
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                float f = this.$current;
                floatRef.element = f;
                Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(f, 0.0f, 2, null);
                Float fBoxFloat = Boxing.boxFloat(this.$target);
                TweenSpec tweenSpec = SliderKt.SliderToTickAnimation;
                Float fBoxFloat2 = Boxing.boxFloat(this.$velocity);
                Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt.animateToTarget.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                        invoke2(animatable);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Animatable<Float, AnimationVector1D> animateTo) {
                        Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                        dragScope.dragBy(animateTo.getValue().floatValue() - floatRef.element);
                        floatRef.element = animateTo.getValue().floatValue();
                    }
                };
                this.label = 1;
                if (animatableAnimatable$default.animateTo(fBoxFloat, tweenSpec, fBoxFloat2, function1, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {982}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C15991 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
        final /* synthetic */ State<Float> $rawOffsetEnd;
        final /* synthetic */ State<Float> $rawOffsetStart;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {983}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ float $maxPx;
            final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ State<Float> $rawOffsetEnd;
            final /* synthetic */ State<Float> $rawOffsetStart;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {984}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C145501 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ State<Float> $rawOffsetEnd;
                final /* synthetic */ State<Float> $rawOffsetStart;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1", m14021f = "Slider.kt", m14022i = {0, 1, 1, 1, 1, 1, 2, 2}, m14023l = {985, 995, 1014}, m14024m = "invokeSuspend", m14025n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "event", "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, m14026s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
                public static final class C145511 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ float $maxPx;
                    final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    final /* synthetic */ State<Float> $rawOffsetEnd;
                    final /* synthetic */ State<Float> $rawOffsetStart;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                    @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2", m14021f = "Slider.kt", m14022i = {}, m14023l = {ErrorCodeConvertor.TEMP_AGENT_WIFI_ONLY_MODEL}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Ref.BooleanRef $draggingStart;
                        final /* synthetic */ DragInteraction $finishInteraction;
                        final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$rangeSliderLogic = rangeSliderLogic;
                            this.$draggingStart = booleanRef;
                            this.$finishInteraction = dragInteraction;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                MutableInteractionSource mutableInteractionSourceActiveInteraction = this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element);
                                DragInteraction dragInteraction = this.$finishInteraction;
                                this.label = 1;
                                if (mutableInteractionSourceActiveInteraction.emit(dragInteraction, this) == coroutine_suspended) {
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
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C145511(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C145511> continuation) {
                        super(2, continuation);
                        this.$isRtl = z;
                        this.$maxPx = f;
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$rawOffsetStart = state;
                        this.$$this$coroutineScope = coroutineScope;
                        this.$gestureEndAction = state2;
                        this.$rawOffsetEnd = state3;
                        this.$onDrag = state4;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        C145511 c145511 = new C145511(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                        c145511.L$0 = obj;
                        return c145511;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((C145511) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc  */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x0172  */
                    /* JADX WARN: Removed duplicated region for block: B:57:0x017c A[Catch: CancellationException -> 0x018a, TryCatch #1 {CancellationException -> 0x018a, blocks: (B:8:0x001d, B:55:0x0174, B:57:0x017c, B:58:0x0182), top: B:67:0x001d }] */
                    /* JADX WARN: Removed duplicated region for block: B:58:0x0182 A[Catch: CancellationException -> 0x018a, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x018a, blocks: (B:8:0x001d, B:55:0x0174, B:57:0x017c, B:58:0x0182), top: B:67:0x001d }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(@NotNull Object obj) {
                        AwaitPointerEventScope awaitPointerEventScope;
                        Object objAwaitFirstDown;
                        Object objM16851awaitSlop8vUncbI;
                        AwaitPointerEventScope awaitPointerEventScope2;
                        PointerInputChange pointerInputChange;
                        Ref.FloatRef floatRef;
                        DragInteraction.Start start;
                        final Ref.BooleanRef booleanRef;
                        Pair pair;
                        Ref.BooleanRef booleanRef2;
                        DragInteraction.Start start2;
                        Object objM15596horizontalDragjO51t88;
                        DragInteraction cancel;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            this.L$0 = awaitPointerEventScope;
                            this.label = 1;
                            objAwaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, this);
                            if (objAwaitFirstDown != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                booleanRef2 = (Ref.BooleanRef) this.L$1;
                                start2 = (DragInteraction.Start) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    objM15596horizontalDragjO51t88 = obj;
                                    cancel = !((Boolean) objM15596horizontalDragjO51t88).booleanValue() ? new DragInteraction.Stop(start2) : new DragInteraction.Cancel(start2);
                                } catch (CancellationException unused) {
                                    cancel = new DragInteraction.Cancel(start2);
                                }
                                this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            booleanRef = (Ref.BooleanRef) this.L$4;
                            Ref.FloatRef floatRef2 = (Ref.FloatRef) this.L$3;
                            start = (DragInteraction.Start) this.L$2;
                            PointerInputChange pointerInputChange2 = (PointerInputChange) this.L$1;
                            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope2 = awaitPointerEventScope3;
                            pointerInputChange = pointerInputChange2;
                            floatRef = floatRef2;
                            objM16851awaitSlop8vUncbI = obj;
                            pair = (Pair) objM16851awaitSlop8vUncbI;
                            if (pair != null) {
                                State<Float> state = this.$rawOffsetEnd;
                                State<Float> state2 = this.$rawOffsetStart;
                                boolean z = this.$isRtl;
                                float fM16720pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m16720pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), pointerInputChange.getType());
                                if (Math.abs(state.getValue().floatValue() - floatRef.element) < fM16720pointerSlopE8SPZFQ && Math.abs(state2.getValue().floatValue() - floatRef.element) < fM16720pointerSlopE8SPZFQ) {
                                    float fFloatValue = ((Number) pair.getSecond()).floatValue();
                                    booleanRef.element = !z ? fFloatValue >= 0.0f : fFloatValue < 0.0f;
                                    floatRef.element = Offset.m18284getXimpl(PointerEventKt.positionChange((PointerInputChange) pair.getFirst())) + floatRef.element;
                                }
                            }
                            this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                            try {
                                long id = pointerInputChange.getId();
                                final State<Function2<Boolean, Float, Unit>> state3 = this.$onDrag;
                                final boolean z2 = this.$isRtl;
                                Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3) {
                                        invoke2(pointerInputChange3);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull PointerInputChange it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        float fM18284getXimpl = Offset.m18284getXimpl(PointerEventKt.positionChange(it));
                                        Function2<Boolean, Float, Unit> value = state3.getValue();
                                        Boolean boolValueOf = Boolean.valueOf(booleanRef.element);
                                        if (z2) {
                                            fM18284getXimpl = -fM18284getXimpl;
                                        }
                                        value.invoke(boolValueOf, Float.valueOf(fM18284getXimpl));
                                    }
                                };
                                this.L$0 = start;
                                this.L$1 = booleanRef;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 3;
                                objM15596horizontalDragjO51t88 = DragGestureDetectorKt.m15596horizontalDragjO51t88(awaitPointerEventScope2, id, function1, this);
                            } catch (CancellationException unused2) {
                                booleanRef2 = booleanRef;
                                start2 = start;
                                cancel = new DragInteraction.Cancel(start2);
                            }
                            if (objM15596horizontalDragjO51t88 != coroutine_suspended) {
                                booleanRef2 = booleanRef;
                                start2 = start;
                                if (!((Boolean) objM15596horizontalDragjO51t88).booleanValue()) {
                                }
                                this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objAwaitFirstDown = obj;
                        AwaitPointerEventScope awaitPointerEventScope4 = awaitPointerEventScope;
                        PointerInputChange pointerInputChange3 = (PointerInputChange) objAwaitFirstDown;
                        DragInteraction.Start start3 = new DragInteraction.Start();
                        Ref.FloatRef floatRef3 = new Ref.FloatRef();
                        float fM18284getXimpl = this.$isRtl ? this.$maxPx - Offset.m18284getXimpl(pointerInputChange3.getPosition()) : Offset.m18284getXimpl(pointerInputChange3.getPosition());
                        floatRef3.element = fM18284getXimpl;
                        int iCompareOffsets = this.$rangeSliderLogic.compareOffsets(fM18284getXimpl);
                        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                        booleanRef3.element = iCompareOffsets == 0 ? this.$rawOffsetStart.getValue().floatValue() > floatRef3.element : iCompareOffsets < 0;
                        long id2 = pointerInputChange3.getId();
                        int type = pointerInputChange3.getType();
                        this.L$0 = awaitPointerEventScope4;
                        this.L$1 = pointerInputChange3;
                        this.L$2 = start3;
                        this.L$3 = floatRef3;
                        this.L$4 = booleanRef3;
                        this.label = 2;
                        objM16851awaitSlop8vUncbI = SliderKt.m16851awaitSlop8vUncbI(awaitPointerEventScope4, id2, type, this);
                        if (objM16851awaitSlop8vUncbI != coroutine_suspended) {
                            awaitPointerEventScope2 = awaitPointerEventScope4;
                            pointerInputChange = pointerInputChange3;
                            floatRef = floatRef3;
                            start = start3;
                            booleanRef = booleanRef3;
                            pair = (Pair) objM16851awaitSlop8vUncbI;
                            if (pair != null) {
                            }
                            this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                            long id3 = pointerInputChange.getId();
                            final State<? extends Function2<? super Boolean, ? super Float, Unit>> state32 = this.$onDrag;
                            final boolean z22 = this.$isRtl;
                            Function1<PointerInputChange, Unit> function12 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange32) {
                                    invoke2(pointerInputChange32);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull PointerInputChange it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    float fM18284getXimpl2 = Offset.m18284getXimpl(PointerEventKt.positionChange(it));
                                    Function2<Boolean, Float, Unit> value = state32.getValue();
                                    Boolean boolValueOf = Boolean.valueOf(booleanRef.element);
                                    if (z22) {
                                        fM18284getXimpl2 = -fM18284getXimpl2;
                                    }
                                    value.invoke(boolValueOf, Float.valueOf(fM18284getXimpl2));
                                }
                            };
                            this.L$0 = start;
                            this.L$1 = booleanRef;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 3;
                            objM15596horizontalDragjO51t88 = DragGestureDetectorKt.m15596horizontalDragjO51t88(awaitPointerEventScope2, id3, function12, this);
                            if (objM15596horizontalDragjO51t88 != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C145501(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C145501> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$rawOffsetStart = state;
                    this.$$this$coroutineScope = coroutineScope;
                    this.$gestureEndAction = state2;
                    this.$rawOffsetEnd = state3;
                    this.$onDrag = state4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    C145501 c145501 = new C145501(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                    c145501.L$0 = obj;
                    return c145501;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C145501) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                        C145511 c145511 = new C145511(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                        this.label = 1;
                        if (pointerInputScope.awaitPointerEventScope(c145511, this) == coroutine_suspended) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(PointerInputScope pointerInputScope, boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$isRtl = z;
                this.$maxPx = f;
                this.$rangeSliderLogic = rangeSliderLogic;
                this.$rawOffsetStart = state;
                this.$gestureEndAction = state2;
                this.$rawOffsetEnd = state3;
                this.$onDrag = state4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
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
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C145501 c145501 = new C145501(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                    this.label = 1;
                    if (ForEachGestureKt.forEachGesture(pointerInputScope, c145501, this) == coroutine_suspended) {
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
        /* JADX WARN: Multi-variable type inference failed */
        public C15991(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, State<? extends Function2<? super Boolean, ? super Float, Unit>> state3, boolean z, float f, State<? extends Function1<? super Boolean, Unit>> state4, Continuation<? super C15991> continuation) {
            super(2, continuation);
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$rawOffsetStart = state;
            this.$rawOffsetEnd = state2;
            this.$onDrag = state3;
            this.$isRtl = z;
            this.$maxPx = f;
            this.$gestureEndAction = state4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C15991 c15991 = new C15991(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag, this.$isRtl, this.$maxPx, this.$gestureEndAction, continuation);
            c15991.L$0 = obj;
            return c15991;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C15991) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.L$0, this.$isRtl, this.$maxPx, new RangeSliderLogic(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag), this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
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
    }

    static {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(48);
        SliderHeight = fM20968constructorimpl;
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(144);
        SliderMinWidth = fM20968constructorimpl2;
        DefaultSliderConstraints = SizeKt.m15887heightInVpY3zN4$default(SizeKt.m15906widthInVpY3zN4$default(Modifier.INSTANCE, fM20968constructorimpl2, 0.0f, 2, null), 0.0f, fM20968constructorimpl, 1, null);
        SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void CorrectValueSideEffect(final Function1<? super Float, Float> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final ClosedFloatingPointRange<Float> closedFloatingPointRange2, final MutableState<Float> mutableState, final float f, Composer composer, final int i) {
        float f4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-743965752);
        int i2 = (i & 14) == 0 ? (composerStartRestartGroup.changed(function1) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(closedFloatingPointRange) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(closedFloatingPointRange2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            f4 = f;
            i2 |= composerStartRestartGroup.changed(f4) ? 16384 : 8192;
        } else {
            f4 = f;
        }
        if ((i2 & 46811) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743965752, i, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:831)");
            }
            Object[] objArr = {closedFloatingPointRange, function1, Float.valueOf(f4), mutableState, closedFloatingPointRange2};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i4 = 0; i4 < 5; i4++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i4]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final float f5 = f4;
                objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        float fFloatValue = (closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue()) / 1000;
                        float fFloatValue2 = function1.invoke(Float.valueOf(f5)).floatValue();
                        if (Math.abs(fFloatValue2 - mutableState.getValue().floatValue()) <= fFloatValue || !closedFloatingPointRange2.contains(mutableState.getValue())) {
                            return;
                        }
                        mutableState.setValue(Float.valueOf(fFloatValue2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.CorrectValueSideEffect.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i5) {
                SliderKt.CorrectValueSideEffect(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f, composer2, i | 1);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x026a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(@NotNull final ClosedFloatingPointRange<Float> value, @NotNull final Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, @Nullable Modifier modifier, boolean z, @Nullable ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, @Nullable Function0<Unit> function0, @Nullable SliderColors sliderColors, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i7;
        int i8;
        int i9;
        Function0<Unit> function02;
        SliderColors sliderColors2;
        Composer composer2;
        int i10;
        SliderColors sliderColorsM16847colorsq0g_0yA;
        Modifier modifier3;
        boolean z3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        final boolean z4;
        final int i11;
        final Function0<Unit> function03;
        final SliderColors sliderColors3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1556183027);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        int i12 = i4 & 4;
        if (i12 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((57344 & i2) == 0) {
                    if ((i4 & 16) == 0) {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                        int i13 = composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                        i5 |= i13;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    }
                    i5 |= i13;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                i7 = i4 & 32;
                if (i7 == 0) {
                    if ((458752 & i2) == 0) {
                        i8 = i;
                        i5 |= composerStartRestartGroup.changed(i8) ? 131072 : 65536;
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        function02 = function0;
                    } else {
                        function02 = function0;
                        if ((i2 & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changed(function02) ? 1048576 : 524288;
                        }
                    }
                    if ((i2 & 29360128) != 0) {
                        if ((i4 & 128) == 0) {
                            sliderColors2 = sliderColors;
                            int i14 = composerStartRestartGroup.changed(sliderColors2) ? 8388608 : 4194304;
                            i5 |= i14;
                        } else {
                            sliderColors2 = sliderColors;
                        }
                        i5 |= i14;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    if ((i5 & 23967451) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            }
                            int i15 = i7 == 0 ? 0 : i8;
                            if (i9 != 0) {
                                function02 = null;
                            }
                            if ((i4 & 128) == 0) {
                                composer2 = composerStartRestartGroup;
                                i5 &= -29360129;
                                i10 = i15;
                                sliderColorsM16847colorsq0g_0yA = SliderDefaults.INSTANCE.m16847colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                composer2 = composerStartRestartGroup;
                                i10 = i15;
                                sliderColorsM16847colorsq0g_0yA = sliderColors2;
                            }
                            modifier3 = modifier2;
                            z3 = z2;
                            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                            }
                            if ((i4 & 128) != 0) {
                                i5 &= -29360129;
                            }
                            sliderColorsM16847colorsq0g_0yA = sliderColors2;
                            modifier3 = modifier2;
                            z3 = z2;
                            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                            i10 = i8;
                            composer2 = composerStartRestartGroup;
                        }
                        Function0<Unit> function04 = function02;
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1556183027, i5, -1, "androidx.compose.material.RangeSlider (Slider.kt:289)");
                        }
                        composer2.startReplaceableGroup(-492369756);
                        objRememberedValue = composer2.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                        composer2.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composer2.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                        if (i10 >= 0) {
                            throw new IllegalArgumentException("steps should be >= 0");
                        }
                        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onValueChange, composer2, (i5 >> 3) & 14);
                        Integer numValueOf = Integer.valueOf(i10);
                        composer2.startReplaceableGroup(1157296644);
                        boolean zChanged = composer2.changed(numValueOf);
                        Object objRememberedValue3 = composer2.rememberedValue();
                        if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = stepsToTickFractions(i10);
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        Modifier modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifier3);
                        float f = ThumbRadius;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m15895requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize, C2256Dp.m20968constructorimpl(4 * f), C2256Dp.m20968constructorimpl(f * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C15872(closedFloatingPointRange2, value, i5, stateRememberUpdatedState, mutableInteractionSource, mutableInteractionSource2, z3, i10, function04, (List) objRememberedValue3, sliderColorsM16847colorsq0g_0yA)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        z4 = z3;
                        i11 = i10;
                        function03 = function04;
                        sliderColors3 = sliderColorsM16847colorsq0g_0yA;
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        sliderColors3 = sliderColors2;
                        modifier4 = modifier2;
                        closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                        i11 = i8;
                        composer2 = composerStartRestartGroup;
                        function03 = function02;
                        z4 = z2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i16) {
                            SliderKt.RangeSlider(value, onValueChange, modifier4, z4, closedFloatingPointRange3, i11, function03, sliderColors3, composer3, i2 | 1, i4);
                        }
                    });
                    return;
                }
                i5 |= 196608;
                i8 = i;
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                if ((i2 & 29360128) != 0) {
                }
                if ((i5 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i4 & 16) != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i4 & 128) == 0) {
                        }
                        modifier3 = modifier2;
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        Function0<Unit> function042 = function02;
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2.startReplaceableGroup(-492369756);
                        objRememberedValue = composer2.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                        }
                        composer2.endReplaceableGroup();
                        MutableInteractionSource mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        composer2.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composer2.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                        }
                        composer2.endReplaceableGroup();
                        MutableInteractionSource mutableInteractionSource22 = (MutableInteractionSource) objRememberedValue2;
                        if (i10 >= 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((57344 & i2) == 0) {
            }
            i7 = i4 & 32;
            if (i7 == 0) {
            }
            i8 = i;
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            if ((i2 & 29360128) != 0) {
            }
            if ((i5 & 23967451) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        if ((57344 & i2) == 0) {
        }
        i7 = i4 & 32;
        if (i7 == 0) {
        }
        i8 = i;
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        if ((i2 & 29360128) != 0) {
        }
        if ((i5 & 23967451) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RangeSliderImpl(final boolean z, final float f, final float f4, final List<Float> list, final SliderColors sliderColors, final float f5, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Modifier modifier, final Modifier modifier2, final Modifier modifier3, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-278895713);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-278895713, i, i2, "androidx.compose.material.RangeSliderImpl (Slider.kt:615)");
        }
        Strings.Companion companion = Strings.INSTANCE;
        final String strM16870getString4foXLRw = Strings_androidKt.m16870getString4foXLRw(companion.m16869getSliderRangeStartUdPEhr4(), composerStartRestartGroup, 6);
        final String strM16870getString4foXLRw2 = Strings_androidKt.m16870getString4foXLRw(companion.m16868getSliderRangeEndUdPEhr4(), composerStartRestartGroup, 6);
        Modifier modifierThen = modifier.then(DefaultSliderConstraints);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierThen);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, 2044256857);
        float fMo15546toPx0680j_4 = density2.mo15546toPx0680j_4(TrackHeight);
        float f6 = ThumbRadius;
        float fMo15546toPx0680j_42 = density2.mo15546toPx0680j_4(f6);
        float fMo15542toDpu2uoSUM = density2.mo15542toDpu2uoSUM(f5);
        Unit unit = Unit.INSTANCE;
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(f6 * 2);
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(fMo15542toDpu2uoSUM * f);
        float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(fMo15542toDpu2uoSUM * f4);
        Modifier.Companion companion4 = Modifier.INSTANCE;
        int i4 = i >> 9;
        int i5 = i << 6;
        Track(SizeKt.fillMaxSize$default(boxScopeInstance.align(companion4, companion2.getCenterStart()), 0.0f, 1, null), sliderColors, z, f, f4, list, fMo15546toPx0680j_42, fMo15546toPx0680j_4, composerStartRestartGroup, (i4 & 112) | 262144 | (i5 & 896) | (i5 & 7168) | (i5 & 57344));
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(strM16870getString4foXLRw);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setContentDescription(semantics, strM16870getString4foXLRw);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        int i6 = i & 57344;
        int i7 = (i << 15) & 458752;
        m16848SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion4, true, (Function1) objRememberedValue), true, mutableInteractionSource).then(modifier2), fM20968constructorimpl2, mutableInteractionSource, sliderColors, z, fM20968constructorimpl, composerStartRestartGroup, (i4 & 7168) | 1572870 | i6 | i7);
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged2 = composerStartRestartGroup.changed(strM16870getString4foXLRw2);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setContentDescription(semantics, strM16870getString4foXLRw2);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        m16848SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion4, true, (Function1) objRememberedValue2), true, mutableInteractionSource2).then(modifier3), fM20968constructorimpl3, mutableInteractionSource2, sliderColors, z, fM20968constructorimpl, composerStartRestartGroup, ((i >> 12) & 7168) | 1572870 | i6 | i7);
        if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSliderImpl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i8) {
                SliderKt.RangeSliderImpl(z, f, f4, list, sliderColors, f5, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier3, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0119  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, @NotNull final Function1<? super Float, Unit> onValueChange, @Nullable Modifier modifier, boolean z, @Nullable ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, @Nullable Function0<Unit> function0, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable SliderColors sliderColors, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i7;
        int i8;
        int i9;
        Function0<Unit> function02;
        int i10;
        int i11;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        final int i12;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        SliderColors sliderColorsM16847colorsq0g_0yA;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        Function0<Unit> function03;
        int i13;
        boolean z3;
        Composer composer3;
        final Modifier modifier3;
        final boolean z4;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        final MutableInteractionSource mutableInteractionSource3;
        final SliderColors sliderColors2;
        final Function0<Unit> function04;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1962335196);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        int i14 = i4 & 4;
        if (i14 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((57344 & i2) == 0) {
                    if ((i4 & 16) == 0) {
                        closedFloatingPointRange2 = closedFloatingPointRange;
                        int i15 = composerStartRestartGroup.changed(closedFloatingPointRange2) ? 16384 : 8192;
                        i5 |= i15;
                    } else {
                        closedFloatingPointRange2 = closedFloatingPointRange;
                    }
                    i5 |= i15;
                } else {
                    closedFloatingPointRange2 = closedFloatingPointRange;
                }
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= 196608;
                } else {
                    if ((458752 & i2) == 0) {
                        i8 = i;
                        i5 |= composerStartRestartGroup.changed(i8) ? 131072 : 65536;
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        function02 = function0;
                    } else {
                        function02 = function0;
                        if ((i2 & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changed(function02) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 != 0) {
                        if ((i2 & 29360128) == 0) {
                            i11 = i10;
                            i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                        }
                        if ((i2 & 234881024) == 0) {
                            i5 |= ((i4 & 256) == 0 && composerStartRestartGroup.changed(sliderColors)) ? 67108864 : 33554432;
                        }
                        if ((i5 & 191739611) == 38347922 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            mutableInteractionSource3 = mutableInteractionSource;
                            composer3 = composerStartRestartGroup;
                            modifier3 = modifier2;
                            closedFloatingPointRange4 = closedFloatingPointRange2;
                            i12 = i8;
                            function04 = function02;
                            z4 = z2;
                            sliderColors2 = sliderColors;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if ((i4 & 16) == 0) {
                                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                    i5 &= -57345;
                                } else {
                                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                                }
                                i12 = i7 == 0 ? 0 : i8;
                                if (i9 != 0) {
                                    function02 = null;
                                }
                                if (i11 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                if ((i4 & 256) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    i5 &= -234881025;
                                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                                    sliderColorsM16847colorsq0g_0yA = SliderDefaults.INSTANCE.m16847colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    sliderColorsM16847colorsq0g_0yA = sliderColors;
                                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                                }
                                function03 = function02;
                                i13 = i5;
                                z3 = z2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 16) != 0) {
                                    i5 &= -57345;
                                }
                                if ((i4 & 256) != 0) {
                                    i5 &= -234881025;
                                }
                                mutableInteractionSource2 = mutableInteractionSource;
                                sliderColorsM16847colorsq0g_0yA = sliderColors;
                                function03 = function02;
                                z3 = z2;
                                closedFloatingPointRange3 = closedFloatingPointRange2;
                                i12 = i8;
                                composer2 = composerStartRestartGroup;
                                i13 = i5;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1962335196, i13, -1, "androidx.compose.material.Slider (Slider.kt:144)");
                            }
                            if (i12 >= 0) {
                                throw new IllegalArgumentException("steps should be >= 0");
                            }
                            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onValueChange, composer2, (i13 >> 3) & 14);
                            Integer numValueOf = Integer.valueOf(i12);
                            composer2.startReplaceableGroup(1157296644);
                            boolean zChanged = composer2.changed(numValueOf);
                            Object objRememberedValue2 = composer2.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = stepsToTickFractions(i12);
                                composer2.updateRememberedValue(objRememberedValue2);
                            }
                            composer2.endReplaceableGroup();
                            List list = (List) objRememberedValue2;
                            Modifier modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifier2);
                            float f4 = ThumbRadius;
                            float f5 = 2;
                            boolean z5 = z3;
                            Composer composer4 = composer2;
                            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m15895requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize, C2256Dp.m20968constructorimpl(f4 * f5), C2256Dp.m20968constructorimpl(f4 * f5), 0.0f, 0.0f, 12, null), f, z5, onValueChange, function03, closedFloatingPointRange3, i12), z5, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composer4, 2085116814, true, new C15913(closedFloatingPointRange3, i13, f, mutableInteractionSource4, z5, list, sliderColorsM16847colorsq0g_0yA, stateRememberUpdatedState, function03)), composer4, 3072, 6);
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            z4 = z5;
                            closedFloatingPointRange4 = closedFloatingPointRange3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            sliderColors2 = sliderColorsM16847colorsq0g_0yA;
                            function04 = function03;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer5, int i16) {
                                SliderKt.Slider(f, onValueChange, modifier3, z4, closedFloatingPointRange4, i12, function04, mutableInteractionSource3, sliderColors2, composer5, i2 | 1, i4);
                            }
                        });
                        return;
                    }
                    i5 |= 12582912;
                    i11 = i10;
                    if ((i2 & 234881024) == 0) {
                    }
                    if ((i5 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i14 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i4 & 16) == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i11 == 0) {
                            }
                            if ((i4 & 256) == 0) {
                            }
                            function03 = function02;
                            i13 = i5;
                            z3 = z2;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (i12 >= 0) {
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i;
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 != 0) {
                }
                i11 = i10;
                if ((i2 & 234881024) == 0) {
                }
                if ((i5 & 191739611) == 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((57344 & i2) == 0) {
            }
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            i8 = i;
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 != 0) {
            }
            i11 = i10;
            if ((i2 & 234881024) == 0) {
            }
            if ((i5 & 191739611) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        if ((57344 & i2) == 0) {
        }
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        i8 = i;
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 != 0) {
        }
        i11 = i10;
        if ((i2 & 234881024) == 0) {
        }
        if ((i5 & 191739611) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SliderImpl(final boolean z, final float f, final List<Float> list, final SliderColors sliderColors, final float f4, final MutableInteractionSource mutableInteractionSource, final Modifier modifier, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1679682785);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1679682785, i, -1, "androidx.compose.material.SliderImpl (Slider.kt:578)");
        }
        Modifier modifierThen = modifier.then(DefaultSliderConstraints);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierThen);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, 231316251);
        float fMo15546toPx0680j_4 = density2.mo15546toPx0680j_4(TrackHeight);
        float f5 = ThumbRadius;
        float fMo15546toPx0680j_42 = density2.mo15546toPx0680j_4(f5);
        float fMo15542toDpu2uoSUM = density2.mo15542toDpu2uoSUM(f4);
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(f5 * 2);
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(fMo15542toDpu2uoSUM * f);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        int i2 = i >> 6;
        Track(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), sliderColors, z, 0.0f, f, list, fMo15546toPx0680j_42, fMo15546toPx0680j_4, composerStartRestartGroup, (i2 & 112) | 265222 | ((i << 6) & 896) | ((i << 9) & 57344));
        m16848SliderThumbPcYyNuk(boxScopeInstance, companion2, fM20968constructorimpl2, mutableInteractionSource, sliderColors, z, fM20968constructorimpl, composerStartRestartGroup, (i2 & 7168) | 1572918 | ((i << 3) & 57344) | ((i << 15) & 458752));
        if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.SliderImpl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                SliderKt.SliderImpl(z, f, list, sliderColors, f4, mutableInteractionSource, modifier, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    public static final void m16848SliderThumbPcYyNuk(final BoxScope boxScope, final Modifier modifier, final float f, final MutableInteractionSource mutableInteractionSource, final SliderColors sliderColors, final boolean z, final float f4, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(428907178);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
        }
        if ((2995931 & i2) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(428907178, i2, -1, "androidx.compose.material.SliderThumb (Slider.kt:683)");
            }
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, f, 0.0f, 0.0f, 0.0f, 14, null);
            Alignment.Companion companion = Alignment.INSTANCE;
            Modifier modifierAlign = boxScope.align(modifierM15858paddingqDBjuR0$default, companion.getCenterStart());
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composerStartRestartGroup, 0, -1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierAlign);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-587645648);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i4 = i2 >> 9;
            int i5 = i4 & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new SliderKt$SliderThumb$1$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, i5 | 64);
            SpacerKt.Spacer(BackgroundKt.m15408backgroundbw27NRU(ShadowKt.m18189shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m15901sizeVpY3zN4(modifier, f4, f4), mutableInteractionSource, RippleKt.m16977rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null), z ? !snapshotStateList.isEmpty() ? ThumbPressedElevation : ThumbDefaultElevation : C2256Dp.m20968constructorimpl(0), RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), sliderColors.thumbColor(z, composerStartRestartGroup, ((i2 >> 15) & 14) | (i4 & 112)).getValue().m18535unboximpl(), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderThumb$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i6) {
                SliderKt.m16848SliderThumbPcYyNuk(boxScope, modifier, f, mutableInteractionSource, sliderColors, z, f4, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Track(final Modifier modifier, final SliderColors sliderColors, final boolean z, final float f, final float f4, final List<Float> list, final float f5, final float f6, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1833126050);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1833126050, i, -1, "androidx.compose.material.Track (Slider.kt:729)");
        }
        int i2 = ((i >> 6) & 14) | 48 | ((i << 3) & 896);
        final State<Color> stateTrackColor = sliderColors.trackColor(z, false, composerStartRestartGroup, i2);
        final State<Color> stateTrackColor2 = sliderColors.trackColor(z, true, composerStartRestartGroup, i2);
        final State<Color> stateTickColor = sliderColors.tickColor(z, false, composerStartRestartGroup, i2);
        final State<Color> stateTickColor2 = sliderColors.tickColor(z, true, composerStartRestartGroup, i2);
        CanvasKt.Canvas(modifier, new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SliderKt.Track.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DrawScope Canvas) {
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                boolean z2 = Canvas.getLayoutDirection() == LayoutDirection.Rtl;
                long jOffset = OffsetKt.Offset(f5, Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()));
                long jOffset2 = OffsetKt.Offset(Size.m18353getWidthimpl(Canvas.mo19076getSizeNHjbRc()) - f5, Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()));
                long j = jOffset2;
                if (!z2) {
                    jOffset2 = jOffset;
                }
                if (z2) {
                    j = jOffset;
                }
                long jM18535unboximpl = stateTrackColor.getValue().m18535unboximpl();
                float f7 = f6;
                StrokeCap.Companion companion = StrokeCap.INSTANCE;
                DrawScope.m19062drawLineNGM6Ib0$default(Canvas, jM18535unboximpl, jOffset2, j, f7, companion.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                long j2 = j;
                long j3 = jOffset2;
                DrawScope.m19062drawLineNGM6Ib0$default(Canvas, stateTrackColor2.getValue().m18535unboximpl(), OffsetKt.Offset(((Offset.m18284getXimpl(j) - Offset.m18284getXimpl(jOffset2)) * f) + Offset.m18284getXimpl(jOffset2), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0())), OffsetKt.Offset(((Offset.m18284getXimpl(j) - Offset.m18284getXimpl(jOffset2)) * f4) + Offset.m18284getXimpl(jOffset2), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0())), f6, companion.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                List<Float> list2 = list;
                float f8 = f4;
                float f9 = f;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : list2) {
                    float fFloatValue = ((Number) obj).floatValue();
                    Boolean boolValueOf = Boolean.valueOf(fFloatValue > f8 || fFloatValue < f9);
                    Object arrayList = linkedHashMap.get(boolValueOf);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(boolValueOf, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                State<Color> state = stateTickColor;
                State<Color> state2 = stateTickColor2;
                float f10 = f6;
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
                    List list3 = (List) entry.getValue();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(list3));
                    Iterator it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(Offset.m18273boximpl(OffsetKt.Offset(Offset.m18284getXimpl(OffsetKt.m18307lerpWko1d7g(j3, j2, ((Number) it.next()).floatValue())), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()))));
                    }
                    long j5 = j3;
                    j2 = j2;
                    DrawScope.m19067drawPointsF8ZwMP8$default(Canvas, arrayList2, PointMode.INSTANCE.m18831getPointsr_lszbg(), (zBooleanValue ? state : state2).getValue().m18535unboximpl(), f10, StrokeCap.INSTANCE.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                    j3 = j5;
                }
            }
        }, composerStartRestartGroup, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Track.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                SliderKt.Track(modifier, sliderColors, z, f, f4, list, f5, f6, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float f, float f4, float f5, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(draggableState, null, new C15982(f, f4, f5, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m16851awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        Ref.FloatRef floatRef;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            int i2 = sliderKt$awaitSlop$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label = i2 - Integer.MIN_VALUE;
            } else {
                sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
            }
        }
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$12 = sliderKt$awaitSlop$1;
        Object obj = sliderKt$awaitSlop$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = sliderKt$awaitSlop$12.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Function2<PointerInputChange, Float, Unit> function2 = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                    invoke(pointerInputChange, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull PointerInputChange pointerInput, float f) {
                    Intrinsics.checkNotNullParameter(pointerInput, "pointerInput");
                    pointerInput.consume();
                    floatRef2.element = f;
                }
            };
            sliderKt$awaitSlop$12.L$0 = floatRef2;
            sliderKt$awaitSlop$12.label = 1;
            Object objM16717awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m16717awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, function2, sliderKt$awaitSlop$12);
            if (objM16717awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objM16717awaitHorizontalPointerSlopOrCancellationgDDlDlE;
            floatRef = floatRef2;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) sliderKt$awaitSlop$12.L$0;
            ResultKt.throwOnFailure(obj);
        }
        PointerInputChange pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange != null) {
            return TuplesKt.m13893to(pointerInputChange, Boxing.boxFloat(floatRef.element));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float f, float f4, float f5) {
        float f6 = f4 - f;
        return RangesKt.coerceIn(f6 == 0.0f ? 0.0f : (f5 - f) / f6, 0.0f, 1.0f);
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier modifier, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, boolean z, boolean z2, float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, State<? extends Function1<? super Boolean, Unit>> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f), Boolean.valueOf(z2), closedFloatingPointRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C15991(mutableInteractionSource, mutableInteractionSource2, state, state2, state4, z2, f, state3, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float f, float f4, float f5, float f6, float f7) {
        return MathHelpersKt.lerp(f6, f7, calcFraction(f, f4, f5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier modifier, float f, final boolean z, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int i) {
        final float fCoerceIn = RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt.sliderSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                if (!z) {
                    SemanticsPropertiesKt.disabled(semantics);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                final int i2 = i;
                final float f4 = fCoerceIn;
                final Function1<Float, Unit> function12 = function1;
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.setProgress$default(semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material.SliderKt.sliderSemantics.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f5) {
                        return invoke(f5.floatValue());
                    }

                    @NotNull
                    public final Boolean invoke(float f5) {
                        int i4;
                        float fCoerceIn2 = RangesKt.coerceIn(f5, closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue());
                        int i5 = i2;
                        boolean z2 = false;
                        if (i5 > 0 && (i4 = i5 + 1) >= 0) {
                            float fAbs = fCoerceIn2;
                            float f6 = fAbs;
                            int i6 = 0;
                            while (true) {
                                float fLerp = MathHelpersKt.lerp(closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue(), i6 / (i2 + 1));
                                float f7 = fLerp - fCoerceIn2;
                                if (Math.abs(f7) <= fAbs) {
                                    fAbs = Math.abs(f7);
                                    f6 = fLerp;
                                }
                                if (i6 == i4) {
                                    break;
                                }
                                i6++;
                            }
                            fCoerceIn2 = f6;
                        }
                        if (fCoerceIn2 != f4) {
                            function12.invoke(Float.valueOf(fCoerceIn2));
                            Function0<Unit> function03 = function02;
                            if (function03 != null) {
                                function03.invoke();
                            }
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    }
                }, 1, null);
            }
        }, 1, null), f, closedFloatingPointRange, i);
    }

    public static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f, boolean z, Function1 function1, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function0 = null;
        }
        Function0 function02 = function0;
        if ((i2 & 16) != 0) {
            closedFloatingPointRange = RangesKt.rangeTo(0.0f, 1.0f);
        }
        ClosedFloatingPointRange closedFloatingPointRange2 = closedFloatingPointRange;
        if ((i2 & 32) != 0) {
            i = 0;
        }
        return sliderSemantics(modifier, f, z, function1, function02, closedFloatingPointRange2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderTapModifier(Modifier modifier, final DraggableState draggableState, final MutableInteractionSource mutableInteractionSource, final float f, final boolean z, final State<Float> state, final State<? extends Function1<? super Float, Unit>> state2, final MutableState<Float> mutableState, final boolean z2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("sliderTapModifier");
                inspectorInfo.getProperties().set("draggableState", draggableState);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("maxPx", Float.valueOf(f));
                AbstractC0622a.m1163i(z, inspectorInfo.getProperties(), "isRtl", inspectorInfo).set("rawOffset", state);
                inspectorInfo.getProperties().set("gestureEndAction", state2);
                inspectorInfo.getProperties().set("pressOffset", mutableState);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SliderKt.sliderTapModifier.2

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {909}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DraggableState $draggableState;
                final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ MutableState<Float> $pressOffset;
                final /* synthetic */ State<Float> $rawOffset;
                final /* synthetic */ CoroutineScope $scope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {914}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class C145521 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ float $maxPx;
                    final /* synthetic */ MutableState<Float> $pressOffset;
                    final /* synthetic */ State<Float> $rawOffset;
                    /* synthetic */ long J$0;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C145521(boolean z, float f, MutableState<Float> mutableState, State<Float> state, Continuation<? super C145521> continuation) {
                        super(3, continuation);
                        this.$isRtl = z;
                        this.$maxPx = f;
                        this.$pressOffset = mutableState;
                        this.$rawOffset = state;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                        return m16852invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
                    }

                    @Nullable
                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                    public final Object m16852invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j, @Nullable Continuation<? super Unit> continuation) {
                        C145521 c145521 = new C145521(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, continuation);
                        c145521.L$0 = pressGestureScope;
                        c145521.J$0 = j;
                        return c145521.invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                long j = this.J$0;
                                this.$pressOffset.setValue(Boxing.boxFloat((this.$isRtl ? this.$maxPx - Offset.m18284getXimpl(j) : Offset.m18284getXimpl(j)) - this.$rawOffset.getValue().floatValue()));
                                this.label = 1;
                                if (pressGestureScope.awaitRelease(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        } catch (GestureCancellationException unused) {
                            this.$pressOffset.setValue(Boxing.boxFloat(0.0f));
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(boolean z, float f, MutableState<Float> mutableState, State<Float> state, CoroutineScope coroutineScope, DraggableState draggableState, State<? extends Function1<? super Float, Unit>> state2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$pressOffset = mutableState;
                    this.$rawOffset = state;
                    this.$scope = coroutineScope;
                    this.$draggableState = draggableState;
                    this.$gestureEndAction = state2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, this.$scope, this.$draggableState, this.$gestureEndAction, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                        C145521 c145521 = new C145521(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
                        final CoroutineScope coroutineScope = this.$scope;
                        final DraggableState draggableState = this.$draggableState;
                        final State<Function1<Float, Unit>> state = this.$gestureEndAction;
                        Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material.SliderKt.sliderTapModifier.2.1.2

                            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                            @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {921}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                            public static final class C145531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DraggableState $draggableState;
                                final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
                                int label;

                                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                @DebugMetadata(m14020c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                public static final class C145541 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    public C145541(Continuation<? super C145541> continuation) {
                                        super(2, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @NotNull
                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                        C145541 c145541 = new C145541(continuation);
                                        c145541.L$0 = obj;
                                        return c145541;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    @Nullable
                                    public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
                                        return ((C145541) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @Nullable
                                    public final Object invokeSuspend(@NotNull Object obj) {
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        if (this.label != 0) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                        ((DragScope) this.L$0).dragBy(0.0f);
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                public C145531(DraggableState draggableState, State<? extends Function1<? super Float, Unit>> state, Continuation<? super C145531> continuation) {
                                    super(2, continuation);
                                    this.$draggableState = draggableState;
                                    this.$gestureEndAction = state;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    return new C145531(this.$draggableState, this.$gestureEndAction, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        DraggableState draggableState = this.$draggableState;
                                        MutatePriority mutatePriority = MutatePriority.UserInput;
                                        C145541 c145541 = new C145541(null);
                                        this.label = 1;
                                        if (draggableState.drag(mutatePriority, c145541, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    this.$gestureEndAction.getValue().invoke(Boxing.boxFloat(0.0f));
                                    return Unit.INSTANCE;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                @Nullable
                                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                    return ((C145531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                m16853invokek4lQ0M(offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                            public final void m16853invokek4lQ0M(long j) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C145531(draggableState, state, null), 3, null);
                            }
                        };
                        this.label = 1;
                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, c145521, function1, this, 3, null) == coroutine_suspended) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(1945228890);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1945228890, i, -1, "androidx.compose.material.sliderTapModifier.<anonymous> (Slider.kt:904)");
                }
                if (z2) {
                    composer.startReplaceableGroup(773894976);
                    composer.startReplaceableGroup(-492369756);
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer), composer);
                    }
                    composer.endReplaceableGroup();
                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composer.endReplaceableGroup();
                    composed = SuspendingPointerInputFilterKt.pointerInput(composed, new Object[]{draggableState, mutableInteractionSource, Float.valueOf(f), Boolean.valueOf(z)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(z, f, mutableState, state, coroutineScope, draggableState, state2, null));
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return composed;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float snapValueToTick(float f, List<Float> list, float f4, float f5) {
        Object obj;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                float fAbs = Math.abs(MathHelpersKt.lerp(f4, f5, ((Number) next).floatValue()) - f);
                do {
                    Object next2 = it.next();
                    float fAbs2 = Math.abs(MathHelpersKt.lerp(f4, f5, ((Number) next2).floatValue()) - f);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Float f6 = (Float) obj;
        return f6 != null ? MathHelpersKt.lerp(f4, f5, f6.floatValue()) : f;
    }

    private static final List<Float> stepsToTickFractions(int i) {
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int i2 = i + 2;
        ArrayList arrayList = new ArrayList(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            arrayList.add(Float.valueOf(i4 / (i + 1)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float f, float f4, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f5, float f6) {
        return RangesKt.rangeTo(scale(f, f4, closedFloatingPointRange.getStart().floatValue(), f5, f6), scale(f, f4, closedFloatingPointRange.getEndInclusive().floatValue(), f5, f6));
    }
}
