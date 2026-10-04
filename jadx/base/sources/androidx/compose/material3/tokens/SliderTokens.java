package androidx.compose.material3.tokens;

import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u001a\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0017\u0010\nR\u000e\u0010\u0018\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u000e\u0010\u001b\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b!\u0010\nR\u001c\u0010\"\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b#\u0010\nR\u0011\u0010$\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000fR\u001c\u0010&\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b'\u0010\nR\u0011\u0010(\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u0011\u0010*\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b-\u0010\nR\u0011\u0010.\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000fR\u0011\u00100\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0006R\u001c\u00102\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b3\u0010\nR\u001c\u00104\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b5\u0010\nR\u0011\u00106\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0006R\u0011\u00108\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0006R\u001c\u0010>\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b?\u0010\nR\u0011\u0010@\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0006R\u001c\u0010B\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bC\u0010\nR\u0011\u0010D\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0006R\u000e\u0010F\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010G\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000fR\u001c\u0010I\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bJ\u0010\nR\u0011\u0010K\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0006R\u000e\u0010M\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0006R\u000e\u0010P\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010Q\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bR\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, m13886d2 = {"Landroidx/compose/material3/tokens/SliderTokens;", "", "()V", "ActiveTrackColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveTrackColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveTrackHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveTrackHeight-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "ActiveTrackShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getActiveTrackShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DisabledActiveTrackColor", "getDisabledActiveTrackColor", "DisabledActiveTrackOpacity", "", "DisabledHandleColor", "getDisabledHandleColor", "DisabledHandleElevation", "getDisabledHandleElevation-D9Ej5fM", "DisabledHandleOpacity", "DisabledInactiveTrackColor", "getDisabledInactiveTrackColor", "DisabledInactiveTrackOpacity", "FocusHandleColor", "getFocusHandleColor", "HandleColor", "getHandleColor", "HandleElevation", "getHandleElevation-D9Ej5fM", "HandleHeight", "getHandleHeight-D9Ej5fM", "HandleShape", "getHandleShape", "HandleWidth", "getHandleWidth-D9Ej5fM", "HoverHandleColor", "getHoverHandleColor", "InactiveTrackColor", "getInactiveTrackColor", "InactiveTrackHeight", "getInactiveTrackHeight-D9Ej5fM", "InactiveTrackShape", "getInactiveTrackShape", "LabelContainerColor", "getLabelContainerColor", "LabelContainerElevation", "getLabelContainerElevation-D9Ej5fM", "LabelContainerHeight", "getLabelContainerHeight-D9Ej5fM", "LabelTextColor", "getLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "OverlapHandleOutlineColor", "getOverlapHandleOutlineColor", "OverlapHandleOutlineWidth", "getOverlapHandleOutlineWidth-D9Ej5fM", "PressedHandleColor", "getPressedHandleColor", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "TickMarksActiveContainerColor", "getTickMarksActiveContainerColor", "TickMarksActiveContainerOpacity", "TickMarksContainerShape", "getTickMarksContainerShape", "TickMarksContainerSize", "getTickMarksContainerSize-D9Ej5fM", "TickMarksDisabledContainerColor", "getTickMarksDisabledContainerColor", "TickMarksDisabledContainerOpacity", "TickMarksInactiveContainerColor", "getTickMarksInactiveContainerColor", "TickMarksInactiveContainerOpacity", "TrackElevation", "getTrackElevation-D9Ej5fM", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SliderTokens {

    @NotNull
    private static final ColorSchemeKeyTokens ActiveTrackColor;
    private static final float ActiveTrackHeight;

    @NotNull
    private static final ShapeKeyTokens ActiveTrackShape;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledActiveTrackColor;
    public static final float DisabledActiveTrackOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledHandleColor;
    private static final float DisabledHandleElevation;
    public static final float DisabledHandleOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledInactiveTrackColor;
    public static final float DisabledInactiveTrackOpacity = 0.12f;

    @NotNull
    private static final ColorSchemeKeyTokens FocusHandleColor;

    @NotNull
    private static final ColorSchemeKeyTokens HandleColor;
    private static final float HandleElevation;
    private static final float HandleHeight;

    @NotNull
    private static final ShapeKeyTokens HandleShape;
    private static final float HandleWidth;

    @NotNull
    private static final ColorSchemeKeyTokens HoverHandleColor;

    @NotNull
    public static final SliderTokens INSTANCE = new SliderTokens();

    @NotNull
    private static final ColorSchemeKeyTokens InactiveTrackColor;
    private static final float InactiveTrackHeight;

    @NotNull
    private static final ShapeKeyTokens InactiveTrackShape;

    @NotNull
    private static final ColorSchemeKeyTokens LabelContainerColor;
    private static final float LabelContainerElevation;
    private static final float LabelContainerHeight;

    @NotNull
    private static final ColorSchemeKeyTokens LabelTextColor;

    @NotNull
    private static final TypographyKeyTokens LabelTextFont;

    @NotNull
    private static final ColorSchemeKeyTokens OverlapHandleOutlineColor;
    private static final float OverlapHandleOutlineWidth;

    @NotNull
    private static final ColorSchemeKeyTokens PressedHandleColor;
    private static final float StateLayerSize;

    @NotNull
    private static final ColorSchemeKeyTokens TickMarksActiveContainerColor;
    public static final float TickMarksActiveContainerOpacity = 0.38f;

    @NotNull
    private static final ShapeKeyTokens TickMarksContainerShape;
    private static final float TickMarksContainerSize;

    @NotNull
    private static final ColorSchemeKeyTokens TickMarksDisabledContainerColor;
    public static final float TickMarksDisabledContainerOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens TickMarksInactiveContainerColor;
    public static final float TickMarksInactiveContainerOpacity = 0.38f;
    private static final float TrackElevation;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        ActiveTrackColor = colorSchemeKeyTokens;
        float f = (float) 4.0d;
        ActiveTrackHeight = C2256Dp.m20968constructorimpl(f);
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        ActiveTrackShape = shapeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurface;
        DisabledActiveTrackColor = colorSchemeKeyTokens2;
        DisabledHandleColor = colorSchemeKeyTokens2;
        ElevationTokens elevationTokens = ElevationTokens.INSTANCE;
        DisabledHandleElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        DisabledInactiveTrackColor = colorSchemeKeyTokens2;
        FocusHandleColor = colorSchemeKeyTokens;
        HandleColor = colorSchemeKeyTokens;
        HandleElevation = elevationTokens.m17593getLevel1D9Ej5fM();
        float f4 = (float) 20.0d;
        HandleHeight = C2256Dp.m20968constructorimpl(f4);
        HandleShape = shapeKeyTokens;
        HandleWidth = C2256Dp.m20968constructorimpl(f4);
        HoverHandleColor = colorSchemeKeyTokens;
        InactiveTrackColor = ColorSchemeKeyTokens.SurfaceVariant;
        InactiveTrackHeight = C2256Dp.m20968constructorimpl(f);
        InactiveTrackShape = shapeKeyTokens;
        LabelContainerColor = colorSchemeKeyTokens;
        LabelContainerElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        LabelContainerHeight = C2256Dp.m20968constructorimpl((float) 28.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnPrimary;
        LabelTextColor = colorSchemeKeyTokens3;
        LabelTextFont = TypographyKeyTokens.LabelMedium;
        PressedHandleColor = colorSchemeKeyTokens;
        StateLayerSize = C2256Dp.m20968constructorimpl((float) 40.0d);
        TrackElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        OverlapHandleOutlineColor = colorSchemeKeyTokens3;
        OverlapHandleOutlineWidth = C2256Dp.m20968constructorimpl((float) 1.0d);
        TickMarksActiveContainerColor = colorSchemeKeyTokens3;
        TickMarksContainerShape = shapeKeyTokens;
        TickMarksContainerSize = C2256Dp.m20968constructorimpl((float) 2.0d);
        TickMarksDisabledContainerColor = colorSchemeKeyTokens2;
        TickMarksInactiveContainerColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    }

    private SliderTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveTrackColor() {
        return ActiveTrackColor;
    }

    /* JADX INFO: renamed from: getActiveTrackHeight-D9Ej5fM, reason: not valid java name */
    public final float m17875getActiveTrackHeightD9Ej5fM() {
        return ActiveTrackHeight;
    }

    @NotNull
    public final ShapeKeyTokens getActiveTrackShape() {
        return ActiveTrackShape;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledActiveTrackColor() {
        return DisabledActiveTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledHandleColor() {
        return DisabledHandleColor;
    }

    /* JADX INFO: renamed from: getDisabledHandleElevation-D9Ej5fM, reason: not valid java name */
    public final float m17876getDisabledHandleElevationD9Ej5fM() {
        return DisabledHandleElevation;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledInactiveTrackColor() {
        return DisabledInactiveTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFocusHandleColor() {
        return FocusHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getHandleColor() {
        return HandleColor;
    }

    /* JADX INFO: renamed from: getHandleElevation-D9Ej5fM, reason: not valid java name */
    public final float m17877getHandleElevationD9Ej5fM() {
        return HandleElevation;
    }

    /* JADX INFO: renamed from: getHandleHeight-D9Ej5fM, reason: not valid java name */
    public final float m17878getHandleHeightD9Ej5fM() {
        return HandleHeight;
    }

    @NotNull
    public final ShapeKeyTokens getHandleShape() {
        return HandleShape;
    }

    /* JADX INFO: renamed from: getHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m17879getHandleWidthD9Ej5fM() {
        return HandleWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getHoverHandleColor() {
        return HoverHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveTrackColor() {
        return InactiveTrackColor;
    }

    /* JADX INFO: renamed from: getInactiveTrackHeight-D9Ej5fM, reason: not valid java name */
    public final float m17880getInactiveTrackHeightD9Ej5fM() {
        return InactiveTrackHeight;
    }

    @NotNull
    public final ShapeKeyTokens getInactiveTrackShape() {
        return InactiveTrackShape;
    }

    @NotNull
    public final ColorSchemeKeyTokens getLabelContainerColor() {
        return LabelContainerColor;
    }

    /* JADX INFO: renamed from: getLabelContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17881getLabelContainerElevationD9Ej5fM() {
        return LabelContainerElevation;
    }

    /* JADX INFO: renamed from: getLabelContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m17882getLabelContainerHeightD9Ej5fM() {
        return LabelContainerHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getLabelTextColor() {
        return LabelTextColor;
    }

    @NotNull
    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getOverlapHandleOutlineColor() {
        return OverlapHandleOutlineColor;
    }

    /* JADX INFO: renamed from: getOverlapHandleOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m17883getOverlapHandleOutlineWidthD9Ej5fM() {
        return OverlapHandleOutlineWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getPressedHandleColor() {
        return PressedHandleColor;
    }

    /* JADX INFO: renamed from: getStateLayerSize-D9Ej5fM, reason: not valid java name */
    public final float m17884getStateLayerSizeD9Ej5fM() {
        return StateLayerSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTickMarksActiveContainerColor() {
        return TickMarksActiveContainerColor;
    }

    @NotNull
    public final ShapeKeyTokens getTickMarksContainerShape() {
        return TickMarksContainerShape;
    }

    /* JADX INFO: renamed from: getTickMarksContainerSize-D9Ej5fM, reason: not valid java name */
    public final float m17885getTickMarksContainerSizeD9Ej5fM() {
        return TickMarksContainerSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTickMarksDisabledContainerColor() {
        return TickMarksDisabledContainerColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTickMarksInactiveContainerColor() {
        return TickMarksInactiveContainerColor;
    }

    /* JADX INFO: renamed from: getTrackElevation-D9Ej5fM, reason: not valid java name */
    public final float m17886getTrackElevationD9Ej5fM() {
        return TrackElevation;
    }
}
