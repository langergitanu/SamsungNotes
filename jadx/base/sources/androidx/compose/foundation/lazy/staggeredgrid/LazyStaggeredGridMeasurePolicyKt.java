package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u007f\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a)\u0010\u001c\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001f\u001a)\u0010 \u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001f\u001a!\u0010!\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "rememberStaggeredGridMeasurePolicy-qKj4JfE", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyStaggeredGridMeasurePolicy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyStaggeredGridMeasurePolicy.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasurePolicyKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,169:1\n1225#2,6:170\n*S KotlinDebug\n*F\n+ 1 LazyStaggeredGridMeasurePolicy.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasurePolicyKt\n*L\n51#1:170,6\n*E\n"})
public final class LazyStaggeredGridMeasurePolicyKt {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float afterPadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.getTop() : paddingValues.getBottom();
        }
        if (i == 2) {
            return z ? PaddingKt.calculateStartPadding(paddingValues, layoutDirection) : PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float beforePadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.getBottom() : paddingValues.getTop();
        }
        if (i == 2) {
            return z ? PaddingKt.calculateEndPadding(paddingValues, layoutDirection) : PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007a A[PHI: r3
      0x007a: PHI (r3v21 androidx.compose.foundation.gestures.Orientation) = (r3v19 androidx.compose.foundation.gestures.Orientation), (r3v22 androidx.compose.foundation.gestures.Orientation) binds: [B:36:0x0078, B:32:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096 A[PHI: r4
      0x0096: PHI (r4v12 float) = (r4v10 float), (r4v13 float) binds: [B:46:0x0094, B:42:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc A[PHI: r8
      0x00cc: PHI (r8v17 androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider) = 
      (r8v15 androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider)
      (r8v18 androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider)
     binds: [B:64:0x00ca, B:60:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fa  */
    @Composable
    @NotNull
    /* JADX INFO: renamed from: rememberStaggeredGridMeasurePolicy-qKj4JfE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> m16066rememberStaggeredGridMeasurePolicyqKj4JfE(@NotNull final LazyStaggeredGridState lazyStaggeredGridState, @NotNull final Function0<? extends LazyStaggeredGridItemProvider> function0, @NotNull final PaddingValues paddingValues, final boolean z, @NotNull Orientation orientation, float f, float f4, @NotNull final CoroutineScope coroutineScope, @NotNull LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, @NotNull final GraphicsContext graphicsContext, @Nullable Composer composer, int i) {
        Orientation orientation2;
        boolean z2;
        float f5;
        boolean z3;
        final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider2;
        boolean zChanged;
        Object objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1630140849, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:50)");
        }
        boolean z4 = false;
        boolean zChanged2 = composer.changed(lazyStaggeredGridState) | ((((i & 112) ^ 48) > 32 && composer.changed(function0)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(z)) || (i & 3072) == 2048);
        if (((57344 & i) ^ 24576) > 16384) {
            orientation2 = orientation;
            if (composer.changed(orientation2)) {
                z2 = true;
            }
            boolean z5 = zChanged2 | z2;
            if (((458752 & i) ^ 196608) <= 131072) {
                f5 = f;
                if (composer.changed(f5)) {
                    z3 = true;
                }
                boolean z6 = z5 | z3 | ((((3670016 & i) ^ 1572864) > 1048576 && composer.changed(f4)) || (i & 1572864) == 1048576);
                if (((234881024 & i) ^ 100663296) > 67108864) {
                    lazyGridStaggeredGridSlotsProvider2 = lazyGridStaggeredGridSlotsProvider;
                    if (composer.changed(lazyGridStaggeredGridSlotsProvider2)) {
                        z4 = true;
                    }
                    zChanged = z6 | z4 | composer.changed(graphicsContext);
                    objRememberedValue = composer.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        final Orientation orientation3 = orientation2;
                        final float f6 = f5;
                        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2 = new Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ LazyStaggeredGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                return m16067invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                            }

                            @NotNull
                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final LazyStaggeredGridMeasureResult m16067invoke0kLqBqw(@NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
                                ObservableScopeInvalidator.m16028attachToScopeimpl(lazyStaggeredGridState.m16072getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                CheckScrollableContainerConstraintsKt.m15437checkScrollableContainerConstraintsK40F9xA(j, orientation3);
                                LazyStaggeredGridSlots lazyStaggeredGridSlotsMo16048invoke0kLqBqw = lazyGridStaggeredGridSlotsProvider2.mo16048invoke0kLqBqw(lazyLayoutMeasureScope, j);
                                boolean z7 = orientation3 == Orientation.Vertical;
                                LazyStaggeredGridItemProvider lazyStaggeredGridItemProviderInvoke = function0.invoke();
                                int iMo15540roundToPx0680j_4 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(paddingValues, orientation3, z, lazyLayoutMeasureScope.getLayoutDirection()));
                                int iMo15540roundToPx0680j_42 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(paddingValues, orientation3, z, lazyLayoutMeasureScope.getLayoutDirection()));
                                int iMo15540roundToPx0680j_43 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(paddingValues, orientation3, lazyLayoutMeasureScope.getLayoutDirection()));
                                int iM20920getMaxHeightimpl = ((z7 ? Constraints.m20920getMaxHeightimpl(j) : Constraints.m20921getMaxWidthimpl(j)) - iMo15540roundToPx0680j_4) - iMo15540roundToPx0680j_42;
                                long jIntOffset = z7 ? IntOffsetKt.IntOffset(iMo15540roundToPx0680j_43, iMo15540roundToPx0680j_4) : IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                                PaddingValues paddingValues2 = paddingValues;
                                int iMo15540roundToPx0680j_44 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl(PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateStartPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection())));
                                PaddingValues paddingValues3 = paddingValues;
                                boolean z8 = z7;
                                LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResultM16065measureStaggeredGridXtK8cYQ = LazyStaggeredGridMeasureKt.m16065measureStaggeredGridXtK8cYQ(lazyLayoutMeasureScope, lazyStaggeredGridState, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyStaggeredGridItemProviderInvoke, lazyStaggeredGridState.getPinnedItems(), lazyStaggeredGridState.getBeyondBoundsInfo()), lazyStaggeredGridItemProviderInvoke, lazyStaggeredGridSlotsMo16048invoke0kLqBqw, Constraints.m20912copyZbe2FdA$default(j, ConstraintsKt.m20938constrainWidthK40F9xA(j, iMo15540roundToPx0680j_44), 0, ConstraintsKt.m20937constrainHeightK40F9xA(j, lazyLayoutMeasureScope.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl(paddingValues3.getBottom() + paddingValues3.getTop()))), 0, 10, null), z8, z, jIntOffset, iM20920getMaxHeightimpl, lazyLayoutMeasureScope.mo15540roundToPx0680j_4(f6), iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_42, coroutineScope, graphicsContext);
                                LazyStaggeredGridState.applyMeasureResult$foundation_release$default(lazyStaggeredGridState, lazyStaggeredGridMeasureResultM16065measureStaggeredGridXtK8cYQ, false, 2, null);
                                return lazyStaggeredGridMeasureResultM16065measureStaggeredGridXtK8cYQ;
                            }
                        };
                        composer.updateRememberedValue(function2);
                        objRememberedValue = function2;
                    }
                    Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function22 = (Function2) objRememberedValue;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    return function22;
                }
                lazyGridStaggeredGridSlotsProvider2 = lazyGridStaggeredGridSlotsProvider;
                if ((i & 100663296) == 67108864) {
                }
                zChanged = z6 | z4 | composer.changed(graphicsContext);
                objRememberedValue = composer.rememberedValue();
                if (!zChanged) {
                    final Orientation orientation32 = orientation2;
                    final float f62 = f5;
                    Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function23 = new Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ LazyStaggeredGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                            return m16067invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                        }

                        @NotNull
                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final LazyStaggeredGridMeasureResult m16067invoke0kLqBqw(@NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
                            ObservableScopeInvalidator.m16028attachToScopeimpl(lazyStaggeredGridState.m16072getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                            CheckScrollableContainerConstraintsKt.m15437checkScrollableContainerConstraintsK40F9xA(j, orientation32);
                            LazyStaggeredGridSlots lazyStaggeredGridSlotsMo16048invoke0kLqBqw = lazyGridStaggeredGridSlotsProvider2.mo16048invoke0kLqBqw(lazyLayoutMeasureScope, j);
                            boolean z7 = orientation32 == Orientation.Vertical;
                            LazyStaggeredGridItemProvider lazyStaggeredGridItemProviderInvoke = function0.invoke();
                            int iMo15540roundToPx0680j_4 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(paddingValues, orientation32, z, lazyLayoutMeasureScope.getLayoutDirection()));
                            int iMo15540roundToPx0680j_42 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(paddingValues, orientation32, z, lazyLayoutMeasureScope.getLayoutDirection()));
                            int iMo15540roundToPx0680j_43 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(paddingValues, orientation32, lazyLayoutMeasureScope.getLayoutDirection()));
                            int iM20920getMaxHeightimpl = ((z7 ? Constraints.m20920getMaxHeightimpl(j) : Constraints.m20921getMaxWidthimpl(j)) - iMo15540roundToPx0680j_4) - iMo15540roundToPx0680j_42;
                            long jIntOffset = z7 ? IntOffsetKt.IntOffset(iMo15540roundToPx0680j_43, iMo15540roundToPx0680j_4) : IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                            PaddingValues paddingValues2 = paddingValues;
                            int iMo15540roundToPx0680j_44 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl(PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateStartPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection())));
                            PaddingValues paddingValues3 = paddingValues;
                            boolean z8 = z7;
                            LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResultM16065measureStaggeredGridXtK8cYQ = LazyStaggeredGridMeasureKt.m16065measureStaggeredGridXtK8cYQ(lazyLayoutMeasureScope, lazyStaggeredGridState, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyStaggeredGridItemProviderInvoke, lazyStaggeredGridState.getPinnedItems(), lazyStaggeredGridState.getBeyondBoundsInfo()), lazyStaggeredGridItemProviderInvoke, lazyStaggeredGridSlotsMo16048invoke0kLqBqw, Constraints.m20912copyZbe2FdA$default(j, ConstraintsKt.m20938constrainWidthK40F9xA(j, iMo15540roundToPx0680j_44), 0, ConstraintsKt.m20937constrainHeightK40F9xA(j, lazyLayoutMeasureScope.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl(paddingValues3.getBottom() + paddingValues3.getTop()))), 0, 10, null), z8, z, jIntOffset, iM20920getMaxHeightimpl, lazyLayoutMeasureScope.mo15540roundToPx0680j_4(f62), iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_42, coroutineScope, graphicsContext);
                            LazyStaggeredGridState.applyMeasureResult$foundation_release$default(lazyStaggeredGridState, lazyStaggeredGridMeasureResultM16065measureStaggeredGridXtK8cYQ, false, 2, null);
                            return lazyStaggeredGridMeasureResultM16065measureStaggeredGridXtK8cYQ;
                        }
                    };
                    composer.updateRememberedValue(function23);
                    objRememberedValue = function23;
                }
                Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function222 = (Function2) objRememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                }
                return function222;
            }
            f5 = f;
            if ((196608 & i) == 131072) {
                z3 = false;
            }
            boolean z62 = z5 | z3 | ((((3670016 & i) ^ 1572864) > 1048576 && composer.changed(f4)) || (i & 1572864) == 1048576);
            if (((234881024 & i) ^ 100663296) > 67108864) {
            }
            if ((i & 100663296) == 67108864) {
            }
            zChanged = z62 | z4 | composer.changed(graphicsContext);
            objRememberedValue = composer.rememberedValue();
            if (!zChanged) {
            }
            Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2222 = (Function2) objRememberedValue;
            if (ComposerKt.isTraceInProgress()) {
            }
            return function2222;
        }
        orientation2 = orientation;
        if ((i & 24576) != 16384) {
            z2 = false;
        }
        boolean z52 = zChanged2 | z2;
        if (((458752 & i) ^ 196608) <= 131072) {
        }
        if ((196608 & i) == 131072) {
        }
        boolean z622 = z52 | z3 | ((((3670016 & i) ^ 1572864) > 1048576 && composer.changed(f4)) || (i & 1572864) == 1048576);
        if (((234881024 & i) ^ 100663296) > 67108864) {
        }
        if ((i & 100663296) == 67108864) {
        }
        zChanged = z622 | z4 | composer.changed(graphicsContext);
        objRememberedValue = composer.rememberedValue();
        if (!zChanged) {
        }
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function22222 = (Function2) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
        }
        return function22222;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float startPadding(PaddingValues paddingValues, Orientation orientation, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        if (i == 2) {
            return paddingValues.getTop();
        }
        throw new NoWhenBranchMatchedException();
    }
}
