package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.AlignmentLineKt;
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.unit.Velocity;
import androidx.compose.p109ui.unit.VelocityKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0086\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ao\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u007f\u0010(\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u007f\u00100\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u007f\u00101\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u0085\u0001\u00102\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0003¢\u0006\u0002\u00107\u001a\u007f\u00108\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u007f\u00109\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a¦\u0001\u0010:\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u001c2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u0002062\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a¸\u0001\u0010J\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u00020\u00012\u0011\u0010K\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010L\u001a\u0002042\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a+\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020<2\b\b\u0002\u0010T\u001a\u00020<2\b\b\u0002\u0010U\u001a\u00020<H\u0007¢\u0006\u0002\u0010V\u001aD\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020R2\u0006\u0010Z\u001a\u00020<2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\\2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010^H\u0082@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010_\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006`"}, m13886d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "MediumTopAppBar", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SmallTopAppBar", "TopAppBar", "TopAppBarLayout", "heightPx", "", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "maxHeight", "pinnedHeight", "TwoRowsTopAppBar-tjU4iQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;FFLandroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "initialHeightOffsetLimit", "initialHeightOffset", "initialContentOffset", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;

    @NotNull
    private static final CubicBezierEasing TopTitleAlphaEasing;

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarKt$settleAppBar$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material3.AppBarKt", m14021f = "AppBar.kt", m14022i = {0, 0, 0, 1}, m14023l = {1579, 1595}, m14024m = "settleAppBar", m14025n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, m14026s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class C17181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C17181(Continuation<? super C17181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppBarKt.settleAppBar(null, 0.0f, null, null, this);
        }
    }

    static {
        float f = 16;
        float f4 = 12;
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f) - C2256Dp.m20968constructorimpl(f4));
        BottomAppBarHorizontalPadding = fM20968constructorimpl;
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f) - C2256Dp.m20968constructorimpl(f4));
        BottomAppBarVerticalPadding = fM20968constructorimpl2;
        FABHorizontalPadding = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f) - fM20968constructorimpl);
        FABVerticalPadding = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f4) - fM20968constructorimpl2);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = C2256Dp.m20968constructorimpl(24);
        LargeTitleBottomPadding = C2256Dp.m20968constructorimpl(28);
        float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(4);
        TopAppBarHorizontalPadding = fM20968constructorimpl3;
        TopAppBarTitleInset = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f) - fM20968constructorimpl3);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012d  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomAppBar-1oL4kX8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16988BottomAppBar1oL4kX8(@Nullable Modifier modifier, long j, long j2, float f, @Nullable PaddingValues paddingValues, @Nullable WindowInsets windowInsets, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final int i4;
        long containerColor;
        long jM17098contentColorForek8zF_U;
        float fM17005getContainerElevationD9Ej5fM;
        int i5;
        PaddingValues contentPadding;
        int i6;
        WindowInsets windowInsets2;
        Modifier modifier3;
        final WindowInsets windowInsets3;
        long j3;
        float f4;
        final PaddingValues paddingValues2;
        int i7;
        long j5;
        Composer composer2;
        final PaddingValues paddingValues3;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final long j6;
        final long j7;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1391700845);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                containerColor = j;
                int i10 = composerStartRestartGroup.changed(containerColor) ? 32 : 16;
                i4 |= i10;
            } else {
                containerColor = j;
            }
            i4 |= i10;
        } else {
            containerColor = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM17098contentColorForek8zF_U = j2;
                int i11 = composerStartRestartGroup.changed(jM17098contentColorForek8zF_U) ? 256 : 128;
                i4 |= i11;
            } else {
                jM17098contentColorForek8zF_U = j2;
            }
            i4 |= i11;
        } else {
            jM17098contentColorForek8zF_U = j2;
        }
        int i12 = i2 & 8;
        if (i12 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                fM17005getContainerElevationD9Ej5fM = f;
                i4 |= composerStartRestartGroup.changed(fM17005getContainerElevationD9Ej5fM) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i & 57344) == 0) {
                    contentPadding = paddingValues;
                    i4 |= composerStartRestartGroup.changed(contentPadding) ? 16384 : 8192;
                }
                if ((i & 458752) == 0) {
                    i6 = 57344;
                    windowInsets2 = windowInsets;
                    i4 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(windowInsets2)) ? 131072 : 65536;
                } else {
                    i6 = 57344;
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 64) == 0) {
                    i8 = (i & 3670016) == 0 ? composerStartRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                    if ((i4 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                                containerColor = BottomAppBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            if ((i2 & 4) != 0) {
                                jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 3) & 14);
                                i4 &= -897;
                            }
                            if (i12 != 0) {
                                fM17005getContainerElevationD9Ej5fM = BottomAppBarDefaults.INSTANCE.m17005getContainerElevationD9Ej5fM();
                            }
                            if (i5 != 0) {
                                contentPadding = BottomAppBarDefaults.INSTANCE.getContentPadding();
                            }
                            if ((i2 & 32) == 0) {
                                windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                i4 &= -458753;
                                modifier3 = modifier5;
                                j3 = containerColor;
                                f4 = fM17005getContainerElevationD9Ej5fM;
                                paddingValues2 = contentPadding;
                                i7 = -1391700845;
                                j5 = jM17098contentColorForek8zF_U;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:454)");
                                }
                                Shape shape = ShapesKt.toShape(BottomAppBarTokens.INSTANCE.getContainerShape(), composerStartRestartGroup, 6);
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -396569832, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$3
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

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer3, int i13) {
                                        if ((i13 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-396569832, i13, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:470)");
                                        }
                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m15885height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets3), BottomAppBarTokens.INSTANCE.m17494getContainerHeightD9Ej5fM()), paddingValues2);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                        int i14 = ((i4 >> 9) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                        if (composer3.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        function3.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i14 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                int i13 = (i4 & 14) | 12582912;
                                int i14 = i4 << 3;
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m17325SurfaceT9BRK9s(modifier3, shape, j3, j5, f4, 0.0f, null, composableLambda, composer2, i13 | (i14 & 896) | (i14 & 7168) | (i14 & i6), 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                paddingValues3 = paddingValues2;
                                windowInsets4 = windowInsets3;
                                modifier4 = modifier3;
                                j6 = j3;
                                j7 = j5;
                                f5 = f4;
                            } else {
                                modifier3 = modifier5;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                            modifier3 = modifier2;
                        }
                        f4 = fM17005getContainerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        paddingValues2 = contentPadding;
                        j3 = containerColor;
                        j5 = jM17098contentColorForek8zF_U;
                        i7 = -1391700845;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Shape shape2 = ShapesKt.toShape(BottomAppBarTokens.INSTANCE.getContainerShape(), composerStartRestartGroup, 6);
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -396569832, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$3
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

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer3, int i132) {
                                if ((i132 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-396569832, i132, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:470)");
                                }
                                Modifier modifierPadding = PaddingKt.padding(SizeKt.m15885height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets3), BottomAppBarTokens.INSTANCE.m17494getContainerHeightD9Ej5fM()), paddingValues2);
                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                int i142 = ((i4 >> 9) & 7168) | 432;
                                composer3.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                composer3.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                composer3.startReplaceableGroup(-678309503);
                                function3.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i142 >> 6) & 112) | 6));
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i132 = (i4 & 14) | 12582912;
                        int i142 = i4 << 3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m17325SurfaceT9BRK9s(modifier3, shape2, j3, j5, f4, 0.0f, null, composableLambda2, composer2, i132 | (i142 & 896) | (i142 & 7168) | (i142 & i6), 96);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        paddingValues3 = paddingValues2;
                        windowInsets4 = windowInsets3;
                        modifier4 = modifier3;
                        j6 = j3;
                        j7 = j5;
                        f5 = f4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier2;
                        j6 = containerColor;
                        j7 = jM17098contentColorForek8zF_U;
                        f5 = fM17005getContainerElevationD9Ej5fM;
                        windowInsets4 = windowInsets2;
                        paddingValues3 = contentPadding;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$4
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

                        public final void invoke(@Nullable Composer composer3, int i15) {
                            AppBarKt.m16988BottomAppBar1oL4kX8(modifier4, j6, j7, f5, paddingValues3, windowInsets4, content, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i8;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 == 0) {
                        }
                        if ((i2 & 2) != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            contentPadding = paddingValues;
            if ((i & 458752) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            i4 |= i8;
            if ((i4 & 2995931) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM17005getContainerElevationD9Ej5fM = f;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        contentPadding = paddingValues;
        if ((i & 458752) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        i4 |= i8;
        if ((i4 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x020c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011f  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomAppBar-Snr_uVM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16989BottomAppBarSnr_uVM(@NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, @Nullable PaddingValues paddingValues, @Nullable WindowInsets windowInsets, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        Modifier modifier2;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        long containerColor;
        long jM17098contentColorForek8zF_U;
        int i6;
        int i7;
        float fM17005getContainerElevationD9Ej5fM;
        int i8;
        Modifier modifier3;
        int i9;
        long j3;
        WindowInsets windowInsets2;
        PaddingValues paddingValues2;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier4;
        final long j5;
        final long j6;
        final float f4;
        final PaddingValues paddingValues3;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(actions, "actions");
        Composer composerStartRestartGroup = composer.startRestartGroup(2141738945);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(actions) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 != 0) {
                if ((i & 896) == 0) {
                    function22 = function2;
                    i4 |= composerStartRestartGroup.changed(function22) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        containerColor = j;
                        int i11 = composerStartRestartGroup.changed(containerColor) ? 2048 : 1024;
                        i4 |= i11;
                    } else {
                        containerColor = j;
                    }
                    i4 |= i11;
                } else {
                    containerColor = j;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        jM17098contentColorForek8zF_U = j2;
                        int i12 = composerStartRestartGroup.changed(jM17098contentColorForek8zF_U) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        jM17098contentColorForek8zF_U = j2;
                    }
                    i4 |= i12;
                } else {
                    jM17098contentColorForek8zF_U = j2;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                    i7 = 57344;
                    fM17005getContainerElevationD9Ej5fM = f;
                } else {
                    i7 = 57344;
                    fM17005getContainerElevationD9Ej5fM = f;
                    if ((i & 458752) == 0) {
                        i4 |= composerStartRestartGroup.changed(fM17005getContainerElevationD9Ej5fM) ? 131072 : 65536;
                    }
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i4 |= composerStartRestartGroup.changed(paddingValues) ? 1048576 : 524288;
                }
                if ((i & 29360128) == 0) {
                    i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(windowInsets)) ? 8388608 : 4194304;
                }
                if ((i4 & 23967451) == 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier2;
                    function23 = function22;
                    j5 = containerColor;
                    f4 = fM17005getContainerElevationD9Ej5fM;
                    j6 = jM17098contentColorForek8zF_U;
                    paddingValues3 = paddingValues;
                    windowInsets3 = windowInsets;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function22 = null;
                        }
                        if ((i2 & 8) != 0) {
                            containerColor = BottomAppBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 9) & 14);
                            i4 &= -57345;
                        }
                        if (i6 != 0) {
                            fM17005getContainerElevationD9Ej5fM = BottomAppBarDefaults.INSTANCE.m17005getContainerElevationD9Ej5fM();
                        }
                        PaddingValues contentPadding = i8 == 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
                        if ((i2 & 128) == 0) {
                            i4 &= -29360129;
                            long j7 = jM17098contentColorForek8zF_U;
                            modifier3 = modifier2;
                            i9 = 458752;
                            j3 = j7;
                            paddingValues2 = contentPadding;
                            windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            long j8 = jM17098contentColorForek8zF_U;
                            modifier3 = modifier2;
                            i9 = 458752;
                            j3 = j8;
                            windowInsets2 = windowInsets;
                            paddingValues2 = contentPadding;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i4 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i4 &= -57345;
                        }
                        if ((i2 & 128) != 0) {
                            i4 &= -29360129;
                        }
                        long j9 = jM17098contentColorForek8zF_U;
                        modifier3 = modifier2;
                        i9 = 458752;
                        j3 = j9;
                        paddingValues2 = paddingValues;
                        windowInsets2 = windowInsets;
                    }
                    long j10 = containerColor;
                    float f5 = fM17005getContainerElevationD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2141738945, i4, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:394)");
                    }
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1974005449, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope BottomAppBar, @Nullable Composer composer3, int i13) {
                            Intrinsics.checkNotNullParameter(BottomAppBar, "$this$BottomAppBar");
                            if ((i13 & 14) == 0) {
                                i13 |= composer3.changed(BottomAppBar) ? 4 : 2;
                            }
                            if ((i13 & 91) == 18 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1974005449, i13, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:410)");
                            }
                            actions.invoke(BottomAppBar, composer3, Integer.valueOf((i13 & 14) | ((i4 << 3) & 112)));
                            if (function22 != null) {
                                Modifier.Companion companion = Modifier.INSTANCE;
                                SpacerKt.Spacer(BottomAppBar.weight(companion, 1.0f, true), composer3, 0);
                                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 0.0f, AppBarKt.FABVerticalPadding, AppBarKt.FABHorizontalPadding, 0.0f, 9, null);
                                Alignment topStart = Alignment.INSTANCE.getTopStart();
                                Function2<Composer, Integer, Unit> function24 = function22;
                                int i14 = i4;
                                composer3.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer3, 6);
                                Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                composer3.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                composer3.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(1812284970);
                                AbstractC1038a.m1222w(composer3, (i14 >> 6) & 14, function24);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i13 = 1572864 | ((i4 >> 3) & 14);
                    int i14 = i4 >> 6;
                    composer2 = composerStartRestartGroup;
                    m16988BottomAppBar1oL4kX8(modifier3, j10, j3, f5, paddingValues2, windowInsets2, composableLambda, composer2, i13 | (i14 & 112) | (i14 & 896) | (i14 & 7168) | (i14 & i7) | (i14 & i9), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function23 = function22;
                    modifier4 = modifier3;
                    j5 = j10;
                    j6 = j3;
                    f4 = f5;
                    paddingValues3 = paddingValues2;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
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

                    public final void invoke(@Nullable Composer composer3, int i15) {
                        AppBarKt.m16989BottomAppBarSnr_uVM(actions, modifier4, function23, j5, j6, f4, paddingValues3, windowInsets3, composer3, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= 384;
            function22 = function2;
            if ((i & 7168) == 0) {
            }
            if ((i & 57344) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            i8 = i2 & 64;
            if (i8 != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i4 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    long j102 = containerColor;
                    float f52 = fM17005getContainerElevationD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1974005449, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope BottomAppBar, @Nullable Composer composer3, int i132) {
                            Intrinsics.checkNotNullParameter(BottomAppBar, "$this$BottomAppBar");
                            if ((i132 & 14) == 0) {
                                i132 |= composer3.changed(BottomAppBar) ? 4 : 2;
                            }
                            if ((i132 & 91) == 18 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1974005449, i132, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:410)");
                            }
                            actions.invoke(BottomAppBar, composer3, Integer.valueOf((i132 & 14) | ((i4 << 3) & 112)));
                            if (function22 != null) {
                                Modifier.Companion companion = Modifier.INSTANCE;
                                SpacerKt.Spacer(BottomAppBar.weight(companion, 1.0f, true), composer3, 0);
                                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 0.0f, AppBarKt.FABVerticalPadding, AppBarKt.FABHorizontalPadding, 0.0f, 9, null);
                                Alignment topStart = Alignment.INSTANCE.getTopStart();
                                Function2<Composer, Integer, Unit> function24 = function22;
                                int i142 = i4;
                                composer3.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer3, 6);
                                Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                composer3.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                composer3.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer3.startReplaceableGroup(1812284970);
                                AbstractC1038a.m1222w(composer3, (i142 >> 6) & 14, function24);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i132 = 1572864 | ((i4 >> 3) & 14);
                    int i142 = i4 >> 6;
                    composer2 = composerStartRestartGroup;
                    m16988BottomAppBar1oL4kX8(modifier3, j102, j3, f52, paddingValues2, windowInsets2, composableLambda2, composer2, i132 | (i142 & 112) | (i142 & 896) | (i142 & 7168) | (i142 & i7) | (i142 & i9), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function23 = function22;
                    modifier4 = modifier3;
                    j5 = j102;
                    j6 = j3;
                    f4 = f52;
                    paddingValues3 = paddingValues2;
                    windowInsets3 = windowInsets2;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 != 0) {
        }
        function22 = function2;
        if ((i & 7168) == 0) {
        }
        if ((i & 57344) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        i8 = i2 & 64;
        if (i8 != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i4 & 23967451) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CenterAlignedTopAppBar(@NotNull final Function2<? super Composer, ? super Integer, Unit> title, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable WindowInsets windowInsets, @Nullable TopAppBarColors topAppBarColors, @Nullable TopAppBarScrollBehavior topAppBarScrollBehavior, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function2M17111getLambda5$material3_release;
        int i6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M17112getLambda6$material3_release;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        final WindowInsets windowInsets4;
        final TopAppBarColors topAppBarColors3;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2139286460);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    function2M17111getLambda5$material3_release = function2;
                    i4 |= composerStartRestartGroup.changed(function2M17111getLambda5$material3_release) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        function3M17112getLambda6$material3_release = function3;
                        i4 |= composerStartRestartGroup.changed(function3M17112getLambda6$material3_release) ? 2048 : 1024;
                    }
                    if ((i & 57344) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            int i9 = composerStartRestartGroup.changed(windowInsets2) ? 16384 : 8192;
                            i4 |= i9;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i4 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((i & 458752) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM = topAppBarColors;
                            int i10 = composerStartRestartGroup.changed(topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM) ? 131072 : 65536;
                            i4 |= i10;
                        } else {
                            topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM = topAppBarColors;
                        }
                        i4 |= i10;
                    } else {
                        topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM = topAppBarColors;
                    }
                    i7 = i2 & 64;
                    if (i7 != 0) {
                        if ((i & 3670016) == 0) {
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            i4 |= composerStartRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        }
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            function23 = function2M17111getLambda5$material3_release;
                            function33 = function3M17112getLambda6$material3_release;
                            windowInsets4 = windowInsets2;
                            topAppBarColors3 = topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    function2M17111getLambda5$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m17111getLambda5$material3_release();
                                }
                                if (i6 != 0) {
                                    function3M17112getLambda6$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m17112getLambda6$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                    topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m17470centerAlignedTopAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196608, 31);
                                }
                                if (i7 == 0) {
                                    function32 = function3M17112getLambda6$material3_release;
                                    topAppBarColors2 = topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM;
                                    topAppBarScrollBehavior3 = null;
                                    function22 = function2M17111getLambda5$material3_release;
                                    windowInsets3 = windowInsets2;
                                } else {
                                    function22 = function2M17111getLambda5$material3_release;
                                    function32 = function3M17112getLambda6$material3_release;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors2 = topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM;
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                modifier3 = modifier2;
                                function22 = function2M17111getLambda5$material3_release;
                                function32 = function3M17112getLambda6$material3_release;
                                windowInsets3 = windowInsets2;
                                topAppBarColors2 = topAppBarColorsM17470centerAlignedTopAppBarColorszjMxDiM;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2139286460, i4, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:224)");
                            }
                            int i11 = i4 << 6;
                            int i12 = (i11 & 234881024) | (i11 & 57344) | ((i4 >> 3) & 14) | 3072 | ((i4 << 3) & 112) | (i11 & 458752) | (i11 & 3670016) | (29360128 & i11);
                            Modifier modifier5 = modifier3;
                            SingleRowTopAppBar(modifier5, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function22, function32, windowInsets3, topAppBarColors2, topAppBarScrollBehavior3, composerStartRestartGroup, i12, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            function23 = function22;
                            function33 = function32;
                            windowInsets4 = windowInsets3;
                            topAppBarColors3 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar.1
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

                            public final void invoke(@Nullable Composer composer2, int i13) {
                                AppBarKt.CenterAlignedTopAppBar(title, modifier4, function23, function33, windowInsets4, topAppBarColors3, topAppBarScrollBehavior4, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 1572864;
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((2995931 & i4) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i2 & 16) != 0) {
                            }
                            if ((i2 & 32) != 0) {
                            }
                            if (i7 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i112 = i4 << 6;
                            int i122 = (i112 & 234881024) | (i112 & 57344) | ((i4 >> 3) & 14) | 3072 | ((i4 << 3) & 112) | (i112 & 458752) | (i112 & 3670016) | (29360128 & i112);
                            Modifier modifier52 = modifier3;
                            SingleRowTopAppBar(modifier52, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function22, function32, windowInsets3, topAppBarColors2, topAppBarScrollBehavior3, composerStartRestartGroup, i122, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier52;
                            function23 = function22;
                            function33 = function32;
                            windowInsets4 = windowInsets3;
                            topAppBarColors3 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function3M17112getLambda6$material3_release = function3;
                if ((i & 57344) != 0) {
                }
                if ((i & 458752) != 0) {
                }
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((2995931 & i4) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function2M17111getLambda5$material3_release = function2;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            function3M17112getLambda6$material3_release = function3;
            if ((i & 57344) != 0) {
            }
            if ((i & 458752) != 0) {
            }
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((2995931 & i4) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function2M17111getLambda5$material3_release = function2;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        function3M17112getLambda6$material3_release = function3;
        if ((i & 57344) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((2995931 & i4) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LargeTopAppBar(@NotNull final Function2<? super Composer, ? super Integer, Unit> title, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable WindowInsets windowInsets, @Nullable TopAppBarColors topAppBarColors, @Nullable TopAppBarScrollBehavior topAppBarScrollBehavior, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColorsM17471largeTopAppBarColorszjMxDiM;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier modifier3;
        WindowInsets windowInsets3;
        Composer composer2;
        TopAppBarColors topAppBarColors2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets4;
        Composer composer3;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final WindowInsets windowInsets5;
        final TopAppBarColors topAppBarColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-474540752);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    function22 = function2;
                    i4 |= composerStartRestartGroup.changed(function22) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        function32 = function3;
                        i4 |= composerStartRestartGroup.changed(function32) ? 2048 : 1024;
                    }
                    if ((i & 57344) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            int i9 = composerStartRestartGroup.changed(windowInsets2) ? 16384 : 8192;
                            i4 |= i9;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i4 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColorsM17471largeTopAppBarColorszjMxDiM = topAppBarColors;
                            int i10 = composerStartRestartGroup.changed(topAppBarColorsM17471largeTopAppBarColorszjMxDiM) ? 131072 : 65536;
                            i4 |= i10;
                        } else {
                            topAppBarColorsM17471largeTopAppBarColorszjMxDiM = topAppBarColors;
                        }
                        i4 |= i10;
                    } else {
                        topAppBarColorsM17471largeTopAppBarColorszjMxDiM = topAppBarColors;
                    }
                    i7 = i2 & 64;
                    if (i7 != 0) {
                        if ((i & 3670016) == 0) {
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            i4 |= composerStartRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        }
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            function24 = function22;
                            function34 = function32;
                            windowInsets5 = windowInsets2;
                            topAppBarColors3 = topAppBarColorsM17471largeTopAppBarColorszjMxDiM;
                            composer3 = composerStartRestartGroup;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function2M17115getLambda9$material3_release = i5 == 0 ? ComposableSingletons$AppBarKt.INSTANCE.m17115getLambda9$material3_release() : function22;
                                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M17105getLambda10$material3_release = i6 == 0 ? ComposableSingletons$AppBarKt.INSTANCE.m17105getLambda10$material3_release() : function32;
                                if ((i2 & 16) == 0) {
                                    i4 &= -57345;
                                    windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                } else {
                                    windowInsets3 = windowInsets2;
                                }
                                int i11 = i4;
                                if ((i2 & 32) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    topAppBarColorsM17471largeTopAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m17471largeTopAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, 196608, 31);
                                    i4 = i11 & (-458753);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    i4 = i11;
                                }
                                topAppBarScrollBehavior2 = i7 == 0 ? null : topAppBarScrollBehavior;
                                topAppBarColors2 = topAppBarColorsM17471largeTopAppBarColorszjMxDiM;
                                function23 = function2M17115getLambda9$material3_release;
                                function33 = function3M17105getLambda10$material3_release;
                                windowInsets4 = windowInsets3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                modifier3 = modifier2;
                                function23 = function22;
                                function33 = function32;
                                windowInsets4 = windowInsets2;
                                topAppBarColors2 = topAppBarColorsM17471largeTopAppBarColorszjMxDiM;
                                composer2 = composerStartRestartGroup;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-474540752, i4, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:337)");
                            }
                            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                            Typography typography = materialTheme.getTypography(composer2, 6);
                            TopAppBarLargeTokens topAppBarLargeTokens = TopAppBarLargeTokens.INSTANCE;
                            TextStyle textStyleFromToken = TypographyKt.fromToken(typography, topAppBarLargeTokens.getHeadlineFont());
                            Typography typography2 = materialTheme.getTypography(composer2, 6);
                            TopAppBarSmallTokens topAppBarSmallTokens = TopAppBarSmallTokens.INSTANCE;
                            int i12 = i4;
                            int i13 = i12 << 12;
                            Composer composer4 = composer2;
                            Modifier modifier5 = modifier3;
                            m16992TwoRowsTopAppBartjU4iQQ(modifier5, title, textStyleFromToken, LargeTitleBottomPadding, title, TypographyKt.fromToken(typography2, topAppBarSmallTokens.getHeadlineFont()), function23, function33, windowInsets4, topAppBarColors2, topAppBarLargeTokens.m17918getContainerHeightD9Ej5fM(), topAppBarSmallTokens.m17932getContainerHeightD9Ej5fM(), topAppBarScrollBehavior2, composer4, ((i12 >> 3) & 14) | 3072 | ((i12 << 3) & 112) | (i13 & 57344) | (i13 & 3670016) | (i13 & 29360128) | (i13 & 234881024) | (i13 & 1879048192), ((i12 >> 12) & 896) | 54, 0);
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            function24 = function23;
                            function34 = function33;
                            windowInsets5 = windowInsets4;
                            topAppBarColors3 = topAppBarColors2;
                        }
                        final TopAppBarScrollBehavior topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.LargeTopAppBar.1
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
                                AppBarKt.LargeTopAppBar(title, modifier4, function24, function34, windowInsets5, topAppBarColors3, topAppBarScrollBehavior3, composer5, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 1572864;
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((2995931 & i4) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            int i112 = i4;
                            if ((i2 & 32) == 0) {
                            }
                            if (i7 == 0) {
                            }
                            topAppBarColors2 = topAppBarColorsM17471largeTopAppBarColorszjMxDiM;
                            function23 = function2M17115getLambda9$material3_release;
                            function33 = function3M17105getLambda10$material3_release;
                            windowInsets4 = windowInsets3;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                            Typography typography3 = materialTheme2.getTypography(composer2, 6);
                            TopAppBarLargeTokens topAppBarLargeTokens2 = TopAppBarLargeTokens.INSTANCE;
                            TextStyle textStyleFromToken2 = TypographyKt.fromToken(typography3, topAppBarLargeTokens2.getHeadlineFont());
                            Typography typography22 = materialTheme2.getTypography(composer2, 6);
                            TopAppBarSmallTokens topAppBarSmallTokens2 = TopAppBarSmallTokens.INSTANCE;
                            int i122 = i4;
                            int i132 = i122 << 12;
                            Composer composer42 = composer2;
                            Modifier modifier52 = modifier3;
                            m16992TwoRowsTopAppBartjU4iQQ(modifier52, title, textStyleFromToken2, LargeTitleBottomPadding, title, TypographyKt.fromToken(typography22, topAppBarSmallTokens2.getHeadlineFont()), function23, function33, windowInsets4, topAppBarColors2, topAppBarLargeTokens2.m17918getContainerHeightD9Ej5fM(), topAppBarSmallTokens2.m17932getContainerHeightD9Ej5fM(), topAppBarScrollBehavior2, composer42, ((i122 >> 3) & 14) | 3072 | ((i122 << 3) & 112) | (i132 & 57344) | (i132 & 3670016) | (i132 & 29360128) | (i132 & 234881024) | (i132 & 1879048192), ((i122 >> 12) & 896) | 54, 0);
                            composer3 = composer42;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier52;
                            function24 = function23;
                            function34 = function33;
                            windowInsets5 = windowInsets4;
                            topAppBarColors3 = topAppBarColors2;
                        }
                    }
                    final TopAppBarScrollBehavior topAppBarScrollBehavior32 = topAppBarScrollBehavior2;
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function32 = function3;
                if ((i & 57344) != 0) {
                }
                if ((458752 & i) != 0) {
                }
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((2995931 & i4) == 599186) {
                }
                final TopAppBarScrollBehavior topAppBarScrollBehavior322 = topAppBarScrollBehavior2;
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function22 = function2;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            function32 = function3;
            if ((i & 57344) != 0) {
            }
            if ((458752 & i) != 0) {
            }
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((2995931 & i4) == 599186) {
            }
            final TopAppBarScrollBehavior topAppBarScrollBehavior3222 = topAppBarScrollBehavior2;
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function22 = function2;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        function32 = function3;
        if ((i & 57344) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((2995931 & i4) == 599186) {
        }
        final TopAppBarScrollBehavior topAppBarScrollBehavior32222 = topAppBarScrollBehavior2;
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MediumTopAppBar(@NotNull final Function2<? super Composer, ? super Integer, Unit> title, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable WindowInsets windowInsets, @Nullable TopAppBarColors topAppBarColors, @Nullable TopAppBarScrollBehavior topAppBarScrollBehavior, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColorsM17472mediumTopAppBarColorszjMxDiM;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier modifier3;
        WindowInsets windowInsets3;
        Composer composer2;
        TopAppBarColors topAppBarColors2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets4;
        Composer composer3;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final WindowInsets windowInsets5;
        final TopAppBarColors topAppBarColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(1805417862);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    function22 = function2;
                    i4 |= composerStartRestartGroup.changed(function22) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        function32 = function3;
                        i4 |= composerStartRestartGroup.changed(function32) ? 2048 : 1024;
                    }
                    if ((i & 57344) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            int i9 = composerStartRestartGroup.changed(windowInsets2) ? 16384 : 8192;
                            i4 |= i9;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i4 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColorsM17472mediumTopAppBarColorszjMxDiM = topAppBarColors;
                            int i10 = composerStartRestartGroup.changed(topAppBarColorsM17472mediumTopAppBarColorszjMxDiM) ? 131072 : 65536;
                            i4 |= i10;
                        } else {
                            topAppBarColorsM17472mediumTopAppBarColorszjMxDiM = topAppBarColors;
                        }
                        i4 |= i10;
                    } else {
                        topAppBarColorsM17472mediumTopAppBarColorszjMxDiM = topAppBarColors;
                    }
                    i7 = i2 & 64;
                    if (i7 != 0) {
                        if ((i & 3670016) == 0) {
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            i4 |= composerStartRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        }
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            function24 = function22;
                            function34 = function32;
                            windowInsets5 = windowInsets2;
                            topAppBarColors3 = topAppBarColorsM17472mediumTopAppBarColorszjMxDiM;
                            composer3 = composerStartRestartGroup;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function2M17113getLambda7$material3_release = i5 == 0 ? ComposableSingletons$AppBarKt.INSTANCE.m17113getLambda7$material3_release() : function22;
                                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M17114getLambda8$material3_release = i6 == 0 ? ComposableSingletons$AppBarKt.INSTANCE.m17114getLambda8$material3_release() : function32;
                                if ((i2 & 16) == 0) {
                                    i4 &= -57345;
                                    windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                } else {
                                    windowInsets3 = windowInsets2;
                                }
                                int i11 = i4;
                                if ((i2 & 32) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    topAppBarColorsM17472mediumTopAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m17472mediumTopAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, 196608, 31);
                                    i4 = i11 & (-458753);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    i4 = i11;
                                }
                                topAppBarScrollBehavior2 = i7 == 0 ? null : topAppBarScrollBehavior;
                                topAppBarColors2 = topAppBarColorsM17472mediumTopAppBarColorszjMxDiM;
                                function23 = function2M17113getLambda7$material3_release;
                                function33 = function3M17114getLambda8$material3_release;
                                windowInsets4 = windowInsets3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                modifier3 = modifier2;
                                function23 = function22;
                                function33 = function32;
                                windowInsets4 = windowInsets2;
                                topAppBarColors2 = topAppBarColorsM17472mediumTopAppBarColorszjMxDiM;
                                composer2 = composerStartRestartGroup;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1805417862, i4, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:279)");
                            }
                            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                            Typography typography = materialTheme.getTypography(composer2, 6);
                            TopAppBarMediumTokens topAppBarMediumTokens = TopAppBarMediumTokens.INSTANCE;
                            TextStyle textStyleFromToken = TypographyKt.fromToken(typography, topAppBarMediumTokens.getHeadlineFont());
                            Typography typography2 = materialTheme.getTypography(composer2, 6);
                            TopAppBarSmallTokens topAppBarSmallTokens = TopAppBarSmallTokens.INSTANCE;
                            int i12 = i4;
                            int i13 = i12 << 12;
                            Composer composer4 = composer2;
                            Modifier modifier5 = modifier3;
                            m16992TwoRowsTopAppBartjU4iQQ(modifier5, title, textStyleFromToken, MediumTitleBottomPadding, title, TypographyKt.fromToken(typography2, topAppBarSmallTokens.getHeadlineFont()), function23, function33, windowInsets4, topAppBarColors2, topAppBarMediumTokens.m17922getContainerHeightD9Ej5fM(), topAppBarSmallTokens.m17932getContainerHeightD9Ej5fM(), topAppBarScrollBehavior2, composer4, ((i12 >> 3) & 14) | 3072 | ((i12 << 3) & 112) | (i13 & 57344) | (i13 & 3670016) | (i13 & 29360128) | (i13 & 234881024) | (i13 & 1879048192), ((i12 >> 12) & 896) | 54, 0);
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            function24 = function23;
                            function34 = function33;
                            windowInsets5 = windowInsets4;
                            topAppBarColors3 = topAppBarColors2;
                        }
                        final TopAppBarScrollBehavior topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.MediumTopAppBar.1
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
                                AppBarKt.MediumTopAppBar(title, modifier4, function24, function34, windowInsets5, topAppBarColors3, topAppBarScrollBehavior3, composer5, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 1572864;
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((2995931 & i4) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            int i112 = i4;
                            if ((i2 & 32) == 0) {
                            }
                            if (i7 == 0) {
                            }
                            topAppBarColors2 = topAppBarColorsM17472mediumTopAppBarColorszjMxDiM;
                            function23 = function2M17113getLambda7$material3_release;
                            function33 = function3M17114getLambda8$material3_release;
                            windowInsets4 = windowInsets3;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                            Typography typography3 = materialTheme2.getTypography(composer2, 6);
                            TopAppBarMediumTokens topAppBarMediumTokens2 = TopAppBarMediumTokens.INSTANCE;
                            TextStyle textStyleFromToken2 = TypographyKt.fromToken(typography3, topAppBarMediumTokens2.getHeadlineFont());
                            Typography typography22 = materialTheme2.getTypography(composer2, 6);
                            TopAppBarSmallTokens topAppBarSmallTokens2 = TopAppBarSmallTokens.INSTANCE;
                            int i122 = i4;
                            int i132 = i122 << 12;
                            Composer composer42 = composer2;
                            Modifier modifier52 = modifier3;
                            m16992TwoRowsTopAppBartjU4iQQ(modifier52, title, textStyleFromToken2, MediumTitleBottomPadding, title, TypographyKt.fromToken(typography22, topAppBarSmallTokens2.getHeadlineFont()), function23, function33, windowInsets4, topAppBarColors2, topAppBarMediumTokens2.m17922getContainerHeightD9Ej5fM(), topAppBarSmallTokens2.m17932getContainerHeightD9Ej5fM(), topAppBarScrollBehavior2, composer42, ((i122 >> 3) & 14) | 3072 | ((i122 << 3) & 112) | (i132 & 57344) | (i132 & 3670016) | (i132 & 29360128) | (i132 & 234881024) | (i132 & 1879048192), ((i122 >> 12) & 896) | 54, 0);
                            composer3 = composer42;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier52;
                            function24 = function23;
                            function34 = function33;
                            windowInsets5 = windowInsets4;
                            topAppBarColors3 = topAppBarColors2;
                        }
                    }
                    final TopAppBarScrollBehavior topAppBarScrollBehavior32 = topAppBarScrollBehavior2;
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function32 = function3;
                if ((i & 57344) != 0) {
                }
                if ((458752 & i) != 0) {
                }
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((2995931 & i4) == 599186) {
                }
                final TopAppBarScrollBehavior topAppBarScrollBehavior322 = topAppBarScrollBehavior2;
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function22 = function2;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            function32 = function3;
            if ((i & 57344) != 0) {
            }
            if ((458752 & i) != 0) {
            }
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((2995931 & i4) == 599186) {
            }
            final TopAppBarScrollBehavior topAppBarScrollBehavior3222 = topAppBarScrollBehavior2;
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function22 = function2;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        function32 = function3;
        if ((i & 57344) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((2995931 & i4) == 599186) {
        }
        final TopAppBarScrollBehavior topAppBarScrollBehavior32222 = topAppBarScrollBehavior2;
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0278 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f6  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SingleRowTopAppBar(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function22, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final int i4;
        final float f;
        boolean zChanged;
        Object objRememberedValue;
        Modifier modifierDraggable$default;
        TopAppBarState state;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        int i6;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(1841601619);
        int i8 = i2 & 1;
        if (i8 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                i4 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    i4 |= composerStartRestartGroup.changed(textStyle) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        i4 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                    }
                    if ((i2 & 16) == 0) {
                        i4 |= 24576;
                    } else {
                        if ((57344 & i) == 0) {
                            i4 |= composerStartRestartGroup.changed(function22) ? 16384 : 8192;
                        }
                        if ((i2 & 32) == 0) {
                            i7 = (458752 & i) == 0 ? composerStartRestartGroup.changed(function3) ? 131072 : 65536 : 196608;
                            if ((i2 & 64) == 0) {
                                i4 |= 1572864;
                            } else {
                                if ((3670016 & i) == 0) {
                                    i4 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
                                }
                                if ((i2 & 128) == 0) {
                                    i6 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(topAppBarColors) ? 8388608 : 4194304 : 12582912;
                                    if ((i2 & 256) != 0) {
                                        i5 = (234881024 & i) == 0 ? composerStartRestartGroup.changed(topAppBarScrollBehavior) ? 67108864 : 33554432 : 100663296;
                                        if ((191739611 & i4) == 38347922 && composerStartRestartGroup.getSkipping()) {
                                            composerStartRestartGroup.skipToGroupEnd();
                                        } else {
                                            if (i8 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1841601619, i4, -1, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:982)");
                                            }
                                            f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m17932getContainerHeightD9Ej5fM());
                                            Float fValueOf = Float.valueOf(f);
                                            composerStartRestartGroup.startReplaceableGroup(511388516);
                                            zChanged = composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(topAppBarScrollBehavior);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
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
                                                        TopAppBarState state2;
                                                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                                        if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), f)) {
                                                            return;
                                                        }
                                                        TopAppBarScrollBehavior topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                                        TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                                                        if (state3 == null) {
                                                            return;
                                                        }
                                                        state3.setHeightOffsetLimit(f);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            composerStartRestartGroup.endReplaceableGroup();
                                            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                                            State stateM15287animateColorAsStateKTwxG1Y = SingleValueAnimationKt.m15287animateColorAsStateKTwxG1Y(topAppBarColors.m17466containerColorXeAY9LY$material3_release(((topAppBarScrollBehavior != null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction()) <= 0.01f ? 1.0f : 0.0f, composerStartRestartGroup, (i4 >> 18) & 112), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, composerStartRestartGroup, 48, 4);
                                            final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1520880938, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer2, int i9) {
                                                    if ((i9 & 11) == 2 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1520880938, i9, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1015)");
                                                    }
                                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                                    int i10 = ((i4 >> 6) & 7168) | 432;
                                                    composer2.startReplaceableGroup(693286680);
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer2, 54);
                                                    Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
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
                                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                                    composer2.startReplaceableGroup(-678309503);
                                                    function32.invoke(RowScopeInstance.INSTANCE, composer2, Integer.valueOf(((i10 >> 6) & 112) | 6));
                                                    composer2.endReplaceableGroup();
                                                    composer2.endReplaceableGroup();
                                                    composer2.endNode();
                                                    composer2.endReplaceableGroup();
                                                    composer2.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            composerStartRestartGroup.startReplaceableGroup(-1008378142);
                                            if (topAppBarScrollBehavior != null || topAppBarScrollBehavior.getIsPinned()) {
                                                modifierDraggable$default = Modifier.INSTANCE;
                                            } else {
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                Orientation orientation = Orientation.Vertical;
                                                composerStartRestartGroup.startReplaceableGroup(1157296644);
                                                boolean zChanged2 = composerStartRestartGroup.changed(topAppBarScrollBehavior);
                                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue2 = new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Float f4) {
                                                            invoke(f4.floatValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(float f4) {
                                                            topAppBarScrollBehavior.getState().setHeightOffset(topAppBarScrollBehavior.getState().getHeightOffset() + f4);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                                }
                                                composerStartRestartGroup.endReplaceableGroup();
                                                DraggableState draggableStateRememberDraggableState = DraggableKt.rememberDraggableState((Function1) objRememberedValue2, composerStartRestartGroup, 0);
                                                composerStartRestartGroup.startReplaceableGroup(1157296644);
                                                boolean zChanged3 = composerStartRestartGroup.changed(topAppBarScrollBehavior);
                                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue3 = new AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1(topAppBarScrollBehavior, null);
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                }
                                                composerStartRestartGroup.endReplaceableGroup();
                                                modifierDraggable$default = DraggableKt.draggable$default(companion, draggableStateRememberDraggableState, orientation, false, null, false, null, (Function3) objRememberedValue3, false, STBorder.INT_X_ILLUSIONS, null);
                                            }
                                            composerStartRestartGroup.endReplaceableGroup();
                                            final int i9 = i4;
                                            SurfaceKt.m17325SurfaceT9BRK9s(modifier2.then(modifierDraggable$default), null, m16990SingleRowTopAppBar$lambda3(stateM15287animateColorAsStateKTwxG1Y), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 376925230, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.SingleRowTopAppBar.2
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

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer2, int i10) {
                                                    TopAppBarState state2;
                                                    if ((i10 & 11) == 2 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(376925230, i10, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1047)");
                                                    }
                                                    Object objConsume = composer2.consume(CompositionLocalsKt.getLocalDensity());
                                                    TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                                    float heightOffset = ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()) + ((Density) objConsume).mo15546toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m17932getContainerHeightD9Ej5fM());
                                                    Modifier modifierClipToBounds = ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, windowInsets));
                                                    long jM17468getNavigationIconContentColor0d7_KjU$material3_release = topAppBarColors.getNavigationIconContentColor();
                                                    long jM17469getTitleContentColor0d7_KjU$material3_release = topAppBarColors.getTitleContentColor();
                                                    long jM17467getActionIconContentColor0d7_KjU$material3_release = topAppBarColors.getActionIconContentColor();
                                                    Function2<Composer, Integer, Unit> function23 = function2;
                                                    TextStyle textStyle2 = textStyle;
                                                    Arrangement arrangement = Arrangement.INSTANCE;
                                                    Arrangement.HorizontalOrVertical center = arrangement.getCenter();
                                                    Arrangement.Horizontal center2 = z ? arrangement.getCenter() : arrangement.getStart();
                                                    Function2<Composer, Integer, Unit> function24 = function22;
                                                    Function2<Composer, Integer, Unit> function25 = composableLambda;
                                                    int i11 = i9;
                                                    AppBarKt.m16991TopAppBarLayoutkXwM9vE(modifierClipToBounds, heightOffset, jM17468getNavigationIconContentColor0d7_KjU$material3_release, jM17469getTitleContentColor0d7_KjU$material3_release, jM17467getActionIconContentColor0d7_KjU$material3_release, function23, textStyle2, 1.0f, center, center2, 0, false, function24, function25, composer2, ((i11 << 12) & 458752) | 113246208 | ((i11 << 12) & 3670016), ((i11 >> 6) & 896) | 3126);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composerStartRestartGroup, 12582912, 122);
                                            composerStartRestartGroup = composerStartRestartGroup;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                        if (scopeUpdateScopeEndRestartGroup == null) {
                                            return;
                                        }
                                        final Modifier modifier3 = modifier2;
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.SingleRowTopAppBar.3
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

                                            public final void invoke(@Nullable Composer composer2, int i10) {
                                                AppBarKt.SingleRowTopAppBar(modifier3, function2, textStyle, z, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer2, i | 1, i2);
                                            }
                                        });
                                        return;
                                    }
                                    i4 |= i5;
                                    if ((191739611 & i4) == 38347922) {
                                        if (i8 != 0) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m17932getContainerHeightD9Ej5fM());
                                        Float fValueOf2 = Float.valueOf(f);
                                        composerStartRestartGroup.startReplaceableGroup(511388516);
                                        zChanged = composerStartRestartGroup.changed(fValueOf2) | composerStartRestartGroup.changed(topAppBarScrollBehavior);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (!zChanged) {
                                            objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
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
                                                    TopAppBarState state2;
                                                    TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                                    if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), f)) {
                                                        return;
                                                    }
                                                    TopAppBarScrollBehavior topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                                    TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                                                    if (state3 == null) {
                                                        return;
                                                    }
                                                    state3.setHeightOffsetLimit(f);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            composerStartRestartGroup.endReplaceableGroup();
                                            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                                            if (topAppBarScrollBehavior != null) {
                                                State stateM15287animateColorAsStateKTwxG1Y2 = SingleValueAnimationKt.m15287animateColorAsStateKTwxG1Y(topAppBarColors.m17466containerColorXeAY9LY$material3_release(((topAppBarScrollBehavior != null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction()) <= 0.01f ? 1.0f : 0.0f, composerStartRestartGroup, (i4 >> 18) & 112), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, composerStartRestartGroup, 48, 4);
                                                final Function2<? super Composer, ? super Integer, Unit> composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1520880938, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @Composable
                                                    public final void invoke(@Nullable Composer composer2, int i92) {
                                                        if ((i92 & 11) == 2 && composer2.getSkipping()) {
                                                            composer2.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1520880938, i92, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1015)");
                                                        }
                                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                                        int i10 = ((i4 >> 6) & 7168) | 432;
                                                        composer2.startReplaceableGroup(693286680);
                                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer2, 54);
                                                        Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor = companion22.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion22, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                                        composer2.startReplaceableGroup(-678309503);
                                                        function32.invoke(RowScopeInstance.INSTANCE, composer2, Integer.valueOf(((i10 >> 6) & 112) | 6));
                                                        composer2.endReplaceableGroup();
                                                        composer2.endReplaceableGroup();
                                                        composer2.endNode();
                                                        composer2.endReplaceableGroup();
                                                        composer2.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                });
                                                composerStartRestartGroup.startReplaceableGroup(-1008378142);
                                                if (topAppBarScrollBehavior != null) {
                                                    modifierDraggable$default = Modifier.INSTANCE;
                                                    composerStartRestartGroup.endReplaceableGroup();
                                                    final int i92 = i4;
                                                    SurfaceKt.m17325SurfaceT9BRK9s(modifier2.then(modifierDraggable$default), null, m16990SingleRowTopAppBar$lambda3(stateM15287animateColorAsStateKTwxG1Y2), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 376925230, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.SingleRowTopAppBar.2
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

                                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                        @Composable
                                                        public final void invoke(@Nullable Composer composer2, int i10) {
                                                            TopAppBarState state2;
                                                            if ((i10 & 11) == 2 && composer2.getSkipping()) {
                                                                composer2.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(376925230, i10, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1047)");
                                                            }
                                                            Object objConsume = composer2.consume(CompositionLocalsKt.getLocalDensity());
                                                            TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                                            float heightOffset = ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()) + ((Density) objConsume).mo15546toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m17932getContainerHeightD9Ej5fM());
                                                            Modifier modifierClipToBounds = ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, windowInsets));
                                                            long jM17468getNavigationIconContentColor0d7_KjU$material3_release = topAppBarColors.getNavigationIconContentColor();
                                                            long jM17469getTitleContentColor0d7_KjU$material3_release = topAppBarColors.getTitleContentColor();
                                                            long jM17467getActionIconContentColor0d7_KjU$material3_release = topAppBarColors.getActionIconContentColor();
                                                            Function2<Composer, Integer, Unit> function23 = function2;
                                                            TextStyle textStyle2 = textStyle;
                                                            Arrangement arrangement = Arrangement.INSTANCE;
                                                            Arrangement.HorizontalOrVertical center = arrangement.getCenter();
                                                            Arrangement.Horizontal center2 = z ? arrangement.getCenter() : arrangement.getStart();
                                                            Function2<Composer, Integer, Unit> function24 = function22;
                                                            Function2<Composer, Integer, Unit> function25 = composableLambda2;
                                                            int i11 = i92;
                                                            AppBarKt.m16991TopAppBarLayoutkXwM9vE(modifierClipToBounds, heightOffset, jM17468getNavigationIconContentColor0d7_KjU$material3_release, jM17469getTitleContentColor0d7_KjU$material3_release, jM17467getActionIconContentColor0d7_KjU$material3_release, function23, textStyle2, 1.0f, center, center2, 0, false, function24, function25, composer2, ((i11 << 12) & 458752) | 113246208 | ((i11 << 12) & 3670016), ((i11 >> 6) & 896) | 3126);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }), composerStartRestartGroup, 12582912, 122);
                                                    composerStartRestartGroup = composerStartRestartGroup;
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                    }
                                }
                                i4 |= i6;
                                if ((i2 & 256) != 0) {
                                }
                                i4 |= i5;
                                if ((191739611 & i4) == 38347922) {
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            if ((i2 & 128) == 0) {
                            }
                            i4 |= i6;
                            if ((i2 & 256) != 0) {
                            }
                            i4 |= i5;
                            if ((191739611 & i4) == 38347922) {
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i4 |= i7;
                        if ((i2 & 64) == 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        i4 |= i6;
                        if ((i2 & 256) != 0) {
                        }
                        i4 |= i5;
                        if ((191739611 & i4) == 38347922) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    if ((i2 & 32) == 0) {
                    }
                    i4 |= i7;
                    if ((i2 & 64) == 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    i4 |= i6;
                    if ((i2 & 256) != 0) {
                    }
                    i4 |= i5;
                    if ((191739611 & i4) == 38347922) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                if ((i2 & 16) == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                i4 |= i7;
                if ((i2 & 64) == 0) {
                }
                if ((i2 & 128) == 0) {
                }
                i4 |= i6;
                if ((i2 & 256) != 0) {
                }
                i4 |= i5;
                if ((191739611 & i4) == 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            i4 |= i7;
            if ((i2 & 64) == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            i4 |= i6;
            if ((i2 & 256) != 0) {
            }
            i4 |= i5;
            if ((191739611 & i4) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i4 |= i7;
        if ((i2 & 64) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        i4 |= i6;
        if ((i2 & 256) != 0) {
        }
        i4 |= i5;
        if ((191739611 & i4) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: renamed from: SingleRowTopAppBar$lambda-3, reason: not valid java name */
    private static final long m16990SingleRowTopAppBar$lambda3(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x019d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011e  */
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use TopAppBar instead.", replaceWith = @ReplaceWith(expression = "TopAppBar(title, modifier, navigationIcon, actions, windowInsets, colors, scrollBehavior)", imports = {}))
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SmallTopAppBar(@NotNull final Function2<? super Composer, ? super Integer, Unit> title, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable WindowInsets windowInsets, @Nullable TopAppBarColors topAppBarColors, @Nullable TopAppBarScrollBehavior topAppBarScrollBehavior, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function2M17109getLambda3$material3_release;
        int i6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M17110getLambda4$material3_release;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier modifier3;
        WindowInsets windowInsets3;
        Composer composer2;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function22;
        TopAppBarColors topAppBarColors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        final TopAppBarColors topAppBarColors3;
        final WindowInsets windowInsets4;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1967617284);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    function2M17109getLambda3$material3_release = function2;
                    i4 |= composerStartRestartGroup.changed(function2M17109getLambda3$material3_release) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        function3M17110getLambda4$material3_release = function3;
                        i4 |= composerStartRestartGroup.changed(function3M17110getLambda4$material3_release) ? 2048 : 1024;
                    }
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            int i10 = composerStartRestartGroup.changed(windowInsets2) ? 16384 : 8192;
                            i4 |= i10;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i4 |= i10;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColorsM17473smallTopAppBarColorszjMxDiM = topAppBarColors;
                            int i11 = composerStartRestartGroup.changed(topAppBarColorsM17473smallTopAppBarColorszjMxDiM) ? 131072 : 65536;
                            i4 |= i11;
                        } else {
                            topAppBarColorsM17473smallTopAppBarColorszjMxDiM = topAppBarColors;
                        }
                        i4 |= i11;
                    } else {
                        topAppBarColorsM17473smallTopAppBarColorszjMxDiM = topAppBarColors;
                    }
                    i7 = i2 & 64;
                    if (i7 != 0) {
                        if ((3670016 & i) == 0) {
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            i4 |= composerStartRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        }
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            function23 = function2M17109getLambda3$material3_release;
                            composer2 = composerStartRestartGroup;
                            function32 = function3M17110getLambda4$material3_release;
                            windowInsets4 = windowInsets2;
                            topAppBarColors3 = topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    function2M17109getLambda3$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m17109getLambda3$material3_release();
                                }
                                if (i6 != 0) {
                                    function3M17110getLambda4$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m17110getLambda4$material3_release();
                                }
                                if ((i2 & 16) == 0) {
                                    windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                    i4 &= -57345;
                                } else {
                                    windowInsets3 = windowInsets2;
                                }
                                if ((i2 & 32) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    i4 &= -458753;
                                    topAppBarColorsM17473smallTopAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m17473smallTopAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, 196608, 31);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i7 == 0) {
                                    i8 = i4;
                                    function22 = function2M17109getLambda3$material3_release;
                                    topAppBarScrollBehavior3 = null;
                                    topAppBarColors2 = topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
                                } else {
                                    i8 = i4;
                                    function22 = function2M17109getLambda3$material3_release;
                                    topAppBarColors2 = topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                modifier3 = modifier2;
                                composer2 = composerStartRestartGroup;
                                windowInsets3 = windowInsets2;
                                topAppBarColors2 = topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
                                i8 = i4;
                                function22 = function2M17109getLambda3$material3_release;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1967617284, i8, -1, "androidx.compose.material3.SmallTopAppBar (AppBar.kt:183)");
                            }
                            Modifier modifier5 = modifier3;
                            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function3M17110getLambda4$material3_release;
                            TopAppBar(title, modifier5, function22, function33, windowInsets3, topAppBarColors2, topAppBarScrollBehavior3, composer2, i8 & 4194302, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                            topAppBarColors3 = topAppBarColors2;
                            windowInsets4 = windowInsets3;
                            function32 = function33;
                            function23 = function22;
                            modifier4 = modifier5;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.SmallTopAppBar.1
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

                            public final void invoke(@Nullable Composer composer3, int i12) {
                                AppBarKt.SmallTopAppBar(title, modifier4, function23, function32, windowInsets4, topAppBarColors3, topAppBarScrollBehavior4, composer3, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 1572864;
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((2995931 & i4) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i7 == 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Modifier modifier52 = modifier3;
                            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function332 = function3M17110getLambda4$material3_release;
                            TopAppBar(title, modifier52, function22, function332, windowInsets3, topAppBarColors2, topAppBarScrollBehavior3, composer2, i8 & 4194302, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                            topAppBarColors3 = topAppBarColors2;
                            windowInsets4 = windowInsets3;
                            function32 = function332;
                            function23 = function22;
                            modifier4 = modifier52;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function3M17110getLambda4$material3_release = function3;
                if ((57344 & i) != 0) {
                }
                if ((458752 & i) != 0) {
                }
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((2995931 & i4) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function2M17109getLambda3$material3_release = function2;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            function3M17110getLambda4$material3_release = function3;
            if ((57344 & i) != 0) {
            }
            if ((458752 & i) != 0) {
            }
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((2995931 & i4) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function2M17109getLambda3$material3_release = function2;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        function3M17110getLambda4$material3_release = function3;
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((2995931 & i4) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TopAppBar(@NotNull final Function2<? super Composer, ? super Integer, Unit> title, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable WindowInsets windowInsets, @Nullable TopAppBarColors topAppBarColors, @Nullable TopAppBarScrollBehavior topAppBarScrollBehavior, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function2M17104getLambda1$material3_release;
        int i6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M17108getLambda2$material3_release;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        final WindowInsets windowInsets4;
        final TopAppBarColors topAppBarColors3;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(1906353009);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    function2M17104getLambda1$material3_release = function2;
                    i4 |= composerStartRestartGroup.changed(function2M17104getLambda1$material3_release) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        function3M17108getLambda2$material3_release = function3;
                        i4 |= composerStartRestartGroup.changed(function3M17108getLambda2$material3_release) ? 2048 : 1024;
                    }
                    if ((i & 57344) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            int i9 = composerStartRestartGroup.changed(windowInsets2) ? 16384 : 8192;
                            i4 |= i9;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i4 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((i & 458752) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColorsM17473smallTopAppBarColorszjMxDiM = topAppBarColors;
                            int i10 = composerStartRestartGroup.changed(topAppBarColorsM17473smallTopAppBarColorszjMxDiM) ? 131072 : 65536;
                            i4 |= i10;
                        } else {
                            topAppBarColorsM17473smallTopAppBarColorszjMxDiM = topAppBarColors;
                        }
                        i4 |= i10;
                    } else {
                        topAppBarColorsM17473smallTopAppBarColorszjMxDiM = topAppBarColors;
                    }
                    i7 = i2 & 64;
                    if (i7 != 0) {
                        if ((i & 3670016) == 0) {
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            i4 |= composerStartRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        }
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            function23 = function2M17104getLambda1$material3_release;
                            function33 = function3M17108getLambda2$material3_release;
                            windowInsets4 = windowInsets2;
                            topAppBarColors3 = topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    function2M17104getLambda1$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m17104getLambda1$material3_release();
                                }
                                if (i6 != 0) {
                                    function3M17108getLambda2$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m17108getLambda2$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                    topAppBarColorsM17473smallTopAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m17473smallTopAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196608, 31);
                                }
                                if (i7 == 0) {
                                    function32 = function3M17108getLambda2$material3_release;
                                    topAppBarColors2 = topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
                                    topAppBarScrollBehavior3 = null;
                                    function22 = function2M17104getLambda1$material3_release;
                                    windowInsets3 = windowInsets2;
                                } else {
                                    function22 = function2M17104getLambda1$material3_release;
                                    function32 = function3M17108getLambda2$material3_release;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors2 = topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                modifier3 = modifier2;
                                function22 = function2M17104getLambda1$material3_release;
                                function32 = function3M17108getLambda2$material3_release;
                                windowInsets3 = windowInsets2;
                                topAppBarColors2 = topAppBarColorsM17473smallTopAppBarColorszjMxDiM;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1906353009, i4, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:120)");
                            }
                            int i11 = i4 << 6;
                            int i12 = (i11 & 234881024) | (i11 & 57344) | ((i4 >> 3) & 14) | 3072 | ((i4 << 3) & 112) | (i11 & 458752) | (i11 & 3670016) | (29360128 & i11);
                            Modifier modifier5 = modifier3;
                            SingleRowTopAppBar(modifier5, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function22, function32, windowInsets3, topAppBarColors2, topAppBarScrollBehavior3, composerStartRestartGroup, i12, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            function23 = function22;
                            function33 = function32;
                            windowInsets4 = windowInsets3;
                            topAppBarColors3 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.TopAppBar.1
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

                            public final void invoke(@Nullable Composer composer2, int i13) {
                                AppBarKt.TopAppBar(title, modifier4, function23, function33, windowInsets4, topAppBarColors3, topAppBarScrollBehavior4, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 1572864;
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((2995931 & i4) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i2 & 16) != 0) {
                            }
                            if ((i2 & 32) != 0) {
                            }
                            if (i7 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i112 = i4 << 6;
                            int i122 = (i112 & 234881024) | (i112 & 57344) | ((i4 >> 3) & 14) | 3072 | ((i4 << 3) & 112) | (i112 & 458752) | (i112 & 3670016) | (29360128 & i112);
                            Modifier modifier52 = modifier3;
                            SingleRowTopAppBar(modifier52, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function22, function32, windowInsets3, topAppBarColors2, topAppBarScrollBehavior3, composerStartRestartGroup, i122, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier52;
                            function23 = function22;
                            function33 = function32;
                            windowInsets4 = windowInsets3;
                            topAppBarColors3 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function3M17108getLambda2$material3_release = function3;
                if ((i & 57344) != 0) {
                }
                if ((i & 458752) != 0) {
                }
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((2995931 & i4) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function2M17104getLambda1$material3_release = function2;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            function3M17108getLambda2$material3_release = function3;
            if ((i & 57344) != 0) {
            }
            if ((i & 458752) != 0) {
            }
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((2995931 & i4) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function2M17104getLambda1$material3_release = function2;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        function3M17108getLambda2$material3_release = function3;
        if ((i & 57344) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((2995931 & i4) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: TopAppBarLayout-kXwM9vE, reason: not valid java name */
    public static final void m16991TopAppBarLayoutkXwM9vE(final Modifier modifier, final float f, final long j, final long j2, final long j3, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final float f4, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final int i, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i2, final int i4) {
        int i5;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-6794037);
        if ((i2 & 14) == 0) {
            i5 = i2 | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(j3) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(function2) ? 131072 : 65536;
        }
        if ((i2 & 3670016) == 0) {
            i5 |= composerStartRestartGroup.changed(textStyle) ? 1048576 : 524288;
        }
        if ((i2 & 29360128) == 0) {
            i5 |= composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
        }
        if ((i2 & 234881024) == 0) {
            i5 |= composerStartRestartGroup.changed(vertical) ? 67108864 : 33554432;
        }
        if ((i2 & 1879048192) == 0) {
            i5 |= composerStartRestartGroup.changed(horizontal) ? 536870912 : 268435456;
        }
        final int i7 = i5;
        if ((i4 & 14) == 0) {
            i6 = i4 | (composerStartRestartGroup.changed(i) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 112) == 0) {
            i6 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i6 |= composerStartRestartGroup.changed(function22) ? 256 : 128;
        }
        if ((i4 & 7168) == 0) {
            i6 |= composerStartRestartGroup.changed(function23) ? 2048 : 1024;
        }
        int i8 = i6;
        if ((1533916891 & i7) == 306783378 && (i8 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6794037, i7, i8, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:1238)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> measurables, final long j5) {
                    final MeasureScope Layout = measureScope;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    for (Measurable measurable : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "navigationIcon")) {
                            final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j5, 0, 0, 0, 0, 14, null));
                            for (Measurable measurable2 : list) {
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "actionIcons")) {
                                    final Placeable placeableMo19855measureBRTryo02 = measurable2.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j5, 0, 0, 0, 0, 14, null));
                                    int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j5) == Integer.MAX_VALUE ? Constraints.m20921getMaxWidthimpl(j5) : RangesKt.coerceAtLeast((Constraints.m20921getMaxWidthimpl(j5) - placeableMo19855measureBRTryo0.getWidth()) - placeableMo19855measureBRTryo02.getWidth(), 0);
                                    for (Measurable measurable3 : list) {
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "title")) {
                                            final Placeable placeableMo19855measureBRTryo03 = measurable3.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j5, 0, iM20921getMaxWidthimpl, 0, 0, 12, null));
                                            final int i9 = placeableMo19855measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? placeableMo19855measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) : 0;
                                            final int iRoundToInt = MathKt.roundToInt(f);
                                            int iM20921getMaxWidthimpl2 = Constraints.m20921getMaxWidthimpl(j5);
                                            final Arrangement.Horizontal horizontal2 = horizontal;
                                            final Arrangement.Vertical vertical2 = vertical;
                                            final int i10 = i;
                                            return MeasureScope.layout$default(measureScope, iM20921getMaxWidthimpl2, iRoundToInt, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$measure$1
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
                                                    int i11;
                                                    int height;
                                                    int iMax;
                                                    int iM1197B;
                                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                    Placeable placeable = placeableMo19855measureBRTryo0;
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, AbstractC1038a.m1197B(placeable, iRoundToInt, 2), 0.0f, 4, null);
                                                    Placeable placeable2 = placeableMo19855measureBRTryo03;
                                                    Arrangement.Horizontal horizontal3 = horizontal2;
                                                    Arrangement arrangement = Arrangement.INSTANCE;
                                                    int iM1205f = Intrinsics.areEqual(horizontal3, arrangement.getCenter()) ? AbstractC1038a.m1205f(placeableMo19855measureBRTryo03, Constraints.m20921getMaxWidthimpl(j5), 2) : Intrinsics.areEqual(horizontal3, arrangement.getEnd()) ? (Constraints.m20921getMaxWidthimpl(j5) - placeableMo19855measureBRTryo03.getWidth()) - placeableMo19855measureBRTryo02.getWidth() : Math.max(Layout.mo15540roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), placeableMo19855measureBRTryo0.getWidth());
                                                    Arrangement.Vertical vertical3 = vertical2;
                                                    if (Intrinsics.areEqual(vertical3, arrangement.getCenter())) {
                                                        iM1197B = AbstractC1038a.m1197B(placeableMo19855measureBRTryo03, iRoundToInt, 2);
                                                    } else if (!Intrinsics.areEqual(vertical3, arrangement.getBottom())) {
                                                        i11 = 0;
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeable2, iM1205f, i11, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo02, Constraints.m20921getMaxWidthimpl(j5) - placeableMo19855measureBRTryo02.getWidth(), AbstractC1038a.m1197B(placeableMo19855measureBRTryo02, iRoundToInt, 2), 0.0f, 4, null);
                                                    } else {
                                                        if (i10 == 0) {
                                                            height = iRoundToInt;
                                                            iMax = placeableMo19855measureBRTryo03.getHeight();
                                                        } else {
                                                            height = iRoundToInt - placeableMo19855measureBRTryo03.getHeight();
                                                            iMax = Math.max(0, (i10 - placeableMo19855measureBRTryo03.getHeight()) + i9);
                                                        }
                                                        iM1197B = height - iMax;
                                                    }
                                                    i11 = iM1197B;
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeable2, iM1205f, i11, 0.0f, 4, null);
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo19855measureBRTryo02, Constraints.m20921getMaxWidthimpl(j5) - placeableMo19855measureBRTryo02.getWidth(), AbstractC1038a.m1197B(placeableMo19855measureBRTryo02, iRoundToInt, 2), 0.0f, 4, null);
                                                }
                                            }, 4, null);
                                        }
                                        Layout = measureScope;
                                    }
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                }
                                Layout = measureScope;
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        Layout = measureScope;
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
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
            Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(1688650562);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion2, "navigationIcon");
            float f5 = TopAppBarHorizontalPadding;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(modifierLayoutId, f5, 0.0f, 0.0f, 0.0f, 14, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1034743112);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j))}, function22, composerStartRestartGroup, ((i8 >> 3) & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen = PaddingKt.m15856paddingVpY3zN4$default(LayoutIdKt.layoutId(companion2, "title"), f5, 0.0f, 2, null).then(z ? SemanticsModifierKt.clearAndSetSemantics(companion2, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SemanticsPropertyReceiver clearAndSetSemantics) {
                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            }) : companion2);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierThen);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            composerStartRestartGroup.startReplaceableGroup(-280006401);
            TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 824316656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$3$1
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

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i9) {
                    if ((i9 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(824316656, i9, -1, "androidx.compose.material3.TopAppBarLayout.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:1272)");
                    }
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(Color.m18524copywmQWz5c$default(j2, f4, 0.0f, 0.0f, 0.0f, 14, null)))}, function2, composer2, ((i7 >> 12) & 112) | 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, ((i7 >> 18) & 14) | 48);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM15858paddingqDBjuR0$default2 = PaddingKt.m15858paddingqDBjuR0$default(LayoutIdKt.layoutId(companion2, "actionIcons"), 0.0f, 0.0f, f5, 0.0f, 11, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
            Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor4 = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default2);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl4, measurePolicyM1210k3, composerM18018constructorimpl4, density4));
            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            composerStartRestartGroup.startReplaceableGroup(1192272192);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j3))}, function23, composerStartRestartGroup, ((i8 >> 6) & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$3
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

            public final void invoke(@Nullable Composer composer2, int i9) {
                AppBarKt.m16991TopAppBarLayoutkXwM9vE(modifier, f, j, j2, j3, function2, textStyle, f4, vertical, horizontal, i, z, function22, function23, composer2, i2 | 1, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0334 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012b  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: TwoRowsTopAppBar-tjU4iQQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16992TwoRowsTopAppBartjU4iQQ(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function22, final TextStyle textStyle2, final Function2<? super Composer, ? super Integer, Unit> function23, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final float f4, final float f5, final TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2, final int i4) {
        Modifier modifier2;
        final int i5;
        TextStyle textStyle3;
        int i6;
        int i7;
        int i8;
        Modifier modifierDraggable$default;
        Composer composer2;
        final Modifier modifier3;
        TopAppBarState state;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(210227552);
        int i10 = i4 & 1;
        if (i10 != 0) {
            i5 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else {
            if ((i & 896) == 0) {
                textStyle3 = textStyle;
                i5 |= composerStartRestartGroup.changed(textStyle3) ? 256 : 128;
            }
            if ((i4 & 8) == 0) {
                i5 |= 3072;
            } else if ((i & 7168) == 0) {
                i5 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
            }
            if ((i4 & 16) == 0) {
                i5 |= 24576;
            } else {
                if ((57344 & i) == 0) {
                    i5 |= composerStartRestartGroup.changed(function22) ? 16384 : 8192;
                }
                if ((i4 & 32) != 0) {
                    i5 |= 196608;
                } else if ((i & 458752) == 0) {
                    i5 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                }
                if ((i4 & 64) != 0) {
                    i5 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i5 |= composerStartRestartGroup.changed(function23) ? 1048576 : 524288;
                }
                if ((i4 & 128) == 0) {
                    i9 = (i & 29360128) == 0 ? composerStartRestartGroup.changed(function3) ? 8388608 : 4194304 : 12582912;
                    if ((i4 & 256) == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i & 234881024) == 0) {
                            i5 |= composerStartRestartGroup.changed(windowInsets) ? 67108864 : 33554432;
                        }
                        if ((i4 & 512) == 0) {
                            if ((i & 1879048192) == 0) {
                                i6 = composerStartRestartGroup.changed(topAppBarColors) ? 536870912 : 268435456;
                            }
                            if ((i4 & 1024) == 0) {
                                i7 = i2 | 6;
                            } else if ((i2 & 14) == 0) {
                                i7 = i2 | (composerStartRestartGroup.changed(f4) ? 4 : 2);
                            } else {
                                i7 = i2;
                            }
                            int i11 = i7;
                            if ((i4 & 2048) == 0) {
                                i8 = i11 | 48;
                            } else if ((i2 & 112) == 0) {
                                i8 = i11 | (composerStartRestartGroup.changed(f5) ? 32 : 16);
                            } else {
                                i8 = i11;
                            }
                            if ((i4 & 4096) == 0) {
                                i8 |= 384;
                            } else if ((i2 & 896) == 0) {
                                i8 |= composerStartRestartGroup.changed(topAppBarScrollBehavior) ? 256 : 128;
                            }
                            if ((1533916891 & i5) != 306783378 && (i8 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                composer2 = composerStartRestartGroup;
                                modifier3 = modifier2;
                            } else {
                                Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(210227552, i5, i8, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1084)");
                                }
                                if (C2256Dp.m20967compareTo0680j_4(f4, f5) > 0) {
                                    throw new IllegalArgumentException("A TwoRowsTopAppBar max height should be greater than its pinned height");
                                }
                                final Ref.FloatRef floatRef = new Ref.FloatRef();
                                final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                                final Ref.IntRef intRef = new Ref.IntRef();
                                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                floatRef.element = density.mo15546toPx0680j_4(f5);
                                floatRef2.element = density.mo15546toPx0680j_4(f4);
                                intRef.element = density.mo15540roundToPx0680j_4(f);
                                Unit unit = Unit.INSTANCE;
                                Float fValueOf = Float.valueOf(floatRef.element);
                                Float fValueOf2 = Float.valueOf(floatRef2.element);
                                composerStartRestartGroup.startReplaceableGroup(1618982084);
                                boolean zChanged = composerStartRestartGroup.changed(topAppBarScrollBehavior) | composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(fValueOf2);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1
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
                                            TopAppBarState state2;
                                            TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                            if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), floatRef.element - floatRef2.element)) {
                                                return;
                                            }
                                            TopAppBarScrollBehavior topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                            TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                                            if (state3 == null) {
                                                return;
                                            }
                                            state3.setHeightOffsetLimit(floatRef.element - floatRef2.element);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                                float collapsedFraction = (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getCollapsedFraction();
                                final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(topAppBarColors.m17466containerColorXeAY9LY$material3_release(collapsedFraction, composerStartRestartGroup, (i5 >> 24) & 112)), composerStartRestartGroup, 0);
                                final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1048401111, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
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

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer3, int i12) {
                                        if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1048401111, i12, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1130)");
                                        }
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        int i13 = ((i5 >> 12) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                                        Density density2 = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                                        if (composer3.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density2));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        function32.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i13 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                final float fTransform = TopTitleAlphaEasing.transform(collapsedFraction);
                                final float f6 = 1.0f - collapsedFraction;
                                final boolean z = collapsedFraction < 0.5f;
                                final boolean z2 = !z;
                                composerStartRestartGroup.startReplaceableGroup(-1609667638);
                                if (topAppBarScrollBehavior == null || topAppBarScrollBehavior.getIsPinned()) {
                                    modifierDraggable$default = Modifier.INSTANCE;
                                } else {
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    Orientation orientation = Orientation.Vertical;
                                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                                    boolean zChanged2 = composerStartRestartGroup.changed(topAppBarScrollBehavior);
                                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Float f7) {
                                                invoke(f7.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(float f7) {
                                                topAppBarScrollBehavior.getState().setHeightOffset(topAppBarScrollBehavior.getState().getHeightOffset() + f7);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    DraggableState draggableStateRememberDraggableState = DraggableKt.rememberDraggableState((Function1) objRememberedValue2, composerStartRestartGroup, 0);
                                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                                    boolean zChanged3 = composerStartRestartGroup.changed(topAppBarScrollBehavior);
                                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1(topAppBarScrollBehavior, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    modifierDraggable$default = DraggableKt.draggable$default(companion, draggableStateRememberDraggableState, orientation, false, null, false, null, (Function3) objRememberedValue3, false, STBorder.INT_X_ILLUSIONS, null);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                Modifier modifierThen = modifier4.then(modifierDraggable$default);
                                final TextStyle textStyle4 = textStyle3;
                                final int i12 = i5;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1985938853, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3
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

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer3, int i13) {
                                        TopAppBarState state2;
                                        if ((i13 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1985938853, i13, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1164)");
                                        }
                                        WindowInsets windowInsets2 = windowInsets;
                                        Ref.FloatRef floatRef3 = floatRef;
                                        TopAppBarColors topAppBarColors2 = topAppBarColors;
                                        Function2<Composer, Integer, Unit> function24 = function22;
                                        TextStyle textStyle5 = textStyle2;
                                        float f7 = fTransform;
                                        boolean z3 = z;
                                        Function2<Composer, Integer, Unit> function25 = function23;
                                        Function2<Composer, Integer, Unit> function26 = composableLambda;
                                        int i14 = i12;
                                        Ref.FloatRef floatRef4 = floatRef2;
                                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                        Function2<Composer, Integer, Unit> function27 = function2;
                                        TextStyle textStyle6 = textStyle4;
                                        float f8 = f6;
                                        Ref.IntRef intRef2 = intRef;
                                        boolean z4 = z2;
                                        State<Color> state3 = stateRememberUpdatedState;
                                        composer3.startReplaceableGroup(-483455358);
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, arrangement.getTop(), composer3, 0, -1323940314);
                                        Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
                                        if (composer3.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density2));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                        composer3.startReplaceableGroup(-1163856341);
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        composer3.startReplaceableGroup(80455579);
                                        int i15 = i14 << 3;
                                        AppBarKt.m16991TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(BackgroundKt.m15409backgroundbw27NRU$default(companion2, AppBarKt.m16993TwoRowsTopAppBar_tjU4iQQ$lambda8(state3), null, 2, null), windowInsets2)), floatRef3.element, topAppBarColors2.getNavigationIconContentColor(), topAppBarColors2.getTitleContentColor(), topAppBarColors2.getActionIconContentColor(), function24, textStyle5, f7, arrangement.getCenter(), arrangement.getStart(), 0, z3, function25, function26, composer3, (i15 & 458752) | 905969664 | (i15 & 3670016), ((i14 >> 12) & 896) | 3078);
                                        Modifier modifierClipToBounds = ClipKt.clipToBounds(companion2);
                                        float heightOffset = ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()) + (floatRef4.element - floatRef3.element);
                                        long navigationIconContentColor = topAppBarColors2.getNavigationIconContentColor();
                                        long titleContentColor = topAppBarColors2.getTitleContentColor();
                                        long actionIconContentColor = topAppBarColors2.getActionIconContentColor();
                                        Arrangement.Vertical bottom = arrangement.getBottom();
                                        Arrangement.Horizontal start = arrangement.getStart();
                                        int i16 = intRef2.element;
                                        ComposableSingletons$AppBarKt composableSingletons$AppBarKt = ComposableSingletons$AppBarKt.INSTANCE;
                                        Function2<Composer, Integer, Unit> function2M17106getLambda11$material3_release = composableSingletons$AppBarKt.m17106getLambda11$material3_release();
                                        Function2<Composer, Integer, Unit> function2M17107getLambda12$material3_release = composableSingletons$AppBarKt.m17107getLambda12$material3_release();
                                        int i17 = i14 << 12;
                                        AppBarKt.m16991TopAppBarLayoutkXwM9vE(modifierClipToBounds, heightOffset, navigationIconContentColor, titleContentColor, actionIconContentColor, function27, textStyle6, f8, bottom, start, i16, z4, function2M17106getLambda11$material3_release, function2M17107getLambda12$material3_release, composer3, (i17 & 458752) | 905969670 | (i17 & 3670016), 3456);
                                        if (AbstractC1038a.m1225z(composer3)) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m17325SurfaceT9BRK9s(modifierThen, null, 0L, 0L, 0.0f, 0.0f, null, composableLambda2, composer2, 12582912, 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4
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

                                public final void invoke(@Nullable Composer composer3, int i13) {
                                    AppBarKt.m16992TwoRowsTopAppBartjU4iQQ(modifier3, function2, textStyle, f, function22, textStyle2, function23, function3, windowInsets, topAppBarColors, f4, f5, topAppBarScrollBehavior, composer3, i | 1, i2, i4);
                                }
                            });
                            return;
                        }
                        i6 = DriveFile.MODE_READ_WRITE;
                        i5 |= i6;
                        if ((i4 & 1024) == 0) {
                        }
                        int i112 = i7;
                        if ((i4 & 2048) == 0) {
                        }
                        if ((i4 & 4096) == 0) {
                        }
                        if ((1533916891 & i5) != 306783378) {
                            if (i10 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (C2256Dp.m20967compareTo0680j_4(f4, f5) > 0) {
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    if ((i4 & 512) == 0) {
                    }
                    i5 |= i6;
                    if ((i4 & 1024) == 0) {
                    }
                    int i1122 = i7;
                    if ((i4 & 2048) == 0) {
                    }
                    if ((i4 & 4096) == 0) {
                    }
                    if ((1533916891 & i5) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i5 |= i9;
                if ((i4 & 256) == 0) {
                }
                if ((i4 & 512) == 0) {
                }
                i5 |= i6;
                if ((i4 & 1024) == 0) {
                }
                int i11222 = i7;
                if ((i4 & 2048) == 0) {
                }
                if ((i4 & 4096) == 0) {
                }
                if ((1533916891 & i5) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            if ((i4 & 32) != 0) {
            }
            if ((i4 & 64) != 0) {
            }
            if ((i4 & 128) == 0) {
            }
            i5 |= i9;
            if ((i4 & 256) == 0) {
            }
            if ((i4 & 512) == 0) {
            }
            i5 |= i6;
            if ((i4 & 1024) == 0) {
            }
            int i112222 = i7;
            if ((i4 & 2048) == 0) {
            }
            if ((i4 & 4096) == 0) {
            }
            if ((1533916891 & i5) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        textStyle3 = textStyle;
        if ((i4 & 8) == 0) {
        }
        if ((i4 & 16) == 0) {
        }
        if ((i4 & 32) != 0) {
        }
        if ((i4 & 64) != 0) {
        }
        if ((i4 & 128) == 0) {
        }
        i5 |= i9;
        if ((i4 & 256) == 0) {
        }
        if ((i4 & 512) == 0) {
        }
        i5 |= i6;
        if ((i4 & 1024) == 0) {
        }
        int i1122222 = i7;
        if ((i4 & 2048) == 0) {
        }
        if ((i4 & 4096) == 0) {
        }
        if ((1533916891 & i5) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TwoRowsTopAppBar_tjU4iQQ$lambda-8, reason: not valid java name */
    public static final long m16993TwoRowsTopAppBar_tjU4iQQ$lambda8(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    @NotNull
    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    @Composable
    @ExperimentalMaterial3Api
    @NotNull
    public static final TopAppBarState rememberTopAppBarState(final float f, final float f4, final float f5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1801969826);
        if ((i2 & 1) != 0) {
            f = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f5 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801969826, i, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:755)");
        }
        Object[] objArr = new Object[0];
        Saver<TopAppBarState, ?> saver = TopAppBarState.INSTANCE.getSaver();
        Float fValueOf = Float.valueOf(f);
        Float fValueOf2 = Float.valueOf(f4);
        Float fValueOf3 = Float.valueOf(f5);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(fValueOf) | composer.changed(fValueOf2) | composer.changed(fValueOf3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0<TopAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TopAppBarState invoke() {
                    return new TopAppBarState(f, f4, f5);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TopAppBarState topAppBarState = (TopAppBarState) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object settleAppBar(TopAppBarState topAppBarState, float f, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Continuation<? super Velocity> continuation) {
        C17181 c17181;
        final Ref.FloatRef floatRef;
        AnimationSpec<Float> animationSpec2;
        Ref.FloatRef floatRef2;
        final TopAppBarState topAppBarState2 = topAppBarState;
        if (continuation instanceof C17181) {
            c17181 = (C17181) continuation;
            int i = c17181.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17181.label = i - Integer.MIN_VALUE;
            } else {
                c17181 = new C17181(continuation);
            }
        }
        C17181 c171812 = c17181;
        Object obj = c171812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c171812.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (topAppBarState2.getCollapsedFraction() < 0.01f || topAppBarState2.getCollapsedFraction() == 1.0f) {
                return Velocity.m21196boximpl(Velocity.INSTANCE.m21216getZero9UxMQ8M());
            }
            floatRef = new Ref.FloatRef();
            floatRef.element = f;
            if (decayAnimationSpec != null && Math.abs(f) > 1.0f) {
                final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null);
                Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt.settleAppBar.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        invoke2(animationScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animateDecay) {
                        Intrinsics.checkNotNullParameter(animateDecay, "$this$animateDecay");
                        float fFloatValue = animateDecay.getValue().floatValue() - floatRef3.element;
                        float heightOffset = topAppBarState2.getHeightOffset();
                        topAppBarState2.setHeightOffset(heightOffset + fFloatValue);
                        float fAbs = Math.abs(heightOffset - topAppBarState2.getHeightOffset());
                        floatRef3.element = animateDecay.getValue().floatValue();
                        floatRef.element = animateDecay.getVelocity().floatValue();
                        if (Math.abs(fFloatValue - fAbs) > 0.5f) {
                            animateDecay.cancelAnimation();
                        }
                    }
                };
                c171812.L$0 = topAppBarState2;
                animationSpec2 = animationSpec;
                c171812.L$1 = animationSpec2;
                c171812.L$2 = floatRef;
                c171812.label = 1;
                if (SuspendAnimationKt.animateDecay$default(animationStateAnimationState$default, decayAnimationSpec, false, function1, c171812, 2, null) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            animationSpec2 = animationSpec;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                floatRef2 = (Ref.FloatRef) c171812.L$0;
                ResultKt.throwOnFailure(obj);
                floatRef = floatRef2;
                return Velocity.m21196boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
            }
            Ref.FloatRef floatRef4 = (Ref.FloatRef) c171812.L$2;
            AnimationSpec<Float> animationSpec3 = (AnimationSpec) c171812.L$1;
            TopAppBarState topAppBarState3 = (TopAppBarState) c171812.L$0;
            ResultKt.throwOnFailure(obj);
            floatRef = floatRef4;
            animationSpec2 = animationSpec3;
            topAppBarState2 = topAppBarState3;
        }
        AnimationSpec<Float> animationSpec4 = animationSpec2;
        if (animationSpec4 != null && topAppBarState2.getHeightOffset() < 0.0f && topAppBarState2.getHeightOffset() > topAppBarState2.getHeightOffsetLimit()) {
            AnimationState animationStateAnimationState$default2 = AnimationStateKt.AnimationState$default(topAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
            Float fBoxFloat = Boxing.boxFloat(topAppBarState2.getCollapsedFraction() < 0.5f ? 0.0f : topAppBarState2.getHeightOffsetLimit());
            Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt.settleAppBar.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    invoke2(animationScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animateTo) {
                    Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                    topAppBarState2.setHeightOffset(animateTo.getValue().floatValue());
                }
            };
            c171812.L$0 = floatRef;
            c171812.L$1 = null;
            c171812.L$2 = null;
            c171812.label = 2;
            if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default2, fBoxFloat, animationSpec4, false, function12, c171812, 4, null) != coroutine_suspended) {
                floatRef2 = floatRef;
                floatRef = floatRef2;
            }
            return coroutine_suspended;
        }
        return Velocity.m21196boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
    }
}
