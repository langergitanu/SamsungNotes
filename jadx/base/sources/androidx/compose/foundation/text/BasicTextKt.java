package androidx.compose.foundation.text;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.ColorProducer;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.Placeholder;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.spen.libsdl.SdlMediaRecorder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010 \u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010!\u001a°\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010#\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a@\u0010,\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000.\u0018\u00010-2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e00H\u0002\u001a\u001e\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207062\b\u00108\u001a\u0004\u0018\u000109H\u0002\u001aÂ\u0001\u0010:\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0014\u0010;\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<\u0018\u00010-2\u001c\u0010>\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010?0-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0003X\u008a\u008e\u0002"}, m13886d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "LayoutWithLinksAndInlineContent", "hasInlineContent", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "LayoutWithLinksAndInlineContent-vOo2fZY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "textModifier", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "textModifier-cFh6CEA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "foundation_release", "displayedText"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBasicText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicText.kt\nandroidx/compose/foundation/text/BasicTextKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 8 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 9 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,606:1\n77#2:607\n77#2:608\n77#2:621\n77#2:622\n77#2:653\n77#2:654\n77#2:667\n77#2:704\n1225#3,6:609\n1225#3,6:615\n1225#3,6:655\n1225#3,6:661\n1225#3,6:698\n1225#3,6:705\n1225#3,6:723\n1225#3,6:729\n1225#3,6:735\n1225#3,6:741\n1225#3,6:747\n1225#3,6:753\n1225#3,6:759\n1225#3,6:765\n1225#3,6:771\n125#4,6:623\n132#4,5:638\n137#4:649\n139#4:652\n125#4,6:668\n132#4,5:683\n137#4:694\n139#4:697\n79#4,6:777\n86#4,4:792\n90#4,2:802\n94#4:807\n289#5,9:629\n298#5,2:650\n289#5,9:674\n298#5,2:695\n368#5,9:783\n377#5,3:804\n4034#6,6:643\n4034#6,6:688\n4034#6,6:796\n298#7,3:711\n69#7,4:714\n301#7:718\n302#7:720\n74#7:721\n303#7:722\n1#8:719\n81#9:808\n107#9,2:809\n*S KotlinDebug\n*F\n+ 1 BasicText.kt\nandroidx/compose/foundation/text/BasicTextKt\n*L\n102#1:607\n104#1:608\n131#1:621\n144#1:622\n197#1:653\n199#1:654\n230#1:667\n255#1:704\n106#1:609,6\n109#1:615,6\n201#1:655,6\n204#1:661,6\n242#1:698,6\n258#1:705,6\n540#1:723,6\n546#1:729,6\n549#1:735,6\n559#1:741,6\n563#1:747,6\n579#1:753,6\n596#1:759,6\n600#1:765,6\n601#1:771,6\n152#1:623,6\n152#1:638,5\n152#1:649\n152#1:652\n218#1:668,6\n218#1:683,5\n218#1:694\n218#1:697\n566#1:777,6\n566#1:792,4\n566#1:802,2\n566#1:807\n152#1:629,9\n152#1:650,2\n218#1:674,9\n218#1:695,2\n566#1:783,9\n566#1:804,3\n152#1:643,6\n218#1:688,6\n566#1:796,6\n449#1:711,3\n449#1:714,4\n449#1:718\n449#1:720\n449#1:721\n449#1:722\n449#1:719\n242#1:808\n242#1:809,2\n*E\n"})
public final class BasicTextKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    @Composable
    /* JADX INFO: renamed from: BasicText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m16144BasicText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Map map, Composer composer, final int i4, final int i5) {
        AnnotatedString annotatedString2;
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        Function1 function12;
        int i9;
        int iM20906getClipgIe3tQ8;
        int i10;
        boolean z2;
        int i11;
        int i12;
        int i13;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final int i14;
        final boolean z3;
        final int i15;
        final Map map2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-648605928);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i4 & 6) == 0) {
                i6 = (composerStartRestartGroup.changed(annotatedString2) ? 4 : 2) | i4;
            } else {
                i6 = i4;
            }
        }
        int i16 = i5 & 2;
        if (i16 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        function12 = function1;
                        i6 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            iM20906getClipgIe3tQ8 = i;
                            i6 |= composerStartRestartGroup.changed(iM20906getClipgIe3tQ8) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= 196608;
                        } else {
                            if ((196608 & i4) == 0) {
                                z2 = z;
                                i6 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                            }
                            i11 = i5 & 64;
                            if (i11 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i12 = i5 & 128;
                            if (i12 != 0) {
                                if ((i4 & 12582912) == 0) {
                                    i13 = i12;
                                    i6 |= composerStartRestartGroup.changedInstance(map) ? 8388608 : 4194304;
                                }
                                if ((i6 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    i15 = i2;
                                    modifier3 = modifier2;
                                    textStyle3 = textStyle2;
                                    function13 = function12;
                                    i14 = iM20906getClipgIe3tQ8;
                                    z3 = z2;
                                    map2 = map;
                                } else {
                                    Modifier modifier4 = i16 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i7 != 0) {
                                        textStyle2 = TextStyle.INSTANCE.getDefault();
                                    }
                                    if (i8 != 0) {
                                        function12 = null;
                                    }
                                    if (i9 != 0) {
                                        iM20906getClipgIe3tQ8 = TextOverflow.INSTANCE.m20906getClipgIe3tQ8();
                                    }
                                    if (i10 != 0) {
                                        z2 = true;
                                    }
                                    int i17 = i11 == 0 ? Integer.MAX_VALUE : i2;
                                    Map mapEmptyMap = i13 == 0 ? MapsKt.emptyMap() : map;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-648605928, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:302)");
                                    }
                                    Modifier modifier5 = modifier4;
                                    int i18 = i17;
                                    Function1 function14 = function12;
                                    boolean z4 = z2;
                                    int i19 = iM20906getClipgIe3tQ8;
                                    TextStyle textStyle4 = textStyle2;
                                    m16147BasicTextRWo7tUw(annotatedString2, modifier5, textStyle4, function14, i19, z4, i18, 1, mapEmptyMap, null, composerStartRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | ((i6 << 3) & 234881024), 512);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier5;
                                    textStyle3 = textStyle4;
                                    function13 = function14;
                                    i14 = i19;
                                    z3 = z4;
                                    i15 = i18;
                                    map2 = mapEmptyMap;
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$5
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

                                        public final void invoke(@Nullable Composer composer2, int i20) {
                                            BasicTextKt.m16144BasicText4YKlhWE(annotatedString, modifier3, textStyle3, function13, i14, z3, i15, map2, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i6 |= 12582912;
                            i13 = i12;
                            if ((i6 & 4793491) == 4793490) {
                                if (i16 == 0) {
                                }
                                if (i7 != 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i9 != 0) {
                                }
                                if (i10 != 0) {
                                }
                                if (i11 == 0) {
                                }
                                if (i13 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                Modifier modifier52 = modifier4;
                                int i182 = i17;
                                Function1 function142 = function12;
                                boolean z42 = z2;
                                int i192 = iM20906getClipgIe3tQ8;
                                TextStyle textStyle42 = textStyle2;
                                m16147BasicTextRWo7tUw(annotatedString2, modifier52, textStyle42, function142, i192, z42, i182, 1, mapEmptyMap, null, composerStartRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | ((i6 << 3) & 234881024), 512);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier3 = modifier52;
                                textStyle3 = textStyle42;
                                function13 = function142;
                                i14 = i192;
                                z3 = z42;
                                i15 = i182;
                                map2 = mapEmptyMap;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        z2 = z;
                        i11 = i5 & 64;
                        if (i11 == 0) {
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                        }
                        i13 = i12;
                        if ((i6 & 4793491) == 4793490) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    iM20906getClipgIe3tQ8 = i;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    z2 = z;
                    i11 = i5 & 64;
                    if (i11 == 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    if ((i6 & 4793491) == 4793490) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                iM20906getClipgIe3tQ8 = i;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                z2 = z;
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                i13 = i12;
                if ((i6 & 4793491) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            iM20906getClipgIe3tQ8 = i;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            z2 = z;
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            i13 = i12;
            if ((i6 & 4793491) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        iM20906getClipgIe3tQ8 = i;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        z2 = z;
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        i13 = i12;
        if ((i6 & 4793491) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0111  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    @Composable
    /* JADX INFO: renamed from: BasicText-BpD7jsM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m16146BasicTextBpD7jsM(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Composer composer, final int i4, final int i5) {
        String str2;
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        Function1 function12;
        int i9;
        int iM20906getClipgIe3tQ8;
        int i10;
        boolean z2;
        int i11;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final int i12;
        final int i13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1022429478);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i4 & 6) == 0) {
                i6 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i4;
            } else {
                i6 = i4;
            }
        }
        int i14 = i5 & 2;
        if (i14 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        function12 = function1;
                        i6 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            iM20906getClipgIe3tQ8 = i;
                            i6 |= composerStartRestartGroup.changed(iM20906getClipgIe3tQ8) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 == 0) {
                            if ((196608 & i4) == 0) {
                                z2 = z;
                                i6 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                            }
                            i11 = i5 & 64;
                            if (i11 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            if ((i6 & 599187) == 599186 || !composerStartRestartGroup.getSkipping()) {
                                Modifier modifier4 = i14 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i7 != 0) {
                                    textStyle2 = TextStyle.INSTANCE.getDefault();
                                }
                                if (i8 != 0) {
                                    function12 = null;
                                }
                                if (i9 != 0) {
                                    iM20906getClipgIe3tQ8 = TextOverflow.INSTANCE.m20906getClipgIe3tQ8();
                                }
                                if (i10 != 0) {
                                    z2 = true;
                                }
                                int i15 = i11 == 0 ? Integer.MAX_VALUE : i2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1022429478, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:278)");
                                }
                                TextStyle textStyle4 = textStyle2;
                                int i16 = iM20906getClipgIe3tQ8;
                                Function1 function14 = function12;
                                Modifier modifier5 = modifier4;
                                m16149BasicTextVhcvRP8(str2, modifier5, textStyle4, (Function1<? super TextLayoutResult, Unit>) function14, i16, z2, i15, 1, (ColorProducer) null, composerStartRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 256);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier5;
                                textStyle3 = textStyle4;
                                function13 = function14;
                                i12 = i16;
                                i13 = i15;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i13 = i2;
                                modifier3 = modifier2;
                                textStyle3 = textStyle2;
                                function13 = function12;
                                i12 = iM20906getClipgIe3tQ8;
                            }
                            final boolean z3 = z2;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$4
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

                                    public final void invoke(@Nullable Composer composer2, int i17) {
                                        BasicTextKt.m16146BasicTextBpD7jsM(str, modifier3, textStyle3, function13, i12, z3, i13, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i6 |= 196608;
                        z2 = z;
                        i11 = i5 & 64;
                        if (i11 == 0) {
                        }
                        if ((i6 & 599187) == 599186) {
                            if (i14 == 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            TextStyle textStyle42 = textStyle2;
                            int i162 = iM20906getClipgIe3tQ8;
                            Function1 function142 = function12;
                            Modifier modifier52 = modifier4;
                            m16149BasicTextVhcvRP8(str2, modifier52, textStyle42, (Function1<? super TextLayoutResult, Unit>) function142, i162, z2, i15, 1, (ColorProducer) null, composerStartRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 256);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier52;
                            textStyle3 = textStyle42;
                            function13 = function142;
                            i12 = i162;
                            i13 = i15;
                        }
                        final boolean z32 = z2;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    iM20906getClipgIe3tQ8 = i;
                    i10 = i5 & 32;
                    if (i10 == 0) {
                    }
                    z2 = z;
                    i11 = i5 & 64;
                    if (i11 == 0) {
                    }
                    if ((i6 & 599187) == 599186) {
                    }
                    final boolean z322 = z2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                iM20906getClipgIe3tQ8 = i;
                i10 = i5 & 32;
                if (i10 == 0) {
                }
                z2 = z;
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                if ((i6 & 599187) == 599186) {
                }
                final boolean z3222 = z2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            iM20906getClipgIe3tQ8 = i;
            i10 = i5 & 32;
            if (i10 == 0) {
            }
            z2 = z;
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            if ((i6 & 599187) == 599186) {
            }
            final boolean z32222 = z2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        iM20906getClipgIe3tQ8 = i;
        i10 = i5 & 32;
        if (i10 == 0) {
        }
        z2 = z;
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        if ((i6 & 599187) == 599186) {
        }
        final boolean z322222 = z2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: BasicText-RWo7tUw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16147BasicTextRWo7tUw(@NotNull AnnotatedString annotatedString, @Nullable Modifier modifier, @Nullable TextStyle textStyle, @Nullable Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i4, @Nullable Map<String, InlineTextContent> map, @Nullable ColorProducer colorProducer, @Nullable Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        TextStyle textStyle2;
        int i9;
        Function1<? super TextLayoutResult, Unit> function12;
        int i10;
        int iM20906getClipgIe3tQ8;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Modifier modifier3;
        Map<String, InlineTextContent> mapEmptyMap;
        ColorProducer colorProducer2;
        final SelectionRegistrar selectionRegistrar;
        int i20;
        int i21;
        int i22;
        Composer composer2;
        SelectionController selectionController;
        boolean zHasInlineContent;
        final AnnotatedString annotatedString2;
        boolean z3;
        Composer composer3;
        boolean z4;
        int i23;
        int i24;
        int i25;
        Object objRememberedValue;
        final MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue2;
        TextStyle textStyle3;
        Function1<? super TextLayoutResult, Unit> function13;
        Composer composer4;
        Composer composer5;
        final int i26;
        final ColorProducer colorProducer3;
        final Map<String, InlineTextContent> map2;
        final TextStyle textStyle4;
        final Modifier modifier4;
        final int i27;
        final boolean z5;
        final int i28;
        final Function1<? super TextLayoutResult, Unit> function14;
        long jLongValue;
        boolean zChanged2;
        Object objRememberedValue3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1064305212);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i29 = i6 & 2;
        if (i29 != 0) {
            i7 |= 48;
        } else {
            if ((i5 & 48) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else {
                if ((i5 & 384) == 0) {
                    textStyle2 = textStyle;
                    i7 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i5 & 3072) == 0) {
                        function12 = function1;
                        i7 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else {
                        if ((i5 & 24576) == 0) {
                            iM20906getClipgIe3tQ8 = i;
                            i7 |= composerStartRestartGroup.changed(iM20906getClipgIe3tQ8) ? 16384 : 8192;
                        }
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                            z2 = z;
                        } else {
                            z2 = z;
                            if ((i5 & 196608) == 0) {
                                i7 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                            }
                        }
                        i12 = i6 & 64;
                        if (i12 != 0) {
                            i7 |= 1572864;
                            i13 = i2;
                        } else {
                            i13 = i2;
                            if ((i5 & 1572864) == 0) {
                                i7 |= composerStartRestartGroup.changed(i13) ? 1048576 : 524288;
                            }
                        }
                        i14 = i6 & 128;
                        if (i14 != 0) {
                            i7 |= 12582912;
                        } else {
                            if ((i5 & 12582912) == 0) {
                                i15 = i14;
                                i7 |= composerStartRestartGroup.changed(i4) ? 8388608 : 4194304;
                            }
                            i16 = i6 & 256;
                            if (i16 == 0) {
                                i7 |= 100663296;
                            } else {
                                if ((i5 & 100663296) == 0) {
                                    i17 = i16;
                                    i7 |= composerStartRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                                }
                                i18 = i6 & 512;
                                if (i18 == 0) {
                                    if ((i5 & DriveFile.MODE_READ_WRITE) == 0) {
                                        i19 = i18;
                                        i7 |= composerStartRestartGroup.changedInstance(colorProducer) ? 536870912 : 268435456;
                                    }
                                    if ((i7 & 306783379) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                        modifier3 = i29 == 0 ? Modifier.INSTANCE : modifier2;
                                        if (i8 != 0) {
                                            textStyle2 = TextStyle.INSTANCE.getDefault();
                                        }
                                        if (i9 != 0) {
                                            function12 = null;
                                        }
                                        if (i10 != 0) {
                                            iM20906getClipgIe3tQ8 = TextOverflow.INSTANCE.m20906getClipgIe3tQ8();
                                        }
                                        if (i11 != 0) {
                                            z2 = true;
                                        }
                                        if (i12 != 0) {
                                            i13 = Integer.MAX_VALUE;
                                        }
                                        int i30 = i13;
                                        int i31 = i15 == 0 ? 1 : i4;
                                        mapEmptyMap = i17 == 0 ? MapsKt.emptyMap() : map;
                                        colorProducer2 = i19 == 0 ? null : colorProducer;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1064305212, i7, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:191)");
                                        }
                                        HeightInLinesModifierKt.validateMinMaxLines(i31, i30);
                                        selectionRegistrar = (SelectionRegistrar) composerStartRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
                                        if (selectionRegistrar == null) {
                                            composerStartRestartGroup.startReplaceGroup(-1584983428);
                                            long backgroundColor = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getBackgroundColor();
                                            Object[] objArr = {selectionRegistrar};
                                            Saver<Long, Long> saverSelectionIdSaver = selectionIdSaver(selectionRegistrar);
                                            boolean zChangedInstance = composerStartRestartGroup.changedInstance(selectionRegistrar);
                                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                i20 = i7;
                                            } else {
                                                i20 = i7;
                                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                }
                                                composer2 = composerStartRestartGroup;
                                                Number number = (Number) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) saverSelectionIdSaver, (String) null, (Function0) objRememberedValue4, composerStartRestartGroup, 0, 4);
                                                i21 = i30;
                                                i22 = i31;
                                                jLongValue = number.longValue();
                                                zChanged2 = composer2.changed(jLongValue) | composer2.changed(selectionRegistrar) | composer2.changed(backgroundColor);
                                                objRememberedValue3 = composer2.rememberedValue();
                                                if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue3 = new SelectionController(jLongValue, selectionRegistrar, backgroundColor, null, 8, null);
                                                    composer2.updateRememberedValue(objRememberedValue3);
                                                }
                                                selectionController = (SelectionController) objRememberedValue3;
                                                composer2.endReplaceGroup();
                                            }
                                            objRememberedValue4 = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$2$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                @NotNull
                                                public final Long invoke() {
                                                    return Long.valueOf(selectionRegistrar.nextSelectableId());
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                            composer2 = composerStartRestartGroup;
                                            Number number2 = (Number) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) saverSelectionIdSaver, (String) null, (Function0) objRememberedValue4, composerStartRestartGroup, 0, 4);
                                            i21 = i30;
                                            i22 = i31;
                                            jLongValue = number2.longValue();
                                            zChanged2 = composer2.changed(jLongValue) | composer2.changed(selectionRegistrar) | composer2.changed(backgroundColor);
                                            objRememberedValue3 = composer2.rememberedValue();
                                            if (!zChanged2) {
                                                objRememberedValue3 = new SelectionController(jLongValue, selectionRegistrar, backgroundColor, null, 8, null);
                                                composer2.updateRememberedValue(objRememberedValue3);
                                                selectionController = (SelectionController) objRememberedValue3;
                                                composer2.endReplaceGroup();
                                            }
                                        } else {
                                            i20 = i7;
                                            i21 = i30;
                                            i22 = i31;
                                            composer2 = composerStartRestartGroup;
                                            composer2.startReplaceGroup(-1584467526);
                                            composer2.endReplaceGroup();
                                            selectionController = null;
                                        }
                                        zHasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
                                        boolean zHasLinks = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
                                        if (!zHasInlineContent || zHasLinks) {
                                            annotatedString2 = annotatedString;
                                            z3 = false;
                                            composer3 = composer2;
                                            z4 = z2;
                                            i23 = i21;
                                            TextStyle textStyle5 = textStyle2;
                                            i24 = i22;
                                            Function1<? super TextLayoutResult, Unit> function15 = function12;
                                            i25 = iM20906getClipgIe3tQ8;
                                            SelectionController selectionController2 = selectionController;
                                            composer3.startReplaceGroup(-1583391888);
                                            if ((i20 & 14) == 4) {
                                                z3 = true;
                                            }
                                            objRememberedValue = composer3.rememberedValue();
                                            if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString2, null, 2, null);
                                                composer3.updateRememberedValue(objRememberedValue);
                                            }
                                            mutableState = (MutableState) objRememberedValue;
                                            AnnotatedString annotatedStringBasicText_RWo7tUw$lambda$5 = BasicText_RWo7tUw$lambda$5(mutableState);
                                            FontFamily.Resolver resolver = (FontFamily.Resolver) composer3.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                            zChanged = composer3.changed(mutableState);
                                            objRememberedValue2 = composer3.rememberedValue();
                                            if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue2 = new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                                                        invoke2(textSubstitutionValue);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@NotNull TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                                                        mutableState.setValue(textSubstitutionValue.isShowingSubstitution() ? textSubstitutionValue.getSubstitution() : textSubstitutionValue.getOriginal());
                                                    }
                                                };
                                                composer3.updateRememberedValue(objRememberedValue2);
                                            }
                                            int i32 = i20 << 6;
                                            textStyle3 = textStyle5;
                                            function13 = function15;
                                            Modifier modifier5 = modifier3;
                                            m16150LayoutWithLinksAndInlineContentvOo2fZY(modifier5, annotatedStringBasicText_RWo7tUw$lambda$5, function13, zHasInlineContent, mapEmptyMap, textStyle3, i25, z4, i23, i24, resolver, selectionController2, colorProducer2, (Function1) objRememberedValue2, composer3, ((i20 >> 3) & SdlMediaRecorder.MEDIA_RECORDER_INFO_NO_NETWORK) | ((i20 >> 12) & 57344) | ((i20 << 9) & 458752) | (3670016 & i32) | (29360128 & i32) | (234881024 & i32) | (i32 & 1879048192), (i20 >> 21) & 896, 0);
                                            composer4 = composer3;
                                            modifier3 = modifier5;
                                            composer4.endReplaceGroup();
                                        } else {
                                            composer2.startReplaceGroup(-1584294453);
                                            Modifier modifierM18686graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(modifier3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                                            FontFamily.Resolver resolver2 = (FontFamily.Resolver) composer2.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                            i24 = i22;
                                            TextStyle textStyle6 = textStyle2;
                                            Composer composer6 = composer2;
                                            i23 = i21;
                                            Function1<? super TextLayoutResult, Unit> function16 = function12;
                                            annotatedString2 = annotatedString;
                                            z4 = z2;
                                            i25 = iM20906getClipgIe3tQ8;
                                            Modifier modifierM16152textModifiercFh6CEA = m16152textModifiercFh6CEA(modifierM18686graphicsLayerAp8cVGQ$default, annotatedString2, textStyle6, function16, i25, z4, i23, i24, resolver2, null, null, selectionController, colorProducer2, null);
                                            EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer6, modifierM16152textModifiercFh6CEA);
                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                                            if (composer6.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer6.startReusableNode();
                                            if (composer6.getInserting()) {
                                                composer6.createNode(constructor);
                                            } else {
                                                composer6.useNode();
                                            }
                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer6);
                                            Updater.m18025setimpl(composerM18018constructorimpl, emptyMeasurePolicy, companion.getSetMeasurePolicy());
                                            Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                                            }
                                            composer6.endNode();
                                            composer6.endReplaceGroup();
                                            textStyle3 = textStyle6;
                                            function13 = function16;
                                            composer4 = composer6;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer5 = composer4;
                                        i26 = i24;
                                        colorProducer3 = colorProducer2;
                                        map2 = mapEmptyMap;
                                        textStyle4 = textStyle3;
                                        modifier4 = modifier3;
                                        i27 = i23;
                                        z5 = z4;
                                        i28 = i25;
                                        function14 = function13;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        annotatedString2 = annotatedString;
                                        i26 = i4;
                                        colorProducer3 = colorProducer;
                                        composer5 = composerStartRestartGroup;
                                        z5 = z2;
                                        modifier4 = modifier2;
                                        textStyle4 = textStyle2;
                                        function14 = function12;
                                        map2 = map;
                                        i27 = i13;
                                        i28 = iM20906getClipgIe3tQ8;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                invoke(composer7, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@Nullable Composer composer7, int i33) {
                                                BasicTextKt.m16147BasicTextRWo7tUw(annotatedString2, modifier4, textStyle4, function14, i28, z5, i27, i26, map2, colorProducer3, composer7, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i7 |= DriveFile.MODE_READ_WRITE;
                                i19 = i18;
                                if ((i7 & 306783379) == 306783378) {
                                    if (i29 == 0) {
                                    }
                                    if (i8 != 0) {
                                    }
                                    if (i9 != 0) {
                                    }
                                    if (i10 != 0) {
                                    }
                                    if (i11 != 0) {
                                    }
                                    if (i12 != 0) {
                                    }
                                    int i302 = i13;
                                    if (i15 == 0) {
                                    }
                                    if (i17 == 0) {
                                    }
                                    if (i19 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    HeightInLinesModifierKt.validateMinMaxLines(i31, i302);
                                    selectionRegistrar = (SelectionRegistrar) composerStartRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
                                    if (selectionRegistrar == null) {
                                    }
                                    zHasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
                                    boolean zHasLinks2 = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
                                    if (zHasInlineContent) {
                                        annotatedString2 = annotatedString;
                                        z3 = false;
                                        composer3 = composer2;
                                        z4 = z2;
                                        i23 = i21;
                                        TextStyle textStyle52 = textStyle2;
                                        i24 = i22;
                                        Function1<? super TextLayoutResult, Unit> function152 = function12;
                                        i25 = iM20906getClipgIe3tQ8;
                                        SelectionController selectionController22 = selectionController;
                                        composer3.startReplaceGroup(-1583391888);
                                        if ((i20 & 14) == 4) {
                                        }
                                        objRememberedValue = composer3.rememberedValue();
                                        if (!z3) {
                                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString2, null, 2, null);
                                            composer3.updateRememberedValue(objRememberedValue);
                                            mutableState = (MutableState) objRememberedValue;
                                            AnnotatedString annotatedStringBasicText_RWo7tUw$lambda$52 = BasicText_RWo7tUw$lambda$5(mutableState);
                                            FontFamily.Resolver resolver3 = (FontFamily.Resolver) composer3.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                            zChanged = composer3.changed(mutableState);
                                            objRememberedValue2 = composer3.rememberedValue();
                                            if (!zChanged) {
                                                objRememberedValue2 = new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                                                        invoke2(textSubstitutionValue);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@NotNull TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                                                        mutableState.setValue(textSubstitutionValue.isShowingSubstitution() ? textSubstitutionValue.getSubstitution() : textSubstitutionValue.getOriginal());
                                                    }
                                                };
                                                composer3.updateRememberedValue(objRememberedValue2);
                                                int i322 = i20 << 6;
                                                textStyle3 = textStyle52;
                                                function13 = function152;
                                                Modifier modifier52 = modifier3;
                                                m16150LayoutWithLinksAndInlineContentvOo2fZY(modifier52, annotatedStringBasicText_RWo7tUw$lambda$52, function13, zHasInlineContent, mapEmptyMap, textStyle3, i25, z4, i23, i24, resolver3, selectionController22, colorProducer2, (Function1) objRememberedValue2, composer3, ((i20 >> 3) & SdlMediaRecorder.MEDIA_RECORDER_INFO_NO_NETWORK) | ((i20 >> 12) & 57344) | ((i20 << 9) & 458752) | (3670016 & i322) | (29360128 & i322) | (234881024 & i322) | (i322 & 1879048192), (i20 >> 21) & 896, 0);
                                                composer4 = composer3;
                                                modifier3 = modifier52;
                                                composer4.endReplaceGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                                composer5 = composer4;
                                                i26 = i24;
                                                colorProducer3 = colorProducer2;
                                                map2 = mapEmptyMap;
                                                textStyle4 = textStyle3;
                                                modifier4 = modifier3;
                                                i27 = i23;
                                                z5 = z4;
                                                i28 = i25;
                                                function14 = function13;
                                            }
                                        }
                                    }
                                }
                                scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i17 = i16;
                            i18 = i6 & 512;
                            if (i18 == 0) {
                            }
                            i19 = i18;
                            if ((i7 & 306783379) == 306783378) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 256;
                        if (i16 == 0) {
                        }
                        i17 = i16;
                        i18 = i6 & 512;
                        if (i18 == 0) {
                        }
                        i19 = i18;
                        if ((i7 & 306783379) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    iM20906getClipgIe3tQ8 = i;
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 64;
                    if (i12 != 0) {
                    }
                    i14 = i6 & 128;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 256;
                    if (i16 == 0) {
                    }
                    i17 = i16;
                    i18 = i6 & 512;
                    if (i18 == 0) {
                    }
                    i19 = i18;
                    if ((i7 & 306783379) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function12 = function1;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                iM20906getClipgIe3tQ8 = i;
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                }
                i14 = i6 & 128;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 256;
                if (i16 == 0) {
                }
                i17 = i16;
                i18 = i6 & 512;
                if (i18 == 0) {
                }
                i19 = i18;
                if ((i7 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function12 = function1;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            iM20906getClipgIe3tQ8 = i;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            i14 = i6 & 128;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 256;
            if (i16 == 0) {
            }
            i17 = i16;
            i18 = i6 & 512;
            if (i18 == 0) {
            }
            i19 = i18;
            if ((i7 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        textStyle2 = textStyle;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function12 = function1;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        iM20906getClipgIe3tQ8 = i;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        i14 = i6 & 128;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 256;
        if (i16 == 0) {
        }
        i17 = i16;
        i18 = i6 & 512;
        if (i18 == 0) {
        }
        i19 = i18;
        if ((i7 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fd  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: BasicText-VhcvRP8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16149BasicTextVhcvRP8(@NotNull final String str, @Nullable Modifier modifier, @Nullable TextStyle textStyle, @Nullable Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i4, @Nullable ColorProducer colorProducer, @Nullable Composer composer, final int i5, final int i6) {
        String str2;
        int i7;
        Modifier modifier2;
        int i8;
        TextStyle textStyle2;
        int i9;
        Function1<? super TextLayoutResult, Unit> function12;
        int i10;
        int iM20906getClipgIe3tQ8;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Modifier modifier3;
        SelectionController selectionController;
        final SelectionRegistrar selectionRegistrar;
        int i17;
        int i18;
        ColorProducer colorProducer2;
        TextStyle textStyle3;
        boolean z3;
        Modifier modifier4;
        Function1<? super TextLayoutResult, Unit> function13;
        int i19;
        Modifier modifierM16152textModifiercFh6CEA;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final ColorProducer colorProducer3;
        final TextStyle textStyle4;
        final boolean z4;
        final int i20;
        final int i21;
        final Modifier modifier5;
        final Function1<? super TextLayoutResult, Unit> function14;
        final int i22;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1186827822);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i5 & 6) == 0) {
                i7 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i5;
            } else {
                i7 = i5;
            }
        }
        int i23 = i6 & 2;
        if (i23 != 0) {
            i7 |= 48;
        } else {
            if ((i5 & 48) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else {
                if ((i5 & 384) == 0) {
                    textStyle2 = textStyle;
                    i7 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i5 & 3072) == 0) {
                        function12 = function1;
                        i7 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else {
                        if ((i5 & 24576) == 0) {
                            iM20906getClipgIe3tQ8 = i;
                            i7 |= composerStartRestartGroup.changed(iM20906getClipgIe3tQ8) ? 16384 : 8192;
                        }
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                        } else {
                            if ((196608 & i5) == 0) {
                                z2 = z;
                                i7 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                            }
                            i12 = i6 & 64;
                            if (i12 == 0) {
                                i7 |= 1572864;
                            } else if ((i5 & 1572864) == 0) {
                                i7 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i13 = i6 & 128;
                            if (i13 == 0) {
                                i7 |= 12582912;
                            } else {
                                if ((i5 & 12582912) == 0) {
                                    i14 = i13;
                                    i7 |= composerStartRestartGroup.changed(i4) ? 8388608 : 4194304;
                                }
                                i15 = i6 & 256;
                                if (i15 == 0) {
                                    if ((i5 & 100663296) == 0) {
                                        i16 = i15;
                                        i7 |= composerStartRestartGroup.changedInstance(colorProducer) ? 67108864 : 33554432;
                                    }
                                    if ((i7 & 38347923) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                                        modifier3 = i23 == 0 ? Modifier.INSTANCE : modifier2;
                                        if (i8 != 0) {
                                            textStyle2 = TextStyle.INSTANCE.getDefault();
                                        }
                                        selectionController = null;
                                        if (i9 != 0) {
                                            function12 = null;
                                        }
                                        if (i10 != 0) {
                                            iM20906getClipgIe3tQ8 = TextOverflow.INSTANCE.m20906getClipgIe3tQ8();
                                        }
                                        if (i11 != 0) {
                                            z2 = true;
                                        }
                                        int i24 = i12 == 0 ? Integer.MAX_VALUE : i2;
                                        int i25 = i14 == 0 ? i4 : 1;
                                        ColorProducer colorProducer4 = i16 == 0 ? null : colorProducer;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1186827822, i7, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                                        }
                                        HeightInLinesModifierKt.validateMinMaxLines(i25, i24);
                                        selectionRegistrar = (SelectionRegistrar) composerStartRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
                                        if (selectionRegistrar == null) {
                                            composerStartRestartGroup.startReplaceGroup(-1589202404);
                                            i17 = i25;
                                            i18 = i24;
                                            long backgroundColor = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getBackgroundColor();
                                            Object[] objArr = {selectionRegistrar};
                                            Saver<Long, Long> saverSelectionIdSaver = selectionIdSaver(selectionRegistrar);
                                            boolean zChangedInstance = composerStartRestartGroup.changedInstance(selectionRegistrar);
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    @NotNull
                                                    public final Long invoke() {
                                                        return Long.valueOf(selectionRegistrar.nextSelectableId());
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            Number number = (Number) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) saverSelectionIdSaver, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 0, 4);
                                            colorProducer2 = colorProducer4;
                                            textStyle3 = textStyle2;
                                            long jLongValue = number.longValue();
                                            boolean zChanged = composerStartRestartGroup.changed(jLongValue) | composerStartRestartGroup.changed(selectionRegistrar) | composerStartRestartGroup.changed(backgroundColor);
                                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue2 = new SelectionController(jLongValue, selectionRegistrar, backgroundColor, null, 8, null);
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                            }
                                            selectionController = (SelectionController) objRememberedValue2;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i17 = i25;
                                            i18 = i24;
                                            colorProducer2 = colorProducer4;
                                            textStyle3 = textStyle2;
                                            composerStartRestartGroup.startReplaceGroup(-1588686502);
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                        if (selectionController == null || function12 != null) {
                                            int i26 = iM20906getClipgIe3tQ8;
                                            z3 = z2;
                                            Modifier modifier6 = modifier3;
                                            composerStartRestartGroup.startReplaceGroup(-1588564052);
                                            modifier4 = modifier6;
                                            function13 = function12;
                                            i19 = i26;
                                            modifierM16152textModifiercFh6CEA = m16152textModifiercFh6CEA(GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(modifier4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), textStyle3, function13, i19, z3, i18, i17, (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver()), null, null, selectionController, colorProducer2, null);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(-1587866335);
                                            i19 = iM20906getClipgIe3tQ8;
                                            z3 = z2;
                                            modifierM16152textModifiercFh6CEA = GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(modifier3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null).then(new TextStringSimpleElement(str2, textStyle3, (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver()), i19, z3, i18, i17, colorProducer2, null));
                                            composerStartRestartGroup.endReplaceGroup();
                                            modifier4 = modifier3;
                                            function13 = function12;
                                        }
                                        EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM16152textModifiercFh6CEA);
                                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                                        if (composerStartRestartGroup.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composerStartRestartGroup.startReusableNode();
                                        if (composerStartRestartGroup.getInserting()) {
                                            composerStartRestartGroup.useNode();
                                        } else {
                                            composerStartRestartGroup.createNode(constructor);
                                        }
                                        composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                        Updater.m18025setimpl(composerM18018constructorimpl, emptyMeasurePolicy, companion.getSetMeasurePolicy());
                                        Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                        setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                        if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                                        }
                                        composerStartRestartGroup.endNode();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        colorProducer3 = colorProducer2;
                                        textStyle4 = textStyle3;
                                        z4 = z3;
                                        i20 = i18;
                                        i21 = i17;
                                        modifier5 = modifier4;
                                        function14 = function13;
                                        i22 = i19;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        i20 = i2;
                                        colorProducer3 = colorProducer;
                                        modifier5 = modifier2;
                                        textStyle4 = textStyle2;
                                        function14 = function12;
                                        i22 = iM20906getClipgIe3tQ8;
                                        z4 = z2;
                                        i21 = i4;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
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

                                            public final void invoke(@Nullable Composer composer2, int i27) {
                                                BasicTextKt.m16149BasicTextVhcvRP8(str, modifier5, textStyle4, function14, i22, z4, i20, i21, colorProducer3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i7 |= 100663296;
                                i16 = i15;
                                if ((i7 & 38347923) == 38347922) {
                                    if (i23 == 0) {
                                    }
                                    if (i8 != 0) {
                                    }
                                    selectionController = null;
                                    if (i9 != 0) {
                                    }
                                    if (i10 != 0) {
                                    }
                                    if (i11 != 0) {
                                    }
                                    if (i12 == 0) {
                                    }
                                    if (i14 == 0) {
                                    }
                                    if (i16 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    HeightInLinesModifierKt.validateMinMaxLines(i25, i24);
                                    selectionRegistrar = (SelectionRegistrar) composerStartRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
                                    if (selectionRegistrar == null) {
                                    }
                                    if (selectionController == null) {
                                        int i262 = iM20906getClipgIe3tQ8;
                                        z3 = z2;
                                        Modifier modifier62 = modifier3;
                                        composerStartRestartGroup.startReplaceGroup(-1588564052);
                                        modifier4 = modifier62;
                                        function13 = function12;
                                        i19 = i262;
                                        modifierM16152textModifiercFh6CEA = m16152textModifiercFh6CEA(GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(modifier4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), textStyle3, function13, i19, z3, i18, i17, (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver()), null, null, selectionController, colorProducer2, null);
                                        composerStartRestartGroup.endReplaceGroup();
                                        EmptyMeasurePolicy emptyMeasurePolicy2 = EmptyMeasurePolicy.INSTANCE;
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM16152textModifiercFh6CEA);
                                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                                        if (composerStartRestartGroup.getApplier() == null) {
                                        }
                                        composerStartRestartGroup.startReusableNode();
                                        if (composerStartRestartGroup.getInserting()) {
                                        }
                                        composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                        Updater.m18025setimpl(composerM18018constructorimpl, emptyMeasurePolicy2, companion2.getSetMeasurePolicy());
                                        Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                                        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
                                        setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                        if (!composerM18018constructorimpl.getInserting()) {
                                            AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                                            composerStartRestartGroup.endNode();
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            colorProducer3 = colorProducer2;
                                            textStyle4 = textStyle3;
                                            z4 = z3;
                                            i20 = i18;
                                            i21 = i17;
                                            modifier5 = modifier4;
                                            function14 = function13;
                                            i22 = i19;
                                        }
                                    }
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i14 = i13;
                            i15 = i6 & 256;
                            if (i15 == 0) {
                            }
                            i16 = i15;
                            if ((i7 & 38347923) == 38347922) {
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        z2 = z;
                        i12 = i6 & 64;
                        if (i12 == 0) {
                        }
                        i13 = i6 & 128;
                        if (i13 == 0) {
                        }
                        i14 = i13;
                        i15 = i6 & 256;
                        if (i15 == 0) {
                        }
                        i16 = i15;
                        if ((i7 & 38347923) == 38347922) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    iM20906getClipgIe3tQ8 = i;
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    z2 = z;
                    i12 = i6 & 64;
                    if (i12 == 0) {
                    }
                    i13 = i6 & 128;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    i15 = i6 & 256;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    if ((i7 & 38347923) == 38347922) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function12 = function1;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                iM20906getClipgIe3tQ8 = i;
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                z2 = z;
                i12 = i6 & 64;
                if (i12 == 0) {
                }
                i13 = i6 & 128;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i6 & 256;
                if (i15 == 0) {
                }
                i16 = i15;
                if ((i7 & 38347923) == 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function12 = function1;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            iM20906getClipgIe3tQ8 = i;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            z2 = z;
            i12 = i6 & 64;
            if (i12 == 0) {
            }
            i13 = i6 & 128;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i6 & 256;
            if (i15 == 0) {
            }
            i16 = i15;
            if ((i7 & 38347923) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        textStyle2 = textStyle;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function12 = function1;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        iM20906getClipgIe3tQ8 = i;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        z2 = z;
        i12 = i6 & 64;
        if (i12 == 0) {
        }
        i13 = i6 & 128;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i6 & 256;
        if (i15 == 0) {
        }
        i16 = i15;
        if ((i7 & 38347923) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final AnnotatedString BasicText_RWo7tUw$lambda$5(MutableState<AnnotatedString> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LayoutWithLinksAndInlineContent-vOo2fZY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16150LayoutWithLinksAndInlineContentvOo2fZY(final Modifier modifier, final AnnotatedString annotatedString, final Function1<? super TextLayoutResult, Unit> function1, final boolean z, Map<String, InlineTextContent> map, final TextStyle textStyle, final int i, final boolean z2, final int i2, final int i4, final FontFamily.Resolver resolver, final SelectionController selectionController, final ColorProducer colorProducer, final Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function12, Composer composer, final int i5, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        Map<String, InlineTextContent> map2;
        TextStyle textStyle2;
        int i9;
        boolean z3;
        int i10;
        int i11;
        Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function13;
        final TextLinkScope textLinkScope;
        Function0 function0;
        List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> listComponent2;
        Map<String, InlineTextContent> map3;
        Function0 function02;
        Function1 function14;
        Function1 function15;
        boolean zChangedInstance;
        Object objRememberedValue;
        MeasurePolicy textMeasurePolicy;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2 function2M1177w;
        final Map<String, InlineTextContent> map4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(645129368);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i8 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= composerStartRestartGroup.changed(annotatedString) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i5 & 384) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i8 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i8 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        int i12 = i7 & 16;
        if (i12 != 0) {
            i8 |= 24576;
        } else {
            if ((i5 & 24576) == 0) {
                map2 = map;
                i8 |= composerStartRestartGroup.changedInstance(map2) ? 16384 : 8192;
            }
            if ((i7 & 32) == 0) {
                i8 |= 196608;
                textStyle2 = textStyle;
            } else {
                textStyle2 = textStyle;
                if ((i5 & 196608) == 0) {
                    i8 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                }
            }
            if ((i7 & 64) == 0) {
                i8 |= 1572864;
                i9 = i;
            } else {
                i9 = i;
                if ((i5 & 1572864) == 0) {
                    i8 |= composerStartRestartGroup.changed(i9) ? 1048576 : 524288;
                }
            }
            if ((i7 & 128) == 0) {
                i8 |= 12582912;
            } else {
                if ((i5 & 12582912) == 0) {
                    z3 = z2;
                    i8 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
                }
                if ((i7 & 256) != 0) {
                    i8 |= 100663296;
                } else {
                    if ((i5 & 100663296) == 0) {
                        i10 = i2;
                        i8 |= composerStartRestartGroup.changed(i10) ? 67108864 : 33554432;
                    }
                    if ((i7 & 512) == 0) {
                        i8 |= DriveFile.MODE_READ_WRITE;
                    } else {
                        if ((i5 & DriveFile.MODE_READ_WRITE) == 0) {
                            i8 |= composerStartRestartGroup.changed(i4) ? 536870912 : 268435456;
                        }
                        if ((i7 & 1024) != 0) {
                            i11 = i6 | 6;
                        } else if ((i6 & 6) == 0) {
                            i11 = i6 | (composerStartRestartGroup.changedInstance(resolver) ? 4 : 2);
                        } else {
                            i11 = i6;
                        }
                        if ((i7 & 2048) != 0) {
                            i11 |= 48;
                        } else if ((i6 & 48) == 0) {
                            i11 |= composerStartRestartGroup.changedInstance(selectionController) ? 32 : 16;
                        }
                        int i13 = i11;
                        if ((i7 & 4096) != 0) {
                            i13 |= 384;
                        } else {
                            if ((i6 & 384) == 0) {
                                i13 |= composerStartRestartGroup.changedInstance(colorProducer) ? 256 : 128;
                            }
                            if ((i7 & 8192) != 0) {
                                if ((i6 & 3072) == 0) {
                                    function13 = function12;
                                    i13 |= composerStartRestartGroup.changedInstance(function13) ? 2048 : 1024;
                                }
                                if ((i8 & 306783379) == 306783378 && (i13 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    map4 = map2;
                                } else {
                                    Map<String, InlineTextContent> mapEmptyMap = i12 == 0 ? MapsKt.emptyMap() : map2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(645129368, i8, i13, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:536)");
                                    }
                                    final MutableState mutableState = null;
                                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                                        composerStartRestartGroup.startReplaceGroup(-619265198);
                                        composerStartRestartGroup.endReplaceGroup();
                                        textLinkScope = null;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-619323167);
                                        boolean z4 = (i8 & 112) == 32;
                                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = new TextLinkScope(annotatedString);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        textLinkScope = (TextLinkScope) objRememberedValue2;
                                    }
                                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                                        composerStartRestartGroup.startReplaceGroup(-618966357);
                                        boolean z5 = (i8 & 112) == 32;
                                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue3 = new Function0<AnnotatedString>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$2$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                @NotNull
                                                public final AnnotatedString invoke() {
                                                    return annotatedString;
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        }
                                        function0 = (Function0) objRememberedValue3;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-619074547);
                                        boolean zChanged = ((i8 & 112) == 32) | composerStartRestartGroup.changed(textLinkScope);
                                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                        if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue4 = new Function0<AnnotatedString>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                @NotNull
                                                public final AnnotatedString invoke() {
                                                    AnnotatedString annotatedStringApplyAnnotators$foundation_release;
                                                    TextLinkScope textLinkScope2 = textLinkScope;
                                                    return (textLinkScope2 == null || (annotatedStringApplyAnnotators$foundation_release = textLinkScope2.applyAnnotators$foundation_release()) == null) ? annotatedString : annotatedStringApplyAnnotators$foundation_release;
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                        }
                                        function0 = (Function0) objRememberedValue4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> pairResolveInlineContent = !z ? AnnotatedStringResolveInlineContentKt.resolveInlineContent(annotatedString, mapEmptyMap) : new Pair<>(null, null);
                                    List<AnnotatedString.Range<Placeholder>> listComponent1 = pairResolveInlineContent.component1();
                                    listComponent2 = pairResolveInlineContent.component2();
                                    if (z) {
                                        map3 = mapEmptyMap;
                                        function02 = function0;
                                        function14 = null;
                                        composerStartRestartGroup.startReplaceGroup(-618591630);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-618671702);
                                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                        map3 = mapEmptyMap;
                                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            function02 = function0;
                                            function14 = null;
                                            objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                        } else {
                                            function02 = function0;
                                            function14 = null;
                                        }
                                        mutableState = (MutableState) objRememberedValue5;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    if (z) {
                                        composerStartRestartGroup.startReplaceGroup(-618442830);
                                        composerStartRestartGroup.endReplaceGroup();
                                        function15 = function14;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-618506565);
                                        boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
                                        Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                        if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue6 = new Function1<List<? extends Rect>, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$onPlaceholderLayout$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(List<? extends Rect> list) {
                                                    invoke2((List<Rect>) list);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@NotNull List<Rect> list) {
                                                    MutableState<List<Rect>> mutableState2 = mutableState;
                                                    if (mutableState2 == null) {
                                                        return;
                                                    }
                                                    mutableState2.setValue(list);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                        }
                                        function15 = (Function1) objRememberedValue6;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    Modifier modifierM18686graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(modifier2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                                    AnnotatedString annotatedString2 = (AnnotatedString) function02.invoke();
                                    Function1 function16 = function15;
                                    zChangedInstance = ((i8 & 896) != 256) | composerStartRestartGroup.changedInstance(textLinkScope);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                                invoke2(textLayoutResult);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                                TextLinkScope textLinkScope2 = textLinkScope;
                                                if (textLinkScope2 != null) {
                                                    textLinkScope2.setTextLayoutResult(textLayoutResult);
                                                }
                                                Function1<TextLayoutResult, Unit> function17 = function1;
                                                if (function17 != null) {
                                                    function17.invoke(textLayoutResult);
                                                }
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    Modifier modifierM16152textModifiercFh6CEA = m16152textModifiercFh6CEA(modifierM18686graphicsLayerAp8cVGQ$default, annotatedString2, textStyle2, (Function1) objRememberedValue, i9, z3, i10, i4, resolver, listComponent1, function16, selectionController, colorProducer, function13);
                                    if (z) {
                                        composerStartRestartGroup.startReplaceGroup(-617362851);
                                        boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textLinkScope);
                                        Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue7 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$3$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                @NotNull
                                                public final Boolean invoke() {
                                                    TextLinkScope textLinkScope2 = textLinkScope;
                                                    return Boolean.valueOf(textLinkScope2 != null ? textLinkScope2.getShouldMeasureLinks().invoke().booleanValue() : false);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                        }
                                        textMeasurePolicy = new LinksTextMeasurePolicy((Function0) objRememberedValue7);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-617202116);
                                        boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(textLinkScope);
                                        Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance3 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue8 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$4$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                @NotNull
                                                public final Boolean invoke() {
                                                    TextLinkScope textLinkScope2 = textLinkScope;
                                                    return Boolean.valueOf(textLinkScope2 != null ? textLinkScope2.getShouldMeasureLinks().invoke().booleanValue() : false);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                        }
                                        Function0 function03 = (Function0) objRememberedValue8;
                                        boolean zChanged3 = composerStartRestartGroup.changed(mutableState);
                                        Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                        if (zChanged3 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue9 = new Function0<List<? extends Rect>>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$5$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                @Nullable
                                                public final List<? extends Rect> invoke() {
                                                    MutableState<List<Rect>> mutableState2 = mutableState;
                                                    if (mutableState2 != null) {
                                                        return mutableState2.getValue();
                                                    }
                                                    return null;
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                        }
                                        textMeasurePolicy = new TextMeasurePolicy(function03, (Function0) objRememberedValue9);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM16152textModifiercFh6CEA);
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    if (composerStartRestartGroup.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composerStartRestartGroup.startReusableNode();
                                    if (composerStartRestartGroup.getInserting()) {
                                        composerStartRestartGroup.useNode();
                                    } else {
                                        composerStartRestartGroup.createNode(constructor);
                                    }
                                    composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                    function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, textMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                                    if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                                    }
                                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                    if (textLinkScope != null) {
                                        composerStartRestartGroup.startReplaceGroup(-515480539);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(537560924);
                                        textLinkScope.LinksComposables(composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    if (listComponent2 != null) {
                                        composerStartRestartGroup.startReplaceGroup(-515428893);
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-515428892);
                                        AnnotatedStringResolveInlineContentKt.InlineChildren(annotatedString, listComponent2, composerStartRestartGroup, (i8 >> 3) & 14);
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    map4 = map3;
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$6
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

                                        public final void invoke(@Nullable Composer composer2, int i14) {
                                            BasicTextKt.m16150LayoutWithLinksAndInlineContentvOo2fZY(modifier, annotatedString, function1, z, map4, textStyle, i, z2, i2, i4, resolver, selectionController, colorProducer, function12, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i13 |= 3072;
                            function13 = function12;
                            if ((i8 & 306783379) == 306783378) {
                                if (i12 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final MutableState<List<Rect>> mutableState2 = null;
                                if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                                }
                                if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                                }
                                if (!z) {
                                }
                                List<AnnotatedString.Range<Placeholder>> listComponent12 = pairResolveInlineContent.component1();
                                listComponent2 = pairResolveInlineContent.component2();
                                if (z) {
                                }
                                if (z) {
                                }
                                Modifier modifierM18686graphicsLayerAp8cVGQ$default2 = GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(modifier2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                                AnnotatedString annotatedString22 = (AnnotatedString) function02.invoke();
                                Function1 function162 = function15;
                                zChangedInstance = ((i8 & 896) != 256) | composerStartRestartGroup.changedInstance(textLinkScope);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChangedInstance) {
                                    objRememberedValue = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                            invoke2(textLayoutResult);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                            TextLinkScope textLinkScope2 = textLinkScope;
                                            if (textLinkScope2 != null) {
                                                textLinkScope2.setTextLayoutResult(textLayoutResult);
                                            }
                                            Function1<TextLayoutResult, Unit> function17 = function1;
                                            if (function17 != null) {
                                                function17.invoke(textLayoutResult);
                                            }
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    Modifier modifierM16152textModifiercFh6CEA2 = m16152textModifiercFh6CEA(modifierM18686graphicsLayerAp8cVGQ$default2, annotatedString22, textStyle2, (Function1) objRememberedValue, i9, z3, i10, i4, resolver, listComponent12, function162, selectionController, colorProducer, function13);
                                    if (z) {
                                    }
                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM16152textModifiercFh6CEA2);
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                                    if (composerStartRestartGroup.getApplier() == null) {
                                    }
                                    composerStartRestartGroup.startReusableNode();
                                    if (composerStartRestartGroup.getInserting()) {
                                    }
                                    composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                    function2M1177w = AbstractC0622a.m1177w(companion2, composerM18018constructorimpl, textMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap2);
                                    if (!composerM18018constructorimpl.getInserting()) {
                                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                                        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
                                        if (textLinkScope != null) {
                                        }
                                        if (listComponent2 != null) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        composerStartRestartGroup.endNode();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        map4 = map3;
                                    }
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        if ((i7 & 8192) != 0) {
                        }
                        function13 = function12;
                        if ((i8 & 306783379) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    if ((i7 & 1024) != 0) {
                    }
                    if ((i7 & 2048) != 0) {
                    }
                    int i132 = i11;
                    if ((i7 & 4096) != 0) {
                    }
                    if ((i7 & 8192) != 0) {
                    }
                    function13 = function12;
                    if ((i8 & 306783379) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i10 = i2;
                if ((i7 & 512) == 0) {
                }
                if ((i7 & 1024) != 0) {
                }
                if ((i7 & 2048) != 0) {
                }
                int i1322 = i11;
                if ((i7 & 4096) != 0) {
                }
                if ((i7 & 8192) != 0) {
                }
                function13 = function12;
                if ((i8 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            if ((i7 & 256) != 0) {
            }
            i10 = i2;
            if ((i7 & 512) == 0) {
            }
            if ((i7 & 1024) != 0) {
            }
            if ((i7 & 2048) != 0) {
            }
            int i13222 = i11;
            if ((i7 & 4096) != 0) {
            }
            if ((i7 & 8192) != 0) {
            }
            function13 = function12;
            if ((i8 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        map2 = map;
        if ((i7 & 32) == 0) {
        }
        if ((i7 & 64) == 0) {
        }
        if ((i7 & 128) == 0) {
        }
        z3 = z2;
        if ((i7 & 256) != 0) {
        }
        i10 = i2;
        if ((i7 & 512) == 0) {
        }
        if ((i7 & 1024) != 0) {
        }
        if ((i7 & 2048) != 0) {
        }
        int i132222 = i11;
        if ((i7 & 4096) != 0) {
        }
        if ((i7 & 8192) != 0) {
        }
        function13 = function12;
        if ((i8 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> list, Function0<Boolean> function0) {
        if (!function0.invoke().booleanValue()) {
            return null;
        }
        TextRangeLayoutMeasureScope textRangeLayoutMeasureScope = new TextRangeLayoutMeasureScope();
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            Object parentData = measurable.getParentData();
            Intrinsics.checkNotNull(parentData, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
            TextRangeLayoutMeasureResult textRangeLayoutMeasureResultMeasure = ((TextRangeLayoutModifier) parentData).getMeasurePolicy().measure(textRangeLayoutMeasureScope);
            arrayList.add(new Pair(measurable.mo19855measureBRTryo0(Constraints.INSTANCE.m20930fitPrioritizingWidthZbe2FdA(textRangeLayoutMeasureResultMeasure.getWidth(), textRangeLayoutMeasureResultMeasure.getWidth(), textRangeLayoutMeasureResultMeasure.getHeight(), textRangeLayoutMeasureResultMeasure.getHeight())), textRangeLayoutMeasureResultMeasure.getPlace()));
        }
        return arrayList;
    }

    private static final Saver<Long, Long> selectionIdSaver(final SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new Function2<SaverScope, Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt.selectionIdSaver.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(SaverScope saverScope, Long l) {
                return invoke(saverScope, l.longValue());
            }

            @Nullable
            public final Long invoke(@NotNull SaverScope saverScope, long j) {
                if (SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                    return Long.valueOf(j);
                }
                return null;
            }
        }, new Function1<Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt.selectionIdSaver.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Long l) {
                return invoke(l.longValue());
            }

            @Nullable
            public final Long invoke(long j) {
                return Long.valueOf(j);
            }
        });
    }

    /* JADX INFO: renamed from: textModifier-cFh6CEA, reason: not valid java name */
    private static final Modifier m16152textModifiercFh6CEA(Modifier modifier, AnnotatedString annotatedString, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i4, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function13) {
        if (selectionController == null) {
            return modifier.then(Modifier.INSTANCE).then(new TextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i4, list, function12, null, colorProducer, function13, null));
        }
        return modifier.then(selectionController.getModifier()).then(new SelectableTextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i4, list, function12, selectionController, colorProducer, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    @Composable
    /* JADX INFO: renamed from: BasicText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m16145BasicText4YKlhWE(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i4, Composer composer, final int i5, final int i6) {
        String str2;
        int i7;
        Modifier modifier2;
        int i8;
        TextStyle textStyle2;
        int i9;
        Function1 function12;
        int i10;
        int iM20906getClipgIe3tQ8;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final int i15;
        final boolean z3;
        final int i16;
        final int i17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1542716361);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i5 & 6) == 0) {
                i7 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i5;
            } else {
                i7 = i5;
            }
        }
        int i18 = i6 & 2;
        if (i18 != 0) {
            i7 |= 48;
        } else {
            if ((i5 & 48) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else {
                if ((i5 & 384) == 0) {
                    textStyle2 = textStyle;
                    i7 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i5 & 3072) == 0) {
                        function12 = function1;
                        i7 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else {
                        if ((i5 & 24576) == 0) {
                            iM20906getClipgIe3tQ8 = i;
                            i7 |= composerStartRestartGroup.changed(iM20906getClipgIe3tQ8) ? 16384 : 8192;
                        }
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                        } else {
                            if ((196608 & i5) == 0) {
                                z2 = z;
                                i7 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                            }
                            i12 = i6 & 64;
                            if (i12 == 0) {
                                i7 |= 1572864;
                            } else if ((i5 & 1572864) == 0) {
                                i7 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i13 = i6 & 128;
                            if (i13 != 0) {
                                if ((i5 & 12582912) == 0) {
                                    i14 = i13;
                                    i7 |= composerStartRestartGroup.changed(i4) ? 8388608 : 4194304;
                                }
                                if ((i7 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    i16 = i2;
                                    modifier3 = modifier2;
                                    textStyle3 = textStyle2;
                                    function13 = function12;
                                    i15 = iM20906getClipgIe3tQ8;
                                    z3 = z2;
                                    i17 = i4;
                                } else {
                                    Modifier modifier4 = i18 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i8 != 0) {
                                        textStyle2 = TextStyle.INSTANCE.getDefault();
                                    }
                                    if (i9 != 0) {
                                        function12 = null;
                                    }
                                    if (i10 != 0) {
                                        iM20906getClipgIe3tQ8 = TextOverflow.INSTANCE.m20906getClipgIe3tQ8();
                                    }
                                    if (i11 != 0) {
                                        z2 = true;
                                    }
                                    int i19 = i12 == 0 ? Integer.MAX_VALUE : i2;
                                    int i20 = i14 == 0 ? 1 : i4;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1542716361, i7, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
                                    }
                                    Modifier modifier5 = modifier4;
                                    int i21 = i19;
                                    Function1 function14 = function12;
                                    boolean z4 = z2;
                                    int i22 = iM20906getClipgIe3tQ8;
                                    TextStyle textStyle4 = textStyle2;
                                    m16149BasicTextVhcvRP8(str2, modifier5, textStyle4, (Function1<? super TextLayoutResult, Unit>) function14, i22, z4, i21, i20, (ColorProducer) null, composerStartRestartGroup, i7 & 33554430, 256);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier5;
                                    textStyle3 = textStyle4;
                                    function13 = function14;
                                    i15 = i22;
                                    z3 = z4;
                                    i16 = i21;
                                    i17 = i20;
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
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

                                        public final void invoke(@Nullable Composer composer2, int i23) {
                                            BasicTextKt.m16145BasicText4YKlhWE(str, modifier3, textStyle3, function13, i15, z3, i16, i17, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i7 |= 12582912;
                            i14 = i13;
                            if ((i7 & 4793491) == 4793490) {
                                if (i18 == 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i9 != 0) {
                                }
                                if (i10 != 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i12 == 0) {
                                }
                                if (i14 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                Modifier modifier52 = modifier4;
                                int i212 = i19;
                                Function1 function142 = function12;
                                boolean z42 = z2;
                                int i222 = iM20906getClipgIe3tQ8;
                                TextStyle textStyle42 = textStyle2;
                                m16149BasicTextVhcvRP8(str2, modifier52, textStyle42, (Function1<? super TextLayoutResult, Unit>) function142, i222, z42, i212, i20, (ColorProducer) null, composerStartRestartGroup, i7 & 33554430, 256);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier3 = modifier52;
                                textStyle3 = textStyle42;
                                function13 = function142;
                                i15 = i222;
                                z3 = z42;
                                i16 = i212;
                                i17 = i20;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        z2 = z;
                        i12 = i6 & 64;
                        if (i12 == 0) {
                        }
                        i13 = i6 & 128;
                        if (i13 != 0) {
                        }
                        i14 = i13;
                        if ((i7 & 4793491) == 4793490) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    iM20906getClipgIe3tQ8 = i;
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    z2 = z;
                    i12 = i6 & 64;
                    if (i12 == 0) {
                    }
                    i13 = i6 & 128;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    if ((i7 & 4793491) == 4793490) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function12 = function1;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                iM20906getClipgIe3tQ8 = i;
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                z2 = z;
                i12 = i6 & 64;
                if (i12 == 0) {
                }
                i13 = i6 & 128;
                if (i13 != 0) {
                }
                i14 = i13;
                if ((i7 & 4793491) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function12 = function1;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            iM20906getClipgIe3tQ8 = i;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            z2 = z;
            i12 = i6 & 64;
            if (i12 == 0) {
            }
            i13 = i6 & 128;
            if (i13 != 0) {
            }
            i14 = i13;
            if ((i7 & 4793491) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        textStyle2 = textStyle;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function12 = function1;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        iM20906getClipgIe3tQ8 = i;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        z2 = z;
        i12 = i6 & 64;
        if (i12 == 0) {
        }
        i13 = i6 & 128;
        if (i13 != 0) {
        }
        i14 = i13;
        if ((i7 & 4793491) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fd  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    @Composable
    /* JADX INFO: renamed from: BasicText-VhcvRP8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m16148BasicTextVhcvRP8(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i4, Map map, Composer composer, final int i5, final int i6) {
        AnnotatedString annotatedString2;
        int i7;
        Modifier modifier2;
        int i8;
        TextStyle textStyle2;
        int i9;
        Function1 function12;
        int i10;
        int iM20906getClipgIe3tQ8;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final int i17;
        final boolean z3;
        final int i18;
        final int i19;
        final Map map2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(851408699);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i5 & 6) == 0) {
                i7 = (composerStartRestartGroup.changed(annotatedString2) ? 4 : 2) | i5;
            } else {
                i7 = i5;
            }
        }
        int i20 = i6 & 2;
        if (i20 != 0) {
            i7 |= 48;
        } else {
            if ((i5 & 48) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else {
                if ((i5 & 384) == 0) {
                    textStyle2 = textStyle;
                    i7 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i5 & 3072) == 0) {
                        function12 = function1;
                        i7 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else {
                        if ((i5 & 24576) == 0) {
                            iM20906getClipgIe3tQ8 = i;
                            i7 |= composerStartRestartGroup.changed(iM20906getClipgIe3tQ8) ? 16384 : 8192;
                        }
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                        } else {
                            if ((196608 & i5) == 0) {
                                z2 = z;
                                i7 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                            }
                            i12 = i6 & 64;
                            if (i12 == 0) {
                                i7 |= 1572864;
                            } else if ((i5 & 1572864) == 0) {
                                i7 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i13 = i6 & 128;
                            if (i13 == 0) {
                                i7 |= 12582912;
                            } else {
                                if ((i5 & 12582912) == 0) {
                                    i14 = i13;
                                    i7 |= composerStartRestartGroup.changed(i4) ? 8388608 : 4194304;
                                }
                                i15 = i6 & 256;
                                if (i15 == 0) {
                                    if ((i5 & 100663296) == 0) {
                                        i16 = i15;
                                        i7 |= composerStartRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                                    }
                                    if ((i7 & 38347923) != 38347922 && composerStartRestartGroup.getSkipping()) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        i18 = i2;
                                        map2 = map;
                                        modifier3 = modifier2;
                                        textStyle3 = textStyle2;
                                        function13 = function12;
                                        i17 = iM20906getClipgIe3tQ8;
                                        z3 = z2;
                                        i19 = i4;
                                    } else {
                                        if (i20 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i8 != 0) {
                                            textStyle2 = TextStyle.INSTANCE.getDefault();
                                        }
                                        if (i9 != 0) {
                                            function12 = null;
                                        }
                                        if (i10 != 0) {
                                            iM20906getClipgIe3tQ8 = TextOverflow.INSTANCE.m20906getClipgIe3tQ8();
                                        }
                                        if (i11 != 0) {
                                            z2 = true;
                                        }
                                        int i21 = i12 == 0 ? Integer.MAX_VALUE : i2;
                                        int i22 = i14 == 0 ? i4 : 1;
                                        Map mapEmptyMap = i16 == 0 ? MapsKt.emptyMap() : map;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(851408699, i7, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:341)");
                                        }
                                        int i23 = i22;
                                        int i24 = i21;
                                        TextStyle textStyle4 = textStyle2;
                                        int i25 = iM20906getClipgIe3tQ8;
                                        boolean z4 = z2;
                                        Modifier modifier4 = modifier2;
                                        Function1 function14 = function12;
                                        m16147BasicTextRWo7tUw(annotatedString2, modifier4, textStyle4, function14, i25, z4, i24, i23, mapEmptyMap, null, composerStartRestartGroup, i7 & 268435454, 512);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = modifier4;
                                        textStyle3 = textStyle4;
                                        function13 = function14;
                                        i17 = i25;
                                        z3 = z4;
                                        i18 = i24;
                                        i19 = i23;
                                        map2 = mapEmptyMap;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$7
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

                                            public final void invoke(@Nullable Composer composer2, int i26) {
                                                BasicTextKt.m16148BasicTextVhcvRP8(annotatedString, modifier3, textStyle3, function13, i17, z3, i18, i19, map2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i7 |= 100663296;
                                i16 = i15;
                                if ((i7 & 38347923) != 38347922) {
                                    if (i20 != 0) {
                                    }
                                    if (i8 != 0) {
                                    }
                                    if (i9 != 0) {
                                    }
                                    if (i10 != 0) {
                                    }
                                    if (i11 != 0) {
                                    }
                                    if (i12 == 0) {
                                    }
                                    if (i14 == 0) {
                                    }
                                    if (i16 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    int i232 = i22;
                                    int i242 = i21;
                                    TextStyle textStyle42 = textStyle2;
                                    int i252 = iM20906getClipgIe3tQ8;
                                    boolean z42 = z2;
                                    Modifier modifier42 = modifier2;
                                    Function1 function142 = function12;
                                    m16147BasicTextRWo7tUw(annotatedString2, modifier42, textStyle42, function142, i252, z42, i242, i232, mapEmptyMap, null, composerStartRestartGroup, i7 & 268435454, 512);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    modifier3 = modifier42;
                                    textStyle3 = textStyle42;
                                    function13 = function142;
                                    i17 = i252;
                                    z3 = z42;
                                    i18 = i242;
                                    i19 = i232;
                                    map2 = mapEmptyMap;
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i14 = i13;
                            i15 = i6 & 256;
                            if (i15 == 0) {
                            }
                            i16 = i15;
                            if ((i7 & 38347923) != 38347922) {
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        z2 = z;
                        i12 = i6 & 64;
                        if (i12 == 0) {
                        }
                        i13 = i6 & 128;
                        if (i13 == 0) {
                        }
                        i14 = i13;
                        i15 = i6 & 256;
                        if (i15 == 0) {
                        }
                        i16 = i15;
                        if ((i7 & 38347923) != 38347922) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    iM20906getClipgIe3tQ8 = i;
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    z2 = z;
                    i12 = i6 & 64;
                    if (i12 == 0) {
                    }
                    i13 = i6 & 128;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    i15 = i6 & 256;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    if ((i7 & 38347923) != 38347922) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function12 = function1;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                iM20906getClipgIe3tQ8 = i;
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                z2 = z;
                i12 = i6 & 64;
                if (i12 == 0) {
                }
                i13 = i6 & 128;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i6 & 256;
                if (i15 == 0) {
                }
                i16 = i15;
                if ((i7 & 38347923) != 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function12 = function1;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            iM20906getClipgIe3tQ8 = i;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            z2 = z;
            i12 = i6 & 64;
            if (i12 == 0) {
            }
            i13 = i6 & 128;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i6 & 256;
            if (i15 == 0) {
            }
            i16 = i15;
            if ((i7 & 38347923) != 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        textStyle2 = textStyle;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function12 = function1;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        iM20906getClipgIe3tQ8 = i;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        z2 = z;
        i12 = i6 & 64;
        if (i12 == 0) {
        }
        i13 = i6 & 128;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i6 & 256;
        if (i15 == 0) {
        }
        i16 = i15;
        if ((i7 & 38347923) != 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
