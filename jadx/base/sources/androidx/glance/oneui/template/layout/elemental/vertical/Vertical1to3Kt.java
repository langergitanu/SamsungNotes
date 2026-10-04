package androidx.glance.oneui.template.layout.elemental.vertical;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.FuturePublicApi;
import androidx.glance.layout.WeightValue;
import androidx.glance.oneui.template.component.padding.Padding;
import androidx.glance.oneui.template.layout.internal.VerticalLayoutKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Vertical1to3", "", "padding", "Landroidx/glance/oneui/template/component/padding/Padding;", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "top", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottom", "(Landroidx/glance/oneui/template/component/padding/Padding;Landroidx/glance/unit/ColorProvider;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class Vertical1to3Kt {
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ef  */
    @Composable
    @FuturePublicApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Vertical1to3(@Nullable Padding padding, @Nullable ColorProvider colorProvider, @NotNull final Function2<? super Composer, ? super Integer, Unit> top, @NotNull final Function2<? super Composer, ? super Integer, Unit> bottom, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final Padding padding2;
        final ColorProvider colorProvider2;
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        Composer composerStartRestartGroup = composer.startRestartGroup(1491709995);
        if ((i & 14) == 0) {
            i4 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(padding)) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(top) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(bottom) ? 2048 : 1024;
        }
        if (i5 == 2 && (i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            padding2 = padding;
            colorProvider2 = colorProvider;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    padding = Padding.INSTANCE.getNone();
                    i4 &= -15;
                }
                if (i5 != 0) {
                    colorProvider = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                Padding padding3 = padding;
                ColorProvider colorProvider3 = colorProvider;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1491709995, i4, -1, "androidx.glance.oneui.template.layout.elemental.vertical.Vertical1to3 (Vertical1to3.kt:26)");
                }
                WeightValue.Companion companion = WeightValue.INSTANCE;
                WeightValue weight_1 = companion.getWEIGHT_1();
                Padding.Companion companion2 = Padding.INSTANCE;
                VerticalLayoutKt.VerticalRatioLayout(padding3, colorProvider3, CollectionsKt.listOf((Object[]) new Triple[]{new Triple(weight_1, companion2.getNone(), top), new Triple(companion.getWEIGHT_3(), companion2.getNone(), bottom)}), composerStartRestartGroup, (i4 & 14) | 64, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                padding2 = padding3;
                colorProvider2 = colorProvider3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i4 &= -15;
                }
                if (i5 != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                Padding padding32 = padding;
                ColorProvider colorProvider32 = colorProvider;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                WeightValue.Companion companion3 = WeightValue.INSTANCE;
                WeightValue weight_12 = companion3.getWEIGHT_1();
                Padding.Companion companion22 = Padding.INSTANCE;
                VerticalLayoutKt.VerticalRatioLayout(padding32, colorProvider32, CollectionsKt.listOf((Object[]) new Triple[]{new Triple(weight_12, companion22.getNone(), top), new Triple(companion3.getWEIGHT_3(), companion22.getNone(), bottom)}), composerStartRestartGroup, (i4 & 14) | 64, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                padding2 = padding32;
                colorProvider2 = colorProvider32;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.elemental.vertical.Vertical1to3Kt.Vertical1to3.1
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

                public final void invoke(@Nullable Composer composer2, int i6) {
                    Vertical1to3Kt.Vertical1to3(padding2, colorProvider2, top, bottom, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
