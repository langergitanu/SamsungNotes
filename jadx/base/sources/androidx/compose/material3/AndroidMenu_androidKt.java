package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
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
@Metadata(m13885d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u008e\u0001\u0010\u0013\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, m13886d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", TypedValues.Cycle.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/DpOffset;", StringLookupFactory.KEY_PROPERTIES, "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
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
    public static final void m16987DropdownMenuILWXrKs(boolean z, @NotNull final Function0<Unit> onDismissRequest, @Nullable Modifier modifier, long j, @Nullable PopupProperties popupProperties, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
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
        Composer composerStartRestartGroup = composer.startRestartGroup(354826666);
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
                                    ComposerKt.traceEventStart(354826666, i6, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)");
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
                                        objRememberedValue3 = new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
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
                                    AndroidPopup_androidKt.Popup(dropdownMenuPositionProvider, onDismissRequest, popupProperties4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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
                                                ComposerKt.traceEventStart(-1192563503, i10, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:98)");
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
                                objRememberedValue3 = new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
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
                                AndroidPopup_androidKt.Popup(dropdownMenuPositionProvider2, onDismissRequest, popupProperties4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1192563503, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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
                                            ComposerKt.traceEventStart(-1192563503, i10, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:98)");
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2
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
                            AndroidMenu_androidKt.m16987DropdownMenuILWXrKs(z3, onDismissRequest, modifier4, j3, popupProperties5, content, composer4, i | 1, i2);
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

    /* JADX WARN: Removed duplicated region for block: B:101:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0202 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0104  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItem(@NotNull final Function2<? super Composer, ? super Integer, Unit> text, @NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, boolean z, @Nullable MenuItemColors menuItemColors, @Nullable PaddingValues paddingValues, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i7;
        MenuItemColors menuItemColors2;
        int i8;
        int i9;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        int i11;
        MenuItemColors menuItemColorsM17217itemColors5tl4gsc;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function25;
        boolean z2;
        int i12;
        Function2<? super Composer, ? super Integer, Unit> function26;
        PaddingValues paddingValues2;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource4;
        final PaddingValues paddingValues3;
        final MenuItemColors menuItemColors3;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1826340448);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
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
                    function23 = function2;
                    i4 |= composerStartRestartGroup.changed(function23) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((57344 & i) == 0) {
                        function24 = function22;
                        i4 |= composerStartRestartGroup.changed(function24) ? 16384 : 8192;
                    }
                    i7 = i2 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else {
                        if ((458752 & i) == 0) {
                            i4 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                        }
                        if ((3670016 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                menuItemColors2 = menuItemColors;
                                int i14 = composerStartRestartGroup.changed(menuItemColors2) ? 1048576 : 524288;
                                i4 |= i14;
                            } else {
                                menuItemColors2 = menuItemColors;
                            }
                            i4 |= i14;
                        } else {
                            menuItemColors2 = menuItemColors;
                        }
                        i8 = i2 & 128;
                        if (i8 != 0) {
                            i4 |= 12582912;
                        } else if ((i & 29360128) == 0) {
                            i4 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                        }
                        i9 = i2 & 256;
                        if (i9 == 0) {
                            if ((i & 234881024) == 0) {
                                i10 = i9;
                                mutableInteractionSource2 = mutableInteractionSource;
                                i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                            }
                            if ((i4 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i13 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        function23 = null;
                                    }
                                    if (i6 != 0) {
                                        function24 = null;
                                    }
                                    boolean z4 = i7 == 0 ? true : z;
                                    if ((i2 & 64) == 0) {
                                        i11 = i10;
                                        menuItemColorsM17217itemColors5tl4gsc = MenuDefaults.INSTANCE.m17217itemColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                        i4 &= -3670017;
                                    } else {
                                        i11 = i10;
                                        menuItemColorsM17217itemColors5tl4gsc = menuItemColors2;
                                    }
                                    PaddingValues dropdownMenuItemContentPadding = i8 == 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues;
                                    if (i11 == 0) {
                                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        composerStartRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    modifier3 = modifier2;
                                    function25 = function24;
                                    z2 = z4;
                                    i12 = i4;
                                    function26 = function23;
                                    paddingValues2 = dropdownMenuItemContentPadding;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    i12 = i4;
                                    modifier3 = modifier2;
                                    function26 = function23;
                                    function25 = function24;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    menuItemColorsM17217itemColors5tl4gsc = menuItemColors2;
                                    z2 = z;
                                    paddingValues2 = paddingValues;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1826340448, i12, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
                                }
                                MenuKt.DropdownMenuItemContent(text, onClick, modifier3, function26, function25, z2, menuItemColorsM17217itemColors5tl4gsc, paddingValues2, mutableInteractionSource3, composerStartRestartGroup, i12 & 268435454);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = composerStartRestartGroup;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                paddingValues3 = paddingValues2;
                                menuItemColors3 = menuItemColorsM17217itemColors5tl4gsc;
                                z3 = z2;
                                function27 = function25;
                                function28 = function26;
                                modifier4 = modifier3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                z3 = z;
                                paddingValues3 = paddingValues;
                                modifier4 = modifier2;
                                function28 = function23;
                                composer2 = composerStartRestartGroup;
                                function27 = function24;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                menuItemColors3 = menuItemColors2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt.DropdownMenuItem.2
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
                                    AndroidMenu_androidKt.DropdownMenuItem(text, onClick, modifier4, function28, function27, z3, menuItemColors3, paddingValues3, mutableInteractionSource4, composer3, i | 1, i2);
                                }
                            });
                            return;
                        }
                        i4 |= 100663296;
                        i10 = i9;
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i4 & 191739611) == 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 == 0) {
                                }
                                if ((i2 & 64) == 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i11 == 0) {
                                }
                                modifier3 = modifier2;
                                function25 = function24;
                                z2 = z4;
                                i12 = i4;
                                function26 = function23;
                                paddingValues2 = dropdownMenuItemContentPadding;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                MenuKt.DropdownMenuItemContent(text, onClick, modifier3, function26, function25, z2, menuItemColorsM17217itemColors5tl4gsc, paddingValues2, mutableInteractionSource3, composerStartRestartGroup, i12 & 268435454);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composer2 = composerStartRestartGroup;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                paddingValues3 = paddingValues2;
                                menuItemColors3 = menuItemColorsM17217itemColors5tl4gsc;
                                z3 = z2;
                                function27 = function25;
                                function28 = function26;
                                modifier4 = modifier3;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    if ((3670016 & i) == 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                    }
                    i9 = i2 & 256;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i4 & 191739611) == 38347922) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function24 = function22;
                i7 = i2 & 32;
                if (i7 == 0) {
                }
                if ((3670016 & i) == 0) {
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                }
                i9 = i2 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i4 & 191739611) == 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function23 = function2;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            function24 = function22;
            i7 = i2 & 32;
            if (i7 == 0) {
            }
            if ((3670016 & i) == 0) {
            }
            i8 = i2 & 128;
            if (i8 != 0) {
            }
            i9 = i2 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i4 & 191739611) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        function23 = function2;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        function24 = function22;
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        if ((3670016 & i) == 0) {
        }
        i8 = i2 & 128;
        if (i8 != 0) {
        }
        i9 = i2 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i4 & 191739611) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
