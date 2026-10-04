package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
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
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
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
@ExperimentalMaterial3Api
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001eJS\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jî\u0001\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00150(¢\u0006\u0002\b)2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u00102\u001a\u0002032\u0013\b\u0002\u00104\u001a\r\u0012\u0004\u0012\u00020\u00150(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00105Jø\u0001\u00106\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00150(¢\u0006\u0002\b)2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010(¢\u0006\u0002\b)2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u00102\u001a\u0002032\u0013\b\u0002\u00104\u001a\r\u0012\u0004\u0012\u00020\u00150(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00107J\u00ad\u0002\u00108\u001a\u00020\u001c2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020:2\b\b\u0002\u0010>\u001a\u00020:2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020:2\b\b\u0002\u0010B\u001a\u00020:2\b\b\u0002\u0010C\u001a\u00020:2\b\b\u0002\u0010D\u001a\u00020:2\b\b\u0002\u0010E\u001a\u00020:2\b\b\u0002\u0010F\u001a\u00020:2\b\b\u0002\u0010G\u001a\u00020:2\b\b\u0002\u0010H\u001a\u00020:2\b\b\u0002\u0010I\u001a\u00020:2\b\b\u0002\u0010J\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020:2\b\b\u0002\u0010L\u001a\u00020:2\b\b\u0002\u0010M\u001a\u00020:2\b\b\u0002\u0010N\u001a\u00020:2\b\b\u0002\u0010O\u001a\u00020:2\b\b\u0002\u0010P\u001a\u00020:2\b\b\u0002\u0010Q\u001a\u00020:2\b\b\u0002\u0010R\u001a\u00020:2\b\b\u0002\u0010S\u001a\u00020:2\b\b\u0002\u0010T\u001a\u00020:2\b\b\u0002\u0010U\u001a\u00020:2\b\b\u0002\u0010V\u001a\u00020:H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010XJ=\u0010Y\u001a\u0002032\b\b\u0002\u0010Z\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_J=\u0010`\u001a\u0002032\b\b\u0002\u0010Z\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u0004H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010_J\u00ad\u0002\u0010b\u001a\u00020\u001c2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020:2\b\b\u0002\u0010>\u001a\u00020:2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010c\u001a\u00020:2\b\b\u0002\u0010d\u001a\u00020:2\b\b\u0002\u0010e\u001a\u00020:2\b\b\u0002\u0010f\u001a\u00020:2\b\b\u0002\u0010E\u001a\u00020:2\b\b\u0002\u0010F\u001a\u00020:2\b\b\u0002\u0010G\u001a\u00020:2\b\b\u0002\u0010H\u001a\u00020:2\b\b\u0002\u0010I\u001a\u00020:2\b\b\u0002\u0010J\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020:2\b\b\u0002\u0010L\u001a\u00020:2\b\b\u0002\u0010M\u001a\u00020:2\b\b\u0002\u0010N\u001a\u00020:2\b\b\u0002\u0010O\u001a\u00020:2\b\b\u0002\u0010P\u001a\u00020:2\b\b\u0002\u0010Q\u001a\u00020:2\b\b\u0002\u0010R\u001a\u00020:2\b\b\u0002\u0010S\u001a\u00020:2\b\b\u0002\u0010T\u001a\u00020:2\b\b\u0002\u0010U\u001a\u00020:2\b\b\u0002\u0010V\u001a\u00020:H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010XJ=\u0010h\u001a\u0002032\b\b\u0002\u0010Z\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bi\u0010_J=\u0010j\u001a\u0002032\b\b\u0002\u0010Z\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u00042\b\b\u0002\u0010]\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010_JM\u0010l\u001a\u00020m*\u00020m2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010n\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bp\u0010qR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006r"}, m13886d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "FilledContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", VMetaDataKey.META_KEY_SHAPE, "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "OutlinedBorderContainerBox", "focusedBorderThickness", "unfocusedBorderThickness", "OutlinedBorderContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "outlinedTextFieldColors-l59Burw", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3_release", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-l59Burw", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TextFieldDefaults {

    @NotNull
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = C2256Dp.m20968constructorimpl(56);
    private static final float MinWidth = C2256Dp.m20968constructorimpl(280);
    private static final float UnfocusedBorderThickness = C2256Dp.m20968constructorimpl(1);
    private static final float FocusedBorderThickness = C2256Dp.m20968constructorimpl(2);

    private TextFieldDefaults() {
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m17366indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f4, int i, Object obj) {
        if ((i & 16) != 0) {
            f = FocusedBorderThickness;
        }
        return textFieldDefaults.m17376indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f, (i & 32) != 0 ? UnfocusedBorderThickness : f4);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m17367outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f4, float f5, float f6, int i, Object obj) {
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
        return textFieldDefaults.m17378outlinedTextFieldPaddinga9UjIt4(f, f4, f5, f6);
    }

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3_release$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m17368supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f4 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f5 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(0);
        }
        return textFieldDefaults.m17379supportingTextPaddinga9UjIt4$material3_release(f, f4, f5, f6);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m17369textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f4, float f5, float f6, int i, Object obj) {
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
        return textFieldDefaults.m17381textFieldWithLabelPaddinga9UjIt4(f, f4, f5, f6);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m17370textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f4, float f5, float f6, int i, Object obj) {
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
        return textFieldDefaults.m17382textFieldWithoutLabelPaddinga9UjIt4(f, f4, f5, f6);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0130 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0131  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterial3Api
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void FilledContainerBox(final boolean z, final boolean z2, @NotNull final InteractionSource interactionSource, @NotNull final TextFieldColors colors, @Nullable Shape shape, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Shape filledShape;
        final Shape shape2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1358797526);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(colors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                filledShape = shape;
                int i6 = composerStartRestartGroup.changed(filledShape) ? 16384 : 8192;
                i4 |= i6;
            } else {
                filledShape = shape;
            }
            i4 |= i6;
        } else {
            filledShape = shape;
        }
        if ((i2 & 32) == 0) {
            i5 = (458752 & i) == 0 ? composerStartRestartGroup.changed(this) ? 131072 : 65536 : 196608;
            if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i2 & 16) != 0) {
                        filledShape = getFilledShape(composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -57345;
                    }
                    Shape shape3 = filledShape;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1358797526, i4, -1, "androidx.compose.material3.TextFieldDefaults.FilledContainerBox (TextFieldDefaults.kt:102)");
                    }
                    BoxKt.Box(m17366indicatorLinegv0btCI$default(this, BackgroundKt.m15408backgroundbw27NRU(Modifier.INSTANCE, colors.containerColor$material3_release(composerStartRestartGroup, (i4 >> 9) & 14).getValue().m18535unboximpl(), shape3), z, z2, interactionSource, colors, 0.0f, 0.0f, 48, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape2 = shape3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i4 &= -57345;
                    }
                    Shape shape32 = filledShape;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    BoxKt.Box(m17366indicatorLinegv0btCI$default(this, BackgroundKt.m15408backgroundbw27NRU(Modifier.INSTANCE, colors.containerColor$material3_release(composerStartRestartGroup, (i4 >> 9) & 14).getValue().m18535unboximpl(), shape32), z, z2, interactionSource, colors, 0.0f, 0.0f, 48, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape2 = shape32;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                shape2 = filledShape;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults.FilledContainerBox.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    TextFieldDefaults.this.FilledContainerBox(z, z2, interactionSource, colors, shape2, composer2, i | 1, i2);
                }
            });
            return;
        }
        i4 |= i5;
        if ((374491 & i4) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if ((i2 & 16) != 0) {
                }
                Shape shape322 = filledShape;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                BoxKt.Box(m17366indicatorLinegv0btCI$default(this, BackgroundKt.m15408backgroundbw27NRU(Modifier.INSTANCE, colors.containerColor$material3_release(composerStartRestartGroup, (i4 >> 9) & 14).getValue().m18535unboximpl(), shape322), z, z2, interactionSource, colors, 0.0f, 0.0f, 48, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                shape2 = shape322;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010e  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterial3Api
    /* JADX INFO: renamed from: OutlinedBorderContainerBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m17371OutlinedBorderContainerBoxnbWgWpA(final boolean z, final boolean z2, @NotNull final InteractionSource interactionSource, @NotNull TextFieldColors textFieldColors, @Nullable Shape shape, float f, float f4, @Nullable Composer composer, final int i, final int i2) {
        boolean z3;
        int i4;
        Shape shape2;
        float f5;
        float f6;
        TextFieldDefaults textFieldDefaults;
        Shape shape3;
        float f7;
        int i5;
        float f8;
        float f9;
        final float f10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final TextFieldColors colors = textFieldColors;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1998946250);
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
                    int i6 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                    i4 |= i6;
                } else {
                    shape2 = shape;
                }
                i4 |= i6;
            } else {
                shape2 = shape;
            }
            if ((i & 458752) != 0) {
                if ((i2 & 32) == 0) {
                    f5 = f;
                    int i7 = composerStartRestartGroup.changed(f5) ? 131072 : 65536;
                    i4 |= i7;
                } else {
                    f5 = f;
                }
                i4 |= i7;
            } else {
                f5 = f;
            }
            if ((3670016 & i) != 0) {
                if ((i2 & 64) == 0) {
                    f6 = f4;
                    int i8 = composerStartRestartGroup.changed(f6) ? 1048576 : 524288;
                    i4 |= i8;
                } else {
                    f6 = f4;
                }
                i4 |= i8;
            } else {
                f6 = f4;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    textFieldDefaults = this;
                    i4 |= composerStartRestartGroup.changed(textFieldDefaults) ? 8388608 : 4194304;
                }
                if ((23967451 & i4) == 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f10 = f5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if ((i2 & 16) == 0) {
                            shape3 = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 32) == 0) {
                            f7 = FocusedBorderThickness;
                            i4 &= -458753;
                        } else {
                            f7 = f5;
                        }
                        if ((i2 & 64) == 0) {
                            f8 = f7;
                            f9 = UnfocusedBorderThickness;
                            i5 = i4 & (-3670017);
                        } else {
                            i5 = i4;
                            f8 = f7;
                            f9 = f6;
                        }
                        shape2 = shape3;
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
                        f8 = f5;
                        f9 = f6;
                        i5 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1998946250, i5, -1, "androidx.compose.material3.TextFieldDefaults.OutlinedBorderContainerBox (TextFieldDefaults.kt:175)");
                    }
                    int i9 = i5 >> 3;
                    State stateM17384animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m17384animateBorderStrokeAsStateNuRrP5Q(z3, z2, interactionSource, textFieldColors, f8, f9, composerStartRestartGroup, (i5 & 8190) | (i9 & 57344) | (i9 & 458752));
                    f6 = f9;
                    colors = textFieldColors;
                    BoxKt.Box(BackgroundKt.m15408backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) stateM17384animateBorderStrokeAsStateNuRrP5Q.getValue(), shape2), colors.containerColor$material3_release(composerStartRestartGroup, (i5 >> 9) & 14).getValue().m18535unboximpl(), shape2), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f10 = f8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final Shape shape4 = shape2;
                final float f11 = f6;
                final TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$OutlinedBorderContainerBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i10) {
                        this.$tmp0_rcvr.m17371OutlinedBorderContainerBoxnbWgWpA(z, z2, interactionSource, colors, shape4, f10, f11, composer2, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= 12582912;
            textFieldDefaults = this;
            if ((23967451 & i4) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if ((i2 & 16) == 0) {
                    }
                    if ((i2 & 32) == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    shape2 = shape3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i92 = i5 >> 3;
                    State stateM17384animateBorderStrokeAsStateNuRrP5Q2 = TextFieldDefaultsKt.m17384animateBorderStrokeAsStateNuRrP5Q(z3, z2, interactionSource, textFieldColors, f8, f9, composerStartRestartGroup, (i5 & 8190) | (i92 & 57344) | (i92 & 458752));
                    f6 = f9;
                    colors = textFieldColors;
                    BoxKt.Box(BackgroundKt.m15408backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) stateM17384animateBorderStrokeAsStateNuRrP5Q2.getValue(), shape2), colors.containerColor$material3_release(composerStartRestartGroup, (i5 >> 9) & 14).getValue().m18535unboximpl(), shape2), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f10 = f8;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
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
        textFieldDefaults = this;
        if ((23967451 & i4) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0429 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013e  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OutlinedTextFieldDecorationBox(@NotNull final String value, @NotNull final Function2<? super Composer, ? super Integer, Unit> innerTextField, final boolean z, final boolean z2, @NotNull final VisualTransformation visualTransformation, @NotNull final InteractionSource interactionSource, boolean z3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, @Nullable TextFieldColors textFieldColors, @Nullable PaddingValues paddingValues, @Nullable Function2<? super Composer, ? super Integer, Unit> function26, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Composer composer2;
        int i19;
        int i20;
        TextFieldColors textFieldColorsM17377outlinedTextFieldColorsl59Burw;
        PaddingValues paddingValuesM17367outlinedTextFieldPaddinga9UjIt4$default;
        TextFieldColors textFieldColors2;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Composer composer3;
        int i21;
        PaddingValues paddingValues2;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function213;
        final TextFieldColors textFieldColors3;
        Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        Composer composer4;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final PaddingValues paddingValues3;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i22;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(508645792);
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
                z4 = z;
                i5 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
            }
            int i23 = 1024;
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
                    i22 = (i & 458752) == 0 ? composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536 : 196608;
                    i6 = i4 & 64;
                    if (i6 == 0) {
                        i5 |= 1572864;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
                        }
                    }
                    i7 = i4 & 128;
                    if (i7 == 0) {
                        i5 |= 12582912;
                        function27 = function2;
                    } else {
                        function27 = function2;
                        if ((i & 29360128) == 0) {
                            i5 |= composerStartRestartGroup.changed(function27) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i4 & 256;
                    if (i8 == 0) {
                        i5 |= 100663296;
                        function28 = function22;
                    } else {
                        function28 = function22;
                        if ((i & 234881024) == 0) {
                            i5 |= composerStartRestartGroup.changed(function28) ? 67108864 : 33554432;
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
                        i14 = i4 & 2048;
                        if (i14 != 0) {
                            i13 |= 48;
                        } else {
                            if ((i2 & 112) == 0) {
                                i15 = i14;
                                i13 |= composerStartRestartGroup.changed(function25) ? 32 : 16;
                            }
                            if ((i2 & 896) == 0) {
                                i13 |= ((i4 & 4096) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 256 : 128;
                            }
                            if ((i2 & 7168) == 0) {
                                if ((i4 & 8192) == 0 && composerStartRestartGroup.changed(paddingValues)) {
                                    i23 = 2048;
                                }
                                i13 |= i23;
                            }
                            int i24 = i13;
                            i16 = i4 & 16384;
                            if (i16 != 0) {
                                if ((i2 & 57344) == 0) {
                                    i17 = i16;
                                    i24 |= composerStartRestartGroup.changed(function26) ? 16384 : 8192;
                                }
                                if ((i4 & 32768) != 0) {
                                    i18 = i24 | 196608;
                                } else {
                                    int i25 = i24;
                                    if ((i2 & 458752) == 0) {
                                        i18 = i25 | (composerStartRestartGroup.changed(this) ? 131072 : 65536);
                                    } else {
                                        i18 = i25;
                                    }
                                }
                                if ((i5 & 1533916891) == 306783378 && (374491 & i18) == 74898 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function220 = function23;
                                    function217 = function24;
                                    textFieldColors3 = textFieldColors;
                                    function218 = function26;
                                    composer4 = composerStartRestartGroup;
                                    z7 = z5;
                                    function215 = function27;
                                    function216 = function28;
                                    function219 = function25;
                                    paddingValues3 = paddingValues;
                                } else {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        boolean z8 = i6 == 0 ? false : z5;
                                        Function2<? super Composer, ? super Integer, Unit> function221 = i7 == 0 ? null : function27;
                                        Function2<? super Composer, ? super Integer, Unit> function222 = i8 == 0 ? null : function28;
                                        Function2<? super Composer, ? super Integer, Unit> function223 = i10 == 0 ? null : function23;
                                        function29 = i12 == 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i15 == 0 ? function25 : null;
                                        if ((i4 & 4096) == 0) {
                                            int i26 = i18;
                                            i20 = i17;
                                            textFieldColorsM17377outlinedTextFieldColorsl59Burw = m17377outlinedTextFieldColorsl59Burw(0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i18 << 9) & 234881024, 268435455);
                                            composer2 = composerStartRestartGroup;
                                            i19 = i26 & (-897);
                                        } else {
                                            composer2 = composerStartRestartGroup;
                                            i19 = i18;
                                            i20 = i17;
                                            textFieldColorsM17377outlinedTextFieldColorsl59Burw = textFieldColors;
                                        }
                                        if ((i4 & 8192) == 0) {
                                            paddingValuesM17367outlinedTextFieldPaddinga9UjIt4$default = m17367outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                            i19 &= -7169;
                                        } else {
                                            paddingValuesM17367outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                        }
                                        if (i20 == 0) {
                                            final boolean z9 = z8;
                                            final int i27 = i19;
                                            final int i28 = i5;
                                            final boolean z10 = z4;
                                            final TextFieldColors textFieldColors4 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                            textFieldColors2 = textFieldColors4;
                                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 144282315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer5, int i29) {
                                                    if ((i29 & 11) == 2 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(144282315, i29, -1, "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:644)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                                    boolean z11 = z10;
                                                    boolean z12 = z9;
                                                    InteractionSource interactionSource2 = interactionSource;
                                                    TextFieldColors textFieldColors5 = textFieldColors4;
                                                    int i30 = i28;
                                                    textFieldDefaults.m17371OutlinedBorderContainerBoxnbWgWpA(z11, z12, interactionSource2, textFieldColors5, null, 0.0f, 0.0f, composer5, ((i30 >> 9) & 896) | ((i30 >> 6) & 14) | 12582912 | ((i30 >> 15) & 112) | ((i27 << 3) & 7168), 112);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            function210 = function224;
                                            function211 = function221;
                                            function212 = function222;
                                            composer3 = composer2;
                                            paddingValues2 = paddingValuesM17367outlinedTextFieldPaddinga9UjIt4$default;
                                            z6 = z9;
                                            function213 = composableLambda;
                                            i21 = i27;
                                        } else {
                                            TextFieldColors textFieldColors5 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                            int i29 = i19;
                                            textFieldColors2 = textFieldColors5;
                                            boolean z11 = z8;
                                            function210 = function224;
                                            function211 = function221;
                                            function212 = function222;
                                            composer3 = composer2;
                                            i21 = i29;
                                            paddingValues2 = paddingValuesM17367outlinedTextFieldPaddinga9UjIt4$default;
                                            z6 = z11;
                                            function213 = function26;
                                        }
                                        textFieldColors3 = textFieldColors2;
                                        function214 = function223;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i4 & 4096) != 0) {
                                            i18 &= -897;
                                        }
                                        if ((i4 & 8192) != 0) {
                                            i18 &= -7169;
                                        }
                                        function29 = function24;
                                        function210 = function25;
                                        composer3 = composerStartRestartGroup;
                                        z6 = z5;
                                        function211 = function27;
                                        i21 = i18;
                                        function212 = function28;
                                        function214 = function23;
                                        textFieldColors3 = textFieldColors;
                                        paddingValues2 = paddingValues;
                                        function213 = function26;
                                    }
                                    composer3.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(508645792, i5, i21, "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:629)");
                                    }
                                    int i30 = i5 << 3;
                                    int i31 = i5 >> 9;
                                    int i32 = i21 << 21;
                                    int i33 = (i30 & 896) | (i30 & 112) | 6 | ((i5 >> 3) & 7168) | (i31 & 57344) | (i31 & 458752) | (3670016 & i31) | (i32 & 29360128) | (i32 & 234881024) | ((i5 << 18) & 1879048192);
                                    int i34 = ((i5 >> 15) & 112) | ((i5 >> 6) & 14) | (i31 & 896) | (i21 & 7168) | ((i21 << 6) & 57344) | ((i21 << 3) & 458752);
                                    Function2<? super Composer, ? super Integer, Unit> function225 = function29;
                                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, function211, function212, function214, function225, function210, z2, z, z6, interactionSource, paddingValues2, textFieldColors3, function213, composer3, i33, i34, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function215 = function211;
                                    function216 = function212;
                                    function217 = function225;
                                    composer4 = composer3;
                                    function218 = function213;
                                    paddingValues3 = paddingValues2;
                                    function219 = function210;
                                    z7 = z6;
                                    function220 = function214;
                                }
                                scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                    return;
                                }
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@Nullable Composer composer5, int i35) {
                                        TextFieldDefaults.this.OutlinedTextFieldDecorationBox(value, innerTextField, z, z2, visualTransformation, interactionSource, z7, function215, function216, function220, function217, function219, textFieldColors3, paddingValues3, function218, composer5, i | 1, i2, i4);
                                    }
                                });
                                return;
                            }
                            i24 |= 24576;
                            i17 = i16;
                            if ((i4 & 32768) != 0) {
                            }
                            if ((i5 & 1533916891) == 306783378) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0) {
                                    if (i6 == 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i12 == 0) {
                                    }
                                    if (i15 == 0) {
                                    }
                                    if ((i4 & 4096) == 0) {
                                    }
                                    if ((i4 & 8192) == 0) {
                                    }
                                    if (i20 == 0) {
                                    }
                                    textFieldColors3 = textFieldColors2;
                                    function214 = function223;
                                    composer3.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    int i302 = i5 << 3;
                                    int i312 = i5 >> 9;
                                    int i322 = i21 << 21;
                                    int i332 = (i302 & 896) | (i302 & 112) | 6 | ((i5 >> 3) & 7168) | (i312 & 57344) | (i312 & 458752) | (3670016 & i312) | (i322 & 29360128) | (i322 & 234881024) | ((i5 << 18) & 1879048192);
                                    int i342 = ((i5 >> 15) & 112) | ((i5 >> 6) & 14) | (i312 & 896) | (i21 & 7168) | ((i21 << 6) & 57344) | ((i21 << 3) & 458752);
                                    Function2<? super Composer, ? super Integer, Unit> function2252 = function29;
                                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, function211, function212, function214, function2252, function210, z2, z, z6, interactionSource, paddingValues2, textFieldColors3, function213, composer3, i332, i342, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    function215 = function211;
                                    function216 = function212;
                                    function217 = function2252;
                                    composer4 = composer3;
                                    function218 = function213;
                                    paddingValues3 = paddingValues2;
                                    function219 = function210;
                                    z7 = z6;
                                    function220 = function214;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i15 = i14;
                        if ((i2 & 896) == 0) {
                        }
                        if ((i2 & 7168) == 0) {
                        }
                        int i242 = i13;
                        i16 = i4 & 16384;
                        if (i16 != 0) {
                        }
                        i17 = i16;
                        if ((i4 & 32768) != 0) {
                        }
                        if ((i5 & 1533916891) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i9;
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                    }
                    i14 = i4 & 2048;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    if ((i2 & 896) == 0) {
                    }
                    if ((i2 & 7168) == 0) {
                    }
                    int i2422 = i13;
                    i16 = i4 & 16384;
                    if (i16 != 0) {
                    }
                    i17 = i16;
                    if ((i4 & 32768) != 0) {
                    }
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i5 |= i22;
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
                i14 = i4 & 2048;
                if (i14 != 0) {
                }
                i15 = i14;
                if ((i2 & 896) == 0) {
                }
                if ((i2 & 7168) == 0) {
                }
                int i24222 = i13;
                i16 = i4 & 16384;
                if (i16 != 0) {
                }
                i17 = i16;
                if ((i4 & 32768) != 0) {
                }
                if ((i5 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            if ((i4 & 16) != 0) {
            }
            if ((i4 & 32) == 0) {
            }
            i5 |= i22;
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
            i14 = i4 & 2048;
            if (i14 != 0) {
            }
            i15 = i14;
            if ((i2 & 896) == 0) {
            }
            if ((i2 & 7168) == 0) {
            }
            int i242222 = i13;
            i16 = i4 & 16384;
            if (i16 != 0) {
            }
            i17 = i16;
            if ((i4 & 32768) != 0) {
            }
            if ((i5 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        z4 = z;
        int i232 = 1024;
        if ((i4 & 8) == 0) {
        }
        if ((i4 & 16) != 0) {
        }
        if ((i4 & 32) == 0) {
        }
        i5 |= i22;
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
        i14 = i4 & 2048;
        if (i14 != 0) {
        }
        i15 = i14;
        if ((i2 & 896) == 0) {
        }
        if ((i2 & 7168) == 0) {
        }
        int i2422222 = i13;
        i16 = i4 & 16384;
        if (i16 != 0) {
        }
        i17 = i16;
        if ((i4 & 32768) != 0) {
        }
        if ((i5 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x048b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0146  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void TextFieldDecorationBox(@NotNull final String value, @NotNull final Function2<? super Composer, ? super Integer, Unit> innerTextField, final boolean z, final boolean z2, @NotNull final VisualTransformation visualTransformation, @NotNull final InteractionSource interactionSource, boolean z3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, @Nullable Shape shape, @Nullable TextFieldColors textFieldColors, @Nullable PaddingValues paddingValues, @Nullable Function2<? super Composer, ? super Integer, Unit> function26, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        int i6;
        boolean z4;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Shape filledShape;
        Shape shape2;
        Composer composer2;
        TextFieldColors textFieldColorsM17380textFieldColorsl59Burw;
        PaddingValues paddingValuesM17370textFieldWithoutLabelPaddinga9UjIt4$default;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function2ComposableLambda;
        Shape shape3;
        PaddingValues paddingValues2;
        TextFieldColors textFieldColors2;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        Composer composer3;
        final PaddingValues paddingValues3;
        final TextFieldColors textFieldColors3;
        final Shape shape4;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i20;
        int i21;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1224712461);
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
            int i22 = 1024;
            if ((i4 & 8) == 0) {
                i5 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                int i23 = 8192;
                if ((i4 & 16) != 0) {
                    i5 |= 24576;
                } else if ((i & 57344) == 0) {
                    i5 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                }
                if ((i4 & 32) == 0) {
                    i21 = (i & 458752) == 0 ? composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536 : 196608;
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
                        function27 = function2;
                    } else {
                        function27 = function2;
                        if ((i & 29360128) == 0) {
                            i5 |= composerStartRestartGroup.changed(function27) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i4 & 256;
                    if (i8 == 0) {
                        i5 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i5 |= composerStartRestartGroup.changed(function22) ? 67108864 : 33554432;
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
                    i14 = i4 & 2048;
                    if (i14 == 0) {
                        i13 |= 48;
                    } else {
                        if ((i2 & 112) == 0) {
                            i15 = i14;
                            i13 |= composerStartRestartGroup.changed(function25) ? 32 : 16;
                        }
                        if ((i2 & 896) == 0) {
                            i13 |= ((i4 & 4096) == 0 && composerStartRestartGroup.changed(shape)) ? 256 : 128;
                        }
                        if ((i2 & 7168) == 0) {
                            if ((i4 & 8192) == 0 && composerStartRestartGroup.changed(textFieldColors)) {
                                i22 = 2048;
                            }
                            i13 |= i22;
                        }
                        if ((i2 & 57344) == 0) {
                            if ((i4 & 16384) == 0 && composerStartRestartGroup.changed(paddingValues)) {
                                i23 = 16384;
                            }
                            i13 |= i23;
                        }
                        i16 = i4 & 32768;
                        if (i16 != 0) {
                            i13 |= 196608;
                        } else if ((i2 & 458752) == 0) {
                            i13 |= composerStartRestartGroup.changed(function26) ? 131072 : 65536;
                        }
                        if ((i4 & 65536) == 0) {
                            i20 = (i2 & 3670016) == 0 ? composerStartRestartGroup.changed(this) ? 1048576 : 524288 : 1572864;
                            i17 = i13;
                            if ((i11 & 1533916891) != 306783378 && (2995931 & i17) == 599186 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                function214 = function22;
                                function215 = function24;
                                function217 = function25;
                                textFieldColors3 = textFieldColors;
                                paddingValues3 = paddingValues;
                                function216 = function26;
                                composer3 = composerStartRestartGroup;
                                z5 = z4;
                                function213 = function27;
                                function218 = function23;
                                shape4 = shape;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    boolean z6 = i6 == 0 ? false : z4;
                                    Function2<? super Composer, ? super Integer, Unit> function219 = i7 == 0 ? null : function27;
                                    Function2<? super Composer, ? super Integer, Unit> function220 = i8 == 0 ? null : function22;
                                    Function2<? super Composer, ? super Integer, Unit> function221 = i10 == 0 ? null : function23;
                                    Function2<? super Composer, ? super Integer, Unit> function222 = i12 == 0 ? null : function24;
                                    Function2<? super Composer, ? super Integer, Unit> function223 = i15 == 0 ? null : function25;
                                    if ((i4 & 4096) == 0) {
                                        i18 = i17 & (-897);
                                        filledShape = getFilledShape(composerStartRestartGroup, (i17 >> 18) & 14);
                                    } else {
                                        i18 = i17;
                                        filledShape = shape;
                                    }
                                    if ((i4 & 8192) == 0) {
                                        int i24 = i18;
                                        shape2 = filledShape;
                                        textFieldColorsM17380textFieldColorsl59Burw = m17380textFieldColorsl59Burw(0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i18 << 6) & 234881024, 268435455);
                                        composer2 = composerStartRestartGroup;
                                        i17 = i24 & (-7169);
                                    } else {
                                        shape2 = filledShape;
                                        i17 = i18;
                                        composer2 = composerStartRestartGroup;
                                        textFieldColorsM17380textFieldColorsl59Burw = textFieldColors;
                                    }
                                    if ((i4 & 16384) == 0) {
                                        paddingValuesM17370textFieldWithoutLabelPaddinga9UjIt4$default = function219 == null ? m17370textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : m17369textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        i17 &= -57345;
                                    } else {
                                        paddingValuesM17370textFieldWithoutLabelPaddinga9UjIt4$default = paddingValues;
                                    }
                                    if (i16 == 0) {
                                        final Shape shape5 = shape2;
                                        final int i25 = i17;
                                        final TextFieldColors textFieldColors4 = textFieldColorsM17380textFieldColorsl59Burw;
                                        final int i26 = i11;
                                        final boolean z7 = z6;
                                        z4 = z7;
                                        i19 = i26;
                                        shape3 = shape5;
                                        paddingValues2 = paddingValuesM17370textFieldWithoutLabelPaddinga9UjIt4$default;
                                        textFieldColors2 = textFieldColors4;
                                        function2ComposableLambda = ComposableLambdaKt.composableLambda(composer2, -1171460386, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer4, int i27) {
                                                if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1171460386, i27, -1, "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:548)");
                                                }
                                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                                boolean z8 = z;
                                                boolean z9 = z7;
                                                InteractionSource interactionSource2 = interactionSource;
                                                TextFieldColors textFieldColors5 = textFieldColors4;
                                                Shape shape6 = shape5;
                                                int i28 = i26;
                                                int i29 = ((i28 >> 9) & 896) | ((i28 >> 6) & 14) | 196608 | ((i28 >> 15) & 112);
                                                int i30 = i25;
                                                textFieldDefaults.FilledContainerBox(z8, z9, interactionSource2, textFieldColors5, shape6, composer4, i29 | (i30 & 7168) | ((i30 << 6) & 57344), 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    } else {
                                        i19 = i11;
                                        z4 = z6;
                                        function2ComposableLambda = function26;
                                        shape3 = shape2;
                                        paddingValues2 = paddingValuesM17370textFieldWithoutLabelPaddinga9UjIt4$default;
                                        textFieldColors2 = textFieldColorsM17380textFieldColorsl59Burw;
                                    }
                                    function28 = function219;
                                    function29 = function220;
                                    function210 = function221;
                                    function211 = function222;
                                    function212 = function223;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 4096) != 0) {
                                        i17 &= -897;
                                    }
                                    if ((i4 & 8192) != 0) {
                                        i17 &= -7169;
                                    }
                                    if ((i4 & 16384) != 0) {
                                        i17 &= -57345;
                                    }
                                    function29 = function22;
                                    function210 = function23;
                                    shape3 = shape;
                                    paddingValues2 = paddingValues;
                                    function2ComposableLambda = function26;
                                    composer2 = composerStartRestartGroup;
                                    function28 = function27;
                                    i19 = i11;
                                    function211 = function24;
                                    function212 = function25;
                                    textFieldColors2 = textFieldColors;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1224712461, i19, i17, "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:527)");
                                }
                                int i27 = i17;
                                int i28 = i19 << 3;
                                int i29 = i19 >> 9;
                                int i30 = i27 << 21;
                                Composer composer4 = composer2;
                                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, innerTextField, visualTransformation, function28, function29, function210, function211, function212, z2, z, z4, interactionSource, paddingValues2, textFieldColors2, function2ComposableLambda, composer4, (i28 & 896) | (i28 & 112) | 6 | ((i19 >> 3) & 7168) | (i29 & 57344) | (i29 & 458752) | (i29 & 3670016) | (i30 & 29360128) | (i30 & 234881024) | ((i19 << 18) & 1879048192), ((i19 >> 15) & 112) | ((i19 >> 6) & 14) | (i29 & 896) | ((i27 >> 3) & 7168) | ((i27 << 3) & 57344) | (i27 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function213 = function28;
                                function214 = function29;
                                function215 = function211;
                                function216 = function2ComposableLambda;
                                composer3 = composer4;
                                paddingValues3 = paddingValues2;
                                textFieldColors3 = textFieldColors2;
                                shape4 = shape3;
                                function217 = function212;
                                z5 = z4;
                                function218 = function210;
                            }
                            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer5, int i31) {
                                    TextFieldDefaults.this.TextFieldDecorationBox(value, innerTextField, z, z2, visualTransformation, interactionSource, z5, function213, function214, function218, function215, function217, shape4, textFieldColors3, paddingValues3, function216, composer5, i | 1, i2, i4);
                                }
                            });
                            return;
                        }
                        i13 |= i20;
                        i17 = i13;
                        if ((i11 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i10 == 0) {
                                }
                                if (i12 == 0) {
                                }
                                if (i15 == 0) {
                                }
                                if ((i4 & 4096) == 0) {
                                }
                                if ((i4 & 8192) == 0) {
                                }
                                if ((i4 & 16384) == 0) {
                                }
                                if (i16 == 0) {
                                }
                                function28 = function219;
                                function29 = function220;
                                function210 = function221;
                                function211 = function222;
                                function212 = function223;
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i272 = i17;
                                int i282 = i19 << 3;
                                int i292 = i19 >> 9;
                                int i302 = i272 << 21;
                                Composer composer42 = composer2;
                                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, innerTextField, visualTransformation, function28, function29, function210, function211, function212, z2, z, z4, interactionSource, paddingValues2, textFieldColors2, function2ComposableLambda, composer42, (i282 & 896) | (i282 & 112) | 6 | ((i19 >> 3) & 7168) | (i292 & 57344) | (i292 & 458752) | (i292 & 3670016) | (i302 & 29360128) | (i302 & 234881024) | ((i19 << 18) & 1879048192), ((i19 >> 15) & 112) | ((i19 >> 6) & 14) | (i292 & 896) | ((i272 >> 3) & 7168) | ((i272 << 3) & 57344) | (i272 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function213 = function28;
                                function214 = function29;
                                function215 = function211;
                                function216 = function2ComposableLambda;
                                composer3 = composer42;
                                paddingValues3 = paddingValues2;
                                textFieldColors3 = textFieldColors2;
                                shape4 = shape3;
                                function217 = function212;
                                z5 = z4;
                                function218 = function210;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i15 = i14;
                    if ((i2 & 896) == 0) {
                    }
                    if ((i2 & 7168) == 0) {
                    }
                    if ((i2 & 57344) == 0) {
                    }
                    i16 = i4 & 32768;
                    if (i16 != 0) {
                    }
                    if ((i4 & 65536) == 0) {
                    }
                    i13 |= i20;
                    i17 = i13;
                    if ((i11 & 1533916891) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i5 |= i21;
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
                i14 = i4 & 2048;
                if (i14 == 0) {
                }
                i15 = i14;
                if ((i2 & 896) == 0) {
                }
                if ((i2 & 7168) == 0) {
                }
                if ((i2 & 57344) == 0) {
                }
                i16 = i4 & 32768;
                if (i16 != 0) {
                }
                if ((i4 & 65536) == 0) {
                }
                i13 |= i20;
                i17 = i13;
                if ((i11 & 1533916891) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            int i232 = 8192;
            if ((i4 & 16) != 0) {
            }
            if ((i4 & 32) == 0) {
            }
            i5 |= i21;
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
            i14 = i4 & 2048;
            if (i14 == 0) {
            }
            i15 = i14;
            if ((i2 & 896) == 0) {
            }
            if ((i2 & 7168) == 0) {
            }
            if ((i2 & 57344) == 0) {
            }
            i16 = i4 & 32768;
            if (i16 != 0) {
            }
            if ((i4 & 65536) == 0) {
            }
            i13 |= i20;
            i17 = i13;
            if ((i11 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        int i222 = 1024;
        if ((i4 & 8) == 0) {
        }
        int i2322 = 8192;
        if ((i4 & 16) != 0) {
        }
        if ((i4 & 32) == 0) {
        }
        i5 |= i21;
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
        i14 = i4 & 2048;
        if (i14 == 0) {
        }
        i15 = i14;
        if ((i2 & 896) == 0) {
        }
        if ((i2 & 7168) == 0) {
        }
        if ((i2 & 57344) == 0) {
        }
        i16 = i4 & 32768;
        if (i16 != 0) {
        }
        if ((i4 & 65536) == 0) {
        }
        i13 |= i20;
        i17 = i13;
        if ((i11 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    @JvmName(name = "getFilledShape")
    @NotNull
    public final Shape getFilledShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(611926497);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:62)");
        }
        Shape shape = ShapesKt.toShape(FilledTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m17372getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m17373getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m17374getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    @JvmName(name = "getOutlinedShape")
    @NotNull
    public final Shape getOutlinedShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-584749279);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:59)");
        }
        Shape shape = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m17375getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    @ExperimentalMaterial3Api
    @NotNull
    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m17376indicatorLinegv0btCI(@NotNull Modifier indicatorLine, final boolean z, final boolean z2, @NotNull final InteractionSource interactionSource, @NotNull final TextFieldColors colors, final float f, final float f4) {
        Intrinsics.checkNotNullParameter(indicatorLine, "$this$indicatorLine");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return ComposedModifierKt.composed(indicatorLine, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine$2
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
                composer.startReplaceableGroup(-891038934);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891038934, i, -1, "androidx.compose.material3.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:146)");
                }
                Modifier modifierDrawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) TextFieldDefaultsKt.m17384animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, colors, f, f4, composer, 0).getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return modifierDrawIndicatorLine;
            }
        });
    }

    @Composable
    @ExperimentalMaterial3Api
    @NotNull
    /* JADX INFO: renamed from: outlinedTextFieldColors-l59Burw, reason: not valid java name */
    public final TextFieldColors m17377outlinedTextFieldColorsl59Burw(long j, long j2, long j3, long j5, long j6, @Nullable TextSelectionColors textSelectionColors, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, @Nullable Composer composer, int i, int i2, int i4, int i5) {
        composer.startReplaceableGroup(-1654658683);
        long color = (i5 & 1) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputColor(), composer, 6) : j;
        long jM18524copywmQWz5c$default = (i5 & 2) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM18560getTransparent0d7_KjU = (i5 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long color2 = (i5 & 8) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j5;
        long color3 = (i5 & 16) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer, 6) : j6;
        TextSelectionColors textSelectionColors2 = (i5 & 32) != 0 ? (TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors()) : textSelectionColors;
        long color4 = (i5 & 64) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor(), composer, 6) : j7;
        long color5 = (i5 & 128) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getOutlineColor(), composer, 6) : j8;
        long jM18524copywmQWz5c$default2 = (i5 & 256) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long color6 = (i5 & 512) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor(), composer, 6) : j10;
        long color7 = (i5 & 1024) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer, 6) : j11;
        long color8 = (i5 & 2048) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j12;
        long jM18524copywmQWz5c$default3 = (i5 & 4096) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long color9 = (i5 & 8192) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer, 6) : j14;
        long color10 = (i5 & 16384) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer, 6) : j15;
        long color11 = (32768 & i5) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j16;
        long jM18524copywmQWz5c$default4 = (65536 & i5) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long color12 = (131072 & i5) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer, 6) : j18;
        long color13 = (262144 & i5) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor(), composer, 6) : j19;
        long color14 = (524288 & i5) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLabelColor(), composer, 6) : j20;
        long jM18524copywmQWz5c$default5 = (1048576 & i5) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j21;
        long color15 = (2097152 & i5) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor(), composer, 6) : j22;
        long color16 = (4194304 & i5) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, 6) : j23;
        long jM18524copywmQWz5c$default6 = (8388608 & i5) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j24;
        long color17 = (16777216 & i5) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer, 6) : j25;
        long color18 = (33554432 & i5) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getSupportingColor(), composer, 6) : j26;
        long jM18524copywmQWz5c$default7 = (67108864 & i5) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j27;
        long color19 = (i5 & 134217728) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer, 6) : j28;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1654658683, i, i2, "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:399)");
        }
        TextFieldColors textFieldColors = new TextFieldColors(color, jM18524copywmQWz5c$default, jM18560getTransparent0d7_KjU, color2, color3, textSelectionColors2, color4, color5, color6, jM18524copywmQWz5c$default2, color7, color8, jM18524copywmQWz5c$default3, color9, color10, color11, jM18524copywmQWz5c$default4, color12, color13, color14, jM18524copywmQWz5c$default5, color15, color16, jM18524copywmQWz5c$default6, color17, color18, jM18524copywmQWz5c$default7, color19, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textFieldColors;
    }

    @ExperimentalMaterial3Api
    @NotNull
    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m17378outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m15850PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    @ExperimentalMaterial3Api
    @NotNull
    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3_release, reason: not valid java name */
    public final PaddingValues m17379supportingTextPaddinga9UjIt4$material3_release(float start, float top, float end, float bottom) {
        return PaddingKt.m15850PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    @Composable
    @ExperimentalMaterial3Api
    @NotNull
    /* JADX INFO: renamed from: textFieldColors-l59Burw, reason: not valid java name */
    public final TextFieldColors m17380textFieldColorsl59Burw(long j, long j2, long j3, long j5, long j6, @Nullable TextSelectionColors textSelectionColors, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, @Nullable Composer composer, int i, int i2, int i4, int i5) {
        composer.startReplaceableGroup(-128842621);
        long color = (i5 & 1) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputColor(), composer, 6) : j;
        long jM18524copywmQWz5c$default = (i5 & 2) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long color2 = (i5 & 4) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getContainerColor(), composer, 6) : j3;
        long color3 = (i5 & 8) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j5;
        long color4 = (i5 & 16) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer, 6) : j6;
        TextSelectionColors textSelectionColors2 = (i5 & 32) != 0 ? (TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors()) : textSelectionColors;
        long color5 = (i5 & 64) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor(), composer, 6) : j7;
        long color6 = (i5 & 128) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor(), composer, 6) : j8;
        long jM18524copywmQWz5c$default2 = (i5 & 256) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long color7 = (i5 & 512) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor(), composer, 6) : j10;
        long color8 = (i5 & 1024) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer, 6) : j11;
        long color9 = (i5 & 2048) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j12;
        long jM18524copywmQWz5c$default3 = (i5 & 4096) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long color10 = (i5 & 8192) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer, 6) : j14;
        long color11 = (i5 & 16384) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer, 6) : j15;
        long color12 = (32768 & i5) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j16;
        long jM18524copywmQWz5c$default4 = (65536 & i5) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long color13 = (131072 & i5) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer, 6) : j18;
        long color14 = (262144 & i5) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusLabelColor(), composer, 6) : j19;
        long color15 = (524288 & i5) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getLabelColor(), composer, 6) : j20;
        long jM18524copywmQWz5c$default5 = (1048576 & i5) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j21;
        long color16 = (2097152 & i5) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorLabelColor(), composer, 6) : j22;
        long color17 = (4194304 & i5) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, 6) : j23;
        long jM18524copywmQWz5c$default6 = (8388608 & i5) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j24;
        long color18 = (16777216 & i5) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer, 6) : j25;
        long color19 = (33554432 & i5) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getSupportingColor(), composer, 6) : j26;
        long jM18524copywmQWz5c$default7 = (67108864 & i5) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j27;
        long color20 = (i5 & 134217728) != 0 ? ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer, 6) : j28;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-128842621, i, i2, "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:292)");
        }
        TextFieldColors textFieldColors = new TextFieldColors(color, jM18524copywmQWz5c$default, color2, color3, color4, textSelectionColors2, color5, color6, color7, jM18524copywmQWz5c$default2, color8, color9, jM18524copywmQWz5c$default3, color10, color11, color12, jM18524copywmQWz5c$default4, color13, color14, color15, jM18524copywmQWz5c$default5, color16, color17, jM18524copywmQWz5c$default6, color18, color19, jM18524copywmQWz5c$default7, color20, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textFieldColors;
    }

    @ExperimentalMaterial3Api
    @NotNull
    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m17381textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m15850PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    @ExperimentalMaterial3Api
    @NotNull
    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m17382textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m15850PaddingValuesa9UjIt4(start, top, end, bottom);
    }
}
