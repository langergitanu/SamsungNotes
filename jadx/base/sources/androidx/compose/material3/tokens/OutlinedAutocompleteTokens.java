package androidx.compose.material3.tokens;

import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bT\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0011\u00105\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0011\u00107\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0011\u00109\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0011\u0010;\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u001c\u0010=\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\b?\u0010@R\u0011\u0010B\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0006R\u0011\u0010H\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0006R\u001c\u0010J\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\bK\u0010@R\u001c\u0010L\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\bM\u0010@R\u0011\u0010N\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0006R\u0011\u0010P\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\bQ\u00102R\u0011\u0010R\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0006R\u0011\u0010T\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0006R\u0011\u0010V\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0006R\u001c\u0010X\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\bY\u0010@R\u0011\u0010Z\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\b[\u0010ER\u0011\u0010\\\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0006R\u000e\u0010^\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010_\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u0006R\u000e\u0010a\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010b\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010A\u001a\u0004\bc\u0010@R\u0011\u0010d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0006R\u000e\u0010f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010g\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\u0006R\u0011\u0010i\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u0006R\u0011\u0010k\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\u0006R\u0011\u0010m\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010\u0006R\u0011\u0010o\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010\u0006R\u0011\u0010q\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010\u0006R\u0011\u0010s\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\u0006R\u0011\u0010u\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\u0006R\u0011\u0010w\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\u0006R\u0011\u0010y\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\u0006R\u0011\u0010{\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010\u0006R\u0011\u0010}\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u0006R\u001d\u0010\u007f\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010A\u001a\u0005\b\u0080\u0001\u0010@R\u0013\u0010\u0081\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0006R\u0013\u0010\u0083\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0006R\u0013\u0010\u0085\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0006R\u001e\u0010\u0087\u0001\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010A\u001a\u0005\b\u0088\u0001\u0010@R\u0013\u0010\u0089\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u0006R\u0013\u0010\u008b\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u0006R\u001e\u0010\u008d\u0001\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010A\u001a\u0005\b\u008e\u0001\u0010@R\u0013\u0010\u008f\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0006R\u001e\u0010\u0091\u0001\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010A\u001a\u0005\b\u0092\u0001\u0010@R\u0013\u0010\u0093\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0006R\u001e\u0010\u0095\u0001\u001a\u00020>ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000b\n\u0002\u0010A\u001a\u0005\b\u0096\u0001\u0010@\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0097\u0001"}, m13886d2 = {"Landroidx/compose/material3/tokens/OutlinedAutocompleteTokens;", "", "()V", "FieldDisabledInputTextColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getFieldDisabledInputTextColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "FieldDisabledInputTextOpacity", "", "FieldDisabledLabelTextColor", "getFieldDisabledLabelTextColor", "FieldDisabledLabelTextOpacity", "FieldDisabledSupportingTextColor", "getFieldDisabledSupportingTextColor", "FieldDisabledSupportingTextOpacity", "FieldErrorFocusInputTextColor", "getFieldErrorFocusInputTextColor", "FieldErrorFocusLabelTextColor", "getFieldErrorFocusLabelTextColor", "FieldErrorFocusSupportingTextColor", "getFieldErrorFocusSupportingTextColor", "FieldErrorHoverInputTextColor", "getFieldErrorHoverInputTextColor", "FieldErrorHoverLabelTextColor", "getFieldErrorHoverLabelTextColor", "FieldErrorHoverSupportingTextColor", "getFieldErrorHoverSupportingTextColor", "FieldErrorInputTextColor", "getFieldErrorInputTextColor", "FieldErrorLabelTextColor", "getFieldErrorLabelTextColor", "FieldErrorSupportingTextColor", "getFieldErrorSupportingTextColor", "FieldFocusInputTextColor", "getFieldFocusInputTextColor", "FieldFocusLabelTextColor", "getFieldFocusLabelTextColor", "FieldFocusSupportingTextColor", "getFieldFocusSupportingTextColor", "FieldHoverInputTextColor", "getFieldHoverInputTextColor", "FieldHoverLabelTextColor", "getFieldHoverLabelTextColor", "FieldHoverSupportingTextColor", "getFieldHoverSupportingTextColor", "FieldInputTextColor", "getFieldInputTextColor", "FieldInputTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getFieldInputTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "FieldLabelTextColor", "getFieldLabelTextColor", "FieldLabelTextFont", "getFieldLabelTextFont", "FieldSupportingTextColor", "getFieldSupportingTextColor", "FieldSupportingTextFont", "getFieldSupportingTextFont", "MenuContainerColor", "getMenuContainerColor", "MenuContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getMenuContainerElevation-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "MenuContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getMenuContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "MenuContainerSurfaceTintLayerColor", "getMenuContainerSurfaceTintLayerColor", "MenuDividerColor", "getMenuDividerColor", "MenuDividerHeight", "getMenuDividerHeight-D9Ej5fM", "MenuListItemContainerHeight", "getMenuListItemContainerHeight-D9Ej5fM", "MenuListItemLabelTextColor", "getMenuListItemLabelTextColor", "MenuListItemLabelTextFont", "getMenuListItemLabelTextFont", "MenuListItemSelectedContainerColor", "getMenuListItemSelectedContainerColor", "TextFieldCaretColor", "getTextFieldCaretColor", "TextFieldContainerColor", "getTextFieldContainerColor", "TextFieldContainerHeight", "getTextFieldContainerHeight-D9Ej5fM", "TextFieldContainerShape", "getTextFieldContainerShape", "TextFieldDisabledLeadingIconColor", "getTextFieldDisabledLeadingIconColor", "TextFieldDisabledLeadingIconOpacity", "TextFieldDisabledOutlineColor", "getTextFieldDisabledOutlineColor", "TextFieldDisabledOutlineOpacity", "TextFieldDisabledOutlineWidth", "getTextFieldDisabledOutlineWidth-D9Ej5fM", "TextFieldDisabledTrailingIconColor", "getTextFieldDisabledTrailingIconColor", "TextFieldDisabledTrailingIconOpacity", "TextFieldErrorFocusCaretColor", "getTextFieldErrorFocusCaretColor", "TextFieldErrorFocusLeadingIconColor", "getTextFieldErrorFocusLeadingIconColor", "TextFieldErrorFocusOutlineColor", "getTextFieldErrorFocusOutlineColor", "TextFieldErrorFocusTrailingIconColor", "getTextFieldErrorFocusTrailingIconColor", "TextFieldErrorHoverLeadingIconColor", "getTextFieldErrorHoverLeadingIconColor", "TextFieldErrorHoverOutlineColor", "getTextFieldErrorHoverOutlineColor", "TextFieldErrorHoverTrailingIconColor", "getTextFieldErrorHoverTrailingIconColor", "TextFieldErrorLeadingIconColor", "getTextFieldErrorLeadingIconColor", "TextFieldErrorOutlineColor", "getTextFieldErrorOutlineColor", "TextFieldErrorTrailingIconColor", "getTextFieldErrorTrailingIconColor", "TextFieldFocusLeadingIconColor", "getTextFieldFocusLeadingIconColor", "TextFieldFocusOutlineColor", "getTextFieldFocusOutlineColor", "TextFieldFocusOutlineWidth", "getTextFieldFocusOutlineWidth-D9Ej5fM", "TextFieldFocusTrailingIconColor", "getTextFieldFocusTrailingIconColor", "TextFieldHoverLeadingIconColor", "getTextFieldHoverLeadingIconColor", "TextFieldHoverOutlineColor", "getTextFieldHoverOutlineColor", "TextFieldHoverOutlineWidth", "getTextFieldHoverOutlineWidth-D9Ej5fM", "TextFieldHoverTrailingIconColor", "getTextFieldHoverTrailingIconColor", "TextFieldLeadingIconColor", "getTextFieldLeadingIconColor", "TextFieldLeadingIconSize", "getTextFieldLeadingIconSize-D9Ej5fM", "TextFieldOutlineColor", "getTextFieldOutlineColor", "TextFieldOutlineWidth", "getTextFieldOutlineWidth-D9Ej5fM", "TextFieldTrailingIconColor", "getTextFieldTrailingIconColor", "TextFieldTrailingIconSize", "getTextFieldTrailingIconSize-D9Ej5fM", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class OutlinedAutocompleteTokens {

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
    public static final OutlinedAutocompleteTokens INSTANCE = new OutlinedAutocompleteTokens();

    @NotNull
    private static final ColorSchemeKeyTokens MenuContainerColor = ColorSchemeKeyTokens.Surface;
    private static final float MenuContainerElevation = ElevationTokens.INSTANCE.m17594getLevel2D9Ej5fM();

    @NotNull
    private static final ShapeKeyTokens MenuContainerShape;

    @NotNull
    private static final ColorSchemeKeyTokens MenuContainerSurfaceTintLayerColor;

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
    private static final ColorSchemeKeyTokens TextFieldCaretColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldContainerColor;
    private static final float TextFieldContainerHeight;

    @NotNull
    private static final ShapeKeyTokens TextFieldContainerShape;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldDisabledLeadingIconColor;
    public static final float TextFieldDisabledLeadingIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldDisabledOutlineColor;
    public static final float TextFieldDisabledOutlineOpacity = 0.12f;
    private static final float TextFieldDisabledOutlineWidth;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldDisabledTrailingIconColor;
    public static final float TextFieldDisabledTrailingIconOpacity = 0.38f;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorFocusCaretColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorFocusLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorFocusOutlineColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorFocusTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorHoverLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorHoverOutlineColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorHoverTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorOutlineColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldErrorTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldFocusLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldFocusOutlineColor;
    private static final float TextFieldFocusOutlineWidth;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldFocusTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldHoverLeadingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldHoverOutlineColor;
    private static final float TextFieldHoverOutlineWidth;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldHoverTrailingIconColor;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldLeadingIconColor;
    private static final float TextFieldLeadingIconSize;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldOutlineColor;
    private static final float TextFieldOutlineWidth;

    @NotNull
    private static final ColorSchemeKeyTokens TextFieldTrailingIconColor;
    private static final float TextFieldTrailingIconSize;

    static {
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerExtraSmall;
        MenuContainerShape = shapeKeyTokens;
        MenuContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.SurfaceVariant;
        MenuDividerColor = colorSchemeKeyTokens;
        float f = (float) 1.0d;
        MenuDividerHeight = C2256Dp.m20968constructorimpl(f);
        MenuListItemContainerHeight = C2256Dp.m20968constructorimpl((float) 48.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurface;
        MenuListItemLabelTextColor = colorSchemeKeyTokens2;
        MenuListItemLabelTextFont = TypographyKeyTokens.LabelLarge;
        MenuListItemSelectedContainerColor = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.Primary;
        TextFieldCaretColor = colorSchemeKeyTokens3;
        TextFieldContainerColor = colorSchemeKeyTokens;
        TextFieldContainerHeight = C2256Dp.m20968constructorimpl((float) 56.0d);
        TextFieldContainerShape = shapeKeyTokens;
        FieldDisabledInputTextColor = colorSchemeKeyTokens2;
        FieldDisabledLabelTextColor = colorSchemeKeyTokens2;
        TextFieldDisabledLeadingIconColor = colorSchemeKeyTokens2;
        TextFieldDisabledOutlineColor = colorSchemeKeyTokens2;
        TextFieldDisabledOutlineWidth = C2256Dp.m20968constructorimpl(f);
        FieldDisabledSupportingTextColor = colorSchemeKeyTokens2;
        TextFieldDisabledTrailingIconColor = colorSchemeKeyTokens2;
        ColorSchemeKeyTokens colorSchemeKeyTokens4 = ColorSchemeKeyTokens.Error;
        TextFieldErrorFocusCaretColor = colorSchemeKeyTokens4;
        FieldErrorFocusInputTextColor = colorSchemeKeyTokens2;
        FieldErrorFocusLabelTextColor = colorSchemeKeyTokens4;
        ColorSchemeKeyTokens colorSchemeKeyTokens5 = ColorSchemeKeyTokens.OnSurfaceVariant;
        TextFieldErrorFocusLeadingIconColor = colorSchemeKeyTokens5;
        TextFieldErrorFocusOutlineColor = colorSchemeKeyTokens4;
        FieldErrorFocusSupportingTextColor = colorSchemeKeyTokens4;
        TextFieldErrorFocusTrailingIconColor = colorSchemeKeyTokens4;
        FieldErrorHoverInputTextColor = colorSchemeKeyTokens2;
        ColorSchemeKeyTokens colorSchemeKeyTokens6 = ColorSchemeKeyTokens.OnErrorContainer;
        FieldErrorHoverLabelTextColor = colorSchemeKeyTokens6;
        TextFieldErrorHoverLeadingIconColor = colorSchemeKeyTokens5;
        TextFieldErrorHoverOutlineColor = colorSchemeKeyTokens6;
        FieldErrorHoverSupportingTextColor = colorSchemeKeyTokens4;
        TextFieldErrorHoverTrailingIconColor = colorSchemeKeyTokens6;
        FieldErrorInputTextColor = colorSchemeKeyTokens2;
        FieldErrorLabelTextColor = colorSchemeKeyTokens4;
        TextFieldErrorLeadingIconColor = colorSchemeKeyTokens5;
        TextFieldErrorOutlineColor = colorSchemeKeyTokens4;
        FieldErrorSupportingTextColor = colorSchemeKeyTokens4;
        TextFieldErrorTrailingIconColor = colorSchemeKeyTokens4;
        FieldFocusInputTextColor = colorSchemeKeyTokens2;
        FieldFocusLabelTextColor = colorSchemeKeyTokens3;
        TextFieldFocusLeadingIconColor = colorSchemeKeyTokens5;
        TextFieldFocusOutlineColor = colorSchemeKeyTokens3;
        TextFieldFocusOutlineWidth = C2256Dp.m20968constructorimpl((float) 2.0d);
        FieldFocusSupportingTextColor = colorSchemeKeyTokens5;
        TextFieldFocusTrailingIconColor = colorSchemeKeyTokens5;
        FieldHoverInputTextColor = colorSchemeKeyTokens2;
        FieldHoverLabelTextColor = colorSchemeKeyTokens5;
        TextFieldHoverLeadingIconColor = colorSchemeKeyTokens5;
        TextFieldHoverOutlineColor = colorSchemeKeyTokens2;
        TextFieldHoverOutlineWidth = C2256Dp.m20968constructorimpl(f);
        FieldHoverSupportingTextColor = colorSchemeKeyTokens5;
        TextFieldHoverTrailingIconColor = colorSchemeKeyTokens5;
        FieldInputTextColor = colorSchemeKeyTokens2;
        TypographyKeyTokens typographyKeyTokens = TypographyKeyTokens.BodyLarge;
        FieldInputTextFont = typographyKeyTokens;
        FieldLabelTextColor = colorSchemeKeyTokens5;
        FieldLabelTextFont = typographyKeyTokens;
        TextFieldLeadingIconColor = colorSchemeKeyTokens5;
        float f4 = (float) 24.0d;
        TextFieldLeadingIconSize = C2256Dp.m20968constructorimpl(f4);
        TextFieldOutlineColor = ColorSchemeKeyTokens.Outline;
        TextFieldOutlineWidth = C2256Dp.m20968constructorimpl(f);
        FieldSupportingTextColor = colorSchemeKeyTokens5;
        FieldSupportingTextFont = TypographyKeyTokens.BodySmall;
        TextFieldTrailingIconColor = colorSchemeKeyTokens5;
        TextFieldTrailingIconSize = C2256Dp.m20968constructorimpl(f4);
    }

    private OutlinedAutocompleteTokens() {
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
    public final float m17756getMenuContainerElevationD9Ej5fM() {
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
    public final float m17757getMenuDividerHeightD9Ej5fM() {
        return MenuDividerHeight;
    }

    /* JADX INFO: renamed from: getMenuListItemContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m17758getMenuListItemContainerHeightD9Ej5fM() {
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
    public final ColorSchemeKeyTokens getTextFieldCaretColor() {
        return TextFieldCaretColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldContainerColor() {
        return TextFieldContainerColor;
    }

    /* JADX INFO: renamed from: getTextFieldContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m17759getTextFieldContainerHeightD9Ej5fM() {
        return TextFieldContainerHeight;
    }

    @NotNull
    public final ShapeKeyTokens getTextFieldContainerShape() {
        return TextFieldContainerShape;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldDisabledLeadingIconColor() {
        return TextFieldDisabledLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldDisabledOutlineColor() {
        return TextFieldDisabledOutlineColor;
    }

    /* JADX INFO: renamed from: getTextFieldDisabledOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m17760getTextFieldDisabledOutlineWidthD9Ej5fM() {
        return TextFieldDisabledOutlineWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldDisabledTrailingIconColor() {
        return TextFieldDisabledTrailingIconColor;
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
    public final ColorSchemeKeyTokens getTextFieldErrorFocusOutlineColor() {
        return TextFieldErrorFocusOutlineColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorFocusTrailingIconColor() {
        return TextFieldErrorFocusTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorHoverLeadingIconColor() {
        return TextFieldErrorHoverLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorHoverOutlineColor() {
        return TextFieldErrorHoverOutlineColor;
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
    public final ColorSchemeKeyTokens getTextFieldErrorOutlineColor() {
        return TextFieldErrorOutlineColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldErrorTrailingIconColor() {
        return TextFieldErrorTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldFocusLeadingIconColor() {
        return TextFieldFocusLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldFocusOutlineColor() {
        return TextFieldFocusOutlineColor;
    }

    /* JADX INFO: renamed from: getTextFieldFocusOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m17761getTextFieldFocusOutlineWidthD9Ej5fM() {
        return TextFieldFocusOutlineWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldFocusTrailingIconColor() {
        return TextFieldFocusTrailingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldHoverLeadingIconColor() {
        return TextFieldHoverLeadingIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldHoverOutlineColor() {
        return TextFieldHoverOutlineColor;
    }

    /* JADX INFO: renamed from: getTextFieldHoverOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m17762getTextFieldHoverOutlineWidthD9Ej5fM() {
        return TextFieldHoverOutlineWidth;
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
    public final float m17763getTextFieldLeadingIconSizeD9Ej5fM() {
        return TextFieldLeadingIconSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldOutlineColor() {
        return TextFieldOutlineColor;
    }

    /* JADX INFO: renamed from: getTextFieldOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m17764getTextFieldOutlineWidthD9Ej5fM() {
        return TextFieldOutlineWidth;
    }

    @NotNull
    public final ColorSchemeKeyTokens getTextFieldTrailingIconColor() {
        return TextFieldTrailingIconColor;
    }

    /* JADX INFO: renamed from: getTextFieldTrailingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17765getTextFieldTrailingIconSizeD9Ej5fM() {
        return TextFieldTrailingIconSize;
    }
}
