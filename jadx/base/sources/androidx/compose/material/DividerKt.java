package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, m13886d2 = {"DividerAlpha", "", FolderConstants.Divider.DISPLAY_NAME, "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0160  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Divider-oMI9zvI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16716DivideroMI9zvI(@Nullable Modifier modifier, long j, float f, float f4, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        long j2;
        float fM20968constructorimpl;
        int i5;
        float f5;
        Modifier modifier3;
        long jM18524copywmQWz5c$default;
        float fM20968constructorimpl2;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1249392198);
        int i6 = i2 & 1;
        if (i6 != 0) {
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
            j2 = j;
            i4 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(j2)) ? 32 : 16;
        } else {
            j2 = j;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                fM20968constructorimpl = f;
                i4 |= composerStartRestartGroup.changed(fM20968constructorimpl) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    f5 = f4;
                    i4 |= composerStartRestartGroup.changed(f5) ? 2048 : 1024;
                }
                if ((i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    jM18524copywmQWz5c$default = j2;
                    f6 = f5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        modifier3 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        jM18524copywmQWz5c$default = (i2 & 2) == 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16675getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
                        if (i7 != 0) {
                            fM20968constructorimpl = C2256Dp.m20968constructorimpl(1);
                        }
                        if (i5 == 0) {
                            fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(0);
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1249392198, i, -1, "androidx.compose.material.Divider (Divider.kt:43)");
                        }
                        Modifier modifierM15858paddingqDBjuR0$default = fM20968constructorimpl2 == 0.0f ? Modifier.INSTANCE : PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, fM20968constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(1228914189);
                        float fM20968constructorimpl3 = C2256Dp.m20973equalsimpl0(fM20968constructorimpl, C2256Dp.INSTANCE.m20986getHairlineD9Ej5fM()) ? C2256Dp.m20968constructorimpl(1.0f / ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity()) : fM20968constructorimpl;
                        composerStartRestartGroup.endReplaceableGroup();
                        BoxKt.Box(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM15858paddingqDBjuR0$default), 0.0f, 1, null), fM20968constructorimpl3), jM18524copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f6 = fM20968constructorimpl2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        jM18524copywmQWz5c$default = j2;
                    }
                    fM20968constructorimpl2 = f5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (fM20968constructorimpl2 == 0.0f) {
                    }
                    composerStartRestartGroup.startReplaceableGroup(1228914189);
                    if (C2256Dp.m20973equalsimpl0(fM20968constructorimpl, C2256Dp.INSTANCE.m20986getHairlineD9Ej5fM())) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BoxKt.Box(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM15858paddingqDBjuR0$default), 0.0f, 1, null), fM20968constructorimpl3), jM18524copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f6 = fM20968constructorimpl2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final Modifier modifier4 = modifier3;
                final long j3 = jM18524copywmQWz5c$default;
                final float f7 = fM20968constructorimpl;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
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
                        DividerKt.m16716DivideroMI9zvI(modifier4, j3, f7, f6, composer2, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= 3072;
            f5 = f4;
            if ((i4 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if ((i2 & 2) == 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i5 == 0) {
                        fM20968constructorimpl2 = f5;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (fM20968constructorimpl2 == 0.0f) {
                    }
                    composerStartRestartGroup.startReplaceableGroup(1228914189);
                    if (C2256Dp.m20973equalsimpl0(fM20968constructorimpl, C2256Dp.INSTANCE.m20986getHairlineD9Ej5fM())) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BoxKt.Box(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM15858paddingqDBjuR0$default), 0.0f, 1, null), fM20968constructorimpl3), jM18524copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f6 = fM20968constructorimpl2;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        fM20968constructorimpl = f;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        f5 = f4;
        if ((i4 & 5851) == 1170) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
