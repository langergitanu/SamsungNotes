package androidx.compose.material3.tokens;

import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bZ\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u000e\u0010\u0011\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u001c\u0010$\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 R\u001c\u0010&\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0011\u0010(\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u0011\u0010*\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0006R\u0011\u0010,\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0006R\u0011\u0010.\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b1\u0010 R\u001c\u00102\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b3\u0010 R\u0011\u00104\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0006R\u0011\u00106\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0006R\u0011\u00108\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0006R\u0011\u0010:\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0006R\u001c\u0010<\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b=\u0010 R\u0011\u0010>\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0006R\u0011\u0010@\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0006R\u0011\u0010B\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0006R\u0011\u0010D\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0006R\u0011\u0010F\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u001cR\u001c\u0010H\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\bI\u0010 R\u001c\u0010J\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\bK\u0010 R\u001c\u0010L\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\bM\u0010 R\u0011\u0010N\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u001cR\u001c\u0010P\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\bQ\u0010 R\u0011\u0010R\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0006R\u0011\u0010T\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0006R\u0011\u0010V\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0006R\u0011\u0010X\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0006R\u0011\u0010Z\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0006R\u001c\u0010\\\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b]\u0010 R\u001c\u0010^\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b_\u0010 R\u0011\u0010`\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0006R\u0011\u0010b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0006R\u0011\u0010d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0006R\u0011\u0010f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0006R\u0011\u0010h\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0006R\u001c\u0010j\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\bk\u0010 R\u0011\u0010l\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0006R\u0011\u0010n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0006R\u0011\u0010p\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0006R\u0011\u0010r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0006R\u0011\u0010t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0006R\u0011\u0010v\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006x"}, m13886d2 = {"Landroidx/compose/material3/tokens/SwitchTokens;", "", "()V", "DisabledSelectedHandleColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledSelectedHandleColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledSelectedHandleOpacity", "", "DisabledSelectedIconColor", "getDisabledSelectedIconColor", "DisabledSelectedIconOpacity", "DisabledSelectedTrackColor", "getDisabledSelectedTrackColor", "DisabledTrackOpacity", "DisabledUnselectedHandleColor", "getDisabledUnselectedHandleColor", "DisabledUnselectedHandleOpacity", "DisabledUnselectedIconColor", "getDisabledUnselectedIconColor", "DisabledUnselectedIconOpacity", "DisabledUnselectedTrackColor", "getDisabledUnselectedTrackColor", "DisabledUnselectedTrackOutlineColor", "getDisabledUnselectedTrackOutlineColor", "HandleShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getHandleShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "IconHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getIconHandleHeight-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "IconHandleWidth", "getIconHandleWidth-D9Ej5fM", "PressedHandleHeight", "getPressedHandleHeight-D9Ej5fM", "PressedHandleWidth", "getPressedHandleWidth-D9Ej5fM", "SelectedFocusHandleColor", "getSelectedFocusHandleColor", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedFocusTrackColor", "getSelectedFocusTrackColor", "SelectedHandleColor", "getSelectedHandleColor", "SelectedHandleHeight", "getSelectedHandleHeight-D9Ej5fM", "SelectedHandleWidth", "getSelectedHandleWidth-D9Ej5fM", "SelectedHoverHandleColor", "getSelectedHoverHandleColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedHoverTrackColor", "getSelectedHoverTrackColor", "SelectedIconColor", "getSelectedIconColor", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "SelectedPressedHandleColor", "getSelectedPressedHandleColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "SelectedPressedTrackColor", "getSelectedPressedTrackColor", "SelectedTrackColor", "getSelectedTrackColor", "StateLayerShape", "getStateLayerShape", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "TrackHeight", "getTrackHeight-D9Ej5fM", "TrackOutlineWidth", "getTrackOutlineWidth-D9Ej5fM", "TrackShape", "getTrackShape", "TrackWidth", "getTrackWidth-D9Ej5fM", "UnselectedFocusHandleColor", "getUnselectedFocusHandleColor", "UnselectedFocusIconColor", "getUnselectedFocusIconColor", "UnselectedFocusTrackColor", "getUnselectedFocusTrackColor", "UnselectedFocusTrackOutlineColor", "getUnselectedFocusTrackOutlineColor", "UnselectedHandleColor", "getUnselectedHandleColor", "UnselectedHandleHeight", "getUnselectedHandleHeight-D9Ej5fM", "UnselectedHandleWidth", "getUnselectedHandleWidth-D9Ej5fM", "UnselectedHoverHandleColor", "getUnselectedHoverHandleColor", "UnselectedHoverIconColor", "getUnselectedHoverIconColor", "UnselectedHoverTrackColor", "getUnselectedHoverTrackColor", "UnselectedHoverTrackOutlineColor", "getUnselectedHoverTrackOutlineColor", "UnselectedIconColor", "getUnselectedIconColor", "UnselectedIconSize", "getUnselectedIconSize-D9Ej5fM", "UnselectedPressedHandleColor", "getUnselectedPressedHandleColor", "UnselectedPressedIconColor", "getUnselectedPressedIconColor", "UnselectedPressedTrackColor", "getUnselectedPressedTrackColor", "UnselectedPressedTrackOutlineColor", "getUnselectedPressedTrackOutlineColor", "UnselectedTrackColor", "getUnselectedTrackColor", "UnselectedTrackOutlineColor", "getUnselectedTrackOutlineColor", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwitchTokens {
    public static final float DisabledSelectedHandleOpacity = 1.0f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledSelectedIconColor;
    public static final float DisabledSelectedIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledSelectedTrackColor;
    public static final float DisabledTrackOpacity = 0.12f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledUnselectedHandleColor;
    public static final float DisabledUnselectedHandleOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledUnselectedIconColor;
    public static final float DisabledUnselectedIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledUnselectedTrackColor;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledUnselectedTrackOutlineColor;

    @NotNull
    private static final ShapeKeyTokens HandleShape;
    private static final float IconHandleHeight;
    private static final float IconHandleWidth;
    private static final float PressedHandleHeight;
    private static final float PressedHandleWidth;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedFocusHandleColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedFocusIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedFocusTrackColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedHandleColor;
    private static final float SelectedHandleHeight;
    private static final float SelectedHandleWidth;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedHoverHandleColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedHoverIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedHoverTrackColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedIconColor;
    private static final float SelectedIconSize;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedPressedHandleColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedPressedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedPressedTrackColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedTrackColor;

    @NotNull
    private static final ShapeKeyTokens StateLayerShape;
    private static final float StateLayerSize;
    private static final float TrackHeight;
    private static final float TrackOutlineWidth;

    @NotNull
    private static final ShapeKeyTokens TrackShape;
    private static final float TrackWidth;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedFocusHandleColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedFocusIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedFocusTrackColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedFocusTrackOutlineColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedHandleColor;
    private static final float UnselectedHandleHeight;
    private static final float UnselectedHandleWidth;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedHoverHandleColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedHoverIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedHoverTrackColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedHoverTrackOutlineColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedIconColor;
    private static final float UnselectedIconSize;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedPressedHandleColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedPressedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedPressedTrackColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedPressedTrackOutlineColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedTrackColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedTrackOutlineColor;

    @NotNull
    public static final SwitchTokens INSTANCE = new SwitchTokens();

    @NotNull
    private static final ColorSchemeKeyTokens DisabledSelectedHandleColor = ColorSchemeKeyTokens.Surface;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        DisabledSelectedIconColor = colorSchemeKeyTokens;
        DisabledSelectedTrackColor = colorSchemeKeyTokens;
        DisabledUnselectedHandleColor = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.SurfaceVariant;
        DisabledUnselectedIconColor = colorSchemeKeyTokens2;
        DisabledUnselectedTrackColor = colorSchemeKeyTokens2;
        DisabledUnselectedTrackOutlineColor = colorSchemeKeyTokens;
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        HandleShape = shapeKeyTokens;
        float f = (float) 28.0d;
        PressedHandleHeight = C2256Dp.m20968constructorimpl(f);
        PressedHandleWidth = C2256Dp.m20968constructorimpl(f);
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.PrimaryContainer;
        SelectedFocusHandleColor = colorSchemeKeyTokens3;
        ColorSchemeKeyTokens colorSchemeKeyTokens4 = ColorSchemeKeyTokens.OnPrimaryContainer;
        SelectedFocusIconColor = colorSchemeKeyTokens4;
        ColorSchemeKeyTokens colorSchemeKeyTokens5 = ColorSchemeKeyTokens.Primary;
        SelectedFocusTrackColor = colorSchemeKeyTokens5;
        SelectedHandleColor = ColorSchemeKeyTokens.OnPrimary;
        float f4 = (float) 24.0d;
        SelectedHandleHeight = C2256Dp.m20968constructorimpl(f4);
        SelectedHandleWidth = C2256Dp.m20968constructorimpl(f4);
        SelectedHoverHandleColor = colorSchemeKeyTokens3;
        SelectedHoverIconColor = colorSchemeKeyTokens4;
        SelectedHoverTrackColor = colorSchemeKeyTokens5;
        SelectedIconColor = colorSchemeKeyTokens4;
        float f5 = (float) 16.0d;
        SelectedIconSize = C2256Dp.m20968constructorimpl(f5);
        SelectedPressedHandleColor = colorSchemeKeyTokens3;
        SelectedPressedIconColor = colorSchemeKeyTokens4;
        SelectedPressedTrackColor = colorSchemeKeyTokens5;
        SelectedTrackColor = colorSchemeKeyTokens5;
        StateLayerShape = shapeKeyTokens;
        StateLayerSize = C2256Dp.m20968constructorimpl((float) 40.0d);
        TrackHeight = C2256Dp.m20968constructorimpl((float) 32.0d);
        TrackOutlineWidth = C2256Dp.m20968constructorimpl((float) 2.0d);
        TrackShape = shapeKeyTokens;
        TrackWidth = C2256Dp.m20968constructorimpl((float) 52.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens6 = ColorSchemeKeyTokens.OnSurfaceVariant;
        UnselectedFocusHandleColor = colorSchemeKeyTokens6;
        UnselectedFocusIconColor = colorSchemeKeyTokens2;
        UnselectedFocusTrackColor = colorSchemeKeyTokens2;
        ColorSchemeKeyTokens colorSchemeKeyTokens7 = ColorSchemeKeyTokens.Outline;
        UnselectedFocusTrackOutlineColor = colorSchemeKeyTokens7;
        UnselectedHandleColor = colorSchemeKeyTokens7;
        UnselectedHandleHeight = C2256Dp.m20968constructorimpl(f5);
        UnselectedHandleWidth = C2256Dp.m20968constructorimpl(f5);
        UnselectedHoverHandleColor = colorSchemeKeyTokens6;
        UnselectedHoverIconColor = colorSchemeKeyTokens2;
        UnselectedHoverTrackColor = colorSchemeKeyTokens2;
        UnselectedHoverTrackOutlineColor = colorSchemeKeyTokens7;
        UnselectedIconColor = colorSchemeKeyTokens2;
        UnselectedIconSize = C2256Dp.m20968constructorimpl(f5);
        UnselectedPressedHandleColor = colorSchemeKeyTokens6;
        UnselectedPressedIconColor = colorSchemeKeyTokens2;
        UnselectedPressedTrackColor = colorSchemeKeyTokens2;
        UnselectedPressedTrackOutlineColor = colorSchemeKeyTokens7;
        UnselectedTrackColor = colorSchemeKeyTokens2;
        UnselectedTrackOutlineColor = colorSchemeKeyTokens7;
        IconHandleHeight = C2256Dp.m20968constructorimpl(f4);
        IconHandleWidth = C2256Dp.m20968constructorimpl(f4);
    }

    private SwitchTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledSelectedHandleColor() {
        return DisabledSelectedHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledSelectedIconColor() {
        return DisabledSelectedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledSelectedTrackColor() {
        return DisabledSelectedTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledUnselectedHandleColor() {
        return DisabledUnselectedHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledUnselectedIconColor() {
        return DisabledUnselectedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledUnselectedTrackColor() {
        return DisabledUnselectedTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledUnselectedTrackOutlineColor() {
        return DisabledUnselectedTrackOutlineColor;
    }

    @NotNull
    public final ShapeKeyTokens getHandleShape() {
        return HandleShape;
    }

    /* JADX INFO: renamed from: getIconHandleHeight-D9Ej5fM, reason: not valid java name */
    public final float m17901getIconHandleHeightD9Ej5fM() {
        return IconHandleHeight;
    }

    /* JADX INFO: renamed from: getIconHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m17902getIconHandleWidthD9Ej5fM() {
        return IconHandleWidth;
    }

    /* JADX INFO: renamed from: getPressedHandleHeight-D9Ej5fM, reason: not valid java name */
    public final float m17903getPressedHandleHeightD9Ej5fM() {
        return PressedHandleHeight;
    }

    /* JADX INFO: renamed from: getPressedHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m17904getPressedHandleWidthD9Ej5fM() {
        return PressedHandleWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedFocusHandleColor() {
        return SelectedFocusHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return SelectedFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedFocusTrackColor() {
        return SelectedFocusTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedHandleColor() {
        return SelectedHandleColor;
    }

    /* JADX INFO: renamed from: getSelectedHandleHeight-D9Ej5fM, reason: not valid java name */
    public final float m17905getSelectedHandleHeightD9Ej5fM() {
        return SelectedHandleHeight;
    }

    /* JADX INFO: renamed from: getSelectedHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m17906getSelectedHandleWidthD9Ej5fM() {
        return SelectedHandleWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedHoverHandleColor() {
        return SelectedHoverHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return SelectedHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedHoverTrackColor() {
        return SelectedHoverTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedIconColor() {
        return SelectedIconColor;
    }

    /* JADX INFO: renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17907getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedPressedHandleColor() {
        return SelectedPressedHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return SelectedPressedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedPressedTrackColor() {
        return SelectedPressedTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedTrackColor() {
        return SelectedTrackColor;
    }

    @NotNull
    public final ShapeKeyTokens getStateLayerShape() {
        return StateLayerShape;
    }

    /* JADX INFO: renamed from: getStateLayerSize-D9Ej5fM, reason: not valid java name */
    public final float m17908getStateLayerSizeD9Ej5fM() {
        return StateLayerSize;
    }

    /* JADX INFO: renamed from: getTrackHeight-D9Ej5fM, reason: not valid java name */
    public final float m17909getTrackHeightD9Ej5fM() {
        return TrackHeight;
    }

    /* JADX INFO: renamed from: getTrackOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m17910getTrackOutlineWidthD9Ej5fM() {
        return TrackOutlineWidth;
    }

    @NotNull
    public final ShapeKeyTokens getTrackShape() {
        return TrackShape;
    }

    /* JADX INFO: renamed from: getTrackWidth-D9Ej5fM, reason: not valid java name */
    public final float m17911getTrackWidthD9Ej5fM() {
        return TrackWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedFocusHandleColor() {
        return UnselectedFocusHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedFocusIconColor() {
        return UnselectedFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedFocusTrackColor() {
        return UnselectedFocusTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedFocusTrackOutlineColor() {
        return UnselectedFocusTrackOutlineColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedHandleColor() {
        return UnselectedHandleColor;
    }

    /* JADX INFO: renamed from: getUnselectedHandleHeight-D9Ej5fM, reason: not valid java name */
    public final float m17912getUnselectedHandleHeightD9Ej5fM() {
        return UnselectedHandleHeight;
    }

    /* JADX INFO: renamed from: getUnselectedHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m17913getUnselectedHandleWidthD9Ej5fM() {
        return UnselectedHandleWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedHoverHandleColor() {
        return UnselectedHoverHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedHoverIconColor() {
        return UnselectedHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedHoverTrackColor() {
        return UnselectedHoverTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedHoverTrackOutlineColor() {
        return UnselectedHoverTrackOutlineColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedIconColor() {
        return UnselectedIconColor;
    }

    /* JADX INFO: renamed from: getUnselectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17914getUnselectedIconSizeD9Ej5fM() {
        return UnselectedIconSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedPressedHandleColor() {
        return UnselectedPressedHandleColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedPressedIconColor() {
        return UnselectedPressedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedPressedTrackColor() {
        return UnselectedPressedTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedPressedTrackOutlineColor() {
        return UnselectedPressedTrackOutlineColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedTrackColor() {
        return UnselectedTrackColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedTrackOutlineColor() {
        return UnselectedTrackOutlineColor;
    }
}
