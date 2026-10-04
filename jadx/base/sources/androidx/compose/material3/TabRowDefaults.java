package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\f*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/material3/TabRowDefaults;", "", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "Indicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "height", "Landroidx/compose/ui/unit/Dp;", "color", "Indicator-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material3/TabPosition;", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TabRowDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();

    private TabRowDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c6  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m17354Indicator9IZ8Weo(@Nullable Modifier modifier, float f, long j, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        long j2;
        long jFromToken;
        final long j3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1454716052);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            j2 = j;
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(j2)) ? 256 : 128;
        } else {
            j2 = j;
        }
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            j3 = j2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    f = PrimaryNavigationTabTokens.INSTANCE.m17867getActiveIndicatorHeightD9Ej5fM();
                }
                if ((i2 & 4) != 0) {
                    jFromToken = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor());
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1454716052, i, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:372)");
                }
                BoxKt.Box(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), f), jFromToken, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jFromToken;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            jFromToken = j2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            BoxKt.Box(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), f), jFromToken, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j3 = jFromToken;
        }
        final Modifier modifier2 = modifier;
        final float f4 = f;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$Indicator$1
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
                this.$tmp0_rcvr.m17354Indicator9IZ8Weo(modifier2, f4, j3, composer2, i | 1, i2);
            }
        });
    }

    @Composable
    @JvmName(name = "getContainerColor")
    public final long getContainerColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-2026555673);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026555673, i, -1, "androidx.compose.material3.TabRowDefaults.<get-containerColor> (TabRow.kt:356)");
        }
        long color = ColorSchemeKt.toColor(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @Composable
    @JvmName(name = "getContentColor")
    public final long getContentColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1163072359);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1163072359, i, -1, "androidx.compose.material3.TabRowDefaults.<get-contentColor> (TabRow.kt:360)");
        }
        long color = ColorSchemeKt.toColor(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @NotNull
    public final Modifier tabIndicatorOffset(@NotNull Modifier modifier, @NotNull final TabPosition currentTabPosition) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(currentTabPosition, "currentTabPosition");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.2
            {
                super(3);
            }

            /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
            private static final float m17355invoke$lambda0(State<C2256Dp> state) {
                return state.getValue().m20982unboximpl();
            }

            /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
            private static final float m17356invoke$lambda1(State<C2256Dp> state) {
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
                composer.startReplaceableGroup(-1541271084);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1541271084, i, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:400)");
                }
                State stateM15303animateDpAsStateKz89ssw = AnimateAsStateKt.m15303animateDpAsStateKz89ssw(currentTabPosition.getWidth(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, composer, 0, 4);
                Modifier modifierM15904width3ABfNKs = SizeKt.m15904width3ABfNKs(OffsetKt.m15815offsetVpY3zN4$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(composed, 0.0f, 1, null), Alignment.INSTANCE.getBottomStart(), false, 2, null), m17356invoke$lambda1(AnimateAsStateKt.m15303animateDpAsStateKz89ssw(currentTabPosition.getLeft(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, composer, 0, 4)), 0.0f, 2, null), m17355invoke$lambda0(stateM15303animateDpAsStateKz89ssw));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return modifierM15904width3ABfNKs;
            }
        });
    }
}
