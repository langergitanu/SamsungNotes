package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.UiComposable;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a0\u0010\t\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\u0010\u001a \u0001\u0010\u0011\u001a\u00020\u0012*\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00070\f2.\b\u0002\u0010\u0016\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\u0002\b\b2A\u0010\u0017\u001a=\u0012\u0004\u0012\u00020\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0018¢\u0006\u0002\b\b\u001a6\u0010\u001f\u001a\u00020 *\u00020\r2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\"4\u0010\u0000\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\u0002\b\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, m13886d2 = {"defaultPlacementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Lkotlin/ParameterName;", "name", "lookaheadCoordinates", "", "Lkotlin/ExtensionFunctionType;", "LookaheadScope", "", "content", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LookaheadScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "approachLayout", "Landroidx/compose/ui/Modifier;", "isMeasurementApproachInProgress", "Landroidx/compose/ui/unit/IntSize;", "lookaheadSize", "isPlacementApproachInProgress", "approachMeasure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "coordinates", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-Fgt4K4Q", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLookaheadScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LookaheadScope.kt\nandroidx/compose/ui/layout/LookaheadScopeKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,284:1\n1225#2,6:285\n368#3,12:291\n*S KotlinDebug\n*F\n+ 1 LookaheadScope.kt\nandroidx/compose/ui/layout/LookaheadScopeKt\n*L\n52#1:285,6\n53#1:291,12\n*E\n"})
public final class LookaheadScopeKt {

    @NotNull
    private static final Function2<Placeable.PlacementScope, LayoutCoordinates, Boolean> defaultPlacementApproachInProgress = new Function2<Placeable.PlacementScope, LayoutCoordinates, Boolean>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$defaultPlacementApproachInProgress$1
        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final Boolean invoke(@NotNull Placeable.PlacementScope placementScope, @NotNull LayoutCoordinates layoutCoordinates) {
            return Boolean.FALSE;
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    @Composable
    @UiComposable
    public static final void LookaheadScope(@NotNull final Function3<? super LookaheadScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1078066484);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1078066484, i2, -1, "androidx.compose.ui.layout.LookaheadScope (LookaheadScope.kt:50)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new LookaheadScopeImpl(null, 1, 0 == true ? 1 : 0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LookaheadScopeImpl lookaheadScopeImpl = (LookaheadScopeImpl) objRememberedValue;
            C20991 c20991 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt.LookaheadScope.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LayoutNode invoke() {
                    return new LayoutNode(true, 0, 2, null);
                }
            };
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(c20991);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18022initimpl(composerM18018constructorimpl, new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
                    invoke2(layoutNode);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull LayoutNode layoutNode) {
                    layoutNode.setVirtualLookaheadRoot$ui_release(true);
                }
            });
            Updater.m18025setimpl(composerM18018constructorimpl, lookaheadScopeImpl, new Function2<LayoutNode, LookaheadScopeImpl, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LookaheadScopeImpl lookaheadScopeImpl2) {
                    invoke2(layoutNode, lookaheadScopeImpl2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull final LayoutNode layoutNode, @NotNull LookaheadScopeImpl lookaheadScopeImpl2) {
                    lookaheadScopeImpl2.setScopeCoordinates(new Function0<LayoutCoordinates>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$2$2.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final LayoutCoordinates invoke() {
                            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                            Intrinsics.checkNotNull(parent$ui_release);
                            return parent$ui_release.getInnerCoordinator$ui_release().getCoordinates();
                        }
                    });
                }
            });
            function3.invoke(lookaheadScopeImpl, composerStartRestartGroup, Integer.valueOf((i2 << 3) & 112));
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt.LookaheadScope.4
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    LookaheadScopeKt.LookaheadScope(function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @NotNull
    public static final Modifier approachLayout(@NotNull Modifier modifier, @NotNull Function1<? super IntSize, Boolean> function1, @NotNull Function2<? super Placeable.PlacementScope, ? super LayoutCoordinates, Boolean> function2, @NotNull Function3<? super ApproachMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3) {
        return modifier.then(new ApproachLayoutElement(function3, function1, function2));
    }

    public static /* synthetic */ Modifier approachLayout$default(Modifier modifier, Function1 function1, Function2 function2, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = defaultPlacementApproachInProgress;
        }
        return approachLayout(modifier, function1, function2, function3);
    }

    /* JADX INFO: renamed from: localLookaheadPositionOf-Fgt4K4Q, reason: not valid java name */
    public static final long m19884localLookaheadPositionOfFgt4K4Q(@NotNull LookaheadScope lookaheadScope, @NotNull LayoutCoordinates layoutCoordinates, @NotNull LayoutCoordinates layoutCoordinates2, long j, boolean z) {
        LayoutCoordinates lookaheadCoordinates = lookaheadScope.toLookaheadCoordinates(layoutCoordinates);
        LayoutCoordinates lookaheadCoordinates2 = lookaheadScope.toLookaheadCoordinates(layoutCoordinates2);
        return lookaheadCoordinates instanceof LookaheadLayoutCoordinates ? lookaheadCoordinates.mo19865localPositionOfS_NoaFU(lookaheadCoordinates2, j, z) : lookaheadCoordinates2 instanceof LookaheadLayoutCoordinates ? Offset.m18293unaryMinusF1C5BW0(lookaheadCoordinates2.mo19865localPositionOfS_NoaFU(lookaheadCoordinates, j, z)) : lookaheadCoordinates.mo19865localPositionOfS_NoaFU(lookaheadCoordinates, j, z);
    }
}
