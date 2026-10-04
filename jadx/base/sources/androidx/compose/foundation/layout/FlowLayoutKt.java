package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.CrossAxisAlignment;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p109ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000Ô\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001ag\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001ag\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u001b2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010!\u001a5\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&\u001a\u0095\u0001\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172#\u0010.\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002¢\u0006\u0002\u00102\u001a[\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002¢\u0006\u0002\u00106\u001aS\u00107\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172\u0006\u00108\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0002\u001a\u0090\u0001\u00109\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172#\u0010.\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172\u0006\u00108\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002\u001a%\u0010:\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010;\u001a5\u0010<\u001a\u00020#2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010=\u001a\\\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020J2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0000ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a\u001c\u0010M\u001a\u00020\u000f*\u00020+2\u0006\u0010N\u001a\u00020O2\u0006\u0010,\u001a\u00020\u000fH\u0000\u001a\u001c\u0010P\u001a\u00020\u000f*\u00020+2\u0006\u0010N\u001a\u00020O2\u0006\u0010.\u001a\u00020\u000fH\u0000\u001a<\u0010Q\u001a\u00020(*\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020R2\u0014\u0010S\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010T\u0012\u0004\u0012\u00020\u00070\u0014H\u0000ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001aT\u0010W\u001a\u00020?*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020?0[2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u000204H\u0000ø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001a\u001e\u0010`\u001a\u0004\u0018\u00010E*\b\u0012\u0004\u0012\u00020E0D2\b\u0010a\u001a\u0004\u0018\u00010bH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, m13886d2 = {"CROSS_AXIS_ALIGNMENT_START", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_START", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_TOP", "getCROSS_AXIS_ALIGNMENT_TOP", "FlowColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowRowScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "crossAxisSpacing", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "mainAxisSizes", "", "crossAxisSizes", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "maxIntrinsicMainAxisSize", "crossAxisAvailable", "minIntrinsicMainAxisSize", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "crossAxisMin", "isHorizontal", "", "mainAxisMin", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", "items", "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "foundation-layout_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFlowLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowLayout.kt\nandroidx/compose/foundation/layout/FlowLayoutKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n+ 6 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 8 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 9 RowColumnImpl.kt\nandroidx/compose/foundation/layout/OrientationIndependentConstraints\n+ 10 IntList.kt\nandroidx/collection/IntListKt\n+ 11 IntList.kt\nandroidx/collection/IntList\n*L\n1#1,1544:1\n1225#2,6:1545\n1225#2,6:1551\n1225#2,6:1562\n1225#2,6:1600\n1225#2,6:1606\n1225#2,6:1617\n1225#2,6:1655\n1225#2,6:1661\n1225#2,6:1667\n1225#2,6:1673\n171#3,5:1557\n79#3,6:1568\n86#3,4:1583\n90#3,2:1593\n94#3:1598\n177#3:1599\n171#3,5:1612\n79#3,6:1623\n86#3,4:1638\n90#3,2:1648\n94#3:1653\n177#3:1654\n368#4,9:1574\n377#4,3:1595\n368#4,9:1629\n377#4,3:1650\n4034#5,6:1587\n4034#5,6:1642\n69#6,6:1679\n1#7:1685\n1208#8:1686\n1187#8,2:1687\n230#9:1689\n229#9:1690\n232#9:1691\n231#9:1699\n230#9:1700\n231#9:1702\n232#9:1703\n231#9:1704\n232#9:1705\n229#9:1706\n230#9:1707\n931#10:1692\n931#10:1693\n70#11:1694\n266#11,4:1695\n271#11:1701\n*S KotlinDebug\n*F\n+ 1 FlowLayout.kt\nandroidx/compose/foundation/layout/FlowLayoutKt\n*L\n94#1:1545,6\n104#1:1551,6\n111#1:1562,6\n158#1:1600,6\n168#1:1606,6\n174#1:1617,6\n381#1:1655,6\n415#1:1661,6\n444#1:1667,6\n476#1:1673,6\n111#1:1557,5\n111#1:1568,6\n111#1:1583,4\n111#1:1593,2\n111#1:1598\n111#1:1599\n174#1:1612,5\n174#1:1623,6\n174#1:1638,4\n174#1:1648,2\n174#1:1653\n174#1:1654\n111#1:1574,9\n111#1:1595,3\n174#1:1629,9\n174#1:1650,3\n111#1:1587,6\n174#1:1642,6\n905#1:1679,6\n1175#1:1686\n1175#1:1687,2\n1176#1:1689\n1177#1:1690\n1178#1:1691\n1375#1:1699\n1376#1:1700\n1497#1:1702\n1498#1:1703\n1511#1:1704\n1512#1:1705\n1524#1:1706\n1525#1:1707\n1227#1:1692\n1228#1:1693\n1351#1:1694\n1371#1:1695,4\n1371#1:1701\n*E\n"})
public final class FlowLayoutKt {

    @NotNull
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START;

    @NotNull
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP;

    static {
        CrossAxisAlignment.Companion companion = CrossAxisAlignment.INSTANCE;
        Alignment.Companion companion2 = Alignment.INSTANCE;
        CROSS_AXIS_ALIGNMENT_TOP = companion.vertical$foundation_layout_release(companion2.getTop());
        CROSS_AXIS_ALIGNMENT_START = companion.horizontal$foundation_layout_release(companion2.getStart());
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0114  */
    @Composable
    @ExperimentalLayoutApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowColumn(@Nullable Modifier modifier, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, int i, int i2, @Nullable FlowColumnOverflow flowColumnOverflow, @NotNull final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i4, final int i5) {
        Modifier modifier2;
        int i6;
        Arrangement.Vertical vertical2;
        int i7;
        Arrangement.Horizontal start;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        FlowColumnOverflow clip;
        boolean z;
        Object objRememberedValue;
        boolean z2;
        Modifier modifier3;
        final FlowColumnOverflow flowColumnOverflow2;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal2;
        final int i13;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1704849416);
        int i14 = i5 & 1;
        if (i14 != 0) {
            i6 = i4 | 6;
            modifier2 = modifier;
        } else if ((i4 & 6) == 0) {
            modifier2 = modifier;
            i6 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i4;
        } else {
            modifier2 = modifier;
            i6 = i4;
        }
        int i15 = i5 & 2;
        if (i15 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                vertical2 = vertical;
                i6 |= composerStartRestartGroup.changed(vertical2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    start = horizontal;
                    i6 |= composerStartRestartGroup.changed(start) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        i9 = i;
                        i6 |= composerStartRestartGroup.changed(i9) ? 2048 : 1024;
                    }
                    i10 = i5 & 16;
                    if (i10 != 0) {
                        if ((i4 & 24576) == 0) {
                            i11 = i2;
                            i6 |= composerStartRestartGroup.changed(i11) ? 16384 : 8192;
                        }
                        i12 = i5 & 32;
                        if (i12 != 0) {
                            i6 |= 196608;
                        } else if ((i4 & 196608) == 0) {
                            i6 |= composerStartRestartGroup.changed(flowColumnOverflow) ? 131072 : 65536;
                        }
                        if ((i5 & 64) != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        if ((i6 & 599187) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            flowColumnOverflow2 = flowColumnOverflow;
                            modifier4 = modifier2;
                            vertical3 = vertical2;
                            horizontal2 = start;
                            i13 = i11;
                        } else {
                            Modifier modifier5 = i14 == 0 ? Modifier.INSTANCE : modifier2;
                            Arrangement.Vertical top = i15 == 0 ? Arrangement.INSTANCE.getTop() : vertical2;
                            if (i7 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if (i8 != 0) {
                                i9 = Integer.MAX_VALUE;
                            }
                            int i16 = i10 == 0 ? Integer.MAX_VALUE : i11;
                            clip = i12 == 0 ? FlowColumnOverflow.INSTANCE.getClip() : flowColumnOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1704849416, i6, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:156)");
                            }
                            int i17 = 458752 & i6;
                            z = i17 != 131072;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            Arrangement.Horizontal horizontal3 = start;
                            Arrangement.Vertical vertical4 = top;
                            MultiContentMeasurePolicy multiContentMeasurePolicyColumnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(vertical4, horizontal3, i9, i16, flowLayoutOverflowState, composerStartRestartGroup, (i6 >> 3) & 8190);
                            z2 = ((i6 & 3670016) != 1048576) | (i17 != 131072);
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                                Object obj = objRememberedValue2;
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(ComposableLambdaKt.composableLambdaInstance(985886665, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowColumn$list$1$1
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

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer2, int i18) {
                                            if ((i18 & 3) == 2 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(985886665, i18, -1, "androidx.compose.foundation.layout.FlowColumn.<anonymous>.<anonymous> (FlowLayout.kt:169)");
                                            }
                                            function3.invoke(FlowColumnScopeInstance.INSTANCE, composer2, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }));
                                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList);
                                    composerStartRestartGroup.updateRememberedValue(arrayList);
                                    obj = arrayList;
                                }
                                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts((List) obj);
                                boolean zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyColumnMeasurementMultiContentHelper);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                if (composerStartRestartGroup.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Function2 function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                                if (composerM18018constructorimpl.getInserting()) {
                                    modifier3 = modifier5;
                                } else {
                                    modifier3 = modifier5;
                                    if (!Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    }
                                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                    function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    flowColumnOverflow2 = clip;
                                    vertical3 = vertical4;
                                    horizontal2 = horizontal3;
                                    i13 = i16;
                                    modifier4 = modifier3;
                                }
                                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                                Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                flowColumnOverflow2 = clip;
                                vertical3 = vertical4;
                                horizontal2 = horizontal3;
                                i13 = i16;
                                modifier4 = modifier3;
                            }
                        }
                        final int i18 = i9;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.FlowColumn.1
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

                                public final void invoke(@Nullable Composer composer2, int i19) {
                                    FlowLayoutKt.FlowColumn(modifier4, vertical3, horizontal2, i18, i13, flowColumnOverflow2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i6 |= 24576;
                    i11 = i2;
                    i12 = i5 & 32;
                    if (i12 != 0) {
                    }
                    if ((i5 & 64) != 0) {
                    }
                    if ((i6 & 599187) == 599186) {
                        if (i14 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i172 = 458752 & i6;
                        if (i172 != 131072) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            FlowLayoutOverflowState flowLayoutOverflowState2 = (FlowLayoutOverflowState) objRememberedValue;
                            Arrangement.Horizontal horizontal32 = start;
                            Arrangement.Vertical vertical42 = top;
                            MultiContentMeasurePolicy multiContentMeasurePolicyColumnMeasurementMultiContentHelper2 = columnMeasurementMultiContentHelper(vertical42, horizontal32, i9, i16, flowLayoutOverflowState2, composerStartRestartGroup, (i6 >> 3) & 8190);
                            if (i172 != 131072) {
                            }
                            z2 = ((i6 & 3670016) != 1048576) | (i172 != 131072);
                            Object objRememberedValue22 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                            }
                        }
                    }
                    final int i182 = i9;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i9 = i;
                i10 = i5 & 16;
                if (i10 != 0) {
                }
                i11 = i2;
                i12 = i5 & 32;
                if (i12 != 0) {
                }
                if ((i5 & 64) != 0) {
                }
                if ((i6 & 599187) == 599186) {
                }
                final int i1822 = i9;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            start = horizontal;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            i9 = i;
            i10 = i5 & 16;
            if (i10 != 0) {
            }
            i11 = i2;
            i12 = i5 & 32;
            if (i12 != 0) {
            }
            if ((i5 & 64) != 0) {
            }
            if ((i6 & 599187) == 599186) {
            }
            final int i18222 = i9;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        vertical2 = vertical;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        start = horizontal;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        i9 = i;
        i10 = i5 & 16;
        if (i10 != 0) {
        }
        i11 = i2;
        i12 = i5 & 32;
        if (i12 != 0) {
        }
        if ((i5 & 64) != 0) {
        }
        if ((i6 & 599187) == 599186) {
        }
        final int i182222 = i9;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0114  */
    @Composable
    @ExperimentalLayoutApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowRow(@Nullable Modifier modifier, @Nullable Arrangement.Horizontal horizontal, @Nullable Arrangement.Vertical vertical, int i, int i2, @Nullable FlowRowOverflow flowRowOverflow, @NotNull final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i4, final int i5) {
        Modifier modifier2;
        int i6;
        Arrangement.Horizontal horizontal2;
        int i7;
        Arrangement.Vertical top;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        FlowRowOverflow clip;
        boolean z;
        Object objRememberedValue;
        boolean z2;
        Modifier modifier3;
        final FlowRowOverflow flowRowOverflow2;
        final Arrangement.Horizontal horizontal3;
        final Arrangement.Vertical vertical2;
        final int i13;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(437853230);
        int i14 = i5 & 1;
        if (i14 != 0) {
            i6 = i4 | 6;
            modifier2 = modifier;
        } else if ((i4 & 6) == 0) {
            modifier2 = modifier;
            i6 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i4;
        } else {
            modifier2 = modifier;
            i6 = i4;
        }
        int i15 = i5 & 2;
        if (i15 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                horizontal2 = horizontal;
                i6 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    top = vertical;
                    i6 |= composerStartRestartGroup.changed(top) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        i9 = i;
                        i6 |= composerStartRestartGroup.changed(i9) ? 2048 : 1024;
                    }
                    i10 = i5 & 16;
                    if (i10 != 0) {
                        if ((i4 & 24576) == 0) {
                            i11 = i2;
                            i6 |= composerStartRestartGroup.changed(i11) ? 16384 : 8192;
                        }
                        i12 = i5 & 32;
                        if (i12 != 0) {
                            i6 |= 196608;
                        } else if ((i4 & 196608) == 0) {
                            i6 |= composerStartRestartGroup.changed(flowRowOverflow) ? 131072 : 65536;
                        }
                        if ((i5 & 64) != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        if ((i6 & 599187) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            flowRowOverflow2 = flowRowOverflow;
                            modifier4 = modifier2;
                            horizontal3 = horizontal2;
                            vertical2 = top;
                            i13 = i11;
                        } else {
                            Modifier modifier5 = i14 == 0 ? Modifier.INSTANCE : modifier2;
                            Arrangement.Horizontal start = i15 == 0 ? Arrangement.INSTANCE.getStart() : horizontal2;
                            if (i7 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            }
                            if (i8 != 0) {
                                i9 = Integer.MAX_VALUE;
                            }
                            int i16 = i10 == 0 ? Integer.MAX_VALUE : i11;
                            clip = i12 == 0 ? FlowRowOverflow.INSTANCE.getClip() : flowRowOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(437853230, i6, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:92)");
                            }
                            int i17 = 458752 & i6;
                            z = i17 != 131072;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            Arrangement.Vertical vertical3 = top;
                            Arrangement.Horizontal horizontal4 = start;
                            MultiContentMeasurePolicy multiContentMeasurePolicyRowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(horizontal4, vertical3, i9, i16, flowLayoutOverflowState, composerStartRestartGroup, (i6 >> 3) & 8190);
                            z2 = ((i6 & 3670016) != 1048576) | (i17 != 131072);
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                                Object obj = objRememberedValue2;
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(ComposableLambdaKt.composableLambdaInstance(-139531073, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1
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

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer2, int i18) {
                                            if ((i18 & 3) == 2 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-139531073, i18, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:105)");
                                            }
                                            function3.invoke(FlowRowScopeInstance.INSTANCE, composer2, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }));
                                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList);
                                    composerStartRestartGroup.updateRememberedValue(arrayList);
                                    obj = arrayList;
                                }
                                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts((List) obj);
                                boolean zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicyRowMeasurementMultiContentHelper);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                if (composerStartRestartGroup.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Function2 function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                                if (composerM18018constructorimpl.getInserting()) {
                                    modifier3 = modifier5;
                                } else {
                                    modifier3 = modifier5;
                                    if (!Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    }
                                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                    function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    flowRowOverflow2 = clip;
                                    horizontal3 = horizontal4;
                                    vertical2 = vertical3;
                                    i13 = i16;
                                    modifier4 = modifier3;
                                }
                                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                                Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                flowRowOverflow2 = clip;
                                horizontal3 = horizontal4;
                                vertical2 = vertical3;
                                i13 = i16;
                                modifier4 = modifier3;
                            }
                        }
                        final int i18 = i9;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.FlowRow.1
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

                                public final void invoke(@Nullable Composer composer2, int i19) {
                                    FlowLayoutKt.FlowRow(modifier4, horizontal3, vertical2, i18, i13, flowRowOverflow2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i6 |= 24576;
                    i11 = i2;
                    i12 = i5 & 32;
                    if (i12 != 0) {
                    }
                    if ((i5 & 64) != 0) {
                    }
                    if ((i6 & 599187) == 599186) {
                        if (i14 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i172 = 458752 & i6;
                        if (i172 != 131072) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            FlowLayoutOverflowState flowLayoutOverflowState2 = (FlowLayoutOverflowState) objRememberedValue;
                            Arrangement.Vertical vertical32 = top;
                            Arrangement.Horizontal horizontal42 = start;
                            MultiContentMeasurePolicy multiContentMeasurePolicyRowMeasurementMultiContentHelper2 = rowMeasurementMultiContentHelper(horizontal42, vertical32, i9, i16, flowLayoutOverflowState2, composerStartRestartGroup, (i6 >> 3) & 8190);
                            if (i172 != 131072) {
                            }
                            z2 = ((i6 & 3670016) != 1048576) | (i172 != 131072);
                            Object objRememberedValue22 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                            }
                        }
                    }
                    final int i182 = i9;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i9 = i;
                i10 = i5 & 16;
                if (i10 != 0) {
                }
                i11 = i2;
                i12 = i5 & 32;
                if (i12 != 0) {
                }
                if ((i5 & 64) != 0) {
                }
                if ((i6 & 599187) == 599186) {
                }
                final int i1822 = i9;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            top = vertical;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            i9 = i;
            i10 = i5 & 16;
            if (i10 != 0) {
            }
            i11 = i2;
            i12 = i5 & 32;
            if (i12 != 0) {
            }
            if ((i5 & 64) != 0) {
            }
            if ((i6 & 599187) == 599186) {
            }
            final int i18222 = i9;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        horizontal2 = horizontal;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        top = vertical;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        i9 = i;
        i10 = i5 & 16;
        if (i10 != 0) {
        }
        i11 = i2;
        i12 = i5 & 32;
        if (i12 != 0) {
        }
        if ((i5 & 64) != 0) {
        }
        if ((i6 & 599187) == 599186) {
        }
        final int i182222 = i9;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* JADX INFO: renamed from: breakDownItems-di9J0FM, reason: not valid java name */
    public static final MeasureResult m15779breakDownItemsdi9J0FM(@NotNull MeasureScope measureScope, @NotNull FlowLineMeasurePolicy flowLineMeasurePolicy, @NotNull Iterator<? extends Measurable> it, float f, float f4, long j, int i, int i2, @NotNull FlowLayoutOverflowState flowLayoutOverflowState) {
        int i4;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        MutableIntObjectMap mutableIntObjectMap;
        ArrayList arrayList;
        int i5;
        int i6;
        MeasureScope measureScope2;
        FlowLineMeasurePolicy flowLineMeasurePolicy2;
        int[] iArr;
        int[] iArr2;
        long j2;
        int f1176$h;
        int f1177$w;
        int i7;
        MutableIntObjectMap mutableIntObjectMap2;
        ArrayList arrayList2;
        int i8;
        MutableIntList mutableIntList;
        MutableIntList mutableIntList2;
        int i9;
        int i10;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2;
        int i11;
        int i12;
        int iCoerceAtLeast;
        int iCoerceAtLeast2;
        MeasureScope measureScope3 = measureScope;
        FlowLineMeasurePolicy flowLineMeasurePolicy3 = flowLineMeasurePolicy;
        MutableVector mutableVector = new MutableVector(new MeasureResult[16], 0);
        int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j);
        int iM20923getMinWidthimpl = Constraints.m20923getMinWidthimpl(j);
        int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
        MutableIntObjectMap mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList3 = new ArrayList();
        int iCeil = (int) Math.ceil(measureScope3.mo15546toPx0680j_4(f));
        int iCeil2 = (int) Math.ceil(measureScope3.mo15546toPx0680j_4(f4));
        long jM15821constructorimpl = OrientationIndependentConstraints.m15821constructorimpl(0, iM20921getMaxWidthimpl, 0, iM20920getMaxHeightimpl);
        long jM15836toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m15836toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m15825copyyUG9Ft0$default(jM15821constructorimpl, 0, 0, 0, 0, 14, null), flowLineMeasurePolicy3.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FlowLineInfo flowLineInfo = it instanceof ContextualFlowItemIterator ? new FlowLineInfo(0, 0, measureScope3.mo15543toDpu2uoSUM(iM20921getMaxWidthimpl), measureScope3.mo15543toDpu2uoSUM(iM20920getMaxHeightimpl), null) : null;
        Measurable measurableSafeNext = !it.hasNext() ? null : safeNext(it, flowLineInfo);
        IntIntPair intIntPairM15197boximpl = measurableSafeNext != null ? IntIntPair.m15197boximpl(m15780measureAndCacherqJ1uqs(measurableSafeNext, flowLineMeasurePolicy3, jM15836toBoxConstraintsOenEA2s, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                invoke2(placeable);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Placeable placeable) {
                objectRef.element = placeable;
            }
        })) : null;
        Integer numValueOf = intIntPairM15197boximpl != null ? Integer.valueOf(IntIntPair.m15204getFirstimpl(intIntPairM15197boximpl.getPackedValue())) : null;
        Integer numValueOf2 = intIntPairM15197boximpl != null ? Integer.valueOf(IntIntPair.m15205getSecondimpl(intIntPairM15197boximpl.getPackedValue())) : null;
        Integer num = numValueOf;
        Measurable measurable = measurableSafeNext;
        MutableIntList mutableIntList3 = new MutableIntList(0, 1, null);
        MutableIntList mutableIntList4 = new MutableIntList(0, 1, null);
        FlowLineInfo flowLineInfo2 = flowLineInfo;
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i, flowLayoutOverflowState, j, i2, iCeil, iCeil2, null);
        FlowLayoutBuildingBlocks.WrapInfo wrapInfoM15777getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m15777getWrapInfoOpUlnko(it.hasNext(), 0, IntIntPair.m15200constructorimpl(iM20921getMaxWidthimpl, iM20920getMaxHeightimpl), intIntPairM15197boximpl, 0, 0, 0, false, false);
        if (wrapInfoM15777getWrapInfoOpUlnko.getIsLastItemInContainer()) {
            wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM15777getWrapInfoOpUlnko, intIntPairM15197boximpl != null, -1, 0, iM20921getMaxWidthimpl, 0);
            i4 = iM20921getMaxWidthimpl;
        } else {
            i4 = iM20921getMaxWidthimpl;
            wrapEllipsisInfo = null;
        }
        Integer numValueOf3 = num;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo3 = wrapEllipsisInfo;
        int i13 = iCeil;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo = wrapInfoM15777getWrapInfoOpUlnko;
        int i14 = 0;
        int i15 = iM20923getMinWidthimpl;
        Measurable measurableSafeNext2 = measurable;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        MutableIntList mutableIntList5 = mutableIntList3;
        int i20 = iM20920getMaxHeightimpl;
        int i21 = i4;
        int i22 = 0;
        while (!wrapInfo.getIsLastItemInContainer() && measurableSafeNext2 != null) {
            Intrinsics.checkNotNull(numValueOf3);
            int iIntValue = numValueOf3.intValue();
            Intrinsics.checkNotNull(numValueOf2);
            MutableIntList mutableIntList6 = mutableIntList4;
            int i23 = i4;
            int i24 = i18 + iIntValue;
            int iMax = Math.max(i22, numValueOf2.intValue());
            int i25 = i21 - iIntValue;
            int i26 = i16 + 1;
            int i27 = i15;
            flowLayoutOverflowState.setItemShown$foundation_layout_release(i26);
            arrayList3.add(measurableSafeNext2);
            mutableIntObjectMapMutableIntObjectMapOf.set(i16, objectRef.element);
            int i28 = i26 - i17;
            boolean z = i28 < i;
            if (flowLineInfo2 != null) {
                if (z) {
                    i7 = i28;
                    i11 = i14;
                } else {
                    i7 = i28;
                    i11 = i14 + 1;
                }
                int i29 = z ? i7 : 0;
                if (z) {
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i12 = 0;
                    iCoerceAtLeast = RangesKt.coerceAtLeast(i25 - i13, 0);
                } else {
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i12 = 0;
                    iCoerceAtLeast = i23;
                }
                float fMo15543toDpu2uoSUM = measureScope3.mo15543toDpu2uoSUM(iCoerceAtLeast);
                if (z) {
                    arrayList2 = arrayList3;
                    iCoerceAtLeast2 = i20;
                } else {
                    arrayList2 = arrayList3;
                    iCoerceAtLeast2 = RangesKt.coerceAtLeast((i20 - iMax) - iCeil2, i12);
                }
                flowLineInfo2.m15790update4j6BHR0$foundation_layout_release(i11, i29, fMo15543toDpu2uoSUM, measureScope3.mo15543toDpu2uoSUM(iCoerceAtLeast2));
            } else {
                i7 = i28;
                mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                arrayList2 = arrayList3;
            }
            measurableSafeNext2 = !it.hasNext() ? null : safeNext(it, flowLineInfo2);
            IntIntPair intIntPairM15197boximpl2 = null;
            objectRef.element = null;
            IntIntPair intIntPairM15197boximpl3 = measurableSafeNext2 != null ? IntIntPair.m15197boximpl(m15780measureAndCacherqJ1uqs(measurableSafeNext2, flowLineMeasurePolicy3, jM15836toBoxConstraintsOenEA2s, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                    invoke2(placeable);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Placeable placeable) {
                    objectRef.element = placeable;
                }
            })) : null;
            Integer numValueOf4 = intIntPairM15197boximpl3 != null ? Integer.valueOf(IntIntPair.m15204getFirstimpl(intIntPairM15197boximpl3.getPackedValue()) + i13) : null;
            numValueOf2 = intIntPairM15197boximpl3 != null ? Integer.valueOf(IntIntPair.m15205getSecondimpl(intIntPairM15197boximpl3.getPackedValue())) : null;
            boolean zHasNext = it.hasNext();
            int i30 = i14;
            long jM15200constructorimpl = IntIntPair.m15200constructorimpl(i25, i20);
            if (intIntPairM15197boximpl3 != null) {
                Intrinsics.checkNotNull(numValueOf4);
                int iIntValue2 = numValueOf4.intValue();
                Intrinsics.checkNotNull(numValueOf2);
                intIntPairM15197boximpl2 = IntIntPair.m15197boximpl(IntIntPair.m15200constructorimpl(iIntValue2, numValueOf2.intValue()));
            }
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM15777getWrapInfoOpUlnko2 = flowLayoutBuildingBlocks.m15777getWrapInfoOpUlnko(zHasNext, i7, jM15200constructorimpl, intIntPairM15197boximpl2, i30, i19, iMax, false, false);
            if (wrapInfoM15777getWrapInfoOpUlnko2.getIsLastItemInLine()) {
                int iMin = Math.min(Math.max(i27, i24), i23);
                int i31 = i19 + iMax;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo4 = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM15777getWrapInfoOpUlnko2, intIntPairM15197boximpl3 != null, i30, i31, i25, i7);
                mutableIntList = mutableIntList6;
                mutableIntList.add(iMax);
                i10 = (iM20920getMaxHeightimpl - i31) - iCeil2;
                MutableIntList mutableIntList7 = mutableIntList5;
                mutableIntList7.add(i26);
                i14 = i30 + 1;
                numValueOf3 = numValueOf4 != null ? Integer.valueOf(numValueOf4.intValue() - i13) : null;
                i21 = i23;
                i23 = i21;
                i17 = i26;
                i19 = i31 + iCeil2;
                i9 = 0;
                i8 = iMin;
                wrapEllipsisInfo2 = wrapEllipsisInfo4;
                mutableIntList2 = mutableIntList7;
                i24 = 0;
            } else {
                i8 = i27;
                mutableIntList = mutableIntList6;
                mutableIntList2 = mutableIntList5;
                numValueOf3 = numValueOf4;
                i9 = iMax;
                i21 = i25;
                i14 = i30;
                i10 = i20;
                wrapEllipsisInfo2 = wrapEllipsisInfo3;
            }
            wrapEllipsisInfo3 = wrapEllipsisInfo2;
            mutableIntList5 = mutableIntList2;
            i22 = i9;
            i20 = i10;
            i15 = i8;
            i16 = i26;
            arrayList3 = arrayList2;
            wrapInfo = wrapInfoM15777getWrapInfoOpUlnko2;
            mutableIntList4 = mutableIntList;
            mutableIntObjectMapMutableIntObjectMapOf = mutableIntObjectMap2;
            i18 = i24;
            i4 = i23;
        }
        MutableIntObjectMap mutableIntObjectMap3 = mutableIntObjectMapMutableIntObjectMapOf;
        ArrayList arrayList4 = arrayList3;
        int iMax2 = i15;
        MutableIntList mutableIntList8 = mutableIntList4;
        MutableIntList mutableIntList9 = mutableIntList5;
        if (wrapEllipsisInfo3 != null) {
            arrayList = arrayList4;
            arrayList.add(wrapEllipsisInfo3.getEllipsis());
            mutableIntObjectMap = mutableIntObjectMap3;
            mutableIntObjectMap.set(arrayList.size() - 1, wrapEllipsisInfo3.getPlaceable());
            int i32 = mutableIntList9._size - 1;
            if (wrapEllipsisInfo3.getPlaceEllipsisOnLastContentLine()) {
                int size = mutableIntList9.getSize() - 1;
                mutableIntList8.set(i32, Math.max(mutableIntList8.get(i32), IntIntPair.m15205getSecondimpl(wrapEllipsisInfo3.getEllipsisSize())));
                mutableIntList9.set(size, mutableIntList9.last() + 1);
            } else {
                mutableIntList8.add(IntIntPair.m15205getSecondimpl(wrapEllipsisInfo3.getEllipsisSize()));
                mutableIntList9.add(mutableIntList9.last() + 1);
            }
        } else {
            mutableIntObjectMap = mutableIntObjectMap3;
            arrayList = arrayList4;
        }
        int size2 = arrayList.size();
        Placeable[] placeableArr = new Placeable[size2];
        for (int i33 = 0; i33 < size2; i33++) {
            placeableArr[i33] = mutableIntObjectMap.get(i33);
        }
        int size3 = mutableIntList9.getSize();
        int[] iArr3 = new int[size3];
        for (int i34 = 0; i34 < size3; i34++) {
            iArr3[i34] = 0;
        }
        int size4 = mutableIntList9.getSize();
        int[] iArr4 = new int[size4];
        for (int i35 = 0; i35 < size4; i35++) {
            iArr4[i35] = 0;
        }
        int[] iArr5 = mutableIntList9.content;
        int i36 = mutableIntList9._size;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        while (i38 < i36) {
            int i40 = iArr5[i38];
            MutableIntList mutableIntList10 = mutableIntList8;
            int i41 = iMax2;
            int i42 = i37;
            FlowLineMeasurePolicy flowLineMeasurePolicy4 = flowLineMeasurePolicy3;
            ArrayList arrayList5 = arrayList;
            int i43 = i13;
            MeasureResult measureResultMeasure = RowColumnMeasurePolicyKt.measure(flowLineMeasurePolicy4, i41, Constraints.m20922getMinHeightimpl(jM15821constructorimpl), Constraints.m20921getMaxWidthimpl(jM15821constructorimpl), mutableIntList10.get(i38), i43, measureScope3, arrayList5, placeableArr, i42, i40, iArr3, i38);
            if (flowLineMeasurePolicy.isHorizontal()) {
                f1176$h = measureResultMeasure.getWidth();
                f1177$w = measureResultMeasure.getHeight();
            } else {
                f1176$h = measureResultMeasure.getHeight();
                f1177$w = measureResultMeasure.getWidth();
            }
            iArr4[i38] = f1177$w;
            i39 += f1177$w;
            iMax2 = Math.max(i41, f1176$h);
            mutableVector.add(measureResultMeasure);
            i38++;
            arrayList = arrayList5;
            i37 = i40;
            mutableIntList8 = mutableIntList10;
            i13 = i43;
            measureScope3 = measureScope;
            flowLineMeasurePolicy3 = flowLineMeasurePolicy;
        }
        int i44 = iMax2;
        if (mutableVector.isEmpty()) {
            i5 = 0;
            i6 = 0;
            measureScope2 = measureScope;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            j2 = j;
            iArr = iArr3;
            iArr2 = iArr4;
        } else {
            i5 = i44;
            i6 = i39;
            measureScope2 = measureScope;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            iArr = iArr3;
            iArr2 = iArr4;
            j2 = j;
        }
        return m15781placeHelperBmaY500(measureScope2, j2, i5, i6, iArr2, mutableVector, flowLineMeasurePolicy2, iArr);
    }

    @Composable
    @PublishedApi
    @NotNull
    public static final MeasurePolicy columnMeasurementHelper(@NotNull Arrangement.Vertical vertical, @NotNull Arrangement.Horizontal horizontal, int i, @Nullable Composer composer, int i2) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i2, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:442)");
        }
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout_release(), null);
            objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$columnMeasurementHelper$1$1
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                    return flowMeasurePolicy.mo15802measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return measurePolicy;
    }

    @Composable
    @NotNull
    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(@NotNull Arrangement.Vertical vertical, @NotNull Arrangement.Horizontal horizontal, int i, int i2, @NotNull FlowLayoutOverflowState flowLayoutOverflowState, @Nullable Composer composer, int i4) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(748776953, i4, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:474)");
        }
        boolean zChanged = ((((i4 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) > 256 && composer.changed(i)) || (i4 & 384) == 256) | ((((i4 & 7168) ^ 3072) > 2048 && composer.changed(i2)) || (i4 & 3072) == 2048) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return flowMeasurePolicy2;
    }

    public static final int crossAxisMin(@NotNull IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        return z ? intrinsicMeasurable.minIntrinsicHeight(i) : intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @NotNull
    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return CROSS_AXIS_ALIGNMENT_START;
    }

    @NotNull
    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return CROSS_AXIS_ALIGNMENT_TOP;
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, final int[] iArr, final int[] iArr2, int i, int i2, int i4, int i5, int i6, FlowLayoutOverflowState flowLayoutOverflowState) {
        return intrinsicCrossAxisSize(list, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.intrinsicCrossAxisSize.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(iArr[i7]);
            }
        }, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.intrinsicCrossAxisSize.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(iArr2[i7]);
            }
        }, i, i2, i4, i5, i6, flowLayoutOverflowState);
    }

    public static final int mainAxisMin(@NotNull IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        return z ? intrinsicMeasurable.minIntrinsicWidth(i) : intrinsicMeasurable.minIntrinsicHeight(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i, int i2, int i4) {
        int size = list.size();
        int i5 = 0;
        int iMax = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < size) {
            int iIntValue = function3.invoke(list.get(i5), Integer.valueOf(i5), Integer.valueOf(i)).intValue() + i2;
            int i8 = i5 + 1;
            if (i8 - i6 == i4 || i8 == list.size()) {
                iMax = Math.max(iMax, (i7 + iIntValue) - i2);
                i7 = 0;
                i6 = i5;
            } else {
                i7 += iIntValue;
            }
            i5 = i8;
        }
        return iMax;
    }

    /* JADX INFO: renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final long m15780measureAndCacherqJ1uqs(@NotNull Measurable measurable, @NotNull FlowLineMeasurePolicy flowLineMeasurePolicy, long j, @NotNull Function1<? super Placeable, Unit> function1) {
        FlowLayoutData flowLayoutData;
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable)) == 0.0f) {
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) == null) {
                Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
                function1.invoke(placeableMo19855measureBRTryo0);
                return IntIntPair.m15200constructorimpl(flowLineMeasurePolicy.mainAxisSize(placeableMo19855measureBRTryo0), flowLineMeasurePolicy.crossAxisSize(placeableMo19855measureBRTryo0));
            }
        }
        int iMainAxisMin = mainAxisMin(measurable, flowLineMeasurePolicy.isHorizontal(), Integer.MAX_VALUE);
        return IntIntPair.m15200constructorimpl(iMainAxisMin, crossAxisMin(measurable, flowLineMeasurePolicy.isHorizontal(), iMainAxisMin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i4, int i5, int i6, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i7 = i5;
        int i8 = i6;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i9 = 0; i9 < size; i9++) {
            iArr[i9] = 0;
        }
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        for (int i10 = 0; i10 < size2; i10++) {
            iArr2[i10] = 0;
        }
        int size3 = list.size();
        for (int i11 = 0; i11 < size3; i11++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i11);
            int iIntValue = function3.invoke(intrinsicMeasurable, Integer.valueOf(i11), Integer.valueOf(i)).intValue();
            iArr[i11] = iIntValue;
            iArr2[i11] = function32.invoke(intrinsicMeasurable, Integer.valueOf(i11), Integer.valueOf(iIntValue)).intValue();
        }
        List<? extends IntrinsicMeasurable> list2 = list;
        int i12 = Integer.MAX_VALUE;
        if (i8 != Integer.MAX_VALUE && i7 != Integer.MAX_VALUE) {
            i12 = i7 * i8;
        }
        int iMin = Math.min(i12 - (((i12 >= list2.size() || !(flowLayoutOverflowState.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandIndicator || flowLayoutOverflowState.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) && (i12 < list2.size() || i8 < flowLayoutOverflowState.getMinLinesToShowCollapse$foundation_layout_release() || flowLayoutOverflowState.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) ? 0 : 1), list2.size());
        int size4 = ((list2.size() - 1) * i2) + ArraysKt.sum(iArr);
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int i13 = iArr2[0];
        ?? it = new IntRange(1, ArraysKt.getLastIndex(iArr2)).iterator();
        while (it.hasNext()) {
            int i14 = iArr2[it.nextInt()];
            if (i13 < i14) {
                i13 = i14;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i15 = iArr[0];
        ?? it2 = new IntRange(1, ArraysKt.getLastIndex(iArr)).iterator();
        while (it2.hasNext()) {
            int i16 = iArr[it2.nextInt()];
            if (i15 < i16) {
                i15 = i16;
            }
        }
        int i17 = i15;
        int i18 = size4;
        while (i17 <= i18 && i13 != i) {
            int i19 = (i17 + i18) / 2;
            long jIntrinsicCrossAxisSize = intrinsicCrossAxisSize(list2, iArr, iArr2, i19, i2, i4, i7, i8, flowLayoutOverflowState);
            int iM15204getFirstimpl = IntIntPair.m15204getFirstimpl(jIntrinsicCrossAxisSize);
            int iM15205getSecondimpl = IntIntPair.m15205getSecondimpl(jIntrinsicCrossAxisSize);
            if (iM15204getFirstimpl > i || iM15205getSecondimpl < iMin) {
                i17 = i19 + 1;
                if (i17 > i18) {
                    return i17;
                }
            } else {
                if (iM15204getFirstimpl >= i) {
                    return i19;
                }
                i18 = i19 - 1;
            }
            list2 = list;
            i7 = i5;
            i8 = i6;
            size4 = i19;
            i13 = iM15204getFirstimpl;
        }
        return size4;
    }

    @NotNull
    /* JADX INFO: renamed from: placeHelper-BmaY500, reason: not valid java name */
    public static final MeasureResult m15781placeHelperBmaY500(@NotNull MeasureScope measureScope, long j, int i, int i2, @NotNull int[] iArr, @NotNull final MutableVector<MeasureResult> mutableVector, @NotNull FlowLineMeasurePolicy flowLineMeasurePolicy, @NotNull int[] iArr2) {
        int iCoerceIn;
        int i4;
        int i5;
        boolean zIsHorizontal = flowLineMeasurePolicy.isHorizontal();
        Arrangement.Vertical verticalArrangement = flowLineMeasurePolicy.getVerticalArrangement();
        Arrangement.Horizontal horizontalArrangement = flowLineMeasurePolicy.getHorizontalArrangement();
        if (zIsHorizontal) {
            if (verticalArrangement == null) {
                throw new IllegalArgumentException("null verticalArrangement");
            }
            iCoerceIn = RangesKt.coerceIn(((mutableVector.getSize() - 1) * measureScope.mo15540roundToPx0680j_4(verticalArrangement.getSpacing())) + i2, Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j));
            verticalArrangement.arrange(measureScope, iCoerceIn, iArr, iArr2);
        } else {
            if (horizontalArrangement == null) {
                throw new IllegalArgumentException("null horizontalArrangement");
            }
            int iCoerceIn2 = RangesKt.coerceIn(((mutableVector.getSize() - 1) * measureScope.mo15540roundToPx0680j_4(horizontalArrangement.getSpacing())) + i2, Constraints.m20922getMinHeightimpl(j), Constraints.m20920getMaxHeightimpl(j));
            horizontalArrangement.arrange(measureScope, iCoerceIn2, iArr, measureScope.getLayoutDirection(), iArr2);
            iCoerceIn = iCoerceIn2;
        }
        int iCoerceIn3 = RangesKt.coerceIn(i, Constraints.m20923getMinWidthimpl(j), Constraints.m20921getMaxWidthimpl(j));
        if (zIsHorizontal) {
            i5 = iCoerceIn3;
            i4 = iCoerceIn;
        } else {
            i4 = iCoerceIn3;
            i5 = iCoerceIn;
        }
        return MeasureScope.layout$default(measureScope, i5, i4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$placeHelper$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                MutableVector<MeasureResult> mutableVector2 = mutableVector;
                int size = mutableVector2.getSize();
                if (size > 0) {
                    MeasureResult[] content = mutableVector2.getContent();
                    int i6 = 0;
                    do {
                        content[i6].placeChildren();
                        i6++;
                    } while (i6 < size);
                }
            }
        }, 4, null);
    }

    @Composable
    @PublishedApi
    @NotNull
    public static final MeasurePolicy rowMeasurementHelper(@NotNull Arrangement.Horizontal horizontal, @NotNull Arrangement.Vertical vertical, int i, @Nullable Composer composer, int i2) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i2, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:379)");
        }
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout_release(), null);
            objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$rowMeasurementHelper$1$1
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                    return flowMeasurePolicy.mo15802measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return measurePolicy;
    }

    @Composable
    @NotNull
    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(@NotNull Arrangement.Horizontal horizontal, @NotNull Arrangement.Vertical vertical, int i, int i2, @NotNull FlowLayoutOverflowState flowLayoutOverflowState, @Nullable Composer composer, int i4) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2134502475, i4, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:413)");
        }
        boolean zChanged = ((((i4 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) > 256 && composer.changed(i)) || (i4 & 384) == 256) | ((((i4 & 7168) ^ 3072) > 2048 && composer.changed(i2)) || (i4 & 3072) == 2048) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return flowMeasurePolicy2;
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> it, FlowLineInfo flowLineInfo) {
        try {
            if (!(it instanceof ContextualFlowItemIterator)) {
                return it.next();
            }
            Intrinsics.checkNotNull(flowLineInfo);
            return ((ContextualFlowItemIterator) it).getNext$foundation_layout_release(flowLineInfo);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i4, int i5, int i6, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i7;
        if (list.isEmpty()) {
            return IntIntPair.m15200constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i5, flowLayoutOverflowState, OrientationIndependentConstraints.m15821constructorimpl(0, i, 0, Integer.MAX_VALUE), i6, i2, i4, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int iIntValue = intrinsicMeasurable != null ? function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(i)).intValue() : 0;
        int iIntValue2 = intrinsicMeasurable != null ? function3.invoke(intrinsicMeasurable, 0, Integer.valueOf(iIntValue)).intValue() : 0;
        int i8 = 0;
        int iMax = 0;
        if (flowLayoutBuildingBlocks.m15777getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m15200constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m15197boximpl(IntIntPair.m15200constructorimpl(iIntValue2, iIntValue)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair intIntPairM15782ellipsisSizeF35zmw$foundation_layout_release = flowLayoutOverflowState.m15782ellipsisSizeF35zmw$foundation_layout_release(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m15200constructorimpl(intIntPairM15782ellipsisSizeF35zmw$foundation_layout_release != null ? IntIntPair.m15205getSecondimpl(intIntPairM15782ellipsisSizeF35zmw$foundation_layout_release.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i9 = i;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = iMax;
            if (i10 >= size) {
                i7 = i11;
                break;
            }
            int i15 = i9 - iIntValue2;
            int i16 = i10 + 1;
            iMax = Math.max(i14, iIntValue);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i16);
            int iIntValue3 = intrinsicMeasurable2 != null ? function32.invoke(intrinsicMeasurable2, Integer.valueOf(i16), Integer.valueOf(i)).intValue() : 0;
            int iIntValue4 = intrinsicMeasurable2 != null ? function3.invoke(intrinsicMeasurable2, Integer.valueOf(i16), Integer.valueOf(iIntValue3)).intValue() + i2 : 0;
            int i17 = i16 - i12;
            i7 = i16;
            int i18 = i13;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM15777getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m15777getWrapInfoOpUlnko(i10 + 2 < list.size(), i17, IntIntPair.m15200constructorimpl(i15, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m15197boximpl(IntIntPair.m15200constructorimpl(iIntValue4, iIntValue3)), i18, i8, iMax, false, false);
            if (wrapInfoM15777getWrapInfoOpUlnko.getIsLastItemInLine()) {
                int iM15205getSecondimpl = iMax + i4 + i8;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM15777getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i18, iM15205getSecondimpl, i15, i17);
                iIntValue4 -= i2;
                i13 = i18 + 1;
                if (wrapInfoM15777getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            iM15205getSecondimpl = IntIntPair.m15205getSecondimpl(ellipsisSize) + i4 + iM15205getSecondimpl;
                        }
                    }
                    i8 = iM15205getSecondimpl;
                } else {
                    i9 = i;
                    i12 = i7;
                    i8 = iM15205getSecondimpl;
                    iMax = 0;
                }
            } else {
                i9 = i15;
                i13 = i18;
            }
            iIntValue2 = iIntValue4;
            iIntValue = iIntValue3;
            i10 = i7;
            i11 = i10;
        }
        return IntIntPair.m15200constructorimpl(i8 - i4, i7);
    }
}
