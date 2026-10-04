package androidx.compose.material;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.platform.InspectableValueKt;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.text.input.VisualTransformation;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JS\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%J×\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+H\u0007¢\u0006\u0002\u00106JÂ\u0001\u00107\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00108Jç\u0001\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ=\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010XJç\u0001\u0010Y\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010Z\u001a\u00020;2\b\b\u0002\u0010[\u001a\u00020;2\b\b\u0002\u0010\\\u001a\u00020;2\b\b\u0002\u0010]\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010QJ=\u0010_\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010XJ=\u0010a\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010XJM\u0010c\u001a\u00020d*\u00020d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010e\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, m13886d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "IconOpacity", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedTextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getOutlinedTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "TextFieldShape", "getTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "BorderBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", VMetaDataKey.META_KEY_SHAPE, "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", OutlinedTextFieldKt.BorderId, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TextFieldDefaults {
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;

    @NotNull
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = C2256Dp.m20968constructorimpl(56);
    private static final float MinWidth = C2256Dp.m20968constructorimpl(280);
    private static final float UnfocusedBorderThickness = C2256Dp.m20968constructorimpl(1);
    private static final float FocusedBorderThickness = C2256Dp.m20968constructorimpl(2);

    private TextFieldDefaults() {
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m16912indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f4, int i, Object obj) {
        if ((i & 16) != 0) {
            f = FocusedBorderThickness;
        }
        return textFieldDefaults.m16921indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f, (i & 32) != 0 ? UnfocusedBorderThickness : f4);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m16913outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f5 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f6 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m16923outlinedTextFieldPaddinga9UjIt4(f, f4, f5, f6);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m16914textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f5 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f6 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m16925textFieldWithLabelPaddinga9UjIt4(f, f4, f5, f6);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m16915textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f5 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f6 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m16926textFieldWithoutLabelPaddinga9UjIt4(f, f4, f5, f6);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m16916BorderBoxnbWgWpA(final boolean z, final boolean z2, @NotNull final InteractionSource interactionSource, @NotNull final TextFieldColors colors, @Nullable Shape shape, float f, float f4, @Nullable Composer composer, final int i, final int i2) {
        boolean z3;
        int i4;
        Shape shape2;
        float f5;
        float f6;
        Shape outlinedTextFieldShape;
        float f7;
        int i5;
        float f8;
        float f9;
        Composer composer2;
        final float f10;
        final float f11;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(943754022);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            z3 = z;
        } else if ((i & 14) == 0) {
            z3 = z;
            i4 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                i4 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                i4 |= composerStartRestartGroup.changed(interactionSource) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                i4 |= composerStartRestartGroup.changed(colors) ? 2048 : 1024;
            }
            if ((i & 57344) != 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    int i7 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                    i4 |= i7;
                } else {
                    shape2 = shape;
                }
                i4 |= i7;
            } else {
                shape2 = shape;
            }
            if ((i & 458752) != 0) {
                if ((i2 & 32) == 0) {
                    f5 = f;
                    int i8 = composerStartRestartGroup.changed(f5) ? 131072 : 65536;
                    i4 |= i8;
                } else {
                    f5 = f;
                }
                i4 |= i8;
            } else {
                f5 = f;
            }
            if ((3670016 & i) != 0) {
                if ((i2 & 64) == 0) {
                    f6 = f4;
                    int i9 = composerStartRestartGroup.changed(f6) ? 1048576 : 524288;
                    i4 |= i9;
                } else {
                    f6 = f4;
                }
                i4 |= i9;
            } else {
                f6 = f4;
            }
            if ((i2 & 128) != 0) {
                i6 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(this) ? 8388608 : 4194304 : 12582912;
                if ((23967451 & i4) == 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                    f11 = f5;
                    f10 = f6;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if ((i2 & 16) == 0) {
                            outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i4 >> 21) & 14);
                            i4 &= -57345;
                        } else {
                            outlinedTextFieldShape = shape2;
                        }
                        if ((i2 & 32) == 0) {
                            f7 = FocusedBorderThickness;
                            i4 &= -458753;
                        } else {
                            f7 = f5;
                        }
                        if ((i2 & 64) == 0) {
                            Shape shape3 = outlinedTextFieldShape;
                            i5 = i4 & (-3670017);
                            f8 = f7;
                            shape2 = shape3;
                            f9 = UnfocusedBorderThickness;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(943754022, i5, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:308)");
                            }
                            int i10 = i5 & 8190;
                            int i11 = i5 >> 3;
                            BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) TextFieldDefaultsKt.m16928animateBorderStrokeAsStateNuRrP5Q(z3, z2, interactionSource, colors, f8, f9, composerStartRestartGroup, (i11 & 458752) | i10 | (i11 & 57344)).getValue(), shape2), composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = composerStartRestartGroup;
                            f10 = f9;
                            f11 = f8;
                        } else {
                            Shape shape4 = outlinedTextFieldShape;
                            i5 = i4;
                            f8 = f7;
                            shape2 = shape4;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i4 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i4 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i4 &= -3670017;
                        }
                        i5 = i4;
                        f8 = f5;
                    }
                    f9 = f6;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i102 = i5 & 8190;
                    int i112 = i5 >> 3;
                    BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) TextFieldDefaultsKt.m16928animateBorderStrokeAsStateNuRrP5Q(z3, z2, interactionSource, colors, f8, f9, composerStartRestartGroup, (i112 & 458752) | i102 | (i112 & 57344)).getValue(), shape2), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = composerStartRestartGroup;
                    f10 = f9;
                    f11 = f8;
                }
                final Shape shape5 = shape2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$BorderBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer3, int i12) {
                        this.$tmp0_rcvr.m16916BorderBoxnbWgWpA(z, z2, interactionSource, colors, shape5, f11, f10, composer3, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= i6;
            if ((23967451 & i4) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if ((i2 & 16) == 0) {
                    }
                    if ((i2 & 32) == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                }
            }
            final Shape shape52 = shape2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i & 57344) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        if ((3670016 & i) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        i4 |= i6;
        if ((23967451 & i4) == 4793490) {
        }
        final Shape shape522 = shape2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x039c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0142  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OutlinedTextFieldDecorationBox(@NotNull final String value, @NotNull final Function2<? super Composer, ? super Integer, Unit> innerTextField, final boolean z, final boolean z2, @NotNull final VisualTransformation visualTransformation, @NotNull final InteractionSource interactionSource, boolean z3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable TextFieldColors textFieldColors, @Nullable PaddingValues paddingValues, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        int i6;
        boolean z4;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        TextFieldColors textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs;
        int i17;
        PaddingValues paddingValuesM16913outlinedTextFieldPaddinga9UjIt4$default;
        boolean z5;
        int i18;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function2ComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function28;
        final TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final boolean z6;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final PaddingValues paddingValues3;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i20;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1280721485);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(innerTextField) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else {
            if ((i & 896) == 0) {
                i5 |= composerStartRestartGroup.changed(z) ? 256 : 128;
            }
            if ((i4 & 8) == 0) {
                i5 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i4 & 16) != 0) {
                    i5 |= 24576;
                } else if ((i & 57344) == 0) {
                    i5 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                }
                if ((i4 & 32) == 0) {
                    i20 = (i & 458752) == 0 ? composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536 : 196608;
                    i6 = i4 & 64;
                    if (i6 == 0) {
                        i5 |= 1572864;
                        z4 = z3;
                    } else {
                        z4 = z3;
                        if ((i & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
                        }
                    }
                    i7 = i4 & 128;
                    if (i7 == 0) {
                        i5 |= 12582912;
                        function26 = function2;
                    } else {
                        function26 = function2;
                        if ((i & 29360128) == 0) {
                            i5 |= composerStartRestartGroup.changed(function26) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i4 & 256;
                    if (i8 == 0) {
                        i5 |= 100663296;
                        function27 = function22;
                    } else {
                        function27 = function22;
                        if ((i & 234881024) == 0) {
                            i5 |= composerStartRestartGroup.changed(function27) ? 67108864 : 33554432;
                        }
                    }
                    i9 = i4 & 512;
                    if (i9 == 0) {
                        i10 = i9;
                        i11 = i5 | DriveFile.MODE_READ_WRITE;
                    } else {
                        if ((i & 1879048192) == 0) {
                            i10 = i9;
                            i5 |= composerStartRestartGroup.changed(function23) ? 536870912 : 268435456;
                        } else {
                            i10 = i9;
                        }
                        i11 = i5;
                    }
                    i12 = i4 & 1024;
                    if (i12 == 0) {
                        i13 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        i13 = i2 | (composerStartRestartGroup.changed(function24) ? 4 : 2);
                    } else {
                        i13 = i2;
                    }
                    if ((i2 & 112) == 0) {
                        i13 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 32 : 16;
                    }
                    if ((i2 & 896) == 0) {
                        i13 |= ((i4 & 4096) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 256 : 128;
                    }
                    int i21 = i13;
                    i14 = i4 & 8192;
                    if (i14 == 0) {
                        i15 = i21 | 3072;
                    } else {
                        int i22 = i21;
                        if ((i2 & 7168) == 0) {
                            i22 |= composerStartRestartGroup.changed(function25) ? 2048 : 1024;
                        }
                        i15 = i22;
                    }
                    if ((i4 & 16384) != 0) {
                        if ((i2 & 57344) == 0) {
                            i15 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                        }
                        int i23 = i15;
                        if ((i11 & 1533916891) == 306783378 && (i23 & 46811) == 9362 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function213 = function23;
                            function216 = function24;
                            paddingValues3 = paddingValues;
                            z6 = z4;
                            function212 = function26;
                            composer2 = composerStartRestartGroup;
                            textFieldColors2 = textFieldColors;
                            function215 = function25;
                            function214 = function27;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                boolean z7 = i6 == 0 ? false : z4;
                                Function2<? super Composer, ? super Integer, Unit> function217 = i7 == 0 ? null : function26;
                                if (i8 != 0) {
                                    function27 = null;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function218 = i10 == 0 ? null : function23;
                                Function2<? super Composer, ? super Integer, Unit> function219 = i12 == 0 ? function24 : null;
                                if ((i4 & 2048) == 0) {
                                    i16 = i14;
                                    textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs = m16922outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i23 >> 9) & 112, 2097151);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    i17 = i23 & LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                } else {
                                    i16 = i14;
                                    textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                    i17 = i23;
                                }
                                if ((i4 & 4096) == 0) {
                                    paddingValuesM16913outlinedTextFieldPaddinga9UjIt4$default = m16913outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i17 &= -897;
                                } else {
                                    paddingValuesM16913outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i16 == 0) {
                                    final boolean z8 = z7;
                                    final int i24 = i17;
                                    final TextFieldColors textFieldColors3 = textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs;
                                    final int i25 = i11;
                                    z5 = z8;
                                    i19 = i25;
                                    i18 = i24;
                                    function28 = function27;
                                    textFieldColors2 = textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs;
                                    paddingValues2 = paddingValuesM16913outlinedTextFieldPaddinga9UjIt4$default;
                                    function2ComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer3, int i26) {
                                            if ((i26 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1261916269, i26, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:647)");
                                            }
                                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                            boolean z9 = z;
                                            boolean z10 = z8;
                                            InteractionSource interactionSource2 = interactionSource;
                                            TextFieldColors textFieldColors4 = textFieldColors3;
                                            int i27 = i25;
                                            textFieldDefaults.m16916BorderBoxnbWgWpA(z9, z10, interactionSource2, textFieldColors4, null, 0.0f, 0.0f, composer3, ((i27 >> 9) & 896) | ((i27 >> 6) & 14) | 12582912 | ((i27 >> 15) & 112) | ((i24 << 6) & 7168), 112);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                } else {
                                    z5 = z7;
                                    i18 = i17;
                                    i19 = i11;
                                    function2ComposableLambda = function25;
                                    function28 = function27;
                                    textFieldColors2 = textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs;
                                    paddingValues2 = paddingValuesM16913outlinedTextFieldPaddinga9UjIt4$default;
                                }
                                function29 = function217;
                                function210 = function218;
                                z4 = z5;
                                function211 = function219;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i18 = (i4 & 2048) != 0 ? i23 & LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR : i23;
                                if ((i4 & 4096) != 0) {
                                    i18 &= -897;
                                }
                                function211 = function24;
                                paddingValues2 = paddingValues;
                                function2ComposableLambda = function25;
                                function28 = function27;
                                function29 = function26;
                                i19 = i11;
                                function210 = function23;
                                textFieldColors2 = textFieldColors;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i19, i18, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:633)");
                            }
                            int i26 = i19 << 3;
                            int i27 = i19 >> 9;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, function29, function28, function210, function211, z2, z, z4, interactionSource, paddingValues2, textFieldColors2, function2ComposableLambda, composerStartRestartGroup, (i26 & 896) | (i26 & 112) | 6 | ((i19 >> 3) & 7168) | (i27 & 57344) | (i27 & 458752) | (i27 & 3670016) | ((i18 << 21) & 29360128) | ((i19 << 15) & 234881024) | ((i19 << 21) & 1879048192), ((i19 >> 12) & 112) | ((i19 >> 18) & 14) | (i18 & 896) | ((i18 << 6) & 7168) | ((i18 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function212 = function29;
                            function213 = function210;
                            z6 = z4;
                            composer2 = composerStartRestartGroup;
                            function214 = function28;
                            function215 = function2ComposableLambda;
                            paddingValues3 = paddingValues2;
                            function216 = function211;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer3, int i28) {
                                TextFieldDefaults.this.OutlinedTextFieldDecorationBox(value, innerTextField, z, z2, visualTransformation, interactionSource, z6, function212, function214, function213, function216, textFieldColors2, paddingValues3, function215, composer3, i | 1, i2, i4);
                            }
                        });
                        return;
                    }
                    i15 |= 24576;
                    int i232 = i15;
                    if ((i11 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i10 == 0) {
                            }
                            if (i12 == 0) {
                            }
                            if ((i4 & 2048) == 0) {
                            }
                            if ((i4 & 4096) == 0) {
                            }
                            if (i16 == 0) {
                            }
                            function29 = function217;
                            function210 = function218;
                            z4 = z5;
                            function211 = function219;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i262 = i19 << 3;
                            int i272 = i19 >> 9;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, function29, function28, function210, function211, z2, z, z4, interactionSource, paddingValues2, textFieldColors2, function2ComposableLambda, composerStartRestartGroup, (i262 & 896) | (i262 & 112) | 6 | ((i19 >> 3) & 7168) | (i272 & 57344) | (i272 & 458752) | (i272 & 3670016) | ((i18 << 21) & 29360128) | ((i19 << 15) & 234881024) | ((i19 << 21) & 1879048192), ((i19 >> 12) & 112) | ((i19 >> 18) & 14) | (i18 & 896) | ((i18 << 6) & 7168) | ((i18 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function212 = function29;
                            function213 = function210;
                            z6 = z4;
                            composer2 = composerStartRestartGroup;
                            function214 = function28;
                            function215 = function2ComposableLambda;
                            paddingValues3 = paddingValues2;
                            function216 = function211;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i5 |= i20;
                i6 = i4 & 64;
                if (i6 == 0) {
                }
                i7 = i4 & 128;
                if (i7 == 0) {
                }
                i8 = i4 & 256;
                if (i8 == 0) {
                }
                i9 = i4 & 512;
                if (i9 == 0) {
                }
                i12 = i4 & 1024;
                if (i12 == 0) {
                }
                if ((i2 & 112) == 0) {
                }
                if ((i2 & 896) == 0) {
                }
                int i212 = i13;
                i14 = i4 & 8192;
                if (i14 == 0) {
                }
                if ((i4 & 16384) != 0) {
                }
                int i2322 = i15;
                if ((i11 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            if ((i4 & 16) != 0) {
            }
            if ((i4 & 32) == 0) {
            }
            i5 |= i20;
            i6 = i4 & 64;
            if (i6 == 0) {
            }
            i7 = i4 & 128;
            if (i7 == 0) {
            }
            i8 = i4 & 256;
            if (i8 == 0) {
            }
            i9 = i4 & 512;
            if (i9 == 0) {
            }
            i12 = i4 & 1024;
            if (i12 == 0) {
            }
            if ((i2 & 112) == 0) {
            }
            if ((i2 & 896) == 0) {
            }
            int i2122 = i13;
            i14 = i4 & 8192;
            if (i14 == 0) {
            }
            if ((i4 & 16384) != 0) {
            }
            int i23222 = i15;
            if ((i11 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i4 & 8) == 0) {
        }
        if ((i4 & 16) != 0) {
        }
        if ((i4 & 32) == 0) {
        }
        i5 |= i20;
        i6 = i4 & 64;
        if (i6 == 0) {
        }
        i7 = i4 & 128;
        if (i7 == 0) {
        }
        i8 = i4 & 256;
        if (i8 == 0) {
        }
        i9 = i4 & 512;
        if (i9 == 0) {
        }
        i12 = i4 & 1024;
        if (i12 == 0) {
        }
        if ((i2 & 112) == 0) {
        }
        if ((i2 & 896) == 0) {
        }
        int i21222 = i13;
        i14 = i4 & 8192;
        if (i14 == 0) {
        }
        if ((i4 & 16384) != 0) {
        }
        int i232222 = i15;
        if ((i11 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0357 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013c  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void TextFieldDecorationBox(@NotNull final String value, @NotNull final Function2<? super Composer, ? super Integer, Unit> innerTextField, final boolean z, final boolean z2, @NotNull final VisualTransformation visualTransformation, @NotNull final InteractionSource interactionSource, boolean z3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable TextFieldColors textFieldColors, @Nullable PaddingValues paddingValues, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        int i6;
        boolean z4;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Composer composer2;
        TextFieldColors textFieldColorsM16924textFieldColorsdx8h9Zs;
        int i15;
        PaddingValues paddingValuesM16915textFieldWithoutLabelPaddinga9UjIt4$default;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        final TextFieldColors textFieldColors2;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final boolean z5;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i16;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(1171040065);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(innerTextField) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else {
            if ((i & 896) == 0) {
                i5 |= composerStartRestartGroup.changed(z) ? 256 : 128;
            }
            if ((i4 & 8) == 0) {
                i5 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i4 & 16) != 0) {
                    i5 |= 24576;
                } else if ((i & 57344) == 0) {
                    i5 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                }
                if ((i4 & 32) == 0) {
                    i16 = (i & 458752) == 0 ? composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536 : 196608;
                    i6 = i4 & 64;
                    if (i6 == 0) {
                        i5 |= 1572864;
                        z4 = z3;
                    } else {
                        z4 = z3;
                        if ((i & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
                        }
                    }
                    i7 = i4 & 128;
                    if (i7 == 0) {
                        i5 |= 12582912;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i & 29360128) == 0) {
                            i5 |= composerStartRestartGroup.changed(function25) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i4 & 256;
                    if (i8 == 0) {
                        i5 |= 100663296;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i & 234881024) == 0) {
                            i5 |= composerStartRestartGroup.changed(function26) ? 67108864 : 33554432;
                        }
                    }
                    i9 = i4 & 512;
                    if (i9 == 0) {
                        i5 |= DriveFile.MODE_READ_WRITE;
                    } else {
                        if ((i & 1879048192) == 0) {
                            i10 = i9;
                            i5 |= composerStartRestartGroup.changed(function23) ? 536870912 : 268435456;
                        }
                        i11 = i4 & 1024;
                        if (i11 != 0) {
                            i13 = i2 | 6;
                            i12 = i11;
                        } else if ((i2 & 14) == 0) {
                            i12 = i11;
                            i13 = i2 | (composerStartRestartGroup.changed(function24) ? 4 : 2);
                        } else {
                            i12 = i11;
                            i13 = i2;
                        }
                        if ((i2 & 112) == 0) {
                            i13 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 32 : 16;
                        }
                        if ((i2 & 896) == 0) {
                            i13 |= ((i4 & 4096) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 256 : 128;
                        }
                        int i17 = i13;
                        if ((i4 & 8192) == 0) {
                            if ((i2 & 7168) == 0) {
                                i17 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
                            }
                            if ((i5 & 1533916891) != 306783378 && (i17 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                function212 = function23;
                                function214 = function24;
                                paddingValues2 = paddingValues;
                                z5 = z4;
                                function211 = function25;
                                composer2 = composerStartRestartGroup;
                                textFieldColors2 = textFieldColors;
                                function213 = function26;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    boolean z6 = i6 == 0 ? false : z4;
                                    Function2<? super Composer, ? super Integer, Unit> function215 = i7 == 0 ? null : function25;
                                    if (i8 != 0) {
                                        function26 = null;
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function216 = i10 == 0 ? null : function23;
                                    Function2<? super Composer, ? super Integer, Unit> function217 = i12 == 0 ? function24 : null;
                                    if ((i4 & 2048) == 0) {
                                        int i18 = (i17 >> 6) & 112;
                                        composer2 = composerStartRestartGroup;
                                        int i19 = i17;
                                        i14 = i5;
                                        textFieldColorsM16924textFieldColorsdx8h9Zs = m16924textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 0, i18, 2097151);
                                        i15 = i19 & LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    } else {
                                        int i20 = i17;
                                        i14 = i5;
                                        composer2 = composerStartRestartGroup;
                                        textFieldColorsM16924textFieldColorsdx8h9Zs = textFieldColors;
                                        i15 = i20;
                                    }
                                    if ((i4 & 4096) == 0) {
                                        i15 &= -897;
                                        function27 = function217;
                                        function28 = function26;
                                        textFieldColors2 = textFieldColorsM16924textFieldColorsdx8h9Zs;
                                        paddingValuesM16915textFieldWithoutLabelPaddinga9UjIt4$default = function215 == null ? m16915textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : m16914textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        function29 = function215;
                                        function210 = function216;
                                        z4 = z6;
                                    } else {
                                        paddingValuesM16915textFieldWithoutLabelPaddinga9UjIt4$default = paddingValues;
                                        z4 = z6;
                                        function27 = function217;
                                        function28 = function26;
                                        textFieldColors2 = textFieldColorsM16924textFieldColorsdx8h9Zs;
                                        function29 = function215;
                                        function210 = function216;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 2048) != 0) {
                                        i17 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    }
                                    if ((i4 & 4096) != 0) {
                                        i17 &= -897;
                                    }
                                    int i21 = i5;
                                    i15 = i17;
                                    i14 = i21;
                                    function27 = function24;
                                    paddingValuesM16915textFieldWithoutLabelPaddinga9UjIt4$default = paddingValues;
                                    function28 = function26;
                                    function29 = function25;
                                    composer2 = composerStartRestartGroup;
                                    function210 = function23;
                                    textFieldColors2 = textFieldColors;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1171040065, i14, i15, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:541)");
                                }
                                int i22 = i14;
                                int i23 = i22 << 3;
                                int i24 = i22 >> 9;
                                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, innerTextField, visualTransformation, function29, function28, function210, function27, z2, z, z4, interactionSource, paddingValuesM16915textFieldWithoutLabelPaddinga9UjIt4$default, textFieldColors2, null, composer2, (i23 & 896) | (i23 & 112) | 6 | ((i22 >> 3) & 7168) | (i24 & 57344) | (i24 & 458752) | (i24 & 3670016) | ((i15 << 21) & 29360128) | ((i22 << 15) & 234881024) | ((i22 << 21) & 1879048192), ((i22 >> 12) & 112) | ((i22 >> 18) & 14) | (i15 & 896) | ((i15 << 6) & 7168), 16384);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function211 = function29;
                                function212 = function210;
                                z5 = z4;
                                paddingValues2 = paddingValuesM16915textFieldWithoutLabelPaddinga9UjIt4$default;
                                function213 = function28;
                                function214 = function27;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer3, int i25) {
                                    TextFieldDefaults.this.TextFieldDecorationBox(value, innerTextField, z, z2, visualTransformation, interactionSource, z5, function211, function213, function212, function214, textFieldColors2, paddingValues2, composer3, i | 1, i2, i4);
                                }
                            });
                            return;
                        }
                        i17 |= 3072;
                        if ((i5 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i10 == 0) {
                                }
                                if (i12 == 0) {
                                }
                                if ((i4 & 2048) == 0) {
                                }
                                if ((i4 & 4096) == 0) {
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i222 = i14;
                                int i232 = i222 << 3;
                                int i242 = i222 >> 9;
                                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, innerTextField, visualTransformation, function29, function28, function210, function27, z2, z, z4, interactionSource, paddingValuesM16915textFieldWithoutLabelPaddinga9UjIt4$default, textFieldColors2, null, composer2, (i232 & 896) | (i232 & 112) | 6 | ((i222 >> 3) & 7168) | (i242 & 57344) | (i242 & 458752) | (i242 & 3670016) | ((i15 << 21) & 29360128) | ((i222 << 15) & 234881024) | ((i222 << 21) & 1879048192), ((i222 >> 12) & 112) | ((i222 >> 18) & 14) | (i15 & 896) | ((i15 << 6) & 7168), 16384);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function211 = function29;
                                function212 = function210;
                                z5 = z4;
                                paddingValues2 = paddingValuesM16915textFieldWithoutLabelPaddinga9UjIt4$default;
                                function213 = function28;
                                function214 = function27;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i10 = i9;
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                    }
                    if ((i2 & 112) == 0) {
                    }
                    if ((i2 & 896) == 0) {
                    }
                    int i172 = i13;
                    if ((i4 & 8192) == 0) {
                    }
                    if ((i5 & 1533916891) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i5 |= i16;
                i6 = i4 & 64;
                if (i6 == 0) {
                }
                i7 = i4 & 128;
                if (i7 == 0) {
                }
                i8 = i4 & 256;
                if (i8 == 0) {
                }
                i9 = i4 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i4 & 1024;
                if (i11 != 0) {
                }
                if ((i2 & 112) == 0) {
                }
                if ((i2 & 896) == 0) {
                }
                int i1722 = i13;
                if ((i4 & 8192) == 0) {
                }
                if ((i5 & 1533916891) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            if ((i4 & 16) != 0) {
            }
            if ((i4 & 32) == 0) {
            }
            i5 |= i16;
            i6 = i4 & 64;
            if (i6 == 0) {
            }
            i7 = i4 & 128;
            if (i7 == 0) {
            }
            i8 = i4 & 256;
            if (i8 == 0) {
            }
            i9 = i4 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i4 & 1024;
            if (i11 != 0) {
            }
            if ((i2 & 112) == 0) {
            }
            if ((i2 & 896) == 0) {
            }
            int i17222 = i13;
            if ((i4 & 8192) == 0) {
            }
            if ((i5 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i4 & 8) == 0) {
        }
        if ((i4 & 16) != 0) {
        }
        if ((i4 & 32) == 0) {
        }
        i5 |= i16;
        i6 = i4 & 64;
        if (i6 == 0) {
        }
        i7 = i4 & 128;
        if (i7 == 0) {
        }
        i8 = i4 & 256;
        if (i8 == 0) {
        }
        i9 = i4 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i4 & 1024;
        if (i11 != 0) {
        }
        if ((i2 & 112) == 0) {
        }
        if ((i2 & 896) == 0) {
        }
        int i172222 = i13;
        if ((i4 & 8192) == 0) {
        }
        if ((i5 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m16917getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m16918getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m16919getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @JvmName(name = "getOutlinedTextFieldShape")
    @NotNull
    @Composable
    @ReadOnlyComposable
    public final Shape getOutlinedTextFieldShape(@Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, i, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:223)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return small;
    }

    @JvmName(name = "getTextFieldShape")
    @NotNull
    @Composable
    @ReadOnlyComposable
    public final Shape getTextFieldShape(@Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, i, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:214)");
        }
        CornerBasedShape cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return cornerBasedShapeCopy$default;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m16920getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    @ExperimentalMaterialApi
    @NotNull
    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m16921indicatorLinegv0btCI(@NotNull Modifier indicatorLine, final boolean z, final boolean z2, @NotNull final InteractionSource interactionSource, @NotNull final TextFieldColors colors, final float f, final float f4) {
        Intrinsics.checkNotNullParameter(indicatorLine, "$this$indicatorLine");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return ComposedModifierKt.composed(indicatorLine, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("indicatorLine");
                AbstractC0622a.m1163i(z2, AbstractC0622a.m1163i(z, inspectorInfo.getProperties(), "enabled", inspectorInfo), "isError", inspectorInfo).set("interactionSource", interactionSource);
                inspectorInfo.getProperties().set("colors", colors);
                AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), "focusedIndicatorLineThickness", inspectorInfo).set("unfocusedIndicatorLineThickness", C2256Dp.m20966boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(1398930845);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1398930845, i, -1, "androidx.compose.material.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:279)");
                }
                Modifier modifierDrawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) TextFieldDefaultsKt.m16928animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, colors, f, f4, composer, 0).getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return modifierDrawIndicatorLine;
            }
        });
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m16922outlinedTextFieldColorsdx8h9Zs(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, @Nullable Composer composer, int i, int i2, int i4, int i5) {
        long j23;
        long jM18524copywmQWz5c$default;
        long j24;
        long jM18524copywmQWz5c$default2;
        long j25;
        long jM18524copywmQWz5c$default3;
        long j26;
        long jM18524copywmQWz5c$default4;
        composer.startReplaceableGroup(1762667317);
        long jM18524copywmQWz5c$default5 = (i5 & 1) != 0 ? Color.m18524copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        long jM18524copywmQWz5c$default6 = (i5 & 2) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default5, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM18560getTransparent0d7_KjU = (i5 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long jM16676getPrimary0d7_KjU = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU() : j5;
        long jM16670getError0d7_KjU = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j6;
        long jM18524copywmQWz5c$default7 = (i5 & 32) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18524copywmQWz5c$default8 = (i5 & 64) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        if ((i5 & 128) != 0) {
            long j27 = jM18524copywmQWz5c$default8;
            j23 = j27;
            jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(j27, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j23 = jM18524copywmQWz5c$default8;
            jM18524copywmQWz5c$default = j9;
        }
        long jM16670getError0d7_KjU2 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j10;
        long jM18524copywmQWz5c$default9 = (i5 & 512) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if ((i5 & 1024) != 0) {
            long j28 = jM18524copywmQWz5c$default9;
            jM18524copywmQWz5c$default2 = Color.m18524copywmQWz5c$default(j28, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j24 = j28;
        } else {
            j24 = jM18524copywmQWz5c$default9;
            jM18524copywmQWz5c$default2 = j12;
        }
        long j29 = (i5 & 2048) != 0 ? j24 : j13;
        long jM18524copywmQWz5c$default10 = (i5 & 4096) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j14;
        if ((i5 & 8192) != 0) {
            long j30 = jM18524copywmQWz5c$default10;
            jM18524copywmQWz5c$default3 = Color.m18524copywmQWz5c$default(j30, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j30;
        } else {
            j25 = jM18524copywmQWz5c$default10;
            jM18524copywmQWz5c$default3 = j15;
        }
        long jM16670getError0d7_KjU3 = (i5 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j16;
        long jM18524copywmQWz5c$default11 = (32768 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM18524copywmQWz5c$default12 = (65536 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        if ((131072 & i5) != 0) {
            long j31 = jM18524copywmQWz5c$default12;
            jM18524copywmQWz5c$default4 = Color.m18524copywmQWz5c$default(j31, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j26 = j31;
        } else {
            j26 = jM18524copywmQWz5c$default12;
            jM18524copywmQWz5c$default4 = j19;
        }
        long jM16670getError0d7_KjU4 = (262144 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j20;
        long jM18524copywmQWz5c$default13 = (524288 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        long jM18524copywmQWz5c$default14 = (i5 & 1048576) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, i, i2, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:433)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM18524copywmQWz5c$default5, jM18524copywmQWz5c$default6, jM16676getPrimary0d7_KjU, jM16670getError0d7_KjU, jM18524copywmQWz5c$default7, j23, jM16670getError0d7_KjU2, jM18524copywmQWz5c$default, j24, jM18524copywmQWz5c$default2, j29, j25, jM18524copywmQWz5c$default3, jM16670getError0d7_KjU3, jM18560getTransparent0d7_KjU, jM18524copywmQWz5c$default11, j26, jM18524copywmQWz5c$default4, jM16670getError0d7_KjU4, jM18524copywmQWz5c$default13, jM18524copywmQWz5c$default14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    @ExperimentalMaterialApi
    @NotNull
    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m16923outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m15850PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m16924textFieldColorsdx8h9Zs(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, @Nullable Composer composer, int i, int i2, int i4, int i5) {
        long j23;
        long jM18524copywmQWz5c$default;
        long j24;
        long jM18524copywmQWz5c$default2;
        long j25;
        long jM18524copywmQWz5c$default3;
        long j26;
        long jM18524copywmQWz5c$default4;
        composer.startReplaceableGroup(231892599);
        long jM18524copywmQWz5c$default5 = (i5 & 1) != 0 ? Color.m18524copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        long jM18524copywmQWz5c$default6 = (i5 & 2) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default5, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM18524copywmQWz5c$default7 = (i5 & 4) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM16676getPrimary0d7_KjU = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU() : j5;
        long jM16670getError0d7_KjU = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j6;
        long jM18524copywmQWz5c$default8 = (i5 & 32) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18524copywmQWz5c$default9 = (i5 & 64) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        if ((i5 & 128) != 0) {
            long j27 = jM18524copywmQWz5c$default9;
            j23 = j27;
            jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(j27, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j23 = jM18524copywmQWz5c$default9;
            jM18524copywmQWz5c$default = j9;
        }
        long jM16670getError0d7_KjU2 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j10;
        long jM18524copywmQWz5c$default10 = (i5 & 512) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if ((i5 & 1024) != 0) {
            long j28 = jM18524copywmQWz5c$default10;
            jM18524copywmQWz5c$default2 = Color.m18524copywmQWz5c$default(j28, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j24 = j28;
        } else {
            j24 = jM18524copywmQWz5c$default10;
            jM18524copywmQWz5c$default2 = j12;
        }
        long j29 = (i5 & 2048) != 0 ? j24 : j13;
        long jM18524copywmQWz5c$default11 = (i5 & 4096) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j14;
        if ((i5 & 8192) != 0) {
            long j30 = jM18524copywmQWz5c$default11;
            jM18524copywmQWz5c$default3 = Color.m18524copywmQWz5c$default(j30, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j30;
        } else {
            j25 = jM18524copywmQWz5c$default11;
            jM18524copywmQWz5c$default3 = j15;
        }
        long jM16670getError0d7_KjU3 = (i5 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j16;
        long jM18524copywmQWz5c$default12 = (32768 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM18524copywmQWz5c$default13 = (65536 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        if ((131072 & i5) != 0) {
            long j31 = jM18524copywmQWz5c$default13;
            jM18524copywmQWz5c$default4 = Color.m18524copywmQWz5c$default(j31, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j26 = j31;
        } else {
            j26 = jM18524copywmQWz5c$default13;
            jM18524copywmQWz5c$default4 = j19;
        }
        long jM16670getError0d7_KjU4 = (262144 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j20;
        long jM18524copywmQWz5c$default14 = (524288 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        long jM18524copywmQWz5c$default15 = (i5 & 1048576) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, i, i2, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:375)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM18524copywmQWz5c$default5, jM18524copywmQWz5c$default6, jM16676getPrimary0d7_KjU, jM16670getError0d7_KjU, jM18524copywmQWz5c$default8, j23, jM16670getError0d7_KjU2, jM18524copywmQWz5c$default, j24, jM18524copywmQWz5c$default2, j29, j25, jM18524copywmQWz5c$default3, jM16670getError0d7_KjU3, jM18524copywmQWz5c$default7, jM18524copywmQWz5c$default12, j26, jM18524copywmQWz5c$default4, jM16670getError0d7_KjU4, jM18524copywmQWz5c$default14, jM18524copywmQWz5c$default15, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    @ExperimentalMaterialApi
    @NotNull
    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m16925textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m15850PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    @ExperimentalMaterialApi
    @NotNull
    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m16926textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m15850PaddingValuesa9UjIt4(start, top, end, bottom);
    }
}
