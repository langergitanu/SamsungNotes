package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.DrawModifierKt;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
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
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
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
@Metadata(m13885d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020-2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u009a\u0001\u0010/\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\u00107\u001a]\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001aE\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001a\u0014\u0010L\u001a\u00020\u0010*\u00020\u00102\u0006\u0010M\u001a\u00020NH\u0000\u001at\u0010O\u001a\u00020\n*\u00020P2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010T2\b\u0010V\u001a\u0004\u0018\u00010T2\b\u0010W\u001a\u0004\u0018\u00010T2\b\u0010X\u001a\u0004\u0018\u00010T2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020%2\u0006\u0010Z\u001a\u00020%2\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u000204H\u0002\u001aZ\u0010[\u001a\u00020\n*\u00020P2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010\\\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010T2\b\u0010W\u001a\u0004\u0018\u00010T2\b\u0010X\u001a\u0004\u0018\u00010T2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010A\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, m13886d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", TokenizerME.NO_SPLIT, "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TextFieldKt {
    private static final float FirstBaselineOffset = C2256Dp.m20968constructorimpl(20);
    private static final float TextFieldBottomPadding = C2256Dp.m20968constructorimpl(10);
    private static final float TextFieldTopPadding = C2256Dp.m20968constructorimpl(4);

    /* JADX WARN: Removed duplicated region for block: B:100:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0615 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0132  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(@NotNull final String value, @NotNull final Function1<? super String, Unit> onValueChange, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable TextStyle textStyle, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, @Nullable VisualTransformation visualTransformation, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActions keyboardActions, boolean z4, int i, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, @Nullable TextFieldColors textFieldColors, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        TextStyle textStyle2;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function26;
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
        int i24;
        TextStyle textStyle3;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        boolean z7;
        VisualTransformation none;
        int i25;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        MutableInteractionSource mutableInteractionSource2;
        Shape shapeCopy$default;
        KeyboardOptions keyboardOptions3;
        Modifier modifier3;
        TextStyle textStyle4;
        TextFieldColors textFieldColors2;
        boolean z8;
        int i26;
        KeyboardActions keyboardActions3;
        boolean z9;
        int i27;
        Shape shape2;
        int i28;
        boolean z10;
        long jM20486getColor0d7_KjU;
        final TextFieldColors textFieldColors3;
        final boolean z11;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions4;
        final int i29;
        final MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        final TextStyle textStyle5;
        final Modifier modifier4;
        final boolean z12;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z13;
        final Shape shape3;
        final boolean z14;
        final VisualTransformation visualTransformation2;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1690895095);
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
        int i30 = i5 & 4;
        if (i30 != 0) {
            i6 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            int i31 = 1024;
            if (i7 == 0) {
                i6 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z5 = z;
                    i6 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i8 = i5 & 16;
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
                    function25 = function2;
                } else {
                    function25 = function2;
                    if ((i2 & 3670016) == 0) {
                        i6 |= composerStartRestartGroup.changed(function25) ? 1048576 : 524288;
                    }
                }
                i10 = i5 & 128;
                if (i10 != 0) {
                    i6 |= 12582912;
                    function26 = function22;
                } else {
                    function26 = function22;
                    if ((i2 & 29360128) == 0) {
                        i6 |= composerStartRestartGroup.changed(function26) ? 8388608 : 4194304;
                    }
                }
                i11 = i5 & 256;
                if (i11 != 0) {
                    i6 |= 100663296;
                } else {
                    if ((i2 & 234881024) == 0) {
                        i12 = i11;
                        i6 |= composerStartRestartGroup.changed(function23) ? 67108864 : 33554432;
                    }
                    i13 = i5 & 512;
                    if (i13 == 0) {
                        i6 |= DriveFile.MODE_READ_WRITE;
                    } else {
                        if ((i2 & 1879048192) == 0) {
                            i14 = i13;
                            i6 |= composerStartRestartGroup.changed(function24) ? 536870912 : 268435456;
                        }
                        i15 = i5 & 1024;
                        if (i15 != 0) {
                            i17 = i4 | 6;
                            i16 = i15;
                        } else if ((i4 & 14) == 0) {
                            i16 = i15;
                            i17 = i4 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
                        } else {
                            i16 = i15;
                            i17 = i4;
                        }
                        i18 = i5 & 2048;
                        if (i18 != 0) {
                            i17 |= 48;
                        } else {
                            if ((i4 & 112) == 0) {
                                i19 = i18;
                                i17 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                            }
                            if ((i4 & 896) == 0) {
                                i17 |= ((i5 & 4096) == 0 && composerStartRestartGroup.changed(keyboardOptions)) ? 256 : 128;
                            }
                            if ((i4 & 7168) == 0) {
                                if ((i5 & 8192) == 0 && composerStartRestartGroup.changed(keyboardActions)) {
                                    i31 = 2048;
                                }
                                i17 |= i31;
                            }
                            int i32 = i17;
                            i20 = i5 & 16384;
                            if (i20 != 0) {
                                if ((i4 & 57344) == 0) {
                                    i21 = i32 | (composerStartRestartGroup.changed(z4) ? 16384 : 8192);
                                }
                                i22 = i5 & 32768;
                                if (i22 != 0) {
                                    i21 |= 196608;
                                } else if ((i4 & 458752) == 0) {
                                    i21 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
                                }
                                i23 = i5 & 65536;
                                if (i23 != 0) {
                                    i21 |= 1572864;
                                } else if ((i4 & 3670016) == 0) {
                                    i21 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                                }
                                if ((i4 & 29360128) == 0) {
                                    i21 |= ((i5 & 131072) == 0 && composerStartRestartGroup.changed(shape)) ? 8388608 : 4194304;
                                }
                                if ((i4 & 234881024) == 0) {
                                    i21 |= ((i5 & 262144) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 67108864 : 33554432;
                                }
                                int i33 = i21;
                                if ((i6 & 1533916891) == 306783378 && (191739611 & i33) == 38347922 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    z13 = z3;
                                    keyboardActions4 = keyboardActions;
                                    i29 = i;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    shape3 = shape;
                                    textFieldColors3 = textFieldColors;
                                    z12 = z5;
                                    z11 = z6;
                                    textStyle5 = textStyle2;
                                    function29 = function25;
                                    function211 = function26;
                                    modifier4 = modifier2;
                                    composer2 = composerStartRestartGroup;
                                    function210 = function23;
                                    function212 = function24;
                                    visualTransformation2 = visualTransformation;
                                    keyboardOptions4 = keyboardOptions;
                                    z14 = z4;
                                } else {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier modifier5 = i30 == 0 ? Modifier.INSTANCE : modifier2;
                                        boolean z15 = i7 == 0 ? true : z5;
                                        boolean z16 = i8 == 0 ? false : z6;
                                        if ((i5 & 32) == 0) {
                                            i24 = i6 & (-458753);
                                            textStyle3 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                                        } else {
                                            i24 = i6;
                                            textStyle3 = textStyle2;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function213 = i9 == 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function214 = i10 == 0 ? null : function26;
                                        function27 = i12 == 0 ? null : function23;
                                        function28 = i14 == 0 ? null : function24;
                                        z7 = i16 == 0 ? false : z3;
                                        none = i19 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        if ((i5 & 4096) == 0) {
                                            i25 = i33 & (-897);
                                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                        } else {
                                            i25 = i33;
                                            keyboardOptions2 = keyboardOptions;
                                        }
                                        if ((i5 & 8192) == 0) {
                                            i25 &= -7169;
                                            keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                        } else {
                                            keyboardActions2 = keyboardActions;
                                        }
                                        boolean z17 = i20 == 0 ? false : z4;
                                        int i34 = i22 == 0 ? Integer.MAX_VALUE : i;
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
                                        if ((i5 & 131072) == 0) {
                                            i25 &= -29360129;
                                            shapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                                        } else {
                                            shapeCopy$default = shape;
                                        }
                                        int i35 = i25;
                                        if ((262144 & i5) == 0) {
                                            TextFieldColors textFieldColorsM16924textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m16924textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                                            composerStartRestartGroup = composerStartRestartGroup;
                                            TextStyle textStyle6 = textStyle3;
                                            keyboardOptions3 = keyboardOptions2;
                                            modifier3 = modifier5;
                                            textStyle4 = textStyle6;
                                            textFieldColors2 = textFieldColorsM16924textFieldColorsdx8h9Zs;
                                            i28 = i35 & (-234881025);
                                            z5 = z15;
                                            z8 = z16;
                                            i26 = i24;
                                            function25 = function213;
                                            function26 = function214;
                                            keyboardActions3 = keyboardActions2;
                                            z9 = z17;
                                            i27 = i34;
                                            shape2 = shapeCopy$default;
                                        } else {
                                            TextStyle textStyle7 = textStyle3;
                                            keyboardOptions3 = keyboardOptions2;
                                            modifier3 = modifier5;
                                            textStyle4 = textStyle7;
                                            textFieldColors2 = textFieldColors;
                                            z5 = z15;
                                            z8 = z16;
                                            i26 = i24;
                                            function25 = function213;
                                            function26 = function214;
                                            keyboardActions3 = keyboardActions2;
                                            z9 = z17;
                                            i27 = i34;
                                            shape2 = shapeCopy$default;
                                            i28 = i35;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i5 & 32) != 0) {
                                            i6 &= -458753;
                                        }
                                        if ((i5 & 4096) != 0) {
                                            i33 &= -897;
                                        }
                                        if ((i5 & 8192) != 0) {
                                            i33 &= -7169;
                                        }
                                        if ((i5 & 131072) != 0) {
                                            i33 &= -29360129;
                                        }
                                        if ((262144 & i5) != 0) {
                                            i33 &= -234881025;
                                        }
                                        function27 = function23;
                                        function28 = function24;
                                        z7 = z3;
                                        none = visualTransformation;
                                        z9 = z4;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        shape2 = shape;
                                        i28 = i33;
                                        i26 = i6;
                                        z8 = z6;
                                        textStyle4 = textStyle2;
                                        modifier3 = modifier2;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        i27 = i;
                                        textFieldColors2 = textFieldColors;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        z10 = z8;
                                    } else {
                                        z10 = z8;
                                        ComposerKt.traceEventStart(-1690895095, i26, i28, "androidx.compose.material.TextField (TextField.kt:157)");
                                    }
                                    composerStartRestartGroup.startReplaceableGroup(-833027444);
                                    jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                                    if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                        jM20486getColor0d7_KjU = textFieldColors2.textColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | ((i28 >> 21) & 112)).getValue().m18535unboximpl();
                                    }
                                    long j = jM20486getColor0d7_KjU;
                                    composerStartRestartGroup.endReplaceableGroup();
                                    TextStyle textStyleMerge = textStyle4.merge(new TextStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    int i36 = (i28 >> 21) & 112;
                                    TextStyle textStyle8 = textStyle4;
                                    final int i37 = i26;
                                    final boolean z18 = z5;
                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                    final boolean z19 = z7;
                                    Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(TextFieldDefaults.m16912indicatorLinegv0btCI$default(textFieldDefaults, BackgroundKt.m15408backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | i36).getValue().m18535unboximpl(), shape2), z18, z19, mutableInteractionSource2, textFieldColors4, 0.0f, 0.0f, 48, null), textFieldDefaults.m16919getMinWidthD9Ej5fM(), textFieldDefaults.m16918getMinHeightD9Ej5fM());
                                    Modifier modifier6 = modifier3;
                                    SolidColor solidColor = new SolidColor(textFieldColors4.cursorColor(z19, composerStartRestartGroup, (i28 & 14) | i36).getValue().m18535unboximpl(), null);
                                    final boolean z20 = z9;
                                    final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                    final Function2<? super Composer, ? super Integer, Unit> function216 = function26;
                                    final int i38 = i28;
                                    final Function2<? super Composer, ? super Integer, Unit> function217 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function218 = function28;
                                    final VisualTransformation visualTransformation3 = none;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    textFieldColors3 = textFieldColors4;
                                    int i39 = i38 << 12;
                                    Shape shape4 = shape2;
                                    boolean z21 = z10;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM15883defaultMinSizeVpY3zN4, z18, z21, textStyleMerge, keyboardOptions5, keyboardActions3, z9, i27, visualTransformation3, (Function1) null, mutableInteractionSource4, solidColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1994363936, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer3, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @Composable
                                        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                                        public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> innerTextField, @Nullable Composer composer3, int i40) {
                                            int i41;
                                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                            if ((i40 & 14) == 0) {
                                                i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                                            } else {
                                                i41 = i40;
                                            }
                                            if ((i41 & 91) == 18 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1994363936, i41, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:206)");
                                            }
                                            int i42 = i41;
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            String str = value;
                                            boolean z22 = z18;
                                            boolean z23 = z20;
                                            VisualTransformation visualTransformation4 = visualTransformation3;
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                            boolean z24 = z19;
                                            Function2<Composer, Integer, Unit> function219 = function215;
                                            Function2<Composer, Integer, Unit> function220 = function216;
                                            Function2<Composer, Integer, Unit> function221 = function217;
                                            Function2<Composer, Integer, Unit> function222 = function218;
                                            TextFieldColors textFieldColors5 = textFieldColors4;
                                            int i43 = i37;
                                            int i44 = i38;
                                            textFieldDefaults2.TextFieldDecorationBox(str, innerTextField, z22, z23, visualTransformation4, mutableInteractionSource5, z24, function219, function220, function221, function222, textFieldColors5, null, composer3, ((i44 >> 3) & 7168) | ((i43 >> 3) & 896) | (i43 & 14) | ((i42 << 3) & 112) | ((i44 << 9) & 57344) | ((i44 >> 3) & 458752) | ((i44 << 18) & 3670016) | ((i43 << 3) & 29360128) | ((i43 << 3) & 234881024) | ((i43 << 3) & 1879048192), ((i43 >> 27) & 14) | 3072 | ((i44 >> 21) & 112), 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i37 & 64638) | (i39 & 3670016) | (KeyboardActions.$stable << 21) | (i39 & 29360128) | (i39 & 234881024) | (i39 & 1879048192), ((i38 >> 12) & 896) | ((i38 >> 3) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z11 = z21;
                                    keyboardOptions4 = keyboardOptions5;
                                    keyboardActions4 = keyboardActions3;
                                    i29 = i27;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    composer2 = composerStartRestartGroup;
                                    textStyle5 = textStyle8;
                                    modifier4 = modifier6;
                                    z12 = z18;
                                    function29 = function215;
                                    function210 = function27;
                                    z13 = z19;
                                    shape3 = shape4;
                                    z14 = z9;
                                    visualTransformation2 = visualTransformation3;
                                    function211 = function216;
                                    function212 = function28;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                    return;
                                }
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.3
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

                                    public final void invoke(@Nullable Composer composer3, int i40) {
                                        TextFieldKt.TextField(value, onValueChange, modifier4, z12, z11, textStyle5, function29, function211, function210, function212, z13, visualTransformation2, keyboardOptions4, keyboardActions4, z14, i29, mutableInteractionSource3, shape3, textFieldColors3, composer3, i2 | 1, i4, i5);
                                    }
                                });
                                return;
                            }
                            i32 |= 24576;
                            i21 = i32;
                            i22 = i5 & 32768;
                            if (i22 != 0) {
                            }
                            i23 = i5 & 65536;
                            if (i23 != 0) {
                            }
                            if ((i4 & 29360128) == 0) {
                            }
                            if ((i4 & 234881024) == 0) {
                            }
                            int i332 = i21;
                            if ((i6 & 1533916891) == 306783378) {
                                composerStartRestartGroup.startDefaults();
                                if ((i2 & 1) != 0) {
                                    if (i30 == 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if ((i5 & 32) == 0) {
                                    }
                                    if (i9 == 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i12 == 0) {
                                    }
                                    if (i14 == 0) {
                                    }
                                    if (i16 == 0) {
                                    }
                                    if (i19 == 0) {
                                    }
                                    if ((i5 & 4096) == 0) {
                                    }
                                    if ((i5 & 8192) == 0) {
                                    }
                                    if (i20 == 0) {
                                    }
                                    if (i22 == 0) {
                                    }
                                    if (i23 == 0) {
                                    }
                                    if ((i5 & 131072) == 0) {
                                    }
                                    int i352 = i25;
                                    if ((262144 & i5) == 0) {
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composerStartRestartGroup.startReplaceableGroup(-833027444);
                                    jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                                    if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                    }
                                    long j2 = jM20486getColor0d7_KjU;
                                    composerStartRestartGroup.endReplaceableGroup();
                                    TextStyle textStyleMerge2 = textStyle4.merge(new TextStyle(j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                                    TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                    int i362 = (i28 >> 21) & 112;
                                    TextStyle textStyle82 = textStyle4;
                                    final int i372 = i26;
                                    final boolean z182 = z5;
                                    final TextFieldColors textFieldColors42 = textFieldColors2;
                                    final boolean z192 = z7;
                                    Modifier modifierM15883defaultMinSizeVpY3zN42 = SizeKt.m15883defaultMinSizeVpY3zN4(TextFieldDefaults.m16912indicatorLinegv0btCI$default(textFieldDefaults2, BackgroundKt.m15408backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | i362).getValue().m18535unboximpl(), shape2), z182, z192, mutableInteractionSource2, textFieldColors42, 0.0f, 0.0f, 48, null), textFieldDefaults2.m16919getMinWidthD9Ej5fM(), textFieldDefaults2.m16918getMinHeightD9Ej5fM());
                                    Modifier modifier62 = modifier3;
                                    SolidColor solidColor2 = new SolidColor(textFieldColors42.cursorColor(z192, composerStartRestartGroup, (i28 & 14) | i362).getValue().m18535unboximpl(), null);
                                    final boolean z202 = z9;
                                    final Function2<? super Composer, ? super Integer, Unit> function2152 = function25;
                                    final Function2<? super Composer, ? super Integer, Unit> function2162 = function26;
                                    final int i382 = i28;
                                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function28;
                                    final VisualTransformation visualTransformation32 = none;
                                    final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                                    textFieldColors3 = textFieldColors42;
                                    int i392 = i382 << 12;
                                    Shape shape42 = shape2;
                                    boolean z212 = z10;
                                    KeyboardOptions keyboardOptions52 = keyboardOptions3;
                                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM15883defaultMinSizeVpY3zN42, z182, z212, textStyleMerge2, keyboardOptions52, keyboardActions3, z9, i27, visualTransformation32, (Function1) null, mutableInteractionSource42, solidColor2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1994363936, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer3, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @Composable
                                        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                                        public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> innerTextField, @Nullable Composer composer3, int i40) {
                                            int i41;
                                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                            if ((i40 & 14) == 0) {
                                                i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                                            } else {
                                                i41 = i40;
                                            }
                                            if ((i41 & 91) == 18 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1994363936, i41, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:206)");
                                            }
                                            int i42 = i41;
                                            TextFieldDefaults textFieldDefaults22 = TextFieldDefaults.INSTANCE;
                                            String str = value;
                                            boolean z22 = z182;
                                            boolean z23 = z202;
                                            VisualTransformation visualTransformation4 = visualTransformation32;
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42;
                                            boolean z24 = z192;
                                            Function2<Composer, Integer, Unit> function219 = function2152;
                                            Function2<Composer, Integer, Unit> function220 = function2162;
                                            Function2<Composer, Integer, Unit> function221 = function2172;
                                            Function2<Composer, Integer, Unit> function222 = function2182;
                                            TextFieldColors textFieldColors5 = textFieldColors42;
                                            int i43 = i372;
                                            int i44 = i382;
                                            textFieldDefaults22.TextFieldDecorationBox(str, innerTextField, z22, z23, visualTransformation4, mutableInteractionSource5, z24, function219, function220, function221, function222, textFieldColors5, null, composer3, ((i44 >> 3) & 7168) | ((i43 >> 3) & 896) | (i43 & 14) | ((i42 << 3) & 112) | ((i44 << 9) & 57344) | ((i44 >> 3) & 458752) | ((i44 << 18) & 3670016) | ((i43 << 3) & 29360128) | ((i43 << 3) & 234881024) | ((i43 << 3) & 1879048192), ((i43 >> 27) & 14) | 3072 | ((i44 >> 21) & 112), 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i372 & 64638) | (i392 & 3670016) | (KeyboardActions.$stable << 21) | (i392 & 29360128) | (i392 & 234881024) | (i392 & 1879048192), ((i382 >> 12) & 896) | ((i382 >> 3) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    z11 = z212;
                                    keyboardOptions4 = keyboardOptions52;
                                    keyboardActions4 = keyboardActions3;
                                    i29 = i27;
                                    mutableInteractionSource3 = mutableInteractionSource42;
                                    composer2 = composerStartRestartGroup;
                                    textStyle5 = textStyle82;
                                    modifier4 = modifier62;
                                    z12 = z182;
                                    function29 = function2152;
                                    function210 = function27;
                                    z13 = z192;
                                    shape3 = shape42;
                                    z14 = z9;
                                    visualTransformation2 = visualTransformation32;
                                    function211 = function2162;
                                    function212 = function28;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i19 = i18;
                        if ((i4 & 896) == 0) {
                        }
                        if ((i4 & 7168) == 0) {
                        }
                        int i322 = i17;
                        i20 = i5 & 16384;
                        if (i20 != 0) {
                        }
                        i21 = i322;
                        i22 = i5 & 32768;
                        if (i22 != 0) {
                        }
                        i23 = i5 & 65536;
                        if (i23 != 0) {
                        }
                        if ((i4 & 29360128) == 0) {
                        }
                        if ((i4 & 234881024) == 0) {
                        }
                        int i3322 = i21;
                        if ((i6 & 1533916891) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i14 = i13;
                    i15 = i5 & 1024;
                    if (i15 != 0) {
                    }
                    i18 = i5 & 2048;
                    if (i18 != 0) {
                    }
                    i19 = i18;
                    if ((i4 & 896) == 0) {
                    }
                    if ((i4 & 7168) == 0) {
                    }
                    int i3222 = i17;
                    i20 = i5 & 16384;
                    if (i20 != 0) {
                    }
                    i21 = i3222;
                    i22 = i5 & 32768;
                    if (i22 != 0) {
                    }
                    i23 = i5 & 65536;
                    if (i23 != 0) {
                    }
                    if ((i4 & 29360128) == 0) {
                    }
                    if ((i4 & 234881024) == 0) {
                    }
                    int i33222 = i21;
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i12 = i11;
                i13 = i5 & 512;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i5 & 1024;
                if (i15 != 0) {
                }
                i18 = i5 & 2048;
                if (i18 != 0) {
                }
                i19 = i18;
                if ((i4 & 896) == 0) {
                }
                if ((i4 & 7168) == 0) {
                }
                int i32222 = i17;
                i20 = i5 & 16384;
                if (i20 != 0) {
                }
                i21 = i32222;
                i22 = i5 & 32768;
                if (i22 != 0) {
                }
                i23 = i5 & 65536;
                if (i23 != 0) {
                }
                if ((i4 & 29360128) == 0) {
                }
                if ((i4 & 234881024) == 0) {
                }
                int i332222 = i21;
                if ((i6 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z5 = z;
            i8 = i5 & 16;
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
            i12 = i11;
            i13 = i5 & 512;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i5 & 1024;
            if (i15 != 0) {
            }
            i18 = i5 & 2048;
            if (i18 != 0) {
            }
            i19 = i18;
            if ((i4 & 896) == 0) {
            }
            if ((i4 & 7168) == 0) {
            }
            int i322222 = i17;
            i20 = i5 & 16384;
            if (i20 != 0) {
            }
            i21 = i322222;
            i22 = i5 & 32768;
            if (i22 != 0) {
            }
            i23 = i5 & 65536;
            if (i23 != 0) {
            }
            if ((i4 & 29360128) == 0) {
            }
            if ((i4 & 234881024) == 0) {
            }
            int i3322222 = i21;
            if ((i6 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        int i312 = 1024;
        if (i7 == 0) {
        }
        z5 = z;
        i8 = i5 & 16;
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
        i12 = i11;
        i13 = i5 & 512;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i5 & 1024;
        if (i15 != 0) {
        }
        i18 = i5 & 2048;
        if (i18 != 0) {
        }
        i19 = i18;
        if ((i4 & 896) == 0) {
        }
        if ((i4 & 7168) == 0) {
        }
        int i3222222 = i17;
        i20 = i5 & 16384;
        if (i20 != 0) {
        }
        i21 = i3222222;
        i22 = i5 & 32768;
        if (i22 != 0) {
        }
        i23 = i5 & 65536;
        if (i23 != 0) {
        }
        if ((i4 & 29360128) == 0) {
        }
        if ((i4 & 234881024) == 0) {
        }
        int i33222222 = i21;
        if ((i6 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TextFieldLayout(@NotNull final Modifier modifier, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, @Nullable final Function2<? super Composer, ? super Integer, Unit> function23, @Nullable final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, @NotNull final PaddingValues paddingValues, @Nullable Composer composer, final int i) {
        int i2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> textField = function2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2112507061);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function22) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function3) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(function23) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(function24) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2112507061, i2, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:365)");
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            Float fValueOf = Float.valueOf(f);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(paddingValues);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TextFieldMeasurePolicy(z, f, paddingValues);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) objRememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            int i5 = i2;
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
            Updater.m18025setimpl(composerM18018constructorimpl, textFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection2, companion.getSetLayoutDirection());
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            AbstractC1038a.m1220u(2058660585, 642667778, composerStartRestartGroup, 254816194);
            if (function23 != null) {
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
                composerStartRestartGroup.startReplaceableGroup(822730659);
                AbstractC1038a.m1222w(composerStartRestartGroup, (i5 >> 12) & 14, function23);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(254816479);
            if (function24 != null) {
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
                composerStartRestartGroup.startReplaceableGroup(-1007916070);
                AbstractC1038a.m1222w(composerStartRestartGroup, (i5 >> 15) & 14, function24);
            }
            composerStartRestartGroup.endReplaceableGroup();
            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            if (function23 != null) {
                i4 = 0;
                fCalculateStartPadding = C2256Dp.m20968constructorimpl(RangesKt.coerceAtLeast(C2256Dp.m20968constructorimpl(fCalculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), C2256Dp.m20968constructorimpl(0)));
            } else {
                i4 = 0;
            }
            float f4 = fCalculateStartPadding;
            if (function24 != null) {
                fCalculateEndPadding = C2256Dp.m20968constructorimpl(RangesKt.coerceAtLeast(C2256Dp.m20968constructorimpl(fCalculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), C2256Dp.m20968constructorimpl(i4)));
            }
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion2, f4, 0.0f, fCalculateEndPadding, 0.0f, 10, null);
            composerStartRestartGroup.startReplaceableGroup(254817490);
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(companion2, "Hint").then(modifierM15858paddingqDBjuR0$default), composerStartRestartGroup, Integer.valueOf((i5 >> 6) & 112));
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(254817619);
            if (function22 != null) {
                Modifier modifierThen3 = LayoutIdKt.layoutId(companion2, "Label").then(modifierM15858paddingqDBjuR0$default);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
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
                composerStartRestartGroup.startReplaceableGroup(1319246300);
                AbstractC1038a.m1222w(composerStartRestartGroup, (i5 >> 6) & 14, function22);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen4 = LayoutIdKt.layoutId(companion2, "TextField").then(modifierM15858paddingqDBjuR0$default);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composerStartRestartGroup, 48, -1323940314);
            Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor5 = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierThen4);
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
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-2048931960);
            textField = function2;
            textField.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextFieldLayout.2
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

            public final void invoke(@Nullable Composer composer2, int i6) {
                TextFieldKt.TextFieldLayout(modifier, textField, function22, function3, function23, function24, z, f, paddingValues, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m16936calculateHeightO3s9Psw(int i, boolean z, int i2, int i4, int i5, int i6, long j, float f, PaddingValues paddingValues) {
        float f4 = TextFieldTopPadding * f;
        float top = paddingValues.getTop() * f;
        float bottom = paddingValues.getBottom() * f;
        int iMax = Math.max(i, i6);
        return Math.max(MathKt.roundToInt(z ? i2 + f4 + iMax + bottom : top + iMax + bottom), Math.max(Math.max(i4, i5), Constraints.m20922getMinHeightimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final int m16937calculateWidthVsPV1Ek(int i, int i2, int i4, int i5, int i6, long j) {
        return Math.max(Math.max(i4, Math.max(i5, i6)) + i + i2, Constraints.m20923getMinWidthimpl(j));
    }

    @NotNull
    public static final Modifier drawIndicatorLine(@NotNull Modifier modifier, @NotNull final BorderStroke indicatorBorder) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(indicatorBorder, "indicatorBorder");
        final float width = indicatorBorder.getWidth();
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.TextFieldKt.drawIndicatorLine.1
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
                drawWithContent.drawContent();
                if (C2256Dp.m20973equalsimpl0(width, C2256Dp.INSTANCE.m20986getHairlineD9Ej5fM())) {
                    return;
                }
                float density = drawWithContent.getDensity() * width;
                float fM18350getHeightimpl = Size.m18350getHeightimpl(drawWithContent.mo19076getSizeNHjbRc()) - (density / 2);
                DrawScope.m19061drawLine1RTmtNc$default(drawWithContent, indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, fM18350getHeightimpl), OffsetKt.Offset(Size.m18353getWidthimpl(drawWithContent.mo19076getSizeNHjbRc()), fM18350getHeightimpl), density, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z, int i4, int i5, float f, float f4) {
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), (z ? Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i2) : MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f4)) - MathKt.roundToInt((r0 - i4) * f), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable4), i5, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable4), i5, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z, float f, PaddingValues paddingValues) {
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable3), z ? Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i2) : iRoundToInt, 0.0f, 4, null);
        if (placeable2 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable3), iRoundToInt, 0.0f, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x05f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0132  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(@NotNull final TextFieldValue value, @NotNull final Function1<? super TextFieldValue, Unit> onValueChange, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable TextStyle textStyle, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, @Nullable VisualTransformation visualTransformation, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActions keyboardActions, boolean z4, int i, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, @Nullable TextFieldColors textFieldColors, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        TextStyle textStyle2;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function26;
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
        int i24;
        TextStyle textStyle3;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        boolean z7;
        VisualTransformation none;
        int i25;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        MutableInteractionSource mutableInteractionSource2;
        Shape textFieldShape;
        KeyboardOptions keyboardOptions3;
        Modifier modifier3;
        TextStyle textStyle4;
        TextFieldColors textFieldColors2;
        boolean z8;
        int i26;
        KeyboardActions keyboardActions3;
        boolean z9;
        int i27;
        Shape shape2;
        int i28;
        boolean z10;
        long jM20486getColor0d7_KjU;
        final TextFieldColors textFieldColors3;
        final boolean z11;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions4;
        final int i29;
        final MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        final TextStyle textStyle5;
        final Modifier modifier4;
        final boolean z12;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z13;
        final Shape shape3;
        final boolean z14;
        final VisualTransformation visualTransformation2;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1576622884);
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
        int i30 = i5 & 4;
        if (i30 != 0) {
            i6 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            int i31 = 1024;
            if (i7 == 0) {
                i6 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z5 = z;
                    i6 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i8 = i5 & 16;
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
                    function25 = function2;
                } else {
                    function25 = function2;
                    if ((i2 & 3670016) == 0) {
                        i6 |= composerStartRestartGroup.changed(function25) ? 1048576 : 524288;
                    }
                }
                i10 = i5 & 128;
                if (i10 != 0) {
                    i6 |= 12582912;
                    function26 = function22;
                } else {
                    function26 = function22;
                    if ((i2 & 29360128) == 0) {
                        i6 |= composerStartRestartGroup.changed(function26) ? 8388608 : 4194304;
                    }
                }
                i11 = i5 & 256;
                if (i11 != 0) {
                    i6 |= 100663296;
                } else {
                    if ((i2 & 234881024) == 0) {
                        i12 = i11;
                        i6 |= composerStartRestartGroup.changed(function23) ? 67108864 : 33554432;
                    }
                    i13 = i5 & 512;
                    if (i13 == 0) {
                        i6 |= DriveFile.MODE_READ_WRITE;
                    } else {
                        if ((i2 & 1879048192) == 0) {
                            i14 = i13;
                            i6 |= composerStartRestartGroup.changed(function24) ? 536870912 : 268435456;
                        }
                        i15 = i5 & 1024;
                        if (i15 != 0) {
                            i17 = i4 | 6;
                            i16 = i15;
                        } else if ((i4 & 14) == 0) {
                            i16 = i15;
                            i17 = i4 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
                        } else {
                            i16 = i15;
                            i17 = i4;
                        }
                        i18 = i5 & 2048;
                        if (i18 != 0) {
                            i17 |= 48;
                        } else {
                            if ((i4 & 112) == 0) {
                                i19 = i18;
                                i17 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                            }
                            if ((i4 & 896) == 0) {
                                i17 |= ((i5 & 4096) == 0 && composerStartRestartGroup.changed(keyboardOptions)) ? 256 : 128;
                            }
                            if ((i4 & 7168) == 0) {
                                if ((i5 & 8192) == 0 && composerStartRestartGroup.changed(keyboardActions)) {
                                    i31 = 2048;
                                }
                                i17 |= i31;
                            }
                            int i32 = i17;
                            i20 = i5 & 16384;
                            if (i20 != 0) {
                                if ((i4 & 57344) == 0) {
                                    i21 = i32 | (composerStartRestartGroup.changed(z4) ? 16384 : 8192);
                                }
                                i22 = i5 & 32768;
                                if (i22 != 0) {
                                    i21 |= 196608;
                                } else if ((i4 & 458752) == 0) {
                                    i21 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
                                }
                                i23 = i5 & 65536;
                                if (i23 != 0) {
                                    i21 |= 1572864;
                                } else if ((i4 & 3670016) == 0) {
                                    i21 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                                }
                                if ((i4 & 29360128) == 0) {
                                    i21 |= ((i5 & 131072) == 0 && composerStartRestartGroup.changed(shape)) ? 8388608 : 4194304;
                                }
                                if ((i4 & 234881024) == 0) {
                                    i21 |= ((i5 & 262144) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 67108864 : 33554432;
                                }
                                int i33 = i21;
                                if ((i6 & 1533916891) == 306783378 && (191739611 & i33) == 38347922 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    z13 = z3;
                                    keyboardActions4 = keyboardActions;
                                    i29 = i;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    shape3 = shape;
                                    textFieldColors3 = textFieldColors;
                                    z12 = z5;
                                    z11 = z6;
                                    textStyle5 = textStyle2;
                                    function29 = function25;
                                    function211 = function26;
                                    modifier4 = modifier2;
                                    composer2 = composerStartRestartGroup;
                                    function210 = function23;
                                    function212 = function24;
                                    visualTransformation2 = visualTransformation;
                                    keyboardOptions4 = keyboardOptions;
                                    z14 = z4;
                                } else {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i5 & 32) != 0) {
                                            i6 &= -458753;
                                        }
                                        if ((i5 & 4096) != 0) {
                                            i33 &= -897;
                                        }
                                        if ((i5 & 8192) != 0) {
                                            i33 &= -7169;
                                        }
                                        if ((i5 & 131072) != 0) {
                                            i33 &= -29360129;
                                        }
                                        if ((262144 & i5) != 0) {
                                            i33 &= -234881025;
                                        }
                                        function27 = function23;
                                        function28 = function24;
                                        z7 = z3;
                                        none = visualTransformation;
                                        z9 = z4;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        shape2 = shape;
                                        i28 = i33;
                                        i26 = i6;
                                        z8 = z6;
                                        textStyle4 = textStyle2;
                                        modifier3 = modifier2;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        i27 = i;
                                        textFieldColors2 = textFieldColors;
                                    } else {
                                        Modifier modifier5 = i30 == 0 ? Modifier.INSTANCE : modifier2;
                                        boolean z15 = i7 == 0 ? true : z5;
                                        boolean z16 = i8 == 0 ? false : z6;
                                        if ((i5 & 32) == 0) {
                                            i24 = i6 & (-458753);
                                            textStyle3 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                                        } else {
                                            i24 = i6;
                                            textStyle3 = textStyle2;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function213 = i9 == 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function214 = i10 == 0 ? null : function26;
                                        function27 = i12 == 0 ? null : function23;
                                        function28 = i14 == 0 ? null : function24;
                                        z7 = i16 == 0 ? false : z3;
                                        none = i19 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        if ((i5 & 4096) == 0) {
                                            i25 = i33 & (-897);
                                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                        } else {
                                            i25 = i33;
                                            keyboardOptions2 = keyboardOptions;
                                        }
                                        if ((i5 & 8192) == 0) {
                                            i25 &= -7169;
                                            keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                        } else {
                                            keyboardActions2 = keyboardActions;
                                        }
                                        boolean z17 = i20 == 0 ? false : z4;
                                        int i34 = i22 == 0 ? Integer.MAX_VALUE : i;
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
                                        if ((i5 & 131072) == 0) {
                                            i25 &= -29360129;
                                            textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                                        } else {
                                            textFieldShape = shape;
                                        }
                                        int i35 = i25;
                                        if ((262144 & i5) == 0) {
                                            TextFieldColors textFieldColorsM16924textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m16924textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                                            composerStartRestartGroup = composerStartRestartGroup;
                                            TextStyle textStyle6 = textStyle3;
                                            keyboardOptions3 = keyboardOptions2;
                                            modifier3 = modifier5;
                                            textStyle4 = textStyle6;
                                            textFieldColors2 = textFieldColorsM16924textFieldColorsdx8h9Zs;
                                            i28 = i35 & (-234881025);
                                            z5 = z15;
                                            z8 = z16;
                                            i26 = i24;
                                            function25 = function213;
                                            function26 = function214;
                                            keyboardActions3 = keyboardActions2;
                                            z9 = z17;
                                            i27 = i34;
                                            shape2 = textFieldShape;
                                        } else {
                                            TextStyle textStyle7 = textStyle3;
                                            keyboardOptions3 = keyboardOptions2;
                                            modifier3 = modifier5;
                                            textStyle4 = textStyle7;
                                            textFieldColors2 = textFieldColors;
                                            z5 = z15;
                                            z8 = z16;
                                            i26 = i24;
                                            function25 = function213;
                                            function26 = function214;
                                            keyboardActions3 = keyboardActions2;
                                            z9 = z17;
                                            i27 = i34;
                                            shape2 = textFieldShape;
                                            i28 = i35;
                                        }
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        z10 = z8;
                                    } else {
                                        z10 = z8;
                                        ComposerKt.traceEventStart(-1576622884, i26, i28, "androidx.compose.material.TextField (TextField.kt:292)");
                                    }
                                    composerStartRestartGroup.startReplaceableGroup(-833020145);
                                    jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                                    if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                        jM20486getColor0d7_KjU = textFieldColors2.textColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | ((i28 >> 21) & 112)).getValue().m18535unboximpl();
                                    }
                                    long j = jM20486getColor0d7_KjU;
                                    composerStartRestartGroup.endReplaceableGroup();
                                    TextStyle textStyleMerge = textStyle4.merge(new TextStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    int i36 = (i28 >> 21) & 112;
                                    TextStyle textStyle8 = textStyle4;
                                    final int i37 = i26;
                                    final boolean z18 = z5;
                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                    final boolean z19 = z7;
                                    Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(TextFieldDefaults.m16912indicatorLinegv0btCI$default(textFieldDefaults, BackgroundKt.m15408backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | i36).getValue().m18535unboximpl(), shape2), z18, z19, mutableInteractionSource2, textFieldColors4, 0.0f, 0.0f, 48, null), textFieldDefaults.m16919getMinWidthD9Ej5fM(), textFieldDefaults.m16918getMinHeightD9Ej5fM());
                                    Modifier modifier6 = modifier3;
                                    SolidColor solidColor = new SolidColor(textFieldColors4.cursorColor(z19, composerStartRestartGroup, (i28 & 14) | i36).getValue().m18535unboximpl(), null);
                                    final boolean z20 = z9;
                                    final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                    final Function2<? super Composer, ? super Integer, Unit> function216 = function26;
                                    final int i38 = i28;
                                    final Function2<? super Composer, ? super Integer, Unit> function217 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function218 = function28;
                                    final VisualTransformation visualTransformation3 = none;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    textFieldColors3 = textFieldColors4;
                                    int i39 = i38 << 12;
                                    Shape shape4 = shape2;
                                    boolean z21 = z10;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM15883defaultMinSizeVpY3zN4, z18, z21, textStyleMerge, keyboardOptions5, keyboardActions3, z9, i27, visualTransformation3, (Function1) null, mutableInteractionSource4, solidColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2078585677, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer3, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @Composable
                                        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                                        public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> innerTextField, @Nullable Composer composer3, int i40) {
                                            int i41;
                                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                            if ((i40 & 14) == 0) {
                                                i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                                            } else {
                                                i41 = i40;
                                            }
                                            if ((i41 & 91) == 18 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2078585677, i41, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:340)");
                                            }
                                            int i42 = i41;
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            String text = value.getText();
                                            boolean z22 = z18;
                                            boolean z23 = z20;
                                            VisualTransformation visualTransformation4 = visualTransformation3;
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                            boolean z24 = z19;
                                            Function2<Composer, Integer, Unit> function219 = function215;
                                            Function2<Composer, Integer, Unit> function220 = function216;
                                            Function2<Composer, Integer, Unit> function221 = function217;
                                            Function2<Composer, Integer, Unit> function222 = function218;
                                            TextFieldColors textFieldColors5 = textFieldColors4;
                                            int i43 = i37;
                                            int i44 = i38;
                                            textFieldDefaults2.TextFieldDecorationBox(text, innerTextField, z22, z23, visualTransformation4, mutableInteractionSource5, z24, function219, function220, function221, function222, textFieldColors5, null, composer3, ((i44 >> 3) & 7168) | ((i43 >> 3) & 896) | ((i42 << 3) & 112) | ((i44 << 9) & 57344) | ((i44 >> 3) & 458752) | ((i44 << 18) & 3670016) | ((i43 << 3) & 29360128) | ((i43 << 3) & 234881024) | ((i43 << 3) & 1879048192), ((i43 >> 27) & 14) | 3072 | ((i44 >> 21) & 112), 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i37 & 64638) | (i39 & 3670016) | (KeyboardActions.$stable << 21) | (i39 & 29360128) | (i39 & 234881024) | (i39 & 1879048192), ((i38 >> 12) & 896) | ((i38 >> 3) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z11 = z21;
                                    keyboardOptions4 = keyboardOptions5;
                                    keyboardActions4 = keyboardActions3;
                                    i29 = i27;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    composer2 = composerStartRestartGroup;
                                    textStyle5 = textStyle8;
                                    modifier4 = modifier6;
                                    z12 = z18;
                                    function29 = function215;
                                    function210 = function27;
                                    z13 = z19;
                                    shape3 = shape4;
                                    z14 = z9;
                                    visualTransformation2 = visualTransformation3;
                                    function211 = function216;
                                    function212 = function28;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                    return;
                                }
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.6
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

                                    public final void invoke(@Nullable Composer composer3, int i40) {
                                        TextFieldKt.TextField(value, onValueChange, modifier4, z12, z11, textStyle5, function29, function211, function210, function212, z13, visualTransformation2, keyboardOptions4, keyboardActions4, z14, i29, mutableInteractionSource3, shape3, textFieldColors3, composer3, i2 | 1, i4, i5);
                                    }
                                });
                                return;
                            }
                            i32 |= 24576;
                            i21 = i32;
                            i22 = i5 & 32768;
                            if (i22 != 0) {
                            }
                            i23 = i5 & 65536;
                            if (i23 != 0) {
                            }
                            if ((i4 & 29360128) == 0) {
                            }
                            if ((i4 & 234881024) == 0) {
                            }
                            int i332 = i21;
                            if ((i6 & 1533916891) == 306783378) {
                                composerStartRestartGroup.startDefaults();
                                if ((i2 & 1) == 0) {
                                    if (i30 == 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if ((i5 & 32) == 0) {
                                    }
                                    if (i9 == 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i12 == 0) {
                                    }
                                    if (i14 == 0) {
                                    }
                                    if (i16 == 0) {
                                    }
                                    if (i19 == 0) {
                                    }
                                    if ((i5 & 4096) == 0) {
                                    }
                                    if ((i5 & 8192) == 0) {
                                    }
                                    if (i20 == 0) {
                                    }
                                    if (i22 == 0) {
                                    }
                                    if (i23 == 0) {
                                    }
                                    if ((i5 & 131072) == 0) {
                                    }
                                    int i352 = i25;
                                    if ((262144 & i5) == 0) {
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composerStartRestartGroup.startReplaceableGroup(-833020145);
                                    jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                                    if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                    }
                                    long j2 = jM20486getColor0d7_KjU;
                                    composerStartRestartGroup.endReplaceableGroup();
                                    TextStyle textStyleMerge2 = textStyle4.merge(new TextStyle(j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                                    TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                    int i362 = (i28 >> 21) & 112;
                                    TextStyle textStyle82 = textStyle4;
                                    final int i372 = i26;
                                    final boolean z182 = z5;
                                    final TextFieldColors textFieldColors42 = textFieldColors2;
                                    final boolean z192 = z7;
                                    Modifier modifierM15883defaultMinSizeVpY3zN42 = SizeKt.m15883defaultMinSizeVpY3zN4(TextFieldDefaults.m16912indicatorLinegv0btCI$default(textFieldDefaults2, BackgroundKt.m15408backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | i362).getValue().m18535unboximpl(), shape2), z182, z192, mutableInteractionSource2, textFieldColors42, 0.0f, 0.0f, 48, null), textFieldDefaults2.m16919getMinWidthD9Ej5fM(), textFieldDefaults2.m16918getMinHeightD9Ej5fM());
                                    Modifier modifier62 = modifier3;
                                    SolidColor solidColor2 = new SolidColor(textFieldColors42.cursorColor(z192, composerStartRestartGroup, (i28 & 14) | i362).getValue().m18535unboximpl(), null);
                                    final boolean z202 = z9;
                                    final Function2<? super Composer, ? super Integer, Unit> function2152 = function25;
                                    final Function2<? super Composer, ? super Integer, Unit> function2162 = function26;
                                    final int i382 = i28;
                                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function28;
                                    final VisualTransformation visualTransformation32 = none;
                                    final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                                    textFieldColors3 = textFieldColors42;
                                    int i392 = i382 << 12;
                                    Shape shape42 = shape2;
                                    boolean z212 = z10;
                                    KeyboardOptions keyboardOptions52 = keyboardOptions3;
                                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM15883defaultMinSizeVpY3zN42, z182, z212, textStyleMerge2, keyboardOptions52, keyboardActions3, z9, i27, visualTransformation32, (Function1) null, mutableInteractionSource42, solidColor2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2078585677, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer3, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @Composable
                                        @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                                        public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> innerTextField, @Nullable Composer composer3, int i40) {
                                            int i41;
                                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                            if ((i40 & 14) == 0) {
                                                i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                                            } else {
                                                i41 = i40;
                                            }
                                            if ((i41 & 91) == 18 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2078585677, i41, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:340)");
                                            }
                                            int i42 = i41;
                                            TextFieldDefaults textFieldDefaults22 = TextFieldDefaults.INSTANCE;
                                            String text = value.getText();
                                            boolean z22 = z182;
                                            boolean z23 = z202;
                                            VisualTransformation visualTransformation4 = visualTransformation32;
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42;
                                            boolean z24 = z192;
                                            Function2<Composer, Integer, Unit> function219 = function2152;
                                            Function2<Composer, Integer, Unit> function220 = function2162;
                                            Function2<Composer, Integer, Unit> function221 = function2172;
                                            Function2<Composer, Integer, Unit> function222 = function2182;
                                            TextFieldColors textFieldColors5 = textFieldColors42;
                                            int i43 = i372;
                                            int i44 = i382;
                                            textFieldDefaults22.TextFieldDecorationBox(text, innerTextField, z22, z23, visualTransformation4, mutableInteractionSource5, z24, function219, function220, function221, function222, textFieldColors5, null, composer3, ((i44 >> 3) & 7168) | ((i43 >> 3) & 896) | ((i42 << 3) & 112) | ((i44 << 9) & 57344) | ((i44 >> 3) & 458752) | ((i44 << 18) & 3670016) | ((i43 << 3) & 29360128) | ((i43 << 3) & 234881024) | ((i43 << 3) & 1879048192), ((i43 >> 27) & 14) | 3072 | ((i44 >> 21) & 112), 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i372 & 64638) | (i392 & 3670016) | (KeyboardActions.$stable << 21) | (i392 & 29360128) | (i392 & 234881024) | (i392 & 1879048192), ((i382 >> 12) & 896) | ((i382 >> 3) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    z11 = z212;
                                    keyboardOptions4 = keyboardOptions52;
                                    keyboardActions4 = keyboardActions3;
                                    i29 = i27;
                                    mutableInteractionSource3 = mutableInteractionSource42;
                                    composer2 = composerStartRestartGroup;
                                    textStyle5 = textStyle82;
                                    modifier4 = modifier62;
                                    z12 = z182;
                                    function29 = function2152;
                                    function210 = function27;
                                    z13 = z192;
                                    shape3 = shape42;
                                    z14 = z9;
                                    visualTransformation2 = visualTransformation32;
                                    function211 = function2162;
                                    function212 = function28;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i19 = i18;
                        if ((i4 & 896) == 0) {
                        }
                        if ((i4 & 7168) == 0) {
                        }
                        int i322 = i17;
                        i20 = i5 & 16384;
                        if (i20 != 0) {
                        }
                        i21 = i322;
                        i22 = i5 & 32768;
                        if (i22 != 0) {
                        }
                        i23 = i5 & 65536;
                        if (i23 != 0) {
                        }
                        if ((i4 & 29360128) == 0) {
                        }
                        if ((i4 & 234881024) == 0) {
                        }
                        int i3322 = i21;
                        if ((i6 & 1533916891) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i14 = i13;
                    i15 = i5 & 1024;
                    if (i15 != 0) {
                    }
                    i18 = i5 & 2048;
                    if (i18 != 0) {
                    }
                    i19 = i18;
                    if ((i4 & 896) == 0) {
                    }
                    if ((i4 & 7168) == 0) {
                    }
                    int i3222 = i17;
                    i20 = i5 & 16384;
                    if (i20 != 0) {
                    }
                    i21 = i3222;
                    i22 = i5 & 32768;
                    if (i22 != 0) {
                    }
                    i23 = i5 & 65536;
                    if (i23 != 0) {
                    }
                    if ((i4 & 29360128) == 0) {
                    }
                    if ((i4 & 234881024) == 0) {
                    }
                    int i33222 = i21;
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i12 = i11;
                i13 = i5 & 512;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i5 & 1024;
                if (i15 != 0) {
                }
                i18 = i5 & 2048;
                if (i18 != 0) {
                }
                i19 = i18;
                if ((i4 & 896) == 0) {
                }
                if ((i4 & 7168) == 0) {
                }
                int i32222 = i17;
                i20 = i5 & 16384;
                if (i20 != 0) {
                }
                i21 = i32222;
                i22 = i5 & 32768;
                if (i22 != 0) {
                }
                i23 = i5 & 65536;
                if (i23 != 0) {
                }
                if ((i4 & 29360128) == 0) {
                }
                if ((i4 & 234881024) == 0) {
                }
                int i332222 = i21;
                if ((i6 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z5 = z;
            i8 = i5 & 16;
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
            i12 = i11;
            i13 = i5 & 512;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i5 & 1024;
            if (i15 != 0) {
            }
            i18 = i5 & 2048;
            if (i18 != 0) {
            }
            i19 = i18;
            if ((i4 & 896) == 0) {
            }
            if ((i4 & 7168) == 0) {
            }
            int i322222 = i17;
            i20 = i5 & 16384;
            if (i20 != 0) {
            }
            i21 = i322222;
            i22 = i5 & 32768;
            if (i22 != 0) {
            }
            i23 = i5 & 65536;
            if (i23 != 0) {
            }
            if ((i4 & 29360128) == 0) {
            }
            if ((i4 & 234881024) == 0) {
            }
            int i3322222 = i21;
            if ((i6 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        int i312 = 1024;
        if (i7 == 0) {
        }
        z5 = z;
        i8 = i5 & 16;
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
        i12 = i11;
        i13 = i5 & 512;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i5 & 1024;
        if (i15 != 0) {
        }
        i18 = i5 & 2048;
        if (i18 != 0) {
        }
        i19 = i18;
        if ((i4 & 896) == 0) {
        }
        if ((i4 & 7168) == 0) {
        }
        int i3222222 = i17;
        i20 = i5 & 16384;
        if (i20 != 0) {
        }
        i21 = i3222222;
        i22 = i5 & 32768;
        if (i22 != 0) {
        }
        i23 = i5 & 65536;
        if (i23 != 0) {
        }
        if ((i4 & 29360128) == 0) {
        }
        if ((i4 & 234881024) == 0) {
        }
        int i33222222 = i21;
        if ((i6 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
