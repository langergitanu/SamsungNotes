package androidx.compose.material3;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusRequester;
import androidx.compose.p109ui.focus.FocusRequesterModifierKt;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutCoordinatesKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.node.Ref;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.InspectableValueKt;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a6\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\bH\u0002\u001aE\u0010\u0018\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\u001e\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, m13886d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuDescription", "", "expandedDescription", "collapsedDescription", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ExposedDropdownMenuKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = C2256Dp.m20968constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015c A[LOOP:0: B:69:0x0159->B:71:0x015c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x024a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x024b  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExposedDropdownMenuBox(final boolean z, @NotNull final Function1<? super Boolean, Unit> onExpandedChange, @Nullable Modifier modifier, @NotNull final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        Modifier modifier2;
        final Density density;
        final View view;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object objRememberedValue2;
        final MutableState mutableState2;
        int iMo15540roundToPx0680j_4;
        Object objRememberedValue3;
        final Ref ref;
        Object objRememberedValue4;
        FocusRequester focusRequester;
        int i5;
        boolean zChanged;
        Object objRememberedValue5;
        final int i6;
        final FocusRequester focusRequester2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onExpandedChange, "onExpandedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1990697039);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onExpandedChange) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                i4 |= composerStartRestartGroup.changed(content) ? 2048 : 1024;
            }
            if ((i4 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1990697039, i4, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:102)");
                }
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState2 = (MutableState) objRememberedValue2;
                iMo15540roundToPx0680j_4 = density.mo15540roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ref = (Ref) objRememberedValue3;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue4;
                Object[] objArr = {Boolean.valueOf(z), onExpandedChange, density, Integer.valueOf(m17153ExposedDropdownMenuBox$lambda4(mutableState2)), Integer.valueOf(m17151ExposedDropdownMenuBox$lambda1(mutableState))};
                composerStartRestartGroup.startReplaceableGroup(-568225417);
                zChanged = false;
                for (i5 = 0; i5 < 5; i5++) {
                    zChanged |= composerStartRestartGroup.changed(objArr[i5]);
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    i6 = iMo15540roundToPx0680j_4;
                    focusRequester2 = focusRequester;
                    objRememberedValue5 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        @NotNull
                        public Modifier exposedDropdownSize(@NotNull Modifier modifier5, boolean z2) {
                            Intrinsics.checkNotNullParameter(modifier5, "<this>");
                            Density density2 = density;
                            MutableState<Integer> mutableState3 = mutableState2;
                            MutableState<Integer> mutableState4 = mutableState;
                            Modifier modifierM15887heightInVpY3zN4$default = SizeKt.m15887heightInVpY3zN4$default(modifier5, 0.0f, density2.mo15543toDpu2uoSUM(ExposedDropdownMenuKt.m17153ExposedDropdownMenuBox$lambda4(mutableState3)), 1, null);
                            return z2 ? SizeKt.m15904width3ABfNKs(modifierM15887heightInVpY3zN4$default, density2.mo15543toDpu2uoSUM(ExposedDropdownMenuKt.m17151ExposedDropdownMenuBox$lambda1(mutableState4))) : modifierM15887heightInVpY3zN4$default;
                        }

                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        @NotNull
                        public Modifier menuAnchor(@NotNull Modifier modifier5) {
                            Intrinsics.checkNotNullParameter(modifier5, "<this>");
                            Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                                    invoke2(inspectorInfo);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                                    Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                                    inspectorInfo.setName("menuAnchor");
                                }
                            } : InspectableValueKt.getNoInspectorInfo();
                            final boolean z2 = z;
                            final Function1<Boolean, Unit> function1 = onExpandedChange;
                            final int i8 = i4;
                            final FocusRequester focusRequester3 = focusRequester2;
                            final Ref<LayoutCoordinates> ref2 = ref;
                            final View view2 = view;
                            final int i9 = i6;
                            final MutableState<Integer> mutableState3 = mutableState;
                            final MutableState<Integer> mutableState4 = mutableState2;
                            return ComposedModifierKt.composed(modifier5, noInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier6, Composer composer2, Integer num) {
                                    return invoke(modifier6, composer2, num.intValue());
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                @NotNull
                                public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer2, int i10) {
                                    Intrinsics.checkNotNullParameter(composed, "$this$composed");
                                    composer2.startReplaceableGroup(1714866713);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1714866713, i10, -1, "androidx.compose.material3.ExposedDropdownMenuBox.<anonymous>.<no name provided>.menuAnchor.<anonymous> (ExposedDropdownMenu.kt:120)");
                                    }
                                    final Ref<LayoutCoordinates> ref3 = ref2;
                                    final View view3 = view2;
                                    final int i11 = i9;
                                    final MutableState<Integer> mutableState5 = mutableState3;
                                    final MutableState<Integer> mutableState6 = mutableState4;
                                    Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(composed, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                            invoke2(layoutCoordinates);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull LayoutCoordinates it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            ExposedDropdownMenuKt.m17152ExposedDropdownMenuBox$lambda2(mutableState5, IntSize.m21138getWidthimpl(it.mo19863getSizeYbymL2g()));
                                            ref3.setValue(it);
                                            View rootView = view3.getRootView();
                                            Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                            LayoutCoordinates value = ref3.getValue();
                                            int i12 = i11;
                                            final MutableState<Integer> mutableState7 = mutableState6;
                                            ExposedDropdownMenuKt.updateHeight(rootView, value, i12, new Function1<Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox.scope.1.1.menuAnchor.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                                    invoke(num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(int i13) {
                                                    ExposedDropdownMenuKt.m17154ExposedDropdownMenuBox$lambda5(mutableState7, i13);
                                                }
                                            });
                                        }
                                    });
                                    boolean z3 = z2;
                                    Function1<Boolean, Unit> function12 = function1;
                                    Boolean boolValueOf = Boolean.valueOf(z3);
                                    final Function1<Boolean, Unit> function13 = function1;
                                    final boolean z4 = z2;
                                    composer2.startReplaceableGroup(511388516);
                                    boolean zChanged2 = composer2.changed(function12) | composer2.changed(boolValueOf);
                                    Object objRememberedValue6 = composer2.rememberedValue();
                                    if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue6 = new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$2$1
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
                                                function13.invoke(Boolean.valueOf(!z4));
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue6);
                                    }
                                    composer2.endReplaceableGroup();
                                    Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(ExposedDropdownMenuKt.expandable(modifierOnGloballyPositioned, z3, (Function0) objRememberedValue6, null, null, null, composer2, (i8 << 3) & 112, 28), focusRequester3);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceableGroup();
                                    return modifierFocusRequester;
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    i6 = iMo15540roundToPx0680j_4;
                    focusRequester2 = focusRequester;
                }
                composerStartRestartGroup.endReplaceableGroup();
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue5;
                int i8 = i4 >> 6;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier4);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor);
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density2));
                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-738793417);
                content.invoke(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1, composerStartRestartGroup, Integer.valueOf(i8 & 112));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox.2
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
                        if (z) {
                            focusRequester2.requestFocus();
                        }
                    }
                }, composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(view, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        final View view2 = view;
                        final Ref<LayoutCoordinates> ref2 = ref;
                        final int i9 = i6;
                        final MutableState<Integer> mutableState3 = mutableState2;
                        final OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(view2, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1
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
                                View rootView = view2.getRootView();
                                Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                LayoutCoordinates value = ref2.getValue();
                                int i10 = i9;
                                final MutableState<Integer> mutableState4 = mutableState3;
                                ExposedDropdownMenuKt.updateHeight(rootView, value, i10, new Function1<Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int i11) {
                                        ExposedDropdownMenuKt.m17154ExposedDropdownMenuBox$lambda5(mutableState4, i11);
                                    }
                                });
                            }
                        });
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                onGlobalLayoutListener.dispose();
                            }
                        };
                    }
                }, composerStartRestartGroup, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox.4
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
                    ExposedDropdownMenuKt.ExposedDropdownMenuBox(z, onExpandedChange, modifier3, content, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i4 & 5851) == 1170) {
            if (i7 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState2 = (MutableState) objRememberedValue2;
            iMo15540roundToPx0680j_4 = density.mo15540roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            ref = (Ref) objRememberedValue3;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            focusRequester = (FocusRequester) objRememberedValue4;
            Object[] objArr2 = {Boolean.valueOf(z), onExpandedChange, density, Integer.valueOf(m17153ExposedDropdownMenuBox$lambda4(mutableState2)), Integer.valueOf(m17151ExposedDropdownMenuBox$lambda1(mutableState))};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            zChanged = false;
            while (i5 < 5) {
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                i6 = iMo15540roundToPx0680j_4;
                focusRequester2 = focusRequester;
                objRememberedValue5 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    @NotNull
                    public Modifier exposedDropdownSize(@NotNull Modifier modifier5, boolean z2) {
                        Intrinsics.checkNotNullParameter(modifier5, "<this>");
                        Density density22 = density;
                        MutableState<Integer> mutableState3 = mutableState2;
                        MutableState<Integer> mutableState4 = mutableState;
                        Modifier modifierM15887heightInVpY3zN4$default = SizeKt.m15887heightInVpY3zN4$default(modifier5, 0.0f, density22.mo15543toDpu2uoSUM(ExposedDropdownMenuKt.m17153ExposedDropdownMenuBox$lambda4(mutableState3)), 1, null);
                        return z2 ? SizeKt.m15904width3ABfNKs(modifierM15887heightInVpY3zN4$default, density22.mo15543toDpu2uoSUM(ExposedDropdownMenuKt.m17151ExposedDropdownMenuBox$lambda1(mutableState4))) : modifierM15887heightInVpY3zN4$default;
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    @NotNull
                    public Modifier menuAnchor(@NotNull Modifier modifier5) {
                        Intrinsics.checkNotNullParameter(modifier5, "<this>");
                        Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                                invoke2(inspectorInfo);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                                inspectorInfo.setName("menuAnchor");
                            }
                        } : InspectableValueKt.getNoInspectorInfo();
                        final boolean z2 = z;
                        final Function1<? super Boolean, Unit> function1 = onExpandedChange;
                        final int i82 = i4;
                        final FocusRequester focusRequester3 = focusRequester2;
                        final Ref<LayoutCoordinates> ref2 = ref;
                        final View view2 = view;
                        final int i9 = i6;
                        final MutableState<Integer> mutableState3 = mutableState;
                        final MutableState<Integer> mutableState4 = mutableState2;
                        return ComposedModifierKt.composed(modifier5, noInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier6, Composer composer2, Integer num) {
                                return invoke(modifier6, composer2, num.intValue());
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            @NotNull
                            public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer2, int i10) {
                                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                                composer2.startReplaceableGroup(1714866713);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1714866713, i10, -1, "androidx.compose.material3.ExposedDropdownMenuBox.<anonymous>.<no name provided>.menuAnchor.<anonymous> (ExposedDropdownMenu.kt:120)");
                                }
                                final Ref<LayoutCoordinates> ref3 = ref2;
                                final View view3 = view2;
                                final int i11 = i9;
                                final MutableState<Integer> mutableState5 = mutableState3;
                                final MutableState<Integer> mutableState6 = mutableState4;
                                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(composed, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                        invoke2(layoutCoordinates);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull LayoutCoordinates it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        ExposedDropdownMenuKt.m17152ExposedDropdownMenuBox$lambda2(mutableState5, IntSize.m21138getWidthimpl(it.mo19863getSizeYbymL2g()));
                                        ref3.setValue(it);
                                        View rootView = view3.getRootView();
                                        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                        LayoutCoordinates value = ref3.getValue();
                                        int i12 = i11;
                                        final MutableState<Integer> mutableState7 = mutableState6;
                                        ExposedDropdownMenuKt.updateHeight(rootView, value, i12, new Function1<Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox.scope.1.1.menuAnchor.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                                invoke(num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(int i13) {
                                                ExposedDropdownMenuKt.m17154ExposedDropdownMenuBox$lambda5(mutableState7, i13);
                                            }
                                        });
                                    }
                                });
                                boolean z3 = z2;
                                Function1<Boolean, Unit> function12 = function1;
                                Boolean boolValueOf = Boolean.valueOf(z3);
                                final Function1<? super Boolean, Unit> function13 = function1;
                                final boolean z4 = z2;
                                composer2.startReplaceableGroup(511388516);
                                boolean zChanged2 = composer2.changed(function12) | composer2.changed(boolValueOf);
                                Object objRememberedValue6 = composer2.rememberedValue();
                                if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$2$1
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
                                            function13.invoke(Boolean.valueOf(!z4));
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue6);
                                }
                                composer2.endReplaceableGroup();
                                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(ExposedDropdownMenuKt.expandable(modifierOnGloballyPositioned, z3, (Function0) objRememberedValue6, null, null, null, composer2, (i82 << 3) & 112, 28), focusRequester3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2.endReplaceableGroup();
                                return modifierFocusRequester;
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                composerStartRestartGroup.endReplaceableGroup();
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$12 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue5;
                int i82 = i4 >> 6;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
                Density density22 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier4);
                if (composerStartRestartGroup.getApplier() == null) {
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl2, measurePolicyM1210k2, composerM18018constructorimpl2, density22));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-738793417);
                content.invoke(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$12, composerStartRestartGroup, Integer.valueOf(i82 & 112));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox.2
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
                        if (z) {
                            focusRequester2.requestFocus();
                        }
                    }
                }, composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(view, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        final View view2 = view;
                        final Ref<LayoutCoordinates> ref2 = ref;
                        final int i9 = i6;
                        final MutableState<Integer> mutableState3 = mutableState2;
                        final OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(view2, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1
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
                                View rootView = view2.getRootView();
                                Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                LayoutCoordinates value = ref2.getValue();
                                int i10 = i9;
                                final MutableState<Integer> mutableState4 = mutableState3;
                                ExposedDropdownMenuKt.updateHeight(rootView, value, i10, new Function1<Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int i11) {
                                        ExposedDropdownMenuKt.m17154ExposedDropdownMenuBox$lambda5(mutableState4, i11);
                                    }
                                });
                            }
                        });
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                onGlobalLayoutListener.dispose();
                            }
                        };
                    }
                }, composerStartRestartGroup, 8);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-1, reason: not valid java name */
    public static final int m17151ExposedDropdownMenuBox$lambda1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-2, reason: not valid java name */
    public static final void m17152ExposedDropdownMenuBox$lambda2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-4, reason: not valid java name */
    public static final int m17153ExposedDropdownMenuBox$lambda4(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-5, reason: not valid java name */
    public static final void m17154ExposedDropdownMenuBox$lambda5(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier expandable(Modifier modifier, final boolean z, final Function0<Unit> function0, String str, String str2, String str3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1006563320);
        if ((i2 & 4) != 0) {
            str = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17311getExposedDropdownMenuadMyvUU(), composer, 6);
        }
        final String str4 = str;
        final String strM17317getStringNWtq28 = (i2 & 8) != 0 ? Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17313getMenuExpandedadMyvUU(), composer, 6) : str2;
        final String strM17317getStringNWtq282 = (i2 & 16) != 0 ? Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17312getMenuCollapsedadMyvUU(), composer, 6) : str3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006563320, i, -1, "androidx.compose.material3.expandable (ExposedDropdownMenu.kt:522)");
        }
        Unit unit = Unit.INSTANCE;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(function0);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new ExposedDropdownMenuKt$expandable$1$1(function0, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue);
        Object[] objArr = {Boolean.valueOf(z), strM17317getStringNWtq28, strM17317getStringNWtq282, str4, function0};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged2 = false;
        for (int i4 = 0; i4 < 5; i4++) {
            zChanged2 |= composer.changed(objArr[i4]);
        }
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Function1<SemanticsPropertyReceiver, Unit> function1 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2$1
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
                    SemanticsPropertiesKt.setStateDescription(semantics, z ? strM17317getStringNWtq28 : strM17317getStringNWtq282);
                    SemanticsPropertiesKt.setContentDescription(semantics, str4);
                    final Function0<Unit> function02 = function0;
                    SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Boolean invoke() {
                            function02.invoke();
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                }
            };
            composer.updateRememberedValue(function1);
            objRememberedValue2 = function1;
        }
        composer.endReplaceableGroup();
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue2, 1, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierSemantics$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates layoutCoordinates, int i, Function1<? super Integer, Unit> function1) {
        if (layoutCoordinates == null) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        function1.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getTop() - rect.top, (rect.bottom - r1) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getBottom())) - i));
    }
}
