package androidx.glance.oneui.template.layout;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\f\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\bR\u0019\u0010\u000e\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000f\u0010\bR\u0019\u0010\u0010\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0012\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0013\u0010\bR\u0019\u0010\u0014\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0015\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/CommonDimensions;", "", "()V", "ICON_SCALE_RATIO", "", "defaultCornerRadius", "Landroidx/compose/ui/unit/Dp;", "getDefaultCornerRadius-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "defaultIconSize", "getDefaultIconSize-D9Ej5fM", "layoutHorizontalPadding", "getLayoutHorizontalPadding-D9Ej5fM", "layoutVerticalPadding", "getLayoutVerticalPadding-D9Ej5fM", "maxAppWidgetCornerRadius", "getMaxAppWidgetCornerRadius-D9Ej5fM", "smallIconSize", "getSmallIconSize-D9Ej5fM", "textAdditionalPadding", "getTextAdditionalPadding-D9Ej5fM", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutDimensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/CommonDimensions\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,729:1\n154#2:730\n154#2:731\n154#2:732\n154#2:733\n154#2:734\n154#2:735\n154#2:736\n*S KotlinDebug\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/CommonDimensions\n*L\n43#1:730\n49#1:731\n55#1:732\n57#1:733\n59#1:734\n63#1:735\n67#1:736\n*E\n"})
public final class CommonDimensions {
    public static final int $stable = 0;
    public static final float ICON_SCALE_RATIO = 0.6667f;

    @NotNull
    public static final CommonDimensions INSTANCE = new CommonDimensions();
    private static final float layoutHorizontalPadding = C2256Dp.m20968constructorimpl(14);
    private static final float layoutVerticalPadding = C2256Dp.m20968constructorimpl(12);
    private static final float textAdditionalPadding = C2256Dp.m20968constructorimpl(2);
    private static final float defaultIconSize = C2256Dp.m20968constructorimpl(18);
    private static final float smallIconSize = C2256Dp.m20968constructorimpl(11);
    private static final float maxAppWidgetCornerRadius = C2256Dp.m20968constructorimpl(200);
    private static final float defaultCornerRadius = C2256Dp.m20968constructorimpl(100);

    private CommonDimensions() {
    }

    /* JADX INFO: renamed from: getDefaultCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m21773getDefaultCornerRadiusD9Ej5fM() {
        return defaultCornerRadius;
    }

    /* JADX INFO: renamed from: getDefaultIconSize-D9Ej5fM, reason: not valid java name */
    public final float m21774getDefaultIconSizeD9Ej5fM() {
        return defaultIconSize;
    }

    /* JADX INFO: renamed from: getLayoutHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m21775getLayoutHorizontalPaddingD9Ej5fM() {
        return layoutHorizontalPadding;
    }

    /* JADX INFO: renamed from: getLayoutVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m21776getLayoutVerticalPaddingD9Ej5fM() {
        return layoutVerticalPadding;
    }

    /* JADX INFO: renamed from: getMaxAppWidgetCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m21777getMaxAppWidgetCornerRadiusD9Ej5fM() {
        return maxAppWidgetCornerRadius;
    }

    /* JADX INFO: renamed from: getSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m21778getSmallIconSizeD9Ej5fM() {
        return smallIconSize;
    }

    /* JADX INFO: renamed from: getTextAdditionalPadding-D9Ej5fM, reason: not valid java name */
    public final float m21779getTextAdditionalPaddingD9Ej5fM() {
        return textAdditionalPadding;
    }
}
