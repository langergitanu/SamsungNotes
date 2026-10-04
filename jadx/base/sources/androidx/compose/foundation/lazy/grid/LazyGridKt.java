package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u0018\u001a~\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\u0002\b\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010%¨\u0006&"}, m13886d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGrid.kt\nandroidx/compose/foundation/lazy/grid/LazyGridKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 4 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 5 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n+ 6 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,378:1\n149#2:379\n481#3:380\n480#3,4:381\n484#3,2:388\n488#3:394\n1225#4,3:385\n1228#4,3:391\n1225#4,6:397\n480#5:390\n77#6:395\n77#6:396\n*S KotlinDebug\n*F\n+ 1 LazyGrid.kt\nandroidx/compose/foundation/lazy/grid/LazyGridKt\n*L\n63#1:379\n83#1:380\n83#1:381,4\n83#1:388,2\n83#1:394\n83#1:385,3\n83#1:391,3\n162#1:397,6\n83#1:390\n84#1:395\n114#1:396\n*E\n"})
public final class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyGrid(@Nullable Modifier modifier, @NotNull final LazyGridState lazyGridState, @NotNull final LazyGridSlotsProvider lazyGridSlotsProvider, @Nullable PaddingValues paddingValues, boolean z, final boolean z2, @Nullable FlingBehavior flingBehavior, final boolean z3, @NotNull final Arrangement.Vertical vertical, @NotNull final Arrangement.Horizontal horizontal, @NotNull final Function1<? super LazyGridScope, Unit> function1, @Nullable Composer composer, final int i, final int i2, final int i4) {
        Modifier modifier2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z4;
        int i7;
        PaddingValues paddingValues3;
        FlingBehavior flingBehavior2;
        Modifier modifier3;
        int i8;
        Object objRememberedValue;
        final boolean z5;
        final FlingBehavior flingBehavior3;
        final Modifier modifier4;
        final PaddingValues paddingValues4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-649686062);
        int i9 = i4 & 1;
        if (i9 != 0) {
            i5 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i & 384) == 0) {
            i5 |= (i & 512) == 0 ? composerStartRestartGroup.changed(lazyGridSlotsProvider) : composerStartRestartGroup.changedInstance(lazyGridSlotsProvider) ? 256 : 128;
        }
        int i10 = i4 & 8;
        if (i10 != 0) {
            i5 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                paddingValues2 = paddingValues;
                i5 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
            }
            i6 = i4 & 16;
            if (i6 == 0) {
                i5 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    z4 = z;
                    i5 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                }
                if ((i4 & 32) != 0) {
                    i5 |= 196608;
                } else if ((i & 196608) == 0) {
                    i5 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                }
                if ((i & 1572864) == 0) {
                    i5 |= ((i4 & 64) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 1048576 : 524288;
                }
                if ((i4 & 128) != 0) {
                    i5 |= 12582912;
                } else {
                    if ((i & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
                    }
                    if ((i4 & 256) == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i5 |= composerStartRestartGroup.changed(vertical) ? 67108864 : 33554432;
                        }
                        if ((i4 & 512) == 0) {
                            if ((i & DriveFile.MODE_READ_WRITE) == 0) {
                                i5 |= composerStartRestartGroup.changed(horizontal) ? 536870912 : 268435456;
                            }
                            if ((i4 & 1024) == 0) {
                                i7 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i7 = i2 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                            } else {
                                i7 = i2;
                            }
                            if ((i5 & 306783379) != 306783378 && (i7 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z5 = z4;
                                modifier4 = modifier2;
                                paddingValues4 = paddingValues2;
                                flingBehavior3 = flingBehavior;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                    PaddingValues paddingValuesM15847PaddingValues0680j_4 = i10 == 0 ? PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0)) : paddingValues2;
                                    if (i6 != 0) {
                                        z4 = false;
                                    }
                                    if ((i4 & 64) == 0) {
                                        paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                                        modifier3 = modifier5;
                                        i8 = i5 & (-3670017);
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    } else {
                                        paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                                        flingBehavior2 = flingBehavior;
                                        modifier3 = modifier5;
                                        i8 = i5;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 64) != 0) {
                                        i5 &= -3670017;
                                    }
                                    flingBehavior2 = flingBehavior;
                                    modifier3 = modifier2;
                                    i8 = i5;
                                    paddingValues3 = paddingValues2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-649686062, i8, i7, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:77)");
                                }
                                int i11 = i8 >> 3;
                                int i12 = i11 & 14;
                                Function0<LazyGridItemProvider> function0RememberLazyGridItemProviderLambda = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, composerStartRestartGroup, ((i7 << 3) & 112) | i12);
                                int i13 = i8 >> 9;
                                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, (i13 & 112) | i12);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                                }
                                int i14 = i8 & 112;
                                int i15 = i8 & 57344;
                                int i16 = i8;
                                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy = rememberLazyGridMeasurePolicy(function0RememberLazyGridItemProviderLambda, lazyGridState, lazyGridSlotsProvider, paddingValues3, z4, z2, horizontal, vertical, ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope(), (GraphicsContext) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), composerStartRestartGroup, (i8 & 524272) | (i13 & 3670016) | (i11 & 29360128));
                                PaddingValues paddingValues5 = paddingValues3;
                                boolean z6 = z4;
                                Orientation orientation = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                                Modifier modifierLazyLayoutSemantics = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), function0RememberLazyGridItemProviderLambda, lazyLayoutSemanticStateRememberLazyGridSemanticState, orientation, z3, z6, composerStartRestartGroup, (i13 & 57344) | ((i16 << 3) & 458752));
                                composerStartRestartGroup = composerStartRestartGroup;
                                FlingBehavior flingBehavior4 = flingBehavior2;
                                LazyLayoutKt.LazyLayout(function0RememberLazyGridItemProviderLambda, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(modifierLazyLayoutSemantics, LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, composerStartRestartGroup, i12), lazyGridState.getBeyondBoundsInfo(), z6, (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, z3, composerStartRestartGroup, (3670016 & i11) | (MutableVector.$stable << 6) | (i11 & 7168)).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation, z3, z6, flingBehavior4, lazyGridState.getInternalInteractionSource(), null, composerStartRestartGroup, i14 | ((i16 >> 12) & 7168) | i15 | (458752 & i11), 64), lazyGridState.getPrefetchState(), function2RememberLazyGridMeasurePolicy, composerStartRestartGroup, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z5 = z6;
                                flingBehavior3 = flingBehavior4;
                                modifier4 = modifier3;
                                paddingValues4 = paddingValues5;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.1
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

                                    public final void invoke(@Nullable Composer composer2, int i17) {
                                        LazyGridKt.LazyGrid(modifier4, lazyGridState, lazyGridSlotsProvider, paddingValues4, z5, z2, flingBehavior3, z3, vertical, horizontal, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= DriveFile.MODE_READ_WRITE;
                        if ((i4 & 1024) == 0) {
                        }
                        if ((i5 & 306783379) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 == 0) {
                                }
                                if (i10 == 0) {
                                }
                                if (i6 != 0) {
                                }
                                if ((i4 & 64) == 0) {
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i112 = i8 >> 3;
                                int i122 = i112 & 14;
                                Function0<LazyGridItemProvider> function0RememberLazyGridItemProviderLambda2 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, composerStartRestartGroup, ((i7 << 3) & 112) | i122);
                                int i132 = i8 >> 9;
                                LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyGridSemanticState2 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, composerStartRestartGroup, (i132 & 112) | i122);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                }
                                int i142 = i8 & 112;
                                int i152 = i8 & 57344;
                                int i162 = i8;
                                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy2 = rememberLazyGridMeasurePolicy(function0RememberLazyGridItemProviderLambda2, lazyGridState, lazyGridSlotsProvider, paddingValues3, z4, z2, horizontal, vertical, ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope(), (GraphicsContext) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), composerStartRestartGroup, (i8 & 524272) | (i132 & 3670016) | (i112 & 29360128));
                                PaddingValues paddingValues52 = paddingValues3;
                                if (!z2) {
                                }
                                boolean z62 = z4;
                                Orientation orientation2 = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                                Modifier modifierLazyLayoutSemantics2 = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), function0RememberLazyGridItemProviderLambda2, lazyLayoutSemanticStateRememberLazyGridSemanticState2, orientation2, z3, z62, composerStartRestartGroup, (i132 & 57344) | ((i162 << 3) & 458752));
                                composerStartRestartGroup = composerStartRestartGroup;
                                FlingBehavior flingBehavior42 = flingBehavior2;
                                LazyLayoutKt.LazyLayout(function0RememberLazyGridItemProviderLambda2, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(modifierLazyLayoutSemantics2, LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, composerStartRestartGroup, i122), lazyGridState.getBeyondBoundsInfo(), z62, (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2, z3, composerStartRestartGroup, (3670016 & i112) | (MutableVector.$stable << 6) | (i112 & 7168)).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation2, z3, z62, flingBehavior42, lazyGridState.getInternalInteractionSource(), null, composerStartRestartGroup, i142 | ((i162 >> 12) & 7168) | i152 | (458752 & i112), 64), lazyGridState.getPrefetchState(), function2RememberLazyGridMeasurePolicy2, composerStartRestartGroup, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                z5 = z62;
                                flingBehavior3 = flingBehavior42;
                                modifier4 = modifier3;
                                paddingValues4 = paddingValues52;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    if ((i4 & 512) == 0) {
                    }
                    if ((i4 & 1024) == 0) {
                    }
                    if ((i5 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                if ((i4 & 256) == 0) {
                }
                if ((i4 & 512) == 0) {
                }
                if ((i4 & 1024) == 0) {
                }
                if ((i5 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z4 = z;
            if ((i4 & 32) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i4 & 128) != 0) {
            }
            if ((i4 & 256) == 0) {
            }
            if ((i4 & 512) == 0) {
            }
            if ((i4 & 1024) == 0) {
            }
            if ((i5 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        paddingValues2 = paddingValues;
        i6 = i4 & 16;
        if (i6 == 0) {
        }
        z4 = z;
        if ((i4 & 32) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i4 & 128) != 0) {
        }
        if ((i4 & 256) == 0) {
        }
        if ((i4 & 512) == 0) {
        }
        if ((i4 & 1024) == 0) {
        }
        if ((i5 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008e A[PHI: r3
      0x008e: PHI (r3v23 boolean) = (r3v21 boolean), (r3v24 boolean) binds: [B:44:0x008c, B:40:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f1  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState lazyGridState, final LazyGridSlotsProvider lazyGridSlotsProvider, final PaddingValues paddingValues, final boolean z, boolean z2, final Arrangement.Horizontal horizontal, final Arrangement.Vertical vertical, final CoroutineScope coroutineScope, final GraphicsContext graphicsContext, Composer composer, int i) {
        boolean z3;
        boolean z4;
        boolean zChanged;
        Object objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1585069765, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:161)");
        }
        boolean z5 = ((((i & 112) ^ 48) > 32 && composer.changed(lazyGridState)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(lazyGridSlotsProvider)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(paddingValues)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(z)) || (i & 24576) == 16384);
        if (((458752 & i) ^ 196608) > 131072) {
            z3 = z2;
            if (composer.changed(z3)) {
                z4 = true;
            }
            zChanged = z5 | z4 | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
            objRememberedValue = composer.rememberedValue();
            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final boolean z6 = z3;
                Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> function2 = new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                        return m15992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Type inference failed for: r18v1, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider] */
                    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider] */
                    @NotNull
                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final LazyGridMeasureResult m15992invoke0kLqBqw(@NotNull final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                        float spacing;
                        long jIntOffset;
                        int lineIndexOfItem;
                        boolean z7;
                        ObservableScopeInvalidator.m16028attachToScopeimpl(lazyGridState.m16000getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                        CheckScrollableContainerConstraintsKt.m15437checkScrollableContainerConstraintsK40F9xA(j, z6 ? Orientation.Vertical : Orientation.Horizontal);
                        int iMo15540roundToPx0680j_4 = z6 ? lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.mo15805calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo15540roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        int iMo15540roundToPx0680j_42 = z6 ? lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.mo15806calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo15540roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        int iMo15540roundToPx0680j_43 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.getTop());
                        int iMo15540roundToPx0680j_44 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.getBottom());
                        final int i2 = iMo15540roundToPx0680j_43 + iMo15540roundToPx0680j_44;
                        final int i4 = iMo15540roundToPx0680j_4 + iMo15540roundToPx0680j_42;
                        boolean z8 = z6;
                        int i5 = z8 ? i2 : i4;
                        final int i6 = (!z8 || z) ? (z8 && z) ? iMo15540roundToPx0680j_44 : (z8 || z) ? iMo15540roundToPx0680j_42 : iMo15540roundToPx0680j_4 : iMo15540roundToPx0680j_43;
                        final int i7 = i5 - i6;
                        long jM20940offsetNN6EwU = ConstraintsKt.m20940offsetNN6EwU(j, -i4, -i2);
                        final LazyGridItemProvider lazyGridItemProviderInvoke = function0.invoke();
                        final LazyGridSpanLayoutProvider spanLayoutProvider = lazyGridItemProviderInvoke.getSpanLayoutProvider();
                        final LazyGridSlots lazyGridSlotsMo15981invoke0kLqBqw = lazyGridSlotsProvider.mo15981invoke0kLqBqw(lazyLayoutMeasureScope, j);
                        int length = lazyGridSlotsMo15981invoke0kLqBqw.getSizes().length;
                        spanLayoutProvider.setSlotsPerLine(length);
                        if (z6) {
                            Arrangement.Vertical vertical2 = vertical;
                            if (vertical2 == null) {
                                throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                            }
                            spacing = vertical2.getSpacing();
                        } else {
                            Arrangement.Horizontal horizontal2 = horizontal;
                            if (horizontal2 == null) {
                                throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
                            }
                            spacing = horizontal2.getSpacing();
                        }
                        final int iMo15540roundToPx0680j_45 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(spacing);
                        final int itemCount = lazyGridItemProviderInvoke.getItemCount();
                        int iM20920getMaxHeightimpl = z6 ? Constraints.m20920getMaxHeightimpl(j) - i2 : Constraints.m20921getMaxWidthimpl(j) - i4;
                        if (!z || iM20920getMaxHeightimpl > 0) {
                            jIntOffset = IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                        } else {
                            boolean z9 = z6;
                            if (!z9) {
                                iMo15540roundToPx0680j_4 += iM20920getMaxHeightimpl;
                            }
                            if (z9) {
                                iMo15540roundToPx0680j_43 += iM20920getMaxHeightimpl;
                            }
                            jIntOffset = IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                        }
                        final long j2 = jIntOffset;
                        final LazyGridState lazyGridState2 = lazyGridState;
                        final boolean z10 = z6;
                        final boolean z11 = z;
                        final ?? r4 = new LazyGridMeasuredItemProvider(lazyGridItemProviderInvoke, lazyLayoutMeasureScope, iMo15540roundToPx0680j_45, lazyGridState2, z10, z11, i6, i7, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                            final /* synthetic */ int $afterContentPadding;
                            final /* synthetic */ int $beforeContentPadding;
                            final /* synthetic */ boolean $isVertical;
                            final /* synthetic */ boolean $reverseLayout;
                            final /* synthetic */ LazyGridState $state;
                            final /* synthetic */ LazyLayoutMeasureScope $this_null;
                            final /* synthetic */ long $visualItemOffset;

                            {
                                this.$this_null = lazyLayoutMeasureScope;
                                this.$state = lazyGridState2;
                                this.$isVertical = z10;
                                this.$reverseLayout = z11;
                                this.$beforeContentPadding = i6;
                                this.$afterContentPadding = i7;
                                this.$visualItemOffset = j2;
                            }

                            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                            @NotNull
                            /* JADX INFO: renamed from: createItem-O3s9Psw, reason: not valid java name */
                            public LazyGridMeasuredItem mo15993createItemO3s9Psw(int index, @NotNull Object key, @Nullable Object contentType, int crossAxisSize, int mainAxisSpacing, @NotNull List<? extends Placeable> placeables, long constraints, int lane, int span) {
                                return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, this.$state.getItemAnimator$foundation_release(), constraints, lane, span, null);
                            }
                        };
                        final boolean z12 = z6;
                        final ?? r18 = new LazyGridMeasuredLineProvider(z12, lazyGridSlotsMo15981invoke0kLqBqw, itemCount, iMo15540roundToPx0680j_45, r4, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                            final /* synthetic */ boolean $isVertical;
                            final /* synthetic */ LazyGridSlots $resolvedSlots;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(z12, lazyGridSlotsMo15981invoke0kLqBqw, itemCount, iMo15540roundToPx0680j_45, r4, spanLayoutProvider);
                                this.$isVertical = z12;
                                this.$resolvedSlots = lazyGridSlotsMo15981invoke0kLqBqw;
                            }

                            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                            @NotNull
                            public LazyGridMeasuredLine createLine(int index, @NotNull LazyGridMeasuredItem[] items, @NotNull List<GridItemSpan> spans, int mainAxisSpacing) {
                                return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
                            }
                        };
                        Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>> function1 = new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @NotNull
                            public final ArrayList<Pair<Integer, Constraints>> invoke(int i8) {
                                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider.getLineConfiguration(i8);
                                int firstItemIndex = lineConfiguration.getFirstItemIndex();
                                ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                                List<GridItemSpan> spans = lineConfiguration.getSpans();
                                C1105xaa796ba c1105xaa796ba = r18;
                                int size = spans.size();
                                int i9 = 0;
                                for (int i10 = 0; i10 < size; i10++) {
                                    int iM15977getCurrentLineSpanimpl = GridItemSpan.m15977getCurrentLineSpanimpl(spans.get(i10).getPackedValue());
                                    arrayList.add(TuplesKt.m13893to(Integer.valueOf(firstItemIndex), Constraints.m20909boximpl(c1105xaa796ba.m15999childConstraintsJhjzzOo$foundation_release(i9, iM15977getCurrentLineSpanimpl))));
                                    firstItemIndex++;
                                    i9 += iM15977getCurrentLineSpanimpl;
                                }
                                return arrayList;
                            }
                        };
                        Snapshot.Companion companion = Snapshot.INSTANCE;
                        LazyGridState lazyGridState3 = lazyGridState;
                        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        int i8 = i6;
                        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProviderInvoke, lazyGridState3.getFirstVisibleItemIndex());
                            int firstVisibleItemScrollOffset = 0;
                            if (iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release < itemCount || itemCount <= 0) {
                                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                                z7 = false;
                                firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                            } else {
                                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                                z7 = false;
                            }
                            Unit unit = Unit.INSTANCE;
                            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            LazyGridMeasureResult lazyGridMeasureResultM15995measureLazyGridOZKpZRA = LazyGridMeasureKt.m15995measureLazyGridOZKpZRA(itemCount, r18, r4, iM20920getMaxHeightimpl, i8, i7, iMo15540roundToPx0680j_45, lineIndexOfItem, firstVisibleItemScrollOffset, lazyGridState.getScrollToBeConsumed(), jM20940offsetNN6EwU, z6, vertical, horizontal, z, lazyLayoutMeasureScope, lazyGridState.getItemAnimator$foundation_release(), length, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProviderInvoke, lazyGridState.getPinnedItems(), lazyGridState.getBeyondBoundsInfo()), coroutineScope, lazyGridState.m16001getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                                }

                                @NotNull
                                public final MeasureResult invoke(int i9, int i10, @NotNull Function1<? super Placeable.PlacementScope, Unit> function12) {
                                    return lazyLayoutMeasureScope.layout(ConstraintsKt.m20938constrainWidthK40F9xA(j, i9 + i4), ConstraintsKt.m20937constrainHeightK40F9xA(j, i10 + i2), MapsKt.emptyMap(), function12);
                                }
                            });
                            LazyGridState.applyMeasureResult$foundation_release$default(lazyGridState, lazyGridMeasureResultM15995measureLazyGridOZKpZRA, false, 2, null);
                            return lazyGridMeasureResultM15995measureLazyGridOZKpZRA;
                        } catch (Throwable th) {
                            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                composer.updateRememberedValue(function2);
                objRememberedValue = function2;
            }
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) objRememberedValue;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return function22;
        }
        z3 = z2;
        if ((196608 & i) != 131072) {
            z4 = false;
        }
        zChanged = z5 | z4 | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
        objRememberedValue = composer.rememberedValue();
        if (!zChanged) {
            final boolean z62 = z3;
            Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> function23 = new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m15992invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX WARN: Type inference failed for: r18v1, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider] */
                /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider] */
                @NotNull
                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridMeasureResult m15992invoke0kLqBqw(@NotNull final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    float spacing;
                    long jIntOffset;
                    int lineIndexOfItem;
                    boolean z7;
                    ObservableScopeInvalidator.m16028attachToScopeimpl(lazyGridState.m16000getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    CheckScrollableContainerConstraintsKt.m15437checkScrollableContainerConstraintsK40F9xA(j, z62 ? Orientation.Vertical : Orientation.Horizontal);
                    int iMo15540roundToPx0680j_4 = z62 ? lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.mo15805calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo15540roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    int iMo15540roundToPx0680j_42 = z62 ? lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.mo15806calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo15540roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    int iMo15540roundToPx0680j_43 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.getTop());
                    int iMo15540roundToPx0680j_44 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.getBottom());
                    final int i2 = iMo15540roundToPx0680j_43 + iMo15540roundToPx0680j_44;
                    final int i4 = iMo15540roundToPx0680j_4 + iMo15540roundToPx0680j_42;
                    boolean z8 = z62;
                    int i5 = z8 ? i2 : i4;
                    final int i6 = (!z8 || z) ? (z8 && z) ? iMo15540roundToPx0680j_44 : (z8 || z) ? iMo15540roundToPx0680j_42 : iMo15540roundToPx0680j_4 : iMo15540roundToPx0680j_43;
                    final int i7 = i5 - i6;
                    long jM20940offsetNN6EwU = ConstraintsKt.m20940offsetNN6EwU(j, -i4, -i2);
                    final LazyGridItemProvider lazyGridItemProviderInvoke = function0.invoke();
                    final LazyGridSpanLayoutProvider spanLayoutProvider = lazyGridItemProviderInvoke.getSpanLayoutProvider();
                    final LazyGridSlots lazyGridSlotsMo15981invoke0kLqBqw = lazyGridSlotsProvider.mo15981invoke0kLqBqw(lazyLayoutMeasureScope, j);
                    int length = lazyGridSlotsMo15981invoke0kLqBqw.getSizes().length;
                    spanLayoutProvider.setSlotsPerLine(length);
                    if (z62) {
                        Arrangement.Vertical vertical2 = vertical;
                        if (vertical2 == null) {
                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                        }
                        spacing = vertical2.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal2 = horizontal;
                        if (horizontal2 == null) {
                            throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
                        }
                        spacing = horizontal2.getSpacing();
                    }
                    final int iMo15540roundToPx0680j_45 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(spacing);
                    final int itemCount = lazyGridItemProviderInvoke.getItemCount();
                    int iM20920getMaxHeightimpl = z62 ? Constraints.m20920getMaxHeightimpl(j) - i2 : Constraints.m20921getMaxWidthimpl(j) - i4;
                    if (!z || iM20920getMaxHeightimpl > 0) {
                        jIntOffset = IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                    } else {
                        boolean z9 = z62;
                        if (!z9) {
                            iMo15540roundToPx0680j_4 += iM20920getMaxHeightimpl;
                        }
                        if (z9) {
                            iMo15540roundToPx0680j_43 += iM20920getMaxHeightimpl;
                        }
                        jIntOffset = IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                    }
                    final long j2 = jIntOffset;
                    final LazyGridState lazyGridState2 = lazyGridState;
                    final boolean z10 = z62;
                    final boolean z11 = z;
                    final C1104x6964719 r4 = new LazyGridMeasuredItemProvider(lazyGridItemProviderInvoke, lazyLayoutMeasureScope, iMo15540roundToPx0680j_45, lazyGridState2, z10, z11, i6, i7, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ LazyGridState $state;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ long $visualItemOffset;

                        {
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$state = lazyGridState2;
                            this.$isVertical = z10;
                            this.$reverseLayout = z11;
                            this.$beforeContentPadding = i6;
                            this.$afterContentPadding = i7;
                            this.$visualItemOffset = j2;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                        @NotNull
                        /* JADX INFO: renamed from: createItem-O3s9Psw, reason: not valid java name */
                        public LazyGridMeasuredItem mo15993createItemO3s9Psw(int index, @NotNull Object key, @Nullable Object contentType, int crossAxisSize, int mainAxisSpacing, @NotNull List<? extends Placeable> placeables, long constraints, int lane, int span) {
                            return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, this.$state.getItemAnimator$foundation_release(), constraints, lane, span, null);
                        }
                    };
                    final boolean z12 = z62;
                    final C1105xaa796ba r18 = new LazyGridMeasuredLineProvider(z12, lazyGridSlotsMo15981invoke0kLqBqw, itemCount, iMo15540roundToPx0680j_45, r4, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ LazyGridSlots $resolvedSlots;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(z12, lazyGridSlotsMo15981invoke0kLqBqw, itemCount, iMo15540roundToPx0680j_45, r4, spanLayoutProvider);
                            this.$isVertical = z12;
                            this.$resolvedSlots = lazyGridSlotsMo15981invoke0kLqBqw;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                        @NotNull
                        public LazyGridMeasuredLine createLine(int index, @NotNull LazyGridMeasuredItem[] items, @NotNull List<GridItemSpan> spans, int mainAxisSpacing) {
                            return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
                        }
                    };
                    Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>> function1 = new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        @NotNull
                        public final ArrayList<Pair<Integer, Constraints>> invoke(int i8) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider.getLineConfiguration(i8);
                            int firstItemIndex = lineConfiguration.getFirstItemIndex();
                            ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                            List<GridItemSpan> spans = lineConfiguration.getSpans();
                            C1105xaa796ba c1105xaa796ba = r18;
                            int size = spans.size();
                            int i9 = 0;
                            for (int i10 = 0; i10 < size; i10++) {
                                int iM15977getCurrentLineSpanimpl = GridItemSpan.m15977getCurrentLineSpanimpl(spans.get(i10).getPackedValue());
                                arrayList.add(TuplesKt.m13893to(Integer.valueOf(firstItemIndex), Constraints.m20909boximpl(c1105xaa796ba.m15999childConstraintsJhjzzOo$foundation_release(i9, iM15977getCurrentLineSpanimpl))));
                                firstItemIndex++;
                                i9 += iM15977getCurrentLineSpanimpl;
                            }
                            return arrayList;
                        }
                    };
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyGridState lazyGridState3 = lazyGridState;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    int i8 = i6;
                    Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProviderInvoke, lazyGridState3.getFirstVisibleItemIndex());
                        int firstVisibleItemScrollOffset = 0;
                        if (iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release < itemCount || itemCount <= 0) {
                            lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                            z7 = false;
                            firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                        } else {
                            lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                            z7 = false;
                        }
                        Unit unit = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        LazyGridMeasureResult lazyGridMeasureResultM15995measureLazyGridOZKpZRA = LazyGridMeasureKt.m15995measureLazyGridOZKpZRA(itemCount, r18, r4, iM20920getMaxHeightimpl, i8, i7, iMo15540roundToPx0680j_45, lineIndexOfItem, firstVisibleItemScrollOffset, lazyGridState.getScrollToBeConsumed(), jM20940offsetNN6EwU, z62, vertical, horizontal, z, lazyLayoutMeasureScope, lazyGridState.getItemAnimator$foundation_release(), length, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProviderInvoke, lazyGridState.getPinnedItems(), lazyGridState.getBeyondBoundsInfo()), coroutineScope, lazyGridState.m16001getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                            }

                            @NotNull
                            public final MeasureResult invoke(int i9, int i10, @NotNull Function1<? super Placeable.PlacementScope, Unit> function12) {
                                return lazyLayoutMeasureScope.layout(ConstraintsKt.m20938constrainWidthK40F9xA(j, i9 + i4), ConstraintsKt.m20937constrainHeightK40F9xA(j, i10 + i2), MapsKt.emptyMap(), function12);
                            }
                        });
                        LazyGridState.applyMeasureResult$foundation_release$default(lazyGridState, lazyGridMeasureResultM15995measureLazyGridOZKpZRA, false, 2, null);
                        return lazyGridMeasureResultM15995measureLazyGridOZKpZRA;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(function23);
            objRememberedValue = function23;
        }
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222 = (Function2) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
        }
        return function222;
    }
}
