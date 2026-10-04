package androidx.compose.material3.tokens;

import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bW\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0011\u00105\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0011\u00107\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0011\u00109\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0011\u0010;\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u001c\u0010=\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\b?\u0010@R\u0011\u0010B\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0006R\u0011\u0010H\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0006R\u001c\u0010J\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\bK\u0010@R\u001c\u0010L\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\bM\u0010@R\u0011\u0010N\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0006R\u0011\u0010P\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\bQ\u00102R\u0011\u0010R\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0006R\u0011\u0010T\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0006R\u001c\u0010V\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\bW\u0010@R\u0011\u0010X\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0006R\u0011\u0010Z\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0006R\u001c\u0010\\\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\b]\u0010@R\u0011\u0010^\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\b_\u0010ER\u0011\u0010`\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0006R\u001c\u0010b\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\bc\u0010@R\u000e\u0010d\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u0006R\u000e\u0010g\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010h\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0006R\u000e\u0010j\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010k\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\u0006R\u000e\u0010m\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0006R\u0011\u0010p\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0006R\u0011\u0010r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0006R\u0011\u0010t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0006R\u0011\u0010v\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0006R\u0011\u0010x\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u0006R\u0011\u0010z\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\u0006R\u0011\u0010|\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\u0006R\u0011\u0010~\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u0006R\u0013\u0010\u0080\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0006R\u0013\u0010\u0082\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0006R\u001e\u0010\u0084\u0001\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010A\u001a\u0005\b\u0085\u0001\u0010@R\u0013\u0010\u0086\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0006R\u0013\u0010\u0088\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0006R\u0013\u0010\u008a\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0006R\u001e\u0010\u008c\u0001\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010A\u001a\u0005\b\u008d\u0001\u0010@R\u0013\u0010\u008e\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0006R\u0013\u0010\u0090\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u0006R\u0013\u0010\u0092\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0006R\u001e\u0010\u0094\u0001\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010A\u001a\u0005\b\u0095\u0001\u0010@R\u0013\u0010\u0096\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0006R\u001e\u0010\u0098\u0001\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010A\u001a\u0005\b\u0099\u0001\u0010@\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009a\u0001"}, m13886d2 = {"Landroidx/compose/material3/tokens/FilledAutocompleteTokens;", "", "()V", "FieldDisabledInputTextColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getFieldDisabledInputTextColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "FieldDisabledInputTextOpacity", "", "FieldDisabledLabelTextColor", "getFieldDisabledLabelTextColor", "FieldDisabledLabelTextOpacity", "FieldDisabledSupportingTextColor", "getFieldDisabledSupportingTextColor", "FieldDisabledSupportingTextOpacity", "FieldErrorFocusInputTextColor", "getFieldErrorFocusInputTextColor", "FieldErrorFocusLabelTextColor", "getFieldErrorFocusLabelTextColor", "FieldErrorFocusSupportingTextColor", "getFieldErrorFocusSupportingTextColor", "FieldErrorHoverInputTextColor", "getFieldErrorHoverInputTextColor", "FieldErrorHoverLabelTextColor", "getFieldErrorHoverLabelTextColor", "FieldErrorHoverSupportingTextColor", "getFieldErrorHoverSupportingTextColor", "FieldErrorInputTextColor", "getFieldErrorInputTextColor", "FieldErrorLabelTextColor", "getFieldErrorLabelTextColor", "FieldErrorSupportingTextColor", "getFieldErrorSupportingTextColor", "FieldFocusInputTextColor", "getFieldFocusInputTextColor", "FieldFocusLabelTextColor", "getFieldFocusLabelTextColor", "FieldFocusSupportingTextColor", "getFieldFocusSupportingTextColor", "FieldHoverInputTextColor", "getFieldHoverInputTextColor", "FieldHoverLabelTextColor", "getFieldHoverLabelTextColor", "FieldHoverSupportingTextColor", "getFieldHoverSupportingTextColor", "FieldInputTextColor", "getFieldInputTextColor", "FieldInputTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getFieldInputTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "FieldLabelTextColor", "getFieldLabelTextColor", "FieldLabelTextFont", "getFieldLabelTextFont", "FieldSupportingTextColor", "getFieldSupportingTextColor", "FieldSupportingTextFont", "getFieldSupportingTextFont", "MenuContainerColor", "getMenuContainerColor", "MenuContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getMenuContainerElevation-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "MenuContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getMenuContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "MenuContainerSurfaceTintLayerColor", "getMenuContainerSurfaceTintLayerColor", "MenuDividerColor", "getMenuDividerColor", "MenuDividerHeight", "getMenuDividerHeight-D9Ej5fM", "MenuListItemContainerHeight", "getMenuListItemContainerHeight-D9Ej5fM", "MenuListItemLabelTextColor", "getMenuListItemLabelTextColor", "MenuListItemLabelTextFont", "getMenuListItemLabelTextFont", "MenuListItemSelectedContainerColor", "getMenuListItemSelectedContainerColor", "TextFieldActiveIndicatorColor", "getTextFieldActiveIndicatorColor", "TextFieldActiveIndicatorHeight", "getTextFieldActiveIndicatorHeight-D9Ej5fM", "TextFieldCaretColor", "getTextFieldCaretColor", "TextFieldContainerColor", "getTextFieldContainerColor", "TextFieldContainerHeight", "getTextFieldContainerHeight-D9Ej5fM", "TextFieldContainerShape", "getTextFieldContainerShape", "TextFieldDisabledActiveIndicatorColor", "getTextFieldDisabledActiveIndicatorColor", "TextFieldDisabledActiveIndicatorHeight", "getTextFieldDisabledActiveIndicatorHeight-D9Ej5fM", "TextFieldDisabledActiveIndicatorOpacity", "TextFieldDisabledContainerColor", "getTextFieldDisabledContainerColor", "TextFieldDisabledContainerOpacity", "TextFieldDisabledLeadingIconColor", "getTextFieldDisabledLeadingIconColor", "TextFieldDisabledLeadingIconOpacity", "TextFieldDisabledTrailingIconColor", "getTextFieldDisabledTrailingIconColor", "TextFieldDisabledTrailingIconOpacity", "TextFieldErrorActiveIndicatorColor", "getTextFieldErrorActiveIndicatorColor", "TextFieldErrorFocusActiveIndicatorColor", "getTextFieldErrorFocusActiveIndicatorColor", "TextFieldErrorFocusCaretColor", "getTextFieldErrorFocusCaretColor", "TextFieldErrorFocusLeadingIconColor", "getTextFieldErrorFocusLeadingIconColor", "TextFieldErrorFocusTrailingIconColor", "getTextFieldErrorFocusTrailingIconColor", "TextFieldErrorHoverActiveIndicatorColor", "getTextFieldErrorHoverActiveIndicatorColor", "TextFieldErrorHoverLeadingIconColor", "getTextFieldErrorHoverLeadingIconColor", "TextFieldErrorHoverTrailingIconColor", "getTextFieldErrorHoverTrailingIconColor", "TextFieldErrorLeadingIconColor", "getTextFieldErrorLeadingIconColor", "TextFieldErrorTrailingIconColor", "getTextFieldErrorTrailingIconColor", "TextFieldFocusActiveIndicatorColor", "getTextFieldFocusActiveIndicatorColor", "TextFieldFocusActiveIndicatorHeight", "getTextFieldFocusActiveIndicatorHeight-D9Ej5fM", "TextFieldFocusLeadingIconColor", "getTextFieldFocusLeadingIconColor", "TextFieldFocusTrailingIconColor", "getTextFieldFocusTrailingIconColor", "TextFieldHoverActiveIndicatorColor", "getTextFieldHoverActiveIndicatorColor", "TextFieldHoverActiveIndicatorHeight", "getTextFieldHoverActiveIndicatorHeight-D9Ej5fM", "TextFieldHoverLeadingIconColor", "getTextFieldHoverLeadingIconColor", "TextFieldHoverTrailingIconColor", "getTextFieldHoverTrailingIconColor", "TextFieldLeadingIconColor", "getTextFieldLeadingIconColor", "TextFieldLeadingIconSize", "getTextFieldLeadingIconSize-D9Ej5fM", "TextFieldTrailingIconColor", "getTextFieldTrailingIconColor", "TextFieldTrailingIconSize", "getTextFieldTrailingIconSize-D9Ej5fM", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class FilledAutocompleteTokens {

    @NotNull
    private static final ColorSchemeKeyTokens FieldDisabledInputTextColor;
    public static final float FieldDisabledInputTextOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens FieldDisabledLabelTextColor;
    public static final float FieldDisabledLabelTextOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens FieldDisabledSupportingTextColor;
    public static final float FieldDisabledSupportingTextOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens FieldErrorFocusInputTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldErrorFocusLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldErrorFocusSupportingTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldErrorHoverInputTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldErrorHoverLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldErrorHoverSupportingTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldErrorInputTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldErrorLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldErrorSupportingTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldFocusInputTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldFocusLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldFocusSupportingTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldHoverInputTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldHoverLabelTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldHoverSupportingTextColor;

    @NotNull
    private static final ColorSchemeKeyTokens FieldInputTextColor;

    @NotNull
    private static final TypographyKeyTokens FieldInputTextFont;

    @NotNull
    private static final ColorSchemeKeyTokens FieldLabelTextColor;

    @NotNull
    private static final TypographyKeyTokens FieldLabelTextFont;

    @NotNull
    private static final ColorSchemeKeyTokens FieldSupportingTextColor;

    @NotNull
    private static final TypographyKeyTokens FieldSupportingTextFont;

    @NotNull
    public static final FilledAutocompleteTokens INSTANCE = new FilledAutocompleteTokens();

    @NotNull
    private static final ColorSchemeKeyTokens MenuContainerColor = ColorSchemeKeyTokens.Surface;
    private static final float MenuContainerElevation = ElevationTokens.INSTANCE.m17594getLevel2D9Ej5fM();

    @NotNull
    private static final ShapeKeyTokens MenuContainerShape = ShapeKeyTokens.CornerExtraSmall;

    @NotNull
    private static final ColorSchemeKeyTokens MenuContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;

    @NotNull
    private static final ColorSchemeKeyTokens MenuDividerColor;
    private static final float MenuDividerHeight;
    private static final float MenuListItemContainerHeight;

    @NotNull
    private static final ColorSchemeKeyTokens MenuListItemLabelTextColor;

    @NotNull
    private static final TypographyKeyTokens MenuListItemLabelTextFont;

    @NotNull
    private static final ColorSchemeKeyTokens MenuListItemSelectedContainerColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldActiveIndicatorColor;
    private static final float TextFieldActiveIndicatorHeight;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldCaretColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldContainerColor;
    private static final float TextFieldContainerHeight;

    @NotNull
    private static final ShapeKeyTokens TextFieldContainerShape;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldDisabledActiveIndicatorColor;
    private static final float TextFieldDisabledActiveIndicatorHeight;
    public static final float TextFieldDisabledActiveIndicatorOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldDisabledContainerColor;
    public static final float TextFieldDisabledContainerOpacity = 0.04f;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldDisabledLeadingIconColor;
    public static final float TextFieldDisabledLeadingIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldDisabledTrailingIconColor;
    public static final float TextFieldDisabledTrailingIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorActiveIndicatorColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorFocusActiveIndicatorColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorFocusCaretColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorFocusLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorFocusTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorHoverActiveIndicatorColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorHoverLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorHoverTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldFocusActiveIndicatorColor;
    private static final float TextFieldFocusActiveIndicatorHeight;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldFocusLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldFocusTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldHoverActiveIndicatorColor;
    private static final float TextFieldHoverActiveIndicatorHeight;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldHoverLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldHoverTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldLeadingIconColor;
    private static final float TextFieldLeadingIconSize;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldTrailingIconColor;
    private static final float TextFieldTrailingIconSize;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.SurfaceVariant;
        MenuDividerColor = colorSchemeKeyTokens;
        float f = (float) 1.0d;
        MenuDividerHeight = C2256Dp.m20968constructorimpl(f);
        MenuListItemContainerHeight = C2256Dp.m20968constructorimpl((float) 48.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurface;
        MenuListItemLabelTextColor = colorSchemeKeyTokens2;
        MenuListItemLabelTextFont = TypographyKeyTokens.LabelLarge;
        MenuListItemSelectedContainerColor = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnSurfaceVariant;
        TextFieldActiveIndicatorColor = colorSchemeKeyTokens3;
        TextFieldActiveIndicatorHeight = C2256Dp.m20968constructorimpl(f);
        ColorSchemeKeyTokens colorSchemeKeyTokens4 = ColorSchemeKeyTokens.Primary;
        TextFieldCaretColor = colorSchemeKeyTokens4;
        TextFieldContainerColor = colorSchemeKeyTokens;
        TextFieldContainerHeight = C2256Dp.m20968constructorimpl((float) 56.0d);
        TextFieldContainerShape = ShapeKeyTokens.CornerExtraSmallTop;
        TextFieldDisabledActiveIndicatorColor = colorSchemeKeyTokens2;
        TextFieldDisabledActiveIndicatorHeight = C2256Dp.m20968constructorimpl(f);
        TextFieldDisabledContainerColor = colorSchemeKeyTokens2;
        FieldDisabledInputTextColor = colorSchemeKeyTokens2;
        FieldDisabledLabelTextColor = colorSchemeKeyTokens2;
        TextFieldDisabledLeadingIconColor = colorSchemeKeyTokens2;
        FieldDisabledSupportingTextColor = colorSchemeKeyTokens2;
        TextFieldDisabledTrailingIconColor = colorSchemeKeyTokens2;
        ColorSchemeKeyTokens colorSchemeKeyTokens5 = ColorSchemeKeyTokens.Error;
        TextFieldErrorActiveIndicatorColor = colorSchemeKeyTokens5;
        TextFieldErrorFocusActiveIndicatorColor = colorSchemeKeyTokens5;
        TextFieldErrorFocusCaretColor = colorSchemeKeyTokens5;
        FieldErrorFocusInputTextColor = colorSchemeKeyTokens2;
        FieldErrorFocusLabelTextColor = colorSchemeKeyTokens5;
        TextFieldErrorFocusLeadingIconColor = colorSchemeKeyTokens3;
        FieldErrorFocusSupportingTextColor = colorSchemeKeyTokens5;
        TextFieldErrorFocusTrailingIconColor = colorSchemeKeyTokens5;
        ColorSchemeKeyTokens colorSchemeKeyTokens6 = ColorSchemeKeyTokens.OnErrorContainer;
        TextFieldErrorHoverActiveIndicatorColor = colorSchemeKeyTokens6;
        FieldErrorHoverInputTextColor = colorSchemeKeyTokens2;
        FieldErrorHoverLabelTextColor = colorSchemeKeyTokens6;
        TextFieldErrorHoverLeadingIconColor = colorSchemeKeyTokens3;
        FieldErrorHoverSupportingTextColor = colorSchemeKeyTokens5;
        TextFieldErrorHoverTrailingIconColor = colorSchemeKeyTokens6;
        FieldErrorInputTextColor = colorSchemeKeyTokens2;
        FieldErrorLabelTextColor = colorSchemeKeyTokens5;
        TextFieldErrorLeadingIconColor = colorSchemeKeyTokens3;
        FieldErrorSupportingTextColor = colorSchemeKeyTokens5;
        TextFieldErrorTrailingIconColor = colorSchemeKeyTokens5;
        TextFieldFocusActiveIndicatorColor = colorSchemeKeyTokens4;
        TextFieldFocusActiveIndicatorHeight = C2256Dp.m20968constructorimpl((float) 2.0d);
        FieldFocusInputTextColor = colorSchemeKeyTokens2;
        FieldFocusLabelTextColor = colorSchemeKeyTokens4;
        TextFieldFocusLeadingIconColor = colorSchemeKeyTokens3;
        FieldFocusSupportingTextColor = colorSchemeKeyTokens3;
        TextFieldFocusTrailingIconColor = colorSchemeKeyTokens3;
        TextFieldHoverActiveIndicatorColor = colorSchemeKeyTokens2;
        TextFieldHoverActiveIndicatorHeight = C2256Dp.m20968constructorimpl(f);
        FieldHoverInputTextColor = colorSchemeKeyTokens2;
        FieldHoverLabelTextColor = colorSchemeKeyTokens3;
        TextFieldHoverLeadingIconColor = colorSchemeKeyTokens3;
        FieldHoverSupportingTextColor = colorSchemeKeyTokens3;
        TextFieldHoverTrailingIconColor = colorSchemeKeyTokens3;
        FieldInputTextColor = colorSchemeKeyTokens2;
        TypographyKeyTokens typographyKeyTokens = TypographyKeyTokens.BodyLarge;
        FieldInputTextFont = typographyKeyTokens;
        FieldLabelTextColor = colorSchemeKeyTokens3;
        FieldLabelTextFont = typographyKeyTokens;
        TextFieldLeadingIconColor = colorSchemeKeyTokens3;
        TextFieldLeadingIconSize = C2256Dp.m20968constructorimpl((float) 20.0d);
        FieldSupportingTextColor = colorSchemeKeyTokens3;
        FieldSupportingTextFont = TypographyKeyTokens.BodySmall;
        TextFieldTrailingIconColor = colorSchemeKeyTokens3;
        TextFieldTrailingIconSize = C2256Dp.m20968constructorimpl((float) 24.0d);
    }

    private FilledAutocompleteTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldDisabledInputTextColor() {
        return FieldDisabledInputTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldDisabledLabelTextColor() {
        return FieldDisabledLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldDisabledSupportingTextColor() {
        return FieldDisabledSupportingTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldErrorFocusInputTextColor() {
        return FieldErrorFocusInputTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldErrorFocusLabelTextColor() {
        return FieldErrorFocusLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldErrorFocusSupportingTextColor() {
        return FieldErrorFocusSupportingTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldErrorHoverInputTextColor() {
        return FieldErrorHoverInputTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldErrorHoverLabelTextColor() {
        return FieldErrorHoverLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldErrorHoverSupportingTextColor() {
        return FieldErrorHoverSupportingTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldErrorInputTextColor() {
        return FieldErrorInputTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldErrorLabelTextColor() {
        return FieldErrorLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldErrorSupportingTextColor() {
        return FieldErrorSupportingTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldFocusInputTextColor() {
        return FieldFocusInputTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldFocusLabelTextColor() {
        return FieldFocusLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldFocusSupportingTextColor() {
        return FieldFocusSupportingTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldHoverInputTextColor() {
        return FieldHoverInputTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldHoverLabelTextColor() {
        return FieldHoverLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldHoverSupportingTextColor() {
        return FieldHoverSupportingTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldInputTextColor() {
        return FieldInputTextColor;
    }

    @NotNull
    public final TypographyKeyTokens getFieldInputTextFont() {
        return FieldInputTextFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldLabelTextColor() {
        return FieldLabelTextColor;
    }

    @NotNull
    public final TypographyKeyTokens getFieldLabelTextFont() {
        return FieldLabelTextFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getFieldSupportingTextColor() {
        return FieldSupportingTextColor;
    }

    @NotNull
    public final TypographyKeyTokens getFieldSupportingTextFont() {
        return FieldSupportingTextFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getMenuContainerColor() {
        return MenuContainerColor;
    }

    /* JADX INFO: renamed from: getMenuContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17652getMenuContainerElevationD9Ej5fM() {
        return MenuContainerElevation;
    }

    @NotNull
    public final ShapeKeyTokens getMenuContainerShape() {
        return MenuContainerShape;
    }

    @NotNull
    public final ColorSchemeKeyTokens getMenuContainerSurfaceTintLayerColor() {
        return MenuContainerSurfaceTintLayerColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getMenuDividerColor() {
        return MenuDividerColor;
    }

    /* JADX INFO: renamed from: getMenuDividerHeight-D9Ej5fM, reason: not valid java name */
    public final float m17653getMenuDividerHeightD9Ej5fM() {
        return MenuDividerHeight;
    }

    /* JADX INFO: renamed from: getMenuListItemContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m17654getMenuListItemContainerHeightD9Ej5fM() {
        return MenuListItemContainerHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getMenuListItemLabelTextColor() {
        return MenuListItemLabelTextColor;
    }

    @NotNull
    public final TypographyKeyTokens getMenuListItemLabelTextFont() {
        return MenuListItemLabelTextFont;
    }

    @NotNull
    public final ColorSchemeKeyTokens getMenuListItemSelectedContainerColor() {
        return MenuListItemSelectedContainerColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldActiveIndicatorColor() {
        return TextFieldActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getTextFieldActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17655getTextFieldActiveIndicatorHeightD9Ej5fM() {
        return TextFieldActiveIndicatorHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldCaretColor() {
        return TextFieldCaretColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldContainerColor() {
        return TextFieldContainerColor;
    }

    /* JADX INFO: renamed from: getTextFieldContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m17656getTextFieldContainerHeightD9Ej5fM() {
        return TextFieldContainerHeight;
    }

    @NotNull
    public final ShapeKeyTokens getTextFieldContainerShape() {
        return TextFieldContainerShape;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldDisabledActiveIndicatorColor() {
        return TextFieldDisabledActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getTextFieldDisabledActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17657getTextFieldDisabledActiveIndicatorHeightD9Ej5fM() {
        return TextFieldDisabledActiveIndicatorHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldDisabledContainerColor() {
        return TextFieldDisabledContainerColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldDisabledLeadingIconColor() {
        return TextFieldDisabledLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldDisabledTrailingIconColor() {
        return TextFieldDisabledTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorActiveIndicatorColor() {
        return TextFieldErrorActiveIndicatorColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorFocusActiveIndicatorColor() {
        return TextFieldErrorFocusActiveIndicatorColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorFocusCaretColor() {
        return TextFieldErrorFocusCaretColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorFocusLeadingIconColor() {
        return TextFieldErrorFocusLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorFocusTrailingIconColor() {
        return TextFieldErrorFocusTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorHoverActiveIndicatorColor() {
        return TextFieldErrorHoverActiveIndicatorColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorHoverLeadingIconColor() {
        return TextFieldErrorHoverLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorHoverTrailingIconColor() {
        return TextFieldErrorHoverTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorLeadingIconColor() {
        return TextFieldErrorLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorTrailingIconColor() {
        return TextFieldErrorTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldFocusActiveIndicatorColor() {
        return TextFieldFocusActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getTextFieldFocusActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17658getTextFieldFocusActiveIndicatorHeightD9Ej5fM() {
        return TextFieldFocusActiveIndicatorHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldFocusLeadingIconColor() {
        return TextFieldFocusLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldFocusTrailingIconColor() {
        return TextFieldFocusTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldHoverActiveIndicatorColor() {
        return TextFieldHoverActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getTextFieldHoverActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m17659getTextFieldHoverActiveIndicatorHeightD9Ej5fM() {
        return TextFieldHoverActiveIndicatorHeight;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldHoverLeadingIconColor() {
        return TextFieldHoverLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldHoverTrailingIconColor() {
        return TextFieldHoverTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldLeadingIconColor() {
        return TextFieldLeadingIconColor;
    }

    /* JADX INFO: renamed from: getTextFieldLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17660getTextFieldLeadingIconSizeD9Ej5fM() {
        return TextFieldLeadingIconSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldTrailingIconColor() {
        return TextFieldTrailingIconColor;
    }

    /* JADX INFO: renamed from: getTextFieldTrailingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17661getTextFieldTrailingIconSizeD9Ej5fM() {
        return TextFieldTrailingIconSize;
    }
}
