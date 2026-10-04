package androidx.compose.material3.tokens;

import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\bW\n\u0002\u0018\u0002\n\u0002\b\u0019\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\nR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0019\u0010\nR\u000e\u0010\u001a\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u000e\u0010\u001e\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u000e\u0010!\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u000e\u0010$\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u000e\u0010'\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u000e\u0010*\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u000e\u0010-\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0006R\u0011\u00100\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0006R\u0011\u00102\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0006R\u0011\u00104\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0006R\u0011\u00106\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0006R\u0011\u00108\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0006R\u0011\u0010:\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0006R\u0011\u0010<\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0006R\u0011\u0010>\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0006R\u0011\u0010@\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0006R\u0011\u0010B\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0006R\u0011\u0010D\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0006R\u0011\u0010F\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0006R\u0011\u0010H\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0006R\u0011\u0010J\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0006R\u0011\u0010L\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0006R\u0011\u0010N\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0006R\u0011\u0010P\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0006R\u0011\u0010R\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0006R\u0011\u0010T\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0006R\u001c\u0010V\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bW\u0010\nR\u0011\u0010X\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0006R\u0011\u0010Z\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0006R\u0011\u0010\\\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0006R\u0011\u0010^\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0006R\u0011\u0010`\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0006R\u0011\u0010b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0006R\u001c\u0010d\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\be\u0010\nR\u0011\u0010f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0006R\u0011\u0010h\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0006R\u0011\u0010j\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0006R\u0011\u0010l\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0006R\u0011\u0010n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0006R\u0011\u0010p\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0006R\u0011\u0010r\u001a\u00020s¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0011\u0010v\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0006R\u0011\u0010x\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u0006R\u0011\u0010z\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\u0006R\u0011\u0010|\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\u0006R\u0011\u0010~\u001a\u00020s¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010uR\u0013\u0010\u0080\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0006R\u001e\u0010\u0082\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0083\u0001\u0010\nR\u0013\u0010\u0084\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0006R\u0013\u0010\u0086\u0001\u001a\u00020s¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010uR\u0013\u0010\u0088\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0006R\u001e\u0010\u008a\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u008b\u0001\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008c\u0001"}, m13886d2 = {"Landroidx/compose/material3/tokens/FilledTextFieldTokens;", "", "()V", "ActiveIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "CaretColor", "getCaretColor", "ContainerColor", "getContainerColor", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DisabledActiveIndicatorColor", "getDisabledActiveIndicatorColor", "DisabledActiveIndicatorHeight", "getDisabledActiveIndicatorHeight-D9Ej5fM", "DisabledActiveIndicatorOpacity", "", "DisabledContainerColor", "getDisabledContainerColor", "DisabledContainerOpacity", "DisabledInputColor", "getDisabledInputColor", "DisabledInputOpacity", "DisabledLabelColor", "getDisabledLabelColor", "DisabledLabelOpacity", "DisabledLeadingIconColor", "getDisabledLeadingIconColor", "DisabledLeadingIconOpacity", "DisabledSupportingColor", "getDisabledSupportingColor", "DisabledSupportingOpacity", "DisabledTrailingIconColor", "getDisabledTrailingIconColor", "DisabledTrailingIconOpacity", "ErrorActiveIndicatorColor", "getErrorActiveIndicatorColor", "ErrorFocusActiveIndicatorColor", "getErrorFocusActiveIndicatorColor", "ErrorFocusCaretColor", "getErrorFocusCaretColor", "ErrorFocusInputColor", "getErrorFocusInputColor", "ErrorFocusLabelColor", "getErrorFocusLabelColor", "ErrorFocusLeadingIconColor", "getErrorFocusLeadingIconColor", "ErrorFocusSupportingColor", "getErrorFocusSupportingColor", "ErrorFocusTrailingIconColor", "getErrorFocusTrailingIconColor", "ErrorHoverActiveIndicatorColor", "getErrorHoverActiveIndicatorColor", "ErrorHoverInputColor", "getErrorHoverInputColor", "ErrorHoverLabelColor", "getErrorHoverLabelColor", "ErrorHoverLeadingIconColor", "getErrorHoverLeadingIconColor", "ErrorHoverSupportingColor", "getErrorHoverSupportingColor", "ErrorHoverTrailingIconColor", "getErrorHoverTrailingIconColor", "ErrorInputColor", "getErrorInputColor", "ErrorLabelColor", "getErrorLabelColor", "ErrorLeadingIconColor", "getErrorLeadingIconColor", "ErrorSupportingColor", "getErrorSupportingColor", "ErrorTrailingIconColor", "getErrorTrailingIconColor", "FocusActiveIndicatorColor", "getFocusActiveIndicatorColor", "FocusActiveIndicatorHeight", "getFocusActiveIndicatorHeight-D9Ej5fM", "FocusInputColor", "getFocusInputColor", "FocusLabelColor", "getFocusLabelColor", "FocusLeadingIconColor", "getFocusLeadingIconColor", "FocusSupportingColor", "getFocusSupportingColor", "FocusTrailingIconColor", "getFocusTrailingIconColor", "HoverActiveIndicatorColor", "getHoverActiveIndicatorColor", "HoverActiveIndicatorHeight", "getHoverActiveIndicatorHeight-D9Ej5fM", "HoverInputColor", "getHoverInputColor", "HoverLabelColor", "getHoverLabelColor", "HoverLeadingIconColor", "getHoverLeadingIconColor", "HoverSupportingColor", "getHoverSupportingColor", "HoverTrailingIconColor", "getHoverTrailingIconColor", "InputColor", "getInputColor", "InputFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getInputFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "InputPlaceholderColor", "getInputPlaceholderColor", "InputPrefixColor", "getInputPrefixColor", "InputSuffixColor", "getInputSuffixColor", "LabelColor", "getLabelColor", "LabelFont", "getLabelFont", "LeadingIconColor", "getLeadingIconColor", "LeadingIconSize", "getLeadingIconSize-D9Ej5fM", "SupportingColor", "getSupportingColor", "SupportingFont", "getSupportingFont", "TrailingIconColor", "getTrailingIconColor", "TrailingIconSize", "getTrailingIconSize-D9Ej5fM", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class FilledTextFieldTokens {

    @NotNull
    private static final ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final float ActiveIndicatorHeight;

    @NotNull
    private static final ColorSchemeKeyTokens CaretColor;

    @NotNull
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerHeight;

    @NotNull
    private static final ShapeKeyTokens ContainerShape;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledActiveIndicatorColor;
    private static final float DisabledActiveIndicatorHeight;
    public static final float DisabledActiveIndicatorOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledContainerColor;
    public static final float DisabledContainerOpacity = 0.04f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledInputColor;
    public static final float DisabledInputOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledLabelColor;
    public static final float DisabledLabelOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledLeadingIconColor;
    public static final float DisabledLeadingIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledSupportingColor;
    public static final float DisabledSupportingOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens DisabledTrailingIconColor;
    public static final float DisabledTrailingIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorActiveIndicatorColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorFocusActiveIndicatorColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorFocusCaretColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorFocusInputColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorFocusLabelColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorFocusLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorFocusSupportingColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorFocusTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorHoverActiveIndicatorColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorHoverInputColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorHoverLabelColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorHoverLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorHoverSupportingColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorHoverTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorInputColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorLabelColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorSupportingColor;

    @NotNull
    private static final ColorSchemeKeyTokens ErrorTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens FocusActiveIndicatorColor;
    private static final float FocusActiveIndicatorHeight;

    @NotNull
    private static final ColorSchemeKeyTokens FocusInputColor;

    @NotNull
    private static final ColorSchemeKeyTokens FocusLabelColor;

    @NotNull
    private static final ColorSchemeKeyTokens FocusLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens FocusSupportingColor;

    @NotNull
    private static final ColorSchemeKeyTokens FocusTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens HoverActiveIndicatorColor;
    private static final float HoverActiveIndicatorHeight;

    @NotNull
    private static final ColorSchemeKeyTokens HoverInputColor;

    @NotNull
    private static final ColorSchemeKeyTokens HoverLabelColor;

    @NotNull
    private static final ColorSchemeKeyTokens HoverLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens HoverSupportingColor;

    @NotNull
    private static final ColorSchemeKeyTokens HoverTrailingIconColor;

    @NotNull
    public static final FilledTextFieldTokens INSTANCE = new FilledTextFieldTokens();

    @NotNull
    private static final ColorSchemeKeyTokens InputColor;

    @NotNull
    private static final TypographyKeyTokens InputFont;

    @NotNull
    private static final ColorSchemeKeyTokens InputPlaceholderColor;

    @NotNull
    private static final ColorSchemeKeyTokens InputPrefixColor;

    @NotNull
    private static final ColorSchemeKeyTokens InputSuffixColor;

    @NotNull
    private static final ColorSchemeKeyTokens LabelColor;

    @NotNull
    private static final TypographyKeyTokens LabelFont;

    @NotNull
    private static final ColorSchemeKeyTokens LeadingIconColor;
    private static final float LeadingIconSize;

    @NotNull
    private static final ColorSchemeKeyTokens SupportingColor;

    @NotNull
    private static final TypographyKeyTokens SupportingFont;

    @NotNull
    private static final ColorSchemeKeyTokens TrailingIconColor;
    private static final float TrailingIconSize;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurfaceVariant;
        ActiveIndicatorColor = colorSchemeKeyTokens;
        float f = (float) 1.0d;
        ActiveIndicatorHeight = C2256Dp.m20968constructorimpl(f);
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.Primary;
        CaretColor = colorSchemeKeyTokens2;
        ContainerColor = ColorSchemeKeyTokens.SurfaceVariant;
        ContainerHeight = C2256Dp.m20968constructorimpl((float) 56.0d);
        ContainerShape = ShapeKeyTokens.CornerExtraSmallTop;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnSurface;
        DisabledActiveIndicatorColor = colorSchemeKeyTokens3;
        DisabledActiveIndicatorHeight = C2256Dp.m20968constructorimpl(f);
        DisabledContainerColor = colorSchemeKeyTokens3;
        DisabledInputColor = colorSchemeKeyTokens3;
        DisabledLabelColor = colorSchemeKeyTokens3;
        DisabledLeadingIconColor = colorSchemeKeyTokens3;
        DisabledSupportingColor = colorSchemeKeyTokens3;
        DisabledTrailingIconColor = colorSchemeKeyTokens3;
        ColorSchemeKeyTokens colorSchemeKeyTokens4 = ColorSchemeKeyTokens.Error;
        ErrorActiveIndicatorColor = colorSchemeKeyTokens4;
        ErrorFocusActiveIndicatorColor = colorSchemeKeyTokens4;
        ErrorFocusCaretColor = colorSchemeKeyTokens4;
        ErrorFocusInputColor = colorSchemeKeyTokens3;
        ErrorFocusLabelColor = colorSchemeKeyTokens4;
        ErrorFocusLeadingIconColor = colorSchemeKeyTokens;
        ErrorFocusSupportingColor = colorSchemeKeyTokens4;
        ErrorFocusTrailingIconColor = colorSchemeKeyTokens4;
        ColorSchemeKeyTokens colorSchemeKeyTokens5 = ColorSchemeKeyTokens.OnErrorContainer;
        ErrorHoverActiveIndicatorColor = colorSchemeKeyTokens5;
        ErrorHoverInputColor = colorSchemeKeyTokens3;
        ErrorHoverLabelColor = colorSchemeKeyTokens5;
        ErrorHoverLeadingIconColor = colorSchemeKeyTokens;
        ErrorHoverSupportingColor = colorSchemeKeyTokens4;
        ErrorHoverTrailingIconColor = colorSchemeKeyTokens5;
        ErrorInputColor = colorSchemeKeyTokens3;
        ErrorLabelColor = colorSchemeKeyTokens4;
        ErrorLeadingIconColor = colorSchemeKeyTokens;
        ErrorSupportingColor = colorSchemeKeyTokens4;
        ErrorTrailingIconColor = colorSchemeKeyTokens4;
        FocusActiveIndicatorColor = colorSchemeKeyTokens2;
        FocusActiveIndicatorHeight = C2256Dp.m20968constructorimpl((float) 2.0d);
        FocusInputColor = colorSchemeKeyTokens3;
        FocusLabelColor = colorSchemeKeyTokens2;
        FocusLeadingIconColor = colorSchemeKeyTokens;
        FocusSupportingColor = colorSchemeKeyTokens;
        FocusTrailingIconColor = colorSchemeKeyTokens;
        HoverActiveIndicatorColor = colorSchemeKeyTokens3;
        HoverActiveIndicatorHeight = C2256Dp.m20968constructorimpl(f);
        HoverInputColor = colorSchemeKeyTokens3;
        HoverLabelColor = colorSchemeKeyTokens;
        HoverLeadingIconColor = colorSchemeKeyTokens;
        HoverSupportingColor = colorSchemeKeyTokens;
        HoverTrailingIconColor = colorSchemeKeyTokens;
        InputColor = colorSchemeKeyTokens3;
        TypographyKeyTokens typographyKeyTokens = TypographyKeyTokens.BodyLarge;
        InputFont = typographyKeyTokens;
        InputPlaceholderColor = colorSchemeKeyTokens;
        InputPrefixColor = colorSchemeKeyTokens;
        InputSuffixColor = colorSchemeKeyTokens;
        LabelColor = colorSchemeKeyTokens;
        LabelFont = typographyKeyTokens;
        LeadingIconColor = colorSchemeKeyTokens;
        LeadingIconSize = C2256Dp.m20968constructorimpl((float) 20.0d);
        SupportingColor = colorSchemeKeyTokens;
        SupportingFont = TypographyKeyTokens.BodySmall;
        TrailingIconColor = colorSchemeKeyTokens;
        TrailingIconSize = C2256Dp.m20968constructorimpl((float) 24.0d);
    }

    private FilledTextFieldTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveIndicatorColor() {
        return ActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17678getActiveIndicatorHeightD9Ej5fM() {
        return ActiveIndicatorHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getCaretColor() {
        return CaretColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m17679getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    @NotNull
    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledActiveIndicatorColor() {
        return DisabledActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17680getDisabledActiveIndicatorHeightD9Ej5fM() {
        return DisabledActiveIndicatorHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledContainerColor() {
        return DisabledContainerColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledInputColor() {
        return DisabledInputColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledLabelColor() {
        return DisabledLabelColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledLeadingIconColor() {
        return DisabledLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledSupportingColor() {
        return DisabledSupportingColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDisabledTrailingIconColor() {
        return DisabledTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorActiveIndicatorColor() {
        return ErrorActiveIndicatorColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorFocusActiveIndicatorColor() {
        return ErrorFocusActiveIndicatorColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorFocusCaretColor() {
        return ErrorFocusCaretColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorFocusInputColor() {
        return ErrorFocusInputColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorFocusLabelColor() {
        return ErrorFocusLabelColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorFocusLeadingIconColor() {
        return ErrorFocusLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorFocusSupportingColor() {
        return ErrorFocusSupportingColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorFocusTrailingIconColor() {
        return ErrorFocusTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorHoverActiveIndicatorColor() {
        return ErrorHoverActiveIndicatorColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorHoverInputColor() {
        return ErrorHoverInputColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorHoverLabelColor() {
        return ErrorHoverLabelColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorHoverLeadingIconColor() {
        return ErrorHoverLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorHoverSupportingColor() {
        return ErrorHoverSupportingColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorHoverTrailingIconColor() {
        return ErrorHoverTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorInputColor() {
        return ErrorInputColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorLabelColor() {
        return ErrorLabelColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorLeadingIconColor() {
        return ErrorLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorSupportingColor() {
        return ErrorSupportingColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getErrorTrailingIconColor() {
        return ErrorTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFocusActiveIndicatorColor() {
        return FocusActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getFocusActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17681getFocusActiveIndicatorHeightD9Ej5fM() {
        return FocusActiveIndicatorHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFocusInputColor() {
        return FocusInputColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFocusLabelColor() {
        return FocusLabelColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFocusLeadingIconColor() {
        return FocusLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFocusSupportingColor() {
        return FocusSupportingColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFocusTrailingIconColor() {
        return FocusTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getHoverActiveIndicatorColor() {
        return HoverActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getHoverActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17682getHoverActiveIndicatorHeightD9Ej5fM() {
        return HoverActiveIndicatorHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getHoverInputColor() {
        return HoverInputColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getHoverLabelColor() {
        return HoverLabelColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getHoverLeadingIconColor() {
        return HoverLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getHoverSupportingColor() {
        return HoverSupportingColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getHoverTrailingIconColor() {
        return HoverTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInputColor() {
        return InputColor;
    }

    @NotNull
    public final TypographyKeyTokens getInputFont() {
        return InputFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInputPlaceholderColor() {
        return InputPlaceholderColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInputPrefixColor() {
        return InputPrefixColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInputSuffixColor() {
        return InputSuffixColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getLabelColor() {
        return LabelColor;
    }

    @NotNull
    public final TypographyKeyTokens getLabelFont() {
        return LabelFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getLeadingIconColor() {
        return LeadingIconColor;
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17683getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getSupportingColor() {
        return SupportingColor;
    }

    @NotNull
    public final TypographyKeyTokens getSupportingFont() {
        return SupportingFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTrailingIconColor() {
        return TrailingIconColor;
    }

    /* JADX INFO: renamed from: getTrailingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17684getTrailingIconSizeD9Ej5fM() {
        return TrailingIconSize;
    }
}
