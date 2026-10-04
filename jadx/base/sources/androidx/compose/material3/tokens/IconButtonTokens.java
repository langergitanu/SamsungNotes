package androidx.compose.material3.tokens;

import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u001b\u0010\fR\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u0011\u0010\"\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, m13886d2 = {"Landroidx/compose/material3/tokens/IconButtonTokens;", "", "()V", "DisabledIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledIconColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledIconOpacity", "", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedIconColor", "getSelectedIconColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "StateLayerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getStateLayerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "UnselectedFocusIconColor", "getUnselectedFocusIconColor", "UnselectedHoverIconColor", "getUnselectedHoverIconColor", "UnselectedIconColor", "getUnselectedIconColor", "UnselectedPressedIconColor", "getUnselectedPressedIconColor", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class IconButtonTokens {
    public static final float DisabledIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedFocusIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedHoverIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedPressedIconColor;

    @NotNull
    private static final ShapeKeyTokens StateLayerShape;
    private static final float StateLayerSize;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedFocusIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedHoverIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedPressedIconColor;

    @NotNull
    public static final IconButtonTokens INSTANCE = new IconButtonTokens();

    @NotNull
    private static final ColorSchemeKeyTokens DisabledIconColor = ColorSchemeKeyTokens.OnSurface;
    private static final float IconSize = C2256Dp.m20968constructorimpl((float) 24.0d);

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        SelectedFocusIconColor = colorSchemeKeyTokens;
        SelectedHoverIconColor = colorSchemeKeyTokens;
        SelectedIconColor = colorSchemeKeyTokens;
        SelectedPressedIconColor = colorSchemeKeyTokens;
        StateLayerShape = ShapeKeyTokens.CornerFull;
        StateLayerSize = C2256Dp.m20968constructorimpl((float) 40.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurfaceVariant;
        UnselectedFocusIconColor = colorSchemeKeyTokens2;
        UnselectedHoverIconColor = colorSchemeKeyTokens2;
        UnselectedIconColor = colorSchemeKeyTokens2;
        UnselectedPressedIconColor = colorSchemeKeyTokens2;
    }

    private IconButtonTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledIconColor() {
        return DisabledIconColor;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17711getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return SelectedFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return SelectedHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedIconColor() {
        return SelectedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return SelectedPressedIconColor;
    }

    @NotNull
    public final ShapeKeyTokens getStateLayerShape() {
        return StateLayerShape;
    }

    /* JADX INFO: renamed from: getStateLayerSize-D9Ej5fM, reason: not valid java name */
    public final float m17712getStateLayerSizeD9Ej5fM() {
        return StateLayerSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedFocusIconColor() {
        return UnselectedFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedHoverIconColor() {
        return UnselectedHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedIconColor() {
        return UnselectedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedPressedIconColor() {
        return UnselectedPressedIconColor;
    }
}
