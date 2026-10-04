package androidx.compose.material3.tokens;

import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u0011\u0010\"\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b%\u0010\u0014R\u0011\u0010&\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u001c\u0010(\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b)\u0010\u0014R\u001c\u0010*\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b+\u0010\u0014R\u0011\u0010,\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0006R\u0011\u0010.\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0006R\u0011\u00100\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0006R\u0011\u00102\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0006R\u0011\u00104\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0006R\u0011\u00106\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0006R\u0011\u00108\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0006R\u0011\u0010:\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0006R\u0011\u0010<\u001a\u00020=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0006R\u0011\u0010B\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0006R\u0011\u0010D\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0006R\u001c\u0010F\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\bG\u0010\u0014R\u0011\u0010H\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0006R\u001c\u0010J\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\bK\u0010\u0014R\u0011\u0010L\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0019\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006N"}, m13886d2 = {"Landroidx/compose/material3/tokens/NavigationRailTokens;", "", "()V", "ActiveFocusIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveFocusIconColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveFocusLabelTextColor", "getActiveFocusLabelTextColor", "ActiveHoverIconColor", "getActiveHoverIconColor", "ActiveHoverLabelTextColor", "getActiveHoverLabelTextColor", "ActiveIconColor", "getActiveIconColor", "ActiveIndicatorColor", "getActiveIndicatorColor", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "ActiveIndicatorShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getActiveIndicatorShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ActiveIndicatorWidth", "getActiveIndicatorWidth-D9Ej5fM", "ActiveLabelTextColor", "getActiveLabelTextColor", "ActivePressedIconColor", "getActivePressedIconColor", "ActivePressedLabelTextColor", "getActivePressedLabelTextColor", "ContainerColor", "getContainerColor", "ContainerElevation", "getContainerElevation-D9Ej5fM", "ContainerShape", "getContainerShape", "ContainerWidth", "getContainerWidth-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "InactiveFocusIconColor", "getInactiveFocusIconColor", "InactiveFocusLabelTextColor", "getInactiveFocusLabelTextColor", "InactiveHoverIconColor", "getInactiveHoverIconColor", "InactiveHoverLabelTextColor", "getInactiveHoverLabelTextColor", "InactiveIconColor", "getInactiveIconColor", "InactiveLabelTextColor", "getInactiveLabelTextColor", "InactivePressedIconColor", "getInactivePressedIconColor", "InactivePressedLabelTextColor", "getInactivePressedLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "MenuFocusIconColor", "getMenuFocusIconColor", "MenuHoverIconColor", "getMenuHoverIconColor", "MenuIconColor", "getMenuIconColor", "MenuIconSize", "getMenuIconSize-D9Ej5fM", "MenuPressedIconColor", "getMenuPressedIconColor", "NoLabelActiveIndicatorHeight", "getNoLabelActiveIndicatorHeight-D9Ej5fM", "NoLabelActiveIndicatorShape", "getNoLabelActiveIndicatorShape", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NavigationRailTokens {

    @NotNull
    private static final ColorSchemeKeyTokens ActiveFocusIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens ActiveFocusLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens ActiveHoverIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens ActiveHoverLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens ActiveIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final float ActiveIndicatorHeight;

    @NotNull
    private static final ShapeKeyTokens ActiveIndicatorShape;
    private static final float ActiveIndicatorWidth;

    @NotNull
    private static final ColorSchemeKeyTokens ActiveLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens ActivePressedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens ActivePressedLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;

    @NotNull
    private static final ShapeKeyTokens ContainerShape;
    private static final float ContainerWidth;

    @NotNull
    public static final NavigationRailTokens INSTANCE = new NavigationRailTokens();
    private static final float IconSize;

    @NotNull
    private static final ColorSchemeKeyTokens InactiveFocusIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens InactiveFocusLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens InactiveHoverIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens InactiveHoverLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens InactiveIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens InactiveLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens InactivePressedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens InactivePressedLabelTextColor;

    @NotNull
    private static final TypographyKeyTokens LabelTextFont;

    @NotNull
    private static final ColorSchemeKeyTokens MenuFocusIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens MenuHoverIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens MenuIconColor;
    private static final float MenuIconSize;

    @NotNull
    private static final ColorSchemeKeyTokens MenuPressedIconColor;
    private static final float NoLabelActiveIndicatorHeight;

    @NotNull
    private static final ShapeKeyTokens NoLabelActiveIndicatorShape;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSecondaryContainer;
        ActiveFocusIconColor = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurface;
        ActiveFocusLabelTextColor = colorSchemeKeyTokens2;
        ActiveHoverIconColor = colorSchemeKeyTokens;
        ActiveHoverLabelTextColor = colorSchemeKeyTokens2;
        ActiveIconColor = colorSchemeKeyTokens;
        ActiveIndicatorColor = ColorSchemeKeyTokens.SecondaryContainer;
        ActiveIndicatorHeight = C2256Dp.m20968constructorimpl((float) 32.0d);
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        ActiveIndicatorShape = shapeKeyTokens;
        float f = (float) 56.0d;
        ActiveIndicatorWidth = C2256Dp.m20968constructorimpl(f);
        ActiveLabelTextColor = colorSchemeKeyTokens2;
        ActivePressedIconColor = colorSchemeKeyTokens;
        ActivePressedLabelTextColor = colorSchemeKeyTokens2;
        ContainerColor = ColorSchemeKeyTokens.Surface;
        ContainerElevation = ElevationTokens.INSTANCE.m17592getLevel0D9Ej5fM();
        ContainerShape = ShapeKeyTokens.CornerNone;
        ContainerWidth = C2256Dp.m20968constructorimpl((float) 80.0d);
        float f4 = (float) 24.0d;
        IconSize = C2256Dp.m20968constructorimpl(f4);
        InactiveFocusIconColor = colorSchemeKeyTokens2;
        InactiveFocusLabelTextColor = colorSchemeKeyTokens2;
        InactiveHoverIconColor = colorSchemeKeyTokens2;
        InactiveHoverLabelTextColor = colorSchemeKeyTokens2;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnSurfaceVariant;
        InactiveIconColor = colorSchemeKeyTokens3;
        InactiveLabelTextColor = colorSchemeKeyTokens3;
        InactivePressedIconColor = colorSchemeKeyTokens2;
        InactivePressedLabelTextColor = colorSchemeKeyTokens2;
        LabelTextFont = TypographyKeyTokens.LabelMedium;
        MenuFocusIconColor = colorSchemeKeyTokens2;
        MenuHoverIconColor = colorSchemeKeyTokens2;
        MenuIconColor = colorSchemeKeyTokens3;
        MenuIconSize = C2256Dp.m20968constructorimpl(f4);
        MenuPressedIconColor = colorSchemeKeyTokens2;
        NoLabelActiveIndicatorHeight = C2256Dp.m20968constructorimpl(f);
        NoLabelActiveIndicatorShape = shapeKeyTokens;
    }

    private NavigationRailTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveFocusIconColor() {
        return ActiveFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveFocusLabelTextColor() {
        return ActiveFocusLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveHoverIconColor() {
        return ActiveHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveHoverLabelTextColor() {
        return ActiveHoverLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveIconColor() {
        return ActiveIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveIndicatorColor() {
        return ActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17749getActiveIndicatorHeightD9Ej5fM() {
        return ActiveIndicatorHeight;
    }

    @NotNull
    public final ShapeKeyTokens getActiveIndicatorShape() {
        return ActiveIndicatorShape;
    }

    /* JADX INFO: renamed from: getActiveIndicatorWidth-D9Ej5fM, reason: not valid java name */
    public final float m17750getActiveIndicatorWidthD9Ej5fM() {
        return ActiveIndicatorWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveLabelTextColor() {
        return ActiveLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActivePressedIconColor() {
        return ActivePressedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActivePressedLabelTextColor() {
        return ActivePressedLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17751getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    @NotNull
    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    /* JADX INFO: renamed from: getContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m17752getContainerWidthD9Ej5fM() {
        return ContainerWidth;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17753getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveFocusIconColor() {
        return InactiveFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveFocusLabelTextColor() {
        return InactiveFocusLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveHoverIconColor() {
        return InactiveHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveHoverLabelTextColor() {
        return InactiveHoverLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveIconColor() {
        return InactiveIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveLabelTextColor() {
        return InactiveLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactivePressedIconColor() {
        return InactivePressedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactivePressedLabelTextColor() {
        return InactivePressedLabelTextColor;
    }

    @NotNull
    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getMenuFocusIconColor() {
        return MenuFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getMenuHoverIconColor() {
        return MenuHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getMenuIconColor() {
        return MenuIconColor;
    }

    /* JADX INFO: renamed from: getMenuIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17754getMenuIconSizeD9Ej5fM() {
        return MenuIconSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getMenuPressedIconColor() {
        return MenuPressedIconColor;
    }

    /* JADX INFO: renamed from: getNoLabelActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17755getNoLabelActiveIndicatorHeightD9Ej5fM() {
        return NoLabelActiveIndicatorHeight;
    }

    @NotNull
    public final ShapeKeyTokens getNoLabelActiveIndicatorShape() {
        return NoLabelActiveIndicatorShape;
    }
}
