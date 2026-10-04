package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
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
@Metadata(m13885d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010,\u001aÄ\u0001\u0010-\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t0\r2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00106\u001a\u000207H\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aU\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002022\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a]\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002022\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a)\u0010M\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010N\u001a\u0002042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a|\u0010Q\u001a\u00020\t*\u00020R2\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020$2\b\u0010U\u001a\u0004\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u00010V2\u0006\u0010X\u001a\u00020V2\b\u0010Y\u001a\u0004\u0018\u00010V2\b\u0010Z\u001a\u0004\u0018\u00010V2\u0006\u0010[\u001a\u00020V2\u0006\u00101\u001a\u0002022\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010A\u001a\u0002022\u0006\u0010\\\u001a\u00020]2\u0006\u00106\u001a\u000207H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006^"}, m13886d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-zUg2_y0", "(IIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "isLabelInMiddleSection", "calculateWidth-O3s9Psw", "(IIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", ServerResultMeetingParser.PLACE, "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class OutlinedTextFieldKt {

    @NotNull
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = C2256Dp.m20968constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = C2256Dp.m20968constructorimpl(8);

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
    /* JADX WARN: Removed duplicated region for block: B:270:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05e5  */
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
    public static final void OutlinedTextField(@NotNull final String value, @NotNull final Function1<? super String, Unit> onValueChange, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable TextStyle textStyle, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, @Nullable VisualTransformation visualTransformation, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActions keyboardActions, boolean z4, int i, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, @Nullable TextFieldColors textFieldColors, @Nullable Composer composer, final int i2, final int i4, final int i5) {
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
        VisualTransformation none;
        int i25;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        MutableInteractionSource mutableInteractionSource2;
        Shape small;
        TextFieldColors textFieldColors2;
        KeyboardOptions keyboardOptions3;
        Modifier modifier3;
        TextStyle textStyle4;
        boolean z7;
        int i26;
        boolean z8;
        boolean z9;
        int i27;
        Shape shape2;
        int i28;
        boolean z10;
        long jM20486getColor0d7_KjU;
        TextStyle textStyle5;
        Modifier modifierM15858paddingqDBjuR0$default;
        final TextFieldColors textFieldColors3;
        final boolean z11;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions3;
        final int i29;
        final MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        final TextStyle textStyle6;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z12;
        final Shape shape3;
        final boolean z13;
        final boolean z14;
        final VisualTransformation visualTransformation2;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2099955827);
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
                                    z12 = z3;
                                    keyboardActions3 = keyboardActions;
                                    i29 = i;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    shape3 = shape;
                                    textFieldColors3 = textFieldColors;
                                    z13 = z5;
                                    z11 = z6;
                                    textStyle6 = textStyle2;
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
                                        boolean z17 = i16 == 0 ? false : z3;
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
                                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                                        } else {
                                            keyboardActions2 = keyboardActions;
                                        }
                                        boolean z18 = i20 == 0 ? false : z4;
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
                                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                        } else {
                                            small = shape;
                                        }
                                        int i35 = i25;
                                        if ((262144 & i5) == 0) {
                                            TextFieldColors textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m16922outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                                            composerStartRestartGroup = composerStartRestartGroup;
                                            textFieldColors2 = textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs;
                                            i28 = i35 & (-234881025);
                                            z5 = z15;
                                            z7 = z16;
                                            i26 = i24;
                                            function25 = function213;
                                            function26 = function214;
                                            z9 = z18;
                                            i27 = i34;
                                            shape2 = small;
                                            keyboardOptions3 = keyboardOptions2;
                                            modifier3 = modifier5;
                                            textStyle4 = textStyle3;
                                            z8 = z17;
                                        } else {
                                            textFieldColors2 = textFieldColors;
                                            keyboardOptions3 = keyboardOptions2;
                                            modifier3 = modifier5;
                                            textStyle4 = textStyle3;
                                            z5 = z15;
                                            z7 = z16;
                                            i26 = i24;
                                            function25 = function213;
                                            function26 = function214;
                                            z8 = z17;
                                            z9 = z18;
                                            i27 = i34;
                                            shape2 = small;
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
                                        none = visualTransformation;
                                        keyboardActions2 = keyboardActions;
                                        z9 = z4;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        shape2 = shape;
                                        i28 = i33;
                                        i26 = i6;
                                        z7 = z6;
                                        textStyle4 = textStyle2;
                                        modifier3 = modifier2;
                                        z8 = z3;
                                        keyboardOptions3 = keyboardOptions;
                                        i27 = i;
                                        textFieldColors2 = textFieldColors;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        z10 = z7;
                                    } else {
                                        z10 = z7;
                                        ComposerKt.traceEventStart(-2099955827, i26, i28, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:132)");
                                    }
                                    composerStartRestartGroup.startReplaceableGroup(1961395022);
                                    jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                                    if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                        jM20486getColor0d7_KjU = textFieldColors2.textColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | ((i28 >> 21) & 112)).getValue().m18535unboximpl();
                                    }
                                    long j = jM20486getColor0d7_KjU;
                                    composerStartRestartGroup.endReplaceableGroup();
                                    TextStyle textStyleMerge = textStyle4.merge(new TextStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                                    if (function25 == null) {
                                        textStyle5 = textStyle4;
                                        modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }
                                        }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                                    } else {
                                        textStyle5 = textStyle4;
                                        modifierM15858paddingqDBjuR0$default = modifier3;
                                    }
                                    int i36 = (i28 >> 21) & 112;
                                    final int i37 = i26;
                                    Modifier modifierM15408backgroundbw27NRU = BackgroundKt.m15408backgroundbw27NRU(modifierM15858paddingqDBjuR0$default, textFieldColors2.backgroundColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | i36).getValue().m18535unboximpl(), shape2);
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(modifierM15408backgroundbw27NRU, textFieldDefaults.m16919getMinWidthD9Ej5fM(), textFieldDefaults.m16918getMinHeightD9Ej5fM());
                                    long jM18535unboximpl = textFieldColors2.cursorColor(z8, composerStartRestartGroup, (i28 & 14) | i36).getValue().m18535unboximpl();
                                    Modifier modifier6 = modifier3;
                                    final boolean z19 = z8;
                                    final boolean z20 = z5;
                                    final boolean z21 = z9;
                                    final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                    final Shape shape4 = shape2;
                                    final Function2<? super Composer, ? super Integer, Unit> function216 = function26;
                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                    final int i38 = i28;
                                    final Function2<? super Composer, ? super Integer, Unit> function217 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function218 = function28;
                                    final VisualTransformation visualTransformation3 = none;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    textFieldColors3 = textFieldColors4;
                                    int i39 = i38 << 12;
                                    boolean z22 = z10;
                                    TextStyle textStyle7 = textStyle5;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    KeyboardActions keyboardActions4 = keyboardActions2;
                                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM15883defaultMinSizeVpY3zN4, z20, z22, textStyleMerge, keyboardOptions5, keyboardActions4, z9, i27, visualTransformation3, (Function1) null, mutableInteractionSource4, new SolidColor(jM18535unboximpl, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3
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
                                                ComposerKt.traceEventStart(986454116, i41, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:187)");
                                            }
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            int i42 = i41;
                                            String str = value;
                                            final boolean z23 = z20;
                                            boolean z24 = z21;
                                            VisualTransformation visualTransformation4 = visualTransformation3;
                                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                            final boolean z25 = z19;
                                            Function2<Composer, Integer, Unit> function219 = function215;
                                            Function2<Composer, Integer, Unit> function220 = function216;
                                            Function2<Composer, Integer, Unit> function221 = function217;
                                            Function2<Composer, Integer, Unit> function222 = function218;
                                            final TextFieldColors textFieldColors5 = textFieldColors4;
                                            final Shape shape5 = shape4;
                                            final int i43 = i37;
                                            final int i44 = i38;
                                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3.1
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
                                                public final void invoke(@Nullable Composer composer4, int i45) {
                                                    if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(329542189, i45, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:201)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults3 = TextFieldDefaults.INSTANCE;
                                                    boolean z26 = z23;
                                                    boolean z27 = z25;
                                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                                    TextFieldColors textFieldColors6 = textFieldColors5;
                                                    Shape shape6 = shape5;
                                                    int i46 = ((i43 >> 9) & 14) | 12582912;
                                                    int i47 = i44;
                                                    textFieldDefaults3.m16916BorderBoxnbWgWpA(z26, z27, mutableInteractionSource6, textFieldColors6, shape6, 0.0f, 0.0f, composer4, i46 | ((i47 << 3) & 112) | ((i47 >> 12) & 896) | ((i47 >> 15) & 7168) | ((i47 >> 9) & 57344), 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i45 = i37;
                                            int i46 = i38;
                                            textFieldDefaults2.OutlinedTextFieldDecorationBox(str, innerTextField, z23, z24, visualTransformation4, mutableInteractionSource5, z25, function219, function220, function221, function222, textFieldColors5, null, composableLambda, composer3, (i45 & 14) | ((i42 << 3) & 112) | ((i45 >> 3) & 896) | ((i46 >> 3) & 7168) | ((i46 << 9) & 57344) | ((i46 >> 3) & 458752) | ((i46 << 18) & 3670016) | ((i45 << 3) & 29360128) | ((i45 << 3) & 234881024) | ((i45 << 3) & 1879048192), ((i45 >> 27) & 14) | 27648 | ((i46 >> 21) & 112), 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i37 & 64638) | (i39 & 3670016) | (KeyboardActions.$stable << 21) | (i39 & 29360128) | (i39 & 234881024) | (i39 & 1879048192), ((i38 >> 12) & 896) | ((i38 >> 3) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z11 = z22;
                                    keyboardOptions4 = keyboardOptions5;
                                    keyboardActions3 = keyboardActions4;
                                    i29 = i27;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    composer2 = composerStartRestartGroup;
                                    textStyle6 = textStyle7;
                                    function29 = function215;
                                    function210 = function27;
                                    z12 = z19;
                                    shape3 = shape4;
                                    z13 = z20;
                                    z14 = z9;
                                    visualTransformation2 = visualTransformation3;
                                    modifier4 = modifier6;
                                    function211 = function216;
                                    function212 = function28;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                    return;
                                }
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.4
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
                                        OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier4, z13, z11, textStyle6, function29, function211, function210, function212, z12, visualTransformation2, keyboardOptions4, keyboardActions3, z14, i29, mutableInteractionSource3, shape3, textFieldColors3, composer3, i2 | 1, i4, i5);
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
                                    composerStartRestartGroup.startReplaceableGroup(1961395022);
                                    jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                                    if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                    }
                                    long j2 = jM20486getColor0d7_KjU;
                                    composerStartRestartGroup.endReplaceableGroup();
                                    TextStyle textStyleMerge2 = textStyle4.merge(new TextStyle(j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                                    if (function25 == null) {
                                    }
                                    int i362 = (i28 >> 21) & 112;
                                    final int i372 = i26;
                                    Modifier modifierM15408backgroundbw27NRU2 = BackgroundKt.m15408backgroundbw27NRU(modifierM15858paddingqDBjuR0$default, textFieldColors2.backgroundColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | i362).getValue().m18535unboximpl(), shape2);
                                    TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                    Modifier modifierM15883defaultMinSizeVpY3zN42 = SizeKt.m15883defaultMinSizeVpY3zN4(modifierM15408backgroundbw27NRU2, textFieldDefaults2.m16919getMinWidthD9Ej5fM(), textFieldDefaults2.m16918getMinHeightD9Ej5fM());
                                    long jM18535unboximpl2 = textFieldColors2.cursorColor(z8, composerStartRestartGroup, (i28 & 14) | i362).getValue().m18535unboximpl();
                                    Modifier modifier62 = modifier3;
                                    final boolean z192 = z8;
                                    final boolean z202 = z5;
                                    final boolean z212 = z9;
                                    final Function2<? super Composer, ? super Integer, Unit> function2152 = function25;
                                    final Shape shape42 = shape2;
                                    final Function2<? super Composer, ? super Integer, Unit> function2162 = function26;
                                    final TextFieldColors textFieldColors42 = textFieldColors2;
                                    final int i382 = i28;
                                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function28;
                                    final VisualTransformation visualTransformation32 = none;
                                    final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                                    textFieldColors3 = textFieldColors42;
                                    int i392 = i382 << 12;
                                    boolean z222 = z10;
                                    TextStyle textStyle72 = textStyle5;
                                    KeyboardOptions keyboardOptions52 = keyboardOptions3;
                                    KeyboardActions keyboardActions42 = keyboardActions2;
                                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM15883defaultMinSizeVpY3zN42, z202, z222, textStyleMerge2, keyboardOptions52, keyboardActions42, z9, i27, visualTransformation32, (Function1) null, mutableInteractionSource42, new SolidColor(jM18535unboximpl2, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3
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
                                                ComposerKt.traceEventStart(986454116, i41, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:187)");
                                            }
                                            TextFieldDefaults textFieldDefaults22 = TextFieldDefaults.INSTANCE;
                                            int i42 = i41;
                                            String str = value;
                                            final boolean z23 = z202;
                                            boolean z24 = z212;
                                            VisualTransformation visualTransformation4 = visualTransformation32;
                                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42;
                                            final boolean z25 = z192;
                                            Function2<Composer, Integer, Unit> function219 = function2152;
                                            Function2<Composer, Integer, Unit> function220 = function2162;
                                            Function2<Composer, Integer, Unit> function221 = function2172;
                                            Function2<Composer, Integer, Unit> function222 = function2182;
                                            final TextFieldColors textFieldColors5 = textFieldColors42;
                                            final Shape shape5 = shape42;
                                            final int i43 = i372;
                                            final int i44 = i382;
                                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3.1
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
                                                public final void invoke(@Nullable Composer composer4, int i45) {
                                                    if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(329542189, i45, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:201)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults3 = TextFieldDefaults.INSTANCE;
                                                    boolean z26 = z23;
                                                    boolean z27 = z25;
                                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                                    TextFieldColors textFieldColors6 = textFieldColors5;
                                                    Shape shape6 = shape5;
                                                    int i46 = ((i43 >> 9) & 14) | 12582912;
                                                    int i47 = i44;
                                                    textFieldDefaults3.m16916BorderBoxnbWgWpA(z26, z27, mutableInteractionSource6, textFieldColors6, shape6, 0.0f, 0.0f, composer4, i46 | ((i47 << 3) & 112) | ((i47 >> 12) & 896) | ((i47 >> 15) & 7168) | ((i47 >> 9) & 57344), 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i45 = i372;
                                            int i46 = i382;
                                            textFieldDefaults22.OutlinedTextFieldDecorationBox(str, innerTextField, z23, z24, visualTransformation4, mutableInteractionSource5, z25, function219, function220, function221, function222, textFieldColors5, null, composableLambda, composer3, (i45 & 14) | ((i42 << 3) & 112) | ((i45 >> 3) & 896) | ((i46 >> 3) & 7168) | ((i46 << 9) & 57344) | ((i46 >> 3) & 458752) | ((i46 << 18) & 3670016) | ((i45 << 3) & 29360128) | ((i45 << 3) & 234881024) | ((i45 << 3) & 1879048192), ((i45 >> 27) & 14) | 27648 | ((i46 >> 21) & 112), 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i372 & 64638) | (i392 & 3670016) | (KeyboardActions.$stable << 21) | (i392 & 29360128) | (i392 & 234881024) | (i392 & 1879048192), ((i382 >> 12) & 896) | ((i382 >> 3) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    z11 = z222;
                                    keyboardOptions4 = keyboardOptions52;
                                    keyboardActions3 = keyboardActions42;
                                    i29 = i27;
                                    mutableInteractionSource3 = mutableInteractionSource42;
                                    composer2 = composerStartRestartGroup;
                                    textStyle6 = textStyle72;
                                    function29 = function2152;
                                    function210 = function27;
                                    z12 = z192;
                                    shape3 = shape42;
                                    z13 = z202;
                                    z14 = z9;
                                    visualTransformation2 = visualTransformation32;
                                    modifier4 = modifier62;
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
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void OutlinedTextFieldLayout(@NotNull final Modifier modifier, @NotNull Function2<? super Composer, ? super Integer, Unit> textField, @Nullable final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable final Function2<? super Composer, ? super Integer, Unit> function23, final boolean z, final float f, @NotNull final Function1<? super Size, Unit> onLabelMeasured, @NotNull final Function2<? super Composer, ? super Integer, Unit> border, @NotNull final PaddingValues paddingValues, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        final Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2049536174);
        int i5 = (i & 14) == 0 ? i | (composerStartRestartGroup.changed(modifier) ? 4 : 2) : i;
        if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(function3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(function25) ? 2048 : 1024;
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
            i5 |= composerStartRestartGroup.changed(border) ? 536870912 : 268435456;
        }
        int i6 = i5;
        int i7 = (i2 & 14) == 0 ? i2 | (composerStartRestartGroup.changed(paddingValues) ? 4 : 2) : i2;
        if ((i6 & 1533916891) == 306783378 && (i7 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function24 = textField;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049536174, i6, i7, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:370)");
            }
            Object[] objArr = {onLabelMeasured, Boolean.valueOf(z), Float.valueOf(f), paddingValues};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i8 = 0; i8 < 4; i8++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i8]);
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
            composerStartRestartGroup.startReplaceableGroup(118153609);
            border.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 27) & 14));
            composerStartRestartGroup.startReplaceableGroup(1169914597);
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
                composerStartRestartGroup.startReplaceableGroup(1691709354);
                AbstractC1038a.m1222w(composerStartRestartGroup, (i6 >> 12) & 14, function22);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1169914882);
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
                composerStartRestartGroup.startReplaceableGroup(-1351586719);
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
            composerStartRestartGroup.startReplaceableGroup(1169915893);
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
            composerStartRestartGroup.startReplaceableGroup(-1205597937);
            function24 = textField;
            AbstractC1038a.m1222w(composerStartRestartGroup, (i6 >> 3) & 14, function24);
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
                AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, -55131805);
                function25 = function2;
                AbstractC1038a.m1222w(composerStartRestartGroup, (i6 >> 9) & 14, function25);
            } else {
                function25 = function2;
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
        final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
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

            public final void invoke(@Nullable Composer composer2, int i9) {
                OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier, function26, function3, function25, function22, function23, z, f, onLabelMeasured, border, paddingValues, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-zUg2_y0, reason: not valid java name */
    public static final int m16809calculateHeightzUg2_y0(int i, int i2, int i4, int i5, int i6, long j, float f, PaddingValues paddingValues) {
        int iMax = Math.max(i4, i6);
        return Math.max(Constraints.m20922getMinHeightimpl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(Math.max(paddingValues.getTop() * f, i5 / 2.0f) + iMax + (paddingValues.getBottom() * f)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m16810calculateWidthO3s9Psw(int i, int i2, int i4, int i5, int i6, boolean z, long j, float f, PaddingValues paddingValues) {
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
    public static final Modifier m16811outlineCutout12SF9DM(@NotNull Modifier outlineCutout, final long j, @NotNull final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

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
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f, boolean z, float f4, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f4);
        int iRoundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f4);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f4;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            float f5 = 1 - f;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, MathKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * f5) + iRoundToInt2, MathKt.roundToInt(((z ? Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i) : iRoundToInt) * f5) - ((placeable4.getHeight() / 2) * f)), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), Math.max(z ? Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), i) : iRoundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        if (placeable5 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), i);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable), iRoundToInt, 0.0f, 4, null);
        }
        Placeable.PlacementScope.m19919place70tqf50$default(placementScope, placeable6, IntOffset.INSTANCE.m21106getZeronOccac(), 0.0f, 2, null);
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
    /* JADX WARN: Removed duplicated region for block: B:291:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05fc  */
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
    public static final void OutlinedTextField(@NotNull final TextFieldValue value, @NotNull final Function1<? super TextFieldValue, Unit> onValueChange, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable TextStyle textStyle, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, @Nullable VisualTransformation visualTransformation, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActions keyboardActions, boolean z4, int i, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, @Nullable TextFieldColors textFieldColors, @Nullable Composer composer, final int i2, final int i4, final int i5) {
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
        VisualTransformation none;
        int i25;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        MutableInteractionSource mutableInteractionSource2;
        Shape outlinedTextFieldShape;
        TextFieldColors textFieldColors2;
        KeyboardOptions keyboardOptions3;
        Modifier modifier3;
        TextStyle textStyle4;
        boolean z7;
        int i26;
        boolean z8;
        boolean z9;
        int i27;
        Shape shape2;
        int i28;
        boolean z10;
        long jM20486getColor0d7_KjU;
        TextStyle textStyle5;
        Modifier modifierM15858paddingqDBjuR0$default;
        final TextFieldColors textFieldColors3;
        final boolean z11;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions3;
        final int i29;
        final MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        final TextStyle textStyle6;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z12;
        final Shape shape3;
        final boolean z13;
        final boolean z14;
        final VisualTransformation visualTransformation2;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-288998816);
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
                                    z12 = z3;
                                    keyboardActions3 = keyboardActions;
                                    i29 = i;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    shape3 = shape;
                                    textFieldColors3 = textFieldColors;
                                    z13 = z5;
                                    z11 = z6;
                                    textStyle6 = textStyle2;
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
                                        none = visualTransformation;
                                        keyboardActions2 = keyboardActions;
                                        z9 = z4;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        shape2 = shape;
                                        i28 = i33;
                                        i26 = i6;
                                        z7 = z6;
                                        textStyle4 = textStyle2;
                                        modifier3 = modifier2;
                                        z8 = z3;
                                        keyboardOptions3 = keyboardOptions;
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
                                        boolean z17 = i16 == 0 ? false : z3;
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
                                        boolean z18 = i20 == 0 ? false : z4;
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
                                            outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                                        } else {
                                            outlinedTextFieldShape = shape;
                                        }
                                        int i35 = i25;
                                        if ((262144 & i5) == 0) {
                                            TextFieldColors textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m16922outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                                            composerStartRestartGroup = composerStartRestartGroup;
                                            textFieldColors2 = textFieldColorsM16922outlinedTextFieldColorsdx8h9Zs;
                                            i28 = i35 & (-234881025);
                                            z5 = z15;
                                            z7 = z16;
                                            i26 = i24;
                                            function25 = function213;
                                            function26 = function214;
                                            z9 = z18;
                                            i27 = i34;
                                            shape2 = outlinedTextFieldShape;
                                            keyboardOptions3 = keyboardOptions2;
                                            modifier3 = modifier5;
                                            textStyle4 = textStyle3;
                                            z8 = z17;
                                        } else {
                                            textFieldColors2 = textFieldColors;
                                            keyboardOptions3 = keyboardOptions2;
                                            modifier3 = modifier5;
                                            textStyle4 = textStyle3;
                                            z5 = z15;
                                            z7 = z16;
                                            i26 = i24;
                                            function25 = function213;
                                            function26 = function214;
                                            z8 = z17;
                                            z9 = z18;
                                            i27 = i34;
                                            shape2 = outlinedTextFieldShape;
                                            i28 = i35;
                                        }
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        z10 = z7;
                                    } else {
                                        z10 = z7;
                                        ComposerKt.traceEventStart(-288998816, i26, i28, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:280)");
                                    }
                                    composerStartRestartGroup.startReplaceableGroup(1961402854);
                                    jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                                    if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                        jM20486getColor0d7_KjU = textFieldColors2.textColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | ((i28 >> 21) & 112)).getValue().m18535unboximpl();
                                    }
                                    long j = jM20486getColor0d7_KjU;
                                    composerStartRestartGroup.endReplaceableGroup();
                                    TextStyle textStyleMerge = textStyle4.merge(new TextStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                                    if (function25 == null) {
                                        textStyle5 = textStyle4;
                                        modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.6
                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }
                                        }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                                    } else {
                                        textStyle5 = textStyle4;
                                        modifierM15858paddingqDBjuR0$default = modifier3;
                                    }
                                    int i36 = (i28 >> 21) & 112;
                                    final int i37 = i26;
                                    Modifier modifierM15408backgroundbw27NRU = BackgroundKt.m15408backgroundbw27NRU(modifierM15858paddingqDBjuR0$default, textFieldColors2.backgroundColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | i36).getValue().m18535unboximpl(), shape2);
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(modifierM15408backgroundbw27NRU, textFieldDefaults.m16919getMinWidthD9Ej5fM(), textFieldDefaults.m16918getMinHeightD9Ej5fM());
                                    long jM18535unboximpl = textFieldColors2.cursorColor(z8, composerStartRestartGroup, (i28 & 14) | i36).getValue().m18535unboximpl();
                                    Modifier modifier6 = modifier3;
                                    final boolean z19 = z8;
                                    final boolean z20 = z5;
                                    final boolean z21 = z9;
                                    final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                    final Shape shape4 = shape2;
                                    final Function2<? super Composer, ? super Integer, Unit> function216 = function26;
                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                    final int i38 = i28;
                                    final Function2<? super Composer, ? super Integer, Unit> function217 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function218 = function28;
                                    final VisualTransformation visualTransformation3 = none;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    textFieldColors3 = textFieldColors4;
                                    int i39 = i38 << 12;
                                    boolean z22 = z10;
                                    TextStyle textStyle7 = textStyle5;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    KeyboardActions keyboardActions4 = keyboardActions2;
                                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM15883defaultMinSizeVpY3zN4, z20, z22, textStyleMerge, keyboardOptions5, keyboardActions4, z9, i27, visualTransformation3, (Function1) null, mutableInteractionSource4, new SolidColor(jM18535unboximpl, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.7
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
                                                ComposerKt.traceEventStart(-1219079113, i41, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:335)");
                                            }
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            String text = value.getText();
                                            final boolean z23 = z20;
                                            boolean z24 = z21;
                                            VisualTransformation visualTransformation4 = visualTransformation3;
                                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                            final boolean z25 = z19;
                                            Function2<Composer, Integer, Unit> function219 = function215;
                                            Function2<Composer, Integer, Unit> function220 = function216;
                                            Function2<Composer, Integer, Unit> function221 = function217;
                                            Function2<Composer, Integer, Unit> function222 = function218;
                                            final TextFieldColors textFieldColors5 = textFieldColors4;
                                            final Shape shape5 = shape4;
                                            final int i42 = i37;
                                            final int i43 = i38;
                                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.7.1
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
                                                public final void invoke(@Nullable Composer composer4, int i44) {
                                                    if ((i44 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1225313536, i44, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:349)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults3 = TextFieldDefaults.INSTANCE;
                                                    boolean z26 = z23;
                                                    boolean z27 = z25;
                                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                                    TextFieldColors textFieldColors6 = textFieldColors5;
                                                    Shape shape6 = shape5;
                                                    int i45 = ((i42 >> 9) & 14) | 12582912;
                                                    int i46 = i43;
                                                    textFieldDefaults3.m16916BorderBoxnbWgWpA(z26, z27, mutableInteractionSource6, textFieldColors6, shape6, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i44 = i37;
                                            int i45 = i38;
                                            textFieldDefaults2.OutlinedTextFieldDecorationBox(text, innerTextField, z23, z24, visualTransformation4, mutableInteractionSource5, z25, function219, function220, function221, function222, textFieldColors5, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i37 & 64638) | (i39 & 3670016) | (KeyboardActions.$stable << 21) | (i39 & 29360128) | (i39 & 234881024) | (i39 & 1879048192), ((i38 >> 12) & 896) | ((i38 >> 3) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z11 = z22;
                                    keyboardOptions4 = keyboardOptions5;
                                    keyboardActions3 = keyboardActions4;
                                    i29 = i27;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    composer2 = composerStartRestartGroup;
                                    textStyle6 = textStyle7;
                                    function29 = function215;
                                    function210 = function27;
                                    z12 = z19;
                                    shape3 = shape4;
                                    z13 = z20;
                                    z14 = z9;
                                    visualTransformation2 = visualTransformation3;
                                    modifier4 = modifier6;
                                    function211 = function216;
                                    function212 = function28;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                    return;
                                }
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.8
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
                                        OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier4, z13, z11, textStyle6, function29, function211, function210, function212, z12, visualTransformation2, keyboardOptions4, keyboardActions3, z14, i29, mutableInteractionSource3, shape3, textFieldColors3, composer3, i2 | 1, i4, i5);
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
                                    composerStartRestartGroup.startReplaceableGroup(1961402854);
                                    jM20486getColor0d7_KjU = textStyle4.m20486getColor0d7_KjU();
                                    if (jM20486getColor0d7_KjU == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
                                    }
                                    long j2 = jM20486getColor0d7_KjU;
                                    composerStartRestartGroup.endReplaceableGroup();
                                    TextStyle textStyleMerge2 = textStyle4.merge(new TextStyle(j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                                    if (function25 == null) {
                                    }
                                    int i362 = (i28 >> 21) & 112;
                                    final int i372 = i26;
                                    Modifier modifierM15408backgroundbw27NRU2 = BackgroundKt.m15408backgroundbw27NRU(modifierM15858paddingqDBjuR0$default, textFieldColors2.backgroundColor(z5, composerStartRestartGroup, ((i26 >> 9) & 14) | i362).getValue().m18535unboximpl(), shape2);
                                    TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                    Modifier modifierM15883defaultMinSizeVpY3zN42 = SizeKt.m15883defaultMinSizeVpY3zN4(modifierM15408backgroundbw27NRU2, textFieldDefaults2.m16919getMinWidthD9Ej5fM(), textFieldDefaults2.m16918getMinHeightD9Ej5fM());
                                    long jM18535unboximpl2 = textFieldColors2.cursorColor(z8, composerStartRestartGroup, (i28 & 14) | i362).getValue().m18535unboximpl();
                                    Modifier modifier62 = modifier3;
                                    final boolean z192 = z8;
                                    final boolean z202 = z5;
                                    final boolean z212 = z9;
                                    final Function2<? super Composer, ? super Integer, Unit> function2152 = function25;
                                    final Shape shape42 = shape2;
                                    final Function2<? super Composer, ? super Integer, Unit> function2162 = function26;
                                    final TextFieldColors textFieldColors42 = textFieldColors2;
                                    final int i382 = i28;
                                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function28;
                                    final VisualTransformation visualTransformation32 = none;
                                    final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                                    textFieldColors3 = textFieldColors42;
                                    int i392 = i382 << 12;
                                    boolean z222 = z10;
                                    TextStyle textStyle72 = textStyle5;
                                    KeyboardOptions keyboardOptions52 = keyboardOptions3;
                                    KeyboardActions keyboardActions42 = keyboardActions2;
                                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM15883defaultMinSizeVpY3zN42, z202, z222, textStyleMerge2, keyboardOptions52, keyboardActions42, z9, i27, visualTransformation32, (Function1) null, mutableInteractionSource42, new SolidColor(jM18535unboximpl2, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.7
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
                                                ComposerKt.traceEventStart(-1219079113, i41, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:335)");
                                            }
                                            TextFieldDefaults textFieldDefaults22 = TextFieldDefaults.INSTANCE;
                                            String text = value.getText();
                                            final boolean z23 = z202;
                                            boolean z24 = z212;
                                            VisualTransformation visualTransformation4 = visualTransformation32;
                                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42;
                                            final boolean z25 = z192;
                                            Function2<Composer, Integer, Unit> function219 = function2152;
                                            Function2<Composer, Integer, Unit> function220 = function2162;
                                            Function2<Composer, Integer, Unit> function221 = function2172;
                                            Function2<Composer, Integer, Unit> function222 = function2182;
                                            final TextFieldColors textFieldColors5 = textFieldColors42;
                                            final Shape shape5 = shape42;
                                            final int i42 = i372;
                                            final int i43 = i382;
                                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.7.1
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
                                                public final void invoke(@Nullable Composer composer4, int i44) {
                                                    if ((i44 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1225313536, i44, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:349)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults3 = TextFieldDefaults.INSTANCE;
                                                    boolean z26 = z23;
                                                    boolean z27 = z25;
                                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                                    TextFieldColors textFieldColors6 = textFieldColors5;
                                                    Shape shape6 = shape5;
                                                    int i45 = ((i42 >> 9) & 14) | 12582912;
                                                    int i46 = i43;
                                                    textFieldDefaults3.m16916BorderBoxnbWgWpA(z26, z27, mutableInteractionSource6, textFieldColors6, shape6, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            int i44 = i372;
                                            int i45 = i382;
                                            textFieldDefaults22.OutlinedTextFieldDecorationBox(text, innerTextField, z23, z24, visualTransformation4, mutableInteractionSource5, z25, function219, function220, function221, function222, textFieldColors5, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i372 & 64638) | (i392 & 3670016) | (KeyboardActions.$stable << 21) | (i392 & 29360128) | (i392 & 234881024) | (i392 & 1879048192), ((i382 >> 12) & 896) | ((i382 >> 3) & 14) | 24576, 2048);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    z11 = z222;
                                    keyboardOptions4 = keyboardOptions52;
                                    keyboardActions3 = keyboardActions42;
                                    i29 = i27;
                                    mutableInteractionSource3 = mutableInteractionSource42;
                                    composer2 = composerStartRestartGroup;
                                    textStyle6 = textStyle72;
                                    function29 = function2152;
                                    function210 = function27;
                                    z12 = z192;
                                    shape3 = shape42;
                                    z13 = z202;
                                    z14 = z9;
                                    visualTransformation2 = visualTransformation32;
                                    modifier4 = modifier62;
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
