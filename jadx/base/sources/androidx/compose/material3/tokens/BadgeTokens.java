package androidx.compose.material3.tokens;

import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001a\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/material3/tokens/BadgeTokens;", "", "()V", "Color", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "LargeColor", "getLargeColor", "LargeLabelTextColor", "getLargeLabelTextColor", "LargeLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLargeLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "LargeShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getLargeShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "LargeSize", "Landroidx/compose/ui/unit/Dp;", "getLargeSize-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "Shape", "getShape", "Size", "getSize-D9Ej5fM", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class BadgeTokens {

    @NotNull
    private static final ColorSchemeKeyTokens Color;

    @NotNull
    public static final BadgeTokens INSTANCE = new BadgeTokens();

    @NotNull
    private static final ColorSchemeKeyTokens LargeColor;

    @NotNull
    private static final ColorSchemeKeyTokens LargeLabelTextColor;

    @NotNull
    private static final TypographyKeyTokens LargeLabelTextFont;

    @NotNull
    private static final ShapeKeyTokens LargeShape;
    private static final float LargeSize;

    @NotNull
    private static final ShapeKeyTokens Shape;
    private static final float Size;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Error;
        Color = colorSchemeKeyTokens;
        LargeColor = colorSchemeKeyTokens;
        LargeLabelTextColor = ColorSchemeKeyTokens.OnError;
        LargeLabelTextFont = TypographyKeyTokens.LabelSmall;
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        LargeShape = shapeKeyTokens;
        LargeSize = C2256Dp.m20968constructorimpl((float) 16.0d);
        Shape = shapeKeyTokens;
        Size = C2256Dp.m20968constructorimpl((float) 6.0d);
    }

    private BadgeTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getColor() {
        return Color;
    }

    @NotNull
    public final ColorSchemeKeyTokens getLargeColor() {
        return LargeColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getLargeLabelTextColor() {
        return LargeLabelTextColor;
    }

    @NotNull
    public final TypographyKeyTokens getLargeLabelTextFont() {
        return LargeLabelTextFont;
    }

    @NotNull
    public final ShapeKeyTokens getLargeShape() {
        return LargeShape;
    }

    /* JADX INFO: renamed from: getLargeSize-D9Ej5fM, reason: not valid java name */
    public final float m17491getLargeSizeD9Ej5fM() {
        return LargeSize;
    }

    @NotNull
    public final ShapeKeyTokens getShape() {
        return Shape;
    }

    /* JADX INFO: renamed from: getSize-D9Ej5fM, reason: not valid java name */
    public final float m17492getSizeD9Ej5fM() {
        return Size;
    }
}
