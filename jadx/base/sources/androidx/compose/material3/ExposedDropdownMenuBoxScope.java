package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.internal.ExposedDropdownMenuPopupKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.TransformOrigin;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpOffset;
import androidx.compose.p109ui.unit.IntRect;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterial3Api
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0005H&J\f\u0010\u0012\u001a\u00020\t*\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "menuAnchor", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface ExposedDropdownMenuBoxScope {
    static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019e  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    default void ExposedDropdownMenu(boolean z, @NotNull final Function0<Unit> onDismissRequest, @Nullable Modifier modifier, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        boolean z2;
        int i4;
        Modifier modifier2;
        ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope;
        Modifier modifier3;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableTransitionState mutableTransitionState;
        Object objRememberedValue2;
        final MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue3;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1658683708);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 14) == 0) {
                i4 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onDismissRequest) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                i4 |= composerStartRestartGroup.changed(content) ? 2048 : 1024;
            }
            if ((i2 & 16) != 0) {
                if ((57344 & i) == 0) {
                    exposedDropdownMenuBoxScope = this;
                    i4 |= composerStartRestartGroup.changed(exposedDropdownMenuBoxScope) ? 16384 : 8192;
                }
                if ((46811 & i4) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                } else {
                    modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1658683708, i4, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:242)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new MutableTransitionState(Boolean.FALSE);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    mutableTransitionState.setTargetState$animation_core_release(Boolean.valueOf(z2));
                    if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m18903boximpl(TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue2;
                        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        long jM21039getZeroRKDOV3M = DpOffset.INSTANCE.m21039getZeroRKDOV3M();
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(mutableState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                                    invoke2(intRect, intRect2);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull IntRect anchorBounds, @NotNull IntRect menuBounds) {
                                    Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
                                    Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
                                    mutableState.setValue(TransformOrigin.m18903boximpl(MenuKt.calculateTransformOrigin(anchorBounds, menuBounds)));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        DropdownMenuPositionProvider dropdownMenuPositionProvider = new DropdownMenuPositionProvider(jM21039getZeroRKDOV3M, density, (Function2) objRememberedValue3, null);
                        final ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope2 = exposedDropdownMenuBoxScope;
                        final int i6 = i4;
                        final Modifier modifier4 = modifier3;
                        Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.1
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
                            public final void invoke(@Nullable Composer composer3, int i7) {
                                if ((i7 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(395026654, i7, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:273)");
                                }
                                MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, ExposedDropdownMenuBoxScope.exposedDropdownSize$default(exposedDropdownMenuBoxScope2, modifier4, false, 1, null), content, composer3, MutableTransitionState.$stable | 48 | (i6 & 7168), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        modifier2 = modifier4;
                        composer2 = composerStartRestartGroup;
                        ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(onDismissRequest, dropdownMenuPositionProvider, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 395026654, true, function2), composer2, ((i6 >> 3) & 14) | 384, 0);
                    } else {
                        modifier2 = modifier3;
                        composer2 = composerStartRestartGroup;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                final Modifier modifier5 = modifier2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final boolean z3 = z2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.2
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

                    public final void invoke(@Nullable Composer composer3, int i7) {
                        ExposedDropdownMenuBoxScope.this.ExposedDropdownMenu(z3, onDismissRequest, modifier5, content, composer3, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= 24576;
            exposedDropdownMenuBoxScope = this;
            if ((46811 & i4) == 9362) {
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                mutableTransitionState.setTargetState$animation_core_release(Boolean.valueOf(z2));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    long jM21039getZeroRKDOV3M2 = DpOffset.INSTANCE.m21039getZeroRKDOV3M();
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(mutableState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                                invoke2(intRect, intRect2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull IntRect anchorBounds, @NotNull IntRect menuBounds) {
                                Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
                                Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
                                mutableState.setValue(TransformOrigin.m18903boximpl(MenuKt.calculateTransformOrigin(anchorBounds, menuBounds)));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        composerStartRestartGroup.endReplaceableGroup();
                        DropdownMenuPositionProvider dropdownMenuPositionProvider2 = new DropdownMenuPositionProvider(jM21039getZeroRKDOV3M2, density2, (Function2) objRememberedValue3, null);
                        final ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope22 = exposedDropdownMenuBoxScope;
                        final int i62 = i4;
                        final Modifier modifier42 = modifier3;
                        Function2<Composer, Integer, Unit> function22 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.1
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
                            public final void invoke(@Nullable Composer composer3, int i7) {
                                if ((i7 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(395026654, i7, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:273)");
                                }
                                MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, ExposedDropdownMenuBoxScope.exposedDropdownSize$default(exposedDropdownMenuBoxScope22, modifier42, false, 1, null), content, composer3, MutableTransitionState.$stable | 48 | (i62 & 7168), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        modifier2 = modifier42;
                        composer2 = composerStartRestartGroup;
                        ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(onDismissRequest, dropdownMenuPositionProvider2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 395026654, true, function22), composer2, ((i62 >> 3) & 14) | 384, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                }
            }
            final Modifier modifier52 = modifier2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) != 0) {
        }
        exposedDropdownMenuBoxScope = this;
        if ((46811 & i4) == 9362) {
        }
        final Modifier modifier522 = modifier2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @NotNull
    Modifier exposedDropdownSize(@NotNull Modifier modifier, boolean z);

    @NotNull
    Modifier menuAnchor(@NotNull Modifier modifier);
}
