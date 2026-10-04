package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0081\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002\u001a-\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00172\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\rH\u0007¢\u0006\u0002\u0010\u001d\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m13886d2 = {"DISMISS_THRESHOLD", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "SwipeToDismiss", "", "state", "Landroidx/compose/material/DismissState;", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material/DismissDirection;", "dismissThresholds", "Lkotlin/Function1;", "Landroidx/compose/material/ThresholdConfig;", "background", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "(Landroidx/compose/material/DismissState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getDismissDirection", Constants.MessagePayloadKeys.FROM, "Landroidx/compose/material/DismissValue;", "to", "rememberDismissState", "initialValue", "confirmStateChange", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DismissState;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwipeToDismissKt {
    private static final float DISMISS_THRESHOLD = C2256Dp.m20968constructorimpl(56);

    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013f  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SwipeToDismiss(@NotNull final DismissState state, @Nullable Modifier modifier, @Nullable Set<? extends DismissDirection> set, @Nullable Function1<? super DismissDirection, ? extends ThresholdConfig> function1, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> background, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> dismissContent, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        Function1<? super DismissDirection, ? extends ThresholdConfig> function12;
        Set<? extends DismissDirection> of;
        final int i7;
        final Set<? extends DismissDirection> set2;
        Modifier modifier3;
        final Function1<? super DismissDirection, ? extends ThresholdConfig> function13;
        final Set<? extends DismissDirection> set3;
        final Function1<? super DismissDirection, ? extends ThresholdConfig> function14;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(dismissContent, "dismissContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(634380143);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
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
            if (i5 != 0) {
                i4 |= 128;
            }
            i6 = i2 & 8;
            if (i6 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    function12 = function1;
                    i4 |= composerStartRestartGroup.changed(function12) ? 2048 : 1024;
                }
                if ((i2 & 16) != 0) {
                    i4 |= 24576;
                } else if ((57344 & i) == 0) {
                    i4 |= composerStartRestartGroup.changed(background) ? 16384 : 8192;
                }
                if ((i2 & 32) == 0) {
                    i8 = (458752 & i) == 0 ? composerStartRestartGroup.changed(dismissContent) ? 131072 : 65536 : 196608;
                    if (i5 != 4 && (374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        set3 = set;
                        modifier4 = modifier2;
                        function14 = function12;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 == 0) {
                                of = SetsKt.setOf((Object[]) new DismissDirection[]{DismissDirection.EndToStart, DismissDirection.StartToEnd});
                                i4 &= -897;
                            } else {
                                of = set;
                            }
                            if (i6 == 0) {
                                Set<? extends DismissDirection> set4 = of;
                                i7 = i4;
                                set2 = set4;
                                modifier3 = modifier5;
                                function13 = new Function1<DismissDirection, FixedThreshold>() { // from class: androidx.compose.material.SwipeToDismissKt.SwipeToDismiss.1
                                    @Override // kotlin.jvm.functions.Function1
                                    @NotNull
                                    public final FixedThreshold invoke(@NotNull DismissDirection it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return new FixedThreshold(SwipeToDismissKt.DISMISS_THRESHOLD, null);
                                    }
                                };
                            } else {
                                Set<? extends DismissDirection> set5 = of;
                                i7 = i4;
                                set2 = set5;
                                modifier3 = modifier5;
                                function13 = function12;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if (i5 != 0) {
                                i4 &= -897;
                            }
                            i7 = i4;
                            modifier3 = modifier2;
                            function13 = function12;
                            set2 = set;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(634380143, i7, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:172)");
                        }
                        BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt.SwipeToDismiss.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                                invoke(boxWithConstraintsScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer2, int i10) {
                                int i11;
                                Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                                if ((i10 & 14) == 0) {
                                    i11 = (composer2.changed(BoxWithConstraints) ? 4 : 2) | i10;
                                } else {
                                    i11 = i10;
                                }
                                if ((i11 & 91) == 18 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(338007641, i10, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:181)");
                                }
                                float fM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
                                boolean z = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                                Float fValueOf = Float.valueOf(0.0f);
                                DismissValue dismissValue = DismissValue.Default;
                                Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.m13893to(fValueOf, dismissValue));
                                Set<DismissDirection> set6 = set2;
                                DismissDirection dismissDirection = DismissDirection.StartToEnd;
                                if (set6.contains(dismissDirection)) {
                                    Pair pairM13893to = TuplesKt.m13893to(Float.valueOf(fM20921getMaxWidthimpl), DismissValue.DismissedToEnd);
                                    mapMutableMapOf.put(pairM13893to.getFirst(), pairM13893to.getSecond());
                                }
                                Set<DismissDirection> set7 = set2;
                                DismissDirection dismissDirection2 = DismissDirection.EndToStart;
                                if (set7.contains(dismissDirection2)) {
                                    Pair pairM13893to2 = TuplesKt.m13893to(Float.valueOf(-fM20921getMaxWidthimpl), DismissValue.DismissedToStart);
                                    mapMutableMapOf.put(pairM13893to2.getFirst(), pairM13893to2.getSecond());
                                }
                                final Function1<DismissDirection, ThresholdConfig> function15 = function13;
                                composer2.startReplaceableGroup(1157296644);
                                boolean zChanged = composer2.changed(function15);
                                Object objRememberedValue = composer2.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        @NotNull
                                        public final ThresholdConfig invoke(@NotNull DismissValue from, @NotNull DismissValue to) {
                                            Intrinsics.checkNotNullParameter(from, "from");
                                            Intrinsics.checkNotNullParameter(to, "to");
                                            Function1<DismissDirection, ThresholdConfig> function16 = function15;
                                            DismissDirection dismissDirection3 = SwipeToDismissKt.getDismissDirection(from, to);
                                            Intrinsics.checkNotNull(dismissDirection3);
                                            return function16.invoke(dismissDirection3);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                Function2 function2 = (Function2) objRememberedValue;
                                float f = set2.contains(dismissDirection2) ? 10.0f : 20.0f;
                                float f4 = set2.contains(dismissDirection) ? 10.0f : 20.0f;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Modifier modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(companion, state, mapMutableMapOf, Orientation.Horizontal, (32 & 8) != 0 ? true : state.getCurrentValue() == dismissValue, (32 & 16) != 0 ? false : z, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                    @Override // kotlin.jvm.functions.Function2
                                    @NotNull
                                    public final FixedThreshold invoke(Object obj, Object obj2) {
                                        return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
                                    }
                                } : function2, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(fM20921getMaxWidthimpl, f, f4), (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : 0.0f);
                                Function3<RowScope, Composer, Integer, Unit> function3 = background;
                                int i12 = i7;
                                final DismissState dismissState = state;
                                Function3<RowScope, Composer, Integer, Unit> function32 = dismissContent;
                                composer2.startReplaceableGroup(733328855);
                                Alignment.Companion companion2 = Alignment.INSTANCE;
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer2, 0, -1323940314);
                                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16882swipeablepPrIpRY);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(981834387);
                                Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(companion);
                                int i13 = (i12 >> 3) & 7168;
                                composer2.startReplaceableGroup(693286680);
                                Arrangement arrangement = Arrangement.INSTANCE;
                                MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion2, arrangement.getStart(), composer2, 0, -1323940314);
                                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierMatchParentSize);
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
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1208i, composerM18018constructorimpl2, density2));
                                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                function3.invoke(rowScopeInstance, composer2, Integer.valueOf(((i13 >> 6) & 112) | 6));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.startReplaceableGroup(1157296644);
                                boolean zChanged2 = composer2.changed(dismissState);
                                Object objRememberedValue2 = composer2.rememberedValue();
                                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                            return IntOffset.m21087boximpl(m16880invokeBjo55l4(density3));
                                        }

                                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                        public final long m16880invokeBjo55l4(@NotNull Density offset) {
                                            Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                            return IntOffsetKt.IntOffset(MathKt.roundToInt(dismissState.getOffset().getValue().floatValue()), 0);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue2);
                                }
                                composer2.endReplaceableGroup();
                                Modifier modifierOffset = OffsetKt.offset(companion, (Function1) objRememberedValue2);
                                int i14 = (i12 >> 6) & 7168;
                                composer2.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyM1208i2 = AbstractC1038a.m1208i(companion2, arrangement.getStart(), composer2, 0, -1323940314);
                                Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierOffset);
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
                                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyM1208i2, composerM18018constructorimpl3, density3));
                                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer2, composer2), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                function32.invoke(rowScopeInstance, composer2, Integer.valueOf(((i14 >> 6) & 112) | 6));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        set3 = set2;
                        function14 = function13;
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt.SwipeToDismiss.3
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
                            SwipeToDismissKt.SwipeToDismiss(state, modifier4, set3, function14, background, dismissContent, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i8;
                if (i5 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt.SwipeToDismiss.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                                invoke(boxWithConstraintsScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer2, int i10) {
                                int i11;
                                Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                                if ((i10 & 14) == 0) {
                                    i11 = (composer2.changed(BoxWithConstraints) ? 4 : 2) | i10;
                                } else {
                                    i11 = i10;
                                }
                                if ((i11 & 91) == 18 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(338007641, i10, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:181)");
                                }
                                float fM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(BoxWithConstraints.mo15761getConstraintsmsEJaDk());
                                boolean z = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                                Float fValueOf = Float.valueOf(0.0f);
                                DismissValue dismissValue = DismissValue.Default;
                                Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.m13893to(fValueOf, dismissValue));
                                Set<DismissDirection> set6 = set2;
                                DismissDirection dismissDirection = DismissDirection.StartToEnd;
                                if (set6.contains(dismissDirection)) {
                                    Pair pairM13893to = TuplesKt.m13893to(Float.valueOf(fM20921getMaxWidthimpl), DismissValue.DismissedToEnd);
                                    mapMutableMapOf.put(pairM13893to.getFirst(), pairM13893to.getSecond());
                                }
                                Set<DismissDirection> set7 = set2;
                                DismissDirection dismissDirection2 = DismissDirection.EndToStart;
                                if (set7.contains(dismissDirection2)) {
                                    Pair pairM13893to2 = TuplesKt.m13893to(Float.valueOf(-fM20921getMaxWidthimpl), DismissValue.DismissedToStart);
                                    mapMutableMapOf.put(pairM13893to2.getFirst(), pairM13893to2.getSecond());
                                }
                                final Function1<? super DismissDirection, ? extends ThresholdConfig> function15 = function13;
                                composer2.startReplaceableGroup(1157296644);
                                boolean zChanged = composer2.changed(function15);
                                Object objRememberedValue = composer2.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        @NotNull
                                        public final ThresholdConfig invoke(@NotNull DismissValue from, @NotNull DismissValue to) {
                                            Intrinsics.checkNotNullParameter(from, "from");
                                            Intrinsics.checkNotNullParameter(to, "to");
                                            Function1<DismissDirection, ThresholdConfig> function16 = function15;
                                            DismissDirection dismissDirection3 = SwipeToDismissKt.getDismissDirection(from, to);
                                            Intrinsics.checkNotNull(dismissDirection3);
                                            return function16.invoke(dismissDirection3);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                Function2 function2 = (Function2) objRememberedValue;
                                float f = set2.contains(dismissDirection2) ? 10.0f : 20.0f;
                                float f4 = set2.contains(dismissDirection) ? 10.0f : 20.0f;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Modifier modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(companion, state, mapMutableMapOf, Orientation.Horizontal, (32 & 8) != 0 ? true : state.getCurrentValue() == dismissValue, (32 & 16) != 0 ? false : z, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                    @Override // kotlin.jvm.functions.Function2
                                    @NotNull
                                    public final FixedThreshold invoke(Object obj, Object obj2) {
                                        return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
                                    }
                                } : function2, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(fM20921getMaxWidthimpl, f, f4), (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : 0.0f);
                                Function3<RowScope, Composer, Integer, Unit> function3 = background;
                                int i12 = i7;
                                final DismissState dismissState = state;
                                Function3<RowScope, Composer, Integer, Unit> function32 = dismissContent;
                                composer2.startReplaceableGroup(733328855);
                                Alignment.Companion companion2 = Alignment.INSTANCE;
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer2, 0, -1323940314);
                                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16882swipeablepPrIpRY);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(981834387);
                                Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(companion);
                                int i13 = (i12 >> 3) & 7168;
                                composer2.startReplaceableGroup(693286680);
                                Arrangement arrangement = Arrangement.INSTANCE;
                                MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion2, arrangement.getStart(), composer2, 0, -1323940314);
                                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierMatchParentSize);
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
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1208i, composerM18018constructorimpl2, density2));
                                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                function3.invoke(rowScopeInstance, composer2, Integer.valueOf(((i13 >> 6) & 112) | 6));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.startReplaceableGroup(1157296644);
                                boolean zChanged2 = composer2.changed(dismissState);
                                Object objRememberedValue2 = composer2.rememberedValue();
                                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                            return IntOffset.m21087boximpl(m16880invokeBjo55l4(density3));
                                        }

                                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                        public final long m16880invokeBjo55l4(@NotNull Density offset) {
                                            Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                            return IntOffsetKt.IntOffset(MathKt.roundToInt(dismissState.getOffset().getValue().floatValue()), 0);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue2);
                                }
                                composer2.endReplaceableGroup();
                                Modifier modifierOffset = OffsetKt.offset(companion, (Function1) objRememberedValue2);
                                int i14 = (i12 >> 6) & 7168;
                                composer2.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyM1208i2 = AbstractC1038a.m1208i(companion2, arrangement.getStart(), composer2, 0, -1323940314);
                                Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierOffset);
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
                                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyM1208i2, composerM18018constructorimpl3, density3));
                                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer2, composer2), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                function32.invoke(rowScopeInstance, composer2, Integer.valueOf(((i14 >> 6) & 112) | 6));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        set3 = set2;
                        function14 = function13;
                        modifier4 = modifier3;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function12 = function1;
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) == 0) {
            }
            i4 |= i8;
            if (i5 != 4) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 != 0) {
        }
        i6 = i2 & 8;
        if (i6 == 0) {
        }
        function12 = function1;
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i4 |= i8;
        if (i5 != 4) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DismissDirection getDismissDirection(DismissValue dismissValue, DismissValue dismissValue2) {
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.Default) {
            return null;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        DismissValue dismissValue3 = DismissValue.Default;
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.DismissedToEnd && dismissValue2 == dismissValue3) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.DismissedToStart && dismissValue2 == dismissValue3) {
            return DismissDirection.EndToStart;
        }
        return null;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final DismissState rememberDismissState(@Nullable final DismissValue dismissValue, @Nullable final Function1<? super DismissValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1753522702);
        if ((i2 & 1) != 0) {
            dismissValue = DismissValue.Default;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1<DismissValue, Boolean>() { // from class: androidx.compose.material.SwipeToDismissKt.rememberDismissState.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull DismissValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1753522702, i, -1, "androidx.compose.material.rememberDismissState (SwipeToDismiss.kt:148)");
        }
        Object[] objArr = new Object[0];
        Saver<DismissState, DismissValue> Saver = DismissState.INSTANCE.Saver(function1);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(dismissValue) | composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0<DismissState>() { // from class: androidx.compose.material.SwipeToDismissKt$rememberDismissState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final DismissState invoke() {
                    return new DismissState(dismissValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DismissState dismissState = (DismissState) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dismissState;
    }
}
