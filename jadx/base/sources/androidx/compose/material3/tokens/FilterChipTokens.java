package androidx.compose.material3.tokens;

import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b+\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u000e\u0010\u0016\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u001d\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001e\u0010\u0006R\u000e\u0010\u001f\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u0011\u0010&\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000fR\u0011\u0010(\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000fR\u001c\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006R\u0011\u0010,\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000fR\u000e\u0010.\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000fR\u000e\u00101\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0011\u00102\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000fR\u001c\u00104\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b5\u0010\u0006R\u001c\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b7\u0010\u0006R\u001c\u00108\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b9\u0010\u0006R\u001c\u0010:\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b;\u0010\u0006R\u001c\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b=\u0010\u0006R\u0011\u0010>\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000fR\u001c\u0010@\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bA\u0010\u0006R\u0011\u0010B\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000fR\u001c\u0010D\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bE\u0010\u0006R\u001c\u0010F\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bG\u0010\u0006R\u001c\u0010H\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\bI\u0010\u0006R\u0011\u0010J\u001a\u00020K¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u000fR\u0011\u0010P\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u000fR\u0011\u0010R\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u000fR\u0011\u0010T\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u000fR\u0011\u0010V\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u000fR\u0011\u0010X\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u000fR\u0011\u0010Z\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u000fR\u0011\u0010\\\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u000fR\u0011\u0010^\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u000fR\u0011\u0010`\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u000fR\u0011\u0010b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u000fR\u0011\u0010d\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u000fR\u0011\u0010f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u000fR\u0011\u0010h\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u000fR\u0011\u0010j\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u000fR\u0011\u0010l\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u000fR\u0011\u0010n\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u000fR\u0011\u0010p\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u000fR\u0011\u0010r\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u000fR\u0011\u0010t\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006v"}, m13886d2 = {"Landroidx/compose/material3/tokens/FilterChipTokens;", "", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerSurfaceTintLayerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerSurfaceTintLayerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledIconColor", "getDisabledIconColor", "DisabledIconOpacity", "", "DisabledLabelTextColor", "getDisabledLabelTextColor", "DisabledLabelTextOpacity", "DraggedContainerElevation", "getDraggedContainerElevation-D9Ej5fM", "ElevatedContainerElevation", "getElevatedContainerElevation-D9Ej5fM", "ElevatedDisabledContainerColor", "getElevatedDisabledContainerColor", "ElevatedDisabledContainerElevation", "getElevatedDisabledContainerElevation-D9Ej5fM", "ElevatedDisabledContainerOpacity", "ElevatedFocusContainerElevation", "getElevatedFocusContainerElevation-D9Ej5fM", "ElevatedHoverContainerElevation", "getElevatedHoverContainerElevation-D9Ej5fM", "ElevatedPressedContainerElevation", "getElevatedPressedContainerElevation-D9Ej5fM", "ElevatedSelectedContainerColor", "getElevatedSelectedContainerColor", "ElevatedUnselectedContainerColor", "getElevatedUnselectedContainerColor", "FlatContainerElevation", "getFlatContainerElevation-D9Ej5fM", "FlatDisabledSelectedContainerColor", "getFlatDisabledSelectedContainerColor", "FlatDisabledSelectedContainerOpacity", "FlatDisabledUnselectedOutlineColor", "getFlatDisabledUnselectedOutlineColor", "FlatDisabledUnselectedOutlineOpacity", "FlatSelectedContainerColor", "getFlatSelectedContainerColor", "FlatSelectedFocusContainerElevation", "getFlatSelectedFocusContainerElevation-D9Ej5fM", "FlatSelectedHoverContainerElevation", "getFlatSelectedHoverContainerElevation-D9Ej5fM", "FlatSelectedOutlineWidth", "getFlatSelectedOutlineWidth-D9Ej5fM", "FlatSelectedPressedContainerElevation", "getFlatSelectedPressedContainerElevation-D9Ej5fM", "FlatUnselectedFocusContainerElevation", "getFlatUnselectedFocusContainerElevation-D9Ej5fM", "FlatUnselectedFocusOutlineColor", "getFlatUnselectedFocusOutlineColor", "FlatUnselectedHoverContainerElevation", "getFlatUnselectedHoverContainerElevation-D9Ej5fM", "FlatUnselectedOutlineColor", "getFlatUnselectedOutlineColor", "FlatUnselectedOutlineWidth", "getFlatUnselectedOutlineWidth-D9Ej5fM", "FlatUnselectedPressedContainerElevation", "getFlatUnselectedPressedContainerElevation-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "SelectedDraggedIconColor", "getSelectedDraggedIconColor", "SelectedDraggedLabelTextColor", "getSelectedDraggedLabelTextColor", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedFocusLabelTextColor", "getSelectedFocusLabelTextColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedHoverLabelTextColor", "getSelectedHoverLabelTextColor", "SelectedIconColor", "getSelectedIconColor", "SelectedLabelTextColor", "getSelectedLabelTextColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "SelectedPressedLabelTextColor", "getSelectedPressedLabelTextColor", "UnselectedDraggedIconColor", "getUnselectedDraggedIconColor", "UnselectedDraggedLabelTextColor", "getUnselectedDraggedLabelTextColor", "UnselectedFocusIconColor", "getUnselectedFocusIconColor", "UnselectedFocusLabelTextColor", "getUnselectedFocusLabelTextColor", "UnselectedHoverIconColor", "getUnselectedHoverIconColor", "UnselectedHoverLabelTextColor", "getUnselectedHoverLabelTextColor", "UnselectedIconColor", "getUnselectedIconColor", "UnselectedLabelTextColor", "getUnselectedLabelTextColor", "UnselectedPressedIconColor", "getUnselectedPressedIconColor", "UnselectedPressedLabelTextColor", "getUnselectedPressedLabelTextColor", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class FilterChipTokens {

    @NotNull
    private static final ColorSchemeKeyTokens DisabledIconColor;
    public static final float DisabledIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledLabelTextColor;
    public static final float DisabledLabelTextOpacity = 0.38f;
    private static final float DraggedContainerElevation;
    private static final float ElevatedContainerElevation;

    @NotNull
    private static final ColorSchemeKeyTokens ElevatedDisabledContainerColor;
    private static final float ElevatedDisabledContainerElevation;
    public static final float ElevatedDisabledContainerOpacity = 0.12f;
    private static final float ElevatedFocusContainerElevation;
    private static final float ElevatedHoverContainerElevation;
    private static final float ElevatedPressedContainerElevation;

    @NotNull
    private static final ColorSchemeKeyTokens ElevatedSelectedContainerColor;

    @NotNull
    private static final ColorSchemeKeyTokens ElevatedUnselectedContainerColor;
    private static final float FlatContainerElevation;

    @NotNull
    private static final ColorSchemeKeyTokens FlatDisabledSelectedContainerColor;
    public static final float FlatDisabledSelectedContainerOpacity = 0.12f;

    @NotNull
    private static final ColorSchemeKeyTokens FlatDisabledUnselectedOutlineColor;
    public static final float FlatDisabledUnselectedOutlineOpacity = 0.12f;

    @NotNull
    private static final ColorSchemeKeyTokens FlatSelectedContainerColor;
    private static final float FlatSelectedFocusContainerElevation;
    private static final float FlatSelectedHoverContainerElevation;
    private static final float FlatSelectedOutlineWidth;
    private static final float FlatSelectedPressedContainerElevation;
    private static final float FlatUnselectedFocusContainerElevation;

    @NotNull
    private static final ColorSchemeKeyTokens FlatUnselectedFocusOutlineColor;
    private static final float FlatUnselectedHoverContainerElevation;

    @NotNull
    private static final ColorSchemeKeyTokens FlatUnselectedOutlineColor;
    private static final float FlatUnselectedOutlineWidth;
    private static final float FlatUnselectedPressedContainerElevation;
    private static final float IconSize;

    @NotNull
    private static final TypographyKeyTokens LabelTextFont;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedDraggedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedDraggedLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedFocusIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedFocusLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedHoverIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedHoverLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedPressedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens SelectedPressedLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedDraggedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedDraggedLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedFocusIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedFocusLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedHoverIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedHoverLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedPressedIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens UnselectedPressedLabelTextColor;

    @NotNull
    public static final FilterChipTokens INSTANCE = new FilterChipTokens();
    private static final float ContainerHeight = C2256Dp.m20968constructorimpl((float) 32.0d);

    @NotNull
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerSmall;

    @NotNull
    private static final ColorSchemeKeyTokens ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        DisabledLabelTextColor = colorSchemeKeyTokens;
        ElevationTokens elevationTokens = ElevationTokens.INSTANCE;
        DraggedContainerElevation = elevationTokens.m17596getLevel4D9Ej5fM();
        ElevatedContainerElevation = elevationTokens.m17593getLevel1D9Ej5fM();
        ElevatedDisabledContainerColor = colorSchemeKeyTokens;
        ElevatedDisabledContainerElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        ElevatedFocusContainerElevation = elevationTokens.m17593getLevel1D9Ej5fM();
        ElevatedHoverContainerElevation = elevationTokens.m17594getLevel2D9Ej5fM();
        ElevatedPressedContainerElevation = elevationTokens.m17593getLevel1D9Ej5fM();
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.SecondaryContainer;
        ElevatedSelectedContainerColor = colorSchemeKeyTokens2;
        ElevatedUnselectedContainerColor = ColorSchemeKeyTokens.Surface;
        FlatContainerElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        FlatDisabledSelectedContainerColor = colorSchemeKeyTokens;
        FlatDisabledUnselectedOutlineColor = colorSchemeKeyTokens;
        FlatSelectedContainerColor = colorSchemeKeyTokens2;
        FlatSelectedFocusContainerElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        FlatSelectedHoverContainerElevation = elevationTokens.m17593getLevel1D9Ej5fM();
        FlatSelectedOutlineWidth = C2256Dp.m20968constructorimpl((float) 0.0d);
        FlatSelectedPressedContainerElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        FlatUnselectedFocusContainerElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnSurfaceVariant;
        FlatUnselectedFocusOutlineColor = colorSchemeKeyTokens3;
        FlatUnselectedHoverContainerElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        FlatUnselectedOutlineColor = ColorSchemeKeyTokens.Outline;
        FlatUnselectedOutlineWidth = C2256Dp.m20968constructorimpl((float) 1.0d);
        FlatUnselectedPressedContainerElevation = elevationTokens.m17592getLevel0D9Ej5fM();
        LabelTextFont = TypographyKeyTokens.LabelLarge;
        ColorSchemeKeyTokens colorSchemeKeyTokens4 = ColorSchemeKeyTokens.OnSecondaryContainer;
        SelectedDraggedLabelTextColor = colorSchemeKeyTokens4;
        SelectedFocusLabelTextColor = colorSchemeKeyTokens4;
        SelectedHoverLabelTextColor = colorSchemeKeyTokens4;
        SelectedLabelTextColor = colorSchemeKeyTokens4;
        SelectedPressedLabelTextColor = colorSchemeKeyTokens4;
        UnselectedDraggedLabelTextColor = colorSchemeKeyTokens3;
        UnselectedFocusLabelTextColor = colorSchemeKeyTokens3;
        UnselectedHoverLabelTextColor = colorSchemeKeyTokens3;
        UnselectedLabelTextColor = colorSchemeKeyTokens3;
        UnselectedPressedLabelTextColor = colorSchemeKeyTokens3;
        DisabledIconColor = colorSchemeKeyTokens;
        IconSize = C2256Dp.m20968constructorimpl((float) 18.0d);
        SelectedDraggedIconColor = colorSchemeKeyTokens4;
        SelectedFocusIconColor = colorSchemeKeyTokens4;
        SelectedHoverIconColor = colorSchemeKeyTokens4;
        SelectedIconColor = colorSchemeKeyTokens4;
        SelectedPressedIconColor = colorSchemeKeyTokens4;
        UnselectedDraggedIconColor = colorSchemeKeyTokens3;
        UnselectedFocusIconColor = colorSchemeKeyTokens3;
        UnselectedHoverIconColor = colorSchemeKeyTokens3;
        UnselectedIconColor = colorSchemeKeyTokens3;
        UnselectedPressedIconColor = colorSchemeKeyTokens3;
    }

    private FilterChipTokens() {
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m17694getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    @NotNull
    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    @NotNull
    public final ColorSchemeKeyTokens getContainerSurfaceTintLayerColor() {
        return ContainerSurfaceTintLayerColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledIconColor() {
        return DisabledIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledLabelTextColor() {
        return DisabledLabelTextColor;
    }

    /* JADX INFO: renamed from: getDraggedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17695getDraggedContainerElevationD9Ej5fM() {
        return DraggedContainerElevation;
    }

    /* JADX INFO: renamed from: getElevatedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17696getElevatedContainerElevationD9Ej5fM() {
        return ElevatedContainerElevation;
    }

    @NotNull
    public final ColorSchemeKeyTokens getElevatedDisabledContainerColor() {
        return ElevatedDisabledContainerColor;
    }

    /* JADX INFO: renamed from: getElevatedDisabledContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17697getElevatedDisabledContainerElevationD9Ej5fM() {
        return ElevatedDisabledContainerElevation;
    }

    /* JADX INFO: renamed from: getElevatedFocusContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17698getElevatedFocusContainerElevationD9Ej5fM() {
        return ElevatedFocusContainerElevation;
    }

    /* JADX INFO: renamed from: getElevatedHoverContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17699getElevatedHoverContainerElevationD9Ej5fM() {
        return ElevatedHoverContainerElevation;
    }

    /* JADX INFO: renamed from: getElevatedPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17700getElevatedPressedContainerElevationD9Ej5fM() {
        return ElevatedPressedContainerElevation;
    }

    @NotNull
    public final ColorSchemeKeyTokens getElevatedSelectedContainerColor() {
        return ElevatedSelectedContainerColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getElevatedUnselectedContainerColor() {
        return ElevatedUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: getFlatContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17701getFlatContainerElevationD9Ej5fM() {
        return FlatContainerElevation;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFlatDisabledSelectedContainerColor() {
        return FlatDisabledSelectedContainerColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFlatDisabledUnselectedOutlineColor() {
        return FlatDisabledUnselectedOutlineColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFlatSelectedContainerColor() {
        return FlatSelectedContainerColor;
    }

    /* JADX INFO: renamed from: getFlatSelectedFocusContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17702getFlatSelectedFocusContainerElevationD9Ej5fM() {
        return FlatSelectedFocusContainerElevation;
    }

    /* JADX INFO: renamed from: getFlatSelectedHoverContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17703getFlatSelectedHoverContainerElevationD9Ej5fM() {
        return FlatSelectedHoverContainerElevation;
    }

    /* JADX INFO: renamed from: getFlatSelectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m17704getFlatSelectedOutlineWidthD9Ej5fM() {
        return FlatSelectedOutlineWidth;
    }

    /* JADX INFO: renamed from: getFlatSelectedPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17705getFlatSelectedPressedContainerElevationD9Ej5fM() {
        return FlatSelectedPressedContainerElevation;
    }

    /* JADX INFO: renamed from: getFlatUnselectedFocusContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17706getFlatUnselectedFocusContainerElevationD9Ej5fM() {
        return FlatUnselectedFocusContainerElevation;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFlatUnselectedFocusOutlineColor() {
        return FlatUnselectedFocusOutlineColor;
    }

    /* JADX INFO: renamed from: getFlatUnselectedHoverContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17707getFlatUnselectedHoverContainerElevationD9Ej5fM() {
        return FlatUnselectedHoverContainerElevation;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFlatUnselectedOutlineColor() {
        return FlatUnselectedOutlineColor;
    }

    /* JADX INFO: renamed from: getFlatUnselectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m17708getFlatUnselectedOutlineWidthD9Ej5fM() {
        return FlatUnselectedOutlineWidth;
    }

    /* JADX INFO: renamed from: getFlatUnselectedPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17709getFlatUnselectedPressedContainerElevationD9Ej5fM() {
        return FlatUnselectedPressedContainerElevation;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17710getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @NotNull
    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedDraggedIconColor() {
        return SelectedDraggedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedDraggedLabelTextColor() {
        return SelectedDraggedLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return SelectedFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedFocusLabelTextColor() {
        return SelectedFocusLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return SelectedHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedHoverLabelTextColor() {
        return SelectedHoverLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedIconColor() {
        return SelectedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedLabelTextColor() {
        return SelectedLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return SelectedPressedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSelectedPressedLabelTextColor() {
        return SelectedPressedLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedDraggedIconColor() {
        return UnselectedDraggedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedDraggedLabelTextColor() {
        return UnselectedDraggedLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedFocusIconColor() {
        return UnselectedFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedFocusLabelTextColor() {
        return UnselectedFocusLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedHoverIconColor() {
        return UnselectedHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedHoverLabelTextColor() {
        return UnselectedHoverLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedIconColor() {
        return UnselectedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedLabelTextColor() {
        return UnselectedLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedPressedIconColor() {
        return UnselectedPressedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getUnselectedPressedLabelTextColor() {
        return UnselectedPressedLabelTextColor;
    }
}
