package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
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
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
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
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
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
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.sdk.pen.engine.pointericon.SpenHoverPointerIcon;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
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
@Metadata(m13885d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u007f\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001ae\u0010&\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00101\u001a±\u0001\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b52\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u00020-2\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5H\u0007¢\u0006\u0002\u00108\u001a}\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u00020-H\u0007¢\u0006\u0002\u00109\u001a\u0096\u0001\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u00020-2\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5H\u0007¢\u0006\u0002\u0010:\u001a\u0099\u0001\u0010;\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00106\u001a\u00020-2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b52\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5H\u0003¢\u0006\u0002\u0010<\u001aU\u0010=\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\bH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a1\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010H\u001a \u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\bH\u0002\u001a0\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a<\u0010M\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a(\u0010T\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002\u001a\u0010\u0010W\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a?\u0010X\u001a\u00020\u0016*\u00020Y2\u0006\u0010Z\u001a\u00020\u00032\u001c\u0010[\u001a\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5¢\u0006\u0002\b\\H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a;\u0010_\u001a\u0010\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020\b\u0018\u00010`*\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH\u0082@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bg\u0010h\u001a\u0098\u0001\u0010i\u001a\u00020\u0001*\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\b0k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\b0k2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010m\u001a\u00020\u001d2\u0006\u0010V\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00160\u001a0k2\u001e\u0010o\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160p0kH\u0002\u001a\\\u0010q\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002\u001ad\u0010r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u00106\u001a\u00020-2\u0006\u0010V\u001a\u00020 2\u0006\u0010m\u001a\u00020\u001d2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\b0k2\u0012\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\"0k2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0u2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\f\u001a\u00020\rX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000e\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011\"\u0013\u0010\u0012\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0013\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0014\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006v"}, m13886d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbHeight", "ThumbPressedElevation", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "RangeSlider", "", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "onValueChange", "Lkotlin/Function1;", "modifier", "enabled", "", "valueRange", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFF[FLandroidx/compose/material3/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "track", "Landroidx/compose/material3/SliderPositions;", "Landroidx/compose/runtime/Composable;", "interactionSource", "thumb", "(FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;IFLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "TempRangeSliderTrack", "thumbWidth", "trackStrokeWidth", "TempRangeSliderTrack-au3_HiA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZFF[FFFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", WiggleAnimationConfig.KEY_SCALE, SAConstants.DETAIL_DEFAULT_IMAGE_BLANK, SAConstants.DETAIL_DEFAULT_PDF_NOTEBOOK, "x1", SAConstants.DETAIL_DEFAULT_IMAGE_LINED, SAConstants.DETAIL_DEFAULT_PDF_PLANNER_1, "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "TempRangeSliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", TypedValues.Cycle.S_WAVE_OFFSET, "content", "Lkotlin/ExtensionFunctionType;", "TempRangeSliderThumb-rAjV9yQ", "(Landroidx/compose/foundation/layout/BoxScope;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "Landroidx/compose/runtime/MutableState;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SliderKt {

    @NotNull
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;

    @NotNull
    private static final TweenSpec<Float> SliderToTickAnimation;
    private static final float ThumbDefaultElevation;
    private static final float ThumbHeight;
    private static final float ThumbPressedElevation;
    private static final long ThumbSize;
    private static final float ThumbWidth;
    private static final float TickSize;
    private static final float TrackHeight;

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$RangeSlider$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class C18492 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ int $steps;
        final /* synthetic */ float[] $tickFractions;
        final /* synthetic */ ClosedFloatingPointRange<Float> $value;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C18492(Function0<Unit> function0, int i, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, float[] fArr, SliderColors sliderColors) {
            super(3);
            this.$onValueChangeFinished = function0;
            this.$$dirty = i;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$enabled = z;
            this.$valueRange = closedFloatingPointRange;
            this.$value = closedFloatingPointRange2;
            this.$steps = i2;
            this.$onValueChangeState = state;
            this.$tickFractions = fArr;
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
            int i2;
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
                ComposerKt.traceEventStart(-990606702, i, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:412)");
            }
            boolean z = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            float fM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            float f = 2;
            floatRef.element = fM20921getMaxWidthimpl - (density.mo15546toPx0680j_4(SliderKt.getThumbWidth()) / f);
            floatRef2.element = density.mo15546toPx0680j_4(SliderKt.getThumbWidth()) / f;
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
            final Function0<Unit> function0 = this.$onValueChangeFinished;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2$gestureEndAction$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2) {
                        Function0<Unit> function02 = function0;
                        if (function02 != null) {
                            function02.invoke();
                        }
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(objRememberedValue3, composer, 0);
            final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = this.$value;
            final float[] fArr = this.$tickFractions;
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange6 = this.$valueRange;
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(new Function2<Boolean, Float, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2$onDrag$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Float f4) {
                    invoke(bool.booleanValue(), f4.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z2, float f4) {
                    ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
                    if (z2) {
                        MutableState<Float> mutableState3 = mutableState;
                        mutableState3.setValue(Float.valueOf(mutableState3.getValue().floatValue() + f4));
                        mutableState2.setValue(Float.valueOf(SliderKt.C18492.invoke$scaleToOffset(closedFloatingPointRange6, floatRef2, floatRef, closedFloatingPointRange5.getEndInclusive().floatValue())));
                        float fFloatValue = mutableState2.getValue().floatValue();
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(SliderKt.snapValueToTick(RangesKt.coerceIn(mutableState.getValue().floatValue(), floatRef2.element, fFloatValue), fArr, floatRef2.element, floatRef.element), fFloatValue);
                    } else {
                        MutableState<Float> mutableState4 = mutableState2;
                        mutableState4.setValue(Float.valueOf(mutableState4.getValue().floatValue() + f4));
                        mutableState.setValue(Float.valueOf(SliderKt.C18492.invoke$scaleToOffset(closedFloatingPointRange6, floatRef2, floatRef, closedFloatingPointRange5.getStart().floatValue())));
                        float fFloatValue2 = mutableState.getValue().floatValue();
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(fFloatValue2, SliderKt.snapValueToTick(RangesKt.coerceIn(mutableState2.getValue().floatValue(), fFloatValue2, floatRef.element), fArr, floatRef2.element, floatRef.element));
                    }
                    state.getValue().invoke(SliderKt.C18492.invoke$scaleToUserValue(floatRef2, floatRef, closedFloatingPointRange6, closedFloatingPointRangeRangeTo));
                }
            }, composer, 0);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierRangeSliderPressDragModifier = SliderKt.rangeSliderPressDragModifier(companion2, this.$startInteractionSource, this.$endInteractionSource, mutableState, mutableState2, this.$enabled, z, fM20921getMaxWidthimpl, this.$valueRange, stateRememberUpdatedState, stateRememberUpdatedState2);
            final float fCoerceIn = RangesKt.coerceIn(this.$value.getStart().floatValue(), this.$valueRange.getStart().floatValue(), this.$value.getEndInclusive().floatValue());
            final float fCoerceIn2 = RangesKt.coerceIn(this.$value.getEndInclusive().floatValue(), this.$value.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
            float fCalcFraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), fCoerceIn);
            float fCalcFraction2 = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), fCoerceIn2);
            int iFloor = (int) Math.floor(this.$steps * fCalcFraction2);
            int iFloor2 = (int) Math.floor((1.0f - fCalcFraction) * this.$steps);
            boolean z2 = this.$enabled;
            Object obj = this.$onValueChangeState;
            Object objValueOf = Float.valueOf(fCoerceIn2);
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state2 = this.$onValueChangeState;
            composer.startReplaceableGroup(511388516);
            boolean zChanged2 = composer.changed(obj) | composer.changed(objValueOf);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1<Float, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2$startThumbSemantics$1$1
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
                        state2.getValue().invoke(RangesKt.rangeTo(f4, fCoerceIn2));
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            Modifier modifierSliderSemantics = SliderKt.sliderSemantics(companion2, fCoerceIn, z2, (Function1) objRememberedValue4, this.$onValueChangeFinished, RangesKt.rangeTo(this.$valueRange.getStart().floatValue(), fCoerceIn2), iFloor);
            boolean z3 = this.$enabled;
            Object obj2 = this.$onValueChangeState;
            Object objValueOf2 = Float.valueOf(fCoerceIn);
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state3 = this.$onValueChangeState;
            composer.startReplaceableGroup(511388516);
            boolean zChanged3 = composer.changed(obj2) | composer.changed(objValueOf2);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function1<Float, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2$endThumbSemantics$1$1
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
                        state3.getValue().invoke(RangesKt.rangeTo(fCoerceIn, f4));
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierSliderSemantics2 = SliderKt.sliderSemantics(companion2, fCoerceIn2, z3, (Function1) objRememberedValue5, this.$onValueChangeFinished, RangesKt.rangeTo(fCoerceIn, this.$valueRange.getEndInclusive().floatValue()), iFloor2);
            boolean z4 = this.$enabled;
            float[] fArr2 = this.$tickFractions;
            SliderColors sliderColors = this.$colors;
            float f4 = floatRef.element - floatRef2.element;
            MutableInteractionSource mutableInteractionSource = this.$startInteractionSource;
            MutableInteractionSource mutableInteractionSource2 = this.$endInteractionSource;
            int i4 = this.$$dirty;
            SliderKt.RangeSliderImpl(z4, fCalcFraction, fCalcFraction2, fArr2, sliderColors, f4, mutableInteractionSource, mutableInteractionSource2, modifierRangeSliderPressDragModifier, modifierSliderSemantics, modifierSliderSemantics2, composer, ((i4 >> 9) & 57344) | ((i4 >> 9) & 14) | 14159872, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$animateToTarget$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$animateToTarget$2", m14021f = "Slider.kt", m14022i = {}, m14023l = {1174}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C18572 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18572(float f, float f4, float f5, Continuation<? super C18572> continuation) {
            super(2, continuation);
            this.$current = f;
            this.$target = f4;
            this.$velocity = f5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C18572 c18572 = new C18572(this.$current, this.$target, this.$velocity, continuation);
            c18572.L$0 = obj;
            return c18572;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C18572) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.SliderKt.animateToTarget.2.1
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

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {SpenHoverPointerIcon.HOVER_POINTER_ICON_TYPE_ENGINE_COLOR_PICKER_}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C18581 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
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

        /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {SpenHoverPointerIcon.HOVER_POINTER_ICON_TYPE_ENGINE_CHANGE_STYLE}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
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

            /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {SpenHoverPointerIcon.HOVER_POINTER_ICON_TYPE_ENGINE_CUTTER}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C145581 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
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

                /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$1", m14021f = "Slider.kt", m14022i = {0, 1, 1, 1, 1, 1, 2, 2}, m14023l = {SpenHoverPointerIcon.HOVER_POINTER_ICON_TYPE_ENGINE_FILL_COLOR, 1215, 1234}, m14024m = "invokeSuspend", m14025n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "event", "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, m14026s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
                public static final class C145591 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
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

                    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                    @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2", m14021f = "Slider.kt", m14022i = {}, m14023l = {1251}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
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
                    public C145591(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C145591> continuation) {
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
                        C145591 c145591 = new C145591(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                        c145591.L$0 = obj;
                        return c145591;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((C145591) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        Object objM17291awaitSlop8vUncbI;
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
                            objM17291awaitSlop8vUncbI = obj;
                            pair = (Pair) objM17291awaitSlop8vUncbI;
                            if (pair != null) {
                                State<Float> state = this.$rawOffsetEnd;
                                State<Float> state2 = this.$rawOffsetStart;
                                boolean z = this.$isRtl;
                                float fM17138pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m17138pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), pointerInputChange.getType());
                                if (Math.abs(state.getValue().floatValue() - floatRef.element) < fM17138pointerSlopE8SPZFQ && Math.abs(state2.getValue().floatValue() - floatRef.element) < fM17138pointerSlopE8SPZFQ) {
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
                                Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1
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
                        objM17291awaitSlop8vUncbI = SliderKt.m17291awaitSlop8vUncbI(awaitPointerEventScope4, id2, type, this);
                        if (objM17291awaitSlop8vUncbI != coroutine_suspended) {
                            awaitPointerEventScope2 = awaitPointerEventScope4;
                            pointerInputChange = pointerInputChange3;
                            floatRef = floatRef3;
                            start = start3;
                            booleanRef = booleanRef3;
                            pair = (Pair) objM17291awaitSlop8vUncbI;
                            if (pair != null) {
                            }
                            this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                            long id3 = pointerInputChange.getId();
                            final State<? extends Function2<? super Boolean, ? super Float, Unit>> state32 = this.$onDrag;
                            final boolean z22 = this.$isRtl;
                            Function1<PointerInputChange, Unit> function12 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1
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
                public C145581(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C145581> continuation) {
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
                    C145581 c145581 = new C145581(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                    c145581.L$0 = obj;
                    return c145581;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C145581) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                        C145591 c145591 = new C145591(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                        this.label = 1;
                        if (pointerInputScope.awaitPointerEventScope(c145591, this) == coroutine_suspended) {
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
                    C145581 c145581 = new C145581(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                    this.label = 1;
                    if (ForEachGestureKt.forEachGesture(pointerInputScope, c145581, this) == coroutine_suspended) {
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
        public C18581(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, State<? extends Function2<? super Boolean, ? super Float, Unit>> state3, boolean z, float f, State<? extends Function1<? super Boolean, Unit>> state4, Continuation<? super C18581> continuation) {
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
            C18581 c18581 = new C18581(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag, this.$isRtl, this.$maxPx, this.$gestureEndAction, continuation);
            c18581.L$0 = obj;
            return c18581;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C18581) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        SliderTokens sliderTokens = SliderTokens.INSTANCE;
        float fM17879getHandleWidthD9Ej5fM = sliderTokens.m17879getHandleWidthD9Ej5fM();
        ThumbWidth = fM17879getHandleWidthD9Ej5fM;
        float fM17878getHandleHeightD9Ej5fM = sliderTokens.m17878getHandleHeightD9Ej5fM();
        ThumbHeight = fM17878getHandleHeightD9Ej5fM;
        ThumbSize = DpKt.m20990DpSizeYgX7TsA(fM17879getHandleWidthD9Ej5fM, fM17878getHandleHeightD9Ej5fM);
        ThumbDefaultElevation = C2256Dp.m20968constructorimpl(1);
        ThumbPressedElevation = C2256Dp.m20968constructorimpl(6);
        TickSize = sliderTokens.m17885getTickMarksContainerSizeD9Ej5fM();
        TrackHeight = sliderTokens.m17880getInactiveTrackHeightD9Ej5fM();
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(48);
        SliderHeight = fM20968constructorimpl;
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(144);
        SliderMinWidth = fM20968constructorimpl2;
        DefaultSliderConstraints = SizeKt.m15887heightInVpY3zN4$default(SizeKt.m15906widthInVpY3zN4$default(Modifier.INSTANCE, fM20968constructorimpl2, 0.0f, 2, null), 0.0f, fM20968constructorimpl, 1, null);
        SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0117  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterial3Api
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
        Composer composer2;
        Composer composer3;
        Function0<Unit> function03;
        Modifier modifier3;
        boolean z3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i10;
        SliderColors sliderColorsM17285colorsq0g_0yA;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        final Function0<Unit> function04;
        final boolean z4;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        final int i11;
        final SliderColors sliderColors2;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-743091416);
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
                    if ((i2 & 29360128) == 0) {
                        i5 |= ((i4 & 128) == 0 && composerStartRestartGroup.changed(sliderColors)) ? 8388608 : 4194304;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i5 & 23967451) == 4793490 || !composer2.getSkipping()) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0 || composer2.getDefaultsInvalid()) {
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
                            if (i7 != 0) {
                                i8 = 0;
                            }
                            Function0<Unit> function05 = i9 == 0 ? null : function02;
                            if ((i4 & 128) == 0) {
                                composer3 = composer2;
                                i5 &= -29360129;
                                function03 = function05;
                                modifier3 = modifier2;
                                z3 = z2;
                                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                                i10 = i8;
                                sliderColorsM17285colorsq0g_0yA = SliderDefaults.INSTANCE.m17285colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 6, 1023);
                                composer3.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-743091416, i5, -1, "androidx.compose.material3.RangeSlider (Slider.kt:384)");
                                }
                                composer3.startReplaceableGroup(-492369756);
                                objRememberedValue = composer3.rememberedValue();
                                companion = Composer.INSTANCE;
                                if (objRememberedValue == companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                composer3.endReplaceableGroup();
                                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                                composer3.startReplaceableGroup(-492369756);
                                objRememberedValue2 = composer3.rememberedValue();
                                if (objRememberedValue2 == companion.getEmpty()) {
                                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                                if (i10 >= 0) {
                                    throw new IllegalArgumentException("steps should be >= 0");
                                }
                                composer3.startReplaceableGroup(511388516);
                                boolean zChanged = composer3.changed(value) | composer3.changed(onValueChange);
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                                    objRememberedValue3 = new Function1<ClosedFloatingPointRange<Float>, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$onValueChangeState$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ClosedFloatingPointRange<Float> closedFloatingPointRange4) {
                                            invoke2(closedFloatingPointRange4);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull ClosedFloatingPointRange<Float> it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            if (Intrinsics.areEqual(it, value)) {
                                                return;
                                            }
                                            onValueChange.invoke(it);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                composer3.endReplaceableGroup();
                                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(objRememberedValue3, composer3, 0);
                                Integer numValueOf = Integer.valueOf(i10);
                                composer3.startReplaceableGroup(1157296644);
                                boolean zChanged2 = composer3.changed(numValueOf);
                                Object objRememberedValue4 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                                    objRememberedValue4 = stepsToTickFractions(i10);
                                    composer3.updateRememberedValue(objRememberedValue4);
                                }
                                composer3.endReplaceableGroup();
                                float f = 2;
                                Composer composer4 = composer3;
                                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m15895requiredSizeInqDBjuR0$default(TouchTargetKt.minimumTouchTargetSize(modifier3), C2256Dp.m20968constructorimpl(ThumbWidth * f), C2256Dp.m20968constructorimpl(ThumbHeight * f), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer3, -990606702, true, new C18492(function03, i5, mutableInteractionSource, mutableInteractionSource2, z3, closedFloatingPointRange2, value, i10, stateRememberUpdatedState, (float[]) objRememberedValue4, sliderColorsM17285colorsq0g_0yA)), composer4, 3072, 6);
                                composer2 = composer4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function04 = function03;
                                z4 = z3;
                                closedFloatingPointRange3 = closedFloatingPointRange2;
                                i11 = i10;
                                sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                                modifier4 = modifier3;
                            } else {
                                composer3 = composer2;
                                function03 = function05;
                                modifier3 = modifier2;
                                z3 = z2;
                                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                                i10 = i8;
                            }
                        } else {
                            composer2.skipToGroupEnd();
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                            }
                            if ((i4 & 128) != 0) {
                                i5 &= -29360129;
                            }
                            function03 = function02;
                            modifier3 = modifier2;
                            z3 = z2;
                            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                            i10 = i8;
                            composer3 = composer2;
                        }
                        sliderColorsM17285colorsq0g_0yA = sliderColors;
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer3.startReplaceableGroup(-492369756);
                        objRememberedValue = composer3.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                        }
                        composer3.endReplaceableGroup();
                        MutableInteractionSource mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        composer3.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                        }
                        composer3.endReplaceableGroup();
                        MutableInteractionSource mutableInteractionSource22 = (MutableInteractionSource) objRememberedValue2;
                        if (i10 >= 0) {
                        }
                    } else {
                        composer2.skipToGroupEnd();
                        function04 = function02;
                        modifier4 = modifier2;
                        z4 = z2;
                        closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                        i11 = i8;
                        sliderColors2 = sliderColors;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.3
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

                        public final void invoke(@Nullable Composer composer5, int i14) {
                            SliderKt.RangeSlider(value, onValueChange, modifier4, z4, closedFloatingPointRange3, i11, function04, sliderColors2, composer5, i2 | 1, i4);
                        }
                    });
                    return;
                }
                i5 |= 196608;
                i8 = i;
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                if ((i2 & 29360128) == 0) {
                }
                composer2 = composerStartRestartGroup;
                if ((i5 & 23967451) == 4793490) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i4 & 16) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i9 == 0) {
                        }
                        if ((i4 & 128) == 0) {
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
            if ((i2 & 29360128) == 0) {
            }
            composer2 = composerStartRestartGroup;
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
        if ((i2 & 29360128) == 0) {
        }
        composer2 = composerStartRestartGroup;
        if ((i5 & 23967451) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RangeSliderImpl(final boolean z, final float f, final float f4, final float[] fArr, final SliderColors sliderColors, final float f5, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Modifier modifier, final Modifier modifier2, final Modifier modifier3, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-597471305);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-597471305, i, i2, "androidx.compose.material3.RangeSliderImpl (Slider.kt:511)");
        }
        Strings.Companion companion = Strings.INSTANCE;
        final String strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(companion.m17316getSliderRangeStartadMyvUU(), composerStartRestartGroup, 6);
        final String strM17317getStringNWtq282 = Strings_androidKt.m17317getStringNWtq28(companion.m17315getSliderRangeEndadMyvUU(), composerStartRestartGroup, 6);
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
        Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, 1755032509);
        float fMo15546toPx0680j_4 = density2.mo15546toPx0680j_4(TrackHeight);
        float fMo15542toDpu2uoSUM = density2.mo15542toDpu2uoSUM(f5);
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(fMo15542toDpu2uoSUM * f);
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(fMo15542toDpu2uoSUM * f4);
        int i4 = i << 6;
        m17287TempRangeSliderTrackau3_HiA(SizeKt.fillMaxSize$default(boxScopeInstance.align(Modifier.INSTANCE, companion2.getCenterStart()), 0.0f, 1, null), sliderColors, z, f, f4, fArr, ThumbWidth, fMo15546toPx0680j_4, composerStartRestartGroup, ((i >> 9) & 112) | 1835008 | (i4 & 896) | (i4 & 7168) | (i4 & 57344));
        m17286TempRangeSliderThumbrAjV9yQ(boxScopeInstance, fM20968constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1592025586, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                invoke(boxScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@NotNull BoxScope TempRangeSliderThumb, @Nullable Composer composer2, int i5) {
                Intrinsics.checkNotNullParameter(TempRangeSliderThumb, "$this$TempRangeSliderThumb");
                if ((i5 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1592025586, i5, -1, "androidx.compose.material3.RangeSliderImpl.<anonymous>.<anonymous> (Slider.kt:552)");
                }
                SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                Modifier.Companion companion4 = Modifier.INSTANCE;
                final String str = strM17317getStringNWtq28;
                composer2.startReplaceableGroup(1157296644);
                boolean zChanged = composer2.changed(str);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$2$1$1
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
                            SemanticsPropertiesKt.setContentDescription(semantics, str);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                composer2.endReplaceableGroup();
                Modifier modifierThen2 = FocusableKt.focusable(SemanticsModifierKt.semantics(companion4, true, (Function1) objRememberedValue), true, mutableInteractionSource).then(modifier2);
                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                SliderColors sliderColors2 = sliderColors;
                boolean z2 = z;
                int i6 = i;
                sliderDefaults.m17284Thumb9LiSoMs(mutableInteractionSource3, modifierThen2, sliderColors2, z2, 0L, composer2, ((i6 >> 18) & 14) | 196608 | ((i6 >> 6) & 896) | ((i6 << 9) & 7168), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 390);
        m17286TempRangeSliderThumbrAjV9yQ(boxScopeInstance, fM20968constructorimpl2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1141545019, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                invoke(boxScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@NotNull BoxScope TempRangeSliderThumb, @Nullable Composer composer2, int i5) {
                Intrinsics.checkNotNullParameter(TempRangeSliderThumb, "$this$TempRangeSliderThumb");
                if ((i5 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1141545019, i5, -1, "androidx.compose.material3.RangeSliderImpl.<anonymous>.<anonymous> (Slider.kt:568)");
                }
                SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                Modifier.Companion companion4 = Modifier.INSTANCE;
                final String str = strM17317getStringNWtq282;
                composer2.startReplaceableGroup(1157296644);
                boolean zChanged = composer2.changed(str);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$3$1$1
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
                            SemanticsPropertiesKt.setContentDescription(semantics, str);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                composer2.endReplaceableGroup();
                Modifier modifierThen2 = FocusableKt.focusable(SemanticsModifierKt.semantics(companion4, true, (Function1) objRememberedValue), true, mutableInteractionSource2).then(modifier3);
                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                SliderColors sliderColors2 = sliderColors;
                boolean z2 = z;
                int i6 = i;
                sliderDefaults.m17284Thumb9LiSoMs(mutableInteractionSource3, modifierThen2, sliderColors2, z2, 0L, composer2, ((i6 >> 21) & 14) | 196608 | ((i6 >> 6) & 896) | ((i6 << 9) & 7168), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 390);
        if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSliderImpl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i5) {
                SliderKt.RangeSliderImpl(z, f, f4, fArr, sliderColors, f5, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier3, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0293 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, @NotNull final Function1<? super Float, Unit> onValueChange, @Nullable Modifier modifier, boolean z, @Nullable ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, @Nullable Function0<Unit> function0, @Nullable SliderColors sliderColors, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i7;
        int i8;
        int i9;
        int i10;
        Function0<Unit> function02;
        int i11;
        SliderColors sliderColorsM17285colorsq0g_0yA;
        int i12;
        final Function0<Unit> function03;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        final MutableInteractionSource mutableInteractionSource2;
        final int i13;
        final boolean z3;
        final SliderColors sliderColors2;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChanged2;
        Object objRememberedValue2;
        final Modifier modifier3;
        final int i14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-202044027);
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
        int i15 = i4 & 4;
        if (i15 != 0) {
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
                if ((i2 & 57344) == 0) {
                    if ((i4 & 16) == 0) {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                        int i16 = composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                        i5 |= i16;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    }
                    i5 |= i16;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                i7 = i4 & 32;
                if (i7 == 0) {
                    if ((i2 & 458752) == 0) {
                        i8 = i;
                        i5 |= composerStartRestartGroup.changed(i8) ? 131072 : 65536;
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        i10 = 57344;
                        function02 = function0;
                    } else {
                        i10 = 57344;
                        function02 = function0;
                        if ((i2 & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changed(function02) ? 1048576 : 524288;
                        }
                    }
                    if ((i2 & 29360128) != 0) {
                        i11 = 458752;
                        if ((i4 & 128) == 0) {
                            sliderColorsM17285colorsq0g_0yA = sliderColors;
                            int i17 = composerStartRestartGroup.changed(sliderColorsM17285colorsq0g_0yA) ? 8388608 : 4194304;
                            i5 |= i17;
                        } else {
                            sliderColorsM17285colorsq0g_0yA = sliderColors;
                        }
                        i5 |= i17;
                    } else {
                        i11 = 458752;
                        sliderColorsM17285colorsq0g_0yA = sliderColors;
                    }
                    i12 = i4 & 256;
                    if (i12 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 234881024) == 0) {
                        i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                    }
                    if ((i5 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            }
                            if (i7 != 0) {
                                i8 = 0;
                            }
                            if (i9 != 0) {
                                function02 = null;
                            }
                            if ((i4 & 128) != 0) {
                                i5 &= -29360129;
                                sliderColorsM17285colorsq0g_0yA = SliderDefaults.INSTANCE.m17285colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            }
                            if (i12 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                function03 = function02;
                                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue3;
                                i13 = i5;
                                z3 = z2;
                                sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-202044027, i13, -1, "androidx.compose.material3.Slider (Slider.kt:154)");
                            }
                            Boolean boolValueOf = Boolean.valueOf(z3);
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(mutableInteractionSource2) | composerStartRestartGroup.changed(sliderColors2);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = ComposableLambdaKt.composableLambdaInstance(-1923353268, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer2, Integer num) {
                                        invoke(sliderPositions, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@NotNull SliderPositions it, @Nullable Composer composer2, int i18) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        if ((i18 & 81) == 16 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1923353268, i18, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:176)");
                                        }
                                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                        MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                        SliderColors sliderColors3 = sliderColors2;
                                        boolean z4 = z3;
                                        int i19 = i13;
                                        sliderDefaults.m17284Thumb9LiSoMs(mutableInteractionSource3, null, sliderColors3, z4, 0L, composer2, ((i19 >> 24) & 14) | 196608 | ((i19 >> 15) & 896) | (i19 & 7168), 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Function3 function3 = (Function3) objRememberedValue;
                            Boolean boolValueOf2 = Boolean.valueOf(z3);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(boolValueOf2) | composerStartRestartGroup.changed(sliderColors2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = ComposableLambdaKt.composableLambdaInstance(1022381539, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer2, Integer num) {
                                        invoke(sliderPositions, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@NotNull SliderPositions sliderPositions, @Nullable Composer composer2, int i18) {
                                        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                                        if ((i18 & 14) == 0) {
                                            i18 |= composer2.changed(sliderPositions) ? 4 : 2;
                                        }
                                        if ((i18 & 91) == 18 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1022381539, i18, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:183)");
                                        }
                                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                        SliderColors sliderColors3 = sliderColors2;
                                        boolean z4 = z3;
                                        int i19 = i13;
                                        sliderDefaults.Track(sliderPositions, null, sliderColors3, z4, composer2, (i18 & 14) | 24576 | ((i19 >> 15) & 896) | (i19 & 7168), 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i18 = i13 & 126;
                            int i19 = i13 << 3;
                            modifier3 = modifier2;
                            i14 = i8;
                            Slider(f, onValueChange, (Function3) objRememberedValue2, modifier3, z3, closedFloatingPointRange2, i14, function03, sliderColors2, mutableInteractionSource2, function3, composerStartRestartGroup, i18 | (i19 & 7168) | (i19 & i10) | (i19 & i11) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (i19 & 1879048192), 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                            }
                            if ((i4 & 128) != 0) {
                                i5 &= -29360129;
                            }
                        }
                        i13 = i5;
                        z3 = z2;
                        function03 = function02;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                        mutableInteractionSource2 = mutableInteractionSource;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Boolean boolValueOf3 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf3) | composerStartRestartGroup.changed(mutableInteractionSource2) | composerStartRestartGroup.changed(sliderColors2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = ComposableLambdaKt.composableLambdaInstance(-1923353268, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer2, Integer num) {
                                    invoke(sliderPositions, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@NotNull SliderPositions it, @Nullable Composer composer2, int i182) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if ((i182 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1923353268, i182, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:176)");
                                    }
                                    SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                    MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                    SliderColors sliderColors3 = sliderColors2;
                                    boolean z4 = z3;
                                    int i192 = i13;
                                    sliderDefaults.m17284Thumb9LiSoMs(mutableInteractionSource3, null, sliderColors3, z4, 0L, composer2, ((i192 >> 24) & 14) | 196608 | ((i192 >> 15) & 896) | (i192 & 7168), 18);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            composerStartRestartGroup.endReplaceableGroup();
                            Function3 function32 = (Function3) objRememberedValue;
                            Boolean boolValueOf22 = Boolean.valueOf(z3);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged2 = composerStartRestartGroup.changed(boolValueOf22) | composerStartRestartGroup.changed(sliderColors2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue2 = ComposableLambdaKt.composableLambdaInstance(1022381539, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer2, Integer num) {
                                        invoke(sliderPositions, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@NotNull SliderPositions sliderPositions, @Nullable Composer composer2, int i182) {
                                        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                                        if ((i182 & 14) == 0) {
                                            i182 |= composer2.changed(sliderPositions) ? 4 : 2;
                                        }
                                        if ((i182 & 91) == 18 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1022381539, i182, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:183)");
                                        }
                                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                        SliderColors sliderColors3 = sliderColors2;
                                        boolean z4 = z3;
                                        int i192 = i13;
                                        sliderDefaults.Track(sliderPositions, null, sliderColors3, z4, composer2, (i182 & 14) | 24576 | ((i192 >> 15) & 896) | (i192 & 7168), 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                composerStartRestartGroup.endReplaceableGroup();
                                int i182 = i13 & 126;
                                int i192 = i13 << 3;
                                modifier3 = modifier2;
                                i14 = i8;
                                Slider(f, onValueChange, (Function3) objRememberedValue2, modifier3, z3, closedFloatingPointRange2, i14, function03, sliderColors2, mutableInteractionSource2, function32, composerStartRestartGroup, i182 | (i192 & 7168) | (i192 & i10) | (i192 & i11) | (i192 & 3670016) | (i192 & 29360128) | (i192 & 234881024) | (i192 & 1879048192), 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        function03 = function02;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                        i14 = i8;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.4
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

                        public final void invoke(@Nullable Composer composer2, int i20) {
                            SliderKt.Slider(f, onValueChange, modifier3, z3, closedFloatingPointRange2, i14, function03, sliderColors2, mutableInteractionSource2, composer2, i2 | 1, i4);
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
                i12 = i4 & 256;
                if (i12 == 0) {
                }
                if ((i5 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i4 & 16) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i4 & 128) != 0) {
                        }
                        if (i12 == 0) {
                            i13 = i5;
                            z3 = z2;
                            function03 = function02;
                            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                            sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Boolean boolValueOf32 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf32) | composerStartRestartGroup.changed(mutableInteractionSource2) | composerStartRestartGroup.changed(sliderColors2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i2 & 57344) == 0) {
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
            i12 = i4 & 256;
            if (i12 == 0) {
            }
            if ((i5 & 191739611) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        if ((i2 & 57344) == 0) {
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
        i12 = i4 & 256;
        if (i12 == 0) {
        }
        if ((i5 & 191739611) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void SliderImpl(final Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final int i, final float f, final ClosedFloatingPointRange<Float> closedFloatingPointRange, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i2) {
        int i4;
        int i5;
        float f4;
        int i6;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        MutableState mutableState4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function33;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function34;
        final boolean z2 = z;
        Composer composerStartRestartGroup = composer.startRestartGroup(851260148);
        if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(function1) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(function0) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i5 = i;
            i4 |= composerStartRestartGroup.changed(i5) ? 131072 : 65536;
        } else {
            i5 = i;
        }
        if ((i2 & 3670016) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((i2 & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changed(closedFloatingPointRange) ? 8388608 : 4194304;
        }
        if ((i2 & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changed(function3) ? 67108864 : 33554432;
        }
        if ((i2 & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changed(function32) ? 536870912 : 268435456;
        }
        if ((i4 & 1533916891) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            composer2 = composerStartRestartGroup;
            function34 = function32;
            function33 = function3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(851260148, i4, -1, "androidx.compose.material3.SliderImpl (Slider.kt:798)");
            }
            Float fValueOf = Float.valueOf(f);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(function1);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1<Float, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$onValueChangeState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f5) {
                        invoke(f5.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f5) {
                        if (f5 == f) {
                            return;
                        }
                        function1.invoke(Float.valueOf(f5));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(objRememberedValue, composerStartRestartGroup, 0);
            Integer numValueOf = Integer.valueOf(i5);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(numValueOf);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = stepsToTickFractions(i5);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final float[] fArr = (float[]) objRememberedValue2;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue3 == companion.getEmpty()) {
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(getThumbWidth()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue3 = mutableStateMutableStateOf$default;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final MutableState mutableState5 = (MutableState) objRememberedValue3;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableState mutableState6 = (MutableState) objRememberedValue4;
            boolean z3 = composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            boolean z4 = z3;
            if (objRememberedValue5 == companion.getEmpty()) {
                f4 = 0.0f;
                MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(SliderImpl$scaleToOffset(closedFloatingPointRange, 0.0f, 0.0f, f)), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                objRememberedValue5 = mutableStateMutableStateOf$default2;
            } else {
                f4 = 0.0f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final MutableState mutableState7 = (MutableState) objRememberedValue5;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f4), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableState mutableState8 = (MutableState) objRememberedValue6;
            final float fCalcFraction = calcFraction(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue()));
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new SliderPositions(fCalcFraction, fArr);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SliderPositions sliderPositions = (SliderPositions) objRememberedValue7;
            sliderPositions.setPositionFraction$material3_release(fCalcFraction);
            sliderPositions.setTickFractions$material3_release(fArr);
            int i7 = i4 >> 21;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged3 = composerStartRestartGroup.changed(closedFloatingPointRange);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue8 == companion.getEmpty()) {
                i6 = i4;
                mutableState = mutableState6;
                mutableState2 = mutableState8;
                mutableState3 = mutableState5;
                mutableState4 = mutableState7;
                objRememberedValue8 = new SliderDraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$draggableState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f5) {
                        invoke(f5.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f5) {
                        float f6 = 2;
                        float fMax = Math.max(mutableState.getValue().floatValue() - (mutableState5.getValue().floatValue() / f6), 0.0f);
                        float fMin = Math.min(mutableState5.getValue().floatValue() / f6, fMax);
                        MutableState<Float> mutableState9 = mutableState7;
                        mutableState9.setValue(Float.valueOf(mutableState2.getValue().floatValue() + mutableState9.getValue().floatValue() + f5));
                        mutableState2.setValue(Float.valueOf(0.0f));
                        stateRememberUpdatedState.getValue().invoke(Float.valueOf(SliderKt.SliderImpl$scaleToUserValue(closedFloatingPointRange, fMin, fMax, SliderKt.snapValueToTick(mutableState7.getValue().floatValue(), fArr, fMin, fMax))));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                mutableState4 = mutableState7;
                i6 = i4;
                mutableState3 = mutableState5;
                mutableState = mutableState6;
                mutableState2 = mutableState8;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final SliderDraggableState sliderDraggableState = (SliderDraggableState) objRememberedValue8;
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$gestureEndAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Function0<Unit> function02;
                    if (sliderDraggableState.isDragging() || (function02 = function0) == null) {
                        return;
                    }
                    function02.invoke();
                }
            }, composerStartRestartGroup, 0);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierSliderTapModifier = sliderTapModifier(companion2, sliderDraggableState, mutableInteractionSource, ((Number) mutableState.getValue()).intValue(), z4, mutableState4, stateRememberUpdatedState2, mutableState2, z);
            Orientation orientation = Orientation.Horizontal;
            boolean zIsDragging = sliderDraggableState.isDragging();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged4 = composerStartRestartGroup.changed(stateRememberUpdatedState2);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = new SliderKt$SliderImpl$drag$1$1(stateRememberUpdatedState2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            Modifier modifierDraggable$default = DraggableKt.draggable$default(companion2, sliderDraggableState, orientation, z, mutableInteractionSource, zIsDragging, null, (Function3) objRememberedValue9, z4, 32, null);
            mutableInteractionSource2 = mutableInteractionSource;
            Modifier modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifier);
            SliderTokens sliderTokens = SliderTokens.INSTANCE;
            z2 = z;
            Modifier modifierThen = FocusableKt.focusable(sliderSemantics(SizeKt.m15895requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize, sliderTokens.m17879getHandleWidthD9Ej5fM(), sliderTokens.m17878getHandleHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), f, z2, function1, function0, closedFloatingPointRange, i), z2, mutableInteractionSource2).then(modifierSliderTapModifier).then(modifierDraggable$default);
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt.SliderImpl.2
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> measurables, long j) {
                    MeasureScope Layout = measureScope;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    for (Measurable measurable : list) {
                        if (LayoutIdKt.getLayoutId(measurable) == SliderComponents.THUMB) {
                            long j2 = j;
                            final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j2);
                            int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j2) - placeableMo19855measureBRTryo0.getWidth();
                            for (Measurable measurable2 : list) {
                                if (LayoutIdKt.getLayoutId(measurable2) == SliderComponents.TRACK) {
                                    final Placeable placeableMo19855measureBRTryo02 = measurable2.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j2, 0, iM20921getMaxWidthimpl, 0, 0, 8, null));
                                    int width = placeableMo19855measureBRTryo02.getWidth() + placeableMo19855measureBRTryo0.getWidth();
                                    int iMax = Math.max(placeableMo19855measureBRTryo02.getHeight(), placeableMo19855measureBRTryo0.getHeight());
                                    mutableState3.setValue(Float.valueOf(placeableMo19855measureBRTryo0.getWidth()));
                                    mutableState.setValue(Integer.valueOf(width));
                                    final int width2 = placeableMo19855measureBRTryo0.getWidth() / 2;
                                    final int iRoundToInt = MathKt.roundToInt(placeableMo19855measureBRTryo02.getWidth() * fCalcFraction);
                                    final int iM1197B = AbstractC1038a.m1197B(placeableMo19855measureBRTryo02, iMax, 2);
                                    final int iM1197B2 = AbstractC1038a.m1197B(placeableMo19855measureBRTryo0, iMax, 2);
                                    return MeasureScope.layout$default(Layout, width, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$measure$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo02, width2, iM1197B, 0.0f, 4, null);
                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo0, iRoundToInt, iM1197B2, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                                Layout = measureScope;
                                j2 = j;
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        Layout = measureScope;
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierThen);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion3.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion3.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(1870435165);
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion2, SliderComponents.THUMB);
            composer2.startReplaceableGroup(733328855);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion4, false, composer2, 0, -1323940314);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierLayoutId);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-1220826601);
            function33 = function3;
            function33.invoke(sliderPositions, composer2, Integer.valueOf((i7 & 112) | 6));
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            Modifier modifierLayoutId2 = LayoutIdKt.layoutId(companion2, SliderComponents.TRACK);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion4, false, composer2, 0, -1323940314);
            Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierLayoutId2);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer2, composer2), composer2, 0);
            AbstractC1038a.m1220u(2058660585, -2137368960, composer2, 971611456);
            function34 = function32;
            function34.invoke(sliderPositions, composer2, Integer.valueOf(((i6 >> 24) & 112) | 6));
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function35 = function33;
        final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function36 = function34;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.SliderImpl.3
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

            public final void invoke(@Nullable Composer composer3, int i8) {
                SliderKt.SliderImpl(modifier, z2, mutableInteractionSource3, function1, function0, i, f, closedFloatingPointRange, function35, function36, composer3, i2 | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SliderImpl$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, float f, float f4, float f5) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f5, f, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SliderImpl$scaleToUserValue(ClosedFloatingPointRange<Float> closedFloatingPointRange, float f, float f4, float f5) {
        return scale(f, f4, f5, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: TempRangeSliderThumb-rAjV9yQ, reason: not valid java name */
    public static final void m17286TempRangeSliderThumbrAjV9yQ(final BoxScope boxScope, float f, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        final float f4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2104116536);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function3) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            f4 = f;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2104116536, i2, -1, "androidx.compose.material3.TempRangeSliderThumb (Slider.kt:946)");
            }
            f4 = f;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, f4, 0.0f, 0.0f, 0.0f, 14, null);
            Alignment.Companion companion = Alignment.INSTANCE;
            Modifier modifierAlign = boxScope.align(modifierM15858paddingqDBjuR0$default, companion.getCenterStart());
            int i4 = (i2 << 3) & 7168;
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
            function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i4 >> 6) & 112) | 6));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$TempRangeSliderThumb$1
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
                SliderKt.m17286TempRangeSliderThumbrAjV9yQ(boxScope, f4, function3, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: TempRangeSliderTrack-au3_HiA, reason: not valid java name */
    public static final void m17287TempRangeSliderTrackau3_HiA(final Modifier modifier, final SliderColors sliderColors, final boolean z, final float f, final float f4, final float[] fArr, final float f5, final float f6, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1015664062);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1015664062, i, -1, "androidx.compose.material3.TempRangeSliderTrack (Slider.kt:960)");
        }
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        floatRef.element = density.mo15546toPx0680j_4(f5) / 2;
        floatRef2.element = density.mo15546toPx0680j_4(TickSize);
        int i2 = ((i >> 6) & 14) | 48 | ((i << 3) & 896);
        final State<Color> stateTrackColor$material3_release = sliderColors.trackColor$material3_release(z, false, composerStartRestartGroup, i2);
        final State<Color> stateTrackColor$material3_release2 = sliderColors.trackColor$material3_release(z, true, composerStartRestartGroup, i2);
        final State<Color> stateTickColor$material3_release = sliderColors.tickColor$material3_release(z, false, composerStartRestartGroup, i2);
        final State<Color> stateTickColor$material3_release2 = sliderColors.tickColor$material3_release(z, true, composerStartRestartGroup, i2);
        CanvasKt.Canvas(modifier, new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderKt$TempRangeSliderTrack$2
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
                long jOffset = OffsetKt.Offset(floatRef.element, Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()));
                long jOffset2 = OffsetKt.Offset(Size.m18353getWidthimpl(Canvas.mo19076getSizeNHjbRc()) - floatRef.element, Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()));
                long j = jOffset2;
                if (!z2) {
                    jOffset2 = jOffset;
                }
                if (z2) {
                    j = jOffset;
                }
                long jM18535unboximpl = stateTrackColor$material3_release.getValue().m18535unboximpl();
                float f7 = f6;
                StrokeCap.Companion companion = StrokeCap.INSTANCE;
                DrawScope.m19062drawLineNGM6Ib0$default(Canvas, jM18535unboximpl, jOffset2, j, f7, companion.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                long j2 = j;
                long j3 = jOffset2;
                DrawScope.m19062drawLineNGM6Ib0$default(Canvas, stateTrackColor$material3_release2.getValue().m18535unboximpl(), OffsetKt.Offset(((Offset.m18284getXimpl(j) - Offset.m18284getXimpl(jOffset2)) * f) + Offset.m18284getXimpl(jOffset2), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0())), OffsetKt.Offset(((Offset.m18284getXimpl(j) - Offset.m18284getXimpl(jOffset2)) * f4) + Offset.m18284getXimpl(jOffset2), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0())), f6, companion.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                float[] fArr2 = fArr;
                float f8 = f4;
                float f9 = f;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int length = fArr2.length;
                for (int i4 = 0; i4 < length; i4++) {
                    float f10 = fArr2[i4];
                    Boolean boolValueOf = Boolean.valueOf(f10 > f8 || f10 < f9);
                    Object arrayList = linkedHashMap.get(boolValueOf);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(boolValueOf, arrayList);
                    }
                    ((List) arrayList).add(Float.valueOf(f10));
                }
                State<Color> state = stateTickColor$material3_release;
                State<Color> state2 = stateTickColor$material3_release2;
                Ref.FloatRef floatRef3 = floatRef2;
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
                    List list = (List) entry.getValue();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(list));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(Offset.m18273boximpl(OffsetKt.Offset(Offset.m18284getXimpl(OffsetKt.m18307lerpWko1d7g(j3, j2, ((Number) it.next()).floatValue())), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()))));
                    }
                    long j5 = j3;
                    j2 = j2;
                    DrawScope.m19067drawPointsF8ZwMP8$default(Canvas, arrayList2, PointMode.INSTANCE.m18831getPointsr_lszbg(), (zBooleanValue ? state : state2).getValue().m18535unboximpl(), floatRef3.element, StrokeCap.INSTANCE.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                    floatRef3 = floatRef3;
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$TempRangeSliderTrack$3
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
                SliderKt.m17287TempRangeSliderTrackau3_HiA(modifier, sliderColors, z, f, f4, fArr, f5, f6, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float f, float f4, float f5, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(draggableState, null, new C18572(f, f4, f5, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m17291awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
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
            Function2<PointerInputChange, Float, Unit> function2 = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
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
            Object objM17135awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m17135awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, function2, sliderKt$awaitSlop$12);
            if (objM17135awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objM17135awaitHorizontalPointerSlopOrCancellationgDDlDlE;
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

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier modifier, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, boolean z, boolean z2, float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, State<? extends Function1<? super Boolean, Unit>> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f), Boolean.valueOf(z2), closedFloatingPointRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C18581(mutableInteractionSource, mutableInteractionSource2, state, state2, state4, z2, f, state3, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float f, float f4, float f5, float f6, float f7) {
        return MathHelpersKt.lerp(f6, f7, calcFraction(f, f4, f5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier modifier, float f, final boolean z, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int i) {
        final float fCoerceIn = RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt.sliderSemantics.1
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
                SemanticsPropertiesKt.setProgress$default(semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt.sliderSemantics.1.1
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

    private static final Modifier sliderTapModifier(Modifier modifier, final DraggableState draggableState, final MutableInteractionSource mutableInteractionSource, final int i, final boolean z, final State<Float> state, final State<? extends Function0<Unit>> state2, final MutableState<Float> mutableState, final boolean z2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
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
                inspectorInfo.getProperties().set("maxPx", Integer.valueOf(i));
                AbstractC0622a.m1163i(z, inspectorInfo.getProperties(), "isRtl", inspectorInfo).set("rawOffset", state);
                inspectorInfo.getProperties().set("gestureEndAction", state2);
                inspectorInfo.getProperties().set("pressOffset", mutableState);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.SliderKt.sliderTapModifier.2

            /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {1129}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DraggableState $draggableState;
                final /* synthetic */ State<Function0<Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ int $maxPx;
                final /* synthetic */ MutableState<Float> $pressOffset;
                final /* synthetic */ State<Float> $rawOffset;
                final /* synthetic */ CoroutineScope $scope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {1134}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class C145601 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ int $maxPx;
                    final /* synthetic */ MutableState<Float> $pressOffset;
                    final /* synthetic */ State<Float> $rawOffset;
                    /* synthetic */ long J$0;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C145601(boolean z, int i, MutableState<Float> mutableState, State<Float> state, Continuation<? super C145601> continuation) {
                        super(3, continuation);
                        this.$isRtl = z;
                        this.$maxPx = i;
                        this.$pressOffset = mutableState;
                        this.$rawOffset = state;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                        return m17292invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
                    }

                    @Nullable
                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                    public final Object m17292invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j, @Nullable Continuation<? super Unit> continuation) {
                        C145601 c145601 = new C145601(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, continuation);
                        c145601.L$0 = pressGestureScope;
                        c145601.J$0 = j;
                        return c145601.invokeSuspend(Unit.INSTANCE);
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
                public AnonymousClass1(boolean z, int i, MutableState<Float> mutableState, State<Float> state, CoroutineScope coroutineScope, DraggableState draggableState, State<? extends Function0<Unit>> state2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = i;
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
                        C145601 c145601 = new C145601(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
                        final CoroutineScope coroutineScope = this.$scope;
                        final DraggableState draggableState = this.$draggableState;
                        final State<Function0<Unit>> state = this.$gestureEndAction;
                        Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material3.SliderKt.sliderTapModifier.2.1.2

                            /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                            @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {1141}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                            public static final class C145611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DraggableState $draggableState;
                                final /* synthetic */ State<Function0<Unit>> $gestureEndAction;
                                int label;

                                /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                @DebugMetadata(m14020c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1$1", m14021f = "Slider.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                public static final class C145621 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    public C145621(Continuation<? super C145621> continuation) {
                                        super(2, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @NotNull
                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                        C145621 c145621 = new C145621(continuation);
                                        c145621.L$0 = obj;
                                        return c145621;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    @Nullable
                                    public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
                                        return ((C145621) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                public C145611(DraggableState draggableState, State<? extends Function0<Unit>> state, Continuation<? super C145611> continuation) {
                                    super(2, continuation);
                                    this.$draggableState = draggableState;
                                    this.$gestureEndAction = state;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    return new C145611(this.$draggableState, this.$gestureEndAction, continuation);
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
                                        C145621 c145621 = new C145621(null);
                                        this.label = 1;
                                        if (draggableState.drag(mutatePriority, c145621, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    this.$gestureEndAction.getValue().invoke();
                                    return Unit.INSTANCE;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                @Nullable
                                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                    return ((C145611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                m17293invokek4lQ0M(offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                            public final void m17293invokek4lQ0M(long j) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C145611(draggableState, state, null), 3, null);
                            }
                        };
                        this.label = 1;
                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, c145601, function1, this, 3, null) == coroutine_suspended) {
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
            public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i2) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(2040469710);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2040469710, i2, -1, "androidx.compose.material3.sliderTapModifier.<anonymous> (Slider.kt:1124)");
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
                    composed = SuspendingPointerInputFilterKt.pointerInput(composed, new Object[]{draggableState, mutableInteractionSource, Integer.valueOf(i), Boolean.valueOf(z)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(z, i, mutableState, state, coroutineScope, draggableState, state2, null));
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
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final float snapValueToTick(float f, float[] fArr, float f4, float f5) {
        Float fValueOf;
        if (fArr.length == 0) {
            fValueOf = null;
        } else {
            float f6 = fArr[0];
            int lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex == 0) {
                fValueOf = Float.valueOf(f6);
            } else {
                float fAbs = Math.abs(MathHelpersKt.lerp(f4, f5, f6) - f);
                ?? it = new IntRange(1, lastIndex).iterator();
                while (it.hasNext()) {
                    float f7 = fArr[it.nextInt()];
                    float fAbs2 = Math.abs(MathHelpersKt.lerp(f4, f5, f7) - f);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        f6 = f7;
                        fAbs = fAbs2;
                    }
                }
                fValueOf = Float.valueOf(f6);
            }
        }
        return fValueOf != null ? MathHelpersKt.lerp(f4, f5, fValueOf.floatValue()) : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int i) {
        if (i == 0) {
            return new float[0];
        }
        int i2 = i + 2;
        float[] fArr = new float[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            fArr[i4] = i4 / (i + 1);
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float f, float f4, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f5, float f6) {
        return RangesKt.rangeTo(scale(f, f4, closedFloatingPointRange.getStart().floatValue(), f5, f6), scale(f, f4, closedFloatingPointRange.getEndInclusive().floatValue(), f5, f6));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x028c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0135  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, @NotNull final Function1<? super Float, Unit> onValueChange, @Nullable Modifier modifier, boolean z, @Nullable ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, @Nullable Function0<Unit> function0, @Nullable SliderColors sliderColors, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> thumb, @Nullable Composer composer, final int i2, final int i4) {
        float f4;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Function0<Unit> function02;
        int i12;
        int i13;
        int i14;
        SliderColors sliderColorsM17285colorsq0g_0yA;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        final Function0<Unit> function03;
        final int i15;
        final boolean z3;
        final SliderColors sliderColors2;
        MutableInteractionSource mutableInteractionSource2;
        boolean zChanged;
        Object objRememberedValue;
        final Modifier modifier3;
        final int i16;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Intrinsics.checkNotNullParameter(thumb, "thumb");
        Composer composerStartRestartGroup = composer.startRestartGroup(1785516312);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            f4 = f;
        } else if ((i2 & 14) == 0) {
            f4 = f;
            i5 = (composerStartRestartGroup.changed(f4) ? 4 : 2) | i2;
        } else {
            f4 = f;
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        int i17 = i4 & 4;
        if (i17 != 0) {
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
                if ((i2 & 57344) == 0) {
                    if ((i4 & 16) == 0) {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                        int i18 = composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                        i5 |= i18;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    }
                    i5 |= i18;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= 196608;
                    i8 = 57344;
                    i9 = i;
                } else {
                    i8 = 57344;
                    i9 = i;
                    if ((i2 & 458752) == 0) {
                        i5 |= composerStartRestartGroup.changed(i9) ? 131072 : 65536;
                    }
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                    i5 |= 1572864;
                    i11 = 458752;
                    function02 = function0;
                } else {
                    i11 = 458752;
                    function02 = function0;
                    if ((i2 & 3670016) == 0) {
                        i5 |= composerStartRestartGroup.changed(function02) ? 1048576 : 524288;
                    }
                }
                if ((i2 & 29360128) == 0) {
                    i5 |= ((i4 & 128) == 0 && composerStartRestartGroup.changed(sliderColors)) ? 8388608 : 4194304;
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                    i5 |= 100663296;
                    i13 = i12;
                } else {
                    i13 = i12;
                    if ((i2 & 234881024) == 0) {
                        i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                    }
                }
                if ((i4 & 512) == 0) {
                    if ((i2 & 1879048192) == 0) {
                        i14 = composerStartRestartGroup.changed(thumb) ? 536870912 : 268435456;
                    }
                    if ((1533916891 & i5) != 306783378 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        i16 = i9;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        function03 = function02;
                        sliderColors2 = sliderColors;
                        mutableInteractionSource3 = mutableInteractionSource;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            }
                            if (i7 != 0) {
                                i9 = 0;
                            }
                            if (i10 != 0) {
                                function02 = null;
                            }
                            if ((i4 & 128) == 0) {
                                sliderColorsM17285colorsq0g_0yA = SliderDefaults.INSTANCE.m17285colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                                i5 &= -29360129;
                            } else {
                                sliderColorsM17285colorsq0g_0yA = sliderColors;
                            }
                            if (i13 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                boolean z4 = z2;
                                sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                                i15 = i5;
                                z3 = z4;
                                function03 = function02;
                            } else {
                                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                                function03 = function02;
                                i15 = i5;
                                z3 = z2;
                                sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                            }
                            if ((i4 & 128) != 0) {
                                i5 &= -29360129;
                            }
                            mutableInteractionSource2 = mutableInteractionSource;
                            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                            function03 = function02;
                            i15 = i5;
                            z3 = z2;
                            sliderColors2 = sliderColors;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1785516312, i15, -1, "androidx.compose.material3.Slider (Slider.kt:235)");
                        }
                        Boolean boolValueOf = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(sliderColors2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = ComposableLambdaKt.composableLambdaInstance(1252336501, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$6$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer2, Integer num) {
                                    invoke(sliderPositions, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@NotNull SliderPositions sliderPositions, @Nullable Composer composer2, int i19) {
                                    Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                                    if ((i19 & 14) == 0) {
                                        i19 |= composer2.changed(sliderPositions) ? 4 : 2;
                                    }
                                    if ((i19 & 91) == 18 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1252336501, i19, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:259)");
                                    }
                                    SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                    SliderColors sliderColors3 = sliderColors2;
                                    boolean z5 = z3;
                                    int i20 = i15;
                                    sliderDefaults.Track(sliderPositions, null, sliderColors3, z5, composer2, (i19 & 14) | 24576 | ((i20 >> 15) & 896) | (i20 & 7168), 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i19 = i15 << 3;
                        float f5 = f4;
                        modifier3 = modifier2;
                        i16 = i9;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        Slider(f5, onValueChange, (Function3) objRememberedValue, modifier3, z3, closedFloatingPointRange2, i16, function03, sliderColors2, mutableInteractionSource3, thumb, composerStartRestartGroup, (i19 & 7168) | (i15 & 126) | (i19 & i8) | (i19 & i11) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (i19 & 1879048192), (i15 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.7
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

                        public final void invoke(@Nullable Composer composer2, int i20) {
                            SliderKt.Slider(f, onValueChange, modifier3, z3, closedFloatingPointRange2, i16, function03, sliderColors2, mutableInteractionSource3, thumb, composer2, i2 | 1, i4);
                        }
                    });
                    return;
                }
                i14 = DriveFile.MODE_READ_WRITE;
                i5 |= i14;
                if ((1533916891 & i5) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i4 & 16) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if ((i4 & 128) == 0) {
                        }
                        if (i13 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Boolean boolValueOf2 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(boolValueOf2) | composerStartRestartGroup.changed(sliderColors2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = ComposableLambdaKt.composableLambdaInstance(1252336501, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$6$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer2, Integer num) {
                                    invoke(sliderPositions, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@NotNull SliderPositions sliderPositions, @Nullable Composer composer2, int i192) {
                                    Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                                    if ((i192 & 14) == 0) {
                                        i192 |= composer2.changed(sliderPositions) ? 4 : 2;
                                    }
                                    if ((i192 & 91) == 18 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1252336501, i192, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:259)");
                                    }
                                    SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                    SliderColors sliderColors3 = sliderColors2;
                                    boolean z5 = z3;
                                    int i20 = i15;
                                    sliderDefaults.Track(sliderPositions, null, sliderColors3, z5, composer2, (i192 & 14) | 24576 | ((i20 >> 15) & 896) | (i20 & 7168), 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            composerStartRestartGroup.endReplaceableGroup();
                            int i192 = i15 << 3;
                            float f52 = f4;
                            modifier3 = modifier2;
                            i16 = i9;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            Slider(f52, onValueChange, (Function3) objRememberedValue, modifier3, z3, closedFloatingPointRange2, i16, function03, sliderColors2, mutableInteractionSource3, thumb, composerStartRestartGroup, (i192 & 7168) | (i15 & 126) | (i192 & i8) | (i192 & i11) | (i192 & 3670016) | (i192 & 29360128) | (i192 & 234881024) | (i192 & 1879048192), (i15 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i2 & 57344) == 0) {
            }
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            if ((i2 & 29360128) == 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            if ((i4 & 512) == 0) {
            }
            i5 |= i14;
            if ((1533916891 & i5) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        if ((i2 & 57344) == 0) {
        }
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        if ((i2 & 29360128) == 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        if ((i4 & 512) == 0) {
        }
        i5 |= i14;
        if ((1533916891 & i5) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0125  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, @NotNull final Function1<? super Float, Unit> onValueChange, @NotNull final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> track, @Nullable Modifier modifier, boolean z, @Nullable ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, @Nullable Function0<Unit> function0, @Nullable SliderColors sliderColors, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        final int i6;
        Modifier modifier2;
        int i7;
        final boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i8;
        int i9;
        int i10;
        final SliderColors sliderColorsM17285colorsq0g_0yA;
        int i11;
        int i12;
        int i13;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        final MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        boolean z3;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32;
        SliderColors sliderColors2;
        int i14;
        Function0<Unit> function02;
        int i15;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function33;
        Composer composer2;
        final SliderColors sliderColors3;
        final MutableInteractionSource mutableInteractionSource4;
        final Function0<Unit> function03;
        final int i16;
        final Modifier modifier4;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Intrinsics.checkNotNullParameter(track, "track");
        Composer composerStartRestartGroup = composer.startRestartGroup(387052651);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i6 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i6 = i2;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i2 & 112) == 0) {
            i6 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            i6 |= 384;
        } else if ((i2 & 896) == 0) {
            i6 |= composerStartRestartGroup.changed(track) ? 256 : 128;
        }
        int i17 = i5 & 8;
        if (i17 != 0) {
            i6 |= 3072;
        } else {
            if ((i2 & 7168) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i7 = i5 & 16;
            if (i7 != 0) {
                if ((i2 & 57344) == 0) {
                    z2 = z;
                    i6 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                }
                if ((i2 & 458752) == 0) {
                    if ((i5 & 32) == 0) {
                        closedFloatingPointRange2 = closedFloatingPointRange;
                        int i18 = composerStartRestartGroup.changed(closedFloatingPointRange2) ? 131072 : 65536;
                        i6 |= i18;
                    } else {
                        closedFloatingPointRange2 = closedFloatingPointRange;
                    }
                    i6 |= i18;
                } else {
                    closedFloatingPointRange2 = closedFloatingPointRange;
                }
                i8 = i5 & 64;
                if (i8 != 0) {
                    i6 |= 1572864;
                    i9 = i;
                } else {
                    i9 = i;
                    if ((i2 & 3670016) == 0) {
                        i6 |= composerStartRestartGroup.changed(i9) ? 1048576 : 524288;
                    }
                }
                i10 = i5 & 128;
                if (i10 != 0) {
                    i6 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    i6 |= composerStartRestartGroup.changed(function0) ? 8388608 : 4194304;
                }
                if ((i2 & 234881024) == 0) {
                    if ((i5 & 256) == 0) {
                        sliderColorsM17285colorsq0g_0yA = sliderColors;
                        int i19 = composerStartRestartGroup.changed(sliderColorsM17285colorsq0g_0yA) ? 67108864 : 33554432;
                        i6 |= i19;
                    } else {
                        sliderColorsM17285colorsq0g_0yA = sliderColors;
                    }
                    i6 |= i19;
                } else {
                    sliderColorsM17285colorsq0g_0yA = sliderColors;
                }
                i11 = i5 & 512;
                if (i11 != 0) {
                    i6 |= DriveFile.MODE_READ_WRITE;
                    i12 = i11;
                } else {
                    i12 = i11;
                    if ((i2 & 1879048192) == 0) {
                        i6 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                    }
                }
                if ((i4 & 14) == 0) {
                    i13 = i4 | (((i5 & 1024) == 0 && composerStartRestartGroup.changed(function3)) ? 4 : 2);
                } else {
                    i13 = i4;
                }
                if ((i6 & 1533916891) == 306783378 && (i13 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function33 = function3;
                    i16 = i9;
                    sliderColors3 = sliderColorsM17285colorsq0g_0yA;
                    modifier4 = modifier2;
                    composer2 = composerStartRestartGroup;
                    z4 = z2;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    function03 = function0;
                    mutableInteractionSource4 = mutableInteractionSource;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i5 & 32) == 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i6 &= -458753;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i8 != 0) {
                            i9 = 0;
                        }
                        Function0<Unit> function04 = i10 == 0 ? null : function0;
                        if ((i5 & 256) != 0) {
                            sliderColorsM17285colorsq0g_0yA = SliderDefaults.INSTANCE.m17285colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i6 = (-234881025) & i6;
                        }
                        if (i12 == 0) {
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
                        if ((i5 & 1024) == 0) {
                            Boolean boolValueOf = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(mutableInteractionSource2) | composerStartRestartGroup.changed(sliderColorsM17285colorsq0g_0yA);
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = ComposableLambdaKt.composableLambdaInstance(1647281944, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$9$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer3, Integer num) {
                                        invoke(sliderPositions, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@NotNull SliderPositions it, @Nullable Composer composer3, int i20) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        if ((i20 & 81) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1647281944, i20, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:325)");
                                        }
                                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                                        SliderColors sliderColors4 = sliderColorsM17285colorsq0g_0yA;
                                        boolean z5 = z2;
                                        int i21 = i6;
                                        sliderDefaults.m17284Thumb9LiSoMs(mutableInteractionSource5, null, sliderColors4, z5, 0L, composer3, ((i21 >> 27) & 14) | 196608 | ((i21 >> 18) & 896) | ((i21 >> 3) & 7168), 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            i13 &= -15;
                            Modifier modifier5 = modifier2;
                            function32 = (Function3) objRememberedValue2;
                            modifier3 = modifier5;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            z3 = z2;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier3 = modifier2;
                            z3 = z2;
                            function32 = function3;
                        }
                        sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                        i14 = i9;
                        function02 = function04;
                        i15 = i13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i5 & 32) != 0) {
                            i6 &= -458753;
                        }
                        if ((i5 & 256) != 0) {
                            i6 &= -234881025;
                        }
                        if ((i5 & 1024) != 0) {
                            i13 &= -15;
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z3 = z2;
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        i15 = i13;
                        function32 = function3;
                        sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                        i14 = i9;
                        function02 = function0;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(387052651, i6, i15, "androidx.compose.material3.Slider (Slider.kt:312)");
                    }
                    if (i14 < 0) {
                        int i20 = i6 >> 9;
                        Modifier modifier6 = modifier3;
                        int i21 = i6 << 6;
                        SliderImpl(modifier6, z3, mutableInteractionSource3, onValueChange, function02, i14, f, closedFloatingPointRangeRangeTo, function32, track, composerStartRestartGroup, ((i6 >> 21) & 896) | (i20 & 126) | (i21 & 7168) | (i20 & 57344) | ((i6 >> 3) & 458752) | ((i6 << 18) & 3670016) | (i21 & 29360128) | ((i15 << 24) & 234881024) | ((i6 << 21) & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                        function33 = function32;
                        composer2 = composerStartRestartGroup;
                        sliderColors3 = sliderColors2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function03 = function02;
                        i16 = i14;
                        modifier4 = modifier6;
                        z4 = z3;
                    } else {
                        throw new IllegalArgumentException("steps should be >= 0");
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.11
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

                    public final void invoke(@Nullable Composer composer3, int i22) {
                        SliderKt.Slider(f, onValueChange, track, modifier4, z4, closedFloatingPointRange3, i16, function03, sliderColors3, mutableInteractionSource4, function33, composer3, i2 | 1, i4, i5);
                    }
                });
                return;
            }
            i6 |= 24576;
            z2 = z;
            if ((i2 & 458752) == 0) {
            }
            i8 = i5 & 64;
            if (i8 != 0) {
            }
            i10 = i5 & 128;
            if (i10 != 0) {
            }
            if ((i2 & 234881024) == 0) {
            }
            i11 = i5 & 512;
            if (i11 != 0) {
            }
            if ((i4 & 14) == 0) {
            }
            if ((i6 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i5 & 32) == 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if ((i5 & 256) != 0) {
                    }
                    if (i12 == 0) {
                    }
                    if ((i5 & 1024) == 0) {
                    }
                    sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                    i14 = i9;
                    function02 = function04;
                    i15 = i13;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (i14 < 0) {
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 16;
        if (i7 != 0) {
        }
        z2 = z;
        if ((i2 & 458752) == 0) {
        }
        i8 = i5 & 64;
        if (i8 != 0) {
        }
        i10 = i5 & 128;
        if (i10 != 0) {
        }
        if ((i2 & 234881024) == 0) {
        }
        i11 = i5 & 512;
        if (i11 != 0) {
        }
        if ((i4 & 14) == 0) {
        }
        if ((i6 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
