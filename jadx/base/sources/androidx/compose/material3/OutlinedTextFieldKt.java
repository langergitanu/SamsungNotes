package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.DrawModifierKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.ClipOp;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.text.input.TextFieldValue;
import androidx.compose.p109ui.text.input.VisualTransformation;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.p109ui.text.style.BaselineShift;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextDirection;
import androidx.compose.p109ui.text.style.TextGeometricTransform;
import androidx.compose.p109ui.text.style.TextIndent;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u009e\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010*\u001a\u009e\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020+2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010,\u001aÙ\u0001\u0010-\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0019\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u00152\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010!\u001a\u00020\u000f2\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00070\u000b2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0013\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0002\u00109\u001a]\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u0002022\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a]\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u0002022\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a)\u0010O\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u0002042\u0006\u00107\u001a\u000208H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a\u0086\u0001\u0010S\u001a\u00020\u0007*\u00020T2\u0006\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020#2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010X2\u0006\u0010Z\u001a\u00020X2\b\u0010[\u001a\u0004\u0018\u00010X2\b\u0010\\\u001a\u0004\u0018\u00010X2\u0006\u0010]\u001a\u00020X2\b\u0010^\u001a\u0004\u0018\u00010X2\u0006\u00101\u001a\u0002022\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010C\u001a\u0002022\u0006\u0010_\u001a\u00020`2\u0006\u00107\u001a\u000208H\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006a"}, m13886d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "supportingPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IIIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "isLabelInMiddleSection", "calculateWidth-O3s9Psw", "(IIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", ServerResultMeetingParser.PLACE, "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = C2256Dp.m20968constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = C2256Dp.m20968constructorimpl(8);

    /* JADX WARN: Removed duplicated region for block: B:108:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0585 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013a  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(@NotNull final String value, @NotNull final Function1<? super String, Unit> onValueChange, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable TextStyle textStyle, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, boolean z3, @Nullable VisualTransformation visualTransformation, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActions keyboardActions, boolean z4, int i, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, @Nullable TextFieldColors textFieldColors, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        final boolean z5;
        int i8;
        final boolean z6;
        TextStyle textStyle2;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        TextStyle textStyle3;
        VisualTransformation none;
        int i24;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        MutableInteractionSource mutableInteractionSource2;
        Shape outlinedShape;
        Composer composer2;
        final TextFieldColors textFieldColorsM17377outlinedTextFieldColorsl59Burw;
        final KeyboardOptions keyboardOptions3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        TextStyle textStyle4;
        int i25;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final boolean z7;
        final KeyboardActions keyboardActions3;
        final boolean z8;
        final int i26;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape2;
        final int i27;
        long jM20486getColor0d7_KjU;
        final boolean z9;
        final boolean z10;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z11;
        final VisualTransformation visualTransformation2;
        final KeyboardActions keyboardActions4;
        Composer composer3;
        final boolean z12;
        final int i28;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Shape shape3;
        final TextStyle textStyle5;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final TextFieldColors textFieldColors2;
        final KeyboardOptions keyboardOptions4;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(534493230);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i6 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i2;
        } else {
            i6 = i2;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i2 & 112) == 0) {
            i6 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        int i29 = i5 & 4;
        if (i29 != 0) {
            i6 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            int i30 = 1024;
            if (i7 == 0) {
                i6 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z5 = z;
                    i6 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                int i31 = 8192;
                if (i8 != 0) {
                    i6 |= 24576;
                    z6 = z2;
                } else {
                    z6 = z2;
                    if ((i2 & 57344) == 0) {
                        i6 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
                    }
                }
                if ((i2 & 458752) == 0) {
                    textStyle2 = textStyle;
                    i6 |= ((i5 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                } else {
                    textStyle2 = textStyle;
                }
                i9 = i5 & 64;
                if (i9 != 0) {
                    i6 |= 1572864;
                    function26 = function2;
                } else {
                    function26 = function2;
                    if ((i2 & 3670016) == 0) {
                        i6 |= composerStartRestartGroup.changed(function26) ? 1048576 : 524288;
                    }
                }
                i10 = i5 & 128;
                if (i10 != 0) {
                    i6 |= 12582912;
                    function27 = function22;
                } else {
                    function27 = function22;
                    if ((i2 & 29360128) == 0) {
                        i6 |= composerStartRestartGroup.changed(function27) ? 8388608 : 4194304;
                    }
                }
                i11 = i5 & 256;
                if (i11 != 0) {
                    i6 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    i6 |= composerStartRestartGroup.changed(function23) ? 67108864 : 33554432;
                }
                i12 = i5 & 512;
                if (i12 != 0) {
                    i6 |= DriveFile.MODE_READ_WRITE;
                } else {
                    if ((i2 & 1879048192) == 0) {
                        i13 = i12;
                        i6 |= composerStartRestartGroup.changed(function24) ? 536870912 : 268435456;
                    }
                    i14 = i5 & 1024;
                    if (i14 == 0) {
                        i16 = i4 | 6;
                        i15 = i14;
                    } else if ((i4 & 14) == 0) {
                        i15 = i14;
                        i16 = i4 | (composerStartRestartGroup.changed(function25) ? 4 : 2);
                    } else {
                        i15 = i14;
                        i16 = i4;
                    }
                    i17 = i5 & 2048;
                    if (i17 == 0) {
                        i16 |= 48;
                        i18 = i17;
                    } else if ((i4 & 112) == 0) {
                        i18 = i17;
                        i16 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
                    } else {
                        i18 = i17;
                    }
                    int i32 = i16;
                    i19 = i5 & 4096;
                    if (i19 != 0) {
                        i20 = i32;
                        if ((i4 & 896) == 0) {
                            i20 |= composerStartRestartGroup.changed(visualTransformation) ? 256 : 128;
                        }
                        if ((i4 & 7168) == 0) {
                            if ((i5 & 8192) == 0 && composerStartRestartGroup.changed(keyboardOptions)) {
                                i30 = 2048;
                            }
                            i20 |= i30;
                        }
                        if ((i4 & 57344) == 0) {
                            if ((i5 & 16384) == 0 && composerStartRestartGroup.changed(keyboardActions)) {
                                i31 = 16384;
                            }
                            i20 |= i31;
                        }
                        i21 = i5 & 32768;
                        if (i21 != 0) {
                            i20 |= 196608;
                        } else if ((i4 & 458752) == 0) {
                            i20 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                        }
                        i22 = i5 & 65536;
                        if (i22 != 0) {
                            i20 |= 1572864;
                        } else if ((i4 & 3670016) == 0) {
                            i20 |= composerStartRestartGroup.changed(i) ? 1048576 : 524288;
                        }
                        i23 = i5 & 131072;
                        if (i23 != 0) {
                            i20 |= 12582912;
                        } else if ((i4 & 29360128) == 0) {
                            i20 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                        }
                        if ((i4 & 234881024) == 0) {
                            i20 |= ((i5 & 262144) == 0 && composerStartRestartGroup.changed(shape)) ? 67108864 : 33554432;
                        }
                        if ((i4 & 1879048192) == 0) {
                            i20 |= ((i5 & 524288) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 536870912 : 268435456;
                        }
                        int i33 = i20;
                        if ((i6 & 1533916891) == 306783378 && (1533916891 & i33) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function215 = function24;
                            visualTransformation2 = visualTransformation;
                            z11 = z4;
                            i28 = i;
                            mutableInteractionSource4 = mutableInteractionSource;
                            shape3 = shape;
                            textFieldColors2 = textFieldColors;
                            composer3 = composerStartRestartGroup;
                            z10 = z5;
                            z12 = z6;
                            textStyle5 = textStyle2;
                            function216 = function26;
                            function213 = function27;
                            modifier3 = modifier2;
                            function214 = function23;
                            function217 = function25;
                            z9 = z3;
                            keyboardOptions4 = keyboardOptions;
                            keyboardActions4 = keyboardActions;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i29 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z13 = i7 == 0 ? true : z5;
                                boolean z14 = i8 == 0 ? false : z6;
                                if ((i5 & 32) == 0) {
                                    i6 &= -458753;
                                    textStyle3 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                                } else {
                                    textStyle3 = textStyle2;
                                }
                                int i34 = i6;
                                Function2<? super Composer, ? super Integer, Unit> function218 = i9 == 0 ? null : function26;
                                Function2<? super Composer, ? super Integer, Unit> function219 = i10 == 0 ? null : function27;
                                Function2<? super Composer, ? super Integer, Unit> function220 = i11 == 0 ? null : function23;
                                Function2<? super Composer, ? super Integer, Unit> function221 = i13 == 0 ? null : function24;
                                Function2<? super Composer, ? super Integer, Unit> function222 = i15 == 0 ? null : function25;
                                boolean z15 = i18 == 0 ? false : z3;
                                none = i19 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                if ((i5 & 8192) == 0) {
                                    i24 = i33 & (-7169);
                                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                } else {
                                    i24 = i33;
                                    keyboardOptions2 = keyboardOptions;
                                }
                                if ((i5 & 16384) == 0) {
                                    i24 &= -57345;
                                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                                } else {
                                    keyboardActions2 = keyboardActions;
                                }
                                boolean z16 = i21 == 0 ? false : z4;
                                int i35 = i22 == 0 ? Integer.MAX_VALUE : i;
                                if (i23 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                if ((i5 & 262144) == 0) {
                                    i24 &= -234881025;
                                    outlinedShape = TextFieldDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                                } else {
                                    outlinedShape = shape;
                                }
                                int i36 = i24;
                                if ((i5 & 524288) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    keyboardOptions3 = keyboardOptions2;
                                    modifier2 = modifier4;
                                    function28 = function220;
                                    textFieldColorsM17377outlinedTextFieldColorsl59Burw = TextFieldDefaults.INSTANCE.m17377outlinedTextFieldColorsl59Burw(0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 100663296, 268435455);
                                    i27 = i36 & (-1879048193);
                                    z5 = z13;
                                    z6 = z14;
                                    textStyle4 = textStyle3;
                                    i25 = i34;
                                    function29 = function218;
                                    function210 = function219;
                                    function211 = function221;
                                    function212 = function222;
                                    z7 = z15;
                                    keyboardActions3 = keyboardActions2;
                                    z8 = z16;
                                    i26 = i35;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    shape2 = outlinedShape;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    textFieldColorsM17377outlinedTextFieldColorsl59Burw = textFieldColors;
                                    keyboardOptions3 = keyboardOptions2;
                                    modifier2 = modifier4;
                                    function28 = function220;
                                    z5 = z13;
                                    z6 = z14;
                                    textStyle4 = textStyle3;
                                    i25 = i34;
                                    function29 = function218;
                                    function210 = function219;
                                    function211 = function221;
                                    function212 = function222;
                                    z7 = z15;
                                    keyboardActions3 = keyboardActions2;
                                    z8 = z16;
                                    i26 = i35;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    shape2 = outlinedShape;
                                    i27 = i36;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i5 & 32) != 0) {
                                    i6 &= -458753;
                                }
                                if ((i5 & 8192) != 0) {
                                    i33 &= -7169;
                                }
                                if ((i5 & 16384) != 0) {
                                    i33 &= -57345;
                                }
                                if ((i5 & 262144) != 0) {
                                    i33 &= -234881025;
                                }
                                if ((i5 & 524288) != 0) {
                                    i33 &= -1879048193;
                                }
                                int i37 = i6;
                                composer2 = composerStartRestartGroup;
                                i25 = i37;
                                function28 = function23;
                                function211 = function24;
                                function212 = function25;
                                z7 = z3;
                                none = visualTransformation;
                                z8 = z4;
                                mutableInteractionSource3 = mutableInteractionSource;
                                shape2 = shape;
                                textFieldColorsM17377outlinedTextFieldColorsl59Burw = textFieldColors;
                                i27 = i33;
                                textStyle4 = textStyle2;
                                function29 = function26;
                                function210 = function27;
                                keyboardOptions3 = keyboardOptions;
                                keyboardActions3 = keyboardActions;
                                i26 = i;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(534493230, i25, i27, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:132)");
                            }
                            composer2.startReplaceableGroup(1663535219);
                            jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                            if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                jM20486getColor0d7_KjU = textFieldColorsM17377outlinedTextFieldColorsl59Burw.textColor$material3_release(z5, composer2, ((i25 >> 9) & 14) | ((i27 >> 24) & 112)).getValue().m18535unboximpl();
                            }
                            long j = jM20486getColor0d7_KjU;
                            composer2.endReplaceableGroup();
                            final TextStyle textStyleMerge = textStyle4.merge(new TextStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                            TextStyle textStyle6 = textStyle4;
                            final int i38 = i25;
                            Composer composer4 = composer2;
                            final Modifier modifier5 = modifier2;
                            final VisualTransformation visualTransformation3 = none;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColorsM17377outlinedTextFieldColorsl59Burw.getSelectionColors(composer2, (i27 >> 27) & 14))}, ComposableLambdaKt.composableLambda(composer4, -1801753362, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i39) {
                                    if ((i39 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1801753362, i39, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:160)");
                                    }
                                    Modifier modifierM15858paddingqDBjuR0$default = function29 != null ? PaddingKt.m15858paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier5, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null) : modifier5;
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(modifierM15858paddingqDBjuR0$default, textFieldDefaults.m17374getMinWidthD9Ej5fM(), textFieldDefaults.m17373getMinHeightD9Ej5fM());
                                    TextFieldColors textFieldColors3 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                    boolean z17 = z7;
                                    int i40 = i27;
                                    SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor$material3_release(z17, composer5, ((i40 >> 24) & 112) | ((i40 >> 3) & 14)).getValue().m18535unboximpl(), null);
                                    final String str = value;
                                    Function1<String, Unit> function1 = onValueChange;
                                    final boolean z18 = z5;
                                    boolean z19 = z6;
                                    TextStyle textStyle7 = textStyleMerge;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    KeyboardActions keyboardActions5 = keyboardActions3;
                                    final boolean z20 = z8;
                                    int i41 = i26;
                                    final VisualTransformation visualTransformation4 = visualTransformation3;
                                    final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                    final boolean z21 = z7;
                                    final Function2<Composer, Integer, Unit> function223 = function29;
                                    final Function2<Composer, Integer, Unit> function224 = function210;
                                    final Function2<Composer, Integer, Unit> function225 = function28;
                                    final Function2<Composer, Integer, Unit> function226 = function211;
                                    final Function2<Composer, Integer, Unit> function227 = function212;
                                    final TextFieldColors textFieldColors4 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                    final int i42 = i38;
                                    final int i43 = i27;
                                    final Shape shape4 = shape2;
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, 794931831, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function228, Composer composer6, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function228, composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                         */
                                        @Composable
                                        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                                        public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> innerTextField, @Nullable Composer composer6, int i44) {
                                            int i45;
                                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                            if ((i44 & 14) == 0) {
                                                i45 = i44 | (composer6.changed(innerTextField) ? 4 : 2);
                                            } else {
                                                i45 = i44;
                                            }
                                            if ((i45 & 91) == 18 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(794931831, i45, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:188)");
                                            }
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            int i46 = i45;
                                            String str2 = str;
                                            final boolean z22 = z18;
                                            boolean z23 = z20;
                                            VisualTransformation visualTransformation5 = visualTransformation4;
                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                            final boolean z24 = z21;
                                            Function2<Composer, Integer, Unit> function228 = function223;
                                            Function2<Composer, Integer, Unit> function229 = function224;
                                            Function2<Composer, Integer, Unit> function230 = function225;
                                            Function2<Composer, Integer, Unit> function231 = function226;
                                            Function2<Composer, Integer, Unit> function232 = function227;
                                            final TextFieldColors textFieldColors5 = textFieldColors4;
                                            final Shape shape5 = shape4;
                                            final int i47 = i42;
                                            final int i48 = i43;
                                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer6, -839984881, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                    invoke(composer7, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer7, int i49) {
                                                    if ((i49 & 11) == 2 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-839984881, i49, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:203)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults3 = TextFieldDefaults.INSTANCE;
                                                    boolean z25 = z22;
                                                    boolean z26 = z24;
                                                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                                    TextFieldColors textFieldColors6 = textFieldColors5;
                                                    Shape shape6 = shape5;
                                                    int i50 = ((i47 >> 9) & 14) | 12582912;
                                                    int i51 = i48;
                                                    textFieldDefaults3.m17371OutlinedBorderContainerBoxnbWgWpA(z25, z26, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer7, i50 | (i51 & 112) | ((i51 >> 15) & 896) | ((i51 >> 18) & 7168) | ((i51 >> 12) & 57344), 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i49 = i42;
                                            int i50 = i43;
                                            textFieldDefaults2.OutlinedTextFieldDecorationBox(str2, innerTextField, z22, z23, visualTransformation5, mutableInteractionSource6, z24, function228, function229, function230, function231, function232, textFieldColors5, null, composableLambda2, composer6, (i49 & 14) | ((i46 << 3) & 112) | ((i49 >> 3) & 896) | ((i50 >> 6) & 7168) | ((i50 << 6) & 57344) | ((i50 >> 6) & 458752) | ((i50 << 15) & 3670016) | ((i49 << 3) & 29360128) | ((i49 << 3) & 234881024) | ((i49 << 3) & 1879048192), ((i49 >> 27) & 14) | 221184 | ((i50 << 3) & 112) | ((i50 >> 21) & 896), 8192);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    int i44 = i38 & 64638;
                                    int i45 = i27;
                                    BasicTextFieldKt.BasicTextField(str, function1, modifierM15883defaultMinSizeVpY3zN4, z18, z19, textStyle7, keyboardOptions5, keyboardActions5, z20, i41, visualTransformation4, (Function1) null, mutableInteractionSource5, solidColor, composableLambda, composer5, i44 | ((i45 << 9) & 3670016) | (KeyboardActions.$stable << 21) | ((i45 << 9) & 29360128) | ((i45 << 9) & 234881024) | (1879048192 & (i45 << 9)), ((i45 >> 15) & 896) | ((i45 >> 6) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer4, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            KeyboardActions keyboardActions5 = keyboardActions3;
                            z9 = z7;
                            z10 = z5;
                            function213 = function210;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z11 = z8;
                            visualTransformation2 = visualTransformation3;
                            keyboardActions4 = keyboardActions5;
                            composer3 = composer4;
                            z12 = z6;
                            i28 = i26;
                            function214 = function28;
                            function215 = function211;
                            shape3 = shape2;
                            textStyle5 = textStyle6;
                            function216 = function29;
                            textFieldColors2 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                            keyboardOptions4 = keyboardOptions3;
                            function217 = function212;
                            modifier3 = modifier5;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.3
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

                            public final void invoke(@Nullable Composer composer5, int i39) {
                                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z10, z12, textStyle5, function216, function213, function214, function215, function217, z9, visualTransformation2, keyboardOptions4, keyboardActions4, z11, i28, mutableInteractionSource4, shape3, textFieldColors2, composer5, i2 | 1, i4, i5);
                            }
                        });
                        return;
                    }
                    i20 = i32 | 384;
                    if ((i4 & 7168) == 0) {
                    }
                    if ((i4 & 57344) == 0) {
                    }
                    i21 = i5 & 32768;
                    if (i21 != 0) {
                    }
                    i22 = i5 & 65536;
                    if (i22 != 0) {
                    }
                    i23 = i5 & 131072;
                    if (i23 != 0) {
                    }
                    if ((i4 & 234881024) == 0) {
                    }
                    if ((i4 & 1879048192) == 0) {
                    }
                    int i332 = i20;
                    if ((i6 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i29 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 == 0) {
                            }
                            if ((i5 & 32) == 0) {
                            }
                            int i342 = i6;
                            if (i9 == 0) {
                            }
                            if (i10 == 0) {
                            }
                            if (i11 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i19 == 0) {
                            }
                            if ((i5 & 8192) == 0) {
                            }
                            if ((i5 & 16384) == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i23 == 0) {
                            }
                            if ((i5 & 262144) == 0) {
                            }
                            int i362 = i24;
                            if ((i5 & 524288) == 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2.startReplaceableGroup(1663535219);
                            jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                            if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                            }
                            long j2 = jM20486getColor0d7_KjU;
                            composer2.endReplaceableGroup();
                            final TextStyle textStyleMerge2 = textStyle4.merge(new TextStyle(j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                            TextStyle textStyle62 = textStyle4;
                            final int i382 = i25;
                            Composer composer42 = composer2;
                            final Modifier modifier52 = modifier2;
                            final VisualTransformation visualTransformation32 = none;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColorsM17377outlinedTextFieldColorsl59Burw.getSelectionColors(composer2, (i27 >> 27) & 14))}, ComposableLambdaKt.composableLambda(composer42, -1801753362, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i39) {
                                    if ((i39 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1801753362, i39, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:160)");
                                    }
                                    Modifier modifierM15858paddingqDBjuR0$default = function29 != null ? PaddingKt.m15858paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier52, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null) : modifier52;
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(modifierM15858paddingqDBjuR0$default, textFieldDefaults.m17374getMinWidthD9Ej5fM(), textFieldDefaults.m17373getMinHeightD9Ej5fM());
                                    TextFieldColors textFieldColors3 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                    boolean z17 = z7;
                                    int i40 = i27;
                                    SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor$material3_release(z17, composer5, ((i40 >> 24) & 112) | ((i40 >> 3) & 14)).getValue().m18535unboximpl(), null);
                                    final String str = value;
                                    Function1<String, Unit> function1 = onValueChange;
                                    final boolean z18 = z5;
                                    boolean z19 = z6;
                                    TextStyle textStyle7 = textStyleMerge2;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    KeyboardActions keyboardActions52 = keyboardActions3;
                                    final boolean z20 = z8;
                                    int i41 = i26;
                                    final VisualTransformation visualTransformation4 = visualTransformation32;
                                    final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                    final boolean z21 = z7;
                                    final Function2<? super Composer, ? super Integer, Unit> function223 = function29;
                                    final Function2<? super Composer, ? super Integer, Unit> function224 = function210;
                                    final Function2<? super Composer, ? super Integer, Unit> function225 = function28;
                                    final Function2<? super Composer, ? super Integer, Unit> function226 = function211;
                                    final Function2<? super Composer, ? super Integer, Unit> function227 = function212;
                                    final TextFieldColors textFieldColors4 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                    final int i42 = i382;
                                    final int i43 = i27;
                                    final Shape shape4 = shape2;
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, 794931831, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function228, Composer composer6, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function228, composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                         */
                                        @Composable
                                        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                                        public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> innerTextField, @Nullable Composer composer6, int i44) {
                                            int i45;
                                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                            if ((i44 & 14) == 0) {
                                                i45 = i44 | (composer6.changed(innerTextField) ? 4 : 2);
                                            } else {
                                                i45 = i44;
                                            }
                                            if ((i45 & 91) == 18 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(794931831, i45, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:188)");
                                            }
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            int i46 = i45;
                                            String str2 = str;
                                            final boolean z22 = z18;
                                            boolean z23 = z20;
                                            VisualTransformation visualTransformation5 = visualTransformation4;
                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                            final boolean z24 = z21;
                                            Function2<Composer, Integer, Unit> function228 = function223;
                                            Function2<Composer, Integer, Unit> function229 = function224;
                                            Function2<Composer, Integer, Unit> function230 = function225;
                                            Function2<Composer, Integer, Unit> function231 = function226;
                                            Function2<Composer, Integer, Unit> function232 = function227;
                                            final TextFieldColors textFieldColors5 = textFieldColors4;
                                            final Shape shape5 = shape4;
                                            final int i47 = i42;
                                            final int i48 = i43;
                                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer6, -839984881, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                    invoke(composer7, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer7, int i49) {
                                                    if ((i49 & 11) == 2 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-839984881, i49, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:203)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults3 = TextFieldDefaults.INSTANCE;
                                                    boolean z25 = z22;
                                                    boolean z26 = z24;
                                                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                                    TextFieldColors textFieldColors6 = textFieldColors5;
                                                    Shape shape6 = shape5;
                                                    int i50 = ((i47 >> 9) & 14) | 12582912;
                                                    int i51 = i48;
                                                    textFieldDefaults3.m17371OutlinedBorderContainerBoxnbWgWpA(z25, z26, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer7, i50 | (i51 & 112) | ((i51 >> 15) & 896) | ((i51 >> 18) & 7168) | ((i51 >> 12) & 57344), 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i49 = i42;
                                            int i50 = i43;
                                            textFieldDefaults2.OutlinedTextFieldDecorationBox(str2, innerTextField, z22, z23, visualTransformation5, mutableInteractionSource6, z24, function228, function229, function230, function231, function232, textFieldColors5, null, composableLambda2, composer6, (i49 & 14) | ((i46 << 3) & 112) | ((i49 >> 3) & 896) | ((i50 >> 6) & 7168) | ((i50 << 6) & 57344) | ((i50 >> 6) & 458752) | ((i50 << 15) & 3670016) | ((i49 << 3) & 29360128) | ((i49 << 3) & 234881024) | ((i49 << 3) & 1879048192), ((i49 >> 27) & 14) | 221184 | ((i50 << 3) & 112) | ((i50 >> 21) & 896), 8192);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    int i44 = i382 & 64638;
                                    int i45 = i27;
                                    BasicTextFieldKt.BasicTextField(str, function1, modifierM15883defaultMinSizeVpY3zN4, z18, z19, textStyle7, keyboardOptions5, keyboardActions52, z20, i41, visualTransformation4, (Function1) null, mutableInteractionSource5, solidColor, composableLambda, composer5, i44 | ((i45 << 9) & 3670016) | (KeyboardActions.$stable << 21) | ((i45 << 9) & 29360128) | ((i45 << 9) & 234881024) | (1879048192 & (i45 << 9)), ((i45 >> 15) & 896) | ((i45 >> 6) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer42, 56);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            KeyboardActions keyboardActions52 = keyboardActions3;
                            z9 = z7;
                            z10 = z5;
                            function213 = function210;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z11 = z8;
                            visualTransformation2 = visualTransformation32;
                            keyboardActions4 = keyboardActions52;
                            composer3 = composer42;
                            z12 = z6;
                            i28 = i26;
                            function214 = function28;
                            function215 = function211;
                            shape3 = shape2;
                            textStyle5 = textStyle62;
                            function216 = function29;
                            textFieldColors2 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                            keyboardOptions4 = keyboardOptions3;
                            function217 = function212;
                            modifier3 = modifier52;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i13 = i12;
                i14 = i5 & 1024;
                if (i14 == 0) {
                }
                i17 = i5 & 2048;
                if (i17 == 0) {
                }
                int i322 = i16;
                i19 = i5 & 4096;
                if (i19 != 0) {
                }
                if ((i4 & 7168) == 0) {
                }
                if ((i4 & 57344) == 0) {
                }
                i21 = i5 & 32768;
                if (i21 != 0) {
                }
                i22 = i5 & 65536;
                if (i22 != 0) {
                }
                i23 = i5 & 131072;
                if (i23 != 0) {
                }
                if ((i4 & 234881024) == 0) {
                }
                if ((i4 & 1879048192) == 0) {
                }
                int i3322 = i20;
                if ((i6 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z5 = z;
            i8 = i5 & 16;
            int i312 = 8192;
            if (i8 != 0) {
            }
            if ((i2 & 458752) == 0) {
            }
            i9 = i5 & 64;
            if (i9 != 0) {
            }
            i10 = i5 & 128;
            if (i10 != 0) {
            }
            i11 = i5 & 256;
            if (i11 != 0) {
            }
            i12 = i5 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i5 & 1024;
            if (i14 == 0) {
            }
            i17 = i5 & 2048;
            if (i17 == 0) {
            }
            int i3222 = i16;
            i19 = i5 & 4096;
            if (i19 != 0) {
            }
            if ((i4 & 7168) == 0) {
            }
            if ((i4 & 57344) == 0) {
            }
            i21 = i5 & 32768;
            if (i21 != 0) {
            }
            i22 = i5 & 65536;
            if (i22 != 0) {
            }
            i23 = i5 & 131072;
            if (i23 != 0) {
            }
            if ((i4 & 234881024) == 0) {
            }
            if ((i4 & 1879048192) == 0) {
            }
            int i33222 = i20;
            if ((i6 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        int i302 = 1024;
        if (i7 == 0) {
        }
        z5 = z;
        i8 = i5 & 16;
        int i3122 = 8192;
        if (i8 != 0) {
        }
        if ((i2 & 458752) == 0) {
        }
        i9 = i5 & 64;
        if (i9 != 0) {
        }
        i10 = i5 & 128;
        if (i10 != 0) {
        }
        i11 = i5 & 256;
        if (i11 != 0) {
        }
        i12 = i5 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i5 & 1024;
        if (i14 == 0) {
        }
        i17 = i5 & 2048;
        if (i17 == 0) {
        }
        int i32222 = i16;
        i19 = i5 & 4096;
        if (i19 != 0) {
        }
        if ((i4 & 7168) == 0) {
        }
        if ((i4 & 57344) == 0) {
        }
        i21 = i5 & 32768;
        if (i21 != 0) {
        }
        i22 = i5 & 65536;
        if (i22 != 0) {
        }
        i23 = i5 & 131072;
        if (i23 != 0) {
        }
        if ((i4 & 234881024) == 0) {
        }
        if ((i4 & 1879048192) == 0) {
        }
        int i332222 = i20;
        if ((i6 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void OutlinedTextFieldLayout(@NotNull final Modifier modifier, @NotNull final Function2<? super Composer, ? super Integer, Unit> textField, @Nullable final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable final Function2<? super Composer, ? super Integer, Unit> function23, final boolean z, final float f, @NotNull final Function1<? super Size, Unit> onLabelMeasured, @NotNull final Function2<? super Composer, ? super Integer, Unit> container, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @NotNull final PaddingValues paddingValues, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerStartRestartGroup = composer.startRestartGroup(-222199799);
        int i5 = (i & 14) == 0 ? i | (composerStartRestartGroup.changed(modifier) ? 4 : 2) : i;
        if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(function3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(function2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i5 |= composerStartRestartGroup.changed(function22) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i5 |= composerStartRestartGroup.changed(function23) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i5 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i5 |= composerStartRestartGroup.changed(onLabelMeasured) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i5 |= composerStartRestartGroup.changed(container) ? 536870912 : 268435456;
        }
        int i6 = i5;
        int i7 = (i2 & 14) == 0 ? i2 | (composerStartRestartGroup.changed(function24) ? 4 : 2) : i2;
        if ((i2 & 112) == 0) {
            i7 |= composerStartRestartGroup.changed(paddingValues) ? 32 : 16;
        }
        int i8 = i7;
        if ((i6 & 1533916891) == 306783378 && (i8 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function26 = function24;
            function25 = function2;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-222199799, i6, i8, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:377)");
            }
            Object[] objArr = {onLabelMeasured, Boolean.valueOf(z), Float.valueOf(f), paddingValues};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i9 = 0; i9 < 4; i9++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i9]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new OutlinedTextFieldMeasurePolicy(onLabelMeasured, z, f, paddingValues);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) objRememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, outlinedTextFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection2, companion.getSetLayoutDirection());
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-147819150);
            container.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 27) & 14));
            composerStartRestartGroup.startReplaceableGroup(1116449790);
            if (function22 != null) {
                Modifier modifierThen = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierThen);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(2127001777);
                AbstractC1038a.m1222w(composerStartRestartGroup, (i6 >> 12) & 14, function22);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1116450075);
            if (function23 != null) {
                Modifier modifierThen2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                Density density3 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierThen2);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-827051110);
                AbstractC1038a.m1222w(composerStartRestartGroup, (i6 >> 15) & 14, function23);
            }
            composerStartRestartGroup.endReplaceableGroup();
            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            if (function22 != null) {
                i4 = 0;
                fCalculateStartPadding = C2256Dp.m20968constructorimpl(RangesKt.coerceAtLeast(C2256Dp.m20968constructorimpl(fCalculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), C2256Dp.m20968constructorimpl(0)));
            } else {
                i4 = 0;
            }
            float f4 = fCalculateStartPadding;
            if (function23 != null) {
                fCalculateEndPadding = C2256Dp.m20968constructorimpl(RangesKt.coerceAtLeast(C2256Dp.m20968constructorimpl(fCalculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), C2256Dp.m20968constructorimpl(i4)));
            }
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion2, f4, 0.0f, fCalculateEndPadding, 0.0f, 10, null);
            composerStartRestartGroup.startReplaceableGroup(1116451086);
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(companion2, "Hint").then(modifierM15858paddingqDBjuR0$default), composerStartRestartGroup, Integer.valueOf((i6 >> 3) & 112));
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen3 = LayoutIdKt.layoutId(companion2, "TextField").then(modifierM15858paddingqDBjuR0$default);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, true, composerStartRestartGroup, 48, -1323940314);
            Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor4 = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierThen3);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl4, measurePolicyM1210k, composerM18018constructorimpl4, density4));
            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-475693524);
            textField.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1116451412);
            if (function2 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(companion2, "Label");
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
                Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor5 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierLayoutId);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection6, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl5, measurePolicyM1210k2, composerM18018constructorimpl5, density5));
                function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl5, viewConfiguration5, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, -1527117480);
                function25 = function2;
                AbstractC1038a.m1222w(composerStartRestartGroup, (i6 >> 9) & 14, function25);
            } else {
                function25 = function2;
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (function24 != null) {
                Modifier modifierPadding = PaddingKt.padding(LayoutIdKt.layoutId(companion2, TextFieldImplKt.SupportingId), TextFieldDefaults.m17368supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
                Density density6 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection7 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration6 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor6 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierPadding);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor6);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl6 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl6, layoutDirection7, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl6, measurePolicyM1210k3, composerM18018constructorimpl6, density6));
                function3MaterializerOf6.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl6, viewConfiguration6, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 270332983);
                function26 = function24;
                AbstractC1038a.m1222w(composerStartRestartGroup, i8 & 14, function26);
            } else {
                function26 = function24;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i10) {
                OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier, textField, function3, function27, function22, function23, z, f, onLabelMeasured, container, function26, paddingValues, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m17262calculateHeightO3s9Psw(int i, int i2, int i4, int i5, int i6, int i7, long j, float f, PaddingValues paddingValues) {
        int iMax = Math.max(i4, i6);
        return Math.max(Constraints.m20922getMinHeightimpl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(Math.max(paddingValues.getTop() * f, i5 / 2.0f) + iMax + (paddingValues.getBottom() * f)))) + i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m17263calculateWidthO3s9Psw(int i, int i2, int i4, int i5, int i6, boolean z, long j, float f, PaddingValues paddingValues) {
        int iRoundToInt = 0;
        int iMax = Math.max(i4, Math.max(z ? i5 : 0, i6)) + i + i2;
        if (!z) {
            LayoutDirection layoutDirection = LayoutDirection.Ltr;
            iRoundToInt = MathKt.roundToInt(C2256Dp.m20968constructorimpl(paddingValues.mo15806calculateRightPaddingu2uoSUM(layoutDirection) + paddingValues.mo15805calculateLeftPaddingu2uoSUM(layoutDirection)) * f) + i5;
        }
        return Math.max(iMax, Math.max(iRoundToInt, Constraints.m20923getMinWidthimpl(j)));
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }

    @NotNull
    /* JADX INFO: renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m17264outlineCutout12SF9DM(@NotNull Modifier outlineCutout, final long j, @NotNull final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$outlineCutout$1

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ContentDrawScope drawWithContent) {
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                float fM18353getWidthimpl = Size.m18353getWidthimpl(j);
                if (fM18353getWidthimpl <= 0.0f) {
                    drawWithContent.drawContent();
                    return;
                }
                float fMo15546toPx0680j_4 = drawWithContent.mo15546toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                float fMo15546toPx0680j_42 = drawWithContent.mo15546toPx0680j_4(paddingValues.mo15805calculateLeftPaddingu2uoSUM(drawWithContent.getLayoutDirection())) - fMo15546toPx0680j_4;
                float f = 2;
                float fM18353getWidthimpl2 = (fMo15546toPx0680j_4 * f) + fM18353getWidthimpl + fMo15546toPx0680j_42;
                LayoutDirection layoutDirection = drawWithContent.getLayoutDirection();
                int[] iArr = WhenMappings.$EnumSwitchMapping$0;
                float fM18353getWidthimpl3 = iArr[layoutDirection.ordinal()] == 1 ? Size.m18353getWidthimpl(drawWithContent.mo19076getSizeNHjbRc()) - fM18353getWidthimpl2 : RangesKt.coerceAtLeast(fMo15546toPx0680j_42, 0.0f);
                if (iArr[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                    fM18353getWidthimpl2 = Size.m18353getWidthimpl(drawWithContent.mo19076getSizeNHjbRc()) - RangesKt.coerceAtLeast(fMo15546toPx0680j_42, 0.0f);
                }
                float fM18350getHeightimpl = Size.m18350getHeightimpl(j);
                float f4 = (-fM18350getHeightimpl) / f;
                float f5 = fM18350getHeightimpl / f;
                int iM18513getDifferencertfAjoo = ClipOp.INSTANCE.m18513getDifferencertfAjoo();
                DrawContext drawContext = drawWithContent.getDrawContext();
                long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo19000clipRectN_I0leg(fM18353getWidthimpl3, f4, fM18353getWidthimpl2, f5, iM18513getDifferencertfAjoo);
                drawWithContent.drawContent();
                drawContext.getCanvas().restore();
                drawContext.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, float f, boolean z, float f4, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        Placeable.PlacementScope.m19919place70tqf50$default(placementScope, placeable6, IntOffset.INSTANCE.m21106getZeronOccac(), 0.0f, 2, null);
        int iHeightOrZero = i - TextFieldImplKt.heightOrZero(placeable7);
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f4);
        int iRoundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f4);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f4;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            float f5 = 1 - f;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, MathKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * f5) + iRoundToInt2, MathKt.roundToInt(((z ? Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), iHeightOrZero) : iRoundToInt) * f5) - ((placeable4.getHeight() / 2) * f)), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), Math.max(z ? Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), iHeightOrZero) : iRoundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        if (placeable5 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), iHeightOrZero);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable), iRoundToInt, 0.0f, 4, null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, 0, iHeightOrZero, 0.0f, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0585 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013a  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(@NotNull final TextFieldValue value, @NotNull final Function1<? super TextFieldValue, Unit> onValueChange, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable TextStyle textStyle, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, boolean z3, @Nullable VisualTransformation visualTransformation, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActions keyboardActions, boolean z4, int i, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, @Nullable TextFieldColors textFieldColors, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        final boolean z5;
        int i8;
        final boolean z6;
        TextStyle textStyle2;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        TextStyle textStyle3;
        VisualTransformation none;
        int i24;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        MutableInteractionSource mutableInteractionSource2;
        Shape outlinedShape;
        Composer composer2;
        final TextFieldColors textFieldColorsM17377outlinedTextFieldColorsl59Burw;
        final KeyboardOptions keyboardOptions3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        TextStyle textStyle4;
        int i25;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final boolean z7;
        final KeyboardActions keyboardActions3;
        final boolean z8;
        final int i26;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape2;
        final int i27;
        long jM20486getColor0d7_KjU;
        final boolean z9;
        final boolean z10;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z11;
        final VisualTransformation visualTransformation2;
        final KeyboardActions keyboardActions4;
        Composer composer3;
        final boolean z12;
        final int i28;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Shape shape3;
        final TextStyle textStyle5;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final TextFieldColors textFieldColors2;
        final KeyboardOptions keyboardOptions4;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(1040237435);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i6 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i2;
        } else {
            i6 = i2;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i2 & 112) == 0) {
            i6 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        int i29 = i5 & 4;
        if (i29 != 0) {
            i6 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            int i30 = 1024;
            if (i7 == 0) {
                i6 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z5 = z;
                    i6 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                int i31 = 8192;
                if (i8 != 0) {
                    i6 |= 24576;
                    z6 = z2;
                } else {
                    z6 = z2;
                    if ((i2 & 57344) == 0) {
                        i6 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
                    }
                }
                if ((i2 & 458752) == 0) {
                    textStyle2 = textStyle;
                    i6 |= ((i5 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                } else {
                    textStyle2 = textStyle;
                }
                i9 = i5 & 64;
                if (i9 != 0) {
                    i6 |= 1572864;
                    function26 = function2;
                } else {
                    function26 = function2;
                    if ((i2 & 3670016) == 0) {
                        i6 |= composerStartRestartGroup.changed(function26) ? 1048576 : 524288;
                    }
                }
                i10 = i5 & 128;
                if (i10 != 0) {
                    i6 |= 12582912;
                    function27 = function22;
                } else {
                    function27 = function22;
                    if ((i2 & 29360128) == 0) {
                        i6 |= composerStartRestartGroup.changed(function27) ? 8388608 : 4194304;
                    }
                }
                i11 = i5 & 256;
                if (i11 != 0) {
                    i6 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    i6 |= composerStartRestartGroup.changed(function23) ? 67108864 : 33554432;
                }
                i12 = i5 & 512;
                if (i12 != 0) {
                    i6 |= DriveFile.MODE_READ_WRITE;
                } else {
                    if ((i2 & 1879048192) == 0) {
                        i13 = i12;
                        i6 |= composerStartRestartGroup.changed(function24) ? 536870912 : 268435456;
                    }
                    i14 = i5 & 1024;
                    if (i14 == 0) {
                        i16 = i4 | 6;
                        i15 = i14;
                    } else if ((i4 & 14) == 0) {
                        i15 = i14;
                        i16 = i4 | (composerStartRestartGroup.changed(function25) ? 4 : 2);
                    } else {
                        i15 = i14;
                        i16 = i4;
                    }
                    i17 = i5 & 2048;
                    if (i17 == 0) {
                        i16 |= 48;
                        i18 = i17;
                    } else if ((i4 & 112) == 0) {
                        i18 = i17;
                        i16 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
                    } else {
                        i18 = i17;
                    }
                    int i32 = i16;
                    i19 = i5 & 4096;
                    if (i19 != 0) {
                        i20 = i32;
                        if ((i4 & 896) == 0) {
                            i20 |= composerStartRestartGroup.changed(visualTransformation) ? 256 : 128;
                        }
                        if ((i4 & 7168) == 0) {
                            if ((i5 & 8192) == 0 && composerStartRestartGroup.changed(keyboardOptions)) {
                                i30 = 2048;
                            }
                            i20 |= i30;
                        }
                        if ((i4 & 57344) == 0) {
                            if ((i5 & 16384) == 0 && composerStartRestartGroup.changed(keyboardActions)) {
                                i31 = 16384;
                            }
                            i20 |= i31;
                        }
                        i21 = i5 & 32768;
                        if (i21 != 0) {
                            i20 |= 196608;
                        } else if ((i4 & 458752) == 0) {
                            i20 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                        }
                        i22 = i5 & 65536;
                        if (i22 != 0) {
                            i20 |= 1572864;
                        } else if ((i4 & 3670016) == 0) {
                            i20 |= composerStartRestartGroup.changed(i) ? 1048576 : 524288;
                        }
                        i23 = i5 & 131072;
                        if (i23 != 0) {
                            i20 |= 12582912;
                        } else if ((i4 & 29360128) == 0) {
                            i20 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                        }
                        if ((i4 & 234881024) == 0) {
                            i20 |= ((i5 & 262144) == 0 && composerStartRestartGroup.changed(shape)) ? 67108864 : 33554432;
                        }
                        if ((i4 & 1879048192) == 0) {
                            i20 |= ((i5 & 524288) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 536870912 : 268435456;
                        }
                        int i33 = i20;
                        if ((i6 & 1533916891) == 306783378 && (1533916891 & i33) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function215 = function24;
                            visualTransformation2 = visualTransformation;
                            z11 = z4;
                            i28 = i;
                            mutableInteractionSource4 = mutableInteractionSource;
                            shape3 = shape;
                            textFieldColors2 = textFieldColors;
                            composer3 = composerStartRestartGroup;
                            z10 = z5;
                            z12 = z6;
                            textStyle5 = textStyle2;
                            function216 = function26;
                            function213 = function27;
                            modifier3 = modifier2;
                            function214 = function23;
                            function217 = function25;
                            z9 = z3;
                            keyboardOptions4 = keyboardOptions;
                            keyboardActions4 = keyboardActions;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i5 & 32) != 0) {
                                    i6 &= -458753;
                                }
                                if ((i5 & 8192) != 0) {
                                    i33 &= -7169;
                                }
                                if ((i5 & 16384) != 0) {
                                    i33 &= -57345;
                                }
                                if ((i5 & 262144) != 0) {
                                    i33 &= -234881025;
                                }
                                if ((i5 & 524288) != 0) {
                                    i33 &= -1879048193;
                                }
                                int i34 = i6;
                                composer2 = composerStartRestartGroup;
                                i25 = i34;
                                function28 = function23;
                                function211 = function24;
                                function212 = function25;
                                z7 = z3;
                                none = visualTransformation;
                                z8 = z4;
                                mutableInteractionSource3 = mutableInteractionSource;
                                shape2 = shape;
                                textFieldColorsM17377outlinedTextFieldColorsl59Burw = textFieldColors;
                                i27 = i33;
                                textStyle4 = textStyle2;
                                function29 = function26;
                                function210 = function27;
                                keyboardOptions3 = keyboardOptions;
                                keyboardActions3 = keyboardActions;
                                i26 = i;
                            } else {
                                Modifier modifier4 = i29 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z13 = i7 == 0 ? true : z5;
                                boolean z14 = i8 == 0 ? false : z6;
                                if ((i5 & 32) == 0) {
                                    i6 &= -458753;
                                    textStyle3 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                                } else {
                                    textStyle3 = textStyle2;
                                }
                                int i35 = i6;
                                Function2<? super Composer, ? super Integer, Unit> function218 = i9 == 0 ? null : function26;
                                Function2<? super Composer, ? super Integer, Unit> function219 = i10 == 0 ? null : function27;
                                Function2<? super Composer, ? super Integer, Unit> function220 = i11 == 0 ? null : function23;
                                Function2<? super Composer, ? super Integer, Unit> function221 = i13 == 0 ? null : function24;
                                Function2<? super Composer, ? super Integer, Unit> function222 = i15 == 0 ? null : function25;
                                boolean z15 = i18 == 0 ? false : z3;
                                none = i19 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                if ((i5 & 8192) == 0) {
                                    i24 = i33 & (-7169);
                                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                } else {
                                    i24 = i33;
                                    keyboardOptions2 = keyboardOptions;
                                }
                                if ((i5 & 16384) == 0) {
                                    i24 &= -57345;
                                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                                } else {
                                    keyboardActions2 = keyboardActions;
                                }
                                boolean z16 = i21 == 0 ? false : z4;
                                int i36 = i22 == 0 ? Integer.MAX_VALUE : i;
                                if (i23 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                if ((i5 & 262144) == 0) {
                                    i24 &= -234881025;
                                    outlinedShape = TextFieldDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                                } else {
                                    outlinedShape = shape;
                                }
                                int i37 = i24;
                                if ((i5 & 524288) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    keyboardOptions3 = keyboardOptions2;
                                    modifier2 = modifier4;
                                    function28 = function220;
                                    textFieldColorsM17377outlinedTextFieldColorsl59Burw = TextFieldDefaults.INSTANCE.m17377outlinedTextFieldColorsl59Burw(0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 100663296, 268435455);
                                    i27 = i37 & (-1879048193);
                                    z5 = z13;
                                    z6 = z14;
                                    textStyle4 = textStyle3;
                                    i25 = i35;
                                    function29 = function218;
                                    function210 = function219;
                                    function211 = function221;
                                    function212 = function222;
                                    z7 = z15;
                                    keyboardActions3 = keyboardActions2;
                                    z8 = z16;
                                    i26 = i36;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    shape2 = outlinedShape;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    textFieldColorsM17377outlinedTextFieldColorsl59Burw = textFieldColors;
                                    keyboardOptions3 = keyboardOptions2;
                                    modifier2 = modifier4;
                                    function28 = function220;
                                    z5 = z13;
                                    z6 = z14;
                                    textStyle4 = textStyle3;
                                    i25 = i35;
                                    function29 = function218;
                                    function210 = function219;
                                    function211 = function221;
                                    function212 = function222;
                                    z7 = z15;
                                    keyboardActions3 = keyboardActions2;
                                    z8 = z16;
                                    i26 = i36;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    shape2 = outlinedShape;
                                    i27 = i37;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1040237435, i25, i27, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:283)");
                            }
                            composer2.startReplaceableGroup(1663543409);
                            jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                            if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                jM20486getColor0d7_KjU = textFieldColorsM17377outlinedTextFieldColorsl59Burw.textColor$material3_release(z5, composer2, ((i25 >> 9) & 14) | ((i27 >> 24) & 112)).getValue().m18535unboximpl();
                            }
                            long j = jM20486getColor0d7_KjU;
                            composer2.endReplaceableGroup();
                            final TextStyle textStyleMerge = textStyle4.merge(new TextStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                            TextStyle textStyle6 = textStyle4;
                            final int i38 = i25;
                            Composer composer4 = composer2;
                            final Modifier modifier5 = modifier2;
                            final VisualTransformation visualTransformation3 = none;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColorsM17377outlinedTextFieldColorsl59Burw.getSelectionColors(composer2, (i27 >> 27) & 14))}, ComposableLambdaKt.composableLambda(composer4, -719341509, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i39) {
                                    if ((i39 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-719341509, i39, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:311)");
                                    }
                                    Modifier modifierM15858paddingqDBjuR0$default = function29 != null ? PaddingKt.m15858paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier5, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null) : modifier5;
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(modifierM15858paddingqDBjuR0$default, textFieldDefaults.m17374getMinWidthD9Ej5fM(), textFieldDefaults.m17373getMinHeightD9Ej5fM());
                                    TextFieldColors textFieldColors3 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                    boolean z17 = z7;
                                    int i40 = i27;
                                    SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor$material3_release(z17, composer5, ((i40 >> 24) & 112) | ((i40 >> 3) & 14)).getValue().m18535unboximpl(), null);
                                    final TextFieldValue textFieldValue = value;
                                    Function1<TextFieldValue, Unit> function1 = onValueChange;
                                    final boolean z18 = z5;
                                    boolean z19 = z6;
                                    TextStyle textStyle7 = textStyleMerge;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    KeyboardActions keyboardActions5 = keyboardActions3;
                                    final boolean z20 = z8;
                                    int i41 = i26;
                                    final VisualTransformation visualTransformation4 = visualTransformation3;
                                    final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                    final boolean z21 = z7;
                                    final Function2<Composer, Integer, Unit> function223 = function29;
                                    final Function2<Composer, Integer, Unit> function224 = function210;
                                    final Function2<Composer, Integer, Unit> function225 = function28;
                                    final Function2<Composer, Integer, Unit> function226 = function211;
                                    final Function2<Composer, Integer, Unit> function227 = function212;
                                    final TextFieldColors textFieldColors4 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                    final int i42 = i38;
                                    final int i43 = i27;
                                    final Shape shape4 = shape2;
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, 342910148, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function228, Composer composer6, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function228, composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                         */
                                        @Composable
                                        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                                        public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> innerTextField, @Nullable Composer composer6, int i44) {
                                            int i45;
                                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                            if ((i44 & 14) == 0) {
                                                i45 = i44 | (composer6.changed(innerTextField) ? 4 : 2);
                                            } else {
                                                i45 = i44;
                                            }
                                            if ((i45 & 91) == 18 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(342910148, i45, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:339)");
                                            }
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            String text = textFieldValue.getText();
                                            final boolean z22 = z18;
                                            boolean z23 = z20;
                                            VisualTransformation visualTransformation5 = visualTransformation4;
                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                            final boolean z24 = z21;
                                            Function2<Composer, Integer, Unit> function228 = function223;
                                            Function2<Composer, Integer, Unit> function229 = function224;
                                            Function2<Composer, Integer, Unit> function230 = function225;
                                            Function2<Composer, Integer, Unit> function231 = function226;
                                            Function2<Composer, Integer, Unit> function232 = function227;
                                            final TextFieldColors textFieldColors5 = textFieldColors4;
                                            final Shape shape5 = shape4;
                                            final int i46 = i42;
                                            final int i47 = i43;
                                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer6, 119108444, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                    invoke(composer7, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer7, int i48) {
                                                    if ((i48 & 11) == 2 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(119108444, i48, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:354)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults3 = TextFieldDefaults.INSTANCE;
                                                    boolean z25 = z22;
                                                    boolean z26 = z24;
                                                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                                    TextFieldColors textFieldColors6 = textFieldColors5;
                                                    Shape shape6 = shape5;
                                                    int i49 = ((i46 >> 9) & 14) | 12582912;
                                                    int i50 = i47;
                                                    textFieldDefaults3.m17371OutlinedBorderContainerBoxnbWgWpA(z25, z26, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer7, i49 | (i50 & 112) | ((i50 >> 15) & 896) | ((i50 >> 18) & 7168) | ((i50 >> 12) & 57344), 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i48 = i42;
                                            int i49 = i43;
                                            textFieldDefaults2.OutlinedTextFieldDecorationBox(text, innerTextField, z22, z23, visualTransformation5, mutableInteractionSource6, z24, function228, function229, function230, function231, function232, textFieldColors5, null, composableLambda2, composer6, ((i45 << 3) & 112) | ((i48 >> 3) & 896) | ((i49 >> 6) & 7168) | ((i49 << 6) & 57344) | ((i49 >> 6) & 458752) | ((i49 << 15) & 3670016) | ((i48 << 3) & 29360128) | ((i48 << 3) & 234881024) | ((i48 << 3) & 1879048192), ((i48 >> 27) & 14) | 221184 | ((i49 << 3) & 112) | ((i49 >> 21) & 896), 8192);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    int i44 = i38 & 64638;
                                    int i45 = i27;
                                    BasicTextFieldKt.BasicTextField(textFieldValue, function1, modifierM15883defaultMinSizeVpY3zN4, z18, z19, textStyle7, keyboardOptions5, keyboardActions5, z20, i41, visualTransformation4, (Function1) null, mutableInteractionSource5, solidColor, composableLambda, composer5, i44 | ((i45 << 9) & 3670016) | (KeyboardActions.$stable << 21) | ((i45 << 9) & 29360128) | ((i45 << 9) & 234881024) | (1879048192 & (i45 << 9)), ((i45 >> 15) & 896) | ((i45 >> 6) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer4, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            KeyboardActions keyboardActions5 = keyboardActions3;
                            z9 = z7;
                            z10 = z5;
                            function213 = function210;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z11 = z8;
                            visualTransformation2 = visualTransformation3;
                            keyboardActions4 = keyboardActions5;
                            composer3 = composer4;
                            z12 = z6;
                            i28 = i26;
                            function214 = function28;
                            function215 = function211;
                            shape3 = shape2;
                            textStyle5 = textStyle6;
                            function216 = function29;
                            textFieldColors2 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                            keyboardOptions4 = keyboardOptions3;
                            function217 = function212;
                            modifier3 = modifier5;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.6
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

                            public final void invoke(@Nullable Composer composer5, int i39) {
                                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z10, z12, textStyle5, function216, function213, function214, function215, function217, z9, visualTransformation2, keyboardOptions4, keyboardActions4, z11, i28, mutableInteractionSource4, shape3, textFieldColors2, composer5, i2 | 1, i4, i5);
                            }
                        });
                        return;
                    }
                    i20 = i32 | 384;
                    if ((i4 & 7168) == 0) {
                    }
                    if ((i4 & 57344) == 0) {
                    }
                    i21 = i5 & 32768;
                    if (i21 != 0) {
                    }
                    i22 = i5 & 65536;
                    if (i22 != 0) {
                    }
                    i23 = i5 & 131072;
                    if (i23 != 0) {
                    }
                    if ((i4 & 234881024) == 0) {
                    }
                    if ((i4 & 1879048192) == 0) {
                    }
                    int i332 = i20;
                    if ((i6 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) == 0) {
                            if (i29 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 == 0) {
                            }
                            if ((i5 & 32) == 0) {
                            }
                            int i352 = i6;
                            if (i9 == 0) {
                            }
                            if (i10 == 0) {
                            }
                            if (i11 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i19 == 0) {
                            }
                            if ((i5 & 8192) == 0) {
                            }
                            if ((i5 & 16384) == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i23 == 0) {
                            }
                            if ((i5 & 262144) == 0) {
                            }
                            int i372 = i24;
                            if ((i5 & 524288) == 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2.startReplaceableGroup(1663543409);
                            jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                            if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                            }
                            long j2 = jM20486getColor0d7_KjU;
                            composer2.endReplaceableGroup();
                            final TextStyle textStyleMerge2 = textStyle4.merge(new TextStyle(j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                            TextStyle textStyle62 = textStyle4;
                            final int i382 = i25;
                            Composer composer42 = composer2;
                            final Modifier modifier52 = modifier2;
                            final VisualTransformation visualTransformation32 = none;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColorsM17377outlinedTextFieldColorsl59Burw.getSelectionColors(composer2, (i27 >> 27) & 14))}, ComposableLambdaKt.composableLambda(composer42, -719341509, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i39) {
                                    if ((i39 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-719341509, i39, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:311)");
                                    }
                                    Modifier modifierM15858paddingqDBjuR0$default = function29 != null ? PaddingKt.m15858paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier52, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null) : modifier52;
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(modifierM15858paddingqDBjuR0$default, textFieldDefaults.m17374getMinWidthD9Ej5fM(), textFieldDefaults.m17373getMinHeightD9Ej5fM());
                                    TextFieldColors textFieldColors3 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                    boolean z17 = z7;
                                    int i40 = i27;
                                    SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor$material3_release(z17, composer5, ((i40 >> 24) & 112) | ((i40 >> 3) & 14)).getValue().m18535unboximpl(), null);
                                    final TextFieldValue textFieldValue = value;
                                    Function1<TextFieldValue, Unit> function1 = onValueChange;
                                    final boolean z18 = z5;
                                    boolean z19 = z6;
                                    TextStyle textStyle7 = textStyleMerge2;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    KeyboardActions keyboardActions52 = keyboardActions3;
                                    final boolean z20 = z8;
                                    int i41 = i26;
                                    final VisualTransformation visualTransformation4 = visualTransformation32;
                                    final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                    final boolean z21 = z7;
                                    final Function2<? super Composer, ? super Integer, Unit> function223 = function29;
                                    final Function2<? super Composer, ? super Integer, Unit> function224 = function210;
                                    final Function2<? super Composer, ? super Integer, Unit> function225 = function28;
                                    final Function2<? super Composer, ? super Integer, Unit> function226 = function211;
                                    final Function2<? super Composer, ? super Integer, Unit> function227 = function212;
                                    final TextFieldColors textFieldColors4 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                                    final int i42 = i382;
                                    final int i43 = i27;
                                    final Shape shape4 = shape2;
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, 342910148, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function228, Composer composer6, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function228, composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                         */
                                        @Composable
                                        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                                        public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> innerTextField, @Nullable Composer composer6, int i44) {
                                            int i45;
                                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                            if ((i44 & 14) == 0) {
                                                i45 = i44 | (composer6.changed(innerTextField) ? 4 : 2);
                                            } else {
                                                i45 = i44;
                                            }
                                            if ((i45 & 91) == 18 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(342910148, i45, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:339)");
                                            }
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            String text = textFieldValue.getText();
                                            final boolean z22 = z18;
                                            boolean z23 = z20;
                                            VisualTransformation visualTransformation5 = visualTransformation4;
                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                            final boolean z24 = z21;
                                            Function2<Composer, Integer, Unit> function228 = function223;
                                            Function2<Composer, Integer, Unit> function229 = function224;
                                            Function2<Composer, Integer, Unit> function230 = function225;
                                            Function2<Composer, Integer, Unit> function231 = function226;
                                            Function2<Composer, Integer, Unit> function232 = function227;
                                            final TextFieldColors textFieldColors5 = textFieldColors4;
                                            final Shape shape5 = shape4;
                                            final int i46 = i42;
                                            final int i47 = i43;
                                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer6, 119108444, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                    invoke(composer7, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer7, int i48) {
                                                    if ((i48 & 11) == 2 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(119108444, i48, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:354)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults3 = TextFieldDefaults.INSTANCE;
                                                    boolean z25 = z22;
                                                    boolean z26 = z24;
                                                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                                    TextFieldColors textFieldColors6 = textFieldColors5;
                                                    Shape shape6 = shape5;
                                                    int i49 = ((i46 >> 9) & 14) | 12582912;
                                                    int i50 = i47;
                                                    textFieldDefaults3.m17371OutlinedBorderContainerBoxnbWgWpA(z25, z26, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer7, i49 | (i50 & 112) | ((i50 >> 15) & 896) | ((i50 >> 18) & 7168) | ((i50 >> 12) & 57344), 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i48 = i42;
                                            int i49 = i43;
                                            textFieldDefaults2.OutlinedTextFieldDecorationBox(text, innerTextField, z22, z23, visualTransformation5, mutableInteractionSource6, z24, function228, function229, function230, function231, function232, textFieldColors5, null, composableLambda2, composer6, ((i45 << 3) & 112) | ((i48 >> 3) & 896) | ((i49 >> 6) & 7168) | ((i49 << 6) & 57344) | ((i49 >> 6) & 458752) | ((i49 << 15) & 3670016) | ((i48 << 3) & 29360128) | ((i48 << 3) & 234881024) | ((i48 << 3) & 1879048192), ((i48 >> 27) & 14) | 221184 | ((i49 << 3) & 112) | ((i49 >> 21) & 896), 8192);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    int i44 = i382 & 64638;
                                    int i45 = i27;
                                    BasicTextFieldKt.BasicTextField(textFieldValue, function1, modifierM15883defaultMinSizeVpY3zN4, z18, z19, textStyle7, keyboardOptions5, keyboardActions52, z20, i41, visualTransformation4, (Function1) null, mutableInteractionSource5, solidColor, composableLambda, composer5, i44 | ((i45 << 9) & 3670016) | (KeyboardActions.$stable << 21) | ((i45 << 9) & 29360128) | ((i45 << 9) & 234881024) | (1879048192 & (i45 << 9)), ((i45 >> 15) & 896) | ((i45 >> 6) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer42, 56);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            KeyboardActions keyboardActions52 = keyboardActions3;
                            z9 = z7;
                            z10 = z5;
                            function213 = function210;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z11 = z8;
                            visualTransformation2 = visualTransformation32;
                            keyboardActions4 = keyboardActions52;
                            composer3 = composer42;
                            z12 = z6;
                            i28 = i26;
                            function214 = function28;
                            function215 = function211;
                            shape3 = shape2;
                            textStyle5 = textStyle62;
                            function216 = function29;
                            textFieldColors2 = textFieldColorsM17377outlinedTextFieldColorsl59Burw;
                            keyboardOptions4 = keyboardOptions3;
                            function217 = function212;
                            modifier3 = modifier52;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i13 = i12;
                i14 = i5 & 1024;
                if (i14 == 0) {
                }
                i17 = i5 & 2048;
                if (i17 == 0) {
                }
                int i322 = i16;
                i19 = i5 & 4096;
                if (i19 != 0) {
                }
                if ((i4 & 7168) == 0) {
                }
                if ((i4 & 57344) == 0) {
                }
                i21 = i5 & 32768;
                if (i21 != 0) {
                }
                i22 = i5 & 65536;
                if (i22 != 0) {
                }
                i23 = i5 & 131072;
                if (i23 != 0) {
                }
                if ((i4 & 234881024) == 0) {
                }
                if ((i4 & 1879048192) == 0) {
                }
                int i3322 = i20;
                if ((i6 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z5 = z;
            i8 = i5 & 16;
            int i312 = 8192;
            if (i8 != 0) {
            }
            if ((i2 & 458752) == 0) {
            }
            i9 = i5 & 64;
            if (i9 != 0) {
            }
            i10 = i5 & 128;
            if (i10 != 0) {
            }
            i11 = i5 & 256;
            if (i11 != 0) {
            }
            i12 = i5 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i5 & 1024;
            if (i14 == 0) {
            }
            i17 = i5 & 2048;
            if (i17 == 0) {
            }
            int i3222 = i16;
            i19 = i5 & 4096;
            if (i19 != 0) {
            }
            if ((i4 & 7168) == 0) {
            }
            if ((i4 & 57344) == 0) {
            }
            i21 = i5 & 32768;
            if (i21 != 0) {
            }
            i22 = i5 & 65536;
            if (i22 != 0) {
            }
            i23 = i5 & 131072;
            if (i23 != 0) {
            }
            if ((i4 & 234881024) == 0) {
            }
            if ((i4 & 1879048192) == 0) {
            }
            int i33222 = i20;
            if ((i6 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        int i302 = 1024;
        if (i7 == 0) {
        }
        z5 = z;
        i8 = i5 & 16;
        int i3122 = 8192;
        if (i8 != 0) {
        }
        if ((i2 & 458752) == 0) {
        }
        i9 = i5 & 64;
        if (i9 != 0) {
        }
        i10 = i5 & 128;
        if (i10 != 0) {
        }
        i11 = i5 & 256;
        if (i11 != 0) {
        }
        i12 = i5 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i5 & 1024;
        if (i14 == 0) {
        }
        i17 = i5 & 2048;
        if (i17 == 0) {
        }
        int i32222 = i16;
        i19 = i5 & 4096;
        if (i19 != 0) {
        }
        if ((i4 & 7168) == 0) {
        }
        if ((i4 & 57344) == 0) {
        }
        i21 = i5 & 32768;
        if (i21 != 0) {
        }
        i22 = i5 & 65536;
        if (i22 != 0) {
        }
        i23 = i5 & 131072;
        if (i23 != 0) {
        }
        if ((i4 & 234881024) == 0) {
        }
        if ((i4 & 1879048192) == 0) {
        }
        int i332222 = i20;
        if ((i6 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
