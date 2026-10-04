package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.platform.InspectableValueKt;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/material/TabRowDefaults;", "", "()V", "DividerOpacity", "", "DividerThickness", "Landroidx/compose/ui/unit/Dp;", "getDividerThickness-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "IndicatorHeight", "getIndicatorHeight-D9Ej5fM", "ScrollableTabRowPadding", "getScrollableTabRowPadding-D9Ej5fM", FolderConstants.Divider.DISPLAY_NAME, "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Indicator", "height", "Indicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final float DividerOpacity = 0.12f;

    @NotNull
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float DividerThickness = C2256Dp.m20968constructorimpl(1);
    private static final float IndicatorHeight = C2256Dp.m20968constructorimpl(2);
    private static final float ScrollableTabRowPadding = C2256Dp.m20968constructorimpl(52);

    private TabRowDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Divider-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m16901Divider9IZ8Weo(@Nullable Modifier modifier, float f, long j, @Nullable Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i4;
        float f4;
        long jM18524copywmQWz5c$default;
        float f5;
        float f6;
        long j2;
        Modifier modifier3;
        final long j3;
        final float f7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(910934799);
        int i5 = i2 & 1;
        if (i5 != 0) {
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
                f4 = f;
                int i6 = composerStartRestartGroup.changed(f4) ? 32 : 16;
                i4 |= i6;
            } else {
                f4 = f;
            }
            i4 |= i6;
        } else {
            f4 = f;
        }
        if ((i & 896) == 0) {
            jM18524copywmQWz5c$default = j;
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM18524copywmQWz5c$default)) ? 256 : 128;
        } else {
            jM18524copywmQWz5c$default = j;
        }
        if ((i2 & 8) == 0) {
            if ((i & 7168) == 0) {
                i4 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
            }
            if ((i4 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) == 0) {
                        f5 = DividerThickness;
                        i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                    } else {
                        f5 = f4;
                    }
                    if ((i2 & 4) != 0) {
                        jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i4 &= -897;
                    }
                    f6 = f5;
                    j2 = jM18524copywmQWz5c$default;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                    }
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    f6 = f4;
                    j2 = jM18524copywmQWz5c$default;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(910934799, i4, -1, "androidx.compose.material.TabRowDefaults.Divider (TabRow.kt:363)");
                }
                DividerKt.m16716DivideroMI9zvI(modifier3, j2, f6, 0.0f, composerStartRestartGroup, (i4 & 14) | ((i4 >> 3) & 112) | ((i4 << 3) & 896), 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = j2;
                f7 = f6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f7 = f4;
                j3 = jM18524copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowDefaults$Divider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    this.$tmp0_rcvr.m16901Divider9IZ8Weo(modifier2, f7, j3, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 3072;
        if ((i4 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 == 0) {
                }
                if ((i2 & 2) == 0) {
                }
                if ((i2 & 4) != 0) {
                }
                f6 = f5;
                j2 = jM18524copywmQWz5c$default;
                modifier3 = modifier4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                DividerKt.m16716DivideroMI9zvI(modifier3, j2, f6, 0.0f, composerStartRestartGroup, (i4 & 14) | ((i4 >> 3) & 112) | ((i4 << 3) & 896), 8);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                j3 = j2;
                f7 = f6;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fb  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m16902Indicator9IZ8Weo(@Nullable Modifier modifier, float f, long j, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        float f4;
        long j2;
        TabRowDefaults tabRowDefaults;
        final Modifier modifier3;
        final float f5;
        long jM18535unboximpl;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1499002201);
        int i5 = i2 & 1;
        if (i5 != 0) {
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
                f4 = f;
                int i6 = composerStartRestartGroup.changed(f4) ? 32 : 16;
                i4 |= i6;
            } else {
                f4 = f;
            }
            i4 |= i6;
        } else {
            f4 = f;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j2 = j;
                int i7 = composerStartRestartGroup.changed(j2) ? 256 : 128;
                i4 |= i7;
            } else {
                j2 = j;
            }
            i4 |= i7;
        } else {
            j2 = j;
        }
        if ((i2 & 8) == 0) {
            if ((i & 7168) == 0) {
                tabRowDefaults = this;
                i4 |= composerStartRestartGroup.changed(tabRowDefaults) ? 2048 : 1024;
            }
            if ((i4 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    f5 = (i2 & 2) == 0 ? IndicatorHeight : f4;
                    if ((i2 & 4) == 0) {
                        jM18535unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1499002201, i, -1, "androidx.compose.material.TabRowDefaults.Indicator (TabRow.kt:380)");
                    }
                    BoxKt.Box(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), f5), jM18535unboximpl, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jM18535unboximpl;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f5 = f4;
                }
                jM18535unboximpl = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                BoxKt.Box(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), f5), jM18535unboximpl, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j3 = jM18535unboximpl;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                f5 = f4;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            final TabRowDefaults tabRowDefaults2 = tabRowDefaults;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowDefaults$Indicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    this.$tmp0_rcvr.m16902Indicator9IZ8Weo(modifier3, f5, j3, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 3072;
        tabRowDefaults = this;
        if ((i4 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 == 0) {
                }
                if ((i2 & 2) == 0) {
                }
                if ((i2 & 4) == 0) {
                    jM18535unboximpl = j2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                BoxKt.Box(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), f5), jM18535unboximpl, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j3 = jM18535unboximpl;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: renamed from: getDividerThickness-D9Ej5fM, reason: not valid java name */
    public final float m16903getDividerThicknessD9Ej5fM() {
        return DividerThickness;
    }

    /* JADX INFO: renamed from: getIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m16904getIndicatorHeightD9Ej5fM() {
        return IndicatorHeight;
    }

    /* JADX INFO: renamed from: getScrollableTabRowPadding-D9Ej5fM, reason: not valid java name */
    public final float m16905getScrollableTabRowPaddingD9Ej5fM() {
        return ScrollableTabRowPadding;
    }

    @NotNull
    public final Modifier tabIndicatorOffset(@NotNull Modifier modifier, @NotNull final TabPosition currentTabPosition) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(currentTabPosition, "currentTabPosition");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("tabIndicatorOffset");
                inspectorInfo.setValue(currentTabPosition);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.TabRowDefaults.tabIndicatorOffset.2
            {
                super(3);
            }

            /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
            private static final float m16906invoke$lambda0(State<C2256Dp> state) {
                return state.getValue().m20982unboximpl();
            }

            /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
            private static final float m16907invoke$lambda1(State<C2256Dp> state) {
                return state.getValue().m20982unboximpl();
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(-398757863);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-398757863, i, -1, "androidx.compose.material.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:407)");
                }
                State stateM15303animateDpAsStateKz89ssw = AnimateAsStateKt.m15303animateDpAsStateKz89ssw(currentTabPosition.getWidth(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, composer, 0, 4);
                Modifier modifierM15904width3ABfNKs = SizeKt.m15904width3ABfNKs(OffsetKt.m15815offsetVpY3zN4$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(composed, 0.0f, 1, null), Alignment.INSTANCE.getBottomStart(), false, 2, null), m16907invoke$lambda1(AnimateAsStateKt.m15303animateDpAsStateKz89ssw(currentTabPosition.getLeft(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, composer, 0, 4)), 0.0f, 2, null), m16906invoke$lambda0(stateM15303animateDpAsStateKz89ssw));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return modifierM15904width3ABfNKs;
            }
        });
    }
}
