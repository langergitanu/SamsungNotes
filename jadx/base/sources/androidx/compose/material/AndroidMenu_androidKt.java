package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.TransformOrigin;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.IntRect;
import androidx.compose.p109ui.window.AndroidPopup_androidKt;
import androidx.compose.p109ui.window.PopupProperties;
import androidx.compose.p109ui.window.SecureFlagPolicy;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aa\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, m13886d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", TypedValues.Cycle.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/DpOffset;", StringLookupFactory.KEY_PROPERTIES, "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AndroidMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0149  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16583DropdownMenuILWXrKs(boolean z, @NotNull final Function0<Unit> onDismissRequest, @Nullable Modifier modifier, long j, @Nullable PopupProperties popupProperties, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        boolean z2;
        int i4;
        final Modifier modifier2;
        int i5;
        long jM20989DpOffsetYgX7TsA;
        PopupProperties popupProperties2;
        final int i6;
        long j2;
        PopupProperties popupProperties3;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableTransitionState mutableTransitionState;
        Object objRememberedValue2;
        final MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue3;
        Modifier modifier3;
        Composer composer2;
        PopupProperties popupProperties4;
        final PopupProperties popupProperties5;
        Composer composer3;
        final long j3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-840283139);
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
        int i8 = i2 & 4;
        if (i8 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    jM20989DpOffsetYgX7TsA = j;
                    i4 |= composerStartRestartGroup.changed(jM20989DpOffsetYgX7TsA) ? 2048 : 1024;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        popupProperties2 = popupProperties;
                        int i9 = composerStartRestartGroup.changed(popupProperties2) ? 16384 : 8192;
                        i4 |= i9;
                    } else {
                        popupProperties2 = popupProperties;
                    }
                    i4 |= i9;
                } else {
                    popupProperties2 = popupProperties;
                }
                if ((i2 & 32) == 0) {
                    i7 = (458752 & i) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                    if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 != 0) {
                                float f = 0;
                                jM20989DpOffsetYgX7TsA = DpKt.m20989DpOffsetYgX7TsA(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f));
                            }
                            if ((i2 & 16) == 0) {
                                i6 = i4 & (-57345);
                                modifier2 = modifier5;
                                j2 = jM20989DpOffsetYgX7TsA;
                                popupProperties3 = new PopupProperties(true, false, false, (SecureFlagPolicy) null, false, false, 62, (DefaultConstructorMarker) null);
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-840283139, i6, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:73)");
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
                                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                                    zChanged = composerStartRestartGroup.changed(mutableState);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged || objRememberedValue3 == companion.getEmpty()) {
                                        objRememberedValue3 = new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
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
                                            public final void invoke2(@NotNull IntRect parentBounds, @NotNull IntRect menuBounds) {
                                                Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
                                                Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
                                                mutableState.setValue(TransformOrigin.m18903boximpl(MenuKt.calculateTransformOrigin(parentBounds, menuBounds)));
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    DropdownMenuPositionProvider dropdownMenuPositionProvider = new DropdownMenuPositionProvider(j2, density, (Function2) objRememberedValue3, null);
                                    modifier3 = modifier2;
                                    composer2 = composerStartRestartGroup;
                                    popupProperties4 = popupProperties3;
                                    AndroidPopup_androidKt.Popup(dropdownMenuPositionProvider, onDismissRequest, popupProperties4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 79632374, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i10) {
                                            if ((i10 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(79632374, i10, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:98)");
                                            }
                                            MutableTransitionState<Boolean> mutableTransitionState2 = mutableTransitionState;
                                            MutableState<TransformOrigin> mutableState2 = mutableState;
                                            Modifier modifier6 = modifier2;
                                            Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                                            int i11 = MutableTransitionState.$stable | 48;
                                            int i12 = i6;
                                            MenuKt.DropdownMenuContent(mutableTransitionState2, mutableState2, modifier6, function3, composer4, i11 | (i12 & 896) | ((i12 >> 6) & 7168), 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, (i6 & 112) | 3072 | ((i6 >> 6) & 896), 0);
                                } else {
                                    modifier3 = modifier2;
                                    composer2 = composerStartRestartGroup;
                                    popupProperties4 = popupProperties3;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                popupProperties5 = popupProperties4;
                                composer3 = composer2;
                                j3 = j2;
                                modifier4 = modifier3;
                            } else {
                                i6 = i4;
                                modifier2 = modifier5;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                            i6 = i4;
                        }
                        popupProperties3 = popupProperties2;
                        j2 = jM20989DpOffsetYgX7TsA;
                        composerStartRestartGroup.endDefaults();
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
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged = composerStartRestartGroup.changed(mutableState);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
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
                                    public final void invoke2(@NotNull IntRect parentBounds, @NotNull IntRect menuBounds) {
                                        Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
                                        Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
                                        mutableState.setValue(TransformOrigin.m18903boximpl(MenuKt.calculateTransformOrigin(parentBounds, menuBounds)));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                composerStartRestartGroup.endReplaceableGroup();
                                DropdownMenuPositionProvider dropdownMenuPositionProvider2 = new DropdownMenuPositionProvider(j2, density2, (Function2) objRememberedValue3, null);
                                modifier3 = modifier2;
                                composer2 = composerStartRestartGroup;
                                popupProperties4 = popupProperties3;
                                AndroidPopup_androidKt.Popup(dropdownMenuPositionProvider2, onDismissRequest, popupProperties4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 79632374, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer4, int i10) {
                                        if ((i10 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(79632374, i10, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:98)");
                                        }
                                        MutableTransitionState<Boolean> mutableTransitionState2 = mutableTransitionState;
                                        MutableState<TransformOrigin> mutableState2 = mutableState;
                                        Modifier modifier6 = modifier2;
                                        Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                                        int i11 = MutableTransitionState.$stable | 48;
                                        int i12 = i6;
                                        MenuKt.DropdownMenuContent(mutableTransitionState2, mutableState2, modifier6, function3, composer4, i11 | (i12 & 896) | ((i12 >> 6) & 7168), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, (i6 & 112) | 3072 | ((i6 >> 6) & 896), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                popupProperties5 = popupProperties4;
                                composer3 = composer2;
                                j3 = j2;
                                modifier4 = modifier3;
                            }
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        composer3 = composerStartRestartGroup;
                        j3 = jM20989DpOffsetYgX7TsA;
                        popupProperties5 = popupProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final boolean z3 = z2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer4, int i10) {
                            AndroidMenu_androidKt.m16583DropdownMenuILWXrKs(z3, onDismissRequest, modifier4, j3, popupProperties5, content, composer4, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i7;
                if ((374491 & i4) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            jM20989DpOffsetYgX7TsA = j;
            if ((57344 & i) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            i4 |= i7;
            if ((374491 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        jM20989DpOffsetYgX7TsA = j;
        if ((57344 & i) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i4 |= i7;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0130  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItem(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable PaddingValues paddingValues, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        PaddingValues dropdownMenuItemContentPadding;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        final MutableInteractionSource mutableInteractionSource4;
        final PaddingValues paddingValues2;
        final boolean z3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1988562892);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
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
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        dropdownMenuItemContentPadding = paddingValues;
                        i4 |= composerStartRestartGroup.changed(dropdownMenuItemContentPadding) ? 2048 : 1024;
                    }
                    i7 = i2 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((57344 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                        }
                        if ((i2 & 32) == 0) {
                            i8 = (458752 & i) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                            if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                                Modifier modifier4 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                }
                                if (i7 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1988562892, i4, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:127)");
                                }
                                int i10 = i4 & 524286;
                                boolean z4 = z2;
                                Modifier modifier5 = modifier4;
                                PaddingValues paddingValues3 = dropdownMenuItemContentPadding;
                                MenuKt.DropdownMenuItemContent(onClick, modifier5, z4, paddingValues3, mutableInteractionSource3, content, composerStartRestartGroup, i10, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource4 = mutableInteractionSource3;
                                paddingValues2 = paddingValues3;
                                z3 = z4;
                                modifier3 = modifier5;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                z3 = z2;
                                paddingValues2 = dropdownMenuItemContentPadding;
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt.DropdownMenuItem.2
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

                                public final void invoke(@Nullable Composer composer2, int i11) {
                                    AndroidMenu_androidKt.DropdownMenuItem(onClick, modifier3, z3, paddingValues2, mutableInteractionSource4, content, composer2, i | 1, i2);
                                }
                            });
                            return;
                        }
                        i4 |= i8;
                        if ((374491 & i4) == 74898) {
                            if (i9 == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i102 = i4 & 524286;
                            boolean z42 = z2;
                            Modifier modifier52 = modifier4;
                            PaddingValues paddingValues32 = dropdownMenuItemContentPadding;
                            MenuKt.DropdownMenuItemContent(onClick, modifier52, z42, paddingValues32, mutableInteractionSource3, content, composerStartRestartGroup, i102, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = paddingValues32;
                            z3 = z42;
                            modifier3 = modifier52;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 32) == 0) {
                    }
                    i4 |= i8;
                    if ((374491 & i4) == 74898) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                dropdownMenuItemContentPadding = paddingValues;
                i7 = i2 & 16;
                if (i7 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) == 0) {
                }
                i4 |= i8;
                if ((374491 & i4) == 74898) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            dropdownMenuItemContentPadding = paddingValues;
            i7 = i2 & 16;
            if (i7 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) == 0) {
            }
            i4 |= i8;
            if ((374491 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        dropdownMenuItemContentPadding = paddingValues;
        i7 = i2 & 16;
        if (i7 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) == 0) {
        }
        i4 |= i8;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
